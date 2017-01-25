package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Proyecto;
import gov.mads.gestor.comun.entidades.Politica;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarConsideracOE extends ObjetoEntrada {

	@XmlElement
	private Proyecto proyecto;
	@XmlElement
	private Politica politica;


	public Proyecto getProyecto(){
		return this.proyecto;
	}

	public void setProyecto(Proyecto in){
		this.proyecto = in;
	}
	public Politica getPolitica(){
		return this.politica;
	}

	public void setPolitica(Politica in){
		this.politica = in;
	}

}
