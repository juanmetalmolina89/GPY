/*
 * Objeto de Entrada Principal
 */
package gov.mads.gestor.comun.vista;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@XmlRootElement
public class GenericoOE implements Serializable {
    
    protected int idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
