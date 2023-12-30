/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class nuevoJuego {
    //private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private String[][] tablero;
    private int numJugador = 1;
    
    public nuevoJuego() {
        jugador1 = new HumanJugador("X");
        jugador2 = new HumanJugador("O");
        tablero = new String[3][3];
    }
    
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    
    public String[][] getTablero() {
        return tablero;
    } 

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    /*public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }*/

    public int getNumJugador() {
        return numJugador;
    }
    
    public Jugador turnoJugador(){
        if(numJugador == 1) {
            numJugador++;
            return jugador1;
        }
        else{
            numJugador--;
            return jugador2;
        }
    }
}
