/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.vista;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author juanmetalmolina
 */
public class DatosSeguridad {
    @XmlElement(required=true)
    public String token;
    @XmlElement(required=true)
    public String mac;
    
}
