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

import gov.mads.gestor.gpy.fachada.impl.FuentesFAC;
import gov.mads.gestor.gpy.vista.RegistrarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarEscenarioBaseOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
import gov.mads.gestor.gpy.vista.ListarEscenarioBaseOE;
import gov.mads.gestor.gpy.vista.ListarFuentesProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarEscenarioBaseOE;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/fuentes")
public class FuentesSERV { 

	@POST
	@Path("/registrarFuente")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarFuente(RegistrarFuenteOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.registrarFuente(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarFuente")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarFuente(ActualizarFuenteOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.actualizarFuente(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/eliminarFuente")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarFuente(EliminarFuenteOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.eliminarFuente(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/consultarFuente")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarFuente(ConsultarFuentePorIdOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.consultarFuentePorId(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarFuenteProyecto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarFuentesPorProyecto(ListarFuentesProyectoOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.listarFuentesPorProyecto(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/registrarEscenarioBase")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarEscenarioBase(RegistrarEscenarioBaseOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.registrarEscenarioBase(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/eliminarEscenarioBase")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarEscenarioBase(EliminarEscenarioBaseOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.eliminarEscenarioBase(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarEscenarioBase")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarEscenarioBase(ListarEscenarioBaseOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.listarEscenarioBase(objetoEntrada);
		return API.retornarRespuesta(os);
	}
}
