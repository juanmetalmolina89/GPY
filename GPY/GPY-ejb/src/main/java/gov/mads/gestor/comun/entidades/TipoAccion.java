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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GPYT_T050_TIPO_ACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpytT050TipoAccion.findAll", query = "SELECT g FROM GpytT050TipoAccion g")})
public class TipoAccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A050CODIGO")
    private Integer a050codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "A050NOMTIPACCION")
    private String a050nomtipaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A050ESTADOREGISTRO")
    private Character a050estadoregistro;
    @Column(name = "A050FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a050fechacreacion;
    @Column(name = "A050FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a050fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A050USUARIOCREACION")
    private int a050usuariocreacion;
    @Column(name = "A050USUARIOMODIFICACION")
    private Integer a050usuariomodificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a011idtipaccion")
    private Collection<Indicador> indicadorCollection;
    @JoinColumn(name = "A002TIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a002tipproyct;

    public TipoAccion() {
    }

    public TipoAccion(Integer a050codigo) {
        this.a050codigo = a050codigo;
    }

    public TipoAccion(Integer a050codigo, String a050nomtipaccion, Character a050estadoregistro, int a050usuariocreacion) {
        this.a050codigo = a050codigo;
        this.a050nomtipaccion = a050nomtipaccion;
        this.a050estadoregistro = a050estadoregistro;
        this.a050usuariocreacion = a050usuariocreacion;
    }

    public Integer getA050codigo() {
        return a050codigo;
    }

    public void setA050codigo(Integer a050codigo) {
        this.a050codigo = a050codigo;
    }

    public String getA050nomtipaccion() {
        return a050nomtipaccion;
    }

    public void setA050nomtipaccion(String a050nomtipaccion) {
        this.a050nomtipaccion = a050nomtipaccion;
    }

    public Character getA050estadoregistro() {
        return a050estadoregistro;
    }

    public void setA050estadoregistro(Character a050estadoregistro) {
        this.a050estadoregistro = a050estadoregistro;
    }

    public Date getA050fechacreacion() {
        return a050fechacreacion;
    }

    public void setA050fechacreacion(Date a050fechacreacion) {
        this.a050fechacreacion = a050fechacreacion;
    }

    public Date getA050fechamodificacion() {
        return a050fechamodificacion;
    }

    public void setA050fechamodificacion(Date a050fechamodificacion) {
        this.a050fechamodificacion = a050fechamodificacion;
    }

    public int getA050usuariocreacion() {
        return a050usuariocreacion;
    }

    public void setA050usuariocreacion(int a050usuariocreacion) {
        this.a050usuariocreacion = a050usuariocreacion;
    }

    public Integer getA050usuariomodificacion() {
        return a050usuariomodificacion;
    }

    public void setA050usuariomodificacion(Integer a050usuariomodificacion) {
        this.a050usuariomodificacion = a050usuariomodificacion;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Indicador> getIndicadorCollection() {
        return indicadorCollection;
    }

    public void setIndicadorCollection(Collection<Indicador> indicadorCollection) {
        this.indicadorCollection = indicadorCollection;
    }

    public Lista getA002tipproyct() {
        return a002tipproyct;
    }

    public void setA002tipproyct(Lista a002tipproyct) {
        this.a002tipproyct = a002tipproyct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a050codigo != null ? a050codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAccion)) {
            return false;
        }
        TipoAccion other = (TipoAccion) object;
        if ((this.a050codigo == null && other.a050codigo != null) || (this.a050codigo != null && !this.a050codigo.equals(other.a050codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.GpytT050TipoAccion[ a050codigo=" + a050codigo + " ]";
    }
    
}
