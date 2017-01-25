package gov.mads.gestor.gpy.modelo.impl;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ActualizarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ActualizarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ConsultarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ConsultarConsideracOE;
import gov.mads.gestor.gpy.vista.ListarAdjuntosOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;
import oracle.jdbc.OracleTypes;
import java.util.ArrayList;
import java.util.List;

import gov.mads.gestor.gpy.vista.RegistrarConsideracOE;
import gov.mads.gestor.gpy.vista.RegistrarCartaNObjOE;

/**
 *
 * @author Ivan Chacon
 */
public class DatosMdlDAO extends GenericoDAO { 

	public ObjetoSalida registrarConsiderac(RegistrarConsideracOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_RegistrarConsiderac", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getProyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Integer idsectoralscope = (objetoEntrada.getProyecto().getA002idsectoralscope() == null) ? null :  objetoEntrada.getProyecto().getA002idsectoralscope().getA102codigo();
                        parametros.add(new SentenciaParametroDAO("p_A002IDSECTORALSCOPE", idsectoralscope, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002NOMBRPROYCTINGLS", objetoEntrada.getProyecto().getA002nombrproyctingls(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A002TECNLGCONTMPLD", objetoEntrada.getProyecto().getA002tecnlgcontmpld(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			//parametros.add(new SentenciaParametroDAO("p_A003IDARCHIV", objetoEntrada.getPolitica().getA003idarchiv().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			//parametros.add(new SentenciaParametroDAO("p_A003IDARCHIV_2", objetoEntrada.getPolitica().getA003idarchiv_2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}

	public ObjetoSalida registrarCartaNObj(RegistrarCartaNObjOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_RegistrarCartaNObj", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getProyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002IDESCALA", objetoEntrada.getProyecto().getA002idescala().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002IDMETDLGMDL", objetoEntrada.getProyecto().getA002idmetdlgmdl().getA028codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}
        public ObjetoSalida consultarConsiderac(ConsultarConsideracOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ConsultarConsiderac", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}

	public ObjetoSalida consultarCartaNObj(ConsultarCartaNObjOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ConsultarCartaNObj", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}
        public ObjetoSalida registrarAdjunto(RegistrarAdjuntoOE objetoEntrada){
                ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_RegistrarAdjunto", objetoEntrada.getIdUsuario());
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

                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                }

                return objetoSalida;

        }
        
        public ObjetoSalida consultarAdjunto(ConsultarAdjuntoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ConsultarAdjuntos", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A025IDPANTALLA", objetoEntrada.getA025idpantalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}
        
        public ObjetoSalida listarAdjuntos(ListarAdjuntosOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ListarAdjuntos", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002TIPPROYCT", objetoEntrada.getA002tipproyct(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A025IDPANTALLA", objetoEntrada.getA0025idpantalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}
        
        public ObjetoSalida actualizarConsiderac(ActualizarConsideracOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ActualizarConsiderac", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getProyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			Integer idsectoralscope = (objetoEntrada.getProyecto().getA002idsectoralscope() == null) ? null :  objetoEntrada.getProyecto().getA002idsectoralscope().getA102codigo();
                        parametros.add(new SentenciaParametroDAO("p_A002IDSECTORALSCOPE", idsectoralscope, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A002NOMBRPROYCTINGLS", objetoEntrada.getProyecto().getA002nombrproyctingls(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A002TECNLGCONTMPLD", objetoEntrada.getProyecto().getA002tecnlgcontmpld(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}
        
        public ObjetoSalida actualizarCartaNObj(ActualizarCartaNObjOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ActualizarCartaNObj", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getProyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002IDESCALA", objetoEntrada.getProyecto().getA002idescala().getA102codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002IDMETDLGMDL", objetoEntrada.getProyecto().getA002idmetdlgmdl().getA028codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
		}

		return objetoSalida;

	}
        
        public ObjetoSalida actualizarAdjunto(ActualizarAdjuntoOE objetoEntrada){
                ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_DATOSMDL.Pr_ActualizarAdjunto", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    parametros.add(new SentenciaParametroDAO("p_A025CODIGO", objetoEntrada.getA025codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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

                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                }

                return objetoSalida;

        }
}
