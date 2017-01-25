package gov.mads.gestor.gpy.fachada;
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
public interface IParticipanteFAC { 

	public ObjetoSalida registrarParticipante(RegistrarParticipanteOE registrarParticipanteOE);
	public ObjetoSalida actualizarParticipante(ActualizarParticipanteOE actualizarParticipanteOE);
	public ObjetoSalida eliminarParticipante(EliminarParticipanteOE eliminarParticipanteOE);
        // Ajuste 
        public ObjetoSalida consultarParticipante(ConsultarParticipanteOE consultarParticipanteOE);    
        public ObjetoSalida listarParticipantesProyecto(ListarParticipanteProyectoOE OE);
}
