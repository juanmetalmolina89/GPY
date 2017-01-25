/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo.impl;

import gov.mads.gestor.adm.vista.ActualizarPublicadorOE;
import gov.mads.gestor.adm.vista.ConsultarPublicadorPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarPublicadorOE;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author juanmetalmolina
 */
public class PublicadorDAO extends GenericoDAO{
    
    public ObjetoSalida registrarPublicador(RegistrarPublicadorOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PUBLICADOR.Pr_RegistrarPublicador", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
       
            parametros.add(new SentenciaParametroDAO("p_IdPersona", objetoEntrada.getPublicador().getA055idpersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            //Integer a052codigo = (objetoEntrada.getPublicador().getA055idpublicador().getA052codigo() == null) ? null: objetoEntrada.getPublicador().getA055idpublicador().getA052codigo();
            //parametros.add(new SentenciaParametroDAO("p_A052CODIGO", a052codigo, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPublicador().getA055idpublicador().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPublicador().getA055idpublicador().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getPublicador().getA055idpublicador().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052loclzcn = (objetoEntrada.getPublicador().getA055idpublicador().getA052loclzcn() == null) ? null : objetoEntrada.getPublicador().getA055idpublicador().getA052loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", a052loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052tipdocumnt = (objetoEntrada.getPublicador().getA055idpublicador().getA052tipdocmnt() == null) ? null : objetoEntrada.getPublicador().getA055idpublicador().getA052tipdocmnt().getA015codigo();
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", a052tipdocumnt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPublicador().getA055idpublicador().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getPublicador().getA055idpublicador().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getPublicador().getA055idpublicador().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getPublicador().getA055idpublicador().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052identidad = (objetoEntrada.getPublicador().getA055idpublicador().getA052identidad() == null) ? null : objetoEntrada.getPublicador().getA055idpublicador().getA052identidad().getA001codigo();
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", a052identidad, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PublicadorDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PublicadorDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida consultarPublicadorPorId(ConsultarPublicadorPorIdOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PUBLICADOR.Pr_ConsultarPublicadorPorId", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A055IDPERSONA", objetoEntrada.getA055idpersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A055CODIGO", objetoEntrada.getA055codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PublicadorDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PublicadorDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida actualizarPublicador(ActualizarPublicadorOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PUBLICADOR.Pr_ActualizarPublicador", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A052CODIGO", objetoEntrada.getPublicador().getA055idpublicador().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPublicador().getA055idpublicador().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPublicador().getA055idpublicador().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getPublicador().getA055idpublicador().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052loclzcn = (objetoEntrada.getPublicador().getA055idpublicador().getA052loclzcn() == null) ? null : objetoEntrada.getPublicador().getA055idpublicador().getA052loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", a052loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052tipdocumnt = (objetoEntrada.getPublicador().getA055idpublicador().getA052tipdocmnt() == null) ? null : objetoEntrada.getPublicador().getA055idpublicador().getA052tipdocmnt().getA015codigo();
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", a052tipdocumnt, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPublicador().getA055idpublicador().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getPublicador().getA055idpublicador().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getPublicador().getA055idpublicador().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getPublicador().getA055idpublicador().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            //parametros.add(new SentenciaParametroDAO("p_A041LOCLZCN", objetoEntrada.getContrasena(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PublicadorDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PublicadorDAO.class);
        }

        return objetoSalida;
    }
}
