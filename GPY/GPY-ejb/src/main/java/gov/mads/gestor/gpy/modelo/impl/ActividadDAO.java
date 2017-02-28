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
import gov.mads.gestor.gpy.vista.ActualizarIndicadorOE;
import gov.mads.gestor.gpy.vista.ActualizarMetaOE;
import gov.mads.gestor.gpy.vista.ActualizarSoporteOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarIndicadorOE;
import gov.mads.gestor.gpy.vista.ConsultarMetaOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.EliminarIndicadorOE;
import gov.mads.gestor.gpy.vista.EliminarMetaOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.RegistrarIndicadorOE;
import gov.mads.gestor.gpy.vista.RegistrarMetaOE;

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
			Integer sectoripcc = (objetoEntrada.getActividad().getA005idsectoripcc() == null) ? null : objetoEntrada.getActividad().getA005idsectoripcc().getA045codigo(); 
                        parametros.add(new SentenciaParametroDAO("p_A005IDSECTORIPCC", sectoripcc, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Long costototal = (objetoEntrada.getActividad().getA005costototal() == null) ? null : objetoEntrada.getActividad().getA005costototal().longValue(); 
                        parametros.add(new SentenciaParametroDAO("p_A005COSTOTOTAL", costototal, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Long contrbcnprop = (objetoEntrada.getActividad().getA005contrbcnprop()== null) ? null : objetoEntrada.getActividad().getA005costototal().longValue();
                        parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNPROP", contrbcnprop, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			Long contrbcextrn = (objetoEntrada.getActividad().getA005contrbcnextrn() == null) ? null : objetoEntrada.getActividad().getA005contrbcnextrn().longValue();  
                        parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNEXTRN", contrbcextrn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			//java.sql.Date a002fechinicio = (objetoEntrada.getActividad().getA005fechainicio() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechainicio().getYear(),objetoEntrada.getActividad().getA005fechainicio().getMonth(),objetoEntrada.getActividad().getA005fechainicio().getDate());
                        java.sql.Date a002fechinicio = (objetoEntrada.getActividad().getA005fechainicio() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechainicio().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A005FECHAINICIO", a002fechinicio, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        //java.sql.Date a002fechfin = (objetoEntrada.getActividad().getA005fechafinal() == null) ? null : new java.sql.Date(objetoEntrada.getActividad().getA005fechafinal().getYear(),objetoEntrada.getActividad().getA005fechafinal().getMonth(),objetoEntrada.getActividad().getA005fechafinal().getDate());
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
                        Integer sectoripcc = (objetoEntrada.getActividad().getA005idsectoripcc() == null) ? null : objetoEntrada.getActividad().getA005idsectoripcc().getA045codigo(); 
			parametros.add(new SentenciaParametroDAO("p_A005IDSECTORIPCC", sectoripcc, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			Integer costototal = (objetoEntrada.getActividad().getA005costototal() == null) ? null : objetoEntrada.getActividad().getA005costototal().intValue(); 
                        parametros.add(new SentenciaParametroDAO("p_A005COSTOTOTAL", costototal, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Integer contrbcnprop = (objetoEntrada.getActividad().getA005costototal() == null) ? null : objetoEntrada.getActividad().getA005costototal().intValue();
                        parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNPROP", contrbcnprop, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			Integer contrbcextrn = (objetoEntrada.getActividad().getA005contrbcnextrn() == null) ? null : objetoEntrada.getActividad().getA005contrbcnextrn().intValue();  
                        parametros.add(new SentenciaParametroDAO("p_A005CONTRBCNEXTRN", contrbcextrn, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
                    parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getSoporte().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
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
                    parametros.add(new SentenciaParametroDAO("p_A026HASHARCHIVO", objetoEntrada.getSoporte().getA026hasharchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
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
        
        public ObjetoSalida registrarIndicador(RegistrarIndicadorOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_RegistrarIndicador", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A011NOMBRINDCDR", objetoEntrada.getIndicador().getA011nombrindcdr(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A011IDTIPINDCDR", objetoEntrada.getIndicador().getA011idtipindcdr().getA034codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A011IDACTVDD", objetoEntrada.getIndicador().getA011idactvdd().getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A011IDTIPACCION", objetoEntrada.getIndicador().getA011idtipaccion().getA050codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));//*/
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
        
        public ObjetoSalida eliminarIndicador(EliminarIndicadorOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_EliminarIndicador", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                        parametros.add(new SentenciaParametroDAO("p_A011CODIGO", objetoEntrada.getIndicador().getA011codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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

        public ObjetoSalida actualizarIndicador(ActualizarIndicadorOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ActualizarIndicador", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A011CODIGO", objetoEntrada.getIndicador().getA011codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A011NOMBRINDCDR", objetoEntrada.getIndicador().getA011nombrindcdr(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));//*/
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
        
        public ObjetoSalida consultarIndicador(ConsultarIndicadorOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ConsultarIndicador", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A005CODIGO", objetoEntrada.getIndicador().getA011idactvdd().getA005codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));//*/
                        parametros.add(new SentenciaParametroDAO("p_A011CODIGO", objetoEntrada.getIndicador().getA011codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
        
        public ObjetoSalida registrarMeta(RegistrarMetaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_RegistrarMeta", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                        java.sql.Date a012fechameta = ( objetoEntrada.getMeta().getA012fechameta() == null) ? null : new java.sql.Date(objetoEntrada.getMeta().getA012fechameta().getTime());
			parametros.add(new SentenciaParametroDAO("p_A012FECHAMETA", a012fechameta, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        parametros.add(new SentenciaParametroDAO("p_A012VALORMETA", objetoEntrada.getMeta().getA012valormeta().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        java.sql.Date a012reprtanfuntindicdr = ( objetoEntrada.getMeta().getA012reprtanfuntindicdr() == null) ? null : new java.sql.Date(objetoEntrada.getMeta().getA012reprtanfuntindicdr().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A012REPRTANFUNTINDICDR", a012reprtanfuntindicdr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        parametros.add(new SentenciaParametroDAO("p_A012VALRLOGRD", objetoEntrada.getMeta().getA012valrlogrd().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A012ACCIONESREALIZADAS", objetoEntrada.getMeta().getA012accionesrealizadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A012RECURSSINVRTDS", objetoEntrada.getMeta().getA012recurssinvrtds().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Integer a012idfuente = (objetoEntrada.getMeta().getA012idfuente() == null) ? null : objetoEntrada.getMeta().getA012idfuente().getA039codigo();
                        parametros.add(new SentenciaParametroDAO("p_A012IDFUENTE", a012idfuente, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Integer a012idindcdr = (objetoEntrada.getMeta().getA012idindcdr() == null) ? null : objetoEntrada.getMeta().getA012idindcdr().getA011codigo();
                        parametros.add(new SentenciaParametroDAO("p_A012IDINDCDR", a012idindcdr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A012UNIDDMEDD", objetoEntrada.getMeta().getA012uniddmedd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
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

        
        public ObjetoSalida eliminarMeta(EliminarMetaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_EliminarMeta", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A012CODIGO", objetoEntrada.getMeta().getA012codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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

        
        public ObjetoSalida actualizarMeta(ActualizarMetaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ActualizarMeta", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
                        parametros.add(new SentenciaParametroDAO("p_A012CODIGO", objetoEntrada.getMeta().getA012codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A012VALORMETA", objetoEntrada.getMeta().getA012valormeta().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        java.sql.Date a012reprtanfuntindicdr = ( objetoEntrada.getMeta().getA012reprtanfuntindicdr() == null) ? null : new java.sql.Date(objetoEntrada.getMeta().getA012reprtanfuntindicdr().getTime());
                        parametros.add(new SentenciaParametroDAO("p_A012REPRTANFUNTINDICDR", a012reprtanfuntindicdr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        parametros.add(new SentenciaParametroDAO("p_A012VALRLOGRD", objetoEntrada.getMeta().getA012valrlogrd().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A012ACCIONESREALIZADAS", objetoEntrada.getMeta().getA012accionesrealizadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        parametros.add(new SentenciaParametroDAO("p_A012RECURSSINVRTDS", objetoEntrada.getMeta().getA012recurssinvrtds().floatValue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Integer a012idfuente = (objetoEntrada.getMeta().getA012idfuente() == null) ? null : objetoEntrada.getMeta().getA012idfuente().getA039codigo();
                        parametros.add(new SentenciaParametroDAO("p_A012IDFUENTE", a012idfuente, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        Integer a012idindcdr = (objetoEntrada.getMeta().getA012idindcdr() == null) ? null : objetoEntrada.getMeta().getA012idindcdr().getA011codigo();
                        parametros.add(new SentenciaParametroDAO("p_A012IDINDCDR", a012idindcdr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A012UNIDDMEDD", objetoEntrada.getMeta().getA012uniddmedd(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

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

        
        public ObjetoSalida consultarMeta(ConsultarMetaOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_GPY_ACTIVIDAD.Pr_ConsultarMeta", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A012CODIGO", objetoEntrada.getMeta().getA012codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
