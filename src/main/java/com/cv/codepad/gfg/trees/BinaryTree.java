package com.cv.codepad.gfg.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void print() {
        TreeUtil.prettyPrintTree(root);
    }

    /**
     * Inserts 1, 2, 3 into this tree!
     */
    public void insert123() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
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
        return node != null && (num == node.val || lookup(node.left, num) || lookup(node.right, num));
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

    /**
     * Level order traversal (BFS)
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
     * Inorder traversal (A form of DFS)
     */
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + ", ");
        inorder(node.right);
    }


    /**
     * Prints the boundary of tree in anticlockwise fashion
     */
    public void boundaryTraversal() {
        boundaryTraversal(root);
    }

    private void boundaryTraversal(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);

            printLeft(node.left);

            printLeaves(node.left);
            printLeaves(node.right);

            printRight(node.right);
        }
    }

    private void printLeft(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                System.out.println(node.val + " ");
                printLeft(node.left);
            } else if (node.right != null) {
                System.out.println(node.val + " ");
                printLeft(node.right);
            }
            // If both are null, this is a leaf, will print it in the printLeaves function
        }
    }

    private void printLeaves(TreeNode node) {
        if (node != null) {
            printLeaves(node.left);
            if (node.left == null && node.right == null) {
                System.out.println(node.val + " ");
            }
            printLeaves(node.right);

        }
    }

    private void printRight(TreeNode node) {
        if (node != null) {
            if (node.right != null) {
                printRight(node.right);
                System.out.println(node.val);
            } else if (node.left != null) {
                printRight(node.left);
                System.out.println(node.val);
            }
        }
    }

    

}
