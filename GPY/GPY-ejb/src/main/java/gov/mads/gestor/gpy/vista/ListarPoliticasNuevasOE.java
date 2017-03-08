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
public class ListarPoliticasNuevasOE extends ObjetoEntrada{
    private Integer a059idproyecto;

    public Integer getA059idproyecto() {
        return a059idproyecto;
    }

    public void setA059idproyecto(Integer a059idproyecto) {
        this.a059idproyecto = a059idproyecto;
    }
}
