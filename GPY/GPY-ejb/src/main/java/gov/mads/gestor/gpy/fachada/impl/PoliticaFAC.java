package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.entidades.ProyPolitica;
import gov.mads.gestor.comun.entidades.ProySectrImplmntdr;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IPoliticaFAC;
import gov.mads.gestor.gpy.modelo.impl.PoliticaDAO;
import gov.mads.gestor.gpy.vista.ActualizarPoliticaOE;
import gov.mads.gestor.gpy.vista.ConsultarPoliticaPorIdOE;
import gov.mads.gestor.gpy.vista.EliminarPoliticaOE;
import gov.mads.gestor.gpy.vista.ListarPoliticasProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoPoliticaOE;
import gov.mads.gestor.gpy.vista.RegistrarPoliticaOE;
import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Ivan Chacon
 */
public class PoliticaFAC implements IPoliticaFAC { 

	private final PoliticaDAO politicaDAO = new PoliticaDAO();

	public ObjetoSalida registrarPolitica(RegistrarPoliticaOE objetoEntrada) {
            //return 
            
            ObjetoSalida objetoSalida = new ObjetoSalida(); 
            for (ProyPolitica item : objetoEntrada.getProyecto().getProyPoliticaList()) {
                objetoEntrada.setProypolitica(item);
                objetoSalida = politicaDAO.registrarPoliticaNueva(objetoEntrada);
                if (objetoSalida.getCodError() != CodError.OPERACION_CORRECTA) {
                        objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br><br>" + objetoSalida.getMsgError());
                }    
            }        
            return objetoSalida;
            //*/
	}
        // Faltantes
        public ObjetoSalida consultarPoliticaPorId(ConsultarPoliticaPorIdOE OE) {
                return politicaDAO.consultarPoliticaPorId(OE);
        }

        public ObjetoSalida actualizarPolitica(ActualizarPoliticaOE OE) {
                return politicaDAO.actualizarPolitica(OE);
        }

        public ObjetoSalida eliminarPolitica(EliminarPoliticaOE OE) {
                return politicaDAO.eliminarPolitica(OE);
        }

        
        public ObjetoSalida listarPoliticasProyecto(ListarPoliticasProyectoOE OE) {
                return politicaDAO.listarPoliticasProyecto(OE);
        }
        
        public ObjetoSalida registrarAdjunto(MultipartFormDataInput OE){
                ObjetoSalida objetoSalida = new ObjetoSalida();

                try {

                    Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
                    //todo: Cuadrar con Yeimmy como me proporciona el codigo del representante
                    Integer codigoProyecto = Integer.parseInt(camposAdjuntoOE.get("idProyecto").get(0).getBodyAsString());
                    //todo: Cuadrar con Yeimmy como proporciona el codgio del idUsuario
                    Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
                    String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
                    String nombreArchivo ="";
                    String nombreArchivoServ = "";
                    File archivoAdjunto = almacenarArchivo(camposAdjuntoOE, rutaAdjuntoParametrica, codigoProyecto);
                    InputStream lecturaAdjunto = new FileInputStream(archivoAdjunto);
                    String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
                    nombreArchivo = archivoAdjunto.getName();
                    nombreArchivoServ = archivoAdjunto.getAbsolutePath();
                    RegistrarAdjuntoPoliticaOE OEntrada = new RegistrarAdjuntoPoliticaOE();
                    Archivo archivo = new Archivo();
                    //archivo.setA026descrpcnarchiv(nombreArchivo);
                    archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                    archivo.setA026rutarchiv(nombreArchivo);
                    archivo.setA026hasharchivo(md5);
                    OEntrada.setA003codigo(codigoProyecto);
                    OEntrada.setIdUsuario(idUsuario);
                    OEntrada.setAdjuntarArchivo(archivo);
                    objetoSalida = politicaDAO.registrarSoporte(OEntrada);    
                    ErrorClass.getMessage(objetoSalida,ActividadFAC.class);


                } catch (Exception e) {

                    objetoSalida.setCodError(CodError.ERROR_INTERNO);
                    objetoSalida.setMsgError(e.getMessage());
                    ErrorClass.getMessage(objetoSalida,ActividadFAC.class);
                }

                return objetoSalida;
        }
        
        private File almacenarArchivo(Map<String, List<InputPart>> camposAdjuntoOE, String rutaAdjuntoParametrica, Integer idrepresentante) throws Exception{
                File archivoS = null;
                try (InputStream lecturaAdjunto = camposAdjuntoOE.get("file").get(0).getBody(InputStream.class, null)){

                        File carpetaAdjunto = new File(rutaAdjuntoParametrica + File.separator + idrepresentante);
                        MultivaluedMap<String, String> header = camposAdjuntoOE.get("file").get(0).getHeaders();
                        String nombreArchivo = darNombreArchivo(header);
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
        
        
        private String darNombreArchivo(MultivaluedMap<String, String> cabecera) {

            String[] contentDisposition = cabecera.getFirst("Content-Disposition").split(";");

            for (String filename : contentDisposition) {
                    if ((filename.trim().startsWith("filename"))) {

                            String[] name = filename.split("=");

                            String finalFileName = name[1].trim().replaceAll("\"", "");
                            return finalFileName;
                    }
            }
            return "unknown";
        }

        
        private String obtenerRutaAdjuntoParametrica(Integer idUsuario) {

            IListadosFAC fachadaListados = new ListadosFAC();
            ListarParametricoOE listaOE = new ListarParametricoOE();
            listaOE.setIdUsuario(idUsuario);
            listaOE.setCategoria("RUTAADJUNTO");
            ObjetoSalida objetoSalidaParametrica = fachadaListados.listarParametrico(listaOE);

            return objetoSalidaParametrica.getRespuesta().get(0).get("a102valor").toString();
        }
}
