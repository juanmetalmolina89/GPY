/*
 * Objeto de Salida Principal
 */
package gov.mads.gestor.comun.vista;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@XmlRootElement
public class GenericoOS implements Serializable {

    private List<Object> respuesta;
    private int codError;
    private String msjError;

    public List<Object> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<Object> respuesta) {
        this.respuesta = respuesta;
    }

    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    @Override
    public String toString() {
        return "GenericoOS{" + "respuesta=" + respuesta + ", codError=" + codError + ", msjError=" + msjError + '}';
    }

}
