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

import gov.mads.gestor.gpy.fachada.impl.PoliticaFAC;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/politica")
public class PoliticaSERV { 

	@POST
	@Path("/registrarPolitica")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarPolitica(RegistrarPoliticaOE objetoEntrada) {
		PoliticaFAC fac = new PoliticaFAC();
		ObjetoSalida os = fac.registrarPolitica(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/consultarPoliticaPorId")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarPoliticaPorId(ConsultarPoliticaPorIdOE objetoEntrada) {
		PoliticaFAC fac = new PoliticaFAC();
		ObjetoSalida os = fac.consultarPoliticaPorId(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/actualizarPolitica")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarPolitica(ActualizarPoliticaOE objetoEntrada) {
		PoliticaFAC fac = new PoliticaFAC();
		ObjetoSalida os = fac.actualizarPolitica(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/eliminarPolitica")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarPolitica(EliminarPoliticaOE objetoEntrada) {
		PoliticaFAC fac = new PoliticaFAC();
		ObjetoSalida os = fac.eliminarPolitica(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarPoliticaProyecto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarPoliticasProyecto(ListarPoliticasProyectoOE objetoEntrada) {
		PoliticaFAC fac = new PoliticaFAC();
		ObjetoSalida os = fac.listarPoliticasProyecto(objetoEntrada);
		return API.retornarRespuesta(os);
	}
}
