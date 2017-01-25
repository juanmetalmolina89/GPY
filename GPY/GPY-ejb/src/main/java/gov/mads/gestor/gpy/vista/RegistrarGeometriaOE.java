/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.ActividadGeometria;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.jose4j.json.internal.json_simple.JSONObject;
/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarGeometriaOE extends ObjetoEntrada{
    @XmlElement
    private ActividadGeometria geometria;
    @XmlElement
    private JSONObject a042geometriasitio;
    @XmlElement
    private JSONObject a042geometriaintersec;
    public ActividadGeometria getGeometria() {
        return geometria;
    }

    public void setGeometria(ActividadGeometria geometria) {
        this.geometria = geometria;
    }

    public JSONObject getA042geometriasitio() {
        return a042geometriasitio;
    }

    public void setA042geometriasitio(JSONObject a042geometriasitio) {
        this.a042geometriasitio = a042geometriasitio;
    }

    public JSONObject getA042geometriaintersec() {
        return a042geometriaintersec;
    }

    public void setA042geometriaintersec(JSONObject a042geometriaintersec) {
        this.a042geometriaintersec = a042geometriaintersec;
    }
}
