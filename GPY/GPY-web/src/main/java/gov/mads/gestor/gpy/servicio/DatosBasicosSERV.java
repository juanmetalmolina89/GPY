/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.servicio;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.gpy.fachada.impl.DatosBasicosFAC;
import gov.mads.gestor.gpy.vista.RegistrarProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarProyectoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoAsociadoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSectorImplementOE;
import gov.mads.gestor.gpy.vista.ListarProyectosOE;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/datosbasicos")
public class DatosBasicosSERV {

    @POST
    @Path("/registrarProyecto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarProyecto (RegistrarProyectoOE registrarproyectoOE) {

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.registrarProyecto(registrarproyectoOE);
        return API.retornarRespuesta(objetoSalida);
    }
    @POST
    @Path("/registrarSectorImplementador")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response registrarSectorImplementador (RegistrarSectorImplementadorOE registrarsectorimplementadorOE) {

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.registrarSectorImplementador(registrarsectorimplementadorOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
    @POST
    @Path("/consultarProyectoPorId")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarProyectoPorId(ConsultarProyectoPorIdOE consultarproyectoporidOE){

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.consultarProyectoPorId(consultarproyectoporidOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
    @POST
    @Path("/actualizarProyecto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response actualizarProyecto (ActualizarProyectoOE actualizarproyectoOE) {

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.actualizarProyecto(actualizarproyectoOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
    @POST
    @Path("/consultarProyectoAsociado")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response consultarProyectoAsociado(ConsultarProyectoAsociadoOE consultarproyectoasociadoOE){

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.consultarProyectoAsociado(consultarproyectoasociadoOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
        
    @POST
    @Path("/listarProyectos")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarProyectos(ListarProyectosOE listarproyectosOE){

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.listarProyectos(listarproyectosOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
    @POST
    @Path("/consultarSectorImplement")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response  consultarSectorImplement(ConsultarSectorImplementOE consultarsectorimplementOE) {

        DatosBasicosFAC fac = new DatosBasicosFAC();
        ObjetoSalida objetoSalida = fac.consultarSectorImplement(consultarsectorimplementOE);
        return API.retornarRespuesta(objetoSalida);
    }
    
    
}
