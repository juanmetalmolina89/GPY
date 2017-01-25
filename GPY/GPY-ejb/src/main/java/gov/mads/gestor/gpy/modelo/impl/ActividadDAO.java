package gov.mads.gestor.gpy.modelo.impl;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import oracle.jdbc.OracleTypes;
import org.jose4j.json.internal.json_simple.JSONObject;
import java.util.ArrayList;
import java.util.List;

import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarGeometriaOE;
import gov.mads.gestor.gpy.vista.ActualizarSoporteOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;

/**
 *
 * @author Ivan Chacon
 */
public class ActividadDAO extends GenericoDAO { 

        public ObjetoSalida registrarActividad(RegistrarActividadOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_RegistrarActividad", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A005DESCRPCNACTVDD", objetoEntrada.getActividad().getA005descrpcnactvdd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A005IDTIPACTVDD", objetoEntrada.getActividad().getA005idtipactvdd().getA022codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getActividad().getA005idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDSECTORIPCC", objetoEntrada.getActividad().getA005idsectoripcc().getA045codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005COSTOTOTAL", objetoEntrada.getActividad().getA005costototal().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNPROP", objetoEntrada.getActividad().getA005contrbcnprop().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNEXTRN", objetoEntrada.getActividad().getA005contrbcnextrn().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			java.sql.Date a002fechinicio = (objetoEntrada.getActividad().getA005fechainicio() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechainicio().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A005FECHAINICIO", a002fechinicio, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        java.sql.Date a002fechfin = (objetoEntrada.getActividad().getA005fechafinal() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechafinal().getTime());
			parametros.add(new SentenciaParametroDAO("p_A005FECHAFINAL", a002fechfin, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        /*
                        parametros.add(new SentenciaParametroDAO("p_A005DESCRPCNACTVDD", objetoEntrada.getActividad().getA005descrpcnactvdd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A005IDTIPACTVDD", objetoEntrada.getActividad().getA005idtipactvdd().getA022codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005UBCCNGEGRFC", objetoEntrada.getActividad().getA005ubccngegrfc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getActividad().getA005idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDSECTORIPCC", objetoEntrada.getActividad().getA005idsectoripcc().getA045codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDSOPORTE", objetoEntrada.getActividad().getA005idsoporte().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005COSTOTOTAL", objetoEntrada.getActividad().getA005costototal().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNPROP", objetoEntrada.getActividad().getA005contrbcnprop().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNEXTRN", objetoEntrada.getActividad().getA005contrbcnextrn().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			*/
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida actualizarActividad(ActualizarActividadOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ActualizarActividad", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getActividad().getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
/*			parametros.add(new SentenciaParametroDAO("p_A005DESCRPCNACTVDD", objetoEntrada.getActividad().getA005descrpcnactvdd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A005IDTIPACTVDD", objetoEntrada.getActividad().getA005idtipactvdd().getA022codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005UBCCNGEGRFC", objetoEntrada.getActividad().getA005ubccngegrfc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getActividad().getA005idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDSECTORIPCC", objetoEntrada.getActividad().getA005idsectoripcc().getA045codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDSOPORTE", objetoEntrada.getActividad().getA005idsoporte().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005COSTOTOTAL", objetoEntrada.getActividad().getA005costototal().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNPROP", objetoEntrada.getActividad().getA005contrbcnprop().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNEXTRN", objetoEntrada.getActividad().getA005contrbcnextrn().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));*/
			parametros.add(new SentenciaParametroDAO("p_A005DESCRPCNACTVDD", objetoEntrada.getActividad().getA005descrpcnactvdd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A005IDTIPACTVDD", objetoEntrada.getActividad().getA005idtipactvdd().getA022codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getActividad().getA005idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDSECTORIPCC", objetoEntrada.getActividad().getA005idsectoripcc().getA045codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005COSTOTOTAL", objetoEntrada.getActividad().getA005costototal().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNPROP", objetoEntrada.getActividad().getA005contrbcnprop().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNEXTRN", objetoEntrada.getActividad().getA005contrbcnextrn().intValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			java.sql.Date a002fechinicio = (objetoEntrada.getActividad().getA005fechainicio() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechainicio().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A005FECHAINICIO", a002fechinicio, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        java.sql.Date a002fechfin = (objetoEntrada.getActividad().getA005fechafinal() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechafinal().getTime());
			parametros.add(new SentenciaParametroDAO("p_A005FECHAFINAL", a002fechfin, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));

			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida eliminarActividad(EliminarActividadOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_EliminarActividad", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getActividad().getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}
         // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        public ObjetoSalida consultarActividadPorId(ConsultarActividadPorIdOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ConsultarActividadPorId", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A002CODIGO", objetoEntrada.getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida registrarSoporte(RegistrarSoporteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_RegistrarSoporte", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getSoporte().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getSoporte().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getSoporte().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutar(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
                }

                return objetoSalida;

	}
        
        public ObjetoSalida actualizarSoporte(ActualizarSoporteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ActualizarSoporte", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                    parametros.add(new SentenciaParametroDAO("p_A026CODIGO", objetoEntrada.getSoporte().getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                    parametros.add(new SentenciaParametroDAO("p_A026DESCRPCNARCHIV", objetoEntrada.getSoporte().getA026descrpcnarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026NOMARCHIVO", objetoEntrada.getSoporte().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getSoporte().getA026rutarchiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutar(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
                }

                return objetoSalida;

	}
        public ObjetoSalida consultarSoportePorId(ConsultarSoportePorIdOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ConsultarSoportePorId", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A026CODIGO", objetoEntrada.getA026codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A005IDPROYECTO", objetoEntrada.getA005idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida registrarGeometria(RegistrarGeometriaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_RegistrarGeografia", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A042IDPROYECTO", objetoEntrada.getGeometria().getA042idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042IDACTVDD", objetoEntrada.getGeometria().getA042idactvdd().getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042NROSITIO", objetoEntrada.getGeometria().getA042nrositio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042GEOMETRIA_SITIO", objetoEntrada.getA042geometriasitio().toJSONString(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.BLOB));
			parametros.add(new SentenciaParametroDAO("p_A042GEOMETRIA_INTERSECC", objetoEntrada.getA042geometriaintersec().toJSONString(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.BLOB));
			
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida actualizarGeometria(ActualizarGeometriaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ActualizarGeografia", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			
                        sentencia.setParametros(parametros);
                        parametros.add(new SentenciaParametroDAO("p_A042CODIGO", objetoEntrada.getGeometria().getA042codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A042IDPROYECTO", objetoEntrada.getGeometria().getA042idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042IDACTVDD", objetoEntrada.getGeometria().getA042idactvdd().getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042NROSITIO", objetoEntrada.getGeometria().getA042nrositio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042GEOMETRIA_SITIO", objetoEntrada.getA042geometriasitio().toJSONString(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.BLOB));
			parametros.add(new SentenciaParametroDAO("p_A042GEOMETRIA_INTERSECC", objetoEntrada.getA042geometriaintersec().toJSONString(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.BLOB));

                        objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida consultarGeometriaPorId(ConsultarGeometriaPorIdOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ConsultarGeografiaPorId", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A042CODIGO", objetoEntrada.getA042codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A042IDPROYECTO", objetoEntrada.getA042idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A042IDACTVDD", objetoEntrada.getA042idactividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
                        sentencia.setParametros(parametros);
			objetoSalida = this.ejecutar(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
		}

		return objetoSalida;

	}
        public ObjetoSalida listarActividades(ListarActividadesOE objetoEntrada) {
        
                ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ListarActividades", objetoEntrada.getIdUsuario());
                    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

                    sentencia.setParametros(parametros);
                    objetoSalida = this.ejecutar(sentencia, objetoSalida);
                    ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,ActividadDAO.class);
                }

                return objetoSalida;
        }

}
