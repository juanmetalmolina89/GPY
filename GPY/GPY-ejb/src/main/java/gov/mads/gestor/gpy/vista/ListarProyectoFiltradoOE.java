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
public class ListarProyectoFiltradoOE extends ObjetoEntrada{
    @XmlElement
    private Integer a041codigo;
    @XmlElement
    private String filtro;

    public Integer getA041codigo() {
        return a041codigo;
    }

    public void setA041codigo(Integer a041codigo) {
        this.a041codigo = a041codigo;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
}
