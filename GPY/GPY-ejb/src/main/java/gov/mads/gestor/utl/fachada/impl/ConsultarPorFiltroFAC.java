/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.fachada.impl;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.modelo.impl.ConsultarPorFiltroDAO;
import gov.mads.gestor.utl.modelo.impl.ListadosDAO;
import gov.mads.gestor.utl.vista.ConsultarDivipolaPorIdOE;
import gov.mads.gestor.utl.modelo.IConsultarPorFiltroDAO;

/**
 *
 * @author Juan Molina
 */
public class ConsultarPorFiltroFAC implements IConsultarPorFiltroDAO{
    
    private final ConsultarPorFiltroDAO UtlConsultarDAO = new ConsultarPorFiltroDAO();

    public ObjetoSalida consultarDivipolaPorId(ConsultarDivipolaPorIdOE OE){

        return UtlConsultarDAO.consultarDivipolaPorId(OE);
    }
    
    
}
