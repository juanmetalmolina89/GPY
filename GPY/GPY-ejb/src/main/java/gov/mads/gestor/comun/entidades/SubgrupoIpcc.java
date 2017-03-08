/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
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
@Table(name = "GPYT_T043_SUBGRUPO_IPCC", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubgrupoIpcc.findAll", query = "SELECT s FROM SubgrupoIpcc s"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043codigo", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043codigo = :a043codigo"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043nombre", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043nombre = :a043nombre"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043estadoregistro", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043estadoregistro = :a043estadoregistro"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043fechacreacion", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043fechacreacion = :a043fechacreacion"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043fechamodificacion", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043fechamodificacion = :a043fechamodificacion"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043usuariocreacion", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043usuariocreacion = :a043usuariocreacion"),
    @NamedQuery(name = "SubgrupoIpcc.findByA043usuariomodificacion", query = "SELECT s FROM SubgrupoIpcc s WHERE s.a043usuariomodificacion = :a043usuariomodificacion")})
public class SubgrupoIpcc implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a046idsubgrupoipcc")
    private List<CategoriaIpcc> categoriaIpccList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A043CODIGO")
    private Integer a043codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "A043NOMBRE")
    private String a043nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A043ESTADOREGISTRO")
    private Character a043estadoregistro;
    @Column(name = "A043FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a043fechacreacion;
    @Column(name = "A043FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a043fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A043USUARIOCREACION")
    private int a043usuariocreacion;
    @Column(name = "A043USUARIOMODIFICACION")
    private Integer a043usuariomodificacion;
    @JoinColumn(name = "A043IDSECTORIPCC", referencedColumnName = "A045CODIGO")
    @ManyToOne(optional = false)
    private SectorIpcc a043idsectoripcc;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a046idsubgrupoipcc")
//    private List<CategoriaIpcc> categoriaIpccList;

    public SubgrupoIpcc() {
    }

    public SubgrupoIpcc(Integer a043codigo) {
        this.a043codigo = a043codigo;
    }

    public SubgrupoIpcc(Integer a043codigo, String a043nombre, Character a043estadoregistro, int a043usuariocreacion) {
        this.a043codigo = a043codigo;
        this.a043nombre = a043nombre;
        this.a043estadoregistro = a043estadoregistro;
        this.a043usuariocreacion = a043usuariocreacion;
    }

    public Integer getA043codigo() {
        return a043codigo;
    }

    public void setA043codigo(Integer a043codigo) {
        this.a043codigo = a043codigo;
    }

    public String getA043nombre() {
        return a043nombre;
    }

    public void setA043nombre(String a043nombre) {
        this.a043nombre = a043nombre;
    }

    public Character getA043estadoregistro() {
        return a043estadoregistro;
    }

    public void setA043estadoregistro(Character a043estadoregistro) {
        this.a043estadoregistro = a043estadoregistro;
    }

    public Date getA043fechacreacion() {
        return a043fechacreacion;
    }

    public void setA043fechacreacion(Date a043fechacreacion) {
        this.a043fechacreacion = a043fechacreacion;
    }

    public Date getA043fechamodificacion() {
        return a043fechamodificacion;
    }

    public void setA043fechamodificacion(Date a043fechamodificacion) {
        this.a043fechamodificacion = a043fechamodificacion;
    }

    public int getA043usuariocreacion() {
        return a043usuariocreacion;
    }

    public void setA043usuariocreacion(int a043usuariocreacion) {
        this.a043usuariocreacion = a043usuariocreacion;
    }

    public Integer getA043usuariomodificacion() {
        return a043usuariomodificacion;
    }

    public void setA043usuariomodificacion(Integer a043usuariomodificacion) {
        this.a043usuariomodificacion = a043usuariomodificacion;
    }

    public SectorIpcc getA043idsectoripcc() {
        return a043idsectoripcc;
    }

    public void setA043idsectoripcc(SectorIpcc a043idsectoripcc) {
        this.a043idsectoripcc = a043idsectoripcc;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<CategoriaIpcc> getCategoriaIpccList() {
//        return categoriaIpccList;
//    }
//
//    public void setCategoriaIpccList(List<CategoriaIpcc> categoriaIpccList) {
//        this.categoriaIpccList = categoriaIpccList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a043codigo != null ? a043codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubgrupoIpcc)) {
            return false;
        }
        SubgrupoIpcc other = (SubgrupoIpcc) object;
        if ((this.a043codigo == null && other.a043codigo != null) || (this.a043codigo != null && !this.a043codigo.equals(other.a043codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.SubgrupoIpcc[ a043codigo=" + a043codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<CategoriaIpcc> getCategoriaIpccList() {
        return categoriaIpccList;
    }

    public void setCategoriaIpccList(List<CategoriaIpcc> categoriaIpccList) {
        this.categoriaIpccList = categoriaIpccList;
    }
    
}
