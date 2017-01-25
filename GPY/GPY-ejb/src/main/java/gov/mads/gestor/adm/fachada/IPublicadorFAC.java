/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada;

import gov.mads.gestor.adm.vista.ActualizarPublicadorOE;
import gov.mads.gestor.adm.vista.ConsultarPublicadorPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarPublicadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;

/**
 *
 * @author juanmetalmolina
 */
public interface IPublicadorFAC {
    public ObjetoSalida registrarPublicador(RegistrarPublicadorOE OE);
    public ObjetoSalida actualizarPublicador(ActualizarPublicadorOE OE);
    public ObjetoSalida consultarPublicadorPorId(ConsultarPublicadorPorIdOE OE);
}
