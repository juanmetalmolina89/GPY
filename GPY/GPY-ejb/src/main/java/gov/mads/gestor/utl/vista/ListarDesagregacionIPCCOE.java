/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarDesagregacionIPCCOE extends ObjetoEntrada{
    private Integer a048idsubcatipcc;

    public Integer getA048idsubcatipcc() {
        return a048idsubcatipcc;
    }

    public void setA048idsubcatipcc(Integer a048idsubcatipcc) {
        this.a048idsubcatipcc = a048idsubcatipcc;
    }
    
}
