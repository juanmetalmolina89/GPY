/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.*;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarInstrmntFinnccnPOE extends ObjetoEntrada{
    @XmlElement
    private Integer a009idproyecto;

    public Integer getA009idproyecto() {
        return a009idproyecto;
    }

    public void setA009idproyecto(Integer a009idproyecto) {
        this.a009idproyecto = a009idproyecto;
    }
}
