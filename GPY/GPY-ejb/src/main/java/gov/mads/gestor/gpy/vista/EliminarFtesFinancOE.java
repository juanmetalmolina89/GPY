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
public class EliminarFtesFinancOE extends ObjetoEntrada{
    @XmlElement
    private Integer a004idproyecto;
    @XmlElement
    private Integer a004idftefinanc;

    public Integer getA004idproyecto() {
        return a004idproyecto;
    }

    public void setA004idproyecto(Integer a004idproyecto) {
        this.a004idproyecto = a004idproyecto;
    }

    public Integer getA004idftefinanc() {
        return a004idftefinanc;
    }

    public void setA004idftefinanc(Integer a004idftefinanc) {
        this.a004idftefinanc = a004idftefinanc;
    }
    
}
