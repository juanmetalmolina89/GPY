/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.fachada.impl;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.rpt.fachada.IReporteFAC;
import gov.mads.gestor.rpt.modelo.IReporteDAO;
import gov.mads.gestor.rpt.modelo.impl.ReporteDAO;
import gov.mads.gestor.rpt.vista.ReporteOE;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juanmetalmolina
 */
public class ReporteFAC implements IReporteFAC{
    private ReporteDAO accesoDatos;
    
    public File generarReporteProyectos(ReporteOE OE) throws Exception{
        
        accesoDatos =  new ReporteDAO();
        List<HashMap<String, Object>> dataProyectos = new ArrayList<>();

        for (Long codigoProyectos : OE.getListaProyectos()) {
            OE.setIdproyecto(codigoProyectos);
            ObjetoSalida objetoSalida = accesoDatos.generarReporteProyectos(OE);
            if (objetoSalida.esRespuestaOperacionCorrecta()) {
                dataProyectos.addAll(objetoSalida.getRespuesta());
            }
        }

        return generarReporte(dataProyectos);
    }
    
    public File generarReporteProyectosDemo(gov.mads.gestor.gpy.vista.ListarProyectoOE OE) throws Exception{
        
        gov.mads.gestor.gpy.modelo.impl.GrillaDAO accesoDatos =  new gov.mads.gestor.gpy.modelo.impl.GrillaDAO();
        List<HashMap<String, Object>> dataProyectos = new ArrayList<>();

        //for (Long codigoProyectos : OE.getListaProyectos()) {
            //OE.setIdproyecto(codigoProyectos);
            ObjetoSalida objetoSalida = accesoDatos.listarProyectos(OE);
            if (objetoSalida.esRespuestaOperacionCorrecta()) {
                dataProyectos.addAll(objetoSalida.getRespuesta());
            }
        //}

        return generarReporte(dataProyectos);
    }
    
    private File generarReporte(List<HashMap<String, Object>> datosReporte) throws Exception {

        File resultado = File.createTempFile("reporte", ".xlsx");

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet("Reporte");

        if (datosReporte != null && !datosReporte.isEmpty()) {

            Integer numFila = 0;
            Row filaTitulos = hoja.createRow(numFila++);

            Integer numColumnaEncabezado = 0;
            for (String nomColumna : datosReporte.get(0).keySet()) {
                Cell celda = filaTitulos.createCell(numColumnaEncabezado++);
                celda.setCellValue(nomColumna);
            }

            for (HashMap<String, Object> fila : datosReporte) {
                Row filaDatos = hoja.createRow(numFila++);
                Integer numColumna = 0;
                for (String nomColumna : fila.keySet()) {
                    Cell celda = filaDatos.createCell(numColumna++);
                    celda.setCellValue(fila.get(nomColumna) == null ? "" : (fila.get(nomColumna)).toString());
                }
            }
        }

        try (FileOutputStream escrituraReporte = new FileOutputStream(resultado)) {
            libro.write(escrituraReporte);
        } catch (Exception e) {
            throw new Exception(e);
        }

        return resultado;
    }
}
