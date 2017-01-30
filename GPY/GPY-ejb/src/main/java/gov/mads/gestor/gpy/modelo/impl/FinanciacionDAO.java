package gov.mads.gestor.gpy.modelo.impl;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import oracle.jdbc.OracleTypes;
import java.util.ArrayList;
import java.util.List;

import gov.mads.gestor.gpy.vista.RegistrarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ActualizarFinancOE;
import gov.mads.gestor.gpy.vista.EliminarFtesFinancOE;
import gov.mads.gestor.gpy.vista.ListarCostosProyectoOE;
import gov.mads.gestor.gpy.vista.ListarFtesFinancOE;
import gov.mads.gestor.gpy.vista.RegistrarCostosProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public class FinanciacionDAO extends GenericoDAO { 

        public ObjetoSalida registrarFtesFinanc(RegistrarFtesFinancOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FINANCIACION.Pr_RegistrarFuenteFinaciacion", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A004IDPROYECTO", objetoEntrada.getProyFteFinanc().getA004idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A004IDFUNTFINNCCN", objetoEntrada.getProyFteFinanc().getA004idfuntfinnccn().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida actualizarFinanc(ActualizarFinancOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FINANCIACION.Pr_ActualizarFinanc", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A004IDPROYECTO", objetoEntrada.getProyFteFinanc().getA004idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDTOTL", objetoEntrada.getProyecto().getA002costsestmdtotl().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDFORMLCN", objetoEntrada.getProyecto().getA002costsestmdformlcn().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002COSTTONLDRDCR", objetoEntrada.getProyecto().getA002costtonldrdcr().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida registrarCostosProyecto(RegistrarCostosProyectoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FINANCIACION.Pr_RegistrarCostosProyecto", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getProyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDTOTL", objetoEntrada.getProyecto().getA002costsestmdtotl().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("P_A002COSTSESTMDFORMLCN", objetoEntrada.getProyecto().getA002costsestmdformlcn().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("P_A002COSTTONLDRDCR", objetoEntrada.getProyecto().getA002costtonldrdcr().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("P_A002TRM", objetoEntrada.getProyecto().getA002trm().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("P_A002BUSQUDFINNCCN", objetoEntrada.getProyecto().getA002busqudfinnccn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida listarCostosProyecto(ListarCostosProyectoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FINANCIACION.Pr_ListarCostosProyecto", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida listarFtesFinanc(ListarFtesFinancOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FINANCIACION.Pr_ListarFuenteFinaciacion", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("P_A004IDPROYECTO", objetoEntrada.getA004idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida eliminarFtesFinanc(EliminarFtesFinancOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FINANCIACION.Pr_EliminarFuenteFinaciacion", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("P_A004IDPROYECTO", objetoEntrada.getA004idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("P_A004IDFUNTFINNCCN", objetoEntrada.getA004idftefinanc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FinanciacionDAO.class);
		}

		return objetoSalida;

	}
}
