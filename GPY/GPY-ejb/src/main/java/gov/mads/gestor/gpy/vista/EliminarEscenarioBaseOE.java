/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class EliminarEscenarioBaseOE extends ObjetoEntrada{
    private Integer a010codigo; 

    public Integer getA010codigo() {
        return a010codigo;
    }

    public void setA010codigo(Integer a010codigo) {
        this.a010codigo = a010codigo;
    }
}
