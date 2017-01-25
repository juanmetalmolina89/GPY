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
public class ListarPoliticasOE extends ObjetoEntrada{
    @XmlElement
    private Integer a003nivel3;

    public Integer getA003nivel3() {
        return a003nivel3;
    }

    public void setA003nivel3(Integer a003nivel3) {
        this.a003nivel3 = a003nivel3;
    }
}
