/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2_ed;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import modelo.*;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class MenuConfiguracionController implements Initializable, Serializable {

    @FXML
    private ComboBox<Jugador> cmbJugador1;
    @FXML
    private ComboBox<String> cmbSigno1;
    @FXML
    private ComboBox<Jugador> cmbJugador2;
    @FXML
    private ComboBox<String> cmbSigno2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarJugadores();
    }

    public void rellenarJugadores() {
        cmbJugador1.getItems().add(new HumanJugador());
        cmbJugador1.getItems().add(new IAJugador());
        
        cmbSigno1.getItems().add("X");
        cmbSigno1.getItems().add("O");
        
        cmbJugador2.getItems().add(new HumanJugador());
        cmbJugador2.getItems().add(new IAJugador());
        
        cmbSigno2.getItems().add("X");
        cmbSigno2.getItems().add("O");     
    }
    
    @FXML
    public void creacionJuego() {
        if(condicionNoVacio() && signosDiferentes()){
            Jugador j1 = (Jugador)cmbJugador1.getValue();
            j1.setSigno((String)cmbSigno1.getValue());
            
            Jugador j2 = (Jugador)cmbJugador2.getValue();
            j2.setSigno((String)cmbSigno2.getValue());
            
            nuevoJuego newGame = new nuevoJuego();
            newGame.setJugador1(j1);
            newGame.setJugador2(j2);
            
            serializarJuego(newGame);
            iniciarGame();
        }
        else if(!condicionNoVacio()){
            mostrarAlerta(Alert.AlertType.INFORMATION, "Verifique si todas las casillas estan llenas.");
        }
        else if(!signosDiferentes()){
            mostrarAlerta(Alert.AlertType.INFORMATION, "Los signos son iguales. Por favor cambie uno.");
        }
    }
    
    public void serializarJuego(nuevoJuego game) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("archivos/game.text"))){
            out.writeObject(game);
            out.flush();
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
    
    public void iniciarGame(){
        try {
            App.setRoot("interfaceTable");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 

    private boolean condicionNoVacio() {
        boolean j1NotNull = (Jugador)cmbJugador1.getValue() != null;
        boolean j2NotNull = (Jugador)cmbJugador2.getValue() != null;
        boolean s1NotNull = (String)cmbSigno1.getValue() != null;
        boolean s2NotNull = (String)cmbSigno2.getValue() != null;
        
        return j1NotNull && j2NotNull && s1NotNull && s2NotNull;
    }

    private boolean signosDiferentes() {
        if(condicionNoVacio()){
            String signo1 = (String)cmbSigno1.getValue();
            String signo2 = (String)cmbSigno2.getValue();
            return !(signo1.compareTo(signo2) == 0);
        }
        return false;
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
