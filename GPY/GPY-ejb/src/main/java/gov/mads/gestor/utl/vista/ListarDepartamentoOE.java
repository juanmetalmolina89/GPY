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
public class ListarDepartamentoOE extends ObjetoEntrada{
    private Divipola paises;

    public Divipola getPaises() {
        return paises;
    }

    public void setPaises(Divipola paises) {
        this.paises = paises;
    }
}
