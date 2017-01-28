package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.entidades.Actividad;
import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IActividadFAC;
import gov.mads.gestor.gpy.modelo.impl.ActividadDAO;
import gov.mads.gestor.gpy.vista.RegistrarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarActividadOE;
import gov.mads.gestor.gpy.vista.ActualizarGeometriaOE;
import gov.mads.gestor.gpy.vista.ActualizarSoporteOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.io.IOUtils;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Ivan Chacon
 */
public class ActividadFAC implements IActividadFAC { 
        private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( ActividadFAC.class ); 
	private final ActividadDAO actividadDAO = new ActividadDAO();

	public ObjetoSalida registrarActividad(RegistrarActividadOE objetoEntrada) {
            ObjetoSalida objetoSalida = actividadDAO.registrarActividad(objetoEntrada);
            if (objetoSalida.esRespuestaOperacionCorrecta()){
                Integer a005codigo =  ((BigDecimal) objetoSalida.getRespuesta().get(0).get("a005codigo")).intValue();
                if (a005codigo > 0){
                    RegistrarGeometriaOE geometria = new RegistrarGeometriaOE();
                    geometria.setIdUsuario(objetoEntrada.getIdUsuario());
                    Actividad act = new Actividad();
                    act.setA005codigo(a005codigo);
                    objetoEntrada.getGeometria().setA042idactvdd(act);
                    geometria.setGeometria(objetoEntrada.getGeometria());
                    //geometria.setA042geometriasitio(objetoEntrada.getA042geometriasitio());
                    //geometria.setA042geometriaintersec(objetoEntrada.getA042geometriaintersec());
                    geometria.setA042geometriasitio(new JSONObject((Map) objetoEntrada.getA042geometriasitio()));
                    geometria.setA042geometriaintersec(new JSONObject((Map)objetoEntrada.getA042geometriaintersec()));
                    ObjetoSalida objetoSalidaGeometria = actividadDAO.registrarGeometria(geometria);
                    if (!objetoSalidaGeometria.esRespuestaOperacionCorrecta()) {
                        objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br><br>" + objetoSalidaGeometria.getMsgError());
                    }else{
                        objetoSalida.getRespuesta().add(objetoSalidaGeometria.getRespuesta().get(0));
                    }
                }
            }
            return objetoSalida;
	}

	public ObjetoSalida actualizarActividad(ActualizarActividadOE objetoEntrada) {
            ObjetoSalida objetoSalida = actividadDAO.actualizarActividad(objetoEntrada);
            if (objetoSalida.getRespuesta() != null){
                Integer a005codigo =  ((BigDecimal) objetoSalida.getRespuesta().get(0).get("a005codigo")).intValue();
                if (a005codigo > 0){
                    ActualizarGeometriaOE geometria = new ActualizarGeometriaOE();
                    Actividad act = new Actividad(a005codigo);
                    objetoEntrada.getGeometria().setA042idactvdd(act);
                    geometria.setGeometria(objetoEntrada.getGeometria());
                    geometria.setIdUsuario(objetoEntrada.getIdUsuario());
                    //geometria.setA042geometriasitio(objetoEntrada.getA042geometriasitio());
                    //geometria.setA042geometriaintersec(objetoEntrada.getA042geometriaintersec());
                    geometria.setA042geometriasitio(new JSONObject((Map) objetoEntrada.getA042geometriasitio()));
                    geometria.setA042geometriaintersec(new JSONObject((Map)objetoEntrada.getA042geometriaintersec()));
                    
                    ObjetoSalida objetoSalidaGeometria = actividadDAO.actualizarGeometria(geometria);
                    if (!objetoSalidaGeometria.esRespuestaOperacionCorrecta()) {
                        objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br><br>" + objetoSalidaGeometria.getMsgError());
                    }else{
                        objetoSalida.getRespuesta().add(objetoSalidaGeometria.getRespuesta().get(0));
                    }
                }
            }//*/
            return objetoSalida;
	}

	public ObjetoSalida eliminarActividad(EliminarActividadOE objetoEntrada) {
		return actividadDAO.eliminarActividad(objetoEntrada);
	}
        // @author juanmetalmolina 
        // Se agrego el metodo consultar Actividad por Id
        public ObjetoSalida consultarActividadPorId(ConsultarActividadPorIdOE objetoEntrada) {
		ObjetoSalida objetoSalida = actividadDAO.consultarActividadPorId(objetoEntrada); 
                
                return objetoSalida;
	}
        
        public ObjetoSalida listarActividades(ListarActividadesOE objetoEntrada) {
		return actividadDAO.listarActividades(objetoEntrada);
	}
        public ObjetoSalida registrarSoporte(MultipartFormDataInput OE){
            ObjetoSalida objetoSalida = new ObjetoSalida();

            try {

                Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
                //todo: Cuadrar con Yeimmy como me proporciona el codigo del representante
                Integer codigoActividad = Integer.parseInt(camposAdjuntoOE.get("idActividad").get(0).getBodyAsString());
                //todo: Cuadrar con Yeimmy como proporciona el codgio del idUsuario
                Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
                String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
                String nombreArchivo ="";
                String nombreArchivoServ = "";
                File archivoAdjunto = almacenarArchivo(camposAdjuntoOE, rutaAdjuntoParametrica, codigoActividad);
                InputStream lecturaAdjunto = new FileInputStream(archivoAdjunto);
                String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
                nombreArchivo = archivoAdjunto.getName();
                nombreArchivoServ = archivoAdjunto.getAbsolutePath();
                RegistrarSoporteOE OEntrada = new RegistrarSoporteOE();
                Archivo archivo = new Archivo();
                //archivo.setA026descrpcnarchiv(nombreArchivo);
                archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                archivo.setA026rutarchiv(nombreArchivo);
                archivo.setA026hasharchivo(md5);
                OEntrada.setA005codigo(codigoActividad);
                OEntrada.setIdUsuario(idUsuario);
                OEntrada.setSoporte(archivo);
                objetoSalida = actividadDAO.registrarSoporte(OEntrada);    
                ErrorClass.getMessage(objetoSalida,ActividadFAC.class);
                
                
            } catch (Exception e) {

                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.getMessage());
                ErrorClass.getMessage(objetoSalida,ActividadFAC.class);
            }

            return objetoSalida;
        }
        
        public File consultarSoportePorId(ConsultarSoportePorIdOE OE){
            ObjetoSalida objetoSalida = actividadDAO.consultarSoportePorId(OE);
            File soporte = null;
            if (objetoSalida.esRespuestaOperacionCorrecta()){
                String nombreAdjunto = "";
                String rutaAdjunto = obtenerRutaAdjuntoParametrica(1);
                for (HashMap<String, Object> item : objetoSalida.getRespuesta()) {
                    nombreAdjunto = item.get("a026nomarchivo").toString();
                    //rutaAdjunto = item.get("A014RUTAADJUNTO").toString();
                }
                soporte = new File(rutaAdjunto + File.separator + OE.getA005codigo() + File.separator + nombreAdjunto);
            }
            return soporte;
        }
        
       
        
        public ObjetoSalida actualizarSoporte(MultipartFormDataInput OE){
            ObjetoSalida objetoSalida = new ObjetoSalida();

            try {

                Map<String, List<InputPart>> camposAdjuntoOE = OE.getFormDataMap();
                //todo: Cuadrar con Yeimmy como me proporciona el codigo del representante
                Integer codigoSoporte = Integer.parseInt(camposAdjuntoOE.get("idSoporte").get(0).getBodyAsString());
                //todo: Cuadrar con Yeimmy como proporciona el codgio del idUsuario
                Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
                String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
                String nombreArchivo ="";
                String nombreArchivoServ = "";
                File Soporte = almacenarArchivo(camposAdjuntoOE, rutaAdjuntoParametrica, codigoSoporte);
                InputStream lecturaAdjunto = new FileInputStream(Soporte);
                String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(lecturaAdjunto); 
                nombreArchivo = Soporte.getName();
                nombreArchivoServ = Soporte.getAbsolutePath();
                ActualizarSoporteOE OEntrada = new ActualizarSoporteOE();
                Archivo archivo = new Archivo();
                archivo.setA026codigo(codigoSoporte);
            //    archivo.setA026descrpcnarchiv(nombreArchivo);
                archivo.setA026descrpcnarchiv("Archivo ubicado en "+nombreArchivoServ);
                archivo.setA026rutarchiv(nombreArchivo);
                archivo.setA026hasharchivo(md5);
                //OEntrada.setA005codigo(codigoSoporte);
                OEntrada.setIdUsuario(idUsuario);
                OEntrada.setSoporte(archivo);
                objetoSalida = actividadDAO.actualizarSoporte(OEntrada);
                ErrorClass.getMessage(objetoSalida,ActividadFAC.class);
                
                
            } catch (Exception e) {

                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.getMessage());
                ErrorClass.getMessage(objetoSalida,ActividadFAC.class);
            }

            return objetoSalida;
        }
        
        public ObjetoSalida registrarGeometria(RegistrarGeometriaOE OE){
            return null;
        }
        //
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

        private String obtenerRutaAdjuntoParametrica(Integer idUsuario) {

            IListadosFAC fachadaListados = new ListadosFAC();
            ListarParametricoOE listaOE = new ListarParametricoOE();
            listaOE.setIdUsuario(idUsuario);
            listaOE.setCategoria("RUTAADJUNTO");
            ObjetoSalida objetoSalidaParametrica = fachadaListados.listarParametrico(listaOE);

            return objetoSalidaParametrica.getRespuesta().get(0).get("a102valor").toString();
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

        @Override
        public ObjetoSalida actualizarGeometria(ActualizarGeometriaOE OE) {
            return actividadDAO.actualizarGeometria(OE);
        }

        @Override
        public ObjetoSalida consultarGeometriaPorId(ConsultarGeometriaPorIdOE OE) {
            return actividadDAO.consultarGeometriaPorId(OE);
        }
}
