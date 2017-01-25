package gov.mads.gestor.gpy.servicio;


import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;

import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.gpy.fachada.impl.ActividadFAC;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gov.mads.gestor.gpy.fachada.impl.DatosMdlFAC;
import gov.mads.gestor.gpy.vista.ActualizarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ActualizarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ConsultarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ConsultarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.ListarAdjuntosOE;
import gov.mads.gestor.gpy.vista.RegistrarConsideracOE;
import gov.mads.gestor.gpy.vista.RegistrarCartaNObjOE;
import java.io.File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/datosMdl")
public class DatosMdlSERV { 

	@POST
	@Path("/registrarConsiderac")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarConsiderac(RegistrarConsideracOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.registrarConsiderac(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/registrarCartaNObj")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarCartaNObj(RegistrarCartaNObjOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.registrarCartaNObj(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/consultarConsiderac")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarConsiderac(ConsultarConsideracOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.consultarConsiderac(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/consultarCartaNObj")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarCartaNObj(ConsultarCartaNObjOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.consultarCartaNObj(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
        @Path("/registrarAdjunto")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces({ MediaType.APPLICATION_JSON})
        @JWT
        public Response registrarAdjunto (MultipartFormDataInput OE) {
               DatosMdlFAC fac = new DatosMdlFAC();
               ObjetoSalida objetoSalida = fac.registrarAdjunto(OE);
               return API.retornarRespuesta(objetoSalida);
        }
        
        @POST
	@Path("/consultarAdjunto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces("application/pdf")
	@JWT
	public Response consultarAdjunto(ConsultarAdjuntoOE objetoEntrada) {
		/*DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.consultarAdjunto(objetoEntrada);
		return API.retornarRespuesta(os);*/
            try {
                    DatosMdlFAC fac = new DatosMdlFAC();
                    File adjunto = fac.consultarAdjunto(objetoEntrada);
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
	}
        
        @POST
	@Path("/listarAdjuntos")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarAdjunto(ListarAdjuntosOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.listarAdjuntos(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/actualizarConsiderac")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarConsiderac(ActualizarConsideracOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.actualizarConsiderac(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarCartaNObj")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarCartaNObj(ActualizarCartaNObjOE objetoEntrada) {
		DatosMdlFAC fac = new DatosMdlFAC();
		ObjetoSalida os = fac.actualizarCartaNObj(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
        @Path("/actualizarAdjunto")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces({ MediaType.APPLICATION_JSON})
        @JWT
        public Response actualizarAdjunto (MultipartFormDataInput OE) {
               DatosMdlFAC fac = new DatosMdlFAC();
               ObjetoSalida objetoSalida = fac.actualizarAdjunto(OE);
               return API.retornarRespuesta(objetoSalida);
        }
}
