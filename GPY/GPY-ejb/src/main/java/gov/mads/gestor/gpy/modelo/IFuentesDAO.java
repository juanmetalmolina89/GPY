package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarEscenarioBaseOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
import gov.mads.gestor.gpy.vista.ListarEscenarioBaseOE;
import gov.mads.gestor.gpy.vista.ListarFuentesProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarEscenarioBaseOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IFuentesDAO { 

	ObjetoSalida registrarFuente(RegistrarFuenteOE registarFuenteOE);
	ObjetoSalida actualizarFuente(ActualizarFuenteOE actualizarFuenteOE);
	ObjetoSalida eliminarFuente(EliminarFuenteOE eliminarFuenteOE);
        // Ajuste
        ObjetoSalida consultarFuentePorId(ConsultarFuentePorIdOE consultarFuentePorIdOE);
        ObjetoSalida listarFuentesPorProyecto(ListarFuentesProyectoOE OE);
        ObjetoSalida registrarEscenarioBase(RegistrarEscenarioBaseOE OE);
        ObjetoSalida eliminarEscenarioBase(EliminarEscenarioBaseOE OE);
        ObjetoSalida listarEscenarioBase(ListarEscenarioBaseOE OE);
}
