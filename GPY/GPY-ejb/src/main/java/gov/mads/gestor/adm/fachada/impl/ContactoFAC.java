/*
 * Fachada Gpy Contacto
 */
package gov.mads.gestor.adm.fachada.impl;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.modelo.impl.ContactoDAO;
import gov.mads.gestor.adm.vista.RegistrarContactoOE;
import gov.mads.gestor.adm.fachada.IContactoFAC;
import gov.mads.gestor.adm.vista.ActualizarContactoOE;
import gov.mads.gestor.adm.vista.ConsultarContactoPorIdOE;

/**
 *
 * @author juanmetalmolina
 */
public class ContactoFAC implements IContactoFAC{
    private final ContactoDAO GpyContactoDAO = new ContactoDAO ();

    public ObjetoSalida registrarContacto(RegistrarContactoOE OE) {

        return GpyContactoDAO.registrarContacto(OE);
    }


    public ObjetoSalida consultarContactoPorId(ConsultarContactoPorIdOE OE) {
        return GpyContactoDAO.consultarContactoPorId(OE);
    }

    
    public ObjetoSalida actualizarContacto(ActualizarContactoOE OE) {
        return GpyContactoDAO.actualizarContacto(OE);
    }
}
