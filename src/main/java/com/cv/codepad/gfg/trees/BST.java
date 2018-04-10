package com.cv.codepad.gfg.trees;

import java.util.Arrays;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public void print() {
        TreeUtil.prettyPrintTree(root);
    }

    /**
     * Inserts a number into the bst at the right place
     *
     * @param num Number to be inserted
     */
    public void insert(int num) {
        root = insert(root, num);
    }

    // Insert helper
    private TreeNode insert(TreeNode node, int num) {
        if (node == null) {
            return new TreeNode(num);
        }
        if (num <= node.val) {
            node.left = insert(node.left, num);
        } else {
            node.right = insert(node.right, num);
        }
        return node;
    }

    /**
     * Inserts 1, 2, 3 into this tree!
     */
    public void insert123() {
        insert(2);
        insert(1);
        insert(3);
    }

    /**
     * Returns if a number is present in a tree
     *
     * @param num The number to lookup
     * @return If the number is present in the tree
     */
    public boolean lookup(int num) {
        return lookup(root, num);
    }

    private boolean lookup(TreeNode node, int num) {
        if (node == null) {
            return false;
        }
        if (num == node.val) {
            return true;
        } else if (num < node.val) {
            return lookup(node.left, num);
        } else {
            return lookup(node.right, num);
        }

    }

    public static void main(String[] args) {
        BST b = new BST();

        // Basic Insert test
        System.out.println("Insertion test: ");
        b.insert123();
        System.out.println("Tree: ");
        b.print();

        // Lookup test
        System.out.println("Lookup test: ");
        int nums[] = {2, 4, 3, 1, 6, 5, 7};
        b = new BST();
        Arrays.stream(nums).forEach(b::insert);
        System.out.println("Tree: ");
        b.print();
        System.out.println("Looking up 4 : " + b.lookup(4));
        System.out.println("Looking up 8: " + b.lookup(8));


    }
}
