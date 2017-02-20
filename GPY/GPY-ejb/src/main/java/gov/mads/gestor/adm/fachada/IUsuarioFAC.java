/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.fachada;
import gov.mads.gestor.adm.vista.ConsultarUsuarioOE;
import gov.mads.gestor.adm.vista.RegistrarUsuarioOE;
import gov.mads.gestor.adm.vista.EliminarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioOE;
import gov.mads.gestor.adm.vista.CambiarContrasenaOE;
import gov.mads.gestor.adm.vista.ListarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioVitalOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
/**
 *
 * @author juanmetalmolina
 */
public interface IUsuarioFAC {
    public ObjetoSalida consultarUsuario(ConsultarUsuarioOE OE);
    public ObjetoSalida registrarUsuario(RegistrarUsuarioOE OE);
    public ObjetoSalida eliminarUsuario(EliminarUsuarioOE OE);
    public ObjetoSalida listarUsuario(ListarUsuarioOE OE);
    public ObjetoSalida validarUsuario(ValidarUsuarioOE OE);
    public ObjetoSalida cambiarContrasena(CambiarContrasenaOE OE);
    public ObjetoSalida validarUsuarioVital(UsuarioVitalOE OE);
    public ObjetoSalida validarUsuarioVital(ValidarUsuarioVitalOE OE);
}
