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
public class CambiarEstadoProyectoOE extends ObjetoEntrada{
    @XmlElement
    private Integer a002codigo;
    @XmlElement
    private Integer estadoproyecto;

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

    public Integer getEstadoproyecto() {
        return estadoproyecto;
    }

    public void setEstadoproyecto(Integer estadoproyecto) {
        this.estadoproyecto = estadoproyecto;
    }
    
}
