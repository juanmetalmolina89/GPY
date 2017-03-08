package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ActualizarPoliticasNuevasOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaNuevaOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasNuevasOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaNuevaOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Ivan Chacon
 */
public interface IPoliticaFAC { 

	public ObjetoSalida registrarPolitica(RegistrarPoliticaOE registrarPoliticaOE);
        //Faltantes
        public ObjetoSalida consultarPoliticaPorId(ConsultarPoliticaPorIdOE OE);
        public ObjetoSalida actualizarPolitica(ActualizarPoliticaOE OE);
        public ObjetoSalida eliminarPolitica(EliminarPoliticaOE OE);
        public ObjetoSalida listarPoliticasProyecto(ListarPoliticasProyectoOE OE);
        public ObjetoSalida registrarAdjunto(MultipartFormDataInput OE);
        public ObjetoSalida registrarPoliticaProy(RegistrarPoliticaNuevaOE OE);
        public ObjetoSalida actualizarPoliticaProy(ActualizarPoliticasNuevasOE OE);
        public ObjetoSalida eliminarPoliticaProy(EliminarPoliticaNuevaOE OE);
        public ObjetoSalida listarPoliticasProy(ListarPoliticasNuevasOE OE);
}
