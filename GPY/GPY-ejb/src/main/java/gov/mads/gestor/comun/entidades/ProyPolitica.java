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
 * @author juanmetalmolina
 */
@Entity
@Table(name = "GPYT_T007_PROY_POLITICA")
@XmlRootElement

public class ProyPolitica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A007CODIGO")
    private Integer a007codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A007ESTADOREGISTRO")
    private Character a007estadoregistro;
    @Column(name = "A007FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a007fechacreacion;
    @Column(name = "A007FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a007fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A007USUARIOCREACION")
    private int a007usuariocreacion;
    @Column(name = "A007USUARIOMODIFICACION")
    private Integer a007usuariomodificacion;
    @JoinColumn(name = "A007IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a007idproyecto;
    @JoinColumn(name = "A007IDPOLITICA", referencedColumnName = "A003CODIGO")
    @ManyToOne(optional = false)
    private Politica a007idpolitica;

    public ProyPolitica() {
    }

    public ProyPolitica(Integer a007codigo) {
        this.a007codigo = a007codigo;
    }

    public ProyPolitica(Integer a007codigo, Character a007estadoregistro, int a007usuariocreacion) {
        this.a007codigo = a007codigo;
        this.a007estadoregistro = a007estadoregistro;
        this.a007usuariocreacion = a007usuariocreacion;
    }

    public Integer getA007codigo() {
        return a007codigo;
    }

    public void setA007codigo(Integer a007codigo) {
        this.a007codigo = a007codigo;
    }

    public Character getA007estadoregistro() {
        return a007estadoregistro;
    }

    public void setA007estadoregistro(Character a007estadoregistro) {
        this.a007estadoregistro = a007estadoregistro;
    }

    public Date getA007fechacreacion() {
        return a007fechacreacion;
    }

    public void setA007fechacreacion(Date a007fechacreacion) {
        this.a007fechacreacion = a007fechacreacion;
    }

    public Date getA007fechamodificacion() {
        return a007fechamodificacion;
    }

    public void setA007fechamodificacion(Date a007fechamodificacion) {
        this.a007fechamodificacion = a007fechamodificacion;
    }

    public int getA007usuariocreacion() {
        return a007usuariocreacion;
    }

    public void setA007usuariocreacion(int a007usuariocreacion) {
        this.a007usuariocreacion = a007usuariocreacion;
    }

    public Integer getA007usuariomodificacion() {
        return a007usuariomodificacion;
    }

    public void setA007usuariomodificacion(Integer a007usuariomodificacion) {
        this.a007usuariomodificacion = a007usuariomodificacion;
    }

    public Proyecto getA007idproyecto() {
        return a007idproyecto;
    }

    public void setA007idproyecto(Proyecto a007idproyecto) {
        this.a007idproyecto = a007idproyecto;
    }

    public Politica getA007idpolitica() {
        return a007idpolitica;
    }

    public void setA007idpolitica(Politica a007idpolitica) {
        this.a007idpolitica = a007idpolitica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a007codigo != null ? a007codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyPolitica)) {
            return false;
        }
        ProyPolitica other = (ProyPolitica) object;
        if ((this.a007codigo == null && other.a007codigo != null) || (this.a007codigo != null && !this.a007codigo.equals(other.a007codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ProyPolitica[ a007codigo=" + a007codigo + " ]";
    }
    
}
