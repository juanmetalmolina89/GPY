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

import gov.mads.gestor.gpy.fachada.impl.UtlListadosFAC;
import gov.mads.gestor.gpy.vista.ListarParticipantesOE;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/utlListados")
public class UtlListadosSERV { 

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

}
