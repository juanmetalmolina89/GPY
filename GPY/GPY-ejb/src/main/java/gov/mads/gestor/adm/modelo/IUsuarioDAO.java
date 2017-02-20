package gov.mads.gestor.adm.modelo;

import gov.mads.gestor.adm.vista.ConsultarUsuarioOE;
import gov.mads.gestor.adm.vista.EliminarUsuarioOE;
import gov.mads.gestor.adm.vista.RegistrarUsuarioOE;
import gov.mads.gestor.adm.vista.ValidarUsuarioOE;
import gov.mads.gestor.adm.vista.CambiarContrasenaOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.comun.vista.UsuarioVitalOE;
/**
 *
 * @author juanmetalmolina
 */
public interface IUsuarioDAO {

    ObjetoSalida consultarUsuario(ConsultarUsuarioOE OE);
    ObjetoSalida registrarUsuario(RegistrarUsuarioOE OE);
    ObjetoSalida eliminarUsuario(EliminarUsuarioOE OE);
    ObjetoSalida listarUsuario(EliminarUsuarioOE OE);
    ObjetoSalida validarUsuario(ValidarUsuarioOE OE);
    ObjetoSalida cambiarContrasena(CambiarContrasenaOE OE);
    ObjetoSalida validarUsuarioVital(UsuarioVitalOE OE);
} 