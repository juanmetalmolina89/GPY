/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo.impl;

import gov.mads.gestor.adm.vista. RegistrarRepresentanteOE;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarRepresentanteOE;
import gov.mads.gestor.gpy.vista.AdjuntarDocumentoOE;
import gov.mads.gestor.gpy.vista.ConsultarDocumentoPorIdOE;
import gov.mads.gestor.adm.vista.ConsultarRepresentantePorIdOE;
import gov.mads.gestor.comun.vista.ErrorClass;
import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanmetalmolina
 */
public class RepresentanteDAO extends GenericoDAO {

    public ObjetoSalida registrarRepresentante(RegistrarRepresentanteOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPRESENTANTE.Pr_RegistrarRepresentante", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_IdPersonaJuridica", objetoEntrada.getRepresentante().getA053idpersonajurd().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052idtippersn = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052idtippersn() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052idtippersn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A052IDTIPPERSN", a052idtippersn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A053TIPOREPRESENTANTE", objetoEntrada.getRepresentante().getA053tiporepresentante().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getRepresentante().getA053idrepresentante().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getRepresentante().getA053idrepresentante().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getRepresentante().getA053idrepresentante().getA052tipdocmnt().getA015codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getRepresentante().getA053idrepresentante().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052LGREXPCNDOCMNT", objetoEntrada.getRepresentante().getA053idrepresentante().getA052lgrexpcndocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getRepresentante().getA053idrepresentante().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            String a052digtchqu = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052digtchqu() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052digtchqu().toString();
            parametros.add(new SentenciaParametroDAO("p_A052DIGTCHQU", a052digtchqu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052loclzcn = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052loclzcn() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", a052loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getRepresentante().getA053idrepresentante().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getRepresentante().getA053idrepresentante().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getRepresentante().getA053idrepresentante().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052codgciiu = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052digtchqu() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052codgciiu().getA049codigo();
            parametros.add(new SentenciaParametroDAO("p_A052CODGCIIU", a052codgciiu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052identidad = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052identidad() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052identidad().getA001codigo();
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", a052identidad, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida consultarRepresentantePorId(ConsultarRepresentantePorIdOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPRESENTANTE.Pr_ConsultarRepresentantePorId", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A053CODIGO", objetoEntrada.getA053codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A053IDPERSONAJURD", objetoEntrada.getA053idpersonajurd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida actualizarRepresentante(ActualizarRepresentanteOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {                
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPRESENTANTE.Pr_ActualizarRepresentante", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A053CODIGO", objetoEntrada.getRepresentante().getA053codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A053IDPERSONAJURD", objetoEntrada.getRepresentante().getA053idpersonajurd().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052IDTIPPERSN", objetoEntrada.getRepresentante().getA053idrepresentante().getA052idtippersn().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A053TIPOREPRESENTANTE", objetoEntrada.getRepresentante().getA053tiporepresentante().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getRepresentante().getA053idrepresentante().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getRepresentante().getA053idrepresentante().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getRepresentante().getA053idrepresentante().getA052tipdocmnt().getA015codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getRepresentante().getA053idrepresentante().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052LGREXPCNDOCMNT", objetoEntrada.getRepresentante().getA053idrepresentante().getA052lgrexpcndocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052DIRCCNCORRSPNDNC", objetoEntrada.getRepresentante().getA053idrepresentante().getA052dirccncorrspndnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            String a052digtchqu = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052digtchqu() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052digtchqu().toString();
            parametros.add(new SentenciaParametroDAO("p_A052DIGTCHQU", a052digtchqu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            Integer a052loclzcn = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052loclzcn() == null) ? null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A052LOCLZCN", a052loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A052TELEFONO", objetoEntrada.getRepresentante().getA053idrepresentante().getA052telefono(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CELULAR", objetoEntrada.getRepresentante().getA053idrepresentante().getA052celular(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getRepresentante().getA053idrepresentante().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a052codgciiu = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052codgciiu() == null) ?  null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052codgciiu().getA049codigo();
            parametros.add(new SentenciaParametroDAO("p_A052CODGCIIU", a052codgciiu, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a052identidad = (objetoEntrada.getRepresentante().getA053idrepresentante().getA052identidad()== null) ?  null : objetoEntrada.getRepresentante().getA053idrepresentante().getA052identidad().getA001codigo();
            parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", a052identidad, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida adjuntarDocumento(AdjuntarDocumentoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPRESENTANTE.Pr_RegistrarAdjunto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A053CODIGO", objetoEntrada.getA053codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getAdjuntarArchivo().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getAdjuntarArchivo().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getAdjuntarArchivo().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        }

        return objetoSalida;
    }

    public ObjetoSalida actualizarDocumento(AdjuntarDocumentoOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPRESENTANTE.Pr_ActualizarAdjunto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A026CODIGO", objetoEntrada.getAdjuntarArchivo().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getAdjuntarArchivo().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getAdjuntarArchivo().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getAdjuntarArchivo().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        }

        return objetoSalida;
    }

    public ObjetoSalida consultarDocumentoPorId(ConsultarDocumentoPorIdOE objetoEntrada) {
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_REPRESENTANTE.Pr_ConsultarAdjuntoPorId", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A053CODIGO", objetoEntrada.getA053codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A026CODIGO", objetoEntrada.getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,RepresentanteDAO.class);
        }

        return objetoSalida;

    }
}
