/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.modelo.impl;

import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.rpt.vista.ListarReporteOE;
import gov.mads.gestor.rpt.vista.ReporteOE;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author juanmetalmolina
 */
public class ReporteDAO extends GenericoDAO{
    
    public ObjetoSalida generarReporteProyectos(ReporteOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPORTE.Pr_GenerarReporte", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            parametros.add(new SentenciaParametroDAO("p_A103CODIGO", objetoEntrada.getA103codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A001CODIGO", objetoEntrada.getA001codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_ANO", objetoEntrada.getAnio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("P_A103NOMBREPLANTILLA", objetoEntrada.getNombrePlantilla(), SentenciaTipoParametroDAO.SALIDA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            
            objetoSalida = this.ejecutarReporte(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ReporteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ReporteDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida generarReporteProyectosDemo(ReporteOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_GRILLA.Pr_ListarActividadesPorClave", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ReporteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ReporteDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarReportes(ListarReporteOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPORTE.Pr_ListarReportes", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            sentencia.setParametros(parametros);
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ReporteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ReporteDAO.class);
        }

        return objetoSalida;
    }
}
