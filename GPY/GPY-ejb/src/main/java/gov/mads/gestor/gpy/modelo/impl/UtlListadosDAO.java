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

import gov.mads.gestor.gpy.vista.ListarParticipantesOE;

/**
 *
 * @author Ivan Chacon
 */
public class UtlListadosDAO extends GenericoDAO { 
    
        public ObjetoSalida listarParticipantes(ListarParticipantesOE objetoEntrada) {

		ObjetoSalida objetoSalida = new ObjetoSalida();
		try {
			SentenciaDAO sentencia = new SentenciaDAO("PK_PARTICIPANTE.Pr_ListarParticipantes", objetoEntrada.getIdUsuario());
			List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
			//parametros.add(new SentenciaParametroDAO("p_A05IDPROYECTO", objetoEntrada.getA05IDPROYECTO(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			//parametros.add(new SentenciaParametroDAO("p_idUsuario", objetoEntrada.getidUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			sentencia.setParametros(parametros);
			objetoSalida = this.ejecutarX(sentencia, objetoSalida);
                        ErrorClass.getMessage(objetoSalida,UtlListadosDAO.class);
		} catch (Exception e) {
			objetoSalida.setCodError(CodError.ERROR_INTERNO);
			objetoSalida.setMsgError(e.getMessage());
                        ErrorClass.getMessage(objetoSalida,UtlListadosDAO.class);
		}

		return objetoSalida;

	}

}
