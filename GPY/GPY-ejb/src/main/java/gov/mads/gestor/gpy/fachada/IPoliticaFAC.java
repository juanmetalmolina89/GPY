package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;

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

}
