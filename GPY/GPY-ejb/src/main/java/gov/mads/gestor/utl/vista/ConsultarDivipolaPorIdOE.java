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
 * @author Juan Molina
 */
@XmlRootElement
public class ConsultarDivipolaPorIdOE extends ObjetoEntrada{
    @XmlElement
    private Integer iddivipola;

    public Integer getIddivipola() {
        return iddivipola;
    }

    public void setIddivipola(Integer iddivipola) {
        this.iddivipola = iddivipola;
    }
    
    
}
