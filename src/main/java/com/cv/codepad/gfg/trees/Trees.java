package com.cv.codepad.gfg.trees;

import java.util.Arrays;

public class Trees {

    public static void main(String[] args) {
        BST bst = new BST();

        // Basic Insert test
        System.out.println("Insertion test: ");
        bst.insert123();
        System.out.println("Tree: ");
        bst.print();

        // Lookup test
        System.out.println("\nLookup test: ");
        int nums[] = {2, 4, 3, 1, 6, 5, 7};
        bst = new BST();
        Arrays.stream(nums).forEach(bst::insert);
        System.out.println("Tree: ");
        bst.print();
        System.out.println("Looking up 4 : " + bst.lookup(4));
        System.out.println("Looking up 8: " + bst.lookup(8));

        // Size
        System.out.println("\nSize : ");
        System.out.println("Tree: ");
        bst.print();
        System.out.println("Size: " + bst.size());

        // Height
        System.out.println("\nHeight of tree: ");
        bst = new BST();
        nums = new int[]{100, 90, 80, 85, 84, 83, 82, 81, 110, 105, 120, 10, 107, 108};
        Arrays.stream(nums).forEach(bst::insert);
        System.out.println("Tree: ");
        bst.print();
        System.out.println("Height : " + bst.height());

        // Level order traversal
        System.out.println("\nLevel order traversal: ");
        System.out.println("Tree: ");
        bst.print();
        System.out.print("Level order traversal : ");
        bst.levelOrder();

        // Inorder traversal
        System.out.println("\nIn order traversal: ");
        System.out.println("Tree: ");
        bst.print();
        System.out.print("In order traversal : ");
        bst.inorder();


    }
}
