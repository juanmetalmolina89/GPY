/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement(name="loginVital")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidarUsuarioVitalOE {
    @XmlElement(required=true)
    public String username;
    @XmlElement(required=true)
    public String clave;
    
}
