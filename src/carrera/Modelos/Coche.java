package carrera.Modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author matias
 */
public class Coche {
    
    private StringProperty combustible ;
    private IntegerProperty cv;
    private StringProperty marca;
    private StringProperty matricula;
    private StringProperty modelo;
    private IntegerProperty posicion;
    
    public Coche(){
        
    }
       
    public Coche(String combustible, int cv, String marca, String matricula, 
            String modelo, int posicion) {
        
        this.combustible = new SimpleStringProperty(combustible);
        this.cv = new SimpleIntegerProperty(cv);
        this.marca = new SimpleStringProperty(marca);
        this.matricula = new SimpleStringProperty(matricula);
        this.modelo = new SimpleStringProperty(modelo);
        this.posicion = new SimpleIntegerProperty(posicion);
    }

    //Tipo de Combustible
    public String getCombustible() {
        return combustible.get();
    }

    public void setCombustible(String combustible) {
        this.combustible.set(combustible);
    }
    
    public StringProperty combustibleProperty(){
        return combustible;
    }
    
    
    //CV
    public int getCv() {
        return cv.get();
    }

    public void setCv(int cv) {
        this.cv.set(cv);
    }
    
    public IntegerProperty cvProperty(){
        return cv;
    }
    

    //Marca    
    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }
    
    public StringProperty marcaProperty(){
        return marca;
    }
    
    
    //Matricula
    public String getMatricula() {
        return matricula.get();
    }

    public void setMatricula(String matricula) {
        this.matricula.set(matricula);
    }
    
    public StringProperty matriculaProperty(){
        return matricula;
    }
    
    
    //Modelo
    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }
    
    public StringProperty modeloProperty(){
        return modelo;
    }

    
    //Posicion
    public int getPosicion() {
        return posicion.get();
    }

    public void setPosicion(int posicion) {
        this.posicion.set(posicion);
    }
    
    public IntegerProperty posicionProperty(){
        return posicion;
    }
   
}
