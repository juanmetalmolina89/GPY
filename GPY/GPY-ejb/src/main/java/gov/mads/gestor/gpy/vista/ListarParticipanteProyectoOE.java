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
public class ListarParticipanteProyectoOE extends ObjetoEntrada{
    @XmlElement
    private Integer a051idproyecto;

    public Integer getA051idproyecto() {
        return a051idproyecto;
    }

    public void setA051idproyecto(Integer a051idproyecto) {
        this.a051idproyecto = a051idproyecto;
    }
}
