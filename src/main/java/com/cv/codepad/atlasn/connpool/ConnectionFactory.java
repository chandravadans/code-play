package com.cv.codepad.atlasn.connpool;

import com.mysql.cj.jdbc.ConnectionWrapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConnectionFactory {
    private String userName, password;

    public static Connection createConnection(String user, String password) {
        return null;
    }

    public static void main(String[] args) {
        /*ConnectionPool pool = new ConnectionPool.ConnectionPoolBuilder("", "")
        .withMaxPoolSize(10)
        .withExpiry(2000L)
        .build();*/
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            iterator.remove();
            System.out.println("Removed " + key);
        }
        System.out.println("Removed!");

    }
}
