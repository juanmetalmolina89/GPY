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
    private Integer anio;
    @XmlElement
    private Integer a001codigo;
    @XmlElement
    private Integer a103codigo;
    @XmlElement
    private String nombrePlantilla;
    
    public ReporteOE(Integer anio, Integer a001codigo, Integer a103codigo,Integer idUsuario){
        this.anio = anio;
        this.a001codigo = a001codigo;
        this.a103codigo = a103codigo;
        this.setIdUsuario(idUsuario);
    }
    
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getA001codigo() {
        return a001codigo;
    }

    public void setA001codigo(Integer a001codigo) {
        this.a001codigo = a001codigo;
    }

    public Integer getA103codigo() {
        return a103codigo;
    }

    public void setA103codigo(Integer a103codigo) {
        this.a103codigo = a103codigo;
    }

    public String getNombrePlantilla() {
        return nombrePlantilla;
    }

    public void setNombrePlantilla(String nombrePlantilla) {
        this.nombrePlantilla = nombrePlantilla;
    }

    
}
