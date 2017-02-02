/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.entidades.Politica;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarAdjuntoPoliticaOE extends ObjetoEntrada{
    
    @XmlElement
    private Integer a003codigo;
    @XmlElement
    private Archivo adjuntarArchivo;

    public Integer getA003codigo() {
        return a003codigo;
    }

    public void setA003codigo(Integer a003codigo) {
        this.a003codigo = a003codigo;
    }

    public Archivo getAdjuntarArchivo() {
        return adjuntarArchivo;
    }

    public void setAdjuntarArchivo(Archivo adjuntarArchivo) {
        this.adjuntarArchivo = adjuntarArchivo;
    }
        
}
