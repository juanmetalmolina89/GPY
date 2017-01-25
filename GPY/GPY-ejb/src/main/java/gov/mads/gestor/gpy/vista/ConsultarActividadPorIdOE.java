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
 // @author juanmetalmolina 
// Se agrego el metodo consultar Actividad por Id
@XmlRootElement
public class ConsultarActividadPorIdOE extends ObjetoEntrada{
    @XmlElement
    private Integer a005codigo;
    @XmlElement
    private Integer a002codigo;
    
    public Integer getA005codigo() {
        return a005codigo;
    }

    public void setA005codigo(Integer a005codigo) {
        this.a005codigo = a005codigo;
    }

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }
}
