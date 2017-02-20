/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ReporteOE extends ObjetoEntrada{
    @XmlElement
    private Integer idReporte;
    @XmlElement
    private List<Long> listaProyectos;
    @XmlElement
    private Long idproyecto;

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public List<Long> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(List<Long> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Long getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Long idproyecto) {
        this.idproyecto = idproyecto;
    }
    
}
