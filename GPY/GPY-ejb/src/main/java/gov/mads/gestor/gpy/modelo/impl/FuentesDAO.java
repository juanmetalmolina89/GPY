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

import gov.mads.gestor.gpy.vista.RegistrarFuenteOE;
import gov.mads.gestor.gpy.vista.ActualizarFuenteOE;
import gov.mads.gestor.gpy.vista.ConsultarFuentePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
import gov.mads.gestor.gpy.vista.ListarFuentesProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public class FuentesDAO extends GenericoDAO { 
        
	public ObjetoSalida registrarFuente(RegistrarFuenteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_RegistrarFuente", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A038NOMBRFUNT", objetoEntrada.getFuente().getA038nombrfunt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A038IDPROYECTO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A038IDDESGRCATIPCC", objetoEntrada.getFuente().getA038iddesgrcatipcc().getA048codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A038FACTOREMISION", objetoEntrada.getFuente().getA038factoremision().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida actualizarFuente(ActualizarFuenteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_ActualizarFuente", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A038CODIGO", objetoEntrada.getFuente().getA038codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A038NOMBRFUNT", objetoEntrada.getFuente().getA038nombrfunt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A038IDPROYECTO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A038IDDESGRCATIPCC", objetoEntrada.getFuente().getA038iddesgrcatipcc().getA048codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A038FACTOREMISION", objetoEntrada.getFuente().getA038factoremision().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida eliminarFuente(EliminarFuenteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_EliminarFuente", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A038CODIGO", objetoEntrada.getFuente().getA038codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida consultarFuente(ConsultarFuentePorIdOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_ConsultarFtesId", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A038CODIGO", objetoEntrada.getA038codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida listarFuentesPorProyecto(ListarFuentesProyectoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_ListarFuentesProyecto", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A038IDPROYECTO", objetoEntrada.getA038idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,FuentesDAO.class);
		}

		return objetoSalida;

	}
}
