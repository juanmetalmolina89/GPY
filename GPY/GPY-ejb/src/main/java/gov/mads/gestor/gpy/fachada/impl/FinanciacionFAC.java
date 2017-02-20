package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.entidades.ProyFteFinanc;
import gov.mads.gestor.comun.entidades.ProySectrImplmntdr;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IFinanciacionFAC;
import gov.mads.gestor.gpy.modelo.impl.FinanciacionDAO;
import gov.mads.gestor.gpy.vista.RegistrarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ActualizarFinancOE;
import gov.mads.gestor.gpy.vista.EliminarFtesFinancOE;
import gov.mads.gestor.gpy.vista.EliminarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.ListarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.ListarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ListarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.RegistrarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarInstrmntFinnccnPOE;
import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;
import java.math.BigDecimal;

/**
 *
 * @author Ivan Chacon
 */
public class FinanciacionFAC implements IFinanciacionFAC { 

	private final FinanciacionDAO financiacionDAO = new FinanciacionDAO();

	public ObjetoSalida registrarFtesFinanc(RegistrarFtesFinancOE objetoEntrada) {
		return financiacionDAO.registrarFtesFinanc(objetoEntrada);
	}

	public ObjetoSalida actualizarFinanc(ActualizarFinancOE objetoEntrada) {
		return financiacionDAO.actualizarFinanc(objetoEntrada);
	}

        
        public ObjetoSalida registrarCostosProyecto(RegistrarCostosProyectoOE OE) {
                ObjetoSalida objetoSalida = financiacionDAO.registrarCostosProyecto(OE);
                if (objetoSalida.esRespuestaOperacionCorrecta()){
                    Integer a002codigo = ((BigDecimal) objetoSalida.getRespuesta().get(0).get("a002codigo")).intValue();
                    String buscafinanciacion = OE.getProyecto().getA002busqudfinnccn();
                    if(a002codigo > 0 && buscafinanciacion.equals("SI")){
                        for (ProyFteFinanc item : OE.getProyecto().getProyFteFinancList()) {
                            RegistrarFtesFinancOE OEE = new RegistrarFtesFinancOE();

                            OEE.setProyFteFinanc(item);
                            OEE.setIdUsuario(1);
                            ObjetoSalida objetoSalidaFinanciacion = financiacionDAO.registrarFtesFinanc(OEE);
                            if (objetoSalidaFinanciacion.getCodError() != CodError.OPERACION_CORRECTA) {
                                objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br><br>" + objetoSalidaFinanciacion.getMsgError());
                            }
                        }
                    }
                }
                return objetoSalida;
        }

        public ObjetoSalida listarCostosProyecto(ListarCostosProyectoOE OE) {
                return financiacionDAO.listarCostosProyecto(OE);
        }

        public ObjetoSalida listarFtesFinanc(ListarFtesFinancOE OE) {
                return financiacionDAO.listarFtesFinanc(OE);
        }

        public ObjetoSalida eliminarFtesFinanc(EliminarFtesFinancOE OE) {
                return financiacionDAO.eliminarFtesFinanc(OE);
        }

        public ObjetoSalida registrarInstrmntFinnccnP(RegistrarInstrmntFinnccnPOE registrarFtesFinancOE) {
                return financiacionDAO.registrarInstrmntFinnccnP(registrarFtesFinancOE);
        }

        public ObjetoSalida listarInstrmntFinnccnP(ListarInstrmntFinnccnPOE OE) {
                return financiacionDAO.listarInstrmntFinnccnP(OE);
        }

        public ObjetoSalida eliminarInstrmntFinnccnP(EliminarInstrmntFinnccnPOE OE) {
                return financiacionDAO.eliminarInstrmntFinnccnP(OE);
        }

}
