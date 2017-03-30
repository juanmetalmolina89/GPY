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
import gov.mads.gestor.adm.vista.ConsultarUsuarioEntidadOE;
import gov.mads.gestor.adm.vista.Funcionario;
import gov.mads.gestor.adm.vista.ListarUsuarioOE;
import gov.mads.gestor.adm.vista.OE_Autenticar;
import gov.mads.gestor.adm.vista.OE_ConsultarFuncionarios;
import gov.mads.gestor.adm.vista.OS_Autenticar;
import gov.mads.gestor.adm.vista.OS_ConsultarFuncionarios;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOS;
import gov.mads.gestor.comun.modelo.ParametroAdaptador;
import gov.mads.gestor.comun.modelo.SeguridadAdaptador;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


  /*  public ObjetoSalida validarUsuarioVital(UsuarioVitalOE OE) {
        
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
        String tokenRecibido = user.datosSeguridad.token;
        int resul = SeguridadAdaptador.ValidarToken(tokenRecibido, ParametroAdaptador.GetParametro("LLAVEENC_SIAC"));
        ObjetoSalida objetoSalida = new ObjetoSalida();
        if ( resul != 0 ) {
            System.out.println("VALIDACION DE TOKEN INCORRECTA (" + resul + ")");
            
            //MostrarMensaje(response, "VALIDACION DE TOKEN INCORRECTA (" + resul + ")");
         //   return objetoSalida;
        }
        ValidarUsuarioOE OE = new ValidarUsuarioOE();
        OE.setIdUsuario(0);
        OE.setUsername(user.datosConexion.aliasUsuarioDestino);
        //OE.setClave(user.datosConexion.aliasUsuarioDestino);
        return AdmUsuarioDAO.validarUsuarioSinPassword(OE);
    }
    
    public OS_Autenticar registrarUsuarioVital(OE_Autenticar OE){
        ValidarUsuarioOE OEE = new ValidarUsuarioOE();
        OEE.setIdUsuario(0);
        OEE.setUsername(OE.aliasUsuario);
        OEE.setClave(OE.clave);
        OS_Autenticar OS = new OS_Autenticar();
        ObjetoSalida objetoSalida = AdmUsuarioDAO.validarUsuario(OEE); 
        OS.setCodigoError(objetoSalida.getCodError().getValor());
        OS.setMensajeError(objetoSalida.getMsgError());
        
        return OS;
    }
    
    public OS_ConsultarFuncionarios listarUsuarioVital(OE_ConsultarFuncionarios OE){
        ListarUsuarioOE OEE = new ListarUsuarioOE();
        ConsultarUsuarioEntidadOE OEES = new ConsultarUsuarioEntidadOE();
        OEE.setIdUsuario(0);
        OS_ConsultarFuncionarios OS = new OS_ConsultarFuncionarios();
        ObjetoSalida objetoSalida = AdmUsuarioDAO.listarUsuario(OEE); 
     //   OEES.setFiltro(OE.codAutoridadAmbiental);
     //   ObjetoSalida objetoSalidaEntidad = AdmUsuarioDAO.consultarUsuarioEntidad(OEES); 
        List<Funcionario> lista =  new ArrayList<Funcionario>();       
        for (HashMap<String, Object> item : objetoSalida.getRespuesta()) {
            Funcionario func = new Funcionario();
            func.setAliasUsuario(item.get("a041username").toString());
            func.setCodigoTipoIdentificacion(Integer.parseInt(item.get("a052tipdocmnt").toString()));
            func.setDireccionCorreoElectronico("");
            func.setIdentificacionPersona(item.get("a052numrdocmnt").toString());
            func.setNombreFuncionario(item.get("a052nombre").toString() + " " + item.get("a052apellido").toString() );
            lista.add(func);
        }
        OS.setFuncionarios(lista);
        OS.setCodigoError(objetoSalida.getCodError().getValor());
        OS.setMensajeError(objetoSalida.getMsgError());
        return OS;
    }
}

