package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ActualizarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ConsultarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.ListarAdjuntosOE;
import gov.mads.gestor.gpy.vista.RegistrarConsideracOE;
import gov.mads.gestor.gpy.vista.RegistrarCartaNObjOE;
import java.io.File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Ivan Chacon
 */
public interface IDatosMdlFAC { 

	public ObjetoSalida registrarConsiderac(RegistrarConsideracOE registrarConsideracOE);
	public ObjetoSalida registrarCartaNObj(RegistrarCartaNObjOE registrarCartaNObjOE);
        public ObjetoSalida consultarConsiderac(ConsultarConsideracOE OE);
        public ObjetoSalida consultarCartaNObj(ConsultarCartaNObjOE OE);
        public ObjetoSalida registrarAdjunto(MultipartFormDataInput OE);
        public ObjetoSalida consultarAdjunto(ConsultarAdjuntoOE OE);
        public ObjetoSalida listarAdjuntos(ListarAdjuntosOE OE);
        public ObjetoSalida actualizarConsiderac(ActualizarConsideracOE OE);
        public ObjetoSalida actualizarCartaNObj(ActualizarCartaNObjOE OE);
        public ObjetoSalida actualizarAdjunto(MultipartFormDataInput OE);
        public File consultarAdjuntoPorID(ConsultarAdjuntoPorIdOE OE);
}
