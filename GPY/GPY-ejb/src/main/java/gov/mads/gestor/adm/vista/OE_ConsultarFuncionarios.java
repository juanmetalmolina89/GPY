/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="arg0")
public class OE_ConsultarFuncionarios {
    public OE_ConsultarFuncionarios() {
    }
    @XmlElement(required=true)
    public String codAutoridadAmbiental;

/*
    public void setCodAutoridadAmbiental(String codAutoridadAmbiental) {
        this.codAutoridadAmbiental = codAutoridadAmbiental;
    }

    public String getCodAutoridadAmbiental() {
        return codAutoridadAmbiental;
    }*/    
}
