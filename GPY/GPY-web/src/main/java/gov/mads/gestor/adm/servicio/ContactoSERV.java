/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.servicio;

import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.adm.fachada.impl.ContactoFAC;
import gov.mads.gestor.adm.vista.RegistrarContactoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.adm.vista.ActualizarContactoOE;
import gov.mads.gestor.adm.vista.ConsultarContactoPorIdOE;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * REST Web Service
 *
 * @author juanmetalmolina
 */
@Path("/contacto")
public class ContactoSERV {

    @POST
    @Path("/registrarContacto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarContacto (RegistrarContactoOE OE) {

        ContactoFAC fac = new ContactoFAC();
        ObjetoSalida objetoSalida = fac.registrarContacto(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/consultarContactoPorId")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarContactoPorId(ConsultarContactoPorIdOE OE) {

        ContactoFAC fac = new ContactoFAC();
        ObjetoSalida objetoSalida = fac.consultarContactoPorId(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/actualizarContacto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response actualizarContacto(ActualizarContactoOE OE) {

        ContactoFAC fac = new ContactoFAC();
        ObjetoSalida objetoSalida = fac.actualizarContacto(OE);
        return API.retornarRespuesta(objetoSalida);
    }
}
