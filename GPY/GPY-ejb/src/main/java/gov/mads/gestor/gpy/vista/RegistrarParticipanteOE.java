package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Persona;
import gov.mads.gestor.comun.entidades.Participante;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarParticipanteOE extends ObjetoEntrada {

	@XmlElement
	private Persona persona;
	@XmlElement
	private Participante participante;


	public Persona getPersona(){
		return this.persona;
	}

	public void setPersona(Persona in){
		this.persona = in;
	}
	public Participante getParticipante(){
		return this.participante;
	}

	public void setParticipante(Participante in){
		this.participante = in;
	}

}
