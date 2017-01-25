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
public class ConsultarProyectoPorIdOE extends ObjetoEntrada{
    
    @XmlElement    
    public int a002codigo;

    public int getA002codigo() {
        return a002codigo;
    }

    public void setA00codigo(int a002codigo) {
        this.a002codigo = a002codigo;
    }
    
    
    
}
