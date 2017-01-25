/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.ActividadGeometria;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ConsultarGeometriaPorIdOE extends ObjetoEntrada{
   @XmlElement
   private Integer a042codigo;
   @XmlElement
   private Integer a042idproyecto;
   @XmlElement
   private Integer a042idactividad;

    public Integer getA042codigo() {
        return a042codigo;
    }

    public void setA042codigo(Integer a042codigo) {
        this.a042codigo = a042codigo;
    }

    public Integer getA042idproyecto() {
        return a042idproyecto;
    }

    public void setA042idproyecto(Integer a042idproyecto) {
        this.a042idproyecto = a042idproyecto;
    }

    public Integer getA042idactividad() {
        return a042idactividad;
    }

    public void setA042idactividad(Integer a042idactividad) {
        this.a042idactividad = a042idactividad;
    }
    
}
