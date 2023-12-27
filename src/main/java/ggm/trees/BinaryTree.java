package ggm.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E root) {
        this.root = new BinaryTreeNode<>(root);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public E getRoot() {
        return this.root.getContent();
    }
    
    private BinaryTreeNode<E> getRootNode() {
        return this.root;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null
                && this.root.getRight() == null;
    }

    public List<E> preOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        results.add(this.root.getContent());
        if (root.getLeft() != null) {
            List<E> leftTraversal = root.getLeft().preOrderTraversal();
            results.addAll(leftTraversal);
        }
        if (root.getRight() != null) {
            List<E> rightTraversal = root.getRight().preOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }

    public List<E> inOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        if (root.getLeft() != null) {
            List<E> leftTraversal = root.getLeft().inOrderTraversal();
            results.addAll(leftTraversal);
        }
        results.add(this.root.getContent());
        if (root.getRight() != null) {
            List<E> rightTraversal = root.getRight().inOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }

    void setLeft(BinaryTree<E> t) {
        this.root.setLeft(t);
    }

    void setRight(BinaryTree<E> t) {
        this.root.setRight(t);
    }

    BinaryTree<E> getLeft() {
        return this.root.getLeft();
    }

    BinaryTree<E> getRight() {
        return this.root.getRight();
    }

    public int countNodesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int totalLeft = 0;
        if (this.getLeft() != null) {
            totalLeft = this.getLeft().countNodesRecursive();
        }
        int totalRight = 0;
        if (this.getRight() != null) {
            totalRight = this.getRight().countNodesRecursive();
        }
        return 1 + totalLeft + totalRight;
    }

    public int countNodesIterative() {
        int nNodes = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            nNodes++;
            if (tree.getLeft() != null) {
                s.push(tree.getLeft());
            }
            if (tree.getRight() != null) {
                s.push(tree.getRight());
            }
        }
        return nNodes;
    }

    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int leavesLeft = 0;
        int leavesRight = 0;
        if (this.getLeft() != null) {
            leavesLeft = this.getLeft().countLeavesRecursive();
        }
        if (this.getRight() != null) {
            leavesRight = this.getRight().countLeavesRecursive();
        }
        return leavesLeft + leavesRight;
    }

    public int countLeavesIterative() {
        int totalLeaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (tree.isLeaf()) {
                totalLeaves++;
            } else {
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }

    public int countInternalNodesIterative() {
        int totalLeaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (!tree.isLeaf()) {
                totalLeaves++;
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }

}
