/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2_ed;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modelo.*;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class InterfaceTableController implements Initializable {

    @FXML
    private Label turnoJugador;
    @FXML
    private GridPane tableGame;
    @FXML
    private Button box0_0;
    @FXML
    private Button box1_0;
    @FXML
    private Button box2_0;
    @FXML
    private Button box0_1;
    @FXML
    private Button box1_1;
    @FXML
    private Button box2_1;
    @FXML
    private Button box0_2;
    @FXML
    private Button box1_2;
    @FXML
    private Button box2_2;
    
    private nuevoJuego partidaActual;
    private Comparator<Jugador> cmp;
    private Jugador jugadorActual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmp = (j1,j2) -> {
            if(j1.getSigno().compareTo(j2.getSigno()) == 0) return 0;
            return -1;
        };
        partidaActual = new nuevoJuego();
        actualizarJugador();
    } 
    
    public void actualizarTablero() {
        String[][] tableroActual = new String[3][3];
        tableroActual[0][0] = box0_0.getText();
        tableroActual[0][1] = box0_1.getText();
        tableroActual[0][2] = box0_2.getText();
        tableroActual[1][0] = box1_0.getText();
        tableroActual[1][1] = box1_1.getText();
        tableroActual[1][2] = box1_2.getText();
        tableroActual[2][0] = box2_0.getText();
        tableroActual[2][1] = box2_1.getText();
        tableroActual[2][2] = box2_2.getText();
        partidaActual.setTablero(tableroActual);
    }
    
    public void actualizarJugador(){
        turnoJugador.setText("Turno del Jugador "+partidaActual.getNumJugador());
        jugadorActual = partidaActual.turnoJugador();
    }
    
    public void marcarCasilla(Button b){
        if(!verificarCasilla(b)){
            jugadorActual.marcarCasilla(b);
            verificarTablero();
            actualizarJugador();
        }
    }
    
    public boolean verificarCasilla(Button b){
        String signo = b.getText();
        return signo.compareTo("X") == 0 || signo.compareTo("O") == 0;
    }
    
    public void verificarTablero(){
        if(condicionVictoria()){
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (condicionEmpate()){
            
        }
    }
    
    public boolean condicionEmpate(){
        boolean lleno0_0 = verificarCasilla(box0_0);
        boolean lleno0_1 = verificarCasilla(box0_1);
        boolean lleno0_2 = verificarCasilla(box0_2);
        boolean lleno1_0 = verificarCasilla(box1_0);
        boolean lleno1_1 = verificarCasilla(box1_1);
        boolean lleno1_2 = verificarCasilla(box1_2);
        boolean lleno2_0 = verificarCasilla(box2_0);
        boolean lleno2_1 = verificarCasilla(box2_1);
        boolean lleno2_2 = verificarCasilla(box2_2);
        
        return lleno0_0 && lleno0_1 && lleno0_2 && lleno1_0 && lleno1_1 && lleno1_2 && lleno2_0 && lleno2_1 && lleno2_2;
    }
    
    public boolean condicionVictoria(){
        String signo = ""+jugadorActual.getSigno();
        boolean diagonal1 = verificarLinea(box0_0,box1_1,box2_2,signo);
        boolean diagonal2 = verificarLinea(box0_2,box1_1,box2_0,signo);
        boolean lineaH1 = verificarLinea(box0_0,box0_1,box0_2,signo);
        boolean lineaH2 = verificarLinea(box1_0,box1_1,box1_2,signo);
        boolean lineaH3 = verificarLinea(box2_0,box2_1,box2_2,signo);
        boolean lineaV1 = verificarLinea(box0_0,box1_0,box2_0,signo);
        boolean lineaV2 = verificarLinea(box0_1,box1_1,box2_1,signo);
        boolean lineaV3 = verificarLinea(box0_2,box1_2,box2_2,signo);
        
        return diagonal1 || diagonal2 || lineaH1 || lineaH2 || lineaH3 || lineaV1 || lineaV2 || lineaV3;   
    }
    
    public boolean verificarLinea(Button b1, Button b2, Button b3, String signo){
        boolean condicion1 = b1.getText().compareTo(signo) == 0;
        boolean condicion2 = b2.getText().compareTo(signo) == 0;
        boolean condicion3 = b3.getText().compareTo(signo) == 0;
        
        return condicion1 && condicion2 && condicion3;
    }
     
    @FXML
    public void marcarBox0_0(){
        marcarCasilla(box0_0);
    }
    
    @FXML
    public void marcarBox0_1(){
        marcarCasilla(box0_1);
    }
    
    @FXML
    public void marcarBox0_2(){
        marcarCasilla(box0_2);
    }
    
    @FXML
    public void marcarBox1_0(){
        marcarCasilla(box1_0);
    }
    
    @FXML
    public void marcarBox1_1(){
        marcarCasilla(box1_1);
    }
    
    @FXML
    public void marcarBox1_2(){
        marcarCasilla(box1_2);
    }
    
    @FXML
    public void marcarBox2_0(){
        marcarCasilla(box2_0);
    }
    
    @FXML
    public void marcarBox2_1(){
        marcarCasilla(box2_1);
    }
    
    @FXML
    public void marcarBox2_2(){
        marcarCasilla(box2_2);
    }
}
