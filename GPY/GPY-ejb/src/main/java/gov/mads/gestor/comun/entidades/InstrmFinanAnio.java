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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T014_INSTRM_FINAN_ANIO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstrmFinanAnio.findAll", query = "SELECT i FROM InstrmFinanAnio i")})
public class InstrmFinanAnio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A014CODIGO")
    private Integer a014codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "A014PORCNTJFINANCCN")
    private BigDecimal a014porcntjfinanccn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A014ESTADOREGISTRO")
    private Character a014estadoregistro;
    @Column(name = "A014FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a014fechacreacion;
    @Column(name = "A014FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a014fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A014USUARIOCREACION")
    private int a014usuariocreacion;
    @Column(name = "A014USUARIOMODIFICACION")
    private Integer a014usuariomodificacion;
    @JoinColumn(name = "A014IDINSTRMNTFINANCCN", referencedColumnName = "A009CODIGO")
    @ManyToOne(optional = false)
    private InstrmntFinnccn a014idinstrmntfinanccn;
    @JoinColumn(name = "A014IDAVNCPROYCT", referencedColumnName = "A013CODIGO")
    @ManyToOne(optional = false)
    private AvanceProyecto a014idavncproyct;

    public InstrmFinanAnio() {
    }

    public InstrmFinanAnio(Integer a014codigo) {
        this.a014codigo = a014codigo;
    }

    public InstrmFinanAnio(Integer a014codigo, Character a014estadoregistro, int a014usuariocreacion) {
        this.a014codigo = a014codigo;
        this.a014estadoregistro = a014estadoregistro;
        this.a014usuariocreacion = a014usuariocreacion;
    }

    public Integer getA014codigo() {
        return a014codigo;
    }

    public void setA014codigo(Integer a014codigo) {
        this.a014codigo = a014codigo;
    }

    public BigDecimal getA014porcntjfinanccn() {
        return a014porcntjfinanccn;
    }

    public void setA014porcntjfinanccn(BigDecimal a014porcntjfinanccn) {
        this.a014porcntjfinanccn = a014porcntjfinanccn;
    }

    public Character getA014estadoregistro() {
        return a014estadoregistro;
    }

    public void setA014estadoregistro(Character a014estadoregistro) {
        this.a014estadoregistro = a014estadoregistro;
    }

    public Date getA014fechacreacion() {
        return a014fechacreacion;
    }

    public void setA014fechacreacion(Date a014fechacreacion) {
        this.a014fechacreacion = a014fechacreacion;
    }

    public Date getA014fechamodificacion() {
        return a014fechamodificacion;
    }

    public void setA014fechamodificacion(Date a014fechamodificacion) {
        this.a014fechamodificacion = a014fechamodificacion;
    }

    public int getA014usuariocreacion() {
        return a014usuariocreacion;
    }

    public void setA014usuariocreacion(int a014usuariocreacion) {
        this.a014usuariocreacion = a014usuariocreacion;
    }

    public Integer getA014usuariomodificacion() {
        return a014usuariomodificacion;
    }

    public void setA014usuariomodificacion(Integer a014usuariomodificacion) {
        this.a014usuariomodificacion = a014usuariomodificacion;
    }

    public InstrmntFinnccn getA014idinstrmntfinanccn() {
        return a014idinstrmntfinanccn;
    }

    public void setA014idinstrmntfinanccn(InstrmntFinnccn a014idinstrmntfinanccn) {
        this.a014idinstrmntfinanccn = a014idinstrmntfinanccn;
    }

    public AvanceProyecto getA014idavncproyct() {
        return a014idavncproyct;
    }

    public void setA014idavncproyct(AvanceProyecto a014idavncproyct) {
        this.a014idavncproyct = a014idavncproyct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a014codigo != null ? a014codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstrmFinanAnio)) {
            return false;
        }
        InstrmFinanAnio other = (InstrmFinanAnio) object;
        if ((this.a014codigo == null && other.a014codigo != null) || (this.a014codigo != null && !this.a014codigo.equals(other.a014codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.InstrmFinanAnio[ a014codigo=" + a014codigo + " ]";
    }
    
}
