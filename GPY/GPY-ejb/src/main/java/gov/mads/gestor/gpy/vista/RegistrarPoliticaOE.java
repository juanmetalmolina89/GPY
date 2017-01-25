package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Politica;
import gov.mads.gestor.comun.entidades.ProyPolitica;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarPoliticaOE extends ObjetoEntrada {

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
