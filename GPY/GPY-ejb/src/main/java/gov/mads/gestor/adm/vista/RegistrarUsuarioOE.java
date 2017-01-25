/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;
import gov.mads.gestor.comun.entidades.Persona;
import gov.mads.gestor.comun.entidades.Usuario;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarUsuarioOE extends ObjetoEntrada {
    /**
     * @todo revisar los atributos y el tipo de dato de cada variable
     */
    private Usuario usuario;
    private Persona persona;
    private int a041idtippersn;
    
    private int a041tipdocmnt;
    
    private int a041identidad;
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the a041idtippersn
     */
    public int getA041idtippersn() {
        return a041idtippersn;
    }

    /**
     * @param a041idtippersn the a041idtippersn to set
     */
   public void setA041idtippersn(int a041idtippersn) {
        this.a041idtippersn = a041idtippersn;
    }

    /**
     * @return the a041tipdocmnt
     */
    public int getA041tipdocmnt() {
        return a041tipdocmnt;
    }

    /**
     * @param a041tipdocmnt the a041tipdocmnt to set
     */
    public void setA041tipdocmnt(int a041tipdocmnt) {
        this.a041tipdocmnt = a041tipdocmnt;
    }

    /**
     * @return the a041identidad
     */
    public int getA041identidad() {
        return a041identidad;
    }

    /**
     * @param a041identidad the a041identidad to set
     */
    public void setA041identidad(int a041identidad) {
        this.a041identidad = a041identidad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
} 
