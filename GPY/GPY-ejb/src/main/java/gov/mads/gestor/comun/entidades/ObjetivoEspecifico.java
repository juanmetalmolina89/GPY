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
@Table(name = "GPYT_T039_OBJETIVO_ESPECIFICO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjetivoEspecifico.findAll", query = "SELECT o FROM ObjetivoEspecifico o")})
public class ObjetivoEspecifico implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a010idfuente")
    private Collection<ReporteAnioFuente> reporteAnioFuenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a012idfuente")
    private Collection<RepAnioFteIndcdr> repAnioFteIndcdrCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A039CODIGO")
    private Integer a039codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A039DESCOBJTVESPCFC")
    private String a039descobjtvespcfc;
    @Column(name = "A039FECHINC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a039fechinc;
    @Column(name = "A039FECHFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a039fechfin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A039ESTADOREGISTRO")
    private Character a039estadoregistro;
    @Column(name = "A039FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a039fechacreacion;
    @Column(name = "A039FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a039fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A039USUARIOCREACION")
    private int a039usuariocreacion;
    @Column(name = "A039USUARIOMODIFICACION")
    private Integer a039usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a010idfuente")
//    private List<ReporteAnioFuente> reporteAnioFuenteList;
    @JoinColumn(name = "A039IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a039idproyecto;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a012idfuente")
//    private List<RepAnioFteIndcdr> repAnioFteIndcdrList;

    public ObjetivoEspecifico() {
    }

    public ObjetivoEspecifico(Integer a039codigo) {
        this.a039codigo = a039codigo;
    }

    public ObjetivoEspecifico(Integer a039codigo, String a039descobjtvespcfc, Character a039estadoregistro, int a039usuariocreacion) {
        this.a039codigo = a039codigo;
        this.a039descobjtvespcfc = a039descobjtvespcfc;
        this.a039estadoregistro = a039estadoregistro;
        this.a039usuariocreacion = a039usuariocreacion;
    }

    public Integer getA039codigo() {
        return a039codigo;
    }

    public void setA039codigo(Integer a039codigo) {
        this.a039codigo = a039codigo;
    }

    public String getA039descobjtvespcfc() {
        return a039descobjtvespcfc;
    }

    public void setA039descobjtvespcfc(String a039descobjtvespcfc) {
        this.a039descobjtvespcfc = a039descobjtvespcfc;
    }

    public Date getA039fechinc() {
        return a039fechinc;
    }

    public void setA039fechinc(Date a039fechinc) {
        this.a039fechinc = a039fechinc;
    }

    public Date getA039fechfin() {
        return a039fechfin;
    }

    public void setA039fechfin(Date a039fechfin) {
        this.a039fechfin = a039fechfin;
    }

    public Character getA039estadoregistro() {
        return a039estadoregistro;
    }

    public void setA039estadoregistro(Character a039estadoregistro) {
        this.a039estadoregistro = a039estadoregistro;
    }

    public Date getA039fechacreacion() {
        return a039fechacreacion;
    }

    public void setA039fechacreacion(Date a039fechacreacion) {
        this.a039fechacreacion = a039fechacreacion;
    }

    public Date getA039fechamodificacion() {
        return a039fechamodificacion;
    }

    public void setA039fechamodificacion(Date a039fechamodificacion) {
        this.a039fechamodificacion = a039fechamodificacion;
    }

    public int getA039usuariocreacion() {
        return a039usuariocreacion;
    }

    public void setA039usuariocreacion(int a039usuariocreacion) {
        this.a039usuariocreacion = a039usuariocreacion;
    }

    public Integer getA039usuariomodificacion() {
        return a039usuariomodificacion;
    }

    public void setA039usuariomodificacion(Integer a039usuariomodificacion) {
        this.a039usuariomodificacion = a039usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<ReporteAnioFuente> getReporteAnioFuenteList() {
//        return reporteAnioFuenteList;
//    }
//
//    public void setReporteAnioFuenteList(List<ReporteAnioFuente> reporteAnioFuenteList) {
//        this.reporteAnioFuenteList = reporteAnioFuenteList;
//    }

    public Proyecto getA039idproyecto() {
        return a039idproyecto;
    }

    public void setA039idproyecto(Proyecto a039idproyecto) {
        this.a039idproyecto = a039idproyecto;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<RepAnioFteIndcdr> getRepAnioFteIndcdrList() {
//        return repAnioFteIndcdrList;
//    }
//
//    public void setRepAnioFteIndcdrList(List<RepAnioFteIndcdr> repAnioFteIndcdrList) {
//        this.repAnioFteIndcdrList = repAnioFteIndcdrList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a039codigo != null ? a039codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoEspecifico)) {
            return false;
        }
        ObjetivoEspecifico other = (ObjetivoEspecifico) object;
        if ((this.a039codigo == null && other.a039codigo != null) || (this.a039codigo != null && !this.a039codigo.equals(other.a039codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ObjetivoEspecifico[ a039codigo=" + a039codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ReporteAnioFuente> getReporteAnioFuenteCollection() {
        return reporteAnioFuenteCollection;
    }

    public void setReporteAnioFuenteCollection(Collection<ReporteAnioFuente> reporteAnioFuenteCollection) {
        this.reporteAnioFuenteCollection = reporteAnioFuenteCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<RepAnioFteIndcdr> getRepAnioFteIndcdrCollection() {
        return repAnioFteIndcdrCollection;
    }

    public void setRepAnioFteIndcdrCollection(Collection<RepAnioFteIndcdr> repAnioFteIndcdrCollection) {
        this.repAnioFteIndcdrCollection = repAnioFteIndcdrCollection;
    }
    
}
