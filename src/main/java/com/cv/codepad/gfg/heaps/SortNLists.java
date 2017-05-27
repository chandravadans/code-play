package com.cv.codepad.gfg.heaps;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by cv on 4/17/17.
 */
public class SortNLists {
    class HeapNode {
        public int element;
        public int listIndex;
        public int nextElement;
        public HeapNode(int element, int listIndex, int nextElement) {
            this.element = element;
            this.listIndex = listIndex;
            this.nextElement = nextElement;
        }

        @Override
        public String toString() {
            return ("HeapNode[element= "+this.element+", listIndex="+this.listIndex+", nextElement="+this.nextElement+"]");
        }
    }
    public Integer[] sortNLists (Integer[][] lists) {
        int numLists = lists.length;
        int sizeOfEachList = lists[0].length;
        Integer result [] = new Integer[numLists*sizeOfEachList];
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(numLists, (node1, node2) -> {
            if (node1.element < node2.element) {
                return -1;
            } else if(node1.element > node2.element) {
                return 1;
            } else {
                return 0;
            }
        });
        for(int i=0; i < numLists; i++) {
            HeapNode thisNode = new HeapNode(lists[i][0],i,1);
            heap.offer(thisNode);
        }
        int resultCount;
        for(resultCount = 0; resultCount < numLists*sizeOfEachList; resultCount++) {
            HeapNode minimumNode = heap.poll();
            result[resultCount] = minimumNode.element;
            HeapNode newNode;
            if (minimumNode.nextElement < sizeOfEachList) {
                newNode = new HeapNode(lists[minimumNode.listIndex][minimumNode.nextElement], minimumNode.listIndex, minimumNode.nextElement + 1);
            } else {
                newNode = new HeapNode(Integer.MAX_VALUE, minimumNode.listIndex, minimumNode.nextElement + 1);
            }
            heap.offer(newNode);
        }
        System.out.println("Heap size = "+heap.size());
        for(Iterator i = heap.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }
        return result;
    }

    public static void main(String[] args) {
        SortNLists solution = new SortNLists();
        Integer nLists[][] = {{-6, -5, -4},
            {-1, 0, 2},
            {-3, -1, 0}};
        Integer[] integers = solution.sortNLists(nLists);
        for(Integer i : integers) {
            System.out.print(i + " ");
        }
    }
}
