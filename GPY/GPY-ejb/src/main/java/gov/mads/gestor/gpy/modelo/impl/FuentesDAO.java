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
import gov.mads.gestor.gpy.vista.EliminarEscenarioBaseOE;
import gov.mads.gestor.gpy.vista.EliminarFuenteOE;
import gov.mads.gestor.gpy.vista.ListarEscenarioBaseOE;
import gov.mads.gestor.gpy.vista.ListarFuentesProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarEscenarioBaseOE;

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
                        Integer a038iddesgrcatipcc = (objetoEntrada.getFuente().getA038iddesgrcatipcc() == null) ? null : objetoEntrada.getFuente().getA038iddesgrcatipcc().getA048codigo();
                        parametros.add(new SentenciaParametroDAO("p_A038IDDESGRCATIPCC", a038iddesgrcatipcc, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A038FACTOREMISION", objetoEntrada.getFuente().getA038factoremision().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A038IDUNIDAD", objetoEntrada.getFuente().getA038idunidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
			Integer a038iddesgrcatipcc = (objetoEntrada.getFuente().getA038iddesgrcatipcc() == null) ? null : objetoEntrada.getFuente().getA038iddesgrcatipcc().getA048codigo();
                        parametros.add(new SentenciaParametroDAO("p_A038IDDESGRCATIPCC", a038iddesgrcatipcc, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A038FACTOREMISION", objetoEntrada.getFuente().getA038factoremision().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A038IDUNIDAD", objetoEntrada.getFuente().getA038idunidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
        
        public ObjetoSalida registrarEscenarioBase(RegistrarEscenarioBaseOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_RegistrarEscenarioBase", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			java.sql.Date reprtanfunt = (objetoEntrada.getReporteaniofuente().getA010reprtanfunt() == null) ? null : new java.sql.Date(objetoEntrada.getReporteaniofuente().getA010reprtanfunt().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A010REPRTANFUNT", reprtanfunt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        parametros.add(new SentenciaParametroDAO("p_A010VALREMSN", objetoEntrada.getReporteaniofuente().getA010valremsn().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A010IDFUENTE", objetoEntrada.getReporteaniofuente().getA010idfuente().getA038codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
        
        
        public ObjetoSalida eliminarEscenarioBase(EliminarEscenarioBaseOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_EliminarEscenarioBase", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A010CODIGO", objetoEntrada.getA010codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
        
        public ObjetoSalida listarEscenarioBase(ListarEscenarioBaseOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_FUENTE.Pr_ListarEscenarioBase", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A010IDFUENTE", objetoEntrada.getA010idfuentes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
