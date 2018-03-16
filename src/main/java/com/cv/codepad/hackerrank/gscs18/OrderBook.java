package com.cv.codepad.hackerrank.gscs18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class OrderBook {

    class Order {
        private Long orderId;
        private Long timestamp;
        private String symbol;
        private String orderType;
        private String side;
        private Double price;
        private Long quantity;
        private boolean closed;

        public Order(String orderId,
                     String timestamp,
                     String symbol,
                     String orderType,
                     String side,
                     String price,
                     String quantity) throws Exception {
            try {
                this.orderId = Long.parseLong(orderId);
                this.timestamp = Long.parseLong(timestamp);
                this.symbol = symbol;
                this.orderType = orderType;
                this.side = side;
                this.price = Double.parseDouble(price);
                this.quantity = Long.parseLong(quantity);
                this.closed = false;
            } catch (Exception e) {
                throw new Exception("303 - Invalid Order Details");
            }
        }
    }

    class MatchingEngine {

        // Orders arranged by lowest prices
        private PriorityQueue<Order> buyBook;

        // Orders arranged by highest prices
        private PriorityQueue<Order> sellBook;

        // All orders
        private Map<Long, Order> orders;

        // Should be matched in the next match cycle or will be cancelled
        List<String> iocOrders;

        public MatchingEngine() {

            // minheap to get lowest priced order
            buyBook = new PriorityQueue<>((order1, order2) -> {
                if (!order1.price.equals(order2.price)) {
                    return order1.price.compareTo(order2.price);
                } else {
                    return order1.timestamp.compareTo(order2.timestamp);
                }
            });

            // maxheap to get max priced order
            sellBook = new PriorityQueue<>((order1, order2) -> {
                if (!order1.price.equals(order2.price)) {
                    return order2.price.compareTo(order1.price);
                } else {
                    return order2.timestamp.compareTo(order1.timestamp);
                }
            });

            orders = new HashMap<>();
            iocOrders = new ArrayList<>();
        }

        public String add(Order order) {
            String result = "";
            return result;
        }

        public void match(Order order) {

        }

        public String handle(String op) {
            String result = null;
            String pieces[] = op.split(",");

            return null;
        }

        public String process(Order order) {
            switch (order.orderType) {
                case "M":
                    break;
                case "L":
                    break;
                case "I":
                    break;
                default:
                    throw new IllegalArgumentException("Invalid order type");
            }
            return order.orderId + "";
        }
    }

    public String[] solve(String[] queries) {
        MatchingEngine engine = new MatchingEngine();
        List<String> ops = Arrays.asList(queries);
        List<String> results = new ArrayList<>();
        ops.stream().forEach(op -> results.add(engine.handle(op)));
        List<String> strings = new ArrayList<>();
        strings.stream().filter(x -> x.equals("hello")).collect(Collectors.toList());
        Collections.sort(strings, Comparator.reverseOrder());
        Scanner in = new Scanner(System.in);
        in.next();
        return results.toArray(new String[results.size()]);
    }


    /*
     * Complete the function below.
     */
    static String[] processQueries(String[] queries) {
        OrderBook orderBook = new OrderBook();
        return orderBook.solve(queries);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int queriesSize = Integer.parseInt(scan.nextLine().trim());

        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int responseItr = 0; responseItr < response.length; responseItr++) {
            bw.write(response[responseItr]);

            if (responseItr != response.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }


}
