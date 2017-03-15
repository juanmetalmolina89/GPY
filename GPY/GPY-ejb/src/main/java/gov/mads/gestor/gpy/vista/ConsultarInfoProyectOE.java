/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ConsultarInfoProyectOE extends ObjetoEntrada{
    @XmlElement
    private Integer a013idproyecto;

    public Integer getA013idproyecto() {
        return a013idproyecto;
    }

    public void setA013idproyecto(Integer a013idproyecto) {
        this.a013idproyecto = a013idproyecto;
    }
    
}
