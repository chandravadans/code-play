package com.cv.codepad.gfg.trees;

public class BST extends BinaryTree {

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
    @Override
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
    @Override
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

}
