package gov.mads.gestor.gpy.modelo.impl;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ActualizarPoliticasNuevasOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaNuevaOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasNuevasOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoPoliticaOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaNuevaOE;
import oracle.jdbc.OracleTypes;
import java.util.ArrayList;
import java.util.List;

import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;

/**
 *
 * @author Ivan Chacon
 */
public class PoliticaDAO extends GenericoDAO { 
        
        public ObjetoSalida registrarPolitica(RegistrarPoliticaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_RegistrarPolitica", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			/*parametros.add(new SentenciaParametroDAO("p_A003DESCRPCNPOLTC", objetoEntrada.getPolitica().getA003descrpcnpoltc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A003IDARCHIV", objetoEntrada.getPolitica().getA003idarchiv().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                                p_A007IDPROYECTO     IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
                                p_A003NIVEL1         IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
                                p_A003NOMNIVEL1      IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
                                p_A003NIVEL2         IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
                                p_A003NOMNIVEL2      IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
                                p_A003NIVEL3         IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
                                p_A003NOMNIVEL3      IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
                                p_A003NONIVEL4       IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
        p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                        p_A026NOMARCHIVO     IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
        p_A026HASHARCHIVO    IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                        */
                        parametros.add(new SentenciaParametroDAO("p_A007IDPROYECTO", objetoEntrada.getProypolitica().getA007idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NIVEL1", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel1(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL1", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel1(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A003NIVEL2", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL2", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A003NIVEL3", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL3", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL4", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel4(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			Integer idarchivo = (objetoEntrada.getProypolitica().getA007idpolitica().getA003idarchiv() == null) ?  null : objetoEntrada.getProypolitica().getA007idpolitica().getA003idarchiv().getA026codigo();
                        parametros.add(new SentenciaParametroDAO("P_A026CODIGO", idarchivo, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        //parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getPolitica().getA003idarchiv().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        //parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getPolitica().getA003idarchiv().getA026nomarchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			//parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getPolitica().getA003idarchiv().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		}

		return objetoSalida;

	}
        public ObjetoSalida consultarPoliticaPorId(ConsultarPoliticaPorIdOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_ConsultarPoliticaPorId", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida actualizarPolitica(ActualizarPoliticaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_ActualizarPolitica", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			sentencia.setParametros(parametros);
			parametros.add(new SentenciaParametroDAO("p_A007IDPROYECTO", objetoEntrada.getProypolitica().getA007idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NIVEL1", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel1(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL1", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel1(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A003NIVEL2", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL2", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A003NIVEL3", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL3", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A003NIVEL4", objetoEntrada.getProypolitica().getA007idpolitica().getA003nivel4(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A003NOMNIVEL4", objetoEntrada.getProypolitica().getA007idpolitica().getA003nomnivel4(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			//parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getPolitica().getA003idarchiv().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        //parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getPolitica().getA003idarchiv().getA026nomarchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			//parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getPolitica().getA003idarchiv().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        
                        objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida eliminarPolitica(EliminarPoliticaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_EliminarPolitica", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                        parametros.add(new SentenciaParametroDAO("p_A007CODIGO", objetoEntrada.getA007codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida listarPoliticasProyecto(ListarPoliticasProyectoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_ListarPoliticasProyecto", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                        parametros.add(new SentenciaParametroDAO(" p_A007IDPROYECTO", objetoEntrada.getIdpoliticaproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida registrarSoporte(RegistrarAdjuntoPoliticaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_RegistrarArchivoPolitica", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    //parametros.add(new SentenciaParametroDAO("p_A003CODIGO", objetoEntrada.getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getAdjuntarArchivo().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getAdjuntarArchivo().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getAdjuntarArchivo().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                }

                return objetoSalida;

	}
        
        public ObjetoSalida registrarPoliticaNueva(RegistrarPoliticaOE objetoEntrada){
                
		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_T007_PROY_POLITICA.Pr_Insertar", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    //parametros.add(new SentenciaParametroDAO("p_A003CODIGO", objetoEntrada.getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A007IDPROYECTO", objetoEntrada.getProypolitica().getA007idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A007IDPOLITICA", objetoEntrada.getProypolitica().getA007idpolitica().getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                }

                return objetoSalida;
        }
        
        public ObjetoSalida registrarPoliticaProy(RegistrarPoliticaNuevaOE objetoEntrada){
                
		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_RegistrarPryPolitica", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    //parametros.add(new SentenciaParametroDAO("p_A003CODIGO", objetoEntrada.getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A059IDPROYECTO", objetoEntrada.getPolitica().getA059idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A059DESCRIPCION", objetoEntrada.getPolitica().getA059descripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                }

                return objetoSalida;
        }
        
        public ObjetoSalida actualizarPoliticaProy(ActualizarPoliticasNuevasOE objetoEntrada){
                
		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_ActualizarPryPolitica", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    parametros.add(new SentenciaParametroDAO("p_A059CODIGO", objetoEntrada.getPolitica().getA059codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A059IDPROYECTO", objetoEntrada.getPolitica().getA059idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A059DESCRIPCION", objetoEntrada.getPolitica().getA059descripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                }

                return objetoSalida;
        }

        public ObjetoSalida eliminarPoliticaProy(EliminarPoliticaNuevaOE objetoEntrada){
                
		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_EliminarPryPolitica", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    //parametros.add(new SentenciaParametroDAO("p_A003CODIGO", objetoEntrada.getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A059CODIGO", objetoEntrada.getA059codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    //parametros.add(new SentenciaParametroDAO("p_A007IDPOLITICA", objetoEntrada.getProypolitica().getA007idpolitica().getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                }

                return objetoSalida;
        }
        
        public ObjetoSalida listarPoliticasProy(ListarPoliticasNuevasOE objetoEntrada){
                
		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_POLITICA.Pr_ListarPryPolitica", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    //parametros.add(new SentenciaParametroDAO("p_A003CODIGO", objetoEntrada.getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A059IDPROYECTO", objetoEntrada.getA059idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    //parametros.add(new SentenciaParametroDAO("p_A007IDPOLITICA", objetoEntrada.getProypolitica().getA007idpolitica().getA003codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,PoliticaDAO.class);
                }

                return objetoSalida;
        }
}
