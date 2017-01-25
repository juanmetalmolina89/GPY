package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarParticipanteOE;
import gov.mads.gestor.gpy.vista.ActualizarParticipanteOE;
import gov.mads.gestor.gpy.vista.ConsultarParticipanteOE;
import gov.mads.gestor.gpy.vista.EliminarParticipanteOE;
import gov.mads.gestor.gpy.vista.ListarParticipanteProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IParticipanteDAO { 

	ObjetoSalida registrarParticipante(RegistrarParticipanteOE registrarParticipanteOE);
	ObjetoSalida actualizarParticipante(ActualizarParticipanteOE actualizarParticipanteOE);
	ObjetoSalida eliminarParticipante(EliminarParticipanteOE eliminarParticipanteOE);
        // Ajuste
        ObjetoSalida consultarParticipante(ConsultarParticipanteOE consultarParticipanteOE);
        ObjetoSalida listarParticipantesProyecto(ListarParticipanteProyectoOE OE);
}
