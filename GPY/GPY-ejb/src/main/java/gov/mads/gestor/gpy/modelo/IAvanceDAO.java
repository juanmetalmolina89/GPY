package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarAvanceOE;
import gov.mads.gestor.gpy.vista.ConsultarAvanceOE;
import gov.mads.gestor.gpy.vista.RegistrarAvanceOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IAvanceDAO { 

	ObjetoSalida registrarAvance(RegistrarAvanceOE registrarAvanceOE);
        ObjetoSalida consultarAvance(ConsultarAvanceOE registrarAvanceOE);
        // Faltante
        ObjetoSalida actualizarAvance(ActualizarAvanceOE OE);
}
