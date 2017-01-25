/*
 * Interfaz de la Fachada de Representante  
 *
 */
package gov.mads.gestor.adm.fachada;
import gov.mads.gestor.adm.vista.RegistrarRepresentanteOE;
import gov.mads.gestor.adm.vista.ConsultarRepresentantePorIdOE;
import gov.mads.gestor.adm.vista.ActualizarRepresentanteOE;
import gov.mads.gestor.gpy.vista.AdjuntarDocumentoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ConsultarDocumentoPorIdOE;
import java.io.File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
/**
 *
 * @author juanmetalmolina
 */
public interface IRepresentanteFAC {
    public ObjetoSalida registrarRepresentante(RegistrarRepresentanteOE OE);
    public ObjetoSalida consultarRepresentantePorId(ConsultarRepresentantePorIdOE OE);
    public ObjetoSalida actualizarRepresentante(ActualizarRepresentanteOE OE);
    public ObjetoSalida adjuntarDocumento(MultipartFormDataInput OE);
    public ObjetoSalida actualizarDocumento(MultipartFormDataInput OE);
    public File consultarDocumentoPorId(ConsultarDocumentoPorIdOE OE);
    
}
