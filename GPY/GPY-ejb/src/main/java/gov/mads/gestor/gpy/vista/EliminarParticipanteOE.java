package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Participante;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class EliminarParticipanteOE extends ObjetoEntrada {

	@XmlElement
	private Participante participante;


	public Participante getParticipante(){
		return this.participante;
	}

	public void setParticipante(Participante in){
		this.participante = in;
	}

}
