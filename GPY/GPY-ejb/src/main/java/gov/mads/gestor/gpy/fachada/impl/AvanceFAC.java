package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IAvanceFAC;
import gov.mads.gestor.gpy.modelo.impl.AvanceDAO;
import gov.mads.gestor.gpy.vista.ActualizarAvanceOE;
import gov.mads.gestor.gpy.vista.ConsultarAvanceOE;
import gov.mads.gestor.gpy.vista.RegistrarAvanceOE;

/**
 *
 * @author Ivan Chacon
 */
public class AvanceFAC implements IAvanceFAC { 

	private final AvanceDAO avanceDAO = new AvanceDAO();

	public ObjetoSalida registrarAvance(RegistrarAvanceOE objetoEntrada) {
		return avanceDAO.registrarAvance(objetoEntrada);
	}
        
        public ObjetoSalida consultarAvance(ConsultarAvanceOE objetoEntrada){
            return avanceDAO.consultarAvance(objetoEntrada);
        }

        
        public ObjetoSalida actualizarAvance(ActualizarAvanceOE OE) {
            return avanceDAO.actualizarAvance(OE);
        }
}
