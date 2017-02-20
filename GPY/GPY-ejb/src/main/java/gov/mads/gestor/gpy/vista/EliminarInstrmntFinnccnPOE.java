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
public class EliminarInstrmntFinnccnPOE extends ObjetoEntrada{
    @XmlElement
    private Integer a009codigo;

    public Integer getA009codigo() {
        return a009codigo;
    }

    public void setA009codigo(Integer a009codigo) {
        this.a009codigo = a009codigo;
    }
    
    
}
