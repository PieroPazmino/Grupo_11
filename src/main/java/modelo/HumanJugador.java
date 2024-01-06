/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javafx.scene.control.Button;

/**
 *
 * @author USUARIO
 */
public class HumanJugador extends Jugador{

    public HumanJugador(){
        
    }
    
    @Override
    public void marcarCasilla(Button b) {
        b.setText(""+getSigno());
    }

    @Override
    public String toString() {
        return "Jugador";
    }
    
}
