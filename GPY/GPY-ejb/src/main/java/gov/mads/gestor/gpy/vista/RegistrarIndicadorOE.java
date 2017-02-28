/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.comun.entidades.Indicador;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrarIndicadorOE  extends ObjetoEntrada {

    @XmlElement
    private Indicador  indicador;

    public Indicador getIndicador () {
       return indicador;
    }

    public void setIndicador (Indicador indicador) {
        this. indicador = indicador;
    }
} 
