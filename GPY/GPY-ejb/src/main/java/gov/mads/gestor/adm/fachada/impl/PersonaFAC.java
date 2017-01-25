/*
 * Clase Fachada de Persona
 */
package gov.mads.gestor.adm.fachada.impl;
import gov.mads.gestor.adm.modelo.impl.PersonaDAO;
import gov.mads.gestor.gpy.vista.RegistrarPersonaNaturalOE;
import gov.mads.gestor.gpy.vista.RegistrarPersonaJuridicaOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.fachada.IPersonaFAC;
import gov.mads.gestor.adm.vista.ActualizarPersonaOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaDocumentoOE;
import gov.mads.gestor.adm.vista.ConsultarPersonaPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarPersonaOE;

/**
 *
 * @author juanmetalmolina
 */
public class PersonaFAC implements IPersonaFAC {

    private final PersonaDAO GpyPersonaDAO = new PersonaDAO ();

    public ObjetoSalida registrarPersonaNatural(RegistrarPersonaNaturalOE registrarpersonanaturalOE) {

        return GpyPersonaDAO.registrarPersonaNatural(registrarpersonanaturalOE);
    }
    
    public ObjetoSalida registrarPersonaJuridica(RegistrarPersonaJuridicaOE registrarpersonajuridicaOE) {

        return GpyPersonaDAO.registrarPersonaJuridica(registrarpersonajuridicaOE);
    }

    public ObjetoSalida consultarPersonaPorId(ConsultarPersonaPorIdOE consultarpersonaporidOE) {
        
        return GpyPersonaDAO.consultarPersonaPorId(consultarpersonaporidOE);
    }
    
    
    public ObjetoSalida actualizarPersona(ActualizarPersonaOE actualizarPersonaOE){
        
        return GpyPersonaDAO.actualizarPersona(actualizarPersonaOE);
    }
    
    public ObjetoSalida registrarPersona(RegistrarPersonaOE OE){
        
        return GpyPersonaDAO.registrarPersona(OE);
    }
    
    public ObjetoSalida consultarPersonaDocumento(ConsultarPersonaDocumentoOE OE){
        return GpyPersonaDAO.consultarPersonaDocumento(OE);
    }
}
