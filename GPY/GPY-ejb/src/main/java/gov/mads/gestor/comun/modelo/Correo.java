/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.modelo;

import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.fachada.impl.ListadosFAC;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author juanmetalmolina
 */
public class Correo {
    private static Correo instancia;

    private String usuario;
    private String contrasenia;
    private String servidor;
    private int puerto;
    private boolean tls;

    private Correo(Integer idUsuario) throws Exception {

        this.usuario = obtenerUsuario(idUsuario);
        this.contrasenia = obtenerContrasenia(idUsuario);
        this.servidor = obtenerServidor(idUsuario);
        this.puerto = obtenerPuerto(idUsuario);
        this.tls = obtenerTLS(idUsuario);
    }

    private String obtenerUsuario(Integer idUsuario) throws Exception {

        IListadosFAC fachadaListados = new ListadosFAC();
        return fachadaListados.obtenerParametro(idUsuario, "MAIL_USUARIO");
    }

    private String obtenerContrasenia(Integer idUsuario) throws Exception {

        IListadosFAC fachadaListados = new ListadosFAC();
        return fachadaListados.obtenerParametro(idUsuario, "MAIL_CONTRASENIA");
    }

    private String obtenerServidor(Integer idUsuario) throws Exception {

        IListadosFAC fachadaListados = new ListadosFAC();
        return fachadaListados.obtenerParametro(idUsuario, "MAIL_SERVIDOR");
    }

    private Integer obtenerPuerto(Integer idUsuario) throws Exception {

        IListadosFAC fachadaListados = new ListadosFAC();
        return Integer.parseInt(fachadaListados.obtenerParametro(idUsuario, "MAIL_PUERTO"));
    }

    private boolean obtenerTLS(Integer idUsuario) throws Exception {

        IListadosFAC fachadaListados = new ListadosFAC();
        return Boolean.parseBoolean(fachadaListados.obtenerParametro(idUsuario, "MAIL_TLS"));
    }

    public synchronized static Correo obtenerInstancia(Integer idUsuario) throws Exception {

        if (instancia == null) {
            instancia = new Correo(idUsuario);
        }
        return instancia;
    }

    public void NotificarCambioEstado(String para, String asunto, String contenido) throws Exception {

        HtmlEmail mensaje = new HtmlEmail();
        mensaje.setAuthenticator(new DefaultAuthenticator(usuario, contrasenia));
        mensaje.setHostName(servidor);
        mensaje.setSmtpPort(puerto);
        mensaje.setStartTLSEnabled(tls);
        mensaje.setFrom(usuario);

        mensaje.addTo(para);
        mensaje.setSubject(asunto);
        mensaje.setHtmlMsg(contenido);

        mensaje.send();
    }
}

