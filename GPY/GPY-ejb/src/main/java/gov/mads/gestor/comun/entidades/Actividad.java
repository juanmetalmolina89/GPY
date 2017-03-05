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
@Table(name = "GPYT_T005_ACTIVIDAD", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")})
public class Actividad implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A005CODIGO")
    private Integer a005codigo;
    @Size(max = 300)
    @Column(name = "A005DESCRPCNACTVDD")
    private String a005descrpcnactvdd;
    @Size(max = 300)
    @Column(name = "A005UBCCNGEGRFC")
    private String a005ubccngegrfc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "A005COSTOTOTAL")
    private BigDecimal a005costototal;
    @Column(name = "A005CONTRBCNPROP")
    private BigDecimal a005contrbcnprop;
    @Column(name = "A005CONTRBCNEXTRN")
    private BigDecimal a005contrbcnextrn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A005ESTADOREGISTRO")
    private Character a005estadoregistro;
    @Column(name = "A005FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a005fechacreacion;
    @Column(name = "A005FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a005fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A005USUARIOCREACION")
    private int a005usuariocreacion;
    @Column(name = "A005USUARIOMODIFICACION")
    private Integer a005usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a011idactvdd")
//    private List<Indicador> indicadorList;
    @JoinColumn(name = "A005IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a005idproyecto;
    @JoinColumn(name = "A005IDTIPACTVDD", referencedColumnName = "A022CODIGO")
    @ManyToOne(optional = false)
    private TipoActividad a005idtipactvdd;
    @JoinColumn(name = "A005IDSOPORTE", referencedColumnName = "A026CODIGO")
    @ManyToOne(optional = false)
    private Archivo a005idsoporte;
    @JoinColumn(name = "A005IDSECTORIPCC", referencedColumnName = "A045CODIGO")
    @ManyToOne(optional = false)
    private SectorIpcc a005idsectoripcc;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a042idactvdd")
//    private List<ActividadGeometria> actividadGeometriaList;
    @JoinColumn(name = "A005IDSOPORTECALCULO", referencedColumnName = "A026CODIGO")
    private Archivo a005idsoportecalculo;
    
    @JoinColumn(name = "A005IDMTDCALCREDUCCBASELINE", referencedColumnName = "A026CODIGO")
    private Lista a005idmtdcalcreduccbaseline;
    
    @JoinColumn(name = "A005IDTIPACTVDREDUC", referencedColumnName = "A058CODIGO")
    @ManyToOne
    private TipoActivReduccion a005idtipactvdreduc;

    @Column(name = "A005FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a005fechainicio;
    @Column(name = "A005FECHAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a005fechafinal;
    

    public Actividad() {
    }

    public Actividad(Integer a005codigo) {
        this.a005codigo = a005codigo;
    }

    public Actividad(Integer a005codigo, Character a005estadoregistro, int a005usuariocreacion) {
        this.a005codigo = a005codigo;
        this.a005estadoregistro = a005estadoregistro;
        this.a005usuariocreacion = a005usuariocreacion;
    }

    public Integer getA005codigo() {
        return a005codigo;
    }

    public void setA005codigo(Integer a005codigo) {
        this.a005codigo = a005codigo;
    }

    public String getA005descrpcnactvdd() {
        return a005descrpcnactvdd;
    }

    public void setA005descrpcnactvdd(String a005descrpcnactvdd) {
        this.a005descrpcnactvdd = a005descrpcnactvdd;
    }

    public String getA005ubccngegrfc() {
        return a005ubccngegrfc;
    }

    public void setA005ubccngegrfc(String a005ubccngegrfc) {
        this.a005ubccngegrfc = a005ubccngegrfc;
    }

    public BigDecimal getA005costototal() {
        return a005costototal;
    }

    public void setA005costototal(BigDecimal a005costototal) {
        this.a005costototal = a005costototal;
    }

    public BigDecimal getA005contrbcnprop() {
        return a005contrbcnprop;
    }

    public void setA005contrbcnprop(BigDecimal a005contrbcnprop) {
        this.a005contrbcnprop = a005contrbcnprop;
    }

    public BigDecimal getA005contrbcnextrn() {
        return a005contrbcnextrn;
    }

    public void setA005contrbcnextrn(BigDecimal a005contrbcnextrn) {
        this.a005contrbcnextrn = a005contrbcnextrn;
    }

    public Character getA005estadoregistro() {
        return a005estadoregistro;
    }

    public void setA005estadoregistro(Character a005estadoregistro) {
        this.a005estadoregistro = a005estadoregistro;
    }

    public Date getA005fechacreacion() {
        return a005fechacreacion;
    }

    public void setA005fechacreacion(Date a005fechacreacion) {
        this.a005fechacreacion = a005fechacreacion;
    }

    public Date getA005fechamodificacion() {
        return a005fechamodificacion;
    }

    public void setA005fechamodificacion(Date a005fechamodificacion) {
        this.a005fechamodificacion = a005fechamodificacion;
    }

    public int getA005usuariocreacion() {
        return a005usuariocreacion;
    }

    public void setA005usuariocreacion(int a005usuariocreacion) {
        this.a005usuariocreacion = a005usuariocreacion;
    }

    public Integer getA005usuariomodificacion() {
        return a005usuariomodificacion;
    }

    public void setA005usuariomodificacion(Integer a005usuariomodificacion) {
        this.a005usuariomodificacion = a005usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Indicador> getIndicadorList() {
//        return indicadorList;
//    }
//
//    public void setIndicadorList(List<Indicador> indicadorList) {
//        this.indicadorList = indicadorList;
//    }

    public Proyecto getA005idproyecto() {
        return a005idproyecto;
    }

    public void setA005idproyecto(Proyecto a005idproyecto) {
        this.a005idproyecto = a005idproyecto;
    }

    public TipoActividad getA005idtipactvdd() {
        return a005idtipactvdd;
    }

    public void setA005idtipactvdd(TipoActividad a005idtipactvdd) {
        this.a005idtipactvdd = a005idtipactvdd;
    }

    public Archivo getA005idsoporte() {
        return a005idsoporte;
    }

    public void setA005idsoporte(Archivo a005idsoporte) {
        this.a005idsoporte = a005idsoporte;
    }

    public SectorIpcc getA005idsectoripcc() {
        return a005idsectoripcc;
    }

    public void setA005idsectoripcc(SectorIpcc a005idsectoripcc) {
        this.a005idsectoripcc = a005idsectoripcc;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<ActividadGeometria> getActividadGeometriaList() {
//        return actividadGeometriaList;
//    }
//
//    public void setActividadGeometriaList(List<ActividadGeometria> actividadGeometriaList) {
//        this.actividadGeometriaList = actividadGeometriaList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a005codigo != null ? a005codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.a005codigo == null && other.a005codigo != null) || (this.a005codigo != null && !this.a005codigo.equals(other.a005codigo))) {
            return false;
        }
        return true;
    }

    public Date getA005fechainicio() {
        return a005fechainicio;
    }

    public void setA005fechainicio(Date a005fechainicio) {
        this.a005fechainicio = a005fechainicio;
    }

    public Date getA005fechafinal() {
        return a005fechafinal;
    }

    public void setA005fechafinal(Date a005fechafinal) {
        this.a005fechafinal = a005fechafinal;
    }

    public TipoActivReduccion getA005idtipactvdreduc() {
        return a005idtipactvdreduc;
    }

    public void setA005idtipactvdreduc(TipoActivReduccion a005idtipactvdreduc) {
        this.a005idtipactvdreduc = a005idtipactvdreduc;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Actividad[ a005codigo=" + a005codigo + " ]";
    }

    public Archivo getA005idsoportecalculo() {
        return a005idsoportecalculo;
    }

    public void setA005idsoportecalculo(Archivo a005idsoportecalculo) {
        this.a005idsoportecalculo = a005idsoportecalculo;
    }

    public Lista getA005idmtdcalcreduccbaseline() {
        return a005idmtdcalcreduccbaseline;
    }

    public void setA005idmtdcalcreduccbaseline(Lista a005idmtdcalcreduccbaseline) {
        this.a005idmtdcalcreduccbaseline = a005idmtdcalcreduccbaseline;
    }
    
}
