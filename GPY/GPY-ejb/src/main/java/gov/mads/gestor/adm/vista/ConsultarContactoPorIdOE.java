/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;

/**
 *
 * @author juanmetalmolina
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ConsultarContactoPorIdOE extends ObjetoEntrada{
    @XmlElement
    private Integer a054codigo;
    @XmlElement
    private Integer idpersona;

    public Integer getA054codigo() {
        return a054codigo;
    }

    public void setA054codigo(Integer a054codigo) {
        this.a054codigo = a054codigo;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }
    
}
