/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.servicio;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.gpy.fachada.impl.DatosBasicosFAC;
import gov.mads.gestor.gpy.vista.ListarProyectoFiltradoOE;
import gov.mads.gestor.gpy.vista.ListarProyectoOE;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.impl.GrillaFAC;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.ListarActividadesPorFiltroOE;
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
@Path("/grilla")
public class GrillaSERV {
    
    @POST
    @Path("/listarProyecto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarProyecto (ListarProyectoOE OE) {

        GrillaFAC fac = new GrillaFAC();
        ObjetoSalida objetoSalida = fac.listarProyecto(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarProyectoPorClave")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarProyectoFiltrado (ListarProyectoFiltradoOE OE) {

        GrillaFAC fac = new GrillaFAC();
        ObjetoSalida objetoSalida = fac.listarProyectoFiltrado(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarActividades")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarActividades(ListarActividadesOE OE) {

        GrillaFAC fac = new GrillaFAC();
        ObjetoSalida objetoSalida = fac.listarActividades(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    @POST
    @Path("/listarActividadPorClave")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarActividadesFiltrado(ListarActividadesPorFiltroOE OE) {

        GrillaFAC fac = new GrillaFAC();
        ObjetoSalida objetoSalida = fac.listarActividadesFiltrado(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    
}
