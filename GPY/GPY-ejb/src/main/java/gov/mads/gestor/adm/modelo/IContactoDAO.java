/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.ActualizarContactoOE;
import gov.mads.gestor.adm.vista.ConsultarContactoPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarContactoOE;


/**
 *
 * @author juanmetalmolina
 */
public interface IContactoDAO {
    ObjetoSalida registrarContacto(RegistrarContactoOE OE);
    ObjetoSalida consultarContactoPorId(ConsultarContactoPorIdOE OE); 
    ObjetoSalida actualizarContacto(ActualizarContactoOE OE);
}
