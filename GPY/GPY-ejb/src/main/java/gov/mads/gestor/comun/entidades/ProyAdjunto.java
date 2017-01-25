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
@Table(name = "GPYT_T008_PROY_ADJUNTO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyAdjunto.findAll", query = "SELECT p FROM ProyAdjunto p")})
public class ProyAdjunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A008CODIGO")
    private Integer a008codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "A008NUMRRADCD")
    private String a008numrradcd;
    @Column(name = "A008FECHADJNT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a008fechadjnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A008ESTADOREGISTRO")
    private Character a008estadoregistro;
    @Column(name = "A008FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a008fechacreacion;
    @Column(name = "A008FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a008fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A008USUARIOCREACION")
    private int a008usuariocreacion;
    @Column(name = "A008USUARIOMODIFICACION")
    private Integer a008usuariomodificacion;
    @JoinColumn(name = "A008IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a008idproyecto;
    @JoinColumn(name = "A008IDADJNT", referencedColumnName = "A025CODIGO")
    @ManyToOne(optional = false)
    private Adjunto a008idadjnt;
    @JoinColumn(name = "A008IDARCHV", referencedColumnName = "A026CODIGO")
    @ManyToOne(optional = false)
    private Archivo a008idarchv;

    public ProyAdjunto() {
    }

    public ProyAdjunto(Integer a008codigo) {
        this.a008codigo = a008codigo;
    }

    public ProyAdjunto(Integer a008codigo, String a008numrradcd, Character a008estadoregistro, int a008usuariocreacion) {
        this.a008codigo = a008codigo;
        this.a008numrradcd = a008numrradcd;
        this.a008estadoregistro = a008estadoregistro;
        this.a008usuariocreacion = a008usuariocreacion;
    }

    public Integer getA008codigo() {
        return a008codigo;
    }

    public void setA008codigo(Integer a008codigo) {
        this.a008codigo = a008codigo;
    }

    public String getA008numrradcd() {
        return a008numrradcd;
    }

    public void setA008numrradcd(String a008numrradcd) {
        this.a008numrradcd = a008numrradcd;
    }

    public Date getA008fechadjnt() {
        return a008fechadjnt;
    }

    public void setA008fechadjnt(Date a008fechadjnt) {
        this.a008fechadjnt = a008fechadjnt;
    }

    public Character getA008estadoregistro() {
        return a008estadoregistro;
    }

    public void setA008estadoregistro(Character a008estadoregistro) {
        this.a008estadoregistro = a008estadoregistro;
    }

    public Date getA008fechacreacion() {
        return a008fechacreacion;
    }

    public void setA008fechacreacion(Date a008fechacreacion) {
        this.a008fechacreacion = a008fechacreacion;
    }

    public Date getA008fechamodificacion() {
        return a008fechamodificacion;
    }

    public void setA008fechamodificacion(Date a008fechamodificacion) {
        this.a008fechamodificacion = a008fechamodificacion;
    }

    public int getA008usuariocreacion() {
        return a008usuariocreacion;
    }

    public void setA008usuariocreacion(int a008usuariocreacion) {
        this.a008usuariocreacion = a008usuariocreacion;
    }

    public Integer getA008usuariomodificacion() {
        return a008usuariomodificacion;
    }

    public void setA008usuariomodificacion(Integer a008usuariomodificacion) {
        this.a008usuariomodificacion = a008usuariomodificacion;
    }

    public Proyecto getA008idproyecto() {
        return a008idproyecto;
    }

    public void setA008idproyecto(Proyecto a008idproyecto) {
        this.a008idproyecto = a008idproyecto;
    }

    public Adjunto getA008idadjnt() {
        return a008idadjnt;
    }

    public void setA008idadjnt(Adjunto a008idadjnt) {
        this.a008idadjnt = a008idadjnt;
    }

    public Archivo getA008idarchv() {
        return a008idarchv;
    }

    public void setA008idarchv(Archivo a008idarchv) {
        this.a008idarchv = a008idarchv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a008codigo != null ? a008codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyAdjunto)) {
            return false;
        }
        ProyAdjunto other = (ProyAdjunto) object;
        if ((this.a008codigo == null && other.a008codigo != null) || (this.a008codigo != null && !this.a008codigo.equals(other.a008codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.ProyAdjunto[ a008codigo=" + a008codigo + " ]";
    }
    
}
