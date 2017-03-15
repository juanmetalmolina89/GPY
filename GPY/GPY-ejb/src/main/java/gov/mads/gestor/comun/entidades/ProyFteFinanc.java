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
@Table(name = "GPYT_T004_PROY_FTE_FINANC", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyFteFinanc.findAll", query = "SELECT p FROM ProyFteFinanc p")})
public class ProyFteFinanc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A004CODIGO")
    private Integer a004codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A004ESTADOREGISTRO")
    private Character a004estadoregistro;
    @Column(name = "A004FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a004fechacreacion;
    @Column(name = "A004FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a004fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A004USUARIOCREACION")
    private int a004usuariocreacion;
    @Column(name = "A004USUARIOMODIFICACION")
    private Integer a004usuariomodificacion;
    @JoinColumn(name = "A004IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a004idproyecto;
    @JoinColumn(name = "A004IDFUNTFINNCCN", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a004idfuntfinnccn;

    public ProyFteFinanc() {
    }

    public ProyFteFinanc(Integer a004codigo) {
        this.a004codigo = a004codigo;
    }

    public ProyFteFinanc(Integer a004codigo, Character a004estadoregistro, int a004usuariocreacion) {
        this.a004codigo = a004codigo;
        this.a004estadoregistro = a004estadoregistro;
        this.a004usuariocreacion = a004usuariocreacion;
    }

    public Integer getA004codigo() {
        return a004codigo;
    }

    public void setA004codigo(Integer a004codigo) {
        this.a004codigo = a004codigo;
    }

    public Character getA004estadoregistro() {
        return a004estadoregistro;
    }

    public void setA004estadoregistro(Character a004estadoregistro) {
        this.a004estadoregistro = a004estadoregistro;
    }

    public Date getA004fechacreacion() {
        return a004fechacreacion;
    }

    public void setA004fechacreacion(Date a004fechacreacion) {
        this.a004fechacreacion = a004fechacreacion;
    }

    public Date getA004fechamodificacion() {
        return a004fechamodificacion;
    }

    public void setA004fechamodificacion(Date a004fechamodificacion) {
        this.a004fechamodificacion = a004fechamodificacion;
    }

    public int getA004usuariocreacion() {
        return a004usuariocreacion;
    }

    public void setA004usuariocreacion(int a004usuariocreacion) {
        this.a004usuariocreacion = a004usuariocreacion;
    }

    public Integer getA004usuariomodificacion() {
        return a004usuariomodificacion;
    }

    public void setA004usuariomodificacion(Integer a004usuariomodificacion) {
        this.a004usuariomodificacion = a004usuariomodificacion;
    }

    public Proyecto getA004idproyecto() {
        return a004idproyecto;
    }

    public void setA004idproyecto(Proyecto a004idproyecto) {
        this.a004idproyecto = a004idproyecto;
    }

    public Lista getA004idfuntfinnccn() {
        return a004idfuntfinnccn;
    }

    public void setA004idfuntfinnccn(Lista a004idfuntfinnccn) {
        this.a004idfuntfinnccn = a004idfuntfinnccn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a004codigo != null ? a004codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyFteFinanc)) {
            return false;
        }
        ProyFteFinanc other = (ProyFteFinanc) object;
        if ((this.a004codigo == null && other.a004codigo != null) || (this.a004codigo != null && !this.a004codigo.equals(other.a004codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ProyFteFinanc[ a004codigo=" + a004codigo + " ]";
    }

}
