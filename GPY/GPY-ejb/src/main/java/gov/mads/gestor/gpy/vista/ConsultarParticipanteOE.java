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
public class ConsultarParticipanteOE extends ObjetoEntrada{
    @XmlElement
    private Integer a051codigo;

    public Integer getA051codigo() {
        return a051codigo;
    }

    public void setA051codigo(Integer a051codigo) {
        this.a051codigo = a051codigo;
    }
}
