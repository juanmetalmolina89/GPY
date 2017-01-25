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
public class ActualizarSoporteOE extends ObjetoEntrada{
    @XmlElement
    private Archivo soporte;

    public Archivo getSoporte() {
        return soporte;
    }

    public void setSoporte(Archivo soporte) {
        this.soporte = soporte;
    }
}
