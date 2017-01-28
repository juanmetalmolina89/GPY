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
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.ListarActividadesPorFiltroOE;
import gov.mads.gestor.gpy.vista.ListarProyectoFiltradoOE;
import gov.mads.gestor.gpy.vista.ListarProyectoOE;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author juanmetalmolina
 */
public class GrillaDAO extends GenericoDAO{
    
    public ObjetoSalida listarProyectos(ListarProyectoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_GRILLA.Pr_ListarProyectos", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarProyectoFiltrado(ListarProyectoFiltradoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_GRILLA.Pr_ListarProyectosPorClave", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_Clave", objetoEntrada.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        }

        return objetoSalida;
    }
    public ObjetoSalida listarActividades(ListarActividadesOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_GRILLA.Pr_ListarActividades", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getA005idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarActividadesFiltrado(ListarActividadesPorFiltroOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_GRILLA.Pr_ListarActividadesPorClave", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getA005idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_Clave", objetoEntrada.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,GrillaDAO.class);
        }

        return objetoSalida;
    }

}
