package ggm.trees;

import java.util.LinkedList;
import java.util.List;

class TreeNode<E> {
    
    private E content;
    private List<Tree<E>> children;
    private int valor;

    public TreeNode(E content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    } 

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<E>> children) {
        this.children = children;
    }
    
    public void addChildren(Tree<E> t){
        children.add(t);
    }
    
}
