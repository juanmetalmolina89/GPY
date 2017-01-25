package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarGeometriaOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
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

}
