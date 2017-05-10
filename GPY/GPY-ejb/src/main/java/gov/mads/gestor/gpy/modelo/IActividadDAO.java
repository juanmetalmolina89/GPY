package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarGeometriaOE;
import gov.mads.gestor.gpy.vista.ActualizarIndicadorOE;
import gov.mads.gestor.gpy.vista.ActualizarMetaOE;
import gov.mads.gestor.gpy.vista.ActualizarSoporteOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadFechaOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarIndicadorOE;
import gov.mads.gestor.gpy.vista.ConsultarMetaOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.EliminarIndicadorOE;
import gov.mads.gestor.gpy.vista.EliminarMetaOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.RegistrarIndicadorOE;
import gov.mads.gestor.gpy.vista.RegistrarMetaOE;

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
        
        ObjetoSalida registrarIndicador(RegistrarIndicadorOE OE);
        ObjetoSalida eliminarIndicador(EliminarIndicadorOE OE);
        ObjetoSalida actualizarIndicador(ActualizarIndicadorOE OE);
        ObjetoSalida consultarIndicador(ConsultarIndicadorOE OE);
        ObjetoSalida registrarMeta(RegistrarMetaOE OE);
        ObjetoSalida eliminarMeta(EliminarMetaOE OE);
        ObjetoSalida actualizarMeta(ActualizarMetaOE OE);
        ObjetoSalida consultarMeta(ConsultarMetaOE OE);
        
        ObjetoSalida consultarActividadFechaOE(ConsultarActividadFechaOE OE);
}
