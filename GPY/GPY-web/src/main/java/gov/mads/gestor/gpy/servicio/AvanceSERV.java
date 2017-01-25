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

import gov.mads.gestor.gpy.fachada.impl.AvanceFAC;
import gov.mads.gestor.gpy.vista.ActualizarAvanceOE;
import gov.mads.gestor.gpy.vista.ConsultarAvanceOE;
import gov.mads.gestor.gpy.vista.RegistrarAvanceOE;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/avance")
public class AvanceSERV { 

	@POST
	@Path("/registrarAvance")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarAvance(RegistrarAvanceOE objetoEntrada) {
		AvanceFAC fac = new AvanceFAC();
		ObjetoSalida os = fac.registrarAvance(objetoEntrada);
		return API.retornarRespuesta(os);
	}
	@POST
	@Path("/consultarAvance")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarAvance(ConsultarAvanceOE objetoEntrada) {
		AvanceFAC fac = new AvanceFAC();
		ObjetoSalida os = fac.consultarAvance(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        @POST
	@Path("/actualizarAvance")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarAvance(ActualizarAvanceOE objetoEntrada) {
		AvanceFAC fac = new AvanceFAC();
		ObjetoSalida os = fac.actualizarAvance(objetoEntrada);
		return API.retornarRespuesta(os);
	}

}
