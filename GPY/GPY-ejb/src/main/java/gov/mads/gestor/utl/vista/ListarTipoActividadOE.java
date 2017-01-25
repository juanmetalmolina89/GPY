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
public class ListarTipoActividadOE extends ObjetoEntrada{
    @XmlElement
    private Integer a022idtipproyct;
    @XmlElement
    private Integer a022idtipproyctmdl;

    public Integer getA022idtipproyct() {
        return a022idtipproyct;
    }

    public void setA022idtipproyct(Integer a022idtipproyct) {
        this.a022idtipproyct = a022idtipproyct;
    }

    public Integer getA022idtipproyctmdl() {
        return a022idtipproyctmdl;
    }

    public void setA022idtipproyctmdl(Integer a022idtipproyctmdl) {
        this.a022idtipproyctmdl = a022idtipproyctmdl;
    }
    
    
}
