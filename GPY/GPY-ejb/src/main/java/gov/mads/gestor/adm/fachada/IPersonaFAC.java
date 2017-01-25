/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada;
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
public interface IPersonaFAC {
    public ObjetoSalida registrarPersonaNatural(RegistrarPersonaNaturalOE registrarpersonanaturalOE);
    public ObjetoSalida registrarPersonaJuridica(RegistrarPersonaJuridicaOE registrarpersonajuridicaOE);
    public ObjetoSalida consultarPersonaPorId(ConsultarPersonaPorIdOE consultarpersonaporidOE);
    public ObjetoSalida actualizarPersona(ActualizarPersonaOE actualizarPersonaOE);
    public ObjetoSalida registrarPersona(RegistrarPersonaOE OE);
    public ObjetoSalida consultarPersonaDocumento(ConsultarPersonaDocumentoOE OE);
}
