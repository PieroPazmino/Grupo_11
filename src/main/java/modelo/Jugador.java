/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javafx.scene.control.Button;

/**
 *
 * @author USUARIO
 */
public abstract class Jugador implements Serializable{
    private String signo;
    
    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }
    public abstract void marcarCasilla(Button b);
    
    @Override
    public abstract String toString();
}
