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
@Table(name = "GPYT_T046_CATEGORIA_IPCC", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaIpcc.findAll", query = "SELECT c FROM CategoriaIpcc c")})
public class CategoriaIpcc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A046CODIGO")
    private Integer a046codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A046NOMBRE")
    private String a046nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A046ESTADOREGISTRO")
    private Character a046estadoregistro;
    @Column(name = "A046FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a046fechacreacion;
    @Column(name = "A046FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a046fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A046USUARIOCREACION")
    private int a046usuariocreacion;
    @Column(name = "A046USUARIOMODIFICACION")
    private Integer a046usuariomodificacion;
    @JoinColumn(name = "A046IDSECTOR", referencedColumnName = "A045CODIGO")
    @ManyToOne(optional = false)
    private SectorIpcc a046idsector;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a047idcatipcc")
//    private List<SubcategoriaIpcc> subcategoriaIpccList;
    @JoinColumn(name = "A046IDSUBGRUPOIPCC", referencedColumnName = "A043CODIGO")
    @ManyToOne(optional = false)
    private SubgrupoIpcc a046idsubgrupoipcc;
    @JoinColumn(name = "A046IDTIPOPROYECTOMDL", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a046idtipoproyectomdl;

    public CategoriaIpcc() {
    }

    public CategoriaIpcc(Integer a046codigo) {
        this.a046codigo = a046codigo;
    }

    public CategoriaIpcc(Integer a046codigo, String a046nombre, Character a046estadoregistro, int a046usuariocreacion) {
        this.a046codigo = a046codigo;
        this.a046nombre = a046nombre;
        this.a046estadoregistro = a046estadoregistro;
        this.a046usuariocreacion = a046usuariocreacion;
    }

    public Integer getA046codigo() {
        return a046codigo;
    }

    public void setA046codigo(Integer a046codigo) {
        this.a046codigo = a046codigo;
    }

    public String getA046nombre() {
        return a046nombre;
    }

    public void setA046nombre(String a046nombre) {
        this.a046nombre = a046nombre;
    }

    public Character getA046estadoregistro() {
        return a046estadoregistro;
    }

    public void setA046estadoregistro(Character a046estadoregistro) {
        this.a046estadoregistro = a046estadoregistro;
    }

    public Date getA046fechacreacion() {
        return a046fechacreacion;
    }

    public void setA046fechacreacion(Date a046fechacreacion) {
        this.a046fechacreacion = a046fechacreacion;
    }

    public Date getA046fechamodificacion() {
        return a046fechamodificacion;
    }

    public void setA046fechamodificacion(Date a046fechamodificacion) {
        this.a046fechamodificacion = a046fechamodificacion;
    }

    public int getA046usuariocreacion() {
        return a046usuariocreacion;
    }

    public void setA046usuariocreacion(int a046usuariocreacion) {
        this.a046usuariocreacion = a046usuariocreacion;
    }

    public Integer getA046usuariomodificacion() {
        return a046usuariomodificacion;
    }

    public void setA046usuariomodificacion(Integer a046usuariomodificacion) {
        this.a046usuariomodificacion = a046usuariomodificacion;
    }

    public SectorIpcc getA046idsector() {
        return a046idsector;
    }

    public void setA046idsector(SectorIpcc a046idsector) {
        this.a046idsector = a046idsector;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<SubcategoriaIpcc> getSubcategoriaIpccList() {
//        return subcategoriaIpccList;
//    }
//
//    public void setSubcategoriaIpccList(List<SubcategoriaIpcc> subcategoriaIpccList) {
//        this.subcategoriaIpccList = subcategoriaIpccList;
//    }

    public SubgrupoIpcc getA046idsubgrupoipcc() {
        return a046idsubgrupoipcc;
    }

    public void setA046idsubgrupoipcc(SubgrupoIpcc a046idsubgrupoipcc) {
        this.a046idsubgrupoipcc = a046idsubgrupoipcc;
    }

    public Lista getA046idtipoproyectomdl() {
        return a046idtipoproyectomdl;
    }

    public void setA046idtipoproyectomdl(Lista a046idtipoproyectomdl) {
        this.a046idtipoproyectomdl = a046idtipoproyectomdl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a046codigo != null ? a046codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaIpcc)) {
            return false;
        }
        CategoriaIpcc other = (CategoriaIpcc) object;
        if ((this.a046codigo == null && other.a046codigo != null) || (this.a046codigo != null && !this.a046codigo.equals(other.a046codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.CategoriaIpcc[ a046codigo=" + a046codigo + " ]";
    }
    
}
