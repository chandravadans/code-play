package com.cv.codepad.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cv on 4/27/17.
 */
public class LRUCache {
    class Node {
        public int data;
        public Node(int data) {
            this.data = data;
        }
    }
    private HashMap<Integer, Node> pageMap;
    private Queue<Integer> accessTimes;
    final int cacheSize;

    public LRUCache(int size) {
        this.pageMap = new HashMap<>();
        this.accessTimes = new LinkedList<>();
        this.cacheSize = size;
    }

    public Node accessPage(int pageNumber) {

        return null;
    }

}
