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
public class ConsultarFuentePorIdOE extends ObjetoEntrada{
    @XmlElement
    private Integer a038codigo;

    public Integer getA038codigo() {
        return a038codigo;
    }

    public void setA038codigo(Integer a038codigo) {
        this.a038codigo = a038codigo;
    }
}
