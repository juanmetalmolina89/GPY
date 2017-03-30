/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo.impl;
//Objetos de entrada
import gov.mads.gestor.adm.vista.ActualizarUsuarioOE;
import gov.mads.gestor.adm.vista.ConsultarUsuarioOE;
import gov.mads.gestor.adm.vista.RegistrarUsuarioOE;
import gov.mads.gestor.adm.vista.EliminarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioOE;
import gov.mads.gestor.adm.vista. CambiarContrasenaOE;
import gov.mads.gestor.adm.vista.ConsultarUsuarioEntidadOE;
import gov.mads.gestor.adm.vista.ListarUsuarioOE;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author juanmetalmolina
 */
public class UsuarioDAO extends GenericoDAO {

    public ObjetoSalida consultarUsuario(ConsultarUsuarioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_ConsultarUsuario", objetoEntrada.getA041codigo());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarUsuario(ListarUsuarioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_ListarUsuario", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida registrarUsuario(RegistrarUsuarioOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();
        
        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_RegistrarUsuario", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPersona().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPersona().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052IDTIPPERSN", objetoEntrada.getPersona().getA052idtippersn().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getPersona().getA052tipdocmnt().getA015codigo() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPersona().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            String digtchqu = (objetoEntrada.getPersona().getA052digtchqu() == null) ? null : objetoEntrada.getPersona().getA052digtchqu().toString();
            parametros.add(new SentenciaParametroDAO("p_A052DIGTCHQU", digtchqu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", objetoEntrada.getPersona().getA052identidad().getA001codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041USERNAME", objetoEntrada.getUsuario().getA041username(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CLAVE", objetoEntrada.getUsuario().getA041clave(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    public ObjetoSalida eliminarUsuario(EliminarUsuarioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_EliminarUsuario", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida validarUsuario(ValidarUsuarioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_ValidarUsuario", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041USERNAME", objetoEntrada.getUsername(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CLAVE", objetoEntrada.getClave(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida cambiarContrasena(CambiarContrasenaOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_CambiarContrasena", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getUsuario().getA041codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041USERNAME", objetoEntrada.getUsuario().getA041username(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CLAVEANT", objetoEntrada.getA041claveant(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CLAVENUEVA", objetoEntrada.getA041clavenueva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida actualizaUsuario(ActualizarUsuarioOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_RegistrarUsuario", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            /*parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getUsuario().getA041codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041NOMBRE", objetoEntrada.getUsuario().getA041nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041APELLIDO", objetoEntrada.getUsuario().getA041apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041IDTIPPERSN", objetoEntrada.getUsuario().getA041idtippersn().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041TIPDOCMNT", objetoEntrada.getUsuario().getA041tipdocmnt().getA102codigo() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041NUMRDOCMNT", objetoEntrada.getUsuario().getA041numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041DIGTCHQU", objetoEntrada.getUsuario().getA041digtchqu().toString(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041IDENTIDAD", objetoEntrada.getUsuario().getA041identidad().getA001codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041USERNAME", objetoEntrada.getUsuario().getA041username(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CLAVE", objetoEntrada.getUsuario().getA041clave(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));*/
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida validarUsuarioSinPassword(ValidarUsuarioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_ConsultarUsrPrUsname", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041USERNAME", objetoEntrada.getUsername(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            //parametros.add(new SentenciaParametroDAO("p_A041CLAVE", objetoEntrada.getClave(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }

    public ObjetoSalida consultarUsuarioEntidad(ConsultarUsuarioEntidadOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_ADM_USUARIO.Pr_ConsultarUsrsEntidad", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041SIGLA", objetoEntrada.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            //parametros.add(new SentenciaParametroDAO("p_A041CLAVE", objetoEntrada.getClave(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,UsuarioDAO.class);
        }

        return objetoSalida;
    }
} 

