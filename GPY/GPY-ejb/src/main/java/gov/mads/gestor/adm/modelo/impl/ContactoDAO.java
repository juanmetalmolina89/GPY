/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo.impl;
import gov.mads.gestor.adm.vista.RegistrarContactoOE;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarContactoOE;
import gov.mads.gestor.adm.vista.ConsultarContactoPorIdOE;
import gov.mads.gestor.comun.vista.ErrorClass;
import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanmetalmolina
 */
public class ContactoDAO extends GenericoDAO {

    public ObjetoSalida registrarContacto(RegistrarContactoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_CONTACTO.Pr_RegistrarContacto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
       
            parametros.add(new SentenciaParametroDAO("p_IdPersona", objetoEntrada.getContacto().getA054idpersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052codigo = (objetoEntrada.getContacto().getA054idcontacto().getA052codigo() == null) ? null: objetoEntrada.getContacto().getA054idcontacto().getA052codigo();
            parametros.add(new SentenciaParametroDAO("p_A052CODIGO", a052codigo, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getContacto().getA054idcontacto().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getContacto().getA054idcontacto().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getContacto().getA054idcontacto().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052loclzcn = (objetoEntrada.getContacto().getA054idcontacto().getA052loclzcn() == null) ? null : objetoEntrada.getContacto().getA054idcontacto().getA052loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", a052loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052tipdocumnt = (objetoEntrada.getContacto().getA054idcontacto().getA052tipdocmnt() == null) ? null : objetoEntrada.getContacto().getA054idcontacto().getA052tipdocmnt().getA015codigo();
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", a052tipdocumnt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getContacto().getA054idcontacto().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getContacto().getA054idcontacto().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getContacto().getA054idcontacto().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getContacto().getA054idcontacto().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052identidad = (objetoEntrada.getContacto().getA054idcontacto().getA052identidad() == null) ? null : objetoEntrada.getContacto().getA054idcontacto().getA052identidad().getA001codigo();
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", a052identidad, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ContactoDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ContactoDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida consultarContactoPorId(ConsultarContactoPorIdOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_CONTACTO.Pr_ConsultarContactoPorId", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A054IDPERSONA", objetoEntrada.getIdpersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A054CODIGO", objetoEntrada.getA054codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ContactoDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ContactoDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida actualizarContacto(ActualizarContactoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_CONTACTO.Pr_ActualizarContacto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A052CODIGO", objetoEntrada.getContacto().getA054idcontacto().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getContacto().getA054idcontacto().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getContacto().getA054idcontacto().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getContacto().getA054idcontacto().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052loclzcn = (objetoEntrada.getContacto().getA054idcontacto().getA052loclzcn() == null) ? null : objetoEntrada.getContacto().getA054idcontacto().getA052loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", a052loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052tipdocumnt = (objetoEntrada.getContacto().getA054idcontacto().getA052tipdocmnt() == null) ? null : objetoEntrada.getContacto().getA054idcontacto().getA052tipdocmnt().getA015codigo();
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", a052tipdocumnt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getContacto().getA054idcontacto().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getContacto().getA054idcontacto().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getContacto().getA054idcontacto().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getContacto().getA054idcontacto().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            //parametros.add(new SentenciaParametroDAO("p_A041LOCLZCN", objetoEntrada.getContrasena(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ContactoDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ContactoDAO.class);
        }

        return objetoSalida;
    }
}
