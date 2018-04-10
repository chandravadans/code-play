package com.cv.codepad.gfg.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Do a level order traversal and print out nodes
     */
    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }

    private void levelOrder(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            TreeNode thisNode = q.poll();
            System.out.print(thisNode.val + ", ");
            if (thisNode.left != null) {
                q.offer(thisNode.left);
            }
            if (thisNode.right != null) {
                q.offer(thisNode.right);
            }
        }
    }

    /**
     * Returns the number of nodes in this tree
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.right) + size(node.left);
        }
    }

    /**
     * Height of the tree, length of the longest root -> leaf path
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

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

        // Level order traversal
        System.out.println("\nLevel order traversal: ");
        System.out.println("Tree: ");
        bst.print();
        System.out.print("Level order traversal : ");
        bst.levelOrder();

        // Size
        System.out.println("\nSize : ");
        System.out.println("Tree: ");
        bst.print();
        System.out.println("Size: " + bst.size());

        // MaxDepth
        System.out.println("\nHeight of tree: ");
        bst = new BST();
        nums = new int[]{100, 90, 80, 85, 84, 83, 82, 81, 110, 105, 120, 10, 107, 108};
        Arrays.stream(nums).forEach(bst::insert);
        System.out.println("Tree: ");
        bst.print();
        System.out.println("Height : " + bst.height());


    }
}
