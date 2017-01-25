/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;
import gov.mads.gestor.comun.entidades.Archivo;
import gov.mads.gestor.comun.entidades.Persona;
import gov.mads.gestor.comun.entidades.RepLegal;
import gov.mads.gestor.comun.entidades.Usuario;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class RegistrarRepresentanteOE extends ObjetoEntrada {
    @XmlElement
    private RepLegal representante;
    
    public RepLegal getRepresentante() {
        return representante;
    }

    public void setRepresentante(RepLegal representante) {
        this.representante = representante;
    }

}
