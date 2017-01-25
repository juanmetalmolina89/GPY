/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarSoporteOE extends ObjetoEntrada{
    @XmlElement
    private Integer a005codigo;
    @XmlElement
    private Archivo soporte;

    public Archivo getSoporte() {
        return soporte;
    }

    public void setSoporte(Archivo soporte) {
        this.soporte = soporte;
    }

    public Integer getA005codigo() {
        return a005codigo;
    }

    public void setA005codigo(Integer a005codigo) {
        this.a005codigo = a005codigo;
    }
}
