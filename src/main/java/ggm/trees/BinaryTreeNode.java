package ggm.trees;

class BinaryTreeNode<E> {
    private E content;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTreeNode(E content) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }
    
    
    
    
}
