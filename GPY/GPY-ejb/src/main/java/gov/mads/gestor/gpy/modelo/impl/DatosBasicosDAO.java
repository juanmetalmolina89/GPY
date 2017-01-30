/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.modelo.impl;
import gov.mads.gestor.gpy.vista.RegistrarProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarProyectoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoAsociadoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSectorImplementOE;
import gov.mads.gestor.gpy.vista.ListarProyectosOE;
import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanmetalmolina
 */
public class DatosBasicosDAO extends GenericoDAO{
    
    public ObjetoSalida registrarProyecto(RegistrarProyectoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {
            
            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_RegistrarProyecto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A002NOMBRPROYCT", objetoEntrada.getProyecto().getA002nombrproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002DESCRPCINPROYCT", objetoEntrada.getProyecto().getA002descrpcinproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a002tipproyct = (objetoEntrada.getProyecto().getA002tipproyct()== null) ? null : objetoEntrada.getProyecto().getA002tipproyct().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002TIPPROYCT", a002tipproyct, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002DURCNPREVST", objetoEntrada.getProyecto().getA002durcnprevst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002proytascd = (objetoEntrada.getProyecto().getA002proytascd() == null) ? null : objetoEntrada.getProyecto().getA002proytascd().getA002codigo();
            parametros.add(new SentenciaParametroDAO("p_A002PROYTASCD", a002proytascd, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002ubccn = (objetoEntrada.getProyecto().getA002ubccn() == null) ? null : objetoEntrada.getProyecto().getA002ubccn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002UBCCN", a002ubccn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002loclzcn = (objetoEntrada.getProyecto().getA002loclzcn() == null) ? null : objetoEntrada.getProyecto().getA002loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A002LOCLZCN", a002loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idusr = (objetoEntrada.getProyecto().getA002idusr() == null) ? null : objetoEntrada.getProyecto().getA002idusr().getA041codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDUSR", a002idusr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002SOCEXTRNJR", objetoEntrada.getProyecto().getA002socextrnjr(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.CHAR));
            Long costsestmdtl = (objetoEntrada.getProyecto().getA002costsestmdtotl() == null) ? null : objetoEntrada.getProyecto().getA002costsestmdtotl().longValue();  
            parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDTOTL", costsestmdtl, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long costsestmdformlcn = (objetoEntrada.getProyecto().getA002costsestmdformlcn() == null) ? null : objetoEntrada.getProyecto().getA002costsestmdformlcn().longValue();
            parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDFORMLCN",costsestmdformlcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long costtonldrdcr = (objetoEntrada.getProyecto().getA002costtonldrdcr() == null) ? null : objetoEntrada.getProyecto().getA002costtonldrdcr().longValue();
            parametros.add(new SentenciaParametroDAO("p_A002COSTTONLDRDCR", costtonldrdcr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long trm  = (objetoEntrada.getProyecto().getA002trm() == null) ? null : objetoEntrada.getProyecto().getA002trm().longValue();
            parametros.add(new SentenciaParametroDAO("p_A002TRM", trm, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002BUSQUDFINNCCN", objetoEntrada.getProyecto().getA002busqudfinnccn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002PLANPRGRMNACNL", objetoEntrada.getProyecto().getA002planprgrmnacnl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002OBJTVGENRL", objetoEntrada.getProyecto().getA002objtvgenrl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002POTNCLESTMDREDCCN", objetoEntrada.getProyecto().getA002potnclestmdredccn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002NOMBRPROYCTINGLS", objetoEntrada.getProyecto().getA002nombrproyctingls(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002TECNLGCONTMPLD", objetoEntrada.getProyecto().getA002tecnlgcontmpld(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a002idescala = (objetoEntrada.getProyecto().getA002idescala() == null) ? null: objetoEntrada.getProyecto().getA002idescala().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDESCALA", a002idescala, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idalcance = (objetoEntrada.getProyecto().getA002idalcance() == null) ? null : objetoEntrada.getProyecto().getA002idalcance().getA102codigo(); 
            parametros.add(new SentenciaParametroDAO("p_A002IDALCANCE", a002idalcance, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idmetdlgmdl = (objetoEntrada.getProyecto().getA002idmetdlgmdl() == null) ? null : objetoEntrada.getProyecto().getA002idmetdlgmdl().getA028codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDMETDLGMDL", a002idmetdlgmdl, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idsectoralscope = (objetoEntrada.getProyecto().getA002idsectoralscope()== null) ? null : objetoEntrada.getProyecto().getA002idsectoralscope().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDSECTORALSCOPE", a002idsectoralscope, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002NROCPAS", objetoEntrada.getProyecto().getA002nrocpas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002PROCSVALDCNEC", objetoEntrada.getProyecto().getA002procsvaldcnec(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a002idestdprocsvaldcn = (objetoEntrada.getProyecto().getA002idestdprocsvaldcn() == null) ? null: objetoEntrada.getProyecto().getA002idestdprocsvaldcn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDESTDPROCSVALDCN",a002idestdprocsvaldcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idproyctmdl = (objetoEntrada.getProyecto().getA002idproyctmdl() == null) ? null : objetoEntrada.getProyecto().getA002idproyctmdl().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDPROYCTMDL", a002idproyctmdl, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002VIDAUTL", objetoEntrada.getProyecto().getA002vidautl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idtipperdacrdtcn = (objetoEntrada.getProyecto().getA002idtipperdacrdtcn() == null)? null : objetoEntrada.getProyecto().getA002idtipperdacrdtcn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDTIPPERDACRDTCN", a002idtipperdacrdtcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            //String a002fechinicio = (objetoEntrada.getProyecto().getA002fechinicio() == null) ? null : objetoEntrada.getProyecto().getA002fechinicio().toString();
            java.sql.Date a002fechinicio = (objetoEntrada.getProyecto().getA002fechinicio() == null) ? null : new java.sql.Date(objetoEntrada.getProyecto().getA002fechinicio().getTime());
            parametros.add(new SentenciaParametroDAO("p_A002FECHINICIO", a002fechinicio, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            //parametros.add(new SentenciaParametroDAO("p_A002FECHINICIO", objetoEntrada.getProyecto().getA002fechinicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            //String a002fechfin = (objetoEntrada.getProyecto().getA002fechfin() == null) ? null : objetoEntrada.getProyecto().getA002fechinicio().toString();
            java.sql.Date a002fechfin = (objetoEntrada.getProyecto().getA002fechfin() == null) ? null : new java.sql.Date(objetoEntrada.getProyecto().getA002fechinicio().getTime());           
            parametros.add(new SentenciaParametroDAO("p_A002FECHFIN", a002fechfin, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            //parametros.add(new SentenciaParametroDAO("p_A002FECHFIN", objetoEntrada.getProyecto().getA002fechfin(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_A002APLICMERCDVOLNTR", objetoEntrada.getProyecto().getA002aplicmercdvolntr(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Integer a002idestndrmercdvolntr = (objetoEntrada.getProyecto().getA002idestndrmercdvolntr() == null) ? null : objetoEntrada.getProyecto().getA002idestndrmercdvolntr().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDESTNDRMERCDVOLNTR", a002idestndrmercdvolntr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            //parametros.add(new SentenciaParametroDAO("p_A002POTNCLESTMDREDCCN", objetoEntrada.getProyecto().getA002potnclestmdredccn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    public ObjetoSalida registrarSectorImplementador(RegistrarSectorImplementadorOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_RegistrarSectorImplement", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A006IDPROYECTO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A006IDSECTRIMPLMNTDR", objetoEntrada.getSector().getA006idsectrimplmntdr().getA023codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            String a006detalleotro = (objetoEntrada.getSector().getA006detalleotro() == null) ? null : objetoEntrada.getSector().getA006detalleotro();
            parametros.add(new SentenciaParametroDAO("p_A006DETALLEOTRO", a006detalleotro, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    
    
     public ObjetoSalida consultarProyectoPorId(ConsultarProyectoPorIdOE objetoEntrada){

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_ConsultarProyectoPorId", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida actualizarProyecto(ActualizarProyectoOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_ActualizarProyecto", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getProyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002NOMBRPROYCT", objetoEntrada.getProyecto().getA002nombrproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002DESCRPCINPROYCT", objetoEntrada.getProyecto().getA002descrpcinproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a002tipproyct = (objetoEntrada.getProyecto().getA002tipproyct()== null) ? null : objetoEntrada.getProyecto().getA002tipproyct().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002TIPPROYCT", a002tipproyct, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002DURCNPREVST", objetoEntrada.getProyecto().getA002durcnprevst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002proytascd = (objetoEntrada.getProyecto().getA002proytascd() == null) ? null : objetoEntrada.getProyecto().getA002proytascd().getA002codigo();
            parametros.add(new SentenciaParametroDAO("p_A002PROYTASCD", a002proytascd, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002ubccn = (objetoEntrada.getProyecto().getA002ubccn() == null) ? null : objetoEntrada.getProyecto().getA002ubccn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002UBCCN", a002ubccn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002loclzcn = (objetoEntrada.getProyecto().getA002loclzcn() == null) ? null : objetoEntrada.getProyecto().getA002loclzcn().getA020codigo();
            parametros.add(new SentenciaParametroDAO("p_A002LOCLZCN", a002loclzcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idusr = (objetoEntrada.getProyecto().getA002idusr() == null) ? null : objetoEntrada.getProyecto().getA002idusr().getA041codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDUSR", a002idusr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002SOCEXTRNJR", objetoEntrada.getProyecto().getA002socextrnjr(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.CHAR));
            Long costsestmdtl = (objetoEntrada.getProyecto().getA002costsestmdtotl() == null) ? null : objetoEntrada.getProyecto().getA002costsestmdtotl().longValue();  
            parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDTOTL", costsestmdtl, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long costsestmdformlcn = (objetoEntrada.getProyecto().getA002costsestmdformlcn() == null) ? null : objetoEntrada.getProyecto().getA002costsestmdformlcn().longValue();
            parametros.add(new SentenciaParametroDAO("p_A002COSTSESTMDFORMLCN",costsestmdformlcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long costtonldrdcr = (objetoEntrada.getProyecto().getA002costtonldrdcr() == null) ? null : objetoEntrada.getProyecto().getA002costtonldrdcr().longValue();
            parametros.add(new SentenciaParametroDAO("p_A002COSTTONLDRDCR", costtonldrdcr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long trm  = (objetoEntrada.getProyecto().getA002trm() == null) ? null : objetoEntrada.getProyecto().getA002trm().longValue();
            parametros.add(new SentenciaParametroDAO("p_A002TRM", trm, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002BUSQUDFINNCCN", objetoEntrada.getProyecto().getA002busqudfinnccn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002PLANPRGRMNACNL", objetoEntrada.getProyecto().getA002planprgrmnacnl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002OBJTVGENRL", objetoEntrada.getProyecto().getA002objtvgenrl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002POTNCLESTMDREDCCN", objetoEntrada.getProyecto().getA002potnclestmdredccn(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002NOMBRPROYCTINGLS", objetoEntrada.getProyecto().getA002nombrproyctingls(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_A002TECNLGCONTMPLD", objetoEntrada.getProyecto().getA002tecnlgcontmpld(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a002idescala = (objetoEntrada.getProyecto().getA002idescala() == null) ? null: objetoEntrada.getProyecto().getA002idescala().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDESCALA", a002idescala, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idalcance = (objetoEntrada.getProyecto().getA002idalcance() == null) ? null : objetoEntrada.getProyecto().getA002idalcance().getA102codigo(); 
            parametros.add(new SentenciaParametroDAO("p_A002IDALCANCE", a002idalcance, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idmetdlgmdl = (objetoEntrada.getProyecto().getA002idmetdlgmdl() == null) ? null : objetoEntrada.getProyecto().getA002idmetdlgmdl().getA028codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDMETDLGMDL", a002idmetdlgmdl, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idsectoralscope = (objetoEntrada.getProyecto().getA002idsectoralscope()== null) ? null : objetoEntrada.getProyecto().getA002idsectoralscope().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDSECTORALSCOPE", a002idsectoralscope, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002NROCPAS", objetoEntrada.getProyecto().getA002nrocpas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002PROCSVALDCNEC", objetoEntrada.getProyecto().getA002procsvaldcnec(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Integer a002idestdprocsvaldcn = (objetoEntrada.getProyecto().getA002idestdprocsvaldcn() == null) ? null: objetoEntrada.getProyecto().getA002idestdprocsvaldcn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDESTDPROCSVALDCN",a002idestdprocsvaldcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idproyctmdl = (objetoEntrada.getProyecto().getA002idproyctmdl() == null) ? null : objetoEntrada.getProyecto().getA002idproyctmdl().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDPROYCTMDL", a002idproyctmdl, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002VIDAUTL", objetoEntrada.getProyecto().getA002vidautl(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Integer a002idtipperdacrdtcn = (objetoEntrada.getProyecto().getA002idtipperdacrdtcn() == null)? null : objetoEntrada.getProyecto().getA002idtipperdacrdtcn().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDTIPPERDACRDTCN", a002idtipperdacrdtcn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            java.sql.Date a002fechinicio = (objetoEntrada.getProyecto().getA002fechinicio() == null) ? null : new java.sql.Date(objetoEntrada.getProyecto().getA002fechinicio().getTime());
            parametros.add(new SentenciaParametroDAO("p_A002FECHINICIO", a002fechinicio, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            java.sql.Date a002fechfin = (objetoEntrada.getProyecto().getA002fechfin() == null) ? null : new java.sql.Date(objetoEntrada.getProyecto().getA002fechinicio().getTime());           
            parametros.add(new SentenciaParametroDAO("p_A002FECHFIN", a002fechfin, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_A002APLICMERCDVOLNTR", objetoEntrada.getProyecto().getA002aplicmercdvolntr(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Integer a002idestndrmercdvolntr = (objetoEntrada.getProyecto().getA002idestndrmercdvolntr() == null) ? null : objetoEntrada.getProyecto().getA002idestndrmercdvolntr().getA102codigo();
            parametros.add(new SentenciaParametroDAO("p_A002IDESTNDRMERCDVOLNTR", a002idestndrmercdvolntr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida consultarProyectoAsociado(ConsultarProyectoAsociadoOE objetoEntrada){

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_ConsultarProyectoAsociado", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            parametros.add(new SentenciaParametroDAO("p_A002TIPPROYCT", objetoEntrada.getA002tipproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    
    
    
    public ObjetoSalida listarProyectos(ListarProyectosOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_ListarProyectos", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    
    
    public ObjetoSalida consultarSectorImplement(ConsultarSectorImplementOE objetoEntrada) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOS_BASICOS.Pr_ConsultarSectorImplement", objetoEntrada.getIdUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            
            parametros.add(new SentenciaParametroDAO("p_A006IDPROYECTO", objetoEntrada.getA006IDPROYECTO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            sentencia.setParametros(parametros);
            objetoSalida = this.ejecutar(sentencia, objetoSalida);
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);

        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida,DatosBasicosDAO.class);
        }

        return objetoSalida;
    }
    
}