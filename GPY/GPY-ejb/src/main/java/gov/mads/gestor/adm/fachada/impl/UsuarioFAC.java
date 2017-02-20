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
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
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

    public ObjetoSalida validarUsuarioVital(ValidarUsuarioVitalOE OE) {
        ValidarUsuarioOE OEE = new ValidarUsuarioOE();
        OEE.setUsername(OE.username);
        OEE.setClave(OE.clave);
        OEE.setIdUsuario(0);
        return AdmUsuarioDAO.validarUsuario(OEE);
    }
}

