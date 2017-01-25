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
public class ConsultarProyectoAsociadoOE extends ObjetoEntrada {
    
    @XmlElement
    private Integer a002tipproyct;
    @XmlElement
    private Integer a002codigo;
    public Integer getA002tipproyct() {
        return a002tipproyct;
    }

    public void setA002tipproyct(Integer a002tipproyct) {
        this.a002tipproyct = a002tipproyct;
    }

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }
  
}
