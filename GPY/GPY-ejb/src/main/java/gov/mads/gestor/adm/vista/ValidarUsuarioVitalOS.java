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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement(name="Salida")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidarUsuarioVitalOS {
    @XmlElement(required=true)
    public Long idUsuario;

    @XmlElement(required=true)
    public CodError codError = CodError.OPERACION_CORRECTA;

    @XmlElement(required=true)
    public String msgError;
    @XmlElement(name="respuesta")
    public List<HashMap<String, Object>> respuesta;

}
