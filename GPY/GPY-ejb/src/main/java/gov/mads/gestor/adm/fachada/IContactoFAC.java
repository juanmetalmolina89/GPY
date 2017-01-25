/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada;
import gov.mads.gestor.adm.vista.RegistrarContactoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarContactoOE;
import gov.mads.gestor.adm.vista.ConsultarContactoPorIdOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IContactoFAC {
    public ObjetoSalida registrarContacto(RegistrarContactoOE OE);
    public ObjetoSalida consultarContactoPorId(ConsultarContactoPorIdOE OE);
    public ObjetoSalida actualizarContacto(ActualizarContactoOE OE);
    
}
