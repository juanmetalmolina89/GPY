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
public class EliminarPoliticaOE extends ObjetoEntrada{
    @XmlElement
    private Integer a007codigo;

    public Integer getA007codigo() {
        return a007codigo;
    }

    public void setA007codigo(Integer a007codigo) {
        this.a007codigo = a007codigo;
    }
}
