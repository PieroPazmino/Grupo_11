package ggm.trees;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    
    private String[][] content;
    private List<Tree> children;
    private int valor;

    public TreeNode(String[][] content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    } 

    public String[][] getContent() {
        return content;
    }

    public void setContent(String[][] content) {
        this.content = content;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
    
    public void addChildren(Tree t){
        children.add(t);
    }
    
}
