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
import gov.mads.gestor.gpy.vista.ActualizarIndicadorOE;
import gov.mads.gestor.gpy.vista.ActualizarMetaOE;
import gov.mads.gestor.gpy.vista.ActualizarSoporteOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadFechaOE;
import gov.mads.gestor.gpy.vista.ConsultarActividadPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarGeometriaPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarIndicadorOE;
import gov.mads.gestor.gpy.vista.ConsultarMetaOE;
import gov.mads.gestor.gpy.vista.ConsultarSoportePorIdOE;
import gov.mads.gestor.gpy.vista.EliminarActividadOE;
import gov.mads.gestor.gpy.vista.EliminarIndicadorOE;
import gov.mads.gestor.gpy.vista.EliminarMetaOE;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.RegistrarGeometriaOE;
import gov.mads.gestor.gpy.vista.RegistrarIndicadorOE;
import gov.mads.gestor.gpy.vista.RegistrarMetaOE;
import gov.mads.gestor.gpy.vista.RegistrarSoporteOE;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.io.IOUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
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
                Integer Actividad = Integer.parseInt(camposAdjuntoOE.get("idActividad").get(0).getBodyAsString());
                //todo: Cuadrar con Yeimmy como proporciona el codgio del idUsuario
                Integer idUsuario = Integer.parseInt(camposAdjuntoOE.get("idUsuario").get(0).getBodyAsString());
                String rutaAdjuntoParametrica = obtenerRutaAdjuntoParametrica(idUsuario);
                String nombreArchivo ="";
                String nombreArchivoServ = "";
                File Soporte = almacenarArchivo(camposAdjuntoOE, rutaAdjuntoParametrica, Actividad);
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

        @Override
        public ObjetoSalida registrarIndicador(RegistrarIndicadorOE OE) {
            return actividadDAO.registrarIndicador(OE);
        }

        @Override
        public ObjetoSalida eliminarIndicador(EliminarIndicadorOE OE) {
            return actividadDAO.eliminarIndicador(OE);
        }

        @Override
        public ObjetoSalida actualizarIndicador(ActualizarIndicadorOE OE) {
            return actividadDAO.actualizarIndicador(OE);
        }

        @Override
        public ObjetoSalida consultarIndicador(ConsultarIndicadorOE OE) {
            return actividadDAO.consultarIndicador(OE);
        }

        @Override
        public ObjetoSalida registrarMeta(RegistrarMetaOE OE) {
            return actividadDAO.registrarMeta(OE);
        }

        @Override
        public ObjetoSalida eliminarMeta(EliminarMetaOE OE) {
            return actividadDAO.eliminarMeta(OE);
        }

        @Override
        public ObjetoSalida actualizarMeta(ActualizarMetaOE OE) {
            return actividadDAO.actualizarMeta(OE);
        }

        @Override
        public ObjetoSalida consultarMeta(ConsultarMetaOE OE) {
            return actividadDAO.consultarMeta(OE);
        }

        @Override
        public ObjetoSalida consultarActividadFechaOE(ConsultarActividadFechaOE OE) throws Exception{
            ObjetoSalida obj = actividadDAO.consultarActividadFechaOE(OE);
            ObjetoSalida OS = new ObjetoSalida();
        
            if (obj.esRespuestaOperacionCorrecta()){
                List<HashMap<String, Object>> respuesta = new ArrayList<>();
                for (HashMap<String, Object> item : obj.getRespuesta()) {
                    String subgrupo_ipcc = (item.get("subgrupo_ipcc") == null)? null : item.get("subgrupo_ipcc").toString();
                    String potencial_de_reduccion = (item.get("potencial_de_reduccion") == null)? null:item.get("potencial_de_reduccion").toString();
                    String fuente = (item.get("fuente") == null) ? null : item.get("fuente").toString();                    
                    String a002proytascd = (item.get("a002proytascd") == null) ? null : item.get("a002proytascd").toString();
                    String nombre_subcategoria_ipcc = (item.get("nombre_subcategoria_ipcc") == null) ? null : item.get("nombre_subcategoria_ipcc").toString();
                    String nomb_proy = (item.get("nomb_proy") == null) ? null : item.get("nomb_proy").toString();                    
                    String actividad = (item.get("actividad") == null) ? null : item.get("actividad").toString();
                    String categoria_ipcc = (item.get("categoria_ipcc") == null) ? null : item.get("categoria_ipcc").toString();
                    String estado_act = (item.get("estado_act") == null) ? null : item.get("estado_act").toString();                    
                    Object fecha_ini_act = (item.get("fecha_ini_act") == null) ? null : (Object)item.get("fecha_ini_act");
                    String estado_act_nombre = (item.get("estado_act_nombre") == null) ? null : item.get("estado_act_nombre").toString();
                    String nombre_subgrupo_ipcc = (item.get("nombre_subgrupo_ipcc") == null) ? null : item.get("nombre_subgrupo_ipcc").toString();                    
                    String tipo_proy_nombre = (item.get("tipo_proy_nombre") == null )? null : item.get("tipo_proy_nombre").toString();
                    String tipo_actividad = (item.get("tipo_actividad") == null)? null : item.get("tipo_actividad").toString();
                    String nombre_categoria_ipcc = (item.get("nombre_categoria_ipcc") == null)? null : item.get("nombre_categoria_ipcc").toString();                    
                    String sector_implementador = (item.get("sector_implementador") ==null ) ? null : item.get("sector_implementador").toString();
                    String tipo_proy = (item.get("tipo_proy") == null) ? null : item.get("tipo_proy").toString();
                    String subcategoria_ipcc = (item.get("subcategoria_ipcc") == null) ? null :item.get("subcategoria_ipcc").toString();                    
                    Object fecha_fin_act = (item.get("fecha_fin_act")== null) ? null : (Object)item.get("fecha_fin_act");
                    String geojson = (item.get("geojson") == null) ? null : item.get("geojson").toString();                    
                    String nombre_desagregacion_ipcc = (item.get("nombre_desagregacion_ipcc") == null) ? null: item.get("nombre_desagregacion_ipcc").toString();
                    String id_actividad = (item.get("id_actividad") == null) ? null : item.get("id_actividad").toString();                    
                    String sector_ipcc = (item.get("sector_ipcc") == null) ? null : item.get("sector_ipcc").toString();                    
                    String desagregacion_ipcc = (item.get("desagregacion_ipcc") == null) ? null : item.get("desagregacion_ipcc").toString();                        
                    String categoria_de_mitigacion = (item.get("categoria_de_mitigacion") == null) ? null : item.get("categoria_de_mitigacion").toString();                        
                    //rutaAdjunto = item.get("A014RUTAADJUNTO").toString();
                    JSONObject salida = new JSONObject();
                    
                    salida.put("idUsuario", OE.getIdUsuario());
                    salida.put("idModulo", OE.getIdModulo());
                    salida.put("idSistema", OE.getIdSistema());
                    salida.put("geoJson", geojson);
                    String objt = "{\"POTENCIAL_DE_REDUCCION_DE_EMISI\":\""+potencial_de_reduccion+
                            "\",\"FUENTE\":\""+fuente+"\",\"ID_ACTIVIDAD\":\""+id_actividad+
                            "\",\"ACTIVIDAD\":\""+actividad+"\",\"FECHA_INI_ACT\":\""+fecha_ini_act+
                            "\",\"FECHA_FIN_ACT\":\""+fecha_fin_act+"\",\"SECTOR_IPCC\":\""+sector_ipcc+
                            "\",\"CATEGORIA_IPCC\":\""+categoria_ipcc+"\",\"SUBCATEGORIA_IPCC\":\""+subcategoria_ipcc+
                            "\",\"DESAGREGACION_IPCC\":\""+desagregacion_ipcc+"\",\"TIPO_ACTIVIDAD\":\""+tipo_actividad+
                            "\",\"CATEGORIA_DE_MITIGACION\":\""+categoria_de_mitigacion+"\",\"ESTADO_ACT\":\""+estado_act+
                            "\",\"TIPO_PROY\":\""+tipo_proy+"\",\"NOMB_PROY\":\""+nomb_proy+
                            "\",\"PROYECTO_ASOCIADO\":\""+a002proytascd+"\",\"SECTOR_IMPLEMENTADOR\":\""+sector_implementador+"\"}";
                    
                    salida.put("Campos", objt);
                    salida.put("operacion", OE.getOperacionComponente());
                    salida.put("tipoGeometria",OE.getTipoGeometria());
                        System.out.println(salida.toJSONString());
                    StringEntity params =new StringEntity(salida.toJSONString());
                    HttpClient client = new DefaultHttpClient();
                    System.out.println("request");
                    HttpPost request = new HttpPost(OE.getUrl());                
                    System.out.println(OE.getUrl());
        //Set Headers
                    System.out.println("Set Headers");  
                    request.setHeader("Accept", "application/json");
                    request.setHeader("Content-Type","application/json" );
                    request.setEntity(params);
                    HttpResponse response = client.execute(request);
                    StringBuilder result = new StringBuilder();
                    BufferedReader reader;
                    InputStream inputStream = response.getEntity().getContent();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    //se crea la nueva respuesta y se retorna
                    System.out.println(result);
                    
                    HashMap<String, Object> a = new HashMap<>();
                    a.put("respuesta", result);
                    respuesta.add(a);    
                    
                    
                }
                OS.setRespuesta(respuesta);
                OS.setCodError(obj.getCodError());
                return OS;
            }else{
                return obj;
            }
            
        }
}
