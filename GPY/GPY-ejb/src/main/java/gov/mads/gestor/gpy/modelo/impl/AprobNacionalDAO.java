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
import gov.mads.gestor.gpy.vista.CambiarEstadoProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;
import gov.mads.gestor.gpy.vista.RegistrarAvanceOE;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author juanmetalmolina
 */
public class AprobNacionalDAO extends GenericoDAO{
        public ObjetoSalida cambiarEstadoProyecto(CambiarEstadoProyectoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_APROBNACIONAL.Pr_CambiarEstado", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_EstadoProyecto", objetoEntrada.getEstadoproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,AvanceDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,AvanceDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida adjuntarDocumento(RegistrarAdjuntoOE objetoEntrada){
                ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_APROBNACIONAL.Pr_AdjuntarArchivo", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A008IDADJNT", objetoEntrada.getProyadjunto().getA008idadjnt().getA025codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A008NUMRRADCD", objetoEntrada.getProyadjunto().getA008numrradcd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    java.sql.Date fechadjnt = (objetoEntrada.getProyadjunto().getA008fechadjnt() == null ) ? null : new java.sql.Date(objetoEntrada.getProyadjunto().getA008fechadjnt().getTime());           
                    parametros.add(new SentenciaParametroDAO("p_A008FECHADJNT", fechadjnt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                    parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getProyadjunto().getA008idarchv().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getProyadjunto().getA008idarchv().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getProyadjunto().getA008idarchv().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutar(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida, DatosMdlDAO.class);

                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida, DatosMdlDAO.class);
                }

                return objetoSalida;

        }
}
