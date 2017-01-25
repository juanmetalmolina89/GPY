/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ConsultarRepresentantePorIdOE extends ObjetoEntrada {


    @XmlElement
    private Integer a053codigo;
    @XmlElement
    private Integer a053idpersonajurd;


    public Integer getA053codigo() {
       return a053codigo;
    }

    public void setA053codigo (Integer a053codigo) {
        this.a053codigo = a053codigo;
    }

    public Integer getA053idpersonajurd() {
        return a053idpersonajurd;
    }


    public void setA053idpersonajurd(Integer a053idpersonajurd) {
        this.a053idpersonajurd = a053idpersonajurd;
    }

    
}
