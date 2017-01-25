package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Actividad;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class EliminarActividadOE extends ObjetoEntrada {

	@XmlElement
	private Actividad actividad;


	public Actividad getActividad(){
		return this.actividad;
	}

	public void setActividad(Actividad in){
		this.actividad = in;
	}

}
