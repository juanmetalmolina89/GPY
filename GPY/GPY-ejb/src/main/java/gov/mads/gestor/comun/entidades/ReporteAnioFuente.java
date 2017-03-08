/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T010_REPORTE_ANIO_FUENTE", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteAnioFuente.findAll", query = "SELECT r FROM ReporteAnioFuente r")})
public class ReporteAnioFuente implements Serializable {

    /*@Basic(optional = false)
    @NotNull
    @Column(name = "A010IDFUENTE")
    private int a010idfuente;*/
    @JoinColumn(name = "A010CODIGO", referencedColumnName = "A038CODIGO")
    @OneToOne(optional = false)
    private Fuente fuente;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A010CODIGO")
    private Integer a010codigo;
    @Column(name = "A010REPRTANFUNT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a010reprtanfunt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "A010VALREMSN")
    private BigDecimal a010valremsn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A010ESTADOREGISTRO")
    private Character a010estadoregistro;
    @Column(name = "A010FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a010fechacreacion;
    @Column(name = "A010FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a010fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A010USUARIOCREACION")
    private int a010usuariocreacion;
    @Column(name = "A010USUARIOMODIFICACION")
    private Integer a010usuariomodificacion;
    @JoinColumn(name = "A010IDFUENTE", referencedColumnName = "A039CODIGO")
    @ManyToOne(optional = false)
    private Fuente a010idfuente;
    @JoinColumn(name = "A010IDESCALA", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a010idescala;

    public ReporteAnioFuente() {
    }

    public ReporteAnioFuente(Integer a010codigo) {
        this.a010codigo = a010codigo;
    }

    public ReporteAnioFuente(Integer a010codigo, BigDecimal a010valremsn, Character a010estadoregistro, int a010usuariocreacion) {
        this.a010codigo = a010codigo;
        this.a010valremsn = a010valremsn;
        this.a010estadoregistro = a010estadoregistro;
        this.a010usuariocreacion = a010usuariocreacion;
    }

    public Integer getA010codigo() {
        return a010codigo;
    }

    public void setA010codigo(Integer a010codigo) {
        this.a010codigo = a010codigo;
    }

    public Date getA010reprtanfunt() {
        return a010reprtanfunt;
    }

    public void setA010reprtanfunt(Date a010reprtanfunt) {
        this.a010reprtanfunt = a010reprtanfunt;
    }

    public BigDecimal getA010valremsn() {
        return a010valremsn;
    }

    public void setA010valremsn(BigDecimal a010valremsn) {
        this.a010valremsn = a010valremsn;
    }

    public Character getA010estadoregistro() {
        return a010estadoregistro;
    }

    public void setA010estadoregistro(Character a010estadoregistro) {
        this.a010estadoregistro = a010estadoregistro;
    }

    public Date getA010fechacreacion() {
        return a010fechacreacion;
    }

    public void setA010fechacreacion(Date a010fechacreacion) {
        this.a010fechacreacion = a010fechacreacion;
    }

    public Date getA010fechamodificacion() {
        return a010fechamodificacion;
    }

    public void setA010fechamodificacion(Date a010fechamodificacion) {
        this.a010fechamodificacion = a010fechamodificacion;
    }

    public int getA010usuariocreacion() {
        return a010usuariocreacion;
    }

    public void setA010usuariocreacion(int a010usuariocreacion) {
        this.a010usuariocreacion = a010usuariocreacion;
    }

    public Integer getA010usuariomodificacion() {
        return a010usuariomodificacion;
    }

    public void setA010usuariomodificacion(Integer a010usuariomodificacion) {
        this.a010usuariomodificacion = a010usuariomodificacion;
    }

    public Fuente getA010idfuente() {
        return a010idfuente;
    }

    public void setA010idfuente(Fuente a010idfuente) {
        this.a010idfuente = a010idfuente;
    }

    public Lista getA010idescala() {
        return a010idescala;
    }

    public void setA010idescala(Lista a010idescala) {
        this.a010idescala = a010idescala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a010codigo != null ? a010codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteAnioFuente)) {
            return false;
        }
        ReporteAnioFuente other = (ReporteAnioFuente) object;
        if ((this.a010codigo == null && other.a010codigo != null) || (this.a010codigo != null && !this.a010codigo.equals(other.a010codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ReporteAnioFuente[ a010codigo=" + a010codigo + " ]";
    }
/*
    public int getA010idfuente() {
        return a010idfuente;
    }

    public void setA010idfuente(int a010idfuente) {
        this.a010idfuente = a010idfuente;
    }
*/
    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }
    
}
