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
public class EliminarPoliticaNuevaOE extends ObjetoEntrada{
    @XmlElement
    private Integer a059codigo;

    public Integer getA059codigo() {
        return a059codigo;
    }

    public void setA059codigo(Integer a059codigo) {
        this.a059codigo = a059codigo;
    }
}
