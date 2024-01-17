/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ggm.trees;

/**
 *
 * @author USUARIO
 */
public class Tree2<E> {
    private TreeNode2<E> root;
    
    public Tree2 () {
        this.root = null; 
    }
    
    public Tree2 (TreeNode2<E> root){
        this.root = root;
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E[][] getRoot() {
        return root.getContent();
    }
    
    private TreeNode2<E> getRootNode () {
        return this.root;
    }

    private void setRootNode(TreeNode2<E> root) {
        this.root = root;
    }
    
    public void setRoot (E[][] content) {
        this.root.setContent(content);
    }
    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
    public E[][] miniMax(E signo){
        this.createChildren(signo, this.getRoot());
        for(Tree2 t: this.getRootNode().getChildren()){
            t.createChildren(signoOp(signo), t.getRoot());
            t.calculateMin(signo);
        } 
        return calculateMax();    
    }
    
    public void createChildren(E signo, E[][] matrizRoot){
        //String[][] matrizRoot = this.getRoot();           
            
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                E[][] matrizCopia = (E[][]) new Object[3][3];
                
                if(matrizRoot[i][j] == "-"){
                    for(int n = 0; n<3; n++){
                        for(int m = 0; m<3; m++){
                           matrizCopia[n][m] = matrizRoot[n][m];

                        }}
                    
                    matrizCopia[i][j] = signo;
                    Tree2<E> tree = new Tree2(new TreeNode2(matrizCopia));
                    this.getRootNode().addChildren(tree);
                }
            }
        }
    }
    
    public String signoOp(E signo){
        if(signo == "X"){
            return "O";
        } else return "X";
    }
    
    public E[][] calculateMax(){
        int max = Integer.MIN_VALUE;
        for(Tree2<E> t: this.getRootNode().getChildren()){
            max = Math.max(max, t.getRootNode().getValor());
        }
        
        for(Tree2<E> t: this.getRootNode().getChildren()) {
            if(max == t.getRootNode().getValor()){
                return t.getRoot();
            }
        }
        return null;
    }
    
    public void calculateMin(E signo){
        int min = Integer.MAX_VALUE;
        for(Tree2<E> t: this.getRootNode().getChildren()){
            min = Math.min(min, t.UtilidadMin(signo));
        }
        this.getRootNode().setValor(min);
    }

    private int UtilidadMin(E signo) {
        int POponente = calcularP(signo);
        int Pjugador = calcularP((E)signoOp(signo));
        int U = Pjugador - POponente;
        //System.out.println(U);
        return U;
    }
    
    public int calcularP(E signo){
        int count = 0;
        E[][] matriz = this.getRoot();
 
        // Check rows
        for (int i = 0; i < 3; i++) {
            if ((matriz[i][0] != signo) && (matriz[i][1] != signo) 
                    && (matriz[i][2] != signo)) {
                count++;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if ((matriz[0][j] != signo) && (matriz[1][j] != signo) 
                    && (matriz[2][j] != signo)) {
                count++;
            }
        }

        // Check diagonals
        if ((matriz[0][0] != signo) && (matriz[1][1] != signo) 
                && (matriz[2][2] != signo)) {
            count++;
        }
        if ((matriz[0][2] != signo) && (matriz[1][1] != signo) 
                && (matriz[2][0] != signo)) {
            count++;
        }
        //System.out.println(count);
        return count;
    }
}
