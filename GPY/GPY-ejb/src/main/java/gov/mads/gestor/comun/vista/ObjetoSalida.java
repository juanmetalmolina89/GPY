/*
 * Objeto generico de Salida
 */

package gov.mads.gestor.comun.vista;

import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ObjetoSalida extends ObjetoGenerico {

    @XmlElement
    private Long idUsuario;

    @XmlElement
    private CodError codError = CodError.OPERACION_CORRECTA;

    @XmlElement
    private String msgError;

    private List<HashMap<String, Object>> respuesta;

    public CodError getCodError() {

        return codError;
    }

    public void setCodError(CodError codError) {

        this.codError = codError;
    }

    public Long getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {

        this.idUsuario = idUsuario;
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
    public Boolean esRespuestaOperacionCorrecta() {

        return this.codError == CodError.OPERACION_CORRECTA && this.respuesta != null && !respuesta.isEmpty();
    }
}
