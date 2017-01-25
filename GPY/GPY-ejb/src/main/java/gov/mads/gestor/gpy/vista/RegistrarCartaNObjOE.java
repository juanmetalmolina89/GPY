package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Proyecto;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarCartaNObjOE extends ObjetoEntrada {

	@XmlElement
	private Proyecto proyecto;


	public Proyecto getProyecto(){
		return this.proyecto;
	}

	public void setProyecto(Proyecto in){
		this.proyecto = in;
	}

}
