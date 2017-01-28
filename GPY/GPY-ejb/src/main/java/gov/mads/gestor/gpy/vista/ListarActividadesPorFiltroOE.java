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
public class ListarActividadesPorFiltroOE extends ObjetoEntrada{
    @XmlElement
    private Integer a005idproyecto;
    @XmlElement
    private String filtro;

    public Integer getA005idproyecto() {
        return a005idproyecto;
    }

    public void setA005idproyecto(Integer a005idproyecto) {
        this.a005idproyecto = a005idproyecto;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
