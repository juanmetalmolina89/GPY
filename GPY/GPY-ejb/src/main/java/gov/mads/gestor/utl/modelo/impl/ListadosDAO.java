/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.modelo.impl;
import gov.mads.gestor.utl.vista.ListarAutoridadesOE;
import gov.mads.gestor.utl.vista.ListarTipoProyectoOE;
import gov.mads.gestor.utl.vista.ListarTipoPersonaOE;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.vista.ListarAlcanceProyectoOE;
import gov.mads.gestor.utl.vista.ListarCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarClaseUsuarioOE;
import gov.mads.gestor.utl.vista.ListarCodigoCIIUOE;
import gov.mads.gestor.utl.vista.ListarSectorImplementadorOE;
import gov.mads.gestor.utl.vista.ListarTipoDocumentoOE;
import gov.mads.gestor.utl.vista.ListarUbicacionProyectoOE;
import gov.mads.gestor.utl.vista.ListarPaisesOE;
import gov.mads.gestor.utl.vista.ListarDepartamentoOE;
import gov.mads.gestor.utl.vista.ListarDesagregacionIPCCOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv3OE;
import gov.mads.gestor.utl.vista.ListarFtesFinancOE;
import gov.mads.gestor.utl.vista.ListarMetdMDLOE;
import gov.mads.gestor.utl.vista.ListarMunicipioOE;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import gov.mads.gestor.utl.vista.ListarParticipanteOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv2OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv4OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv1OE;
import gov.mads.gestor.utl.vista.ListarPoliticaOE;
import gov.mads.gestor.utl.vista.ListarSectorIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubGrupoIPCCOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadReducOE;

import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanmetalmolina
 */
public class ListadosDAO extends GenericoDAO {
    
    public ObjetoSalida listarAutoridades(ListarAutoridadesOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarAutoridades", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarTipoProyecto(ListarTipoProyectoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            //SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarTipoProyecto", objetoEntrada.getIdUsuario());
            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarParametricas", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_Categoria", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarTipoDocumento(ListarTipoDocumentoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            //SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarTipoDocumento", objetoEntrada.getIdUsuario());
            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarTipoDocumento", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_TipoPersona", objetoEntrada.getTipodocumento().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            //parametros.add(new SentenciaParametroDAO("", objetoEntrada.getCategoria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarTipoPersona(ListarTipoPersonaOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            //SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarTipoPersona", objetoEntrada.getIdUsuario());
            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarParametricas", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_Categoria", objetoEntrada.getCategoria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarClaseUsuario(ListarClaseUsuarioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            //SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarClaseUsuario", objetoEntrada.getIdUsuario());
            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarParametricas", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_Categoria", objetoEntrada.getCategoria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarUbicacionProyecto(ListarUbicacionProyectoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarUbicacionProyecto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("idUsuario", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarAlcanceProyecto(ListarAlcanceProyectoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            //SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarAlcanceProyecto", objetoEntrada.getIdUsuario());
            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarAlcanceProyecto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("idUsuario", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);

        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
     public ObjetoSalida listarSectorImplementador(ListarSectorImplementadorOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarSectorImplementador", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A023IDTIPPROYCT", objetoEntrada.getIdtipproyct().getA023codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
     
    public ObjetoSalida listarPaises(ListarPaisesOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarPaises", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            //parametros.add(new SentenciaParametroDAO("idUsuario", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarDepartamento(ListarDepartamentoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarDepartamentos", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A020CODPAIS", objetoEntrada.getPaises().getA020codpais(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarMunicipio(ListarMunicipioOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarMunicipios", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            //parametros.add(new SentenciaParametroDAO("idUsuario", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A020CODDEPARTAMENTO", objetoEntrada.getDepartamento().getA020coddepartamento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarParametrico(ListarParametricoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            //SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarClaseUsuario", objetoEntrada.getIdUsuario());
            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarParametricas", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_Categoria", objetoEntrada.getCategoria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarCodigoCIIU(ListarCodigoCIIUOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarCodigoCIIU", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            //parametros.add(new SentenciaParametroDAO("idUsuario", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }

    public ObjetoSalida listarTipoActividades(ListarTipoActividadOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarTipoActividad", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A022IDTIPPROYCT", objetoEntrada.getA022idtipproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
           // parametros.add(new SentenciaParametroDAO("p_A022IDTIPPROYCTMDL", objetoEntrada.getA022idtipproyctmdl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarSectorIPCC(ListarSectorIPCCOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarSectorIPCC", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            //parametros.add(new SentenciaParametroDAO("idUsuario", objetoEntrada.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarCategoriaIPCC(ListarCategoriaIPCCOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarCategoriaIPCC", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A046IDSUBGRUPOIPCC", objetoEntrada.getA046idsector(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }

    public ObjetoSalida listarSubCategoriaIPCC(ListarSubCategoriaIPCCOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarSubCategoriaIPCC", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A047IDCATIPCC", objetoEntrada.getA047idcatipcc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarDesagregacionIPCC(ListarDesagregacionIPCCOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarDesagregacionIPCC", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A048IDSUBCATIPCC", objetoEntrada.getA048idsubcatipcc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarMetdMDL(ListarMetdMDLOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarMetodMDL", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A028IDESCL", objetoEntrada.getA028idescl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A028IDSECTORALSCOPE", objetoEntrada.getA028idsectoralscope(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarParticipante(ListarParticipanteOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_ListarParticipantes", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarArbolPolNv1(ListarArbolPolNv1OE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_Listar_arbolPol_nvl_1", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarArbolPolNv2(ListarArbolPolNv2OE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_Listar_arbolPol_nvl_2", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A003NIVEL1", objetoEntrada.getA003nivel1(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarArbolPolNv3(ListarArbolPolNv3OE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_Listar_arbolPol_nvl_3", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A003NIVEL2", objetoEntrada.getA003nivel2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarArbolPolNv4(ListarArbolPolNv4OE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_Listar_arbolPol_nvl_4", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A003NIVEL3", objetoEntrada.getA003nivel3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
        
    public ObjetoSalida listarFuentesFinanciacion(ListarFtesFinancOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarFtesFinanc", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarTipoActividadReduccion(ListarTipoActividadReducOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarActividadesReduc", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A058TIPPROYCT", objetoEntrada.getA058tipproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarSubgrupoIPCC(ListarSubGrupoIPCCOE objetoEntrada) {
        
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarSubgrupoIPCC", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A043IDSECTORIPCC", objetoEntrada.getA043idsectoripcc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida listarPoliticas(ListarPoliticaOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_UTL_LISTADOS.Pr_ListarPoliticas", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }

        return objetoSalida;
    }
}