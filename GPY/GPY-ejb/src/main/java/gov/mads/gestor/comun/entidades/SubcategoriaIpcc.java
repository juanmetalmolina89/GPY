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
@Table(name = "GPYT_T047_SUBCATEGORIA_IPCC", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubcategoriaIpcc.findAll", query = "SELECT s FROM SubcategoriaIpcc s")})
public class SubcategoriaIpcc implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a048idsubcatipcc")
    private Collection<DesagregaCatgIpcc> desagregaCatgIpccCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A047CODIGO")
    private Integer a047codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A047NOMBRE")
    private String a047nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A047ESTADOREGISTRO")
    private Character a047estadoregistro;
    @Column(name = "A047FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a047fechacreacion;
    @Column(name = "A047FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a047fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A047USUARIOCREACION")
    private int a047usuariocreacion;
    @Column(name = "A047USUARIOMODIFICACION")
    private Integer a047usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a048idsubcatipcc")
//    private List<DesagregaCatgIpcc> desagregaCatgIpccList;
    @JoinColumn(name = "A047IDCATIPCC", referencedColumnName = "A046CODIGO")
    @ManyToOne(optional = false)
    private CategoriaIpcc a047idcatipcc;

    public SubcategoriaIpcc() {
    }

    public SubcategoriaIpcc(Integer a047codigo) {
        this.a047codigo = a047codigo;
    }

    public SubcategoriaIpcc(Integer a047codigo, String a047nombre, Character a047estadoregistro, int a047usuariocreacion) {
        this.a047codigo = a047codigo;
        this.a047nombre = a047nombre;
        this.a047estadoregistro = a047estadoregistro;
        this.a047usuariocreacion = a047usuariocreacion;
    }

    public Integer getA047codigo() {
        return a047codigo;
    }

    public void setA047codigo(Integer a047codigo) {
        this.a047codigo = a047codigo;
    }

    public String getA047nombre() {
        return a047nombre;
    }

    public void setA047nombre(String a047nombre) {
        this.a047nombre = a047nombre;
    }

    public Character getA047estadoregistro() {
        return a047estadoregistro;
    }

    public void setA047estadoregistro(Character a047estadoregistro) {
        this.a047estadoregistro = a047estadoregistro;
    }

    public Date getA047fechacreacion() {
        return a047fechacreacion;
    }

    public void setA047fechacreacion(Date a047fechacreacion) {
        this.a047fechacreacion = a047fechacreacion;
    }

    public Date getA047fechamodificacion() {
        return a047fechamodificacion;
    }

    public void setA047fechamodificacion(Date a047fechamodificacion) {
        this.a047fechamodificacion = a047fechamodificacion;
    }

    public int getA047usuariocreacion() {
        return a047usuariocreacion;
    }

    public void setA047usuariocreacion(int a047usuariocreacion) {
        this.a047usuariocreacion = a047usuariocreacion;
    }

    public Integer getA047usuariomodificacion() {
        return a047usuariomodificacion;
    }

    public void setA047usuariomodificacion(Integer a047usuariomodificacion) {
        this.a047usuariomodificacion = a047usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<DesagregaCatgIpcc> getDesagregaCatgIpccList() {
//        return desagregaCatgIpccList;
//    }
//
//    public void setDesagregaCatgIpccList(List<DesagregaCatgIpcc> desagregaCatgIpccList) {
//        this.desagregaCatgIpccList = desagregaCatgIpccList;
//    }

    public CategoriaIpcc getA047idcatipcc() {
        return a047idcatipcc;
    }

    public void setA047idcatipcc(CategoriaIpcc a047idcatipcc) {
        this.a047idcatipcc = a047idcatipcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a047codigo != null ? a047codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcategoriaIpcc)) {
            return false;
        }
        SubcategoriaIpcc other = (SubcategoriaIpcc) object;
        if ((this.a047codigo == null && other.a047codigo != null) || (this.a047codigo != null && !this.a047codigo.equals(other.a047codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.SubcategoriaIpcc[ a047codigo=" + a047codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<DesagregaCatgIpcc> getDesagregaCatgIpccCollection() {
        return desagregaCatgIpccCollection;
    }

    public void setDesagregaCatgIpccCollection(Collection<DesagregaCatgIpcc> desagregaCatgIpccCollection) {
        this.desagregaCatgIpccCollection = desagregaCatgIpccCollection;
    }
    
}
