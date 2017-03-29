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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="arg0")
public class OE_Autenticar {
    public OE_Autenticar() {
    }
    @XmlElement(required=true)
    //private String aliasUsuario;
    public String aliasUsuario;
    @XmlElement(required=true)
    //private String clave;
    public String clave;
    

/*
    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }*/
}
