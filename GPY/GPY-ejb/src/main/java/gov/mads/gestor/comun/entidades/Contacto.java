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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T054_CONTACTO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A054CODIGO")
    private Integer a054codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A054ESTADOREGISTRO")
    private Character a054estadoregistro;
    @Column(name = "A054FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a054fechacreacion;
    @Column(name = "A054FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a054fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A054USUARIOCREACION")
    private int a054usuariocreacion;
    @Column(name = "A054USUARIOMODIFICACION")
    private Integer a054usuariomodificacion;
    @JoinColumn(name = "A054IDPERSONA", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a054idpersona;
    @JoinColumn(name = "A054IDCONTACTO", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a054idcontacto;

    public Contacto() {
    }

    public Contacto(Integer a054codigo) {
        this.a054codigo = a054codigo;
    }

    public Contacto(Integer a054codigo, Character a054estadoregistro, int a054usuariocreacion) {
        this.a054codigo = a054codigo;
        this.a054estadoregistro = a054estadoregistro;
        this.a054usuariocreacion = a054usuariocreacion;
    }

    public Integer getA054codigo() {
        return a054codigo;
    }

    public void setA054codigo(Integer a054codigo) {
        this.a054codigo = a054codigo;
    }

    public Character getA054estadoregistro() {
        return a054estadoregistro;
    }

    public void setA054estadoregistro(Character a054estadoregistro) {
        this.a054estadoregistro = a054estadoregistro;
    }

    public Date getA054fechacreacion() {
        return a054fechacreacion;
    }

    public void setA054fechacreacion(Date a054fechacreacion) {
        this.a054fechacreacion = a054fechacreacion;
    }

    public Date getA054fechamodificacion() {
        return a054fechamodificacion;
    }

    public void setA054fechamodificacion(Date a054fechamodificacion) {
        this.a054fechamodificacion = a054fechamodificacion;
    }

    public int getA054usuariocreacion() {
        return a054usuariocreacion;
    }

    public void setA054usuariocreacion(int a054usuariocreacion) {
        this.a054usuariocreacion = a054usuariocreacion;
    }

    public Integer getA054usuariomodificacion() {
        return a054usuariomodificacion;
    }

    public void setA054usuariomodificacion(Integer a054usuariomodificacion) {
        this.a054usuariomodificacion = a054usuariomodificacion;
    }

    public Persona getA054idpersona() {
        return a054idpersona;
    }

    public void setA054idpersona(Persona a054idpersona) {
        this.a054idpersona = a054idpersona;
    }

    public Persona getA054idcontacto() {
        return a054idcontacto;
    }

    public void setA054idcontacto(Persona a054idcontacto) {
        this.a054idcontacto = a054idcontacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a054codigo != null ? a054codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.a054codigo == null && other.a054codigo != null) || (this.a054codigo != null && !this.a054codigo.equals(other.a054codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Contacto[ a054codigo=" + a054codigo + " ]";
    }
    
}
