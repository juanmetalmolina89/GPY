/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.servicio;
/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.vista.ListarAutoridadesOE;
import gov.mads.gestor.utl.vista.ListarTipoProyectoOE;
import gov.mads.gestor.utl.vista.ListarTipoDocumentoOE;
import gov.mads.gestor.utl.vista.ListarClaseUsuarioOE;
import gov.mads.gestor.utl.vista.ListarTipoPersonaOE;
import gov.mads.gestor.utl.vista.ListarUbicacionProyectoOE;
import gov.mads.gestor.utl.vista.ListarAlcanceProyectoOE;
import gov.mads.gestor.utl.vista.ListarSectorImplementadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.vista.ListarPaisesOE;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.utl.vista.ListarCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarCodigoCIIUOE;
import gov.mads.gestor.utl.vista.ListarDepartamentoOE;
import gov.mads.gestor.utl.vista.ListarDesagregacionIPCCOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv3OE;
import gov.mads.gestor.utl.vista.ListarFtesFinancOE;
import gov.mads.gestor.utl.vista.ListarMetdMDLOE;
import gov.mads.gestor.utl.vista.ListarMunicipioOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv2OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv4OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv1OE;
import gov.mads.gestor.utl.vista.ListarSectorIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubGrupoIPCCOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadReducOE;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/listados")
public class ListadosSERV {
    @POST
    //@GET
    @Path("/listarAutoridades")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarAutoridades (ListarAutoridadesOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarAutoridades(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarTipoProyecto")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarTipoProyecto (ListarTipoProyectoOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarTipoProyecto(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarTipoDocumento")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarTipoDocumento (ListarTipoDocumentoOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarTipoDocumento(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarTipoPersona")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarTipoPersona (ListarTipoPersonaOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarTipoPersona(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarClaseUsuario")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarClaseUsuario (ListarClaseUsuarioOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarClaseUsuario(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    @POST
    @Path("/listarUbicacionProyecto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarUbicacionProyecto (ListarUbicacionProyectoOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarUbicacionProyecto(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarAlcanceProyecto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarAlcanceProyecto (ListarAlcanceProyectoOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarAlcanceProyecto(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarSectorImplementador")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarSectorImplementador (ListarSectorImplementadorOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarSectorImplementador(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/paises")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarPaises (ListarPaisesOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarPaises(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/departamentos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarDepartamentos (ListarDepartamentoOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarDepartamentos(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/municipios")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarMunicipios (ListarMunicipioOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarMunicipio(OE);
        return API.retornarRespuesta(objetoSalida);
    }
/*    @GET
    @Path("/listar/{categoria}")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response listarParametricas(@PathParam("categoria")String categoria){
        ListarParametricoOE listarparametricoOE = new ListarParametricoOE();
        listarparametricoOE.setIdUsuario(1);
        listarparametricoOE.setCategoria(categoria);
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarParametrico(listarparametricoOE);
        return Response.status(200).entity(objetoSalida).build(); 
    }*/
    
    @POST
    @Path("/listar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarParametricas (ListarParametricoOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarParametrico(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarCodigoCIIU")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarCodigoCIIU (ListarCodigoCIIUOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarCodigoCIIU(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarMetdMDL")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarMetdMDL(ListarMetdMDLOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarMetdMDL(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarDesagregacionIPCC")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarDesagregacionIPCC(ListarDesagregacionIPCCOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarDesagregacionIPCC(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarSubcategoriaIPCC")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarSubCategoriaIPCC(ListarSubCategoriaIPCCOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarSubCategoriaIPCC(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarCategoriaIPCC")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarCategoriaIPCC(ListarCategoriaIPCCOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarCategoriaIPCC(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarTipoActividades")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarTipoActividades(ListarTipoActividadOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarTipoActividad(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarSectorIPCC")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarSectorIPCC(ListarSectorIPCCOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarSectorIPCC(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarSubgrupoIPCC")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarSubgrupoIPCC(ListarSubGrupoIPCCOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarSubgrupoIPCC(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarArbolPolNv1")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarArbolPolNv1(ListarArbolPolNv1OE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarArbolPolNv1(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarArbolPolNv2")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarArbolPolNv2(ListarArbolPolNv2OE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarArbolPolNv2(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarArbolPolNv3")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarArbolPolNv3(ListarArbolPolNv3OE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarArbolPolNv3(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarArbolPolNv4")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarArbolPolNv4(ListarArbolPolNv4OE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarArbolPolNv4(OE);
        return API.retornarRespuesta(objetoSalida);
    }
        
    @POST
    @Path("/listarFuentesFinanciacion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarFuentesFinanciacion(ListarFtesFinancOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarFuentesFinanciacion(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarTipoActividadReduccion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @JWT
    public Response listarTipoActividadReduccion(ListarTipoActividadReducOE OE) {
        ListadosFAC fac = new ListadosFAC();
        ObjetoSalida objetoSalida = fac.listarTipoActividadReduccion(OE);
        return API.retornarRespuesta(objetoSalida);
    }
}