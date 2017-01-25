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
public class ConsultarUsuarioOE extends ObjetoEntrada{
    /**
     * @todo revisar los atributos y el tipo de dato de cada variable
     */
    @XmlElement
    private int a041codigo;


    public int getA041codigo() {
       return a041codigo;
    }

    public void setA041codigo (int a041codigo) {
        this.a041codigo = a041codigo;
    }

}
