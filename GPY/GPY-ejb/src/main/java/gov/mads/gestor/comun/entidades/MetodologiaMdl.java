/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "GPYT_T028_METODOLOGIA_MDL", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetodologiaMdl.findAll", query = "SELECT m FROM MetodologiaMdl m")})
public class MetodologiaMdl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A028CODIGO")
    private Integer a028codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A028DESCMETDLGMDL")
    private String a028descmetdlgmdl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A028ESTADOREGISTRO")
    private Character a028estadoregistro;
    @Column(name = "A028FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a028fechacreacion;
    @Column(name = "A028FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a028fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A028USUARIOCREACION")
    private int a028usuariocreacion;
    @Column(name = "A028USUARIOMODIFICACION")
    private Integer a028usuariomodificacion;
    @JoinColumn(name = "A028IDSECTRIMPLMNTDR", referencedColumnName = "A023CODIGO")
    @ManyToOne(optional = false)
    private SectorImplementador a028idsectrimplmntdr;
    @JoinColumn(name = "A028IDESCL", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a028idescl;
//    @OneToMany(mappedBy = "a002idmetdlgmdl")
//    private List<Proyecto> proyectoList;
    @JoinColumn(name = "A028IDSECTORALSCOPE", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a028idsectoralscope;

    public MetodologiaMdl() {
    }

    public MetodologiaMdl(Integer a028codigo) {
        this.a028codigo = a028codigo;
    }

    public MetodologiaMdl(Integer a028codigo, String a028descmetdlgmdl, Character a028estadoregistro, int a028usuariocreacion) {
        this.a028codigo = a028codigo;
        this.a028descmetdlgmdl = a028descmetdlgmdl;
        this.a028estadoregistro = a028estadoregistro;
        this.a028usuariocreacion = a028usuariocreacion;
    }

    public Integer getA028codigo() {
        return a028codigo;
    }

    public void setA028codigo(Integer a028codigo) {
        this.a028codigo = a028codigo;
    }

    public String getA028descmetdlgmdl() {
        return a028descmetdlgmdl;
    }

    public void setA028descmetdlgmdl(String a028descmetdlgmdl) {
        this.a028descmetdlgmdl = a028descmetdlgmdl;
    }

    public Character getA028estadoregistro() {
        return a028estadoregistro;
    }

    public void setA028estadoregistro(Character a028estadoregistro) {
        this.a028estadoregistro = a028estadoregistro;
    }

    public Date getA028fechacreacion() {
        return a028fechacreacion;
    }

    public void setA028fechacreacion(Date a028fechacreacion) {
        this.a028fechacreacion = a028fechacreacion;
    }

    public Date getA028fechamodificacion() {
        return a028fechamodificacion;
    }

    public void setA028fechamodificacion(Date a028fechamodificacion) {
        this.a028fechamodificacion = a028fechamodificacion;
    }

    public int getA028usuariocreacion() {
        return a028usuariocreacion;
    }

    public void setA028usuariocreacion(int a028usuariocreacion) {
        this.a028usuariocreacion = a028usuariocreacion;
    }

    public Integer getA028usuariomodificacion() {
        return a028usuariomodificacion;
    }

    public void setA028usuariomodificacion(Integer a028usuariomodificacion) {
        this.a028usuariomodificacion = a028usuariomodificacion;
    }

    public SectorImplementador getA028idsectrimplmntdr() {
        return a028idsectrimplmntdr;
    }

    public void setA028idsectrimplmntdr(SectorImplementador a028idsectrimplmntdr) {
        this.a028idsectrimplmntdr = a028idsectrimplmntdr;
    }

    public Lista getA028idescl() {
        return a028idescl;
    }

    public void setA028idescl(Lista a028idescl) {
        this.a028idescl = a028idescl;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Proyecto> getProyectoList() {
//        return proyectoList;
//    }
//
//    public void setProyectoList(List<Proyecto> proyectoList) {
//        this.proyectoList = proyectoList;
//    }

    public Lista getA028idsectoralscope() {
        return a028idsectoralscope;
    }

    public void setA028idsectoralscope(Lista a028idsectoralscope) {
        this.a028idsectoralscope = a028idsectoralscope;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a028codigo != null ? a028codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodologiaMdl)) {
            return false;
        }
        MetodologiaMdl other = (MetodologiaMdl) object;
        if ((this.a028codigo == null && other.a028codigo != null) || (this.a028codigo != null && !this.a028codigo.equals(other.a028codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.MetodologiaMdl[ a028codigo=" + a028codigo + " ]";
    }
    
}
