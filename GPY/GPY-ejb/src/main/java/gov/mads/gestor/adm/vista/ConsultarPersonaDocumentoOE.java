/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Molina
 */
@XmlRootElement
public class ConsultarPersonaDocumentoOE extends ObjetoEntrada{
    
    @XmlElement
    private String a052numrdocmnt;

    public String getA052numrdocmnt() {
        return a052numrdocmnt;
    }

    public void setA052numrdocmnt(String a052numrdocmnt) {
        this.a052numrdocmnt = a052numrdocmnt;
    }
    
}
