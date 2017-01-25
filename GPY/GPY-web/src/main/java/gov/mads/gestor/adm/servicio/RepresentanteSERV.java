/*
 * Servicios de representante
 */
package gov.mads.gestor.adm.servicio;

/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.adm.fachada.impl.RepresentanteFAC;
import gov.mads.gestor.adm.vista.RegistrarRepresentanteOE;
import gov.mads.gestor.adm.vista.ConsultarRepresentantePorIdOE;
import gov.mads.gestor.adm.vista.ActualizarRepresentanteOE;
import gov.mads.gestor.gpy.vista.AdjuntarDocumentoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.gpy.vista.ConsultarDocumentoPorIdOE;
import java.io.File;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;


@Path("/representante")
public class RepresentanteSERV {

    @POST
    @Path("/registrarRepresentante")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarRepresentante (RegistrarRepresentanteOE OE) {

        RepresentanteFAC fac = new RepresentanteFAC();
        ObjetoSalida objetoSalida = fac.registrarRepresentante(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/consultarRepresentantePorId")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarrepresentanteporid (ConsultarRepresentantePorIdOE OE) {

        RepresentanteFAC fac = new RepresentanteFAC();
        ObjetoSalida objetoSalida = fac.consultarRepresentantePorId(OE);
        return API.retornarRespuesta(objetoSalida);
    }

    @POST
    @Path("/actualizarRepresentante")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response actualizarRepresentante (ActualizarRepresentanteOE OE) {

        RepresentanteFAC fac = new RepresentanteFAC();
        ObjetoSalida objetoSalida = fac.actualizarRepresentante(OE);
        return API.retornarRespuesta(objetoSalida);
    }  
    /**
     * @todo Revisar la funcionalidad del webservice
     * @param adjuntardocumentoOE
     * @return 
     */
    @POST
    @Path("/adjuntarDocumento")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response adjuntardocumento (MultipartFormDataInput OE) {

        RepresentanteFAC fac = new RepresentanteFAC();
        ObjetoSalida objetoSalida = fac.adjuntarDocumento(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/actualizarDocumento")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response actualizardocumento (MultipartFormDataInput OE) {

        RepresentanteFAC fac = new RepresentanteFAC();
        ObjetoSalida objetoSalida = fac.actualizarDocumento(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
    @POST
    @Path("/consultarDocumento")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/pdf")
    @JWT
    public Response consultardocumento (ConsultarDocumentoPorIdOE OE) {
        try {
            RepresentanteFAC fac = new RepresentanteFAC();
            File adjunto = fac.consultarDocumentoPorId(OE);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(adjunto);
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }catch(Exception ex){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //return API.retornarRespuesta(objetoSalida);
    }
}