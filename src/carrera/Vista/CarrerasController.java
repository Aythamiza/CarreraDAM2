/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera.Vista;


import carrera.Principal;

import javafx.beans.property.SimpleStringProperty;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;


import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author friki
 */
public class CarrerasController  {

    

    @FXML
    private TextField Matricula;
    @FXML
    private TextField Marca;
    @FXML
    private TextField Modelo;
    @FXML
    private TextField Combustible;
    @FXML
    private TextField Numcaballos;
    @FXML
    private TextField Posiciondecarrera;
    
     Principal principal;

    private int num;
    
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    
    /**
     * Initializes the controller class.
     * @param principal
     */
 
      public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
      
      
      
      
      
    


    @FXML
    public void BotonDerecho() {
         
           
           try {
           
            if (num < principal.listacoches.size() - 1) {
                unBindings();
                num++;
                bindings();
            } else {
                alerta.setTitle("Alerta");
                alerta.setHeaderText("Último registro");
                alerta.setContentText("Has llegado al último registro disponible");
                alerta.showAndWait();
            }

        } catch (RuntimeException exceptionNext2) {
                
        }
           
         
    }
    
    
      @FXML
    public void Botoniz() {
        try {
            if (num > 0) {
                unBindings();
                num--;
                bindings();
            } else {
                alerta.setTitle("Alerta");
                alerta.setHeaderText("Primer registro");
                alerta.setContentText("Has llegado al primer registro disponible");
                alerta.showAndWait();
            }
        } catch (RuntimeException exceptionback2) {

        }
    }
    
    
    
    
    
    
    
    
    
    
    
    

 @FXML
    public void bindings() {
        
        
        
        if (principal.listacoches.isEmpty()) {
            Matricula.setText(" ");
            Marca.setText(" ");
            Modelo.setText(" ");
            Combustible.setText(" ");
            Numcaballos.setText(" ");
            Posiciondecarrera.setText(" ");
        } else {
        Matricula.textProperty().bindBidirectional(principal.listacoches.get(num).matriculaProperty());
        Marca.textProperty().bindBidirectional(principal.listacoches.get(num).marcaProperty());
        Modelo.textProperty().bindBidirectional(principal.listacoches.get(num).modeloProperty());
        Combustible.textProperty().bindBidirectional(principal.listacoches.get(num).combustibleProperty());
        Numcaballos.textProperty().bindBidirectional(new SimpleStringProperty(String.valueOf(principal.listacoches.get(num).cvProperty().getValue())));
        Posiciondecarrera.textProperty().bindBidirectional(new SimpleStringProperty(String.valueOf(principal.listacoches.get(num).posicionProperty().getValue())));
        }
        
    }

    @FXML
    public void unBindings() {
        
        Matricula.textProperty().unbindBidirectional(principal.listacoches.get(num).matriculaProperty());
        Marca.textProperty().unbindBidirectional(principal.listacoches.get(num).marcaProperty());
        Modelo.textProperty().unbindBidirectional(principal.listacoches.get(num).modeloProperty());
        Combustible.textProperty().unbindBidirectional(principal.listacoches.get(num).combustibleProperty());
        Numcaballos.textProperty().unbindBidirectional(new SimpleStringProperty(String.valueOf(principal.listacoches.get(num).cvProperty().getValue())));
        Posiciondecarrera.textProperty().unbindBidirectional(new SimpleStringProperty(String.valueOf(principal.listacoches.get(num).posicionProperty().getValue())));
    } 

  
      
    

} 