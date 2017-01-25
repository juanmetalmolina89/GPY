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
 * @author carlosivan.rivera
 */
@XmlRootElement
public class ConsultarPersonaPorIdOE  extends ObjetoEntrada{
    
    @XmlElement
    private int a052codigo;

    public int getA052codigo() {
        return a052codigo;
    }

    public void setA052codigo(int a052codigo) {
        this.a052codigo = a052codigo;
    }
    
    
    
    
    
}
