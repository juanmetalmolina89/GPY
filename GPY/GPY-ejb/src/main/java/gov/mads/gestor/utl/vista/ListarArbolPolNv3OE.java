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
public class ListarArbolPolNv3OE extends ObjetoEntrada{
    @XmlElement
    private Integer a003nivel2;

    public Integer getA003nivel2() {
        return a003nivel2;
    }

    public void setA003nivel2(Integer a003nivel2) {
        this.a003nivel2 = a003nivel2;
    }
    
}
