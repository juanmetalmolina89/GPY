/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.servicio;
import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;

import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import gov.mads.gestor.gpy.fachada.impl.DatosBasicosFAC;
import gov.mads.gestor.gpy.vista.RegistrarProyectoOE;
import gov.mads.gestor.rpt.fachada.impl.ReporteFAC;
import gov.mads.gestor.rpt.vista.ListarReporteOE;
import gov.mads.gestor.rpt.vista.ReporteOE;
import java.io.File;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author juanmetalmolina
 */
@Path("/reporte")
public class ReporteSERV {
    
    @GET
    @Path("/reporteGeneral/{idUsuario}/{anio}/{entidad}/{reporte}")
    @Produces("application/vnd.ms-excel")
    @JWT
    public Response generarReporte(@PathParam("anio")Integer anio,@PathParam("entidad")Integer entidad,@PathParam("reporte")Integer reporte,@PathParam("idUsuario")Integer idUsuario){//ReporteOE objetoEntrada){
        try {
            ReporteFAC fachada = new ReporteFAC();
            ReporteOE objetoEntrada = new ReporteOE(anio, entidad, reporte,idUsuario);
            File adjunto = fachada.generarReporteProyectos(objetoEntrada);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok((Object)new File(adjunto.getAbsolutePath()));
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Path("/reporteGeneralDemo")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces("application/vnd.ms-excel")
    @JWT
    public Response generarReporte(gov.mads.gestor.gpy.vista.ListarProyectoOE objetoEntrada){
        try {
            ReporteFAC fachada = new ReporteFAC();
            File adjunto = fachada.generarReporteProyectosDemo(objetoEntrada);
            if (adjunto != null && adjunto.exists()) {
                Response.ResponseBuilder response = Response.ok(new File(adjunto.getAbsolutePath()));
                response.header("Content-Disposition", "attachment; filename=" + adjunto.getName());
                return response.build();
            }
            else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Path("/ListarReporteProyecto")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @JWT
    public Response listarReporteProyecto (ListarReporteOE OE) throws Exception {

        ReporteFAC fac = new ReporteFAC();
        ObjetoSalida objetoSalida = fac.listarReporteProyectos(OE);
        return API.retornarRespuesta(objetoSalida);
    }
    @GET
    @Path("/download/xls")
    @Produces("application/vnd.ms-excel")
    public Response downloadExcelFile() {
 
        // set file (and path) to be download
        File file = new File("/home/juanmetalmolina/PruebaExcel.xlsx");
 
        ResponseBuilder responseBuilder = Response.ok((Object) file);
        responseBuilder.header("Content-Disposition", "attachment; filename=\"MyJerseyExcelFile.xlsx\"");
        return responseBuilder.build();
    }
}
