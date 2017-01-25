/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarPoliticasProyectoOE extends ObjetoEntrada{
    private Integer idpoliticaproyecto;

    public Integer getIdpoliticaproyecto() {
        return idpoliticaproyecto;
    }

    public void setIdpoliticaproyecto(Integer idpoliticaproyecto) {
        this.idpoliticaproyecto = idpoliticaproyecto;
    }
}
