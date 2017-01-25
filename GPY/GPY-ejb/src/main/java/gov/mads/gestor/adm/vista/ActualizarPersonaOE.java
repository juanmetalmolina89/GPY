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
 * @author carlosivan.rivera
 */
@XmlRootElement
public class ActualizarPersonaOE extends ObjetoEntrada{
    
    @XmlElement
    private Persona persona; 
    /*@XmlElement
    private int A041CODIGO;

    public int getA041CODIGO() {
        return A041CODIGO;
    }

    public void setA041CODIGO(int A041CODIGO) {
        this.A041CODIGO = A041CODIGO;
    }

    @XmlElement
    private int A041IDTIPPERSN;

    public int getA041IDTIPPERSN() {
        return A041IDTIPPERSN;
    }

    public void setA041IDTIPPERSN(int A041IDTIPPERSN) {
        this.A041IDTIPPERSN = A041IDTIPPERSN;
    }

    @XmlElement
    private String A041NOMBRE;

    public String getA041NOMBRE() {
        return A041NOMBRE;
    }

    public void setA041NOMBRE(String A041NOMBRE) {
        this.A041NOMBRE = A041NOMBRE;
    }

    @XmlElement
    private String A041APELLIDO;

    public String getA041APELLIDO() {
        return A041APELLIDO;
    }

    public void setA041APELLIDO(String A041APELLIDO) {
        this.A041APELLIDO = A041APELLIDO;
    }

    @XmlElement
    private int A041TIPDOCMNT;

    public int getA041TIPDOCMNT() {
        return A041TIPDOCMNT;
    }

    public void setA041TIPDOCMNT(int A041TIPDOCMNT) {
        this.A041TIPDOCMNT = A041TIPDOCMNT;
    }

    @XmlElement
    private String A041NUMRDOCMNT;

    public String getA041NUMRDOCMNT() {
        return A041NUMRDOCMNT;
    }

    public void setA041NUMRDOCMNT(String A041NUMRDOCMNT) {
        this.A041NUMRDOCMNT = A041NUMRDOCMNT;
    }

    @XmlElement
    private int A041CODGCIIU;

    public int getA041CODGCIIU() {
        return A041CODGCIIU;
    }

    public void setA041CODGCIIU(int A041CODGCIIU) {
        this.A041CODGCIIU = A041CODGCIIU;
    }

    @XmlElement
    private String A041LGREXPCNDOCMNT;

    public String getA041LGREXPCNDOCMNT() {
        return A041LGREXPCNDOCMNT;
    }

    public void setA041LGREXPCNDOCMNT(String A041LGREXPCNDOCMNT) {
        this.A041LGREXPCNDOCMNT = A041LGREXPCNDOCMNT;
    }

    @XmlElement
    private String A041DIRCCNCORRSPNDNC;

    public String getA041DIRCCNCORRSPNDNC() {
        return A041DIRCCNCORRSPNDNC;
    }

    public void setA041DIRCCNCORRSPNDNC(String A041DIRCCNCORRSPNDNC) {
        this.A041DIRCCNCORRSPNDNC = A041DIRCCNCORRSPNDNC;
    }

    @XmlElement
    private int A041LOCLZCN;

    public int getA041LOCLZCN() {
        return A041LOCLZCN;
    }

    public void setA041LOCLZCN(int A041LOCLZCN) {
        this.A041LOCLZCN = A041LOCLZCN;
    }

    @XmlElement
    private String A041TELEFONO;

    public String getA041TELEFONO() {
        return A041TELEFONO;
    }

    public void setA041TELEFONO(String A041TELEFONO) {
        this.A041TELEFONO = A041TELEFONO;
    }

    @XmlElement
    private String A041CELULAR;

    public String getA041CELULAR() {
        return A041CELULAR;
    }

    public void setA041CELULAR(String A041CELULAR) {
        this.A041CELULAR = A041CELULAR;
    }

    @XmlElement
    private String A041CORRELCTRNC;

    public String getA041CORRELCTRNC() {
        return A041CORRELCTRNC;
    }

    public void setA041CORRELCTRNC(String A041CORRELCTRNC) {
        this.A041CORRELCTRNC = A041CORRELCTRNC;
    }
*/

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
