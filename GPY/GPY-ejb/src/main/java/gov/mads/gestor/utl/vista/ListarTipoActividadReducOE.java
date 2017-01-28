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
public class ListarTipoActividadReducOE extends ObjetoEntrada{
   @XmlElement
   private Integer a058tipproyct;

    public Integer getA058tipproyct() {
        return a058tipproyct;
    }

    public void setA058tipproyct(Integer a058tipproyct) {
        this.a058tipproyct = a058tipproyct;
    }
}
