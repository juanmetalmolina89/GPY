package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ActualizarFinancOE;
import gov.mads.gestor.gpy.vista.EliminarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ListarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.ListarFtesFinancOE;
import gov.mads.gestor.gpy.vista.RegistrarCostosProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IFinanciacionFAC { 

	public ObjetoSalida registrarFtesFinanc(RegistrarFtesFinancOE registrarFtesFinancOE);
	public ObjetoSalida actualizarFinanc(ActualizarFinancOE actualizarFinancOE);
        // Ajuste
        public ObjetoSalida registrarCostosProyecto(RegistrarCostosProyectoOE OE);
        public ObjetoSalida listarCostosProyecto(ListarCostosProyectoOE OE);
        public ObjetoSalida listarFtesFinanc(ListarFtesFinancOE OE);
        public ObjetoSalida eliminarFtesFinanc(EliminarFtesFinancOE OE);

}
