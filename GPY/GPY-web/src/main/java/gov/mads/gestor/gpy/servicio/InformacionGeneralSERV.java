/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.servicio;

import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.impl.InformacionGeneralFAC;
import gov.mads.gestor.gpy.vista.ActualizarInfoProyectOE;
import gov.mads.gestor.gpy.vista.ConsultarInfoProyectOE;
import gov.mads.gestor.gpy.vista.RegistrarInfoProyectOE;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author juanmetalmolina
 */
@Path("/infogeneral")
public class InformacionGeneralSERV {
        @POST
	@Path("/registrarInfoGeneral")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarInfoProyect(RegistrarInfoProyectOE objetoEntrada) {
		InformacionGeneralFAC fac = new InformacionGeneralFAC();
		ObjetoSalida os = fac.registrarInfoProyect(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarInfoGeneral")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarInfoProyect(ActualizarInfoProyectOE objetoEntrada) {
		InformacionGeneralFAC fac = new InformacionGeneralFAC();
		ObjetoSalida os = fac.actualizarInfoProyect(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/consultarInfoGeneral")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarInfoProyect(ConsultarInfoProyectOE objetoEntrada) {
		InformacionGeneralFAC fac = new InformacionGeneralFAC();
		ObjetoSalida os = fac.consultarInfoProyect(objetoEntrada);
		return API.retornarRespuesta(os);
	}
}
