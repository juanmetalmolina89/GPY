/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.ReporteAnioFuente;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarEscenarioBaseOE extends ObjetoEntrada{
    @XmlElement
    private ReporteAnioFuente reporteaniofuente;

    public ReporteAnioFuente getReporteaniofuente() {
        return reporteaniofuente;
    }

    public void setReporteaniofuente(ReporteAnioFuente reporteaniofuente) {
        this.reporteaniofuente = reporteaniofuente;
    }
}
