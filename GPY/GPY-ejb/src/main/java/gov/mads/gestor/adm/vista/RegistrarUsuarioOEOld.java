/*
 * Objeto de Entrada procedimiento Pr_RegistrarUsuario paquete PK_ADM_USUARIO
 */
package gov.mads.gestor.adm.vista;

import gov.mads.gestor.comun.entidades.Usuario;
import gov.mads.gestor.comun.vista.GenericoOE;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Yeimmy Lee
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrarUsuarioOEOld extends GenericoOE {
    
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "RegistrarUsuarioOE{" 
                + "idUsuario=" + idUsuario + ','
                + "usuario=" + usuario + '}';
    }
    
    
    
    
}
