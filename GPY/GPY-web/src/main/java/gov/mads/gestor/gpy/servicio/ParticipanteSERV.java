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

import gov.mads.gestor.gpy.fachada.impl.ParticipanteFAC;
import gov.mads.gestor.gpy.fachada.impl.UtlListadosFAC;
import gov.mads.gestor.gpy.vista.RegistrarParticipanteOE;
import gov.mads.gestor.gpy.vista.ActualizarParticipanteOE;
import gov.mads.gestor.gpy.vista.ConsultarParticipanteOE;
import gov.mads.gestor.gpy.vista.EliminarParticipanteOE;
import gov.mads.gestor.gpy.vista.ListarParticipanteProyectoOE;
import gov.mads.gestor.gpy.vista.ListarParticipantesOE;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/participante")
public class ParticipanteSERV { 

	@POST
	@Path("/registrarParticipante")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarParticipante(RegistrarParticipanteOE objetoEntrada) {
		ParticipanteFAC fac = new ParticipanteFAC();
		ObjetoSalida os = fac.registrarParticipante(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarParticipante")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarParticipante(ActualizarParticipanteOE objetoEntrada) {
		ParticipanteFAC fac = new ParticipanteFAC();
		ObjetoSalida os = fac.actualizarParticipante(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/eliminarParticipante")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarParticipante(EliminarParticipanteOE objetoEntrada) {
		ParticipanteFAC fac = new ParticipanteFAC();
		ObjetoSalida os = fac.eliminarParticipante(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        
	@POST
	@Path("/listarParticipantes")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarParticipantes(ListarParticipantesOE objetoEntrada) {
		UtlListadosFAC fac = new UtlListadosFAC();
		ObjetoSalida os = fac.listarParticipantes(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/consultarParticipante")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarParticipantes(ConsultarParticipanteOE objetoEntrada) {
		ParticipanteFAC fac = new ParticipanteFAC();
		ObjetoSalida os = fac.consultarParticipante(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        @POST
	@Path("/listarParticipantesProyecto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarParticipantesProyecto(ListarParticipanteProyectoOE objetoEntrada) {
		ParticipanteFAC fac = new ParticipanteFAC();
		ObjetoSalida os = fac.listarParticipantesProyecto(objetoEntrada);
		return API.retornarRespuesta(os);
	}

}
