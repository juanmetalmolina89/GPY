/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.entidades.ProyAdjunto;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ActualizarAdjuntoOE extends ObjetoEntrada{
    @XmlElement
    private Integer a025codigo;
    @XmlElement
    private Integer a002codigo;
    @XmlElement
    private Integer a008numrradcd;
    @XmlElement
    private ProyAdjunto proyadjunto;

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

    public ProyAdjunto getProyadjunto() {
        return proyadjunto;
    }

    public void setProyadjunto(ProyAdjunto proyadjunto) {
        this.proyadjunto = proyadjunto;
    }

    public Integer getA008numrradcd() {
        return a008numrradcd;
    }

    public void setA008numrradcd(Integer a008numrradcd) {
        this.a008numrradcd = a008numrradcd;
    }

    public Integer getA025codigo() {
        return a025codigo;
    }

    public void setA025codigo(Integer a025codigo) {
        this.a025codigo = a025codigo;
    }
    
}
