/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.InstrmFinanAnio;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class InsertarInstrmntInfoGralPOE extends ObjetoEntrada{
    @XmlElement
    private InstrmFinanAnio instrumentofinananio;

    public InstrmFinanAnio getInstrumentofinananio() {
        return instrumentofinananio;
    }

    public void setInstrumentofinananio(InstrmFinanAnio instrumentofinananio) {
        this.instrumentofinananio = instrumentofinananio;
    }
}
