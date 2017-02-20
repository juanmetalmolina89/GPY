/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.fachada;

import gov.mads.gestor.rpt.vista.ReporteOE;
import java.io.File;

/**
 *
 * @author juanmetalmolina
 */
public interface IReporteFAC {
    public File generarReporteProyectos(ReporteOE OE)throws Exception;
    public File generarReporteProyectosDemo(gov.mads.gestor.gpy.vista.ListarProyectoOE OE)throws Exception;
}
