package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Fuente;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class EliminarFuenteOE extends ObjetoEntrada {

	@XmlElement
	private Fuente fuente;


	public Fuente getFuente(){
		return this.fuente;
	}

	public void setFuente(Fuente in){
		this.fuente = in;
	}

}
