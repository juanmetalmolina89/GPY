/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada.impl;
import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.adm.modelo.impl.RepresentanteDAO;
import gov.mads.gestor.adm.vista.RegistrarRepresentanteOE;
import gov.mads.gestor.adm.vista.ConsultarRepresentantePorIdOE;
import gov.mads.gestor.adm.vista.ActualizarRepresentanteOE;
import gov.mads.gestor.gpy.vista.AdjuntarDocumentoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.fachada.IRepresentanteFAC;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.gpy.vista.ConsultarDocumentoPorIdOE;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
/**
 *
 * @author juanmetalmolina
 */
public class RepresentanteFAC implements IRepresentanteFAC {

    private final RepresentanteDAO GpyRepresentanteDAO = new RepresentanteDAO ();

    public ObjetoSalida registrarRepresentante(RegistrarRepresentanteOE OE) {
      
        return GpyRepresentanteDAO.registrarRepresentante(OE);
    }
    
    public ObjetoSalida consultarRepresentantePorId(ConsultarRepresentantePorIdOE OE) {

        ObjetoSalida objetoSalida = GpyRepresentanteDAO.consultarRepresentantePorId(OE);
        /**/
        
        return objetoSalida;
    }
    
    public ObjetoSalida actualizarRepresentante(ActualizarRepresentanteOE OE) {

        return GpyRepresentanteDAO.actualizarRepresentante(OE);
    }
    
    public ObjetoSalida actualizarDocumento(MultipartFormDataInput OE){
        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
            //todo: Cuadrar con Yeimmy como me proporciona el codigo del representante
            Integer idrepresentante = Integer.parseInt(camposAdjuntoOE.get("idRepresentante").get(0).getBodyAsString());
            Integer idArchivo = Integer.parseInt(camposAdjuntoOE.get("idArchivo").get(0).getBodyAsString());
            //Integer codigoArchivo = 1;//Integer.parseInt(camposAdjuntoOE.get("uploadedFile").get(0).getBodyAsString());
            //todo: Cuadrar con Yeimmy como proporciona el codgio del idUsuario
            Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
            String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
            String nombreArchivo ="";
            String nombreArchivoServ = "";
            String md5 = "";
            File Adjunto = almacenarArchivo(camposAdjuntoOE, rutaAdjuntoParametrica, idrepresentante);
            InputStream lecturaAdjunto = new FileInputStream(Adjunto);
            md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
            AdjuntarDocumentoOE OEntrada = new AdjuntarDocumentoOE();
            Archivo archivo = new Archivo();
            nombreArchivo = Adjunto.getName();
            nombreArchivoServ = Adjunto.getAbsolutePath();
            archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
            archivo.setA026rutarchiv(nombreArchivo);
            archivo.setA026hasharchivo(md5);
            archivo.setA026codigo(idArchivo);
            OEntrada.setA053codigo(idrepresentante);
            OEntrada.setIdUsuario(idUsuario);
            OEntrada.setAdjuntarArchivo(archivo);
            objetoSalida = GpyRepresentanteDAO.actualizarDocumento(OEntrada);
            /*try (InputStream lecturaAdjunto = camposAdjuntoOE.get("file").get(0).getBody(InputStream.class, null)){
               
                   
                File carpetaAdjunto = new File(rutaAdjuntoParametrica + File.separator + idrepresentante);
                MultivaluedMap<String, String> header = camposAdjuntoOE.get("file").get(0).getHeaders();
                nombreArchivo = getFileName(header);
                if (!carpetaAdjunto.exists())
                    carpetaAdjunto.mkdirs();
                else if (carpetaAdjunto.isDirectory())
                for (File antiguo : carpetaAdjunto.listFiles())
                    antiguo.delete();        
                //archivoAdjunto = new File();
                nombreArchivoServ = rutaAdjuntoParametrica + File.separator + idrepresentante + File.separator+nombreArchivo;
                
                if(objetoSalida.getCodError() == CodError.OPERACION_CORRECTA){
                    File archivoS = new File(nombreArchivoServ);
                    byte [] bytes = IOUtils.toByteArray(lecturaAdjunto);
                    FileOutputStream fop = new FileOutputStream(archivoS);

                    fop.write(bytes);
                    fop.flush();
                    fop.close();
                
                }else{
                    objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br> <br>No se pudo crear el archivo");
                }
                //Falta validar con el procedimiento de almacenado
                /*AdjuntarDocumentoOE OEntrada = new AdjuntarDocumentoOE();
                Archivo archivo = new Archivo();
                archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                archivo.setA026rutarchiv(nombreArchivo);
                archivo.setA026hasharchivo(nombreArchivo);
                OEntrada.setIdUsuario(1);
                OEntrada.setA053codigo(idrepresentante); //Ajustar con codigo Representante
                OEntrada.setAdjuntarArchivo(archivo);
                objetoSalida = GpyRepresentanteDAO.adjuntarDocumento(OEntrada);*/
     
            /*} catch (Exception e) {
                    
                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.getMessage());
            }*/
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
        }

        return objetoSalida;
    }
    
    public File consultarDocumentoPorId(ConsultarDocumentoPorIdOE OE){
        ObjetoSalida objetoSalida = GpyRepresentanteDAO.consultarDocumentoPorId(OE);
        File archivoAdjunto = null;
        if (objetoSalida.esRespuestaOperacionCorrecta()){
            String nombreAdjunto = "";
            String rutaAdjunto = obtenerRutaAdjuntoParametrica(1);
            for (HashMap<String, Object> item : objetoSalida.getRespuesta()) {
                nombreAdjunto = item.get("a026nomarchivo").toString();
                //rutaAdjunto = item.get("A014RUTAADJUNTO").toString();
            }
            archivoAdjunto = new File(rutaAdjunto + File.separator + OE.getA053codigo() + File.separator + nombreAdjunto);
        }
        return archivoAdjunto;
    }
    /**
     * @TODO Modificar el metodo como esta el de inventario para los archivos adjuntos
     * @param OE
     * @return 
     */
    public ObjetoSalida adjuntarDocumento(MultipartFormDataInput OE) {

        ObjetoSalida objetoSalida = new ObjetoSalida();

        try {

            Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
            //todo: Cuadrar con Yeimmy como me proporciona el codigo del representante
            Integer codigoArchivo = Integer.parseInt(camposAdjuntoOE.get("idRepresentante").get(0).getBodyAsString());
            //todo: Cuadrar con Yeimmy como proporciona el codgio del idUsuario
            Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
            String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
            String nombreArchivo ="";
            String nombreArchivoServ = "";
            String md5 = "";
            File Adjunto = almacenarArchivo(camposAdjuntoOE, rutaAdjuntoParametrica, codigoArchivo);
            InputStream lecturaAdjunto = new FileInputStream(Adjunto);
            md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
            AdjuntarDocumentoOE OEntrada = new AdjuntarDocumentoOE();
            Archivo archivo = new Archivo();
            nombreArchivo = Adjunto.getName();
            nombreArchivoServ = Adjunto.getAbsolutePath();
            archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
            archivo.setA026rutarchiv(nombreArchivo);
            archivo.setA026hasharchivo(md5);
            OEntrada.setA053codigo(codigoArchivo);
            OEntrada.setIdUsuario(idUsuario);
            OEntrada.setAdjuntarArchivo(archivo);
            objetoSalida = GpyRepresentanteDAO.adjuntarDocumento(OEntrada);
            
            /*try (InputStream lecturaAdjunto = camposAdjuntoOE.get("file").get(0).getBody(InputStream.class, null)){
                md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto);
                
                File carpetaAdjunto = new File(rutaAdjuntoParametrica + File.separator + codigoArchivo);
                MultivaluedMap<String, String> header = camposAdjuntoOE.get("file").get(0).getHeaders();
                nombreArchivo = getFileName(header);
                if (!carpetaAdjunto.exists())
                    carpetaAdjunto.mkdirs();
                else if (carpetaAdjunto.isDirectory())
                for (File antiguo : carpetaAdjunto.listFiles())
                    antiguo.delete();
                //archivoAdjunto = new File();
                nombreArchivoServ = rutaAdjuntoParametrica + File.separator + codigoArchivo + File.separator+nombreArchivo;
                AdjuntarDocumentoOE OEntrada = new AdjuntarDocumentoOE();
                Archivo archivo = new Archivo();
                //archivo.setA026descrpcnarchiv(nombreArchivo);
                archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                archivo.setA026rutarchiv(nombreArchivo);
                archivo.setA026hasharchivo(md5);
                OEntrada.setA053codigo(codigoArchivo);
                OEntrada.setIdUsuario(idUsuario);
                OEntrada.setAdjuntarArchivo(archivo);
                objetoSalida = GpyRepresentanteDAO.adjuntarDocumento(OEntrada);
                if(objetoSalida.getCodError() == CodError.OPERACION_CORRECTA){
                    File archivoS = new File(nombreArchivoServ);
                    byte [] bytes = IOUtils.toByteArray(lecturaAdjunto);
                    FileOutputStream fop = new FileOutputStream(archivoS);

                    fop.write(bytes);
                    fop.flush();
                    fop.close();
                    //escribirArchivo(bytes, nombreArchivoServ);
                
                }else{
                    objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br> <br>No se pudo crear el archivo");
                }
                    
                //Falta validar con el procedimiento de almacenado
                
                ErrorClass.getMessage(objetoSalida, RepresentanteFAC.class);
            } catch (Exception e) {
                    
                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.getMessage());
                ErrorClass.getMessage(objetoSalida, RepresentanteFAC.class);
            }
            */
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            ErrorClass.getMessage(objetoSalida, RepresentanteFAC.class);
        }

        return objetoSalida;
     //   return GpyRepresentanteDAO.adjuntarDocumento(OE);
    }
    private String obtenerRutaAdjuntoParametrica(Integer idUsuario) {

        IListadosFAC fachadaListados = new ListadosFAC();
        ListarParametricoOE listaOE = new ListarParametricoOE();
        listaOE.setIdUsuario(idUsuario);
        listaOE.setCategoria("RUTAADJUNTO");
        ObjetoSalida objetoSalidaParametrica = fachadaListados.listarParametrico(listaOE);
        
        return objetoSalidaParametrica.getRespuesta().get(0).get("a102valor").toString();
    }
    
    private String getFileName(MultivaluedMap<String, String> header) {

            String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

            for (String filename : contentDisposition) {
                    if ((filename.trim().startsWith("filename"))) {

                            String[] name = filename.split("=");

                            String finalFileName = name[1].trim().replaceAll("\"", "");
                            return finalFileName;
                    }
            }
            return "unknown";
    }
    private File almacenarArchivo(Map<String, List<InputPart>> camposAdjuntoOE, String rutaAdjuntoParametrica, Integer idrepresentante) throws Exception{
        File archivoS = null;
        try (InputStream lecturaAdjunto = camposAdjuntoOE.get("file").get(0).getBody(InputStream.class, null)){
               
                File carpetaAdjunto = new File(rutaAdjuntoParametrica + File.separator + idrepresentante);
                MultivaluedMap<String, String> header = camposAdjuntoOE.get("file").get(0).getHeaders();
                String nombreArchivo = getFileName(header);
                if (!carpetaAdjunto.exists())
                    carpetaAdjunto.mkdirs();
                else if (carpetaAdjunto.isDirectory())
                for (File antiguo : carpetaAdjunto.listFiles())
                    antiguo.delete();        
                //archivoAdjunto = new File();
                String nombreArchivoServ = rutaAdjuntoParametrica + File.separator + idrepresentante + File.separator+nombreArchivo;
                
                archivoS = new File(nombreArchivoServ);
                byte [] bytes = IOUtils.toByteArray(lecturaAdjunto);
                FileOutputStream fop = new FileOutputStream(archivoS);

                fop.write(bytes);
                fop.flush();
                fop.close();
     
            } catch (Exception e) {
                throw new Exception(e);
            }
        return archivoS;        
    }
}
