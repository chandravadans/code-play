package com.cv.codepad.misc;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by cv on 4/6/17.
 */
public class MinHeap {
    private int capacity;
    private int size;
    private int array[];

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        array = new int[capacity];
    }


    public static void main(String[] args) {
        int arr [] = {2,3,1,4,8,6};
        /*ArrayBlockingQueue<Integer> sorted = new ArrayBlockingQueue<>(6);
        for(int x : arr) {
            new Thread(() -> {
                try {
                    Thread.sleep(x);
                    sorted.add(x);
                    //System.out.println(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println(sorted.size());
        while(!sorted.isEmpty()) {
            System.out.println(sorted.poll());
        }*/

        String x = "abcde";
        for(Character c : x.toCharArray()) {
            System.out.println(Character.getNumericValue(c));
        }

        /*PriorityQueue<Integer> minHeap = new PriorityQueue<>(5, (i,j) -> 0 - i.compareTo(j));
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(5);
        minHeap.add(15);
        minHeap.add(22);

        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }*/
    }



}
