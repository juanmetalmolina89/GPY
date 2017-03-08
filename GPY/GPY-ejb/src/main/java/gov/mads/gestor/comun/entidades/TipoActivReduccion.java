/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "GPYT_T058_TIPO_ACTIV_REDUCCION", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActivReduccion.findAll", query = "SELECT t FROM TipoActivReduccion t"),
    @NamedQuery(name = "TipoActivReduccion.findByA058codigo", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058codigo = :a058codigo"),
    @NamedQuery(name = "TipoActivReduccion.findByA058descripcion", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058descripcion = :a058descripcion"),
    @NamedQuery(name = "TipoActivReduccion.findByA058estadoregistro", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058estadoregistro = :a058estadoregistro"),
    @NamedQuery(name = "TipoActivReduccion.findByA058fechacreacion", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058fechacreacion = :a058fechacreacion"),
    @NamedQuery(name = "TipoActivReduccion.findByA058fechamodificacion", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058fechamodificacion = :a058fechamodificacion"),
    @NamedQuery(name = "TipoActivReduccion.findByA058usuariocreacion", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058usuariocreacion = :a058usuariocreacion"),
    @NamedQuery(name = "TipoActivReduccion.findByA058usuariomodificacion", query = "SELECT t FROM TipoActivReduccion t WHERE t.a058usuariomodificacion = :a058usuariomodificacion")})
public class TipoActivReduccion implements Serializable {

    @OneToMany(mappedBy = "a005idtipactvdreduc")
    private List<Actividad> actividadList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A058CODIGO")
    private Integer a058codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "A058DESCRIPCION")
    private String a058descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A058ESTADOREGISTRO")
    private Character a058estadoregistro;
    @Column(name = "A058FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a058fechacreacion;
    @Column(name = "A058FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a058fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A058USUARIOCREACION")
    private int a058usuariocreacion;
    @Column(name = "A058USUARIOMODIFICACION")
    private Integer a058usuariomodificacion;
//    @OneToMany(mappedBy = "a005idtipactvdreduc")
//    private List<Actividad> actividadList;
    @JoinColumn(name = "A058TIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a058tipproyct;

    public TipoActivReduccion() {
    }

    public TipoActivReduccion(Integer a058codigo) {
        this.a058codigo = a058codigo;
    }

    public TipoActivReduccion(Integer a058codigo, String a058descripcion, Character a058estadoregistro, int a058usuariocreacion) {
        this.a058codigo = a058codigo;
        this.a058descripcion = a058descripcion;
        this.a058estadoregistro = a058estadoregistro;
        this.a058usuariocreacion = a058usuariocreacion;
    }

    public Integer getA058codigo() {
        return a058codigo;
    }

    public void setA058codigo(Integer a058codigo) {
        this.a058codigo = a058codigo;
    }

    public String getA058descripcion() {
        return a058descripcion;
    }

    public void setA058descripcion(String a058descripcion) {
        this.a058descripcion = a058descripcion;
    }

    public Character getA058estadoregistro() {
        return a058estadoregistro;
    }

    public void setA058estadoregistro(Character a058estadoregistro) {
        this.a058estadoregistro = a058estadoregistro;
    }

    public Date getA058fechacreacion() {
        return a058fechacreacion;
    }

    public void setA058fechacreacion(Date a058fechacreacion) {
        this.a058fechacreacion = a058fechacreacion;
    }

    public Date getA058fechamodificacion() {
        return a058fechamodificacion;
    }

    public void setA058fechamodificacion(Date a058fechamodificacion) {
        this.a058fechamodificacion = a058fechamodificacion;
    }

    public int getA058usuariocreacion() {
        return a058usuariocreacion;
    }

    public void setA058usuariocreacion(int a058usuariocreacion) {
        this.a058usuariocreacion = a058usuariocreacion;
    }

    public Integer getA058usuariomodificacion() {
        return a058usuariomodificacion;
    }

    public void setA058usuariomodificacion(Integer a058usuariomodificacion) {
        this.a058usuariomodificacion = a058usuariomodificacion;
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

    public Lista getA058tipproyct() {
        return a058tipproyct;
    }

    public void setA058tipproyct(Lista a058tipproyct) {
        this.a058tipproyct = a058tipproyct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a058codigo != null ? a058codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActivReduccion)) {
            return false;
        }
        TipoActivReduccion other = (TipoActivReduccion) object;
        if ((this.a058codigo == null && other.a058codigo != null) || (this.a058codigo != null && !this.a058codigo.equals(other.a058codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.TipoActivReduccion[ a058codigo=" + a058codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }
    
}
