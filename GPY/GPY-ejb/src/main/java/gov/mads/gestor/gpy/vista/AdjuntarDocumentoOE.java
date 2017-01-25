/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement

public class AdjuntarDocumentoOE extends ObjetoEntrada {

    @XmlElement
    private Integer a053codigo;
    @XmlElement
    private Archivo adjuntarArchivo;

    public Archivo getAdjuntarArchivo() {
        return adjuntarArchivo;
    }

    public void setAdjuntarArchivo(Archivo adjuntarArchivo) {
        this.adjuntarArchivo = adjuntarArchivo;
    }

    public Integer getA053codigo() {
        return a053codigo;
    }

    public void setA053codigo(Integer a053codigo) {
        this.a053codigo = a053codigo;
    }
    
}
