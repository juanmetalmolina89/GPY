/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.entidades.ProySectrImplmntdr;
import gov.mads.gestor.comun.entidades.SectorImplementador;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarSectorImplementadorOE extends ObjetoEntrada {

    @XmlElement
    private Integer a002codigo;
    @XmlElement
    private ProySectrImplmntdr sector;
    /*private int a006idproyecto;
    @XmlElement
    private int a006idsectrimplmntdr;
    @XmlElement
    private String A006DETALLEOTRO;

    public int getA006idproyecto() {
       return a006idproyecto;
    }

    public void setA006idproyecto (int a006idproyecto) {
        this.a006idproyecto = a006idproyecto;
    }



    public int getA006idsectrimplmntdr () {
       return a006idsectrimplmntdr;
    }

    public void setA006idsectrimplmntdr (int a006idsectrimplmntdr) {
        this. a006idsectrimplmntdr = a006idsectrimplmntdr;
    }

    
    public String getA006DETALLEOTRO() {
        return A006DETALLEOTRO;
    }

    public void setA006DETALLEOTRO(String A006DETALLEOTRO) {
        this.A006DETALLEOTRO = A006DETALLEOTRO;
    }

    */

    public ProySectrImplmntdr getSector() {
        return sector;
    }

    public void setSector(ProySectrImplmntdr sector) {
        this.sector = sector;
    }

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

    
    
}
