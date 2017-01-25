/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.Divipola;
import gov.mads.gestor.comun.entidades.Proyecto;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlosivan.rivera
 */
@XmlRootElement
public class ActualizarProyectoOE extends ObjetoEntrada{
    
    private Proyecto proyecto;
    private Divipola loclzcn;
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    /*
    
    @XmlElement
    public int A002CODIGO;
    
    public int getA002CODIGO() {
        return A002CODIGO;
    }

    public void setA002CODIGO(int A002CODIGO) {
        this.A002CODIGO = A002CODIGO;
    }
    
    @XmlElement
    public int A002TIPPROYCT;
    
    public int getA002TIPPROYCT() {
        return A002TIPPROYCT;
    }

    public void setA002TIPPROYCT(int A002TIPPROYCT) {
        this.A002TIPPROYCT = A002TIPPROYCT;
    }

    
    @XmlElement
    public int A002PROYTASCD;
    
    public int getA002PROYTASCD() {
        return A002PROYTASCD;
    }

    public void setA002PROYTASCD(int A002PROYTASCD) {
        this.A002PROYTASCD = A002PROYTASCD;
    }

    @XmlElement
    public String A002NOMBRPROYCT;
    
     public String getA002NOMBRPROYCT() {
        return A002NOMBRPROYCT;
    }

    public void setA002NOMBRPROYCT(String A002NOMBRPROYCT) {
        this.A002NOMBRPROYCT = A002NOMBRPROYCT;
    }

    
    @XmlElement
    public int A002UBCCN;
    
    public int getA002UBCCN() {
        return A002UBCCN;
    }

    public void setA002UBCCN(int A002UBCCN) {
        this.A002UBCCN = A002UBCCN;
    }

   
    
    @XmlElement
    private int A002LOCLZCN;
    
    
    public int getA002LOCLZCN () {
       return A002LOCLZCN;
    }

    public void setA002LOCLZCN (int A002LOCLZCN) {
        this. A002LOCLZCN = A002LOCLZCN;
    }
    
    @XmlElement    
    public String A002SOCEXTRNJR;
    
    public String getA002SOCEXTRNJR() {
        return A002SOCEXTRNJR;
    }

    public void setA002SOCEXTRNJR(String A002SOCEXTRNJR) {
        this.A002SOCEXTRNJR = A002SOCEXTRNJR;
    }
    
    @XmlElement    
    public String A002DESCRPCINPROYCT;
    
        public String getA002DESCRPCINPROYCT() {
        return A002DESCRPCINPROYCT;
    }

    public void setA002DESCRPCINPROYCT(String A002DESCRPCINPROYCT) {
        this.A002DESCRPCINPROYCT = A002DESCRPCINPROYCT;
    }

  
    
    @XmlElement    
    public int A002DURCNPREVST;
    
      public int getA002DURCNPREVST() {
        return A002DURCNPREVST;
    }

    public void setA002DURCNPREVST(int A002DURCNPREVST) {
        this.A002DURCNPREVST = A002DURCNPREVST;
    }

    
    
    
    @XmlElement    
    public int A002VIDAUTL;

    public int getA002VIDAUTL() {
        return A002VIDAUTL;
    }

    public void setA002VIDAUTL(int A002VIDAUTL) {
        this.A002VIDAUTL = A002VIDAUTL;
    }

    
    @XmlElement    
    public int A002NROCPAS;
    
    public int getA002NROCPAS() {
        return A002NROCPAS;
    }

    public void setA002NROCPAS(int A002NROCPAS) {
        this.A002NROCPAS = A002NROCPAS;
    }
        
    @XmlElement    
    public int A002POTNCLESTMDREDCCN;
    
    public int getA002POTNCLESTMDREDCCN() {
        return A002POTNCLESTMDREDCCN;
    }

    public void setA002POTNCLESTMDREDCCN(int A002POTNCLESTMDREDCCN) {
        this.A002POTNCLESTMDREDCCN = A002POTNCLESTMDREDCCN;
    }

    
    
    @XmlElement    
    public String A002OBJTVGENRL;
    
    public String getA002OBJTVGENRL() {
        return A002OBJTVGENRL;
    }

    public void setA002OBJTVGENRL(String A002OBJTVGENRL) {
        this.A002OBJTVGENRL = A002OBJTVGENRL;
    }
    
    @XmlElement
    private int A002IDALCANCE;

    public int getA002IDALCANCE() {
        return A002IDALCANCE;
    }

    public void setA002IDALCANCE(int A002IDALCANCE) {
        this.A002IDALCANCE = A002IDALCANCE;
    }
    
    */

    public Divipola getLoclzcn() {
        return loclzcn;
    }

    public void setLoclzcn(Divipola loclzcn) {
        this.loclzcn = loclzcn;
    }
    
}
