/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo.impl;

import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarPersonaOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaDocumentoOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaPorIdOE;
import gov.mads.gestor.gpy.vista.RegistrarPersonaJuridicaOE;
import gov.mads.gestor.gpy.vista.RegistrarPersonaNaturalOE;
import gov.mads.gestor.adm.vista.RegistrarPersonaOE;
import gov.mads.gestor.comun.vista.ErrorClass;
import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanmetalmolina
 */
public class PersonaDAO extends GenericoDAO {

    public ObjetoSalida registrarPersonaNatural(RegistrarPersonaNaturalOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PERSONA.Pr_RegistrarPersonaNatural", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041CODIGO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041NOMBRE", objetoEntrada.getA041NOMBRE(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041APELLIDO", objetoEntrada.getA041APELLIDO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041TIPDOCMNT", objetoEntrada.getA041TIPDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041NUMRDOCMNT", objetoEntrada.getA041NUMRDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041LGREXPCNDOCMNT", objetoEntrada.getA041LGREXPCNDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041DIRCCNCORRSPNDNC", objetoEntrada.getA041DIRCCNCORRSPNDNC(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041LOCLZCN", objetoEntrada.getA041LOCLZCN(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CELULAR", objetoEntrada.getA041CELULAR(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CORRELCTRNC", objetoEntrada.getA041CORRELCTRNC(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041TELEFONO", objetoEntrada.getA041TELEFONO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CODGCIIU", objetoEntrada.getA041CODGCIIU(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            //parametros.add(new SentenciaParametroDAO("A041LOCLZCN", objetoEntrada.getContrasena(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida registrarPersonaJuridica(RegistrarPersonaJuridicaOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PERSONA.Pr_RegistrarPersonaJuridica", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041CODIGO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041IDTIPPERSN", objetoEntrada.getA041IDTIPPERSN(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041APELLIDO", objetoEntrada.getA041APELLIDO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041TIPDOCMNT", objetoEntrada.getA041TIPDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041NUMRDOCMNT", objetoEntrada.getA041NUMRDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CODGCIIU", objetoEntrada.getA041CODGCIIU(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041DIRCCNCORRSPNDNC", objetoEntrada.getA041DIRCCNCORRSPNDNC(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041LOCLZCN", objetoEntrada.getA041LOCLZCN(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CORRELCTRNC", objetoEntrada.getA041CORRELCTRNC(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041TELEFONO", objetoEntrada.getA041TELEFONO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CELULAR", objetoEntrada.getA041CELULAR(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida registrarPersona(RegistrarPersonaOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PERSONA.Pr_RegistrarPersona", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A052IDTIPPERSN", objetoEntrada.getPersona().getA052idtippersn().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPersona().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPersona().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getPersona().getA052tipdocmnt().getA015codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPersona().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052LGREXPCNDOCMNT", objetoEntrada.getPersona().getA052lgrexpcndocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getPersona().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", objetoEntrada.getPersona().getA052loclzcn().getA020codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getPersona().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getPersona().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getPersona().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CODGCIIU", objetoEntrada.getPersona().getA052codgciiu().getA049codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", objetoEntrada.getPersona().getA052identidad().getA001codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            String digtchqu = (objetoEntrada.getPersona().getA052digtchqu() == null) ? null : objetoEntrada.getPersona().getA052digtchqu().toString();
            parametros.add(new SentenciaParametroDAO("p_A052DIGTCHQU", digtchqu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);

        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida consultarPersonaPorId(ConsultarPersonaPorIdOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();
        
        try {
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PERSONA.Pr_ConsultarPersonaPorId", objetoEntrada.getIdUsuario());

            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A052CODIGO", objetoEntrada.getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            sentencia.setParametros(parametros);

            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        } catch (Exception e) {
            
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
            
        }
        
        return objetoSalida;
        
        
    }
    
    //ActualizarPersonaOS actualizarPersona(ActualizarPersonaOE actualizarpersonaOE);
    public ObjetoSalida actualizarPersona(ActualizarPersonaOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();
        
        try {
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PERSONA.Pr_ActualizarPersona", objetoEntrada.getIdUsuario());

            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            /*parametros.add(new SentenciaParametroDAO("p_A041CODIGO", objetoEntrada.getA041CODIGO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041IDTIPPERSN", objetoEntrada.getA041IDTIPPERSN(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041NOMBRE", objetoEntrada.getA041NOMBRE(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041APELLIDO", objetoEntrada.getA041APELLIDO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041TIPDOCMNT", objetoEntrada.getA041TIPDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041NUMRDOCMNT", objetoEntrada.getA041NUMRDOCMNT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));    
            parametros.add(new SentenciaParametroDAO("p_A041CODGCIIU", objetoEntrada.getA041CODGCIIU(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041LGREXPCNDOCMNT", objetoEntrada.getA041CODGCIIU(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));                      
            parametros.add(new SentenciaParametroDAO("p_A041DIRCCNCORRSPNDNC", objetoEntrada.getA041DIRCCNCORRSPNDNC(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041LOCLZCN", objetoEntrada.getA041LOCLZCN(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A041TELEFONO", objetoEntrada.getA041TELEFONO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A041CELULAR", objetoEntrada.getA041CELULAR(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));                       
            parametros.add(new SentenciaParametroDAO("p_A041CORRELCTRNC", objetoEntrada.getA041CORRELCTRNC(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));                       
            */
            parametros.add(new SentenciaParametroDAO("p_A052CODIGO", objetoEntrada.getPersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052IDTIPPERSN", objetoEntrada.getPersona().getA052idtippersn().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPersona().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPersona().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getPersona().getA052tipdocmnt().getA015codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPersona().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            String digtchqu = (objetoEntrada.getPersona().getA052digtchqu() == null) ? null : objetoEntrada.getPersona().getA052digtchqu().toString();
            parametros.add(new SentenciaParametroDAO("p_A052DIGTCHQU", digtchqu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer codgciuu = (objetoEntrada.getPersona().getA052codgciiu()== null) ?  null : objetoEntrada.getPersona().getA052codgciiu().getA049codigo();
            parametros.add(new SentenciaParametroDAO("p_A052CODGCIIU", codgciuu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052LGREXPCNDOCMNT", objetoEntrada.getPersona().getA052lgrexpcndocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));                      
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getPersona().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", objetoEntrada.getPersona().getA052loclzcn().getA020codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getPersona().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getPersona().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));                       
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getPersona().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));                       
            Integer a052identidad = (objetoEntrada.getPersona().getA052identidad() == null) ?  null : objetoEntrada.getPersona().getA052identidad().getA001codigo(); 
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD",a052identidad, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                       
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        } catch (Exception e) {
            
            //TODO Revisar si es el mensaje de error correcto
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
            
        }
        
        return objetoSalida;
        
        
    }
    
    public ObjetoSalida consultarPersonaDocumento(ConsultarPersonaDocumentoOE objetoEntrada){
        ObjetoSalida objetoSalida = new ObjetoSalida();
        
        try {
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_PERSONA.Pr_ConsultarPersonaPorDoc", objetoEntrada.getIdUsuario());

            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

            sentencia.setParametros(parametros);

            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        } catch (Exception e) {
            
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,PersonaDAO.class);
        }
        
        return objetoSalida;
    }
} 
