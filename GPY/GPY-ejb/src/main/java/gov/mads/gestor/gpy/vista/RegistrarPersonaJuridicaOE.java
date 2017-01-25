/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.Usuario;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarPersonaJuridicaOE extends ObjetoEntrada {

    private Usuario usuario;
    @XmlElement
    private int A041CODIGO;
    @XmlElement
    private int A041IDTIPPERSN;
    @XmlElement
    private String A041TIPDOCMNT;
    @XmlElement
    private int A041NUMRDOCMNT;
    @XmlElement
    private String A041LGREXPCNDOCMNT;
    @XmlElement
    private String A041DIRCCNCORRSPNDNC;
    @XmlElement
    private String A041TELEFONO;
    @XmlElement
    private String A041CODGCIIU;

    @XmlElement
    private String A041APELLIDO;

    public int getA041CODIGO() {
       return A041CODIGO;
    }

    public void setA041CODIGO (int A041CODIGO) {
        this.A041CODIGO = A041CODIGO;
    }


    public int getA041IDTIPPERSN () {
       return A041IDTIPPERSN;
    }

    public void setA041IDTIPPERSN (int A041IDTIPPERSN) {
        this. A041IDTIPPERSN = A041IDTIPPERSN;
    }



    public String getA041APELLIDO () {
       return A041APELLIDO;
    }

    public void setA041APELLIDO (String A041APELLIDO) {
        this.A041APELLIDO = A041APELLIDO;
    }

    public String getA041TIPDOCMNT () {
       return A041TIPDOCMNT;
    }

    public void setA041TIPDOCMNT (String A041TIPDOCMNT) {
        this. A041TIPDOCMNT = A041TIPDOCMNT;
    }



    public int getA041NUMRDOCMNT () {
       return A041NUMRDOCMNT;
    }

    public void setA041NUMRDOCMNT (int A041NUMRDOCMNT) {
        this. A041NUMRDOCMNT = A041NUMRDOCMNT;
    }

    /**
     * @return the A041LGREXPCNDOCMNT
     */
    public String getA041LGREXPCNDOCMNT() {
        return A041LGREXPCNDOCMNT;
    }

    /**
     * @param A041LGREXPCNDOCMNT the A041LGREXPCNDOCMNT to set
     */
    public void setA041LGREXPCNDOCMNT(String A041LGREXPCNDOCMNT) {
        this.A041LGREXPCNDOCMNT = A041LGREXPCNDOCMNT;
    }
    
    
    /**
     * @return the A041DIRCCNCORRSPNDNC
     */
    public String getA041DIRCCNCORRSPNDNC() {
        return A041DIRCCNCORRSPNDNC;
    }

    /**
     * @param A041DIRCCNCORRSPNDNC the A041DIRCCNCORRSPNDNC to set
     */
    public void setA041DIRCCNCORRSPNDNC(String A041DIRCCNCORRSPNDNC) {
        this.A041DIRCCNCORRSPNDNC = A041DIRCCNCORRSPNDNC;
    }
    
    @XmlElement
    private int A041LOCLZCN;

    /**
     * @return the A041LOCLZCN
     */
    public int getA041LOCLZCN() {
        return A041LOCLZCN;
    }

    /**
     * @param A041LOCLZCN the A041LOCLZCN to set
     */
    public void setA041LOCLZCN(int A041LOCLZCN) {
        this.A041LOCLZCN = A041LOCLZCN;
    }
    
    /**
     * @return the A041TELEFONO
     */
    public String getA041TELEFONO() {
        return A041TELEFONO;
    }

    /**
     * @param A041TELEFONO the A041TELEFONO to set
     */
    public void setA041TELEFONO(String A041TELEFONO) {
        this.A041TELEFONO = A041TELEFONO;
    }
    @XmlElement
    private String A041CELULAR;

    /**
     * @return the A041CELULAR
     */
    public String getA041CELULAR() {
        return A041CELULAR;
    }

    /**
     * @param A041CELULAR the A041CELULAR to set
     */
    public void setA041CELULAR(String A041CELULAR) {
        this.A041CELULAR = A041CELULAR;
    }
    @XmlElement
    private String A041CORRELCTRNC;

    /**
     * @return the A041CORRELCTRNC
     */
    public String getA041CORRELCTRNC() {
        return A041CORRELCTRNC;
    }

    /**
     * @param A041CORRELCTRNC the A041CORRELCTRNC to set
     */
    public void setA041CORRELCTRNC(String A041CORRELCTRNC) {
        this.A041CORRELCTRNC = A041CORRELCTRNC;
    }

    /**
     * @return the A041CODGCIIU
     */
    public String getA041CODGCIIU() {
        return A041CODGCIIU;
    }

    /**
     * @param A041CODGCIIU the A041CODGCIIU to set
     */
    public void setA041CODGCIIU(String A041CODGCIIU) {
        this.A041CODGCIIU = A041CODGCIIU;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
