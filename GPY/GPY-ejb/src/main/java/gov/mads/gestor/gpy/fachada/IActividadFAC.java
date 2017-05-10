package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarGeometriaOE;
import gov.mads.gestor.gpy.vista.ActualizarIndicadorOE;
import gov.mads.gestor.gpy.vista.ActualizarMetaOE;
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
import java.io.File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Ivan Chacon
 */
public interface IActividadFAC { 

	public ObjetoSalida registrarActividad(RegistrarActividadOE registrarActividadOE);
	public ObjetoSalida actualizarActividad(ActualizarActividadOE actualizarActividadOE);
	public ObjetoSalida eliminarActividad(EliminarActividadOE eliminarActividadOE);
        // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        public ObjetoSalida consultarActividadPorId(ConsultarActividadPorIdOE OE);
        public ObjetoSalida registrarSoporte(MultipartFormDataInput OE);
        public ObjetoSalida actualizarSoporte(MultipartFormDataInput OE);
        public File consultarSoportePorId(ConsultarSoportePorIdOE OE);
        public ObjetoSalida registrarGeometria(RegistrarGeometriaOE OE);
        public ObjetoSalida actualizarGeometria(ActualizarGeometriaOE OE);
        public ObjetoSalida consultarGeometriaPorId(ConsultarGeometriaPorIdOE OE);
        public ObjetoSalida listarActividades(ListarActividadesOE OE);
        
        public ObjetoSalida registrarIndicador(RegistrarIndicadorOE OE);
        public ObjetoSalida eliminarIndicador(EliminarIndicadorOE OE);
        public ObjetoSalida actualizarIndicador(ActualizarIndicadorOE OE);
        public ObjetoSalida consultarIndicador(ConsultarIndicadorOE OE);
        public ObjetoSalida registrarMeta(RegistrarMetaOE OE);
        public ObjetoSalida eliminarMeta(EliminarMetaOE OE);
        public ObjetoSalida actualizarMeta(ActualizarMetaOE OE);
        public ObjetoSalida consultarMeta(ConsultarMetaOE OE);
        
        public ObjetoSalida consultarActividadFechaOE(ConsultarActividadFechaOE OE) throws Exception;

}
