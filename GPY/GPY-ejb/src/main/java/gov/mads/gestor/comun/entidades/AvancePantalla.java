/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Julio C
 */
@Entity
@Table(name = "GPYT_T057_AVANCE_PANTALLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpytT057AvancePantalla.findAll", query = "SELECT g FROM GpytT057AvancePantalla g")})
public class AvancePantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A057CODIGO")
    private Integer a057codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A057ESTADOREGISTRO")
    private Character a057estadoregistro;
    @Column(name = "A057FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a057fechacreacion;
    @Column(name = "A057FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a057fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A057USUARIOCREACION")
    private int a057usuariocreacion;
    @Column(name = "A057USUARIOMODIFICACION")
    private Integer a057usuariomodificacion;
    @JoinColumn(name = "A057IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a057idproyecto;
    @JoinColumn(name = "A057IDPANTALLA", referencedColumnName = "A056CODIGO")
    @ManyToOne(optional = false)
    private Pantalla a057idpantalla;

    public AvancePantalla() {
    }

    public AvancePantalla(Integer a057codigo) {
        this.a057codigo = a057codigo;
    }

    public AvancePantalla(Integer a057codigo, Character a057estadoregistro, int a057usuariocreacion) {
        this.a057codigo = a057codigo;
        this.a057estadoregistro = a057estadoregistro;
        this.a057usuariocreacion = a057usuariocreacion;
    }

    public Integer getA057codigo() {
        return a057codigo;
    }

    public void setA057codigo(Integer a057codigo) {
        this.a057codigo = a057codigo;
    }

    public Character getA057estadoregistro() {
        return a057estadoregistro;
    }

    public void setA057estadoregistro(Character a057estadoregistro) {
        this.a057estadoregistro = a057estadoregistro;
    }

    public Date getA057fechacreacion() {
        return a057fechacreacion;
    }

    public void setA057fechacreacion(Date a057fechacreacion) {
        this.a057fechacreacion = a057fechacreacion;
    }

    public Date getA057fechamodificacion() {
        return a057fechamodificacion;
    }

    public void setA057fechamodificacion(Date a057fechamodificacion) {
        this.a057fechamodificacion = a057fechamodificacion;
    }

    public int getA057usuariocreacion() {
        return a057usuariocreacion;
    }

    public void setA057usuariocreacion(int a057usuariocreacion) {
        this.a057usuariocreacion = a057usuariocreacion;
    }

    public Integer getA057usuariomodificacion() {
        return a057usuariomodificacion;
    }

    public void setA057usuariomodificacion(Integer a057usuariomodificacion) {
        this.a057usuariomodificacion = a057usuariomodificacion;
    }

    public Proyecto getA057idproyecto() {
        return a057idproyecto;
    }

    public void setA057idproyecto(Proyecto a057idproyecto) {
        this.a057idproyecto = a057idproyecto;
    }

    public Pantalla getA057idpantalla() {
        return a057idpantalla;
    }

    public void setA057idpantalla(Pantalla a057idpantalla) {
        this.a057idpantalla = a057idpantalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a057codigo != null ? a057codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvancePantalla)) {
            return false;
        }
        AvancePantalla other = (AvancePantalla) object;
        if ((this.a057codigo == null && other.a057codigo != null) || (this.a057codigo != null && !this.a057codigo.equals(other.a057codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.GpytT057AvancePantalla[ a057codigo=" + a057codigo + " ]";
    }
    
}
