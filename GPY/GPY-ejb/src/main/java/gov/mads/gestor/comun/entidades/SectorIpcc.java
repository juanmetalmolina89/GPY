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
@Table(name = "GPYT_T045_SECTOR_IPCC", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectorIpcc.findAll", query = "SELECT s FROM SectorIpcc s")})
public class SectorIpcc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A045CODIGO")
    private Integer a045codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A045NOMBRE")
    private String a045nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A045ESTADOREGISTRO")
    private Character a045estadoregistro;
    @Column(name = "A045FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a045fechacreacion;
    @Column(name = "A045FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a045fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A045USUARIOCREACION")
    private int a045usuariocreacion;
    @Column(name = "A045USUARIOMODIFICACION")
    private Integer a045usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a046idsector")
//    private List<CategoriaIpcc> categoriaIpccList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a005idsectoripcc")
//    private List<Actividad> actividadList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a043idsectoripcc")
//    private List<SubgrupoIpcc> subgrupoIpccList;

    public SectorIpcc() {
    }

    public SectorIpcc(Integer a045codigo) {
        this.a045codigo = a045codigo;
    }

    public SectorIpcc(Integer a045codigo, String a045nombre, Character a045estadoregistro, int a045usuariocreacion) {
        this.a045codigo = a045codigo;
        this.a045nombre = a045nombre;
        this.a045estadoregistro = a045estadoregistro;
        this.a045usuariocreacion = a045usuariocreacion;
    }

    public Integer getA045codigo() {
        return a045codigo;
    }

    public void setA045codigo(Integer a045codigo) {
        this.a045codigo = a045codigo;
    }

    public String getA045nombre() {
        return a045nombre;
    }

    public void setA045nombre(String a045nombre) {
        this.a045nombre = a045nombre;
    }

    public Character getA045estadoregistro() {
        return a045estadoregistro;
    }

    public void setA045estadoregistro(Character a045estadoregistro) {
        this.a045estadoregistro = a045estadoregistro;
    }

    public Date getA045fechacreacion() {
        return a045fechacreacion;
    }

    public void setA045fechacreacion(Date a045fechacreacion) {
        this.a045fechacreacion = a045fechacreacion;
    }

    public Date getA045fechamodificacion() {
        return a045fechamodificacion;
    }

    public void setA045fechamodificacion(Date a045fechamodificacion) {
        this.a045fechamodificacion = a045fechamodificacion;
    }

    public int getA045usuariocreacion() {
        return a045usuariocreacion;
    }

    public void setA045usuariocreacion(int a045usuariocreacion) {
        this.a045usuariocreacion = a045usuariocreacion;
    }

    public Integer getA045usuariomodificacion() {
        return a045usuariomodificacion;
    }

    public void setA045usuariomodificacion(Integer a045usuariomodificacion) {
        this.a045usuariomodificacion = a045usuariomodificacion;
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
//
//    @XmlTransient
//    @JsonIgnore
//    public List<Actividad> getActividadList() {
//        return actividadList;
//    }
//
//    public void setActividadList(List<Actividad> actividadList) {
//        this.actividadList = actividadList;
//    }

//    @XmlTransient
//    @JsonIgnore
//    public List<SubgrupoIpcc> getSubgrupoIpccList() {
//        return subgrupoIpccList;
//    }
//
//    public void setSubgrupoIpccList(List<SubgrupoIpcc> subgrupoIpccList) {
//        this.subgrupoIpccList = subgrupoIpccList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a045codigo != null ? a045codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorIpcc)) {
            return false;
        }
        SectorIpcc other = (SectorIpcc) object;
        if ((this.a045codigo == null && other.a045codigo != null) || (this.a045codigo != null && !this.a045codigo.equals(other.a045codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.SectorIpcc[ a045codigo=" + a045codigo + " ]";
    }
    
}
