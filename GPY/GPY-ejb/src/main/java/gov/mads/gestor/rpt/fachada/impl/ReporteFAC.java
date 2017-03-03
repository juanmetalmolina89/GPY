/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.rpt.fachada.impl;

import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.rpt.fachada.IReporteFAC;
import gov.mads.gestor.rpt.modelo.IReporteDAO;
import gov.mads.gestor.rpt.modelo.impl.ReporteDAO;
import gov.mads.gestor.rpt.vista.ListarReporteOE;
import gov.mads.gestor.rpt.vista.ReporteOE;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.modelo.impl.ListadosDAO;
import gov.mads.gestor.utl.vista.ListarParametricoOE;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author juanmetalmolina
 */
public class ReporteFAC implements IReporteFAC{
    private ReporteDAO accesoDatos;
    
    public File generarReporteProyectos(ReporteOE OE) throws Exception{
        
        accesoDatos =  new ReporteDAO();
        
        List<HashMap<String, Object>> dataProyectos = new ArrayList<>();
        ObjetoSalida objetoSalida = accesoDatos.generarReporteProyectos(OE);
        String ubicacion = obtenerRutaAdjuntoParametrica(OE.getIdUsuario());
        String nombrePlantilla = objetoSalida.getNombrePlantilla();//obtenerRutaAdjuntoParametrica(OE.getIdUsuario());
        if (objetoSalida.esRespuestaOperacionCorrecta()) {
            dataProyectos.addAll(objetoSalida.getRespuesta());
        }
        return generarReporte(dataProyectos,ubicacion + File.separator+ "plantillas"+File.separator+nombrePlantilla);
    }
    
    public File generarReporteProyectosDemo(gov.mads.gestor.gpy.vista.ListarProyectoOE OE) throws Exception{
        
        gov.mads.gestor.gpy.modelo.impl.GrillaDAO accesoDatos =  new gov.mads.gestor.gpy.modelo.impl.GrillaDAO();
        List<HashMap<String, Object>> dataProyectos = new ArrayList<>();
        String nombrePlantilla = obtenerRutaAdjuntoParametrica(OE.getIdUsuario());
        
        //for (Long codigoProyectos : OE.getListaProyectos()) {
            //OE.setIdproyecto(codigoProyectos);
            ObjetoSalida objetoSalida = accesoDatos.listarProyectos(OE);
            if (objetoSalida.esRespuestaOperacionCorrecta()) {
                dataProyectos.addAll(objetoSalida.getRespuesta());
            }
        //}

        return generarReporte(dataProyectos,nombrePlantilla);
    }
    
    public ObjetoSalida listarReporteProyectos(ListarReporteOE OE) throws Exception{
        
        accesoDatos =  new ReporteDAO();
    /*    String nombrePlantilla = obtenerRutaAdjuntoParametrica(OE.getIdUsuario());
        List<HashMap<String, Object>> dataProyectos = new ArrayList<>();*/
        ObjetoSalida objetoSalida = accesoDatos.listarReportes(OE);
        /*if (objetoSalida.esRespuestaOperacionCorrecta()) {
            dataProyectos.addAll(objetoSalida.getRespuesta());
        }*/
        //return generarReporte(dataProyectos,nombrePlantilla);
        return objetoSalida;
    }
    
    private File generarReporte(List<HashMap<String, Object>> datosReporte,String plantilla) throws Exception {

        //File directorio = new File("/home/juanmetalmolina/"); // @Todo No utilizar la ruta
        String excelFilePath = plantilla; // @Todo Modificar por la plantilla de la BD
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));//*/
         
        //Workbook libro = new XSSFWorkbook(new File(excelFilePath));
        File resultado = File.createTempFile("reporte", ".xlsx");//, directorio);
        XSSFWorkbook libro = new XSSFWorkbook(inputStream);    
        //XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = (XSSFSheet) libro.getSheet("Reporte");
        org.apache.log4j.Logger log = Logger.getLogger( ReporteFAC.class );
        
        if (datosReporte != null && !datosReporte.isEmpty()) {

            Integer numFila = 10; // 
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
                    if(isNumeric((fila.get(nomColumna)).toString())){
                        double dato = Double.parseDouble((fila.get(nomColumna)).toString());
                        celda.setCellValue((double) (fila.get(nomColumna) == null ? 0 : dato));
                    }else{
                        celda.setCellValue(fila.get(nomColumna) == null ? "" : (fila.get(nomColumna)).toString());
                    }
                    
                    
                    
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
    
     private String obtenerRutaAdjuntoParametrica(Integer idUsuario) {

            IListadosFAC fachadaListados = new ListadosFAC();
            ListarParametricoOE listaOE = new ListarParametricoOE();
            listaOE.setIdUsuario(idUsuario);
            listaOE.setCategoria("RUTAADJUNTO");
            ObjetoSalida objetoSalidaParametrica = fachadaListados.listarParametrico(listaOE);

            return objetoSalidaParametrica.getRespuesta().get(0).get("a102valor").toString();
        }
    private boolean isNumeric(String s) {
            return java.util.regex.Pattern.matches("\\d+", s);
    }
}
