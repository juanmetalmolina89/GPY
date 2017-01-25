/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ValidarUsuarioOE extends ObjetoEntrada {
    /**
     * @todo revisar los atributos y el tipo de dato de cada variable
     */

    @XmlElement
    //A041USERNAME
    private String username;

    @XmlElement
    //A041CLAVE
    private String clave;

    public String getUsername() {
       return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }



    public String getClave () {
       return clave;
    }

    public void setClave (String clave) {
        this.clave = clave;
    }

}