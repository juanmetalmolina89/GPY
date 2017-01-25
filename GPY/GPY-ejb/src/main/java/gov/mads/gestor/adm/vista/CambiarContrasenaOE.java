/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;
import gov.mads.gestor.comun.entidades.Usuario;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author juanmetalmolina
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CambiarContrasenaOE extends ObjetoEntrada{
    @XmlElement
    private Usuario usuario;
    @XmlElement
    private String a041claveant;
    @XmlElement
    private String a041clavenueva;

    
    public String getA041claveant() {
        return a041claveant;
    }

    public void setA041claveant(String a041claveant) {
        this.a041claveant = a041claveant;
    }

    public String getA041clavenueva() {
        return a041clavenueva;
    }

    public void setA041clavenueva(String a041clavenueva) {
        this.a041clavenueva = a041clavenueva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @todo revisar los atributos y el tipo de dato de cada variable
     */
}
