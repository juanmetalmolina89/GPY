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
public class ListarAdjuntosOE extends ObjetoEntrada{
    @XmlElement
    private Integer a002tipproyct;
    @XmlElement
    private Integer a0025idpantalla;

    public Integer getA002tipproyct() {
        return a002tipproyct;
    }

    public void setA002tipproyct(Integer a002tipproyct) {
        this.a002tipproyct = a002tipproyct;
    }

    public Integer getA0025idpantalla() {
        return a0025idpantalla;
    }

    public void setA0025idpantalla(Integer a0025idpantalla) {
        this.a0025idpantalla = a0025idpantalla;
    }
}
