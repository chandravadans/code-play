package com.cv.codepad.misc;

import java.util.*;

/**
 * Created by cv on 4/2/17.
 */
public class DataStructures {
    public static void main(String[] args) {
        DataStructures ds = new DataStructures();
        ds.demoHeaps();
        /*Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int matr[][] = new int [r][c];
        for(int i=0; i < r; i++) {
            for(int j=0; j < c; j++) {
                matr[i][j] = in.nextInt();
            }
        }
        int opr = in.nextInt();
        int numdups = in.nextInt();
        System.out.println(countColDuplicates(matr,numdups));*/

    }

    static int countColDuplicates(int data[][], int numDups) {
        int rows = data.length;
        int cols = data[0].length;
        int result = 0;
        int rowDuplicatesCount[] = new int[rows];
        for(int col = 0; col < cols; col++) {
            Set<Integer> set = new HashSet<>();
            Map<Integer, List<Integer>> occurrences = new HashMap<>();
            for(int row = 0; row < rows; row++) {
                if(!set.contains(data[row][col])) {
                    set.add(data[row][col]);
                    List<Integer> occ = new ArrayList<>();
                    occ.add(row);
                    occurrences.put(data[row][col],occ);
                } else {
                    //rowDuplicatesCount[row] ++; //Need to record that a row has a duplicated element
                    List<Integer> occ = occurrences.get(data[row][col]);
                    occ.add(row);
                    occurrences.put(data[row][col],occ);
                }

            }
            for(Map.Entry<Integer, List<Integer>> entry : occurrences.entrySet()) {
                if(entry.getValue().size() > 1) {
                    for(int i : entry.getValue()) {
                        rowDuplicatesCount[i] ++;
                    }
                }
            }
            /*if(occurrences.size() > 1) {
                for(int occurrence : occurrences) {
                    rowDuplicatesCount[occurrence] ++;
                }
            }*/
        }
        for(int dup : rowDuplicatesCount) {
            System.out.print(dup +" ");
            if (dup >= numDups) {
                result ++;
            }
        }
        System.out.println();
        return result;
    }

    void demoQueues() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Poll removes the head");
        System.out.println(queue.poll());
        System.out.println("Size = "+ queue.size());

        System.out.println("Peek gives top element");
        System.out.println(queue.peek());
        System.out.println("Size = "+ queue.size());
    }

    void demoHeaps() {
        Integer x = 1_000_000_007;
        Queue<Integer> heap = new PriorityQueue<>((i1,i2) -> {
            return (0 - i1.compareTo(i2));
        });
        heap.offer(10);
        heap.offer(5);
        heap.offer(20);
        heap.offer(4);
        heap.offer(4);

        while(!heap.isEmpty()) {
            System.out.print(heap.poll()+" ");
        }
    }

    void demoSets() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.remove(10);
        hashSet.contains(10);
    }
}
