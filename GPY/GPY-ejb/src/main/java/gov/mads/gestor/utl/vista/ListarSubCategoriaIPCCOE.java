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
public class ListarSubCategoriaIPCCOE extends ObjetoEntrada{
    @XmlElement
    private Integer a047idcatipcc;

    public Integer getA047idcatipcc() {
        return a047idcatipcc;
    }

    public void setA047idcatipcc(Integer a047idcatipcc) {
        this.a047idcatipcc = a047idcatipcc;
    }
    
}
