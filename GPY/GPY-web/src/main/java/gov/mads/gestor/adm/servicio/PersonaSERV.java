/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.servicio;

/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.adm.fachada.impl.PersonaFAC;
import gov.mads.gestor.gpy.vista.RegistrarPersonaNaturalOE;
import gov.mads.gestor.gpy.vista.RegistrarPersonaJuridicaOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarPersonaOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaDocumentoOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarPersonaOE;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/persona")
public class PersonaSERV {

    @POST
    @Path("/registrarPersonaNatural")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarPersonaNatural (RegistrarPersonaNaturalOE OE) {

        PersonaFAC fac = new PersonaFAC();
        ObjetoSalida objetoSalida = fac.registrarPersonaNatural(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/registrarPersonaJuridica")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarPersonaJuridica (RegistrarPersonaJuridicaOE OE) {

        PersonaFAC fac = new PersonaFAC();
        ObjetoSalida objetoSalida = fac.registrarPersonaJuridica(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
      
    @POST
    @Path("/consultarPersonaPorId")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarPersonaPorId (ConsultarPersonaPorIdOE consultarpersonaporidOE) {

        PersonaFAC fac = new PersonaFAC();
        ObjetoSalida objetoSalida = fac.consultarPersonaPorId(consultarpersonaporidOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/actualizarPersona")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response actualizarPersona (ActualizarPersonaOE actualizarPersonaOE) {

        PersonaFAC fac = new PersonaFAC();
        ObjetoSalida objetoSalida = fac.actualizarPersona(actualizarPersonaOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/registrarPersona")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarPersona (RegistrarPersonaOE OE) {

        PersonaFAC fac = new PersonaFAC();
        ObjetoSalida objetoSalida = fac.registrarPersona(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/consultarPersonaDocumento")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarPersonaDocumento (ConsultarPersonaDocumentoOE OE) {

        PersonaFAC fac = new PersonaFAC();
        ObjetoSalida objetoSalida = fac.consultarPersonaDocumento(OE);
        return API.retornarRespuesta(objetoSalida);
    }
}
