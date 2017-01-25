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
 * @author juanmetalmolina
 */
@XmlRootElement
public class ConsultarPublicadorPorIdOE extends ObjetoEntrada{
    @XmlElement
    private Integer a055idpersona;
    @XmlElement
    private Integer a055codigo;

    public Integer getA055idpersona() {
        return a055idpersona;
    }

    public void setA055idpersona(Integer a055idpersona) {
        this.a055idpersona = a055idpersona;
    }

    public Integer getA055codigo() {
        return a055codigo;
    }

    public void setA055codigo(Integer a055codigo) {
        this.a055codigo = a055codigo;
    }
}
