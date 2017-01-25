/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.servicio;

import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.adm.fachada.impl.ContactoFAC;
import gov.mads.gestor.adm.vista.RegistrarContactoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.adm.vista.ActualizarContactoOE;
import gov.mads.gestor.adm.vista.ConsultarContactoPorIdOE;
import gov.mads.gestor.utl.fachada.impl.ConsultarPorFiltroFAC;
import gov.mads.gestor.utl.vista.ConsultarDivipolaPorIdOE;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Juan Molina
 */
@Path("/consultar")
public class ConsultarPorFiltroSERV {
    @POST
    //@GET
    @Path("/divipolas")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarDivipolaPorId (ConsultarDivipolaPorIdOE OE) {
        ConsultarPorFiltroFAC fac = new ConsultarPorFiltroFAC();
        ObjetoSalida objetoSalida = fac.consultarDivipolaPorId(OE);
        return API.retornarRespuesta(objetoSalida);
    }
}
