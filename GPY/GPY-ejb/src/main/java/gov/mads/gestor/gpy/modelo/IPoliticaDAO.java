package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ActualizarPoliticasNuevasOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaNuevaOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasNuevasOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaNuevaOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IPoliticaDAO { 

	ObjetoSalida registrarPolitica(RegistrarPoliticaOE registrarPoliticaOE);
        // Faltantes en politicas
        ObjetoSalida consultarPoliticaPorId(ConsultarPoliticaPorIdOE OE);
        ObjetoSalida actualizarPolitica(ActualizarPoliticaOE OE);
        ObjetoSalida eliminarPolitica(EliminarPoliticaOE OE);
        ObjetoSalida listarPoliticasProyecto(ListarPoliticasProyectoOE OE);
        ObjetoSalida registrarAdjunto(RegistrarAdjuntoOE OE);
        ObjetoSalida registrarPoliticaNueva(RegistrarPoliticaOE objetoEntrada);
        ObjetoSalida registrarPoliticaProy(RegistrarPoliticaNuevaOE OE);
        ObjetoSalida actualizarPoliticaProy(ActualizarPoliticasNuevasOE OE);
        ObjetoSalida eliminarPoliticaProy(EliminarPoliticaNuevaOE OE);
        ObjetoSalida listarPoliticasProy(ListarPoliticasNuevasOE OE);
}
