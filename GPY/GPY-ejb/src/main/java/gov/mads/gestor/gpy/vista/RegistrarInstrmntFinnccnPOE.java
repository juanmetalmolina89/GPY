/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.InstrmntFinnccn;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarInstrmntFinnccnPOE extends ObjetoEntrada{
    private InstrmntFinnccn instrumentofinanciacion;

    public InstrmntFinnccn getInstrumentofinanciacion() {
        return instrumentofinanciacion;
    }

    public void setInstrumentofinanciacion(InstrmntFinnccn instrumentofinanciacion) {
        this.instrumentofinanciacion = instrumentofinanciacion;
    }
}
