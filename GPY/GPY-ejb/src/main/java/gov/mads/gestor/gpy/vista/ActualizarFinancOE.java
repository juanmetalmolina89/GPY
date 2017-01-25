package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.ProyFteFinanc;
import gov.mads.gestor.comun.entidades.Proyecto;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class ActualizarFinancOE extends ObjetoEntrada {

	@XmlElement
	private ProyFteFinanc proyFteFinanc;
	@XmlElement
	private Proyecto proyecto;


	public ProyFteFinanc getProyFteFinanc(){
		return this.proyFteFinanc;
	}

	public void setProyFteFinanc(ProyFteFinanc in){
		this.proyFteFinanc = in;
	}
	public Proyecto getProyecto(){
		return this.proyecto;
	}

	public void setProyecto(Proyecto in){
		this.proyecto = in;
	}

}
