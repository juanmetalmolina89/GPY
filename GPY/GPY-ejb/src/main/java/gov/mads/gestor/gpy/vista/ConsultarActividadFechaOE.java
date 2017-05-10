/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.vista;

import gov.mads.gestor.comun.vista.ObjetoEntrada;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@XmlRootElement
public class ConsultarActividadFechaOE extends ObjetoEntrada{
    @XmlElement
    private Integer idModulo;
    @XmlElement
    private Integer idSistema;
    
    @XmlElement
    @Temporal(TemporalType.TIMESTAMP)
    
    private Date fecha;
    @XmlElement
    private String operacion;        
    @XmlElement
    private String url;        
    
    @XmlElement
    private String operacionComponente;
    
    @XmlElement
    private String tipoGeometria;
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOperacionComponente() {
        return operacionComponente;
    }

    public void setOperacionComponente(String operacionComponente) {
        this.operacionComponente = operacionComponente;
    }

    public String getTipoGeometria() {
        return tipoGeometria;
    }

    public void setTipoGeometria(String tipoGeometria) {
        this.tipoGeometria = tipoGeometria;
    }

}
