package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.entidades.Adjunto;
import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.entidades.ProyAdjunto;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IDatosMdlFAC;
import gov.mads.gestor.gpy.modelo.impl.DatosMdlDAO;
import gov.mads.gestor.gpy.vista.ActualizarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ActualizarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ActualizarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ConsultarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.ListarAdjuntosOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;
import gov.mads.gestor.gpy.vista.RegistrarConsideracOE;
import gov.mads.gestor.gpy.vista.RegistrarCartaNObjOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
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
public class DatosMdlFAC implements IDatosMdlFAC { 

	private final DatosMdlDAO datosMdlDAO = new DatosMdlDAO();

	public ObjetoSalida registrarConsiderac(RegistrarConsideracOE objetoEntrada) {
		return datosMdlDAO.registrarConsiderac(objetoEntrada);
	}

	public ObjetoSalida registrarCartaNObj(RegistrarCartaNObjOE objetoEntrada) {
		return datosMdlDAO.registrarCartaNObj(objetoEntrada);
	}

        public ObjetoSalida consultarConsiderac(ConsultarConsideracOE OE) {
                return datosMdlDAO.consultarConsiderac(OE);
        }

        public ObjetoSalida consultarCartaNObj(ConsultarCartaNObjOE OE) {
                return datosMdlDAO.consultarCartaNObj(OE);
        }

        public ObjetoSalida registrarAdjunto(MultipartFormDataInput OE) {
            ObjetoSalida objetoSalida = new ObjetoSalida();

            try {

                Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
                Integer codigoProyecto = Integer.parseInt(camposAdjuntoOE.get("idProyecto").get(0).getBodyAsString());
                
                Date fechaAdjunto = (camposAdjuntoOE.get("fechaAdjunto") == null) ? null : Date.valueOf(camposAdjuntoOE.get("fechaAdjunto").get(0).getBodyAsString());
                String numrradcd = (camposAdjuntoOE.get("numrradcd") == null) ? null : (camposAdjuntoOE.get("numrradcd").get(0).getBodyAsString());
                Integer idAdjnt = Integer.parseInt(camposAdjuntoOE.get("idAdjnt").get(0).getBodyAsString());
                Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
                String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
                String nombreArchivo ="";
                String nombreArchivoServ = "";
                String md5 = "";
                File Adjunto = almacenarArchivo(camposAdjuntoOE, (rutaAdjuntoParametrica + File.separator +codigoProyecto), codigoProyecto);
                InputStream lecturaAdjunto = new FileInputStream(Adjunto);
                md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
                nombreArchivo = Adjunto.getName();
                nombreArchivoServ = Adjunto.getAbsolutePath();
                RegistrarAdjuntoOE OEntrada = new RegistrarAdjuntoOE();
                ProyAdjunto proyadjunto = new ProyAdjunto();
                Adjunto adjunto = new Adjunto();
                adjunto.setA025codigo(idAdjnt);
                proyadjunto.setA008idadjnt(adjunto);
                proyadjunto.setA008numrradcd(numrradcd);
                proyadjunto.setA008fechadjnt(fechaAdjunto);
                Archivo archivo = new Archivo();
                //archivo.setA026descrpcnarchiv(nombreArchivo);
                archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                archivo.setA026rutarchiv(nombreArchivo);
                archivo.setA026hasharchivo(md5);//Falta realizar el HASH
                proyadjunto.setA008idarchv(archivo);
                OEntrada.setProyadjunto(proyadjunto);
                OEntrada.setA002codigo(codigoProyecto);
                OEntrada.setIdUsuario(idUsuario);
                objetoSalida = datosMdlDAO.registrarAdjunto(OEntrada);
                ErrorClass.getMessage(objetoSalida,DatosMdlDAO.class);
                
            } catch (Exception e) {

                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.getMessage());
                ErrorClass.getMessage(objetoSalida,DatosMdlDAO.class);
            }

            return objetoSalida;
        }

        public ObjetoSalida consultarAdjunto(ConsultarAdjuntoOE OE) {
            ObjetoSalida objetoSalida = datosMdlDAO.consultarAdjunto(OE);
            
            return objetoSalida;
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

        public ObjetoSalida listarAdjuntos(ListarAdjuntosOE OE) {
            return datosMdlDAO.listarAdjuntos(OE);
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

        @Override
        public ObjetoSalida actualizarConsiderac(ActualizarConsideracOE OE) {
            return datosMdlDAO.actualizarConsiderac(OE);
        }

        @Override
        public ObjetoSalida actualizarCartaNObj(ActualizarCartaNObjOE OE) {
            return datosMdlDAO.actualizarCartaNObj(OE);
        }

        @Override
        public ObjetoSalida actualizarAdjunto(MultipartFormDataInput OE) {
            ObjetoSalida objetoSalida = new ObjetoSalida();

            try {

                Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
                Integer codigoProyecto = Integer.parseInt(camposAdjuntoOE.get("idProyecto").get(0).getBodyAsString());
                Integer a025codigo = Integer.parseInt(camposAdjuntoOE.get("a025codigo").get(0).getBodyAsString());
                Date fechaAdjunto = (camposAdjuntoOE.get("fechaAdjunto") == null) ? null : Date.valueOf(camposAdjuntoOE.get("fechaAdjunto").get(0).getBodyAsString());
                String numrradcd = (camposAdjuntoOE.get("numrradcd").get(0).getBodyAsString());
                Integer idAdjnt = Integer.parseInt(camposAdjuntoOE.get("idAdjnt").get(0).getBodyAsString());
                Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
                String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
                String nombreArchivo ="";
                String nombreArchivoServ = "";
                String md5 = "";
                File Adjunto = almacenarArchivo(camposAdjuntoOE, (rutaAdjuntoParametrica + File.separator +codigoProyecto), codigoProyecto);
                InputStream lecturaAdjunto = new FileInputStream(Adjunto);
                md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
                nombreArchivo = Adjunto.getName();
                nombreArchivoServ = Adjunto.getAbsolutePath();
                ActualizarAdjuntoOE OEntrada = new ActualizarAdjuntoOE();
                ProyAdjunto proyadjunto = new ProyAdjunto();
                Adjunto adjunto = new Adjunto();
                adjunto.setA025codigo(idAdjnt);
                proyadjunto.setA008idadjnt(adjunto);
                proyadjunto.setA008numrradcd(numrradcd);
                proyadjunto.setA008fechadjnt(fechaAdjunto);
                Archivo archivo = new Archivo();
                //archivo.setA026descrpcnarchiv(nombreArchivo);
                archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                archivo.setA026rutarchiv(nombreArchivo);
                archivo.setA026hasharchivo(md5);//Falta realizar el HASH
                proyadjunto.setA008idarchv(archivo);
                OEntrada.setProyadjunto(proyadjunto);
                OEntrada.setA002codigo(codigoProyecto);
                OEntrada.setIdUsuario(idUsuario);
                OEntrada.setA025codigo(a025codigo);
                objetoSalida = datosMdlDAO.actualizarAdjunto(OEntrada);
                ErrorClass.getMessage(objetoSalida,DatosMdlDAO.class);
                
            } catch (Exception e) {

                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.getMessage());
                ErrorClass.getMessage(objetoSalida,DatosMdlDAO.class);
            }

            return objetoSalida;

        }

        
        public File consultarAdjuntoPorID(ConsultarAdjuntoPorIdOE OE) {
            ObjetoSalida objetoSalida = datosMdlDAO.consultarAdjuntoPorID(OE);
            File adjunto =  null;
             if (objetoSalida.esRespuestaOperacionCorrecta()){
                String nombreAdjunto = "";
                String rutaAdjunto = obtenerRutaAdjuntoParametrica(1);
                String numrrdcd = "";
                for (HashMap<String, Object> item : objetoSalida.getRespuesta()) {
                    
                    numrrdcd = item.get("a008numrradcd").toString();
                    nombreAdjunto = item.get("a026nomarchivo").toString();
                    //rutaAdjunto = item.get("A014RUTAADJUNTO").toString();
                }
                adjunto = new File(rutaAdjunto + File.separator + OE.getA002codigo() + File.separator + OE.getA002codigo() + File.separator + nombreAdjunto);
            }
            return adjunto;
        }
}
