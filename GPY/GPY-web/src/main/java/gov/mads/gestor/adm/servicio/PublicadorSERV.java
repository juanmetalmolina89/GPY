/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.servicio;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.adm.fachada.impl.PublicadorFAC;
import gov.mads.gestor.adm.vista.RegistrarPublicadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.adm.vista.ActualizarPublicadorOE;
import gov.mads.gestor.adm.vista.ConsultarPublicadorPorIdOE;

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
@Path("/publicador")
public class PublicadorSERV {
    @POST
    @Path("/registrarPublicador")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarPublicador (RegistrarPublicadorOE OE) {

        PublicadorFAC fac = new PublicadorFAC();
        ObjetoSalida objetoSalida = fac.registrarPublicador(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/consultarPublicadorPorId")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarPublicadorPorId(ConsultarPublicadorPorIdOE OE) {

        PublicadorFAC fac = new PublicadorFAC();
        ObjetoSalida objetoSalida = fac.consultarPublicadorPorId(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/actualizarPublicador")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response actualizarPublicador(ActualizarPublicadorOE OE) {

        PublicadorFAC fac = new PublicadorFAC();
        ObjetoSalida objetoSalida = fac.actualizarPublicador(OE);
        return API.retornarRespuesta(objetoSalida);
    }
}
