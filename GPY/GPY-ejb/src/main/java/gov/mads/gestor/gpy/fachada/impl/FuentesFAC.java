package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IFuentesFAC;
import gov.mads.gestor.gpy.modelo.impl.FuentesDAO;
import gov.mads.gestor.gpy.vista.RegistrarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
import gov.mads.gestor.gpy.vista.ListarFuentesProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public class FuentesFAC implements IFuentesFAC { 

	private final FuentesDAO fuentesDAO = new FuentesDAO();

	public ObjetoSalida registrarFuente(RegistrarFuenteOE objetoEntrada) {
		return fuentesDAO.registrarFuente(objetoEntrada);
	}

	public ObjetoSalida actualizarFuente(ActualizarFuenteOE objetoEntrada) {
		return fuentesDAO.actualizarFuente(objetoEntrada);
	}

	public ObjetoSalida eliminarFuente(EliminarFuenteOE objetoEntrada) {
		return fuentesDAO.eliminarFuente(objetoEntrada);
	}

   
        public ObjetoSalida consultarFuentePorId(ConsultarFuentePorIdOE OE) {
                return fuentesDAO.consultarFuente(OE);
        }
        
        public ObjetoSalida listarFuentesPorProyecto(ListarFuentesProyectoOE OE) {
                return fuentesDAO.listarFuentesPorProyecto(OE);
        }
}
