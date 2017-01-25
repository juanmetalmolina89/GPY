/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.modelo;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.vista.ConsultarDivipolaPorIdOE;

/**
 *
 * @author Juan Molina
 */
public interface IConsultarPorFiltroDAO {
    ObjetoSalida consultarDivipolaPorId(ConsultarDivipolaPorIdOE OE);
}
