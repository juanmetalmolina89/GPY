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
@Table(name = "GPYT_T051_PARTICIPANTE", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participante.findAll", query = "SELECT p FROM Participante p")})
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A051CODIGO")
    private Integer a051codigo;
    @Size(max = 500)
    @Column(name = "A051RESPONSABILIDAD")
    private String a051responsabilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A051ESTADOREGISTRO")
    private Character a051estadoregistro;
    @Column(name = "A051FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a051fechacreacion;
    @Column(name = "A051FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a051fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A051USUARIOCREACION")
    private int a051usuariocreacion;
    @Column(name = "A051USUARIOMODIFICACION")
    private Integer a051usuariomodificacion;
    @JoinColumn(name = "A05IDPROYECTO", referencedColumnName = "A002CODIGO")
    @ManyToOne(optional = false)
    private Proyecto a05idproyecto;
    @JoinColumn(name = "A051IDPERSONA", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a051idpersona;

    public Participante() {
    }

    public Participante(Integer a051codigo) {
        this.a051codigo = a051codigo;
    }

    public Participante(Integer a051codigo, Character a051estadoregistro, int a051usuariocreacion) {
        this.a051codigo = a051codigo;
        this.a051estadoregistro = a051estadoregistro;
        this.a051usuariocreacion = a051usuariocreacion;
    }

    public Integer getA051codigo() {
        return a051codigo;
    }

    public void setA051codigo(Integer a051codigo) {
        this.a051codigo = a051codigo;
    }

    public String getA051responsabilidad() {
        return a051responsabilidad;
    }

    public void setA051responsabilidad(String a051responsabilidad) {
        this.a051responsabilidad = a051responsabilidad;
    }

    public Character getA051estadoregistro() {
        return a051estadoregistro;
    }

    public void setA051estadoregistro(Character a051estadoregistro) {
        this.a051estadoregistro = a051estadoregistro;
    }

    public Date getA051fechacreacion() {
        return a051fechacreacion;
    }

    public void setA051fechacreacion(Date a051fechacreacion) {
        this.a051fechacreacion = a051fechacreacion;
    }

    public Date getA051fechamodificacion() {
        return a051fechamodificacion;
    }

    public void setA051fechamodificacion(Date a051fechamodificacion) {
        this.a051fechamodificacion = a051fechamodificacion;
    }

    public int getA051usuariocreacion() {
        return a051usuariocreacion;
    }

    public void setA051usuariocreacion(int a051usuariocreacion) {
        this.a051usuariocreacion = a051usuariocreacion;
    }

    public Integer getA051usuariomodificacion() {
        return a051usuariomodificacion;
    }

    public void setA051usuariomodificacion(Integer a051usuariomodificacion) {
        this.a051usuariomodificacion = a051usuariomodificacion;
    }

    public Proyecto getA05idproyecto() {
        return a05idproyecto;
    }

    public void setA05idproyecto(Proyecto a05idproyecto) {
        this.a05idproyecto = a05idproyecto;
    }

    public Persona getA051idpersona() {
        return a051idpersona;
    }

    public void setA051idpersona(Persona a051idpersona) {
        this.a051idpersona = a051idpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a051codigo != null ? a051codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.a051codigo == null && other.a051codigo != null) || (this.a051codigo != null && !this.a051codigo.equals(other.a051codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Participante[ a051codigo=" + a051codigo + " ]";
    }
    
}
