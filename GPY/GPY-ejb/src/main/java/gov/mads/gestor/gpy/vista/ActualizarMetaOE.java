/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

/**
 *
 * @author juanmetalmolina
 */

import gov.mads.gestor.comun.entidades.RepAnioFteIndcdr;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ActualizarMetaOE  extends ObjetoEntrada {

    @XmlElement
    private RepAnioFteIndcdr  meta;

    public RepAnioFteIndcdr getMeta () {
       return meta;
    }

    public void setMeta (RepAnioFteIndcdr meta) {
        this. meta = meta;
    }
}
