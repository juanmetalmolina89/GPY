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
@Table(name = "GPYT_T038_FUENTE", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuente.findAll", query = "SELECT f FROM Fuente f")})
public class Fuente implements Serializable {

    @JoinColumn(name = "A038IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a038idproyecto;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A038CODIGO")
    private Integer a038codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A038NOMBRFUNT")
    private String a038nombrfunt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "A038FACTOREMISION")
    private BigDecimal a038factoremision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A038ESTADOREGISTRO")
    private Character a038estadoregistro;
    @Column(name = "A038FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a038fechacreacion;
    @Column(name = "A038FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a038fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A038USUARIOCREACION")
    private int a038usuariocreacion;
    @Column(name = "A038USUARIOMODIFICACION")
    private Integer a038usuariomodificacion;
    @JoinColumn(name = "A038IDDESGRCATIPCC", referencedColumnName = "A048CODIGO")
    @ManyToOne(optional = false)
    private DesagregaCatgIpcc a038iddesgrcatipcc;

    public Fuente() {
    }

    public Fuente(Integer a038codigo) {
        this.a038codigo = a038codigo;
    }

    public Fuente(Integer a038codigo, String a038nombrfunt, BigDecimal a038factoremision, Character a038estadoregistro, int a038usuariocreacion) {
        this.a038codigo = a038codigo;
        this.a038nombrfunt = a038nombrfunt;
        this.a038factoremision = a038factoremision;
        this.a038estadoregistro = a038estadoregistro;
        this.a038usuariocreacion = a038usuariocreacion;
    }

    public Integer getA038codigo() {
        return a038codigo;
    }

    public void setA038codigo(Integer a038codigo) {
        this.a038codigo = a038codigo;
    }

    public String getA038nombrfunt() {
        return a038nombrfunt;
    }

    public void setA038nombrfunt(String a038nombrfunt) {
        this.a038nombrfunt = a038nombrfunt;
    }

    public BigDecimal getA038factoremision() {
        return a038factoremision;
    }

    public void setA038factoremision(BigDecimal a038factoremision) {
        this.a038factoremision = a038factoremision;
    }

    public Character getA038estadoregistro() {
        return a038estadoregistro;
    }

    public void setA038estadoregistro(Character a038estadoregistro) {
        this.a038estadoregistro = a038estadoregistro;
    }

    public Date getA038fechacreacion() {
        return a038fechacreacion;
    }

    public void setA038fechacreacion(Date a038fechacreacion) {
        this.a038fechacreacion = a038fechacreacion;
    }

    public Date getA038fechamodificacion() {
        return a038fechamodificacion;
    }

    public void setA038fechamodificacion(Date a038fechamodificacion) {
        this.a038fechamodificacion = a038fechamodificacion;
    }

    public int getA038usuariocreacion() {
        return a038usuariocreacion;
    }

    public void setA038usuariocreacion(int a038usuariocreacion) {
        this.a038usuariocreacion = a038usuariocreacion;
    }

    public Integer getA038usuariomodificacion() {
        return a038usuariomodificacion;
    }

    public void setA038usuariomodificacion(Integer a038usuariomodificacion) {
        this.a038usuariomodificacion = a038usuariomodificacion;
    }

    public DesagregaCatgIpcc getA038iddesgrcatipcc() {
        return a038iddesgrcatipcc;
    }

    public void setA038iddesgrcatipcc(DesagregaCatgIpcc a038iddesgrcatipcc) {
        this.a038iddesgrcatipcc = a038iddesgrcatipcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a038codigo != null ? a038codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fuente)) {
            return false;
        }
        Fuente other = (Fuente) object;
        if ((this.a038codigo == null && other.a038codigo != null) || (this.a038codigo != null && !this.a038codigo.equals(other.a038codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Fuente[ a038codigo=" + a038codigo + " ]";
    }

    public Proyecto getA038idproyecto() {
        return a038idproyecto;
    }

    public void setA038idproyecto(Proyecto a038idproyecto) {
        this.a038idproyecto = a038idproyecto;
    }
    
}
