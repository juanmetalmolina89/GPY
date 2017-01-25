/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.Politica;
import gov.mads.gestor.comun.entidades.ProyPolitica;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ActualizarPoliticaOE extends ObjetoEntrada{
        @XmlElement
	private Politica politica;
        @XmlElement
        private ProyPolitica proypolitica;

	public Politica getPolitica(){
		return this.politica;
	}

	public void setPolitica(Politica in){
		this.politica = in;
	}

        public ProyPolitica getProypolitica() {
            return proypolitica;
        }

        public void setProypolitica(ProyPolitica proypolitica) {
            this.proypolitica = proypolitica;
        }
}
