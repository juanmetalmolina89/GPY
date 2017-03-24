/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada.impl;
import gov.mads.gestor.adm.modelo.impl.UsuarioDAO;
import gov.mads.gestor.adm.vista.ConsultarUsuarioOE;
import gov.mads.gestor.adm.vista.EliminarUsuarioOE;
import gov.mads.gestor.adm.vista.RegistrarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioOE;
import gov.mads.gestor.adm.vista.CambiarContrasenaOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.fachada.IUsuarioFAC;
import gov.mads.gestor.adm.vista.ListarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOS;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import org.xml.sax.*;
/**
 *
 * @author juanmetalmolina
 */
public class UsuarioFAC implements IUsuarioFAC {

    private final UsuarioDAO AdmUsuarioDAO = new UsuarioDAO ();

    public ObjetoSalida consultarUsuario(ConsultarUsuarioOE OE) {

        return AdmUsuarioDAO.consultarUsuario(OE);
    }

    public ObjetoSalida registrarUsuario(RegistrarUsuarioOE OE) {

        return AdmUsuarioDAO.registrarUsuario(OE);
    }

    public ObjetoSalida eliminarUsuario(EliminarUsuarioOE OE) {

        return AdmUsuarioDAO.eliminarUsuario(OE);
    }
    
    public ObjetoSalida validarUsuario(ValidarUsuarioOE OE) {
        return AdmUsuarioDAO.validarUsuario(OE);
    }
    
    public ObjetoSalida cambiarContrasena(CambiarContrasenaOE OE) {

        return AdmUsuarioDAO.cambiarContrasena(OE);
    }
    
    public ObjetoSalida listarUsuario(ListarUsuarioOE OE) {

        return AdmUsuarioDAO.listarUsuario(OE);
    }


    public ObjetoSalida validarUsuarioVital(UsuarioVitalOE OE) {
        
        return AdmUsuarioDAO.validarUsuarioVital(OE);
    }
    
    public ObjetoSalida ValidarCadena(String XML, UsuarioVitalOE OE){
        System.out.println(XML);
        return AdmUsuarioDAO.validarUsuarioVital(OE);
    }
    /*public ObjetoSalida validarUsuarioVital(ValidarUsuarioVitalOE OE) {
        ValidarUsuarioOE OEE = new ValidarUsuarioOE();
        OEE.setUsername(OE.username);
        OEE.setClave(OE.clave);
        OEE.setIdUsuario(0);
        return AdmUsuarioDAO.validarUsuario(OEE);
    }//*/
    
    public ValidarUsuarioVitalOS validarUsuarioVital(ValidarUsuarioVitalOE OE) {
        ValidarUsuarioOE OEE = new ValidarUsuarioOE();
        OEE.setUsername(OE.username);
        OEE.setClave(OE.clave);
        OEE.setIdUsuario(0);
        ObjetoSalida OS = AdmUsuarioDAO.validarUsuario(OEE);
        ValidarUsuarioVitalOS OSS = new ValidarUsuarioVitalOS();
        OSS.codError = OS.getCodError();
        OSS.respuesta = OS.getRespuesta();
        OSS.msgError = OS.getMsgError();
        return OSS;
    }//*/
    
    public String validar(String xml){
        
        Node node;
        try {
            node = getAuthToken(xml);
            System.out.println(node.getTextContent());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioFAC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return xml;
    }
    
    private Document generarXML(String xml){
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        Document document =  null; 
        try  
        {  
            builder = factory.newDocumentBuilder();  
            
            document = builder.parse( new InputSource( new StringReader( xml ) ) );
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return document;
    }
    
     private Node getAuthToken(String xml) throws Exception {
        Document doc = generarXML(xml);
        NodeList authTokenNodeList = doc.getElementsByTagName("Token");
        return authTokenNodeList.item(0);
    }
}

