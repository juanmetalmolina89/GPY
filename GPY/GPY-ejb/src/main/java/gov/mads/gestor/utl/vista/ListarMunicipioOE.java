/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;
import gov.mads.gestor.comun.entidades.Divipola;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarMunicipioOE extends ObjetoEntrada{
    private Divipola departamento;

    public Divipola getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Divipola departamento) {
        this.departamento = departamento;
    }
}
