package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IParticipanteFAC;
import gov.mads.gestor.gpy.modelo.impl.ParticipanteDAO;
import gov.mads.gestor.gpy.vista.RegistrarParticipanteOE;
import gov.mads.gestor.gpy.vista.ActualizarParticipanteOE;
import gov.mads.gestor.gpy.vista.ConsultarParticipanteOE;
import gov.mads.gestor.gpy.vista.EliminarParticipanteOE;
import gov.mads.gestor.gpy.vista.ListarParticipanteProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public class ParticipanteFAC implements IParticipanteFAC { 

	private final ParticipanteDAO participanteDAO = new ParticipanteDAO();

	public ObjetoSalida registrarParticipante(RegistrarParticipanteOE objetoEntrada) {
		return participanteDAO.registrarParticipante(objetoEntrada);
	}

	public ObjetoSalida actualizarParticipante(ActualizarParticipanteOE objetoEntrada) {
		return participanteDAO.actualizarParticipante(objetoEntrada);
	}

	public ObjetoSalida eliminarParticipante(EliminarParticipanteOE objetoEntrada) {
		return participanteDAO.eliminarParticipante(objetoEntrada);
	}

        
        public ObjetoSalida consultarParticipante(ConsultarParticipanteOE consultarParticipanteOE) {
                return participanteDAO.consultarParticipante(consultarParticipanteOE);
        }

        @Override
        public ObjetoSalida listarParticipantesProyecto(ListarParticipanteProyectoOE OE) {
                return participanteDAO.listarParticipantesProyecto(OE);
        }

}
