/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T009_INSTRMNT_FINNCCN", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstrmntFinnccn.findAll", query = "SELECT i FROM InstrmntFinnccn i")})
public class InstrmntFinnccn implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a014idinstrmntfinanccn")
    private Collection<InstrmFinanAnio> instrmFinanAnioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A009CODIGO")
    private Integer a009codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "A009PORFINNCCNESTMD")
    private BigDecimal a009porfinnccnestmd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A009ESTADOREGISTRO")
    private Character a009estadoregistro;
    @Column(name = "A009FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a009fechacreacion;
    @Column(name = "A009FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a009fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A009USUARIOCREACION")
    private int a009usuariocreacion;
    @Column(name = "A009USUARIOMODIFICACION")
    private Integer a009usuariomodificacion;
    @JoinColumn(name = "A009IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a009idproyecto;
    @JoinColumn(name = "A009IDTIPINSTRMNTF", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a009idtipinstrmntf;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a014idinstrmntfinanccn")
//    private List<InstrmFinanAnio> instrmFinanAnioList;

    public InstrmntFinnccn() {
    }

    public InstrmntFinnccn(Integer a009codigo) {
        this.a009codigo = a009codigo;
    }

    public InstrmntFinnccn(Integer a009codigo, BigDecimal a009porfinnccnestmd, Character a009estadoregistro, int a009usuariocreacion) {
        this.a009codigo = a009codigo;
        this.a009porfinnccnestmd = a009porfinnccnestmd;
        this.a009estadoregistro = a009estadoregistro;
        this.a009usuariocreacion = a009usuariocreacion;
    }

    public Integer getA009codigo() {
        return a009codigo;
    }

    public void setA009codigo(Integer a009codigo) {
        this.a009codigo = a009codigo;
    }

    public BigDecimal getA009porfinnccnestmd() {
        return a009porfinnccnestmd;
    }

    public void setA009porfinnccnestmd(BigDecimal a009porfinnccnestmd) {
        this.a009porfinnccnestmd = a009porfinnccnestmd;
    }

    public Character getA009estadoregistro() {
        return a009estadoregistro;
    }

    public void setA009estadoregistro(Character a009estadoregistro) {
        this.a009estadoregistro = a009estadoregistro;
    }

    public Date getA009fechacreacion() {
        return a009fechacreacion;
    }

    public void setA009fechacreacion(Date a009fechacreacion) {
        this.a009fechacreacion = a009fechacreacion;
    }

    public Date getA009fechamodificacion() {
        return a009fechamodificacion;
    }

    public void setA009fechamodificacion(Date a009fechamodificacion) {
        this.a009fechamodificacion = a009fechamodificacion;
    }

    public int getA009usuariocreacion() {
        return a009usuariocreacion;
    }

    public void setA009usuariocreacion(int a009usuariocreacion) {
        this.a009usuariocreacion = a009usuariocreacion;
    }

    public Integer getA009usuariomodificacion() {
        return a009usuariomodificacion;
    }

    public void setA009usuariomodificacion(Integer a009usuariomodificacion) {
        this.a009usuariomodificacion = a009usuariomodificacion;
    }

    public Proyecto getA009idproyecto() {
        return a009idproyecto;
    }

    public void setA009idproyecto(Proyecto a009idproyecto) {
        this.a009idproyecto = a009idproyecto;
    }

    public Lista getA009idtipinstrmntf() {
        return a009idtipinstrmntf;
    }

    public void setA009idtipinstrmntf(Lista a009idtipinstrmntf) {
        this.a009idtipinstrmntf = a009idtipinstrmntf;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<InstrmFinanAnio> getInstrmFinanAnioList() {
//        return instrmFinanAnioList;
//    }
//
//    public void setInstrmFinanAnioList(List<InstrmFinanAnio> instrmFinanAnioList) {
//        this.instrmFinanAnioList = instrmFinanAnioList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a009codigo != null ? a009codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstrmntFinnccn)) {
            return false;
        }
        InstrmntFinnccn other = (InstrmntFinnccn) object;
        if ((this.a009codigo == null && other.a009codigo != null) || (this.a009codigo != null && !this.a009codigo.equals(other.a009codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.InstrmntFinnccn[ a009codigo=" + a009codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<InstrmFinanAnio> getInstrmFinanAnioCollection() {
        return instrmFinanAnioCollection;
    }

    public void setInstrmFinanAnioCollection(Collection<InstrmFinanAnio> instrmFinanAnioCollection) {
        this.instrmFinanAnioCollection = instrmFinanAnioCollection;
    }
    
}
