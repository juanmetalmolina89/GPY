package gov.mads.gestor.gpy.modelo;
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
public interface IFinanciacionDAO { 

	ObjetoSalida registrarFtesFinanc(RegistrarFtesFinancOE registrarFtesFinancOE);
	ObjetoSalida actualizarFinanc(ActualizarFinancOE actualizarFinancOE);
        // Ajuste
        ObjetoSalida registrarCostosProyecto(RegistrarCostosProyectoOE OE);
        ObjetoSalida listarCostosProyecto(ListarCostosProyectoOE OE);
        ObjetoSalida listarFtesFinanc(ListarFtesFinancOE OE);
        ObjetoSalida eliminarFtesFinanc(EliminarFtesFinancOE OE);
}
