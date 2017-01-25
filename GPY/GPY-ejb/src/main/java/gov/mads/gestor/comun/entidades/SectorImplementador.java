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
@Table(name = "GPYT_T023_SECTOR_IMPLEMENTADOR", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectorImplementador.findAll", query = "SELECT s FROM SectorImplementador s")})
public class SectorImplementador implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a028idsectrimplmntdr")
    private Collection<MetodologiaMdl> metodologiaMdlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a006idsectrimplmntdr")
    private Collection<ProySectrImplmntdr> proySectrImplmntdrCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A023CODIGO")
    private Integer a023codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A023DESCSECTRIMPLMNTDR")
    private String a023descsectrimplmntdr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A023ESTADOREGISTRO")
    private Character a023estadoregistro;
    @Column(name = "A023FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a023fechacreacion;
    @Column(name = "A023FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a023fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A023USUARIOCREACION")
    private int a023usuariocreacion;
    @Column(name = "A023USUARIOMODIFICACION")
    private Integer a023usuariomodificacion;
    @JoinColumn(name = "A023IDTIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a023idtipproyct;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a028idsectrimplmntdr")
//    private List<MetodologiaMdl> metodologiaMdlList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a006idsectrimplmntdr")
//    private List<ProySectrImplmntdr> proySectrImplmntdrList;

    public SectorImplementador() {
    }

    public SectorImplementador(Integer a023codigo) {
        this.a023codigo = a023codigo;
    }

    public SectorImplementador(Integer a023codigo, String a023descsectrimplmntdr, Character a023estadoregistro, int a023usuariocreacion) {
        this.a023codigo = a023codigo;
        this.a023descsectrimplmntdr = a023descsectrimplmntdr;
        this.a023estadoregistro = a023estadoregistro;
        this.a023usuariocreacion = a023usuariocreacion;
    }

    public Integer getA023codigo() {
        return a023codigo;
    }

    public void setA023codigo(Integer a023codigo) {
        this.a023codigo = a023codigo;
    }

    public String getA023descsectrimplmntdr() {
        return a023descsectrimplmntdr;
    }

    public void setA023descsectrimplmntdr(String a023descsectrimplmntdr) {
        this.a023descsectrimplmntdr = a023descsectrimplmntdr;
    }

    public Character getA023estadoregistro() {
        return a023estadoregistro;
    }

    public void setA023estadoregistro(Character a023estadoregistro) {
        this.a023estadoregistro = a023estadoregistro;
    }

    public Date getA023fechacreacion() {
        return a023fechacreacion;
    }

    public void setA023fechacreacion(Date a023fechacreacion) {
        this.a023fechacreacion = a023fechacreacion;
    }

    public Date getA023fechamodificacion() {
        return a023fechamodificacion;
    }

    public void setA023fechamodificacion(Date a023fechamodificacion) {
        this.a023fechamodificacion = a023fechamodificacion;
    }

    public int getA023usuariocreacion() {
        return a023usuariocreacion;
    }

    public void setA023usuariocreacion(int a023usuariocreacion) {
        this.a023usuariocreacion = a023usuariocreacion;
    }

    public Integer getA023usuariomodificacion() {
        return a023usuariomodificacion;
    }

    public void setA023usuariomodificacion(Integer a023usuariomodificacion) {
        this.a023usuariomodificacion = a023usuariomodificacion;
    }

    public Lista getA023idtipproyct() {
        return a023idtipproyct;
    }

    public void setA023idtipproyct(Lista a023idtipproyct) {
        this.a023idtipproyct = a023idtipproyct;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<MetodologiaMdl> getMetodologiaMdlList() {
//        return metodologiaMdlList;
//    }
//
//    public void setMetodologiaMdlList(List<MetodologiaMdl> metodologiaMdlList) {
//        this.metodologiaMdlList = metodologiaMdlList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<ProySectrImplmntdr> getProySectrImplmntdrList() {
//        return proySectrImplmntdrList;
//    }
//
//    public void setProySectrImplmntdrList(List<ProySectrImplmntdr> proySectrImplmntdrList) {
//        this.proySectrImplmntdrList = proySectrImplmntdrList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a023codigo != null ? a023codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorImplementador)) {
            return false;
        }
        SectorImplementador other = (SectorImplementador) object;
        if ((this.a023codigo == null && other.a023codigo != null) || (this.a023codigo != null && !this.a023codigo.equals(other.a023codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.SectorImplementador[ a023codigo=" + a023codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MetodologiaMdl> getMetodologiaMdlCollection() {
        return metodologiaMdlCollection;
    }

    public void setMetodologiaMdlCollection(Collection<MetodologiaMdl> metodologiaMdlCollection) {
        this.metodologiaMdlCollection = metodologiaMdlCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProySectrImplmntdr> getProySectrImplmntdrCollection() {
        return proySectrImplmntdrCollection;
    }

    public void setProySectrImplmntdrCollection(Collection<ProySectrImplmntdr> proySectrImplmntdrCollection) {
        this.proySectrImplmntdrCollection = proySectrImplmntdrCollection;
    }
    
}
