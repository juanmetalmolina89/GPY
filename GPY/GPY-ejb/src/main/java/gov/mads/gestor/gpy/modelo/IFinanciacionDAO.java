package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ActualizarFinancOE;
import gov.mads.gestor.gpy.vista.EliminarFtesFinancOE;
import gov.mads.gestor.gpy.vista.EliminarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.ListarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.ListarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ListarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.RegistrarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarInstrmntFinnccnPOE;

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
        
        ObjetoSalida registrarInstrmntFinnccnP(RegistrarInstrmntFinnccnPOE registrarFtesFinancOE);
        ObjetoSalida listarInstrmntFinnccnP(ListarInstrmntFinnccnPOE OE);
        ObjetoSalida eliminarInstrmntFinnccnP(EliminarInstrmntFinnccnPOE OE);        
                
}
