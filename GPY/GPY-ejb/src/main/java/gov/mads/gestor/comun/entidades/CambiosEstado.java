/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T044_CAMBIOS_ESTADO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CambiosEstado.findAll", query = "SELECT c FROM CambiosEstado c")})
public class CambiosEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A044CODIGO")
    private Integer a044codigo;
    @Column(name = "A044FECHCAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a044fechcambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A044ESTADOREGISTRO")
    private Character a044estadoregistro;
    @Column(name = "A044FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a044fechacreacion;
    @Column(name = "A044FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a044fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A044USUARIOCREACION")
    private int a044usuariocreacion;
    @Column(name = "A044USUARIOMODIFICACION")
    private Integer a044usuariomodificacion;
    @JoinColumn(name = "A044IDPRYTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a044idpryto;
    @JoinColumn(name = "A044ESTDESPUES", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a044estdespues;
    @JoinColumn(name = "A044ESTANTES", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a044estantes;

    public CambiosEstado() {
    }

    public CambiosEstado(Integer a044codigo) {
        this.a044codigo = a044codigo;
    }

    public CambiosEstado(Integer a044codigo, Character a044estadoregistro, int a044usuariocreacion) {
        this.a044codigo = a044codigo;
        this.a044estadoregistro = a044estadoregistro;
        this.a044usuariocreacion = a044usuariocreacion;
    }

    public Integer getA044codigo() {
        return a044codigo;
    }

    public void setA044codigo(Integer a044codigo) {
        this.a044codigo = a044codigo;
    }

    public Date getA044fechcambio() {
        return a044fechcambio;
    }

    public void setA044fechcambio(Date a044fechcambio) {
        this.a044fechcambio = a044fechcambio;
    }

    public Character getA044estadoregistro() {
        return a044estadoregistro;
    }

    public void setA044estadoregistro(Character a044estadoregistro) {
        this.a044estadoregistro = a044estadoregistro;
    }

    public Date getA044fechacreacion() {
        return a044fechacreacion;
    }

    public void setA044fechacreacion(Date a044fechacreacion) {
        this.a044fechacreacion = a044fechacreacion;
    }

    public Date getA044fechamodificacion() {
        return a044fechamodificacion;
    }

    public void setA044fechamodificacion(Date a044fechamodificacion) {
        this.a044fechamodificacion = a044fechamodificacion;
    }

    public int getA044usuariocreacion() {
        return a044usuariocreacion;
    }

    public void setA044usuariocreacion(int a044usuariocreacion) {
        this.a044usuariocreacion = a044usuariocreacion;
    }

    public Integer getA044usuariomodificacion() {
        return a044usuariomodificacion;
    }

    public void setA044usuariomodificacion(Integer a044usuariomodificacion) {
        this.a044usuariomodificacion = a044usuariomodificacion;
    }

    public Proyecto getA044idpryto() {
        return a044idpryto;
    }

    public void setA044idpryto(Proyecto a044idpryto) {
        this.a044idpryto = a044idpryto;
    }

    public Lista getA044estdespues() {
        return a044estdespues;
    }

    public void setA044estdespues(Lista a044estdespues) {
        this.a044estdespues = a044estdespues;
    }

    public Lista getA044estantes() {
        return a044estantes;
    }

    public void setA044estantes(Lista a044estantes) {
        this.a044estantes = a044estantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a044codigo != null ? a044codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CambiosEstado)) {
            return false;
        }
        CambiosEstado other = (CambiosEstado) object;
        if ((this.a044codigo == null && other.a044codigo != null) || (this.a044codigo != null && !this.a044codigo.equals(other.a044codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.CambiosEstado[ a044codigo=" + a044codigo + " ]";
    }
    
}
