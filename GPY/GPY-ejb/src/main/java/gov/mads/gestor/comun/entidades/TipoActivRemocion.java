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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T036_TIPO_ACTIVREMOCION", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActivRemocion.findAll", query = "SELECT t FROM TipoActivRemocion t")})
public class TipoActivRemocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A036CODIGO")
    private Integer a036codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A036DESCTIPACTREM")
    private String a036desctipactrem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A036ESTADOREGISTRO")
    private Character a036estadoregistro;
    @Column(name = "A036FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a036fechacreacion;
    @Column(name = "A036FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a036fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A036USUARIOCREACION")
    private int a036usuariocreacion;
    @Column(name = "A036USUARIOMODIFICACION")
    private Integer a036usuariomodificacion;
    @JoinColumn(name = "A036IDTIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a036idtipproyct;

    public TipoActivRemocion() {
    }

    public TipoActivRemocion(Integer a036codigo) {
        this.a036codigo = a036codigo;
    }

    public TipoActivRemocion(Integer a036codigo, String a036desctipactrem, Character a036estadoregistro, int a036usuariocreacion) {
        this.a036codigo = a036codigo;
        this.a036desctipactrem = a036desctipactrem;
        this.a036estadoregistro = a036estadoregistro;
        this.a036usuariocreacion = a036usuariocreacion;
    }

    public Integer getA036codigo() {
        return a036codigo;
    }

    public void setA036codigo(Integer a036codigo) {
        this.a036codigo = a036codigo;
    }

    public String getA036desctipactrem() {
        return a036desctipactrem;
    }

    public void setA036desctipactrem(String a036desctipactrem) {
        this.a036desctipactrem = a036desctipactrem;
    }

    public Character getA036estadoregistro() {
        return a036estadoregistro;
    }

    public void setA036estadoregistro(Character a036estadoregistro) {
        this.a036estadoregistro = a036estadoregistro;
    }

    public Date getA036fechacreacion() {
        return a036fechacreacion;
    }

    public void setA036fechacreacion(Date a036fechacreacion) {
        this.a036fechacreacion = a036fechacreacion;
    }

    public Date getA036fechamodificacion() {
        return a036fechamodificacion;
    }

    public void setA036fechamodificacion(Date a036fechamodificacion) {
        this.a036fechamodificacion = a036fechamodificacion;
    }

    public int getA036usuariocreacion() {
        return a036usuariocreacion;
    }

    public void setA036usuariocreacion(int a036usuariocreacion) {
        this.a036usuariocreacion = a036usuariocreacion;
    }

    public Integer getA036usuariomodificacion() {
        return a036usuariomodificacion;
    }

    public void setA036usuariomodificacion(Integer a036usuariomodificacion) {
        this.a036usuariomodificacion = a036usuariomodificacion;
    }

    public Lista getA036idtipproyct() {
        return a036idtipproyct;
    }

    public void setA036idtipproyct(Lista a036idtipproyct) {
        this.a036idtipproyct = a036idtipproyct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a036codigo != null ? a036codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActivRemocion)) {
            return false;
        }
        TipoActivRemocion other = (TipoActivRemocion) object;
        if ((this.a036codigo == null && other.a036codigo != null) || (this.a036codigo != null && !this.a036codigo.equals(other.a036codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.TipoActivRemocion[ a036codigo=" + a036codigo + " ]";
    }
    
}
