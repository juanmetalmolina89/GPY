/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.modelo;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.rpt.vista.ReporteOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IReporteDAO {
    ObjetoSalida generarReporteProyectos(ReporteOE objetoEntrada);
    ObjetoSalida generarReporteProyectosDemo(ReporteOE objetoEntrada);
    ObjetoSalida listarReportes(ReporteOE objetoEntrada);
}
