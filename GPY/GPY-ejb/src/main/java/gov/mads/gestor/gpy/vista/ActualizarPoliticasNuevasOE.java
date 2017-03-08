/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.ProyPoliticasP;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ActualizarPoliticasNuevasOE extends ObjetoEntrada{
    @XmlElement
    private ProyPoliticasP politica;

    public ProyPoliticasP getPolitica() {
        return politica;
    }

    public void setPolitica(ProyPoliticasP politica) {
        this.politica = politica;
    }
            
}
