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
public class ListarFuentesProyectoOE extends ObjetoEntrada{
    @XmlElement
    private Integer a038idproyecto;

    public Integer getA038idproyecto() {
        return a038idproyecto;
    }

    public void setA038idproyecto(Integer a038idproyecto) {
        this.a038idproyecto = a038idproyecto;
    }
}
