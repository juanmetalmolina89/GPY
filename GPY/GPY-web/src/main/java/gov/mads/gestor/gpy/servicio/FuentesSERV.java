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
import gov.mads.gestor.gpy.vista.RegistarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
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
	public Response registarFuente(RegistarFuenteOE objetoEntrada) {
		FuentesFAC fac = new FuentesFAC();
		ObjetoSalida os = fac.registarFuente(objetoEntrada);
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
}
