/*
 * Interfaz DAO GPY Persona 
 */
package gov.mads.gestor.adm.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarPersonaOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaDocumentoOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaPorIdOE;

import gov.mads.gestor.gpy.vista.RegistrarPersonaJuridicaOE;
import gov.mads.gestor.gpy.vista.RegistrarPersonaNaturalOE;
import gov.mads.gestor.adm.vista.RegistrarPersonaOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IPersonaDAO {
    ObjetoSalida registrarPersona(RegistrarPersonaOE OE);
    ObjetoSalida registrarPersonaNatural(RegistrarPersonaNaturalOE registrarpersonanaturalOE);
    ObjetoSalida registrarPersonaJuridica(RegistrarPersonaJuridicaOE registrarpersonajuridicaOE);
    ObjetoSalida consultarPersonaPorId (ConsultarPersonaPorIdOE consultarpersonaporidOE);
    ObjetoSalida actualizarPersona(ActualizarPersonaOE actualizarpersonaOE);
    ObjetoSalida consultarPersonaDocumento(ConsultarPersonaDocumentoOE OE);
}
