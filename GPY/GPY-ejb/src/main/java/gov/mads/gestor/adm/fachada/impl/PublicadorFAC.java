/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada.impl;

import gov.mads.gestor.adm.fachada.IPublicadorFAC;
import gov.mads.gestor.adm.modelo.impl.PublicadorDAO;
import gov.mads.gestor.adm.vista.ActualizarPublicadorOE;
import gov.mads.gestor.adm.vista.ConsultarPublicadorPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarPublicadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;

/**
 *
 * @author juanmetalmolina
 */
public class PublicadorFAC implements IPublicadorFAC{

    PublicadorDAO publicadorDAO = new PublicadorDAO();
    public ObjetoSalida registrarPublicador(RegistrarPublicadorOE OE) {
        return publicadorDAO.registrarPublicador(OE);
    }

    
    public ObjetoSalida actualizarPublicador(ActualizarPublicadorOE OE) {
        return publicadorDAO.actualizarPublicador(OE);
    }

    
    public ObjetoSalida consultarPublicadorPorId(ConsultarPublicadorPorIdOE OE) {
        return publicadorDAO.consultarPublicadorPorId(OE);
    }
    
}
