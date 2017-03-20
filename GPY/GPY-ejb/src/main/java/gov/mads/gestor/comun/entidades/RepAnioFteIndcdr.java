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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T012_REP_ANIO_FTE_INDCDR", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepAnioFteIndcdr.findAll", query = "SELECT r FROM RepAnioFteIndcdr r")})
public class RepAnioFteIndcdr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A012CODIGO")
    private Integer a012codigo;
    @Column(name = "A012REPRTANFUNTINDICDR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a012reprtanfuntindicdr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "A012VALRLOGRD")
    private BigDecimal a012valrlogrd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A012UNIDDMEDD")
    private String a012uniddmedd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A012ESTADOREGISTRO")
    private Character a012estadoregistro;
    @Column(name = "A012FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a012fechacreacion;
    @Column(name = "A012FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a012fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A012USUARIOCREACION")
    private int a012usuariocreacion;
    @Column(name = "A012USUARIOMODIFICACION")
    private Integer a012usuariomodificacion;
    @JoinColumn(name = "A012IDINDCDR", referencedColumnName = "A011CODIGO")
    @ManyToOne(optional = false)
    private Indicador a012idindcdr;
    @JoinColumn(name = "A012IDFUENTE", referencedColumnName = "A039CODIGO")
    @ManyToOne(optional = false)
    private ObjetivoEspecifico a012idfuente;
    @Column(name = "A012FECHAMETA")
    private Date a012fechameta;
    @Column(name = "A012VALORMETA")
    private BigDecimal a012valormeta;
    @Column(name = "A012ACCIONESREALIZADAS")
    private String a012accionesrealizadas;
    @Column(name = "A012RECURSSINVRTDS")
    private BigDecimal a012recurssinvrtds;
    
    
    public RepAnioFteIndcdr() {
    }

    public RepAnioFteIndcdr(Integer a012codigo) {
        this.a012codigo = a012codigo;
    }

    public RepAnioFteIndcdr(Integer a012codigo, String a012uniddmedd, Character a012estadoregistro, int a012usuariocreacion) {
        this.a012codigo = a012codigo;
        this.a012uniddmedd = a012uniddmedd;
        this.a012estadoregistro = a012estadoregistro;
        this.a012usuariocreacion = a012usuariocreacion;
    }

    public Integer getA012codigo() {
        return a012codigo;
    }

    public void setA012codigo(Integer a012codigo) {
        this.a012codigo = a012codigo;
    }

    public Date getA012reprtanfuntindicdr() {
        return a012reprtanfuntindicdr;
    }

    public void setA012reprtanfuntindicdr(Date a012reprtanfuntindicdr) {
        this.a012reprtanfuntindicdr = a012reprtanfuntindicdr;
    }

    public BigDecimal getA012valrlogrd() {
        return a012valrlogrd;
    }

    public void setA012valrlogrd(BigDecimal a012valrlogrd) {
        this.a012valrlogrd = a012valrlogrd;
    }

    public String getA012uniddmedd() {
        return a012uniddmedd;
    }

    public void setA012uniddmedd(String a012uniddmedd) {
        this.a012uniddmedd = a012uniddmedd;
    }

    public Character getA012estadoregistro() {
        return a012estadoregistro;
    }

    public void setA012estadoregistro(Character a012estadoregistro) {
        this.a012estadoregistro = a012estadoregistro;
    }

    public Date getA012fechacreacion() {
        return a012fechacreacion;
    }

    public void setA012fechacreacion(Date a012fechacreacion) {
        this.a012fechacreacion = a012fechacreacion;
    }

    public Date getA012fechamodificacion() {
        return a012fechamodificacion;
    }

    public void setA012fechamodificacion(Date a012fechamodificacion) {
        this.a012fechamodificacion = a012fechamodificacion;
    }

    public int getA012usuariocreacion() {
        return a012usuariocreacion;
    }

    public void setA012usuariocreacion(int a012usuariocreacion) {
        this.a012usuariocreacion = a012usuariocreacion;
    }

    public Integer getA012usuariomodificacion() {
        return a012usuariomodificacion;
    }

    public void setA012usuariomodificacion(Integer a012usuariomodificacion) {
        this.a012usuariomodificacion = a012usuariomodificacion;
    }

    public Indicador getA012idindcdr() {
        return a012idindcdr;
    }

    public void setA012idindcdr(Indicador a012idindcdr) {
        this.a012idindcdr = a012idindcdr;
    }

    public ObjetivoEspecifico getA012idfuente() {
        return a012idfuente;
    }

    public void setA012idfuente(ObjetivoEspecifico a012idfuente) {
        this.a012idfuente = a012idfuente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a012codigo != null ? a012codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepAnioFteIndcdr)) {
            return false;
        }
        RepAnioFteIndcdr other = (RepAnioFteIndcdr) object;
        if ((this.a012codigo == null && other.a012codigo != null) || (this.a012codigo != null && !this.a012codigo.equals(other.a012codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.RepAnioFteIndcdr[ a012codigo=" + a012codigo + " ]";
    }

    public BigDecimal getA012valormeta() {
        return a012valormeta;
    }

    public void setA012valormeta(BigDecimal a012valormeta) {
        this.a012valormeta = a012valormeta;
    }

    public Date getA012fechameta() {
        return a012fechameta;
    }

    public void setA012fechameta(Date a012fechameta) {
        this.a012fechameta = a012fechameta;
    }

    public String getA012accionesrealizadas() {
        return a012accionesrealizadas;
    }

    public void setA012accionesrealizadas(String a012accionesrealizadas) {
        this.a012accionesrealizadas = a012accionesrealizadas;
    }

    public BigDecimal getA012recurssinvrtds() {
        return a012recurssinvrtds;
    }

    public void setA012recurssinvrtds(BigDecimal a012recurssinvrtds) {
        this.a012recurssinvrtds = a012recurssinvrtds;
    }

}
