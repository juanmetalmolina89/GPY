package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.ProyFteFinanc;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarFtesFinancOE extends ObjetoEntrada {

	@XmlElement
	private ProyFteFinanc proyFteFinanc;


	public ProyFteFinanc getProyFteFinanc(){
		return this.proyFteFinanc;
	}

	public void setProyFteFinanc(ProyFteFinanc in){
		this.proyFteFinanc = in;
	}

}
