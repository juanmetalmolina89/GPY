package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IPoliticaFAC;
import gov.mads.gestor.gpy.modelo.impl.PoliticaDAO;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;

/**
 *
 * @author Ivan Chacon
 */
public class PoliticaFAC implements IPoliticaFAC { 

	private final PoliticaDAO politicaDAO = new PoliticaDAO();

	public ObjetoSalida registrarPolitica(RegistrarPoliticaOE objetoEntrada) {
		return politicaDAO.registrarPolitica(objetoEntrada);
	}
        // Faltantes
        public ObjetoSalida consultarPoliticaPorId(ConsultarPoliticaPorIdOE OE) {
                return politicaDAO.consultarPoliticaPorId(OE);
        }

        public ObjetoSalida actualizarPolitica(ActualizarPoliticaOE OE) {
                return politicaDAO.actualizarPolitica(OE);
        }

        public ObjetoSalida eliminarPolitica(EliminarPoliticaOE OE) {
                return politicaDAO.eliminarPolitica(OE);
        }

        
        public ObjetoSalida listarPoliticasProyecto(ListarPoliticasProyectoOE OE) {
                return politicaDAO.listarPoliticasProyecto(OE);
        }

}
