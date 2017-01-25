/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Julio C
 */
@Entity
@Table(name = "GPYT_T056_PANTALLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpytT056Pantalla.findAll", query = "SELECT g FROM GpytT056Pantalla g")})
public class Pantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A056CODIGO")
    private Integer a056codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A056NOMPANTALLA")
    private String a056nompantalla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A056ESTADOREGISTRO")
    private Character a056estadoregistro;
    @Column(name = "A056FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a056fechacreacion;
    @Column(name = "A056FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a056fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A056USUARIOCREACION")
    private int a056usuariocreacion;
    @Column(name = "A056USUARIOMODIFICACION")
    private Integer a056usuariomodificacion;
    @OneToMany(mappedBy = "a025idpantalla")
    private Collection<Adjunto> adjuntoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a057idpantalla")
    private Collection<AvancePantalla> gpytT057AvancePantallaCollection;

    public Pantalla() {
    }

    public Pantalla(Integer a056codigo) {
        this.a056codigo = a056codigo;
    }

    public Pantalla(Integer a056codigo, String a056nompantalla, Character a056estadoregistro, int a056usuariocreacion) {
        this.a056codigo = a056codigo;
        this.a056nompantalla = a056nompantalla;
        this.a056estadoregistro = a056estadoregistro;
        this.a056usuariocreacion = a056usuariocreacion;
    }

    public Integer getA056codigo() {
        return a056codigo;
    }

    public void setA056codigo(Integer a056codigo) {
        this.a056codigo = a056codigo;
    }

    public String getA056nompantalla() {
        return a056nompantalla;
    }

    public void setA056nompantalla(String a056nompantalla) {
        this.a056nompantalla = a056nompantalla;
    }

    public Character getA056estadoregistro() {
        return a056estadoregistro;
    }

    public void setA056estadoregistro(Character a056estadoregistro) {
        this.a056estadoregistro = a056estadoregistro;
    }

    public Date getA056fechacreacion() {
        return a056fechacreacion;
    }

    public void setA056fechacreacion(Date a056fechacreacion) {
        this.a056fechacreacion = a056fechacreacion;
    }

    public Date getA056fechamodificacion() {
        return a056fechamodificacion;
    }

    public void setA056fechamodificacion(Date a056fechamodificacion) {
        this.a056fechamodificacion = a056fechamodificacion;
    }

    public int getA056usuariocreacion() {
        return a056usuariocreacion;
    }

    public void setA056usuariocreacion(int a056usuariocreacion) {
        this.a056usuariocreacion = a056usuariocreacion;
    }

    public Integer getA056usuariomodificacion() {
        return a056usuariomodificacion;
    }

    public void setA056usuariomodificacion(Integer a056usuariomodificacion) {
        this.a056usuariomodificacion = a056usuariomodificacion;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Adjunto> getAdjuntoCollection() {
        return adjuntoCollection;
    }

    public void setAdjuntoCollection(Collection<Adjunto> adjuntoCollection) {
        this.adjuntoCollection = adjuntoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AvancePantalla> getGpytT057AvancePantallaCollection() {
        return gpytT057AvancePantallaCollection;
    }

    public void setGpytT057AvancePantallaCollection(Collection<AvancePantalla> gpytT057AvancePantallaCollection) {
        this.gpytT057AvancePantallaCollection = gpytT057AvancePantallaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a056codigo != null ? a056codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalla)) {
            return false;
        }
        Pantalla other = (Pantalla) object;
        if ((this.a056codigo == null && other.a056codigo != null) || (this.a056codigo != null && !this.a056codigo.equals(other.a056codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.GpytT056Pantalla[ a056codigo=" + a056codigo + " ]";
    }
    
}
