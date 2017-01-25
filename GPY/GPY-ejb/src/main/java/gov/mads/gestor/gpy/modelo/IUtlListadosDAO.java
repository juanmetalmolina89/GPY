package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ListarParticipantesOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IUtlListadosDAO { 

	ObjetoSalida listarParticipantes(ListarParticipantesOE listarParticipantesOE);

}
