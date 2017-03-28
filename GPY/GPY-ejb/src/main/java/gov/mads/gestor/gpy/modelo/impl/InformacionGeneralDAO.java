/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.modelo.impl;

import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarInfoProyectOE;
import gov.mads.gestor.gpy.vista.ConsultarInfoProyectOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.RegistrarInfoProyectOE;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author juanmetalmolina
 */
public class InformacionGeneralDAO extends GenericoDAO{
        
        public ObjetoSalida registrarInfoProyect(RegistrarInfoProyectOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_INFORMACION_GENERAL.Pr_RegistrarInfoProyect", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                        java.sql.Date a013fechareprt = (objetoEntrada.getAvanceproyecto().getA013fechreprt() == null) ? null : new java.sql.Date(objetoEntrada.getAvanceproyecto().getA013fechreprt().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A013FECHREPRT", a013fechareprt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
			parametros.add(new SentenciaParametroDAO("p_A013CAMBSIGNFCTV", objetoEntrada.getAvanceproyecto().getA013cambsignfctv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A013COSTTONLD", objetoEntrada.getAvanceproyecto().getA013costtonld().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013FINANCCN", objetoEntrada.getAvanceproyecto().getA013financcn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        java.sql.Date a013fechavncproyct = (objetoEntrada.getAvanceproyecto().getA013fechreprt() == null) ? null : new java.sql.Date(objetoEntrada.getAvanceproyecto().getA013fechavncproyct().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A013FECHAVNCPROYCT", a013fechavncproyct, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));                        
                        parametros.add(new SentenciaParametroDAO("p_A013OPTAPAGORESULTADOS", objetoEntrada.getAvanceproyecto().getA013optapagoresultados(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A013IDPROYECTO", objetoEntrada.getAvanceproyecto().getA013idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCXVERIFICAR", objetoEntrada.getAvanceproyecto().getA013emisredcxverificar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCVERIFICADAS", objetoEntrada.getAvanceproyecto().getA013emisredcverificadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCDISPNTRANSAR", objetoEntrada.getAvanceproyecto().getA013emisredcdispntransar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCTRANSADAS", objetoEntrada.getAvanceproyecto().getA013emisredctransadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013IDARCHV", objetoEntrada.getAvanceproyecto().getA013idarchv().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013NROCPAS", objetoEntrada.getAvanceproyecto().getA013nrocpas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013HAYNUEVOCPA", objetoEntrada.getAvanceproyecto().getA013haynuevocpa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,InformacionGeneralDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,InformacionGeneralDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida actualizarInfoProyect(ActualizarInfoProyectOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_INFORMACION_GENERAL.Pr_ActualizarInfoProyect", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A013CODIGO", objetoEntrada.getAvanceproyecto().getA013codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			java.sql.Date a013fechareprt = (objetoEntrada.getAvanceproyecto().getA013fechreprt() == null) ? null : new java.sql.Date(objetoEntrada.getAvanceproyecto().getA013fechreprt().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A013FECHREPRT", a013fechareprt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
			parametros.add(new SentenciaParametroDAO("p_A013CAMBSIGNFCTV", objetoEntrada.getAvanceproyecto().getA013cambsignfctv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A013COSTTONLD", objetoEntrada.getAvanceproyecto().getA013costtonld().longValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013FINANCCN", objetoEntrada.getAvanceproyecto().getA013financcn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        java.sql.Date a013fechavncproyct = (objetoEntrada.getAvanceproyecto().getA013fechreprt() == null) ? null : new java.sql.Date(objetoEntrada.getAvanceproyecto().getA013fechavncproyct().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A013FECHAVNCPROYCT", a013fechavncproyct, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        parametros.add(new SentenciaParametroDAO("p_A013OPTAPAGORESULTADOS", objetoEntrada.getAvanceproyecto().getA013optapagoresultados(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A013IDPROYECTO", objetoEntrada.getAvanceproyecto().getA013idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCXVERIFICAR", objetoEntrada.getAvanceproyecto().getA013emisredcxverificar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCVERIFICADAS", objetoEntrada.getAvanceproyecto().getA013emisredcverificadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCDISPNTRANSAR", objetoEntrada.getAvanceproyecto().getA013emisredcdispntransar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013EMISREDCTRANSADAS", objetoEntrada.getAvanceproyecto().getA013emisredctransadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013IDARCHV", objetoEntrada.getAvanceproyecto().getA013idarchv().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013NROCPAS", objetoEntrada.getAvanceproyecto().getA013nrocpas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A013HAYNUEVOCPA", objetoEntrada.getAvanceproyecto().getA013haynuevocpa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,InformacionGeneralDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,InformacionGeneralDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida consultarInfoProyect(ConsultarInfoProyectOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_INFORMACION_GENERAL.Pr_ConsultarInfoProyect", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A013IDPROYECTO", objetoEntrada.getA013idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,InformacionGeneralDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,InformacionGeneralDAO.class);
		}

		return objetoSalida;

	}
}
