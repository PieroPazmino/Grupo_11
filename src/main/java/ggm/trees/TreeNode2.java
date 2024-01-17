/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ggm.trees;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class TreeNode2<E> {
    private E[][] content;
    private List<Tree2<E>> children;
    private int valor;

    public TreeNode2(E[][] content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    } 

    public E[][] getContent() {
        return content;
    }

    public void setContent(E[][] content) {
        this.content = content;
    }

    public List<Tree2<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree2<E>> children) {
        this.children = children;
    }
    
    public void addChildren(Tree2<E> t){
        children.add(t);
    }
}
