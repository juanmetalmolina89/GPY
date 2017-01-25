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
@Table(name = "GPYT_T011_INDICADOR", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i")})
public class Indicador implements Serializable {

    @JoinColumn(name = "A011IDTIPACCION", referencedColumnName = "A050CODIGO")
    @ManyToOne(optional = false)
    private TipoAccion a011idtipaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a012idindcdr")
    private Collection<RepAnioFteIndcdr> repAnioFteIndcdrCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A011CODIGO")
    private Integer a011codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A011NOMBRINDCDR")
    private String a011nombrindcdr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A011ESTADOREGISTRO")
    private Character a011estadoregistro;
    @Column(name = "A011FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a011fechacreacion;
    @Column(name = "A011FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a011fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A011USUARIOCREACION")
    private int a011usuariocreacion;
    @Column(name = "A011USUARIOMODIFICACION")
    private Integer a011usuariomodificacion;
    @JoinColumn(name = "A011IDACTVDD", referencedColumnName = "A005CODIGO")
    @ManyToOne(optional = false)
    private Actividad a011idactvdd;
    @JoinColumn(name = "A011IDTIPINDCDR", referencedColumnName = "A034CODIGO")
    @ManyToOne(optional = false)
    private TipoIndicador a011idtipindcdr;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a012idindcdr")
//    private List<RepAnioFteIndcdr> repAnioFteIndcdrList;

    public Indicador() {
    }

    public Indicador(Integer a011codigo) {
        this.a011codigo = a011codigo;
    }

    public Indicador(Integer a011codigo, String a011nombrindcdr, Character a011estadoregistro, int a011usuariocreacion) {
        this.a011codigo = a011codigo;
        this.a011nombrindcdr = a011nombrindcdr;
        this.a011estadoregistro = a011estadoregistro;
        this.a011usuariocreacion = a011usuariocreacion;
    }

    public Integer getA011codigo() {
        return a011codigo;
    }

    public void setA011codigo(Integer a011codigo) {
        this.a011codigo = a011codigo;
    }

    public String getA011nombrindcdr() {
        return a011nombrindcdr;
    }

    public void setA011nombrindcdr(String a011nombrindcdr) {
        this.a011nombrindcdr = a011nombrindcdr;
    }

    public Character getA011estadoregistro() {
        return a011estadoregistro;
    }

    public void setA011estadoregistro(Character a011estadoregistro) {
        this.a011estadoregistro = a011estadoregistro;
    }

    public Date getA011fechacreacion() {
        return a011fechacreacion;
    }

    public void setA011fechacreacion(Date a011fechacreacion) {
        this.a011fechacreacion = a011fechacreacion;
    }

    public Date getA011fechamodificacion() {
        return a011fechamodificacion;
    }

    public void setA011fechamodificacion(Date a011fechamodificacion) {
        this.a011fechamodificacion = a011fechamodificacion;
    }

    public int getA011usuariocreacion() {
        return a011usuariocreacion;
    }

    public void setA011usuariocreacion(int a011usuariocreacion) {
        this.a011usuariocreacion = a011usuariocreacion;
    }

    public Integer getA011usuariomodificacion() {
        return a011usuariomodificacion;
    }

    public void setA011usuariomodificacion(Integer a011usuariomodificacion) {
        this.a011usuariomodificacion = a011usuariomodificacion;
    }

    public Actividad getA011idactvdd() {
        return a011idactvdd;
    }

    public void setA011idactvdd(Actividad a011idactvdd) {
        this.a011idactvdd = a011idactvdd;
    }

    public TipoIndicador getA011idtipindcdr() {
        return a011idtipindcdr;
    }

    public void setA011idtipindcdr(TipoIndicador a011idtipindcdr) {
        this.a011idtipindcdr = a011idtipindcdr;
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
        hash += (a011codigo != null ? a011codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.a011codigo == null && other.a011codigo != null) || (this.a011codigo != null && !this.a011codigo.equals(other.a011codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Indicador[ a011codigo=" + a011codigo + " ]";
    }

    public TipoAccion getA011idtipaccion() {
        return a011idtipaccion;
    }

    public void setA011idtipaccion(TipoAccion a011idtipaccion) {
        this.a011idtipaccion = a011idtipaccion;
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
