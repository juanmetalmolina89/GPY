/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlosivan.rivera
 */
@XmlRootElement
public class ConsultarSectorImplementOE extends ObjetoEntrada{
    
    @XmlElement
    public int A006IDPROYECTO;

    public int getA006IDPROYECTO() {
        return A006IDPROYECTO;
    }

    public void setA006IDPROYECTO(int A006IDPROYECTO) {
        this.A006IDPROYECTO = A006IDPROYECTO;
    }
    
        
    
    
}
