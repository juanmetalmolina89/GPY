package gov.mads.gestor.gpy.servicio;


import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;

import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gov.mads.gestor.gpy.fachada.impl.ActividadFAC;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
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
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.RegistrarIndicadorOE;
import gov.mads.gestor.gpy.vista.RegistrarMetaOE;
import java.io.File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/actividad")
public class ActividadSERV { 

	@POST
	@Path("/registrarActividad")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarActividad(RegistrarActividadOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.registrarActividad(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarActividad")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarActividad(ActualizarActividadOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.actualizarActividad(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/eliminarActividad")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarActividad(EliminarActividadOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.eliminarActividad(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        @POST
	@Path("/consultarActividadPorId")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarActividadPorId(ConsultarActividadPorIdOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.consultarActividadPorId(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
        @Path("/registrarSoporte")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces({ MediaType.APPLICATION_JSON})
        @JWT
        public Response registrarSoporte (MultipartFormDataInput OE) {
               ActividadFAC fac = new ActividadFAC();
               ObjetoSalida objetoSalida = fac.registrarSoporte(OE);
               return API.retornarRespuesta(objetoSalida);
        }
        
        @POST
        @Path("/actualizarSoporte")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces({ MediaType.APPLICATION_JSON})
        @JWT
        public Response actualizarSoporte (MultipartFormDataInput OE) {
               ActividadFAC fac = new ActividadFAC();
               ObjetoSalida objetoSalida = fac.actualizarSoporte(OE);
               return API.retornarRespuesta(objetoSalida);
        }
        
        @POST
	@Path("/consultarSoportePorId")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces("application/pdf")
	@JWT
	public Response consultarSoportePorId(ConsultarSoportePorIdOE objetoEntrada) {
		/*ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.consultarSoportePorId(objetoEntrada);
		return API.retornarRespuesta(os);*/
                try {
                    ActividadFAC fac = new ActividadFAC();
                    File adjunto = fac.consultarSoportePorId(objetoEntrada);
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
	@Path("/consultarGeografia")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarGeografia(ConsultarGeometriaPorIdOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.consultarGeometriaPorId(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarActividades")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarActividades(ListarActividadesOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.listarActividades(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/registrarIndicador")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarIndicador(RegistrarIndicadorOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.registrarIndicador(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarIndicador")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarIndicador(ActualizarIndicadorOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.actualizarIndicador(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/eliminarIndicador")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarIndicador(EliminarIndicadorOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.eliminarIndicador(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        @POST
	@Path("/consultarIndicador")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarIndicador(ConsultarIndicadorOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.consultarIndicador(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/registrarMeta")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarMeta(RegistrarMetaOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.registrarMeta(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("eliminarMeta")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarMeta(EliminarMetaOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.eliminarMeta(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarMeta")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarMeta(ActualizarMetaOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.actualizarMeta(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        @POST
	@Path("/consultarMeta")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarMeta(ConsultarMetaOE objetoEntrada) {
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.consultarMeta(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/consultarActividadFecha")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarActividadFecha(ConsultarActividadFechaOE objetoEntrada) throws Exception{
		ActividadFAC fac = new ActividadFAC();
		ObjetoSalida os = fac.consultarActividadFechaOE(objetoEntrada);
		return API.retornarRespuesta(os);
	}
}
