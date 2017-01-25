/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.vista;
import gov.mads.gestor.comun.entidades.SectorImplementador;
import gov.mads.gestor.comun.vista.ObjetoEntrada;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ListarSectorImplementadorOE extends ObjetoEntrada{
    @XmlElement
    private SectorImplementador idtipproyct;

    public SectorImplementador getIdtipproyct() {
        return idtipproyct;
    }

    public void setIdtipproyct(SectorImplementador idtipproyct) {
        this.idtipproyct = idtipproyct;
    }
}
