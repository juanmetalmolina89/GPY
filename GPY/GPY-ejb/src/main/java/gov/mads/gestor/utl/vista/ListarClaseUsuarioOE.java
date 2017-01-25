/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;

/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarClaseUsuarioOE extends ObjetoEntrada{
    @XmlElement
    private String categoria;

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }
    
}
