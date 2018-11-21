package com.cv.codepad.atlasn.connpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionPool {

    private static final Object mutex = new Object();

    private Map<Connection, Long> busy, free;
    private int numConnections;
    private long expiryTimeMs;
    private String user, pass;

    ConnectionPool(String user, String pass) {
        this.user = user;
        this.pass = pass;
        busy = new ConcurrentHashMap<>();
        free = new ConcurrentHashMap<>();
    }

    private Connection createConnection() {
        // Use username and password to create a connection, or maybe a Factory?
        return null;
    }

    private void expireConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean validateConnection(Connection connection) {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection acquireConnection() {
        Connection result;
        long now = System.currentTimeMillis();

        // Iterate over all connections in the free set
        Iterator<Connection> it = free.keySet().iterator();
        while (it.hasNext()) {
            result = it.next();
            // Check expiry of object
            if (now - free.get(result) > expiryTimeMs) {
                it.remove();
                expireConnection(result);
            } else {
                // Validate the connection
                if (validateConnection(result)) {
                    // If validation was successful, add it to the busy list
                    it.remove();
                    busy.put(result, now);
                    return result;
                } else {
                    // Connection failed validation, so remove it and make sure not to allocate it again
                    expireConnection(result);
                    it.remove();
                }
            }
        }

        // No connection allocated, so make a new one and return it
        result = createConnection();
        busy.put(result, System.currentTimeMillis());
        return result;

    }

    public Connection releaseConnection(Connection connection) {
        busy.remove(connection);
        free.put(connection, System.currentTimeMillis());
        return null;
    }

    public static class ConnectionPoolBuilder {
        private ConnectionPool instance;

        public ConnectionPoolBuilder(String user, String password) {
            instance = new ConnectionPool(user, password);
        }

        public ConnectionPoolBuilder withExpiry(long expiryTimeMs) {
            this.instance.expiryTimeMs = expiryTimeMs;
            return this;
        }

        public ConnectionPoolBuilder withMaxPoolSize(int poolSize) {
            this.instance.numConnections = poolSize;
            return this;
        }

        public ConnectionPool build() {
            return instance;
        }
    }

}
