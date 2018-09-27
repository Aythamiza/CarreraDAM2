/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera.Modelos;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author friki
 */
@XmlRootElement(name = "carrera")
public class CochesWraper {
      private List<Coche> coches;

    @XmlElement(name = "coche")
    public List<Coche> getCarrera() {
        return coches;
    }

    public void setcarreras (List<Coche> carrera) {
        this.coches = carrera;
    }
}
