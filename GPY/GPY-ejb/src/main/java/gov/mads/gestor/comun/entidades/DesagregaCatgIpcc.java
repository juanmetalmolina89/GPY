/*
 * Entidades creadas directamente de la BD
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
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T048_DESAGREGACATG_IPCC", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesagregacatgIpcc.findAll", query = "SELECT d FROM DesagregacatgIpcc d")})
public class DesagregaCatgIpcc implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a038iddesgrcatipcc")
    private Collection<Fuente> fuenteCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A048CODIGO")
    private Integer a048codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A048NOMBRE")
    private String a048nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A048ESTADOREGISTRO")
    private Character a048estadoregistro;
    @Column(name = "A048FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a048fechacreacion;
    @Column(name = "A048FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a048fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A048USUARIOCREACION")
    private int a048usuariocreacion;
    @Column(name = "A048USUARIOMODIFICACION")
    private Integer a048usuariomodificacion;
    @JoinColumn(name = "A048IDSUBCATIPCC", referencedColumnName = "A047CODIGO")
    @ManyToOne(optional = false)
    private SubcategoriaIpcc a048idsubcatipcc;

    public DesagregaCatgIpcc() {
    }

    public DesagregaCatgIpcc(Integer a048codigo) {
        this.a048codigo = a048codigo;
    }

    public DesagregaCatgIpcc(Integer a048codigo, String a048nombre, Character a048estadoregistro, int a048usuariocreacion) {
        this.a048codigo = a048codigo;
        this.a048nombre = a048nombre;
        this.a048estadoregistro = a048estadoregistro;
        this.a048usuariocreacion = a048usuariocreacion;
    }

    public Integer getA048codigo() {
        return a048codigo;
    }

    public void setA048codigo(Integer a048codigo) {
        this.a048codigo = a048codigo;
    }

    public String getA048nombre() {
        return a048nombre;
    }

    public void setA048nombre(String a048nombre) {
        this.a048nombre = a048nombre;
    }

    public Character getA048estadoregistro() {
        return a048estadoregistro;
    }

    public void setA048estadoregistro(Character a048estadoregistro) {
        this.a048estadoregistro = a048estadoregistro;
    }

    public Date getA048fechacreacion() {
        return a048fechacreacion;
    }

    public void setA048fechacreacion(Date a048fechacreacion) {
        this.a048fechacreacion = a048fechacreacion;
    }

    public Date getA048fechamodificacion() {
        return a048fechamodificacion;
    }

    public void setA048fechamodificacion(Date a048fechamodificacion) {
        this.a048fechamodificacion = a048fechamodificacion;
    }

    public int getA048usuariocreacion() {
        return a048usuariocreacion;
    }

    public void setA048usuariocreacion(int a048usuariocreacion) {
        this.a048usuariocreacion = a048usuariocreacion;
    }

    public Integer getA048usuariomodificacion() {
        return a048usuariomodificacion;
    }

    public void setA048usuariomodificacion(Integer a048usuariomodificacion) {
        this.a048usuariomodificacion = a048usuariomodificacion;
    }

    public SubcategoriaIpcc getA048idsubcatipcc() {
        return a048idsubcatipcc;
    }

    public void setA048idsubcatipcc(SubcategoriaIpcc a048idsubcatipcc) {
        this.a048idsubcatipcc = a048idsubcatipcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a048codigo != null ? a048codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesagregaCatgIpcc)) {
            return false;
        }
        DesagregaCatgIpcc other = (DesagregaCatgIpcc) object;
        if ((this.a048codigo == null && other.a048codigo != null) || (this.a048codigo != null && !this.a048codigo.equals(other.a048codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.DesagregacatgIpcc[ a048codigo=" + a048codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Fuente> getFuenteCollection() {
        return fuenteCollection;
    }

    public void setFuenteCollection(Collection<Fuente> fuenteCollection) {
        this.fuenteCollection = fuenteCollection;
    }
    
}
