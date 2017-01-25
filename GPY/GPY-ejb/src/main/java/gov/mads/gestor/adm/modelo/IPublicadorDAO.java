/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo;

import gov.mads.gestor.adm.vista.ActualizarPublicadorOE;
import gov.mads.gestor.adm.vista.ConsultarPublicadorPorIdOE;
import gov.mads.gestor.adm.vista.RegistrarPublicadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;

/**
 *
 * @author juanmetalmolina
 */
public interface IPublicadorDAO {
    ObjetoSalida registrarPublicador(RegistrarPublicadorOE OE);
    ObjetoSalida actualizarPublicador(ActualizarPublicadorOE OE);
    ObjetoSalida consultarPublicadorPorId(ConsultarPublicadorPorIdOE OE);
}
