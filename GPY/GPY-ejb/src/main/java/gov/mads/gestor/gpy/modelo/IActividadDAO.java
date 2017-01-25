package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarGeometriaOE;
import gov.mads.gestor.gpy.vista.ActualizarSoporteOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IActividadDAO { 

	ObjetoSalida registrarActividad(RegistrarActividadOE registrarActividadOE);
	ObjetoSalida actualizarActividad(ActualizarActividadOE actualizarActividadOE);
	ObjetoSalida eliminarActividad(EliminarActividadOE eliminarActividadOE);
         // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        ObjetoSalida consultarActividadPorId(ConsultarActividadPorIdOE OE);
        ObjetoSalida registrarSoporte(RegistrarSoporteOE OE);
        ObjetoSalida actualizarSoporte(ActualizarSoporteOE OE);
        ObjetoSalida consultarSoportePorId(ConsultarSoportePorIdOE OE);
        ObjetoSalida registrarGeometria(RegistrarGeometriaOE OE);
        ObjetoSalida actualizarGeometria(ActualizarGeometriaOE OE);
        ObjetoSalida consultarGeometriaPorId(ConsultarGeometriaPorIdOE OE);
        ObjetoSalida listarActividades(ListarActividadesOE OE);
}
