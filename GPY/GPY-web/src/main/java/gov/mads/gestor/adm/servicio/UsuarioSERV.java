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
import gov.mads.gestor.adm.vista.OE_Autenticar;
import gov.mads.gestor.adm.vista.OE_ConsultarFuncionarios;
import gov.mads.gestor.adm.vista.OS_Autenticar;
import gov.mads.gestor.adm.vista.OS_ConsultarFuncionarios;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOS;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import static gov.mads.gestor.comun.servicio.jwt.JWTFiltro.JWT_HEADER_TOKEN;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

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
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED})//MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.TEXT_XML,MediaType.APPLICATION_XHTML_XML})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response redireccionarVital(@FormParam("datos")String OE) throws URISyntaxException, Exception{//UsuarioVitalOE OE) throws URISyntaxException, Exception {

        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.validar(OE);
        if (objetoSalida.getRespuesta() == null || objetoSalida.getRespuesta().isEmpty()){
           java.net.URI ubicacion = new java.net.URI("../#/gpy");
           //java.net.URI ubicacion = new java.net.URI("http://132.255.20.182:8088/GPY-web/#/gpy");
            return Response.seeOther(ubicacion).entity(objetoSalida).build();//.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
            //return Response.status(Response.Status.UNAUTHORIZED).entity(objetoSalida).build();
        }
        else{
            java.net.URI ubicacion = new java.net.URI("../#/gpy/token/"+ JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta())));
            //java.net.URI ubicacion = new java.net.URI("http://132.255.20.182:8088/GPY-web/#/gpy");
            //String url = "../#/gpy";
            //java.net.URI ubicacion = UriBuilder.fromUri(java.net.URLDecoder.decode(url, "ASCII")).queryParam(JWT_HEADER_TOKEN,JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();//
            
            // return Response.seeOther(ubicacion).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();//.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
            return Response.seeOther(ubicacion).build();//.entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();//.status(Response.Status.OK).entity(objetoSalida).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
        }
        
    }
    
    @POST
    @Path("/validarUsuarioVital")
    @Consumes(MediaType.TEXT_XML)
    @Produces("application/json")
    @WebMethod(operationName = "Autenticar")
    @WebResult(name = "autenticar")
    public Response autenticarVital(OE_Autenticar OE) throws Exception {
        
        UsuarioFAC fac = new UsuarioFAC();
        ObjetoSalida objetoSalida = fac.registrarUsuarioVital(OE);
        OS_Autenticar OS = new OS_Autenticar();
        OS.setCodigoError(objetoSalida.getCodError().getValor());
        OS.setMensajeError(objetoSalida.getMsgError());
        
        if (objetoSalida.getRespuesta() == null || objetoSalida.getRespuesta().isEmpty()){
            return Response.status(Response.Status.UNAUTHORIZED).entity(objetoSalida).build();
        }else{
            return Response.status(Response.Status.OK).entity(OS).header(JWT_HEADER_TOKEN, JWTFiltro.contruirToken(JWTFiltro.obtenerUsuario(objetoSalida.getRespuesta()))).build();
        }
    }
    
    @POST
    @Path("/consultarUsuariosxentidad")
    @Consumes(MediaType.TEXT_XML)
    @Produces("application/json")
    @WebMethod(operationName = "consultarFuncionarios")
    @WebResult(name = "consultarFuncionarios")
    public Response consultarVital(OE_ConsultarFuncionarios OE) {
        
        UsuarioFAC fac = new UsuarioFAC();
        OS_ConsultarFuncionarios objetoSalida = fac.listarUsuarioVital(OE);
        return API.retornarRespuestaVital(objetoSalida);
    }
}
