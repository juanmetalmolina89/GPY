package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IUtlListadosFAC;
import gov.mads.gestor.gpy.modelo.impl.UtlListadosDAO;
import gov.mads.gestor.gpy.vista.ListarParticipantesOE;

/**
 *
 * @author Ivan Chacon
 */
public class UtlListadosFAC implements IUtlListadosFAC { 

	private final UtlListadosDAO utlListadosDAO = new UtlListadosDAO();

	public ObjetoSalida listarParticipantes(ListarParticipantesOE objetoEntrada) {
		return utlListadosDAO.listarParticipantes(objetoEntrada);
	}

}
