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
import javax.persistence.Lob;
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
@Table(name = "GPYT_T042_ACTIVIDAD_GEOMETRIA", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadGeometria.findAll", query = "SELECT a FROM ActividadGeometria a")})
public class ActividadGeometria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A042CODIGO")
    private Integer a042codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A042NROSITIO")
    private int a042nrositio;
    @Lob
    @Column(name = "A042GEOMETRIA_SITIO")
    private Serializable a042geometriaSitio;
    @Lob
    @Column(name = "A042GEOMETRIA_INTERSECC")
    private Serializable a042geometriaIntersecc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A042ESTADOREGISTRO")
    private Character a042estadoregistro;
    @Column(name = "A042FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a042fechacreacion;
    @Column(name = "A042FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a042fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A042USUARIOCREACION")
    private int a042usuariocreacion;
    @Column(name = "A042USUARIOMODIFICACION")
    private Integer a042usuariomodificacion;
    @JoinColumn(name = "A042IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a042idproyecto;
    @JoinColumn(name = "A042IDACTVDD", referencedColumnName = "A005CODIGO")
    @ManyToOne(optional = false)
    private Actividad a042idactvdd;

    public ActividadGeometria() {
    }

    public ActividadGeometria(Integer a042codigo) {
        this.a042codigo = a042codigo;
    }

    public ActividadGeometria(Integer a042codigo, int a042nrositio, Character a042estadoregistro, int a042usuariocreacion) {
        this.a042codigo = a042codigo;
        this.a042nrositio = a042nrositio;
        this.a042estadoregistro = a042estadoregistro;
        this.a042usuariocreacion = a042usuariocreacion;
    }

    public Integer getA042codigo() {
        return a042codigo;
    }

    public void setA042codigo(Integer a042codigo) {
        this.a042codigo = a042codigo;
    }

    public int getA042nrositio() {
        return a042nrositio;
    }

    public void setA042nrositio(int a042nrositio) {
        this.a042nrositio = a042nrositio;
    }

    public Serializable getA042geometriaSitio() {
        return a042geometriaSitio;
    }

    public void setA042geometriaSitio(Serializable a042geometriaSitio) {
        this.a042geometriaSitio = a042geometriaSitio;
    }

    public Serializable getA042geometriaIntersecc() {
        return a042geometriaIntersecc;
    }

    public void setA042geometriaIntersecc(Serializable a042geometriaIntersecc) {
        this.a042geometriaIntersecc = a042geometriaIntersecc;
    }

    public Character getA042estadoregistro() {
        return a042estadoregistro;
    }

    public void setA042estadoregistro(Character a042estadoregistro) {
        this.a042estadoregistro = a042estadoregistro;
    }

    public Date getA042fechacreacion() {
        return a042fechacreacion;
    }

    public void setA042fechacreacion(Date a042fechacreacion) {
        this.a042fechacreacion = a042fechacreacion;
    }

    public Date getA042fechamodificacion() {
        return a042fechamodificacion;
    }

    public void setA042fechamodificacion(Date a042fechamodificacion) {
        this.a042fechamodificacion = a042fechamodificacion;
    }

    public int getA042usuariocreacion() {
        return a042usuariocreacion;
    }

    public void setA042usuariocreacion(int a042usuariocreacion) {
        this.a042usuariocreacion = a042usuariocreacion;
    }

    public Integer getA042usuariomodificacion() {
        return a042usuariomodificacion;
    }

    public void setA042usuariomodificacion(Integer a042usuariomodificacion) {
        this.a042usuariomodificacion = a042usuariomodificacion;
    }

    public Proyecto getA042idproyecto() {
        return a042idproyecto;
    }

    public void setA042idproyecto(Proyecto a042idproyecto) {
        this.a042idproyecto = a042idproyecto;
    }

    public Actividad getA042idactvdd() {
        return a042idactvdd;
    }

    public void setA042idactvdd(Actividad a042idactvdd) {
        this.a042idactvdd = a042idactvdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a042codigo != null ? a042codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadGeometria)) {
            return false;
        }
        ActividadGeometria other = (ActividadGeometria) object;
        if ((this.a042codigo == null && other.a042codigo != null) || (this.a042codigo != null && !this.a042codigo.equals(other.a042codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ActividadGeometria[ a042codigo=" + a042codigo + " ]";
    }
}
