package gov.mads.gestor.gpy.modelo.impl;
import gov.mads.gestor.comun.modelo.GenericoDAO;
import gov.mads.gestor.comun.modelo.SentenciaDAO;
import gov.mads.gestor.comun.modelo.SentenciaParametroDAO;
import gov.mads.gestor.comun.modelo.SentenciaTipoParametroDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import oracle.jdbc.OracleTypes;
import java.util.ArrayList;
import java.util.List;

import gov.mads.gestor.gpy.vista.RegistrarParticipanteOE;
import gov.mads.gestor.gpy.vista.ActualizarParticipanteOE;
import gov.mads.gestor.gpy.vista.ConsultarParticipanteOE;
import gov.mads.gestor.gpy.vista.EliminarParticipanteOE;
import gov.mads.gestor.gpy.vista.ListarParticipanteProyectoOE;

/**
 *
 * @author Ivan Chacon
 */
public class ParticipanteDAO extends GenericoDAO { 

        public ObjetoSalida registrarParticipante(RegistrarParticipanteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_RegistrarParticipante", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
/*			parametros.add(new SentenciaParametroDAO("p_A052CODIGO", objetoEntrada.getPersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPersona().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPersona().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getPersona().getA052tipdocmnt().getA015codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPersona().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getPersona().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", objetoEntrada.getPersona().getA052identidad().getA001codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A051RESPONSABILIDAD", objetoEntrada.getParticipante().getA051responsabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));*/
                        parametros.add(new SentenciaParametroDAO("p_A05IDPROYECTO", objetoEntrada.getParticipante().getA05idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A051IDPERSONA", objetoEntrada.getParticipante().getA051idpersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A051RESPONSABILIDAD", objetoEntrada.getParticipante().getA051responsabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida actualizarParticipante(ActualizarParticipanteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_ActualizarParticipante", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			/*parametros.add(new SentenciaParametroDAO("p_A051CODIGO", objetoEntrada.getParticipante().getA051codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A052CODIGO", objetoEntrada.getPersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A052NOMBRE", objetoEntrada.getPersona().getA052nombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052APELLIDO", objetoEntrada.getPersona().getA052apellido(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052TIPDOCMNT", objetoEntrada.getPersona().getA052tipdocmnt().getA015codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A052NUMRDOCMNT", objetoEntrada.getPersona().getA052numrdocmnt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052CORRELCTRNC", objetoEntrada.getPersona().getA052correlctrnc(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_A052IDENTIDAD", objetoEntrada.getPersona().getA052identidad().getA001codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A051RESPONSABILIDAD", objetoEntrada.getParticipante().getA051responsabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));*/
                        parametros.add(new SentenciaParametroDAO("p_A051CODIGO", objetoEntrada.getParticipante().getA051codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        parametros.add(new SentenciaParametroDAO("p_A05IDPROYECTO", objetoEntrada.getParticipante().getA05idproyecto().getA002codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A051IDPERSONA", objetoEntrada.getParticipante().getA051idpersona().getA052codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_A051RESPONSABILIDAD", objetoEntrada.getParticipante().getA051responsabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		}

		return objetoSalida;

	}

	public ObjetoSalida eliminarParticipante(EliminarParticipanteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_EliminarParticipante", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A051CODIGO", objetoEntrada.getParticipante().getA051codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		}

		return objetoSalida;

	}
        public ObjetoSalida consultarParticipante(ConsultarParticipanteOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_ConsultarParticipante", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A051CODIGO", objetoEntrada.getA051codigo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		}

		return objetoSalida;

	}
        
        public ObjetoSalida listarParticipantesProyecto(ListarParticipanteProyectoOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_ListarParticipantesProyecto", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			parametros.add(new SentenciaParametroDAO("p_A05IDPROYECTO", objetoEntrada.getA051idproyecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,ParticipanteDAO.class);
		}

		return objetoSalida;

	}
}
