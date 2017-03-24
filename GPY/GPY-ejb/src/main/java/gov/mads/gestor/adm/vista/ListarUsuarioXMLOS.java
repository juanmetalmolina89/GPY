/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

import gov.mads.gestor.comun.vista.CodError;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement(name="listarUsuarios")
@XmlType(propOrder = {"idUsuario", "codError", "msgError", "respuesta"})
//@XmlAccessorType(XmlAccessType.FIELD)
public class ListarUsuarioXMLOS {
    //@XmlElement(required=true)
    private Long idUsuario;

    //@XmlElement(required=true)
    private CodError codError = CodError.OPERACION_CORRECTA;

    //@XmlElement(required=true)
    private String msgError;
    //@XmlElement(name="respuesta")
    private List<HashMap<String, Object>> respuesta;
    
    //@XmlAttribute
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CodError getCodError() {
        return codError;
    }

    public void setCodError(CodError codError) {
        this.codError = codError;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
    
    public List<HashMap<String, Object>> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<HashMap<String, Object>> respuesta) {
        this.respuesta = respuesta;
    }

}
