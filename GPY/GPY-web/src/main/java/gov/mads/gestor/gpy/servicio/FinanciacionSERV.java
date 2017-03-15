package gov.mads.gestor.gpy.servicio;


import gov.mads.gestor.comun.servicio.API;
import gov.mads.gestor.comun.vista.ObjetoSalida;

import gov.mads.gestor.comun.servicio.jwt.JWT;
import gov.mads.gestor.comun.servicio.jwt.JWTFiltro;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gov.mads.gestor.gpy.fachada.impl.FinanciacionFAC;
import gov.mads.gestor.gpy.vista.RegistrarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ActualizarFinancOE;
import gov.mads.gestor.gpy.vista.EliminarFtesFinancOE;
import gov.mads.gestor.gpy.vista.EliminarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.InsertarInstrmntInfoGralPOE;
import gov.mads.gestor.gpy.vista.ListarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.ListarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ListarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.RegistrarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarInstrmntFinnccnPOE;
/**
 * REST Web Service
 *
 * @author Ivan Chacon
*/
@Path("/financiacion")
public class FinanciacionSERV { 

	@POST
	@Path("/registrarFtesFinanc")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarFtesFinanc(RegistrarFtesFinancOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.registrarFtesFinanc(objetoEntrada);
		return API.retornarRespuesta(os);
	}

	@POST
	@Path("/actualizarFinanc")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarFinanc(ActualizarFinancOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.actualizarFinanc(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/registrarCostosProyecto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarCostosProyecto(RegistrarCostosProyectoOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.registrarCostosProyecto(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarCostosProyecto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarCostosProyecto(ListarCostosProyectoOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.listarCostosProyecto(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarFtesFinanc")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarFtesFinanc(ListarFtesFinancOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.listarFtesFinanc(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/eliminarFtesFinanc")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarFtesFinanc(EliminarFtesFinancOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.eliminarFtesFinanc(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/registrarInstrmntFinnccnP")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response registrarInstrmntFinnccnP(RegistrarInstrmntFinnccnPOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.registrarInstrmntFinnccnP(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/listarInstrmntFinnccnP")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response listarInstrmntFinnccnP(ListarInstrmntFinnccnPOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.listarInstrmntFinnccnP(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/eliminarInstrmntFinnccnP")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminarInstrmntFinnccnP(EliminarInstrmntFinnccnPOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.eliminarInstrmntFinnccnP(objetoEntrada);
		return API.retornarRespuesta(os);
	}
        
        @POST
	@Path("/insertarInstrmntFinnccnInfoGralP")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@JWT
	public Response insertarInstrmntInfoGralP(InsertarInstrmntInfoGralPOE objetoEntrada) {
		FinanciacionFAC fac = new FinanciacionFAC();
		ObjetoSalida os = fac.insertarInstrmntInfoGralP(objetoEntrada);
		return API.retornarRespuesta(os);
	}
}
