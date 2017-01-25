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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T013_AVANCE_PROYECTO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvanceProyecto.findAll", query = "SELECT a FROM AvanceProyecto a")})
public class AvanceProyecto implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a014idavncproyct")
    private Collection<InstrmFinanAnio> instrmFinanAnioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A013CODIGO")
    private Integer a013codigo;
    @Column(name = "A013FECHREPRT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a013fechreprt;
    @Size(max = 300)
    @Column(name = "A013CAMBSIGNFCTV")
    private String a013cambsignfctv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "A013COSTTONLD")
    private BigDecimal a013costtonld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "A013FINANCCN")
    private String a013financcn;
    @Column(name = "A013FECHAVNCPROYCT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a013fechavncproyct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A013ESTADOREGISTRO")
    private Character a013estadoregistro;
    @Column(name = "A013FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a013fechacreacion;
    @Column(name = "A013FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a013fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A013USUARIOCREACION")
    private int a013usuariocreacion;
    @Column(name = "A013USUARIOMODIFICACION")
    private Integer a013usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a014idavncproyct")
//    private List<InstrmFinanAnio> instrmFinanAnioList;
    @JoinColumn(name = "A013IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a013idproyecto;

    public AvanceProyecto() {
    }

    public AvanceProyecto(Integer a013codigo) {
        this.a013codigo = a013codigo;
    }

    public AvanceProyecto(Integer a013codigo, String a013financcn, Character a013estadoregistro, int a013usuariocreacion) {
        this.a013codigo = a013codigo;
        this.a013financcn = a013financcn;
        this.a013estadoregistro = a013estadoregistro;
        this.a013usuariocreacion = a013usuariocreacion;
    }

    public Integer getA013codigo() {
        return a013codigo;
    }

    public void setA013codigo(Integer a013codigo) {
        this.a013codigo = a013codigo;
    }

    public Date getA013fechreprt() {
        return a013fechreprt;
    }

    public void setA013fechreprt(Date a013fechreprt) {
        this.a013fechreprt = a013fechreprt;
    }

    public String getA013cambsignfctv() {
        return a013cambsignfctv;
    }

    public void setA013cambsignfctv(String a013cambsignfctv) {
        this.a013cambsignfctv = a013cambsignfctv;
    }

    public BigDecimal getA013costtonld() {
        return a013costtonld;
    }

    public void setA013costtonld(BigDecimal a013costtonld) {
        this.a013costtonld = a013costtonld;
    }

    public String getA013financcn() {
        return a013financcn;
    }

    public void setA013financcn(String a013financcn) {
        this.a013financcn = a013financcn;
    }

    public Date getA013fechavncproyct() {
        return a013fechavncproyct;
    }

    public void setA013fechavncproyct(Date a013fechavncproyct) {
        this.a013fechavncproyct = a013fechavncproyct;
    }

    public Character getA013estadoregistro() {
        return a013estadoregistro;
    }

    public void setA013estadoregistro(Character a013estadoregistro) {
        this.a013estadoregistro = a013estadoregistro;
    }

    public Date getA013fechacreacion() {
        return a013fechacreacion;
    }

    public void setA013fechacreacion(Date a013fechacreacion) {
        this.a013fechacreacion = a013fechacreacion;
    }

    public Date getA013fechamodificacion() {
        return a013fechamodificacion;
    }

    public void setA013fechamodificacion(Date a013fechamodificacion) {
        this.a013fechamodificacion = a013fechamodificacion;
    }

    public int getA013usuariocreacion() {
        return a013usuariocreacion;
    }

    public void setA013usuariocreacion(int a013usuariocreacion) {
        this.a013usuariocreacion = a013usuariocreacion;
    }

    public Integer getA013usuariomodificacion() {
        return a013usuariomodificacion;
    }

    public void setA013usuariomodificacion(Integer a013usuariomodificacion) {
        this.a013usuariomodificacion = a013usuariomodificacion;
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

    public Proyecto getA013idproyecto() {
        return a013idproyecto;
    }

    public void setA013idproyecto(Proyecto a013idproyecto) {
        this.a013idproyecto = a013idproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a013codigo != null ? a013codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvanceProyecto)) {
            return false;
        }
        AvanceProyecto other = (AvanceProyecto) object;
        if ((this.a013codigo == null && other.a013codigo != null) || (this.a013codigo != null && !this.a013codigo.equals(other.a013codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.AvanceProyecto[ a013codigo=" + a013codigo + " ]";
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
