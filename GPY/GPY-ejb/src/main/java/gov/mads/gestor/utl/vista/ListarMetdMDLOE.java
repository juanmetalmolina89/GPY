/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */

@XmlRootElement
public class ListarMetdMDLOE extends ObjetoEntrada{
    @XmlElement
    private Integer a028idescl;
    @XmlElement
    private Integer a028idsectoralscope;

    public Integer getA028idescl() {
        return a028idescl;
    }

    public void setA028idescl(Integer a028idescl) {
        this.a028idescl = a028idescl;
    }

    public Integer getA028idsectoralscope() {
        return a028idsectoralscope;
    }

    public void setA028idsectoralscope(Integer a028idsectoralscope) {
        this.a028idsectoralscope = a028idsectoralscope;
    }
    
}
