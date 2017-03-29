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
import gov.mads.gestor.adm.vista.OE_Autenticar;
import gov.mads.gestor.adm.vista.OE_ConsultarFuncionarios;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOS;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/* *
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
    
    public ObjetoSalida validar(String xml) throws JAXBException{
        JAXBContext jc = JAXBContext.newInstance(UsuarioVitalOE.class);

        StringReader reader = new StringReader(xml.replaceAll("&", ""));

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Object result = unmarshaller.unmarshal(reader);
        UsuarioVitalOE user = null;
        if(result instanceof UsuarioVitalOE) {
            user = (UsuarioVitalOE) result;
        }
        ValidarUsuarioOE OE = new ValidarUsuarioOE();
        OE.setIdUsuario(0);
        OE.setUsername(user.datosConexion.aliasUsuarioOrigen);
        OE.setClave(user.datosConexion.aliasUsuarioDestino);
        return AdmUsuarioDAO.validarUsuario(OE);
    }
    
    public ObjetoSalida registrarUsuarioVital(OE_Autenticar OE){
        ValidarUsuarioOE OEE = new ValidarUsuarioOE();
        OEE.setIdUsuario(0);
        OEE.setUsername(OE.aliasUsuario);
        OEE.setClave(OE.clave);
        return AdmUsuarioDAO.validarUsuario(OEE);
    }
    
    public ObjetoSalida listarUsuarioVital(OE_ConsultarFuncionarios OE){
        ListarUsuarioOE OEE = new ListarUsuarioOE();
        OEE.setIdUsuario(0);
        return AdmUsuarioDAO.listarUsuario(OEE);
    }
}

