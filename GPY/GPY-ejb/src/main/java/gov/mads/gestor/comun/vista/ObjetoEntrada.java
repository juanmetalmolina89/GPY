/*
 * Objeto generico de Entrada
 */

package gov.mads.gestor.comun.vista;

import javax.xml.bind.annotation.XmlElement;

public class ObjetoEntrada extends ObjetoGenerico {

    @XmlElement
    private Integer idUsuario;

    public Integer getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {

        this.idUsuario = idUsuario;
    }
}
