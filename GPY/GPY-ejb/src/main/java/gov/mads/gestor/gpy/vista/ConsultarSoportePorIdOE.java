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
 * @author juanmetalmolina
 */
@XmlRootElement
public class ConsultarSoportePorIdOE extends ObjetoEntrada{
    @XmlElement
    private Integer a005codigo;
    @XmlElement
    private Integer a026codigo;
    @XmlElement
    private Integer a005idproyecto;
    
    public Integer getA005codigo() {
        return a005codigo;
    }

    public void setA005codigo(Integer a005codigo) {
        this.a005codigo = a005codigo;
    }

    public Integer getA026codigo() {
        return a026codigo;
    }

    public void setA026codigo(Integer a026codigo) {
        this.a026codigo = a026codigo;
    }

    public Integer getA005idproyecto() {
        return a005idproyecto;
    }

    public void setA005idproyecto(Integer a005idproyecto) {
        this.a005idproyecto = a005idproyecto;
    }
}
