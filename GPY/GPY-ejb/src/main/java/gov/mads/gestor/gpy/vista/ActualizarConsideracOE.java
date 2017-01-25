/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.Politica;
import gov.mads.gestor.comun.entidades.Proyecto;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ActualizarConsideracOE extends ObjetoEntrada{
    	@XmlElement
	private Proyecto proyecto;
	@XmlElement
	private Politica politica;

        public Proyecto getProyecto() {
            return proyecto;
        }

        public void setProyecto(Proyecto proyecto) {
            this.proyecto = proyecto;
        }

        public Politica getPolitica() {
            return politica;
        }

    public void setPolitica(Politica politica) {
        this.politica = politica;
    }
        
}
