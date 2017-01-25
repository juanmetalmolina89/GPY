/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarSubGrupoIPCCOE extends ObjetoEntrada{
    @XmlElement
    private Integer a043idsectoripcc;

    public Integer getA043idsectoripcc() {
        return a043idsectoripcc;
    }

    public void setA043idsectoripcc(Integer a043idsectoripcc) {
        this.a043idsectoripcc = a043idsectoripcc;
    }
}
