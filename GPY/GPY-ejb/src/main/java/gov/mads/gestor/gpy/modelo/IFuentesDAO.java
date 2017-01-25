package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IFuentesDAO { 

	ObjetoSalida registarFuente(RegistarFuenteOE registarFuenteOE);
	ObjetoSalida actualizarFuente(ActualizarFuenteOE actualizarFuenteOE);
	ObjetoSalida eliminarFuente(EliminarFuenteOE eliminarFuenteOE);
        // Ajuste
        ObjetoSalida consultarFuentePorId(ConsultarFuentePorIdOE consultarFuentePorIdOE);

}
