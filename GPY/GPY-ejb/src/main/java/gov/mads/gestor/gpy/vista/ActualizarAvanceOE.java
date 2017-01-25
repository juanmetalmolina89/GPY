/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.AvancePantalla;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ActualizarAvanceOE extends ObjetoEntrada{
    @XmlElement
    private Integer a057codigo;
    @XmlElement
    private Integer a002codigo;
    @XmlElement
    private Integer a057idpantalla;

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

    public Integer getA057codigo() {
        return a057codigo;
    }

    public void setA057codigo(Integer a057codigo) {
        this.a057codigo = a057codigo;
    }

    public void setA057idpantalla(Integer a057idpantalla) {
        this.a057idpantalla = a057idpantalla;
    }

    public Integer getA057idpantalla() {
        return a057idpantalla;
    }

}
