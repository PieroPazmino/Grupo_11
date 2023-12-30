/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
    }

    public char[][] getTablero() {
        return tablero;
    } 

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }
    
}
