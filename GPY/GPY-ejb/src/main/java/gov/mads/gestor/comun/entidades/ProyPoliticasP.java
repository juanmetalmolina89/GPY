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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "GPYT_T059_PROY_POLITICAS_P")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyPoliticasP.findAll", query = "SELECT p FROM ProyPoliticasP p"),
    @NamedQuery(name = "ProyPoliticasP.findByA059codigo", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059codigo = :a059codigo"),
    @NamedQuery(name = "ProyPoliticasP.findByA059descripcion", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059descripcion = :a059descripcion"),
    @NamedQuery(name = "ProyPoliticasP.findByA059estadoregistro", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059estadoregistro = :a059estadoregistro"),
    @NamedQuery(name = "ProyPoliticasP.findByA059fechacreacion", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059fechacreacion = :a059fechacreacion"),
    @NamedQuery(name = "ProyPoliticasP.findByA059fechamodificacion", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059fechamodificacion = :a059fechamodificacion"),
    @NamedQuery(name = "ProyPoliticasP.findByA059usuariocreacion", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059usuariocreacion = :a059usuariocreacion"),
    @NamedQuery(name = "ProyPoliticasP.findByA059usuariomodificacion", query = "SELECT p FROM ProyPoliticasP p WHERE p.a059usuariomodificacion = :a059usuariomodificacion")})
public class ProyPoliticasP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A059CODIGO")
    private Integer a059codigo;
    @Size(max = 200)
    @Column(name = "A059DESCRIPCION")
    private String a059descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A059ESTADOREGISTRO")
    private Character a059estadoregistro;
    @Column(name = "A059FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a059fechacreacion;
    @Column(name = "A059FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a059fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A059USUARIOCREACION")
    private int a059usuariocreacion;
    @Column(name = "A059USUARIOMODIFICACION")
    private Integer a059usuariomodificacion;
    @JoinColumn(name = "A059IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a059idproyecto;

    public ProyPoliticasP() {
    }

    public ProyPoliticasP(Integer a059codigo) {
        this.a059codigo = a059codigo;
    }

    public ProyPoliticasP(Integer a059codigo, Character a059estadoregistro, int a059usuariocreacion) {
        this.a059codigo = a059codigo;
        this.a059estadoregistro = a059estadoregistro;
        this.a059usuariocreacion = a059usuariocreacion;
    }

    public Integer getA059codigo() {
        return a059codigo;
    }

    public void setA059codigo(Integer a059codigo) {
        this.a059codigo = a059codigo;
    }

    public String getA059descripcion() {
        return a059descripcion;
    }

    public void setA059descripcion(String a059descripcion) {
        this.a059descripcion = a059descripcion;
    }

    public Character getA059estadoregistro() {
        return a059estadoregistro;
    }

    public void setA059estadoregistro(Character a059estadoregistro) {
        this.a059estadoregistro = a059estadoregistro;
    }

    public Date getA059fechacreacion() {
        return a059fechacreacion;
    }

    public void setA059fechacreacion(Date a059fechacreacion) {
        this.a059fechacreacion = a059fechacreacion;
    }

    public Date getA059fechamodificacion() {
        return a059fechamodificacion;
    }

    public void setA059fechamodificacion(Date a059fechamodificacion) {
        this.a059fechamodificacion = a059fechamodificacion;
    }

    public int getA059usuariocreacion() {
        return a059usuariocreacion;
    }

    public void setA059usuariocreacion(int a059usuariocreacion) {
        this.a059usuariocreacion = a059usuariocreacion;
    }

    public Integer getA059usuariomodificacion() {
        return a059usuariomodificacion;
    }

    public void setA059usuariomodificacion(Integer a059usuariomodificacion) {
        this.a059usuariomodificacion = a059usuariomodificacion;
    }

    public Proyecto getA059idproyecto() {
        return a059idproyecto;
    }

    public void setA059idproyecto(Proyecto a059idproyecto) {
        this.a059idproyecto = a059idproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a059codigo != null ? a059codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyPoliticasP)) {
            return false;
        }
        ProyPoliticasP other = (ProyPoliticasP) object;
        if ((this.a059codigo == null && other.a059codigo != null) || (this.a059codigo != null && !this.a059codigo.equals(other.a059codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ProyPoliticasP[ a059codigo=" + a059codigo + " ]";
    }
    
}
