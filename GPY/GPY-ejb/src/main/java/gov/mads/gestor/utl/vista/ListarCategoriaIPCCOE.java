/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarCategoriaIPCCOE extends ObjetoEntrada{
    @XmlElement
    private Integer a046idsector;

    public Integer getA046idsector() {
        return a046idsector;
    }

    public void setA046idsector(Integer a046idsector) {
        this.a046idsector = a046idsector;
    }
}
