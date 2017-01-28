/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T022_TIPO_ACTIVIDAD", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividad.findAll", query = "SELECT t FROM TipoActividad t")})
public class TipoActividad implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a005idtipactvdd")
    private Collection<Actividad> actividadCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A022CODIGO")
    private Integer a022codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A022DESCRPCNACTVDD")
    private String a022descrpcnactvdd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A022ESTADOREGISTRO")
    private Character a022estadoregistro;
    @NotNull
    @Column(name = "A022ACTESPECIAL")
    private Character a022actespecial;
    @Column(name = "A022FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a022fechacreacion;
    @Column(name = "A022FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a022fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A022USUARIOCREACION")
    private int a022usuariocreacion;
    @Column(name = "A022USUARIOMODIFICACION")
    private Integer a022usuariomodificacion;
    @JoinColumn(name = "A022IDTIPPROYCT", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a022idtipproyct;
    @JoinColumn(name = "A022IDTIPPROYCTMDL", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a022idtipproyctmdl;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a005idtipactvdd")
//    private List<Actividad> actividadList;

    public TipoActividad() {
    }

    public TipoActividad(Integer a022codigo) {
        this.a022codigo = a022codigo;
    }

    public TipoActividad(Integer a022codigo, String a022descrpcnactvdd, Character a022estadoregistro, int a022usuariocreacion) {
        this.a022codigo = a022codigo;
        this.a022descrpcnactvdd = a022descrpcnactvdd;
        this.a022estadoregistro = a022estadoregistro;
        this.a022usuariocreacion = a022usuariocreacion;
    }

    public Integer getA022codigo() {
        return a022codigo;
    }

    public void setA022codigo(Integer a022codigo) {
        this.a022codigo = a022codigo;
    }

    public String getA022descrpcnactvdd() {
        return a022descrpcnactvdd;
    }

    public void setA022descrpcnactvdd(String a022descrpcnactvdd) {
        this.a022descrpcnactvdd = a022descrpcnactvdd;
    }

    public Character getA022estadoregistro() {
        return a022estadoregistro;
    }

    public void setA022estadoregistro(Character a022estadoregistro) {
        this.a022estadoregistro = a022estadoregistro;
    }

    public Date getA022fechacreacion() {
        return a022fechacreacion;
    }

    public void setA022fechacreacion(Date a022fechacreacion) {
        this.a022fechacreacion = a022fechacreacion;
    }

    public Date getA022fechamodificacion() {
        return a022fechamodificacion;
    }

    public void setA022fechamodificacion(Date a022fechamodificacion) {
        this.a022fechamodificacion = a022fechamodificacion;
    }

    public int getA022usuariocreacion() {
        return a022usuariocreacion;
    }

    public void setA022usuariocreacion(int a022usuariocreacion) {
        this.a022usuariocreacion = a022usuariocreacion;
    }

    public Integer getA022usuariomodificacion() {
        return a022usuariomodificacion;
    }

    public void setA022usuariomodificacion(Integer a022usuariomodificacion) {
        this.a022usuariomodificacion = a022usuariomodificacion;
    }

    public Proyecto getA022idtipproyct() {
        return a022idtipproyct;
    }

    public void setA022idtipproyct(Proyecto a022idtipproyct) {
        this.a022idtipproyct = a022idtipproyct;
    }

    public Lista getA022idtipproyctmdl() {
        return a022idtipproyctmdl;
    }

    public void setA022idtipproyctmdl(Lista a022idtipproyctmdl) {
        this.a022idtipproyctmdl = a022idtipproyctmdl;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Actividad> getActividadList() {
//        return actividadList;
//    }
//
//    public void setActividadList(List<Actividad> actividadList) {
//        this.actividadList = actividadList;
//    }

    public Character getA022actespecial() {
        return a022actespecial;
    }

    public void setA022actespecial(Character a022actespecial) {
        this.a022actespecial = a022actespecial;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a022codigo != null ? a022codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividad)) {
            return false;
        }
        TipoActividad other = (TipoActividad) object;
        if ((this.a022codigo == null && other.a022codigo != null) || (this.a022codigo != null && !this.a022codigo.equals(other.a022codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.TipoActividad[ a022codigo=" + a022codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }
    
}
