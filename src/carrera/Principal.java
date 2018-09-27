/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import carrera.Modelos.Coche;
import carrera.Modelos.CochesWraper;
import carrera.Vista.CarrerasController;
import carrera.Vista.RootLayoutController;
import java.io.File;

import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author friki
 */
public class Principal extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private CarrerasController carreracon;

    public static ObservableList<Coche> listacoches = FXCollections.observableArrayList();
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);

    public Principal() {
            listacoches.add(new Coche ("wer",2,"wertwer","hons","was",3));
            listacoches.add(new Coche ("far",2,"al","vo ","at",3));
            listacoches.add(new Coche ("der",2,"wertwer","aw","td",3));
            listacoches.add(new Coche ("wer",2,"wertwer","ra","rf",3));
            
    }

    public static ObservableList<Coche> getListaViviendas() {
        return listacoches;
    }

    //lanza la aplicacion 
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CarreraApp");
        initRootLayout();
        showPersonOverview();
    }

// se encarga de cargar el root y su controlador
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Principal.class.getResource("Vista/FXML.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setPrincipa(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // se encarga de cargar la clase carreras y su controlador
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Principal.class.getResource("Vista/Carreras.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            carreracon = loader.getController();
            carreracon.setPrincipal(this);

            rootLayout.setCenter(personOverview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    // cargo la rita del archivo 
    public File getCarrerasrutaArchivo() {
        try {
            Preferences prefs = Preferences.userNodeForPackage(Principal.class);

            String filePath = prefs.get("filePath", null);

            if (filePath != null) {
                return new File(filePath);
            } else {
                return null;
            }
        } catch (RuntimeException getCarrerasPath) {
            alerta.setTitle("Alerta");
            alerta.setHeaderText("getcarrerasPath");
            alerta.showAndWait();
            return null;
        }

    }

    public void setCarrerarutaArchivo(File file) {
        try {
            Preferences prefs = Preferences.userNodeForPackage(Principal.class);
            if (file != null) {

                prefs.put("filePath", file.getPath());

                primaryStage.setTitle("Carrera - " + file.getName());
            } else {

                prefs.remove("filePath");

                primaryStage.setTitle("Carrera");
            }
        } catch (RuntimeException setCarrerasPath) {

            alerta.setTitle("Alerta");
            alerta.setHeaderText("setCarrerasPath");
            alerta.showAndWait();

        }
    }

    // carga los elementos desde el fichero xml 
    public void cargarCochesFromFile(File file) throws JAXBException {
        try {

            JAXBContext context = JAXBContext.newInstance(CochesWraper.class);
            Unmarshaller um = context.createUnmarshaller();

            CochesWraper wrapper = (CochesWraper) um.unmarshal(file);

            listacoches.clear();

            listacoches.addAll(wrapper.getCarrera());

            setCarrerarutaArchivo(file);

            carreracon.bindings();

        } catch (RuntimeException loadViviendaFromFile) { // catches ANY exception
            alerta.setTitle("Alerta");
            alerta.setHeaderText("SerRutapath");
            alerta.showAndWait();
        }
    }

    public void savecarrerasToFile(File file) throws JAXBException {
        try {

            JAXBContext context = JAXBContext
                    .newInstance(CochesWraper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CochesWraper wrapper = new CochesWraper();
            wrapper.setcarreras(listacoches);

            m.marshal(wrapper, file);

            setCarrerarutaArchivo(file);

        } catch (RuntimeException saveCarrerasFromFile) {
            alerta.setTitle("Alerta");
            alerta.setHeaderText("savecarrerasFromFile");
            alerta.showAndWait();
        }
    }

    //lanza la aplicacion 
}
