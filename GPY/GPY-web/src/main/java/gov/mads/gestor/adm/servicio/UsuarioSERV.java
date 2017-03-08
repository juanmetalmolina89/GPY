/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.servicio;

import gov.mads.gestor.adm.vista.ConsultarUsuarioOE;
import gov.mads.gestor.adm.fachada.impl.UsuarioFAC;
import gov.mads.gestor.adm.vista.RegistrarUsuarioOE;
import gov.mads.gestor.adm.vista.EliminarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioOE;
import gov.mads.gestor.adm.vista.CambiarContrasenaOE;
import gov.mads.gestor.adm.vista.ListarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOS;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import static gov.mads.gestor.comun.servicio.jwt.JWTFiltro.JWT_HEADER_TOKEN;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioSERV {

    @POST
    @Path("/consultarUsuario")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarUsuario (ConsultarUsuarioOE OE) {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.consultarUsuario(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    @POST
    @Path("/registrarUsuario")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarUsuario (RegistrarUsuarioOE OE) {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.registrarUsuario(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/eliminarUsuario")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response eliminarUsuario (EliminarUsuarioOE OE) {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.eliminarUsuario(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/validarUsuario")
    @Consumes({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//    @JWT
    public Response validarUsuario (ValidarUsuarioOE OE) throws Exception {
        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.validarUsuario(OE);
        if (objetoSalida.getRespuesta() == null || objetoSalida.getRespuesta().isEmpty())
            return Response.status(Response.Status.UNAUTHORIZED).entity(objetoSalida).build();
        else
            //return Response.status(Response.Status.OK).entity(objetoSalida).build();
            //return Response.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(objetoSalida.getRespuesta().stream().findFirst().get().get("a041username").toString())).build();
            return Response.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
    }
    
    @POST
    @Path("/cambiarContrasena")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response cambiarContrasena (CambiarContrasenaOE OE) {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.cambiarContrasena(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarUsuarios")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarUsuarios (ListarUsuarioOE OE) {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.listarUsuario(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    /**
     * @todo 
     * Completar los requerimientos del Web service
     */
    @POST
    @Path("/redireccionarVital")
    @Consumes({ MediaType.APPLICATION_XML})
    //@Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response redireccionarVital(UsuarioVitalOE OE) throws URISyntaxException, Exception {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.validarUsuarioVital(OE);
        if (objetoSalida.getRespuesta() == null || objetoSalida.getRespuesta().isEmpty())
            return Response.status(Response.Status.UNAUTHORIZED).entity(objetoSalida).build();
        else{
            //return Response.status(Response.Status.OK).entity(objetoSalida).build();
            //return Response.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(objetoSalida.getRespuesta().stream().findFirst().get().get("a041username").toString())).build();
            java.net.URI ubicacion = new java.net.URI("http://google.com.co");
            return Response.seeOther(ubicacion).build();//.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
        }
        
    }
    
    @POST
    @Path("/validarVital")
    @Consumes({ MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_XML})
    public Response validarVital(ValidarUsuarioVitalOE OE) throws URISyntaxException, Exception {

        UsuarioFAC fac = new UsuarioFAC();
        //ObjetoSalida objetoSalida = fac.validarUsuarioVital(OE);
        ValidarUsuarioVitalOS objetoSalida = fac.validarUsuarioVital(OE);
        //if (objetoSalida.getRespuesta() == null || objetoSalida.getRespuesta().isEmpty())
        if (objetoSalida.respuesta == null || objetoSalida.respuesta.isEmpty())
            return Response.status(Response.Status.UNAUTHORIZED).entity(objetoSalida).build();
        else{
            //return Response.status(Response.Status.OK).entity(objetoSalida).build();
            //return Response.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(objetoSalida.getRespuesta().stream().findFirst().get().get("a041username").toString())).build();
            //java.net.URI ubicacion = new java.net.URI("http://127.0.0.1:8088/GPY-web/#/gpy");
            return Response.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.respuesta))).build();
            //return Response.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
        }
        
    }
}
