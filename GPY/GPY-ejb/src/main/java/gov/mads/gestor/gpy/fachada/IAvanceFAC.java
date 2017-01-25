package gov.mads.gestor.gpy.fachada;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarAvanceOE;
import gov.mads.gestor.gpy.vista.ConsultarAvanceOE;
import gov.mads.gestor.gpy.vista.RegistrarAvanceOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IAvanceFAC { 

	public ObjetoSalida registrarAvance(RegistrarAvanceOE registrarAvanceOE);
        public ObjetoSalida consultarAvance(ConsultarAvanceOE OE);
        public ObjetoSalida actualizarAvance(ActualizarAvanceOE OE);

}
