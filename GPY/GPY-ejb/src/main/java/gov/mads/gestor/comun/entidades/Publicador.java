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
@Table(name = "GPYT_T055_PUBLICADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpytT055Publicador.findAll", query = "SELECT g FROM GpytT055Publicador g")})
public class Publicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A055CODIGO")
    private Integer a055codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A055ESTADOREGISTRO")
    private Character a055estadoregistro;
    @Column(name = "A055FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a055fechacreacion;
    @Column(name = "A055FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a055fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A055USUARIOCREACION")
    private int a055usuariocreacion;
    @Column(name = "A055USUARIOMODIFICACION")
    private Integer a055usuariomodificacion;
    @JoinColumn(name = "A055IDPERSONA", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a055idpersona;
    @JoinColumn(name = "A055IDPUBLICADOR", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a055idpublicador;

    public Publicador() {
    }

    public Publicador(Integer a055codigo) {
        this.a055codigo = a055codigo;
    }

    public Publicador(Integer a055codigo, Character a055estadoregistro, int a055usuariocreacion) {
        this.a055codigo = a055codigo;
        this.a055estadoregistro = a055estadoregistro;
        this.a055usuariocreacion = a055usuariocreacion;
    }

    public Integer getA055codigo() {
        return a055codigo;
    }

    public void setA055codigo(Integer a055codigo) {
        this.a055codigo = a055codigo;
    }

    public Character getA055estadoregistro() {
        return a055estadoregistro;
    }

    public void setA055estadoregistro(Character a055estadoregistro) {
        this.a055estadoregistro = a055estadoregistro;
    }

    public Date getA055fechacreacion() {
        return a055fechacreacion;
    }

    public void setA055fechacreacion(Date a055fechacreacion) {
        this.a055fechacreacion = a055fechacreacion;
    }

    public Date getA055fechamodificacion() {
        return a055fechamodificacion;
    }

    public void setA055fechamodificacion(Date a055fechamodificacion) {
        this.a055fechamodificacion = a055fechamodificacion;
    }

    public int getA055usuariocreacion() {
        return a055usuariocreacion;
    }

    public void setA055usuariocreacion(int a055usuariocreacion) {
        this.a055usuariocreacion = a055usuariocreacion;
    }

    public Integer getA055usuariomodificacion() {
        return a055usuariomodificacion;
    }

    public void setA055usuariomodificacion(Integer a055usuariomodificacion) {
        this.a055usuariomodificacion = a055usuariomodificacion;
    }

    public Persona getA055idpersona() {
        return a055idpersona;
    }

    public void setA055idpersona(Persona a055idpersona) {
        this.a055idpersona = a055idpersona;
    }

    public Persona getA055idpublicador() {
        return a055idpublicador;
    }

    public void setA055idpublicador(Persona a055idpublicador) {
        this.a055idpublicador = a055idpublicador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a055codigo != null ? a055codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicador)) {
            return false;
        }
        Publicador other = (Publicador) object;
        if ((this.a055codigo == null && other.a055codigo != null) || (this.a055codigo != null && !this.a055codigo.equals(other.a055codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.GpytT055Publicador[ a055codigo=" + a055codigo + " ]";
    }
    
}
