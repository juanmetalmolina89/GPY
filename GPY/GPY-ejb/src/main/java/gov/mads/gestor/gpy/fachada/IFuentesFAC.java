package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IFuentesFAC { 

	public ObjetoSalida registarFuente(RegistarFuenteOE registarFuenteOE);
	public ObjetoSalida actualizarFuente(ActualizarFuenteOE actualizarFuenteOE);
	public ObjetoSalida eliminarFuente(EliminarFuenteOE eliminarFuenteOE);
        // Ajuste
        public ObjetoSalida consultarFuentePorId(ConsultarFuentePorIdOE OE);
}
