
package carrera.Vista;



import java.io.File;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javax.xml.bind.JAXBException;
import carrera.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;


public class RootLayoutController  {
 Principal principal ;
 
    
    @FXML
    private MenuItem CargarDatos;

    @FXML
    private MenuItem GuardarDatos;

    @FXML
    private MenuItem autor;

    @FXML
    private MenuItem cerrar;


    
       @FXML 
    private void  handleClose(){
    Platform.exit();
    }
    
    @FXML
  private void handleAutor(){
  Alert dialoAlerta = new Alert(Alert.AlertType.INFORMATION);
  dialoAlerta.setTitle("Autor");
  dialoAlerta.setHeaderText(null);//sin titulo interno
  dialoAlerta.setContentText("Autor: Aythami Zacarias Martin Gonzalez \n Fecha:29 de mayo de 2017 \n Prueba Final para mòdulo de DAD(Fabiola) ");
  dialoAlerta.initStyle(StageStyle.UTILITY);
  dialoAlerta.showAndWait();
  
  
  }  
  
     public void setPrincipa(Principal mainApp) {
        this.principal = mainApp;
    }

  
  @FXML
    private void handleOpen() throws JAXBException {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                 "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(principal.getPrimaryStage());

        if (file != null) {
          principal.cargarCochesFromFile(file);
          
        }
    }
 
    @FXML
    private void Guardar() throws JAXBException {
        File cocheFile = principal.getCarrerasrutaArchivo();
        if (cocheFile != null) {
            principal.savecarrerasToFile(cocheFile);
        } else {
            handleSaveAs();
        }
    
    }
    
    
     @FXML
    private void handleSaveAs() throws JAXBException {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(principal.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            principal.savecarrerasToFile(file);
        }
    }

  
    
    
    
    
    
    
}
