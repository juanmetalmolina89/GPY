/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
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
@Table(name = "GPYT_T006_PROY_SECTR_IMPLMNTDR", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProySectrImplmntdr.findAll", query = "SELECT p FROM ProySectrImplmntdr p")})
public class ProySectrImplmntdr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A006CODIGO")
    private Integer a006codigo;
    @Size(max = 50)
    @Column(name = "A006DETALLEOTRO")
    private String a006detalleotro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A006ESTADOREGISTRO")
    private Character a006estadoregistro;
    @Column(name = "A006FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a006fechacreacion;
    @Column(name = "A006FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a006fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A006USUARIOCREACION")
    private int a006usuariocreacion;
    @Column(name = "A006USUARIOMODIFICACION")
    private Integer a006usuariomodificacion;
    @JoinColumn(name = "A006IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a006idproyecto;
    @JoinColumn(name = "A006IDSECTRIMPLMNTDR", referencedColumnName = "A023CODIGO")
    @ManyToOne(optional = false)
    private SectorImplementador a006idsectrimplmntdr;

    public ProySectrImplmntdr() {
    }

    public ProySectrImplmntdr(Integer a006codigo) {
        this.a006codigo = a006codigo;
    }

    public ProySectrImplmntdr(Integer a006codigo, Character a006estadoregistro, int a006usuariocreacion) {
        this.a006codigo = a006codigo;
        this.a006estadoregistro = a006estadoregistro;
        this.a006usuariocreacion = a006usuariocreacion;
    }

    public Integer getA006codigo() {
        return a006codigo;
    }

    public void setA006codigo(Integer a006codigo) {
        this.a006codigo = a006codigo;
    }

    public String getA006detalleotro() {
        return a006detalleotro;
    }

    public void setA006detalleotro(String a006detalleotro) {
        this.a006detalleotro = a006detalleotro;
    }

    public Character getA006estadoregistro() {
        return a006estadoregistro;
    }

    public void setA006estadoregistro(Character a006estadoregistro) {
        this.a006estadoregistro = a006estadoregistro;
    }

    public Date getA006fechacreacion() {
        return a006fechacreacion;
    }

    public void setA006fechacreacion(Date a006fechacreacion) {
        this.a006fechacreacion = a006fechacreacion;
    }

    public Date getA006fechamodificacion() {
        return a006fechamodificacion;
    }

    public void setA006fechamodificacion(Date a006fechamodificacion) {
        this.a006fechamodificacion = a006fechamodificacion;
    }

    public int getA006usuariocreacion() {
        return a006usuariocreacion;
    }

    public void setA006usuariocreacion(int a006usuariocreacion) {
        this.a006usuariocreacion = a006usuariocreacion;
    }

    public Integer getA006usuariomodificacion() {
        return a006usuariomodificacion;
    }

    public void setA006usuariomodificacion(Integer a006usuariomodificacion) {
        this.a006usuariomodificacion = a006usuariomodificacion;
    }

    public Proyecto getA006idproyecto() {
        return a006idproyecto;
    }

    public void setA006idproyecto(Proyecto a006idproyecto) {
        this.a006idproyecto = a006idproyecto;
    }

    public SectorImplementador getA006idsectrimplmntdr() {
        return a006idsectrimplmntdr;
    }

    public void setA006idsectrimplmntdr(SectorImplementador a006idsectrimplmntdr) {
        this.a006idsectrimplmntdr = a006idsectrimplmntdr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a006codigo != null ? a006codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProySectrImplmntdr)) {
            return false;
        }
        ProySectrImplmntdr other = (ProySectrImplmntdr) object;
        if ((this.a006codigo == null && other.a006codigo != null) || (this.a006codigo != null && !this.a006codigo.equals(other.a006codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ProySectrImplmntdr[ a006codigo=" + a006codigo + " ]";
    }

}
