package ggm.trees;

import java.util.List;

public class Tree {
    
    private TreeNode root;
    
    public Tree () {
        this.root = null; 
    }
    
    public Tree(TreeNode root){
        this.root = root;
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public String[][] getRoot() {
        return root.getContent();
    }
    
    private TreeNode getRootNode () {
        return this.root;
    }

    private void setRootNode(TreeNode root) {
        this.root = root;
    }
    
    public void setRoot (String[][] content) {
        this.root.setContent(content);
    }
    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
    public String[][] miniMax(String signo){
        this.createChildren(signo);
        for(Tree t: (List<Tree>)this.getRootNode().getChildren()){
            t.createChildren(signoOp(signo));
            t.calculateMin(signo);
        } 
        return calculateMax(signo);    
    }
    
    public void createChildren(String signo){
        String[][] matrizRoot = this.getRoot();           
            
        for(int i = 0; i< 3; i++){
            for(int j = 0; j<3; j++){
                if(matrizRoot[i][j].compareTo("-") == 0){
                    
                    String[][] matrizCopia = new String[3][3];
                    for(int n = 0; n<3; n++){
                        for(int m = 0; m<3; m++){
                           matrizCopia[i][j] = matrizRoot[i][j];

                        }}
                    
                    matrizCopia[i][j] = signo;
                    Tree tree = new Tree(new TreeNode(matrizCopia));
                    this.getRootNode().addChildren(tree);
                }
            }
        }
    }
    
    public String signoOp(String signo){
        String signoOp = "";
        
        if(signo.compareTo("X") == 0){
            signoOp = "O";
        } else signoOp = "X";
        
        return signoOp;
    }
    
    
    public String[][] calculateMax(String signo){
        int max = Integer.MIN_VALUE;
        for(Tree t: (List<Tree>)this.getRootNode().getChildren()){
            max = Math.max(max, t.getRootNode().getValor());
        }
        
        for(Tree t: (List<Tree>)this.getRootNode().getChildren()) {
            if(max == t.getRootNode().getValor()){
                return t.getRoot();
            }
        }
        return null;
    }
    
    public void calculateMin(String signo){
        int min = Integer.MAX_VALUE;
        for(Tree t: (List<Tree>)this.getRootNode().getChildren()){
            min = Math.min(min, t.UtilidadMin(signo));
        }
        this.getRootNode().setValor(min);
    }

    private int UtilidadMin(String signo) {
        int POponente = calcularP(signo);
        int Pjugador = calcularP(signoOp(signo));
        int U = Pjugador - POponente;
        return U;
    }
    
    public int calcularP(String signo){
        int count = 0;
        String[][] matriz = (String[][])this.getRoot();
 
        // Check rows
        for (int i = 0; i < 3; i++) {
            if ((matriz[i][0].compareTo(signo) != 0) && (matriz[i][1].compareTo(signo) != 0) 
                    && (matriz[i][2].compareTo(signo) != 0)) {
                count++;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if ((matriz[0][j].compareTo(signo) != 0) && (matriz[1][j].compareTo(signo) != 0) 
                    && (matriz[2][j].compareTo(signo) != 0)) {
                count++;
            }
        }

        // Check diagonals
        if ((matriz[0][0].compareTo(signo) != 0) && (matriz[1][1].compareTo(signo) != 0) 
                && (matriz[2][2].compareTo(signo) != 0)) {
            count++;
        }
        if ((matriz[0][2].compareTo(signo) != 0) && (matriz[1][1].compareTo(signo) != 0) 
                && (matriz[2][0].compareTo(signo) != 0)) {
            count++;
        }

        return count;
    }
}