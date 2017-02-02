package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
import gov.mads.gestor.gpy.vista.ListarFuentesProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IFuentesFAC { 

	public ObjetoSalida registrarFuente(RegistrarFuenteOE registarFuenteOE);
	public ObjetoSalida actualizarFuente(ActualizarFuenteOE actualizarFuenteOE);
	public ObjetoSalida eliminarFuente(EliminarFuenteOE eliminarFuenteOE);
        // Ajuste
        public ObjetoSalida consultarFuentePorId(ConsultarFuentePorIdOE OE);
        public ObjetoSalida listarFuentesPorProyecto(ListarFuentesProyectoOE OE);
}
