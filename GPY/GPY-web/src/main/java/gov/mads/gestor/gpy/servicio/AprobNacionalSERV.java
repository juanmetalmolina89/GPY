/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.servicio;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;

import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.gpy.fachada.impl.ActividadFAC;
import gov.mads.gestor.gpy.fachada.impl.AprobNacionalFAC;
import gov.mads.gestor.gpy.vista.CambiarEstadoProyectoOE;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author juanmetalmolina
 */
@Path("/aprobnacional")
public class AprobNacionalSERV {
        @POST
        @Path("/registrarDocumento")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces({ MediaType.APPLICATION_JSON})
        @JWT
        public Response registrarDocumento (MultipartFormDataInput OE) {
               AprobNacionalFAC fac = new AprobNacionalFAC();
               ObjetoSalida objetoSalida = fac.adjuntarDocumento(OE);
               return API.retornarRespuesta(objetoSalida);
        }
        
        @POST
        @Path("/cambiarEstado")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces({ MediaType.APPLICATION_JSON})
        @JWT
        public Response cambiarEstadoProyecto(CambiarEstadoProyectoOE OE) {
               AprobNacionalFAC fac = new AprobNacionalFAC();
               ObjetoSalida objetoSalida = fac.cambiarEstadoProyecto(OE);
               return API.retornarRespuesta(objetoSalida);
        }

}
