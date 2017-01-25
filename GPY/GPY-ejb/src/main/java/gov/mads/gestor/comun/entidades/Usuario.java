/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "GPYT_T041_USUARIO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idusr")
    private Collection<Proyecto> proyectoCollection;
    @JoinColumn(name = "A041IDPERSONA", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a041idpersona;
    @JoinColumn(name = "A041IDCLASUSR", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a041idclasusr;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A041CODIGO")
    private Integer a041codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "A041USERNAME")
    private String a041username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "A041CLAVE")
    private String a041clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "A041PRIMRINGRS")
    private String a041primringrs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A041ESTADOREGISTRO")
    private Character a041estadoregistro;
    @Column(name = "A041FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a041fechacreacion;
    @Column(name = "A041FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a041fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A041USUARIOCREACION")
    private int a041usuariocreacion;
    @Column(name = "A041USUARIOMODIFICACION")
    private Integer a041usuariomodificacion;

    public Usuario() {
    }

    public Usuario(Integer a041codigo) {
        this.a041codigo = a041codigo;
    }

    public Usuario(Integer a041codigo, String a041username, String a041clave, String a041primringrs, Character a041estadoregistro, int a041usuariocreacion) {
        this.a041codigo = a041codigo;
        this.a041username = a041username;
        this.a041clave = a041clave;
        this.a041primringrs = a041primringrs;
        this.a041estadoregistro = a041estadoregistro;
        this.a041usuariocreacion = a041usuariocreacion;
    }

    public Integer getA041codigo() {
        return a041codigo;
    }

    public void setA041codigo(Integer a041codigo) {
        this.a041codigo = a041codigo;
    }

    public String getA041username() {
        return a041username;
    }

    public void setA041username(String a041username) {
        this.a041username = a041username;
    }

    public String getA041clave() {
        return a041clave;
    }

    public void setA041clave(String a041clave) {
        this.a041clave = a041clave;
    }

    public String getA041primringrs() {
        return a041primringrs;
    }

    public void setA041primringrs(String a041primringrs) {
        this.a041primringrs = a041primringrs;
    }

    public Character getA041estadoregistro() {
        return a041estadoregistro;
    }

    public void setA041estadoregistro(Character a041estadoregistro) {
        this.a041estadoregistro = a041estadoregistro;
    }

    public Date getA041fechacreacion() {
        return a041fechacreacion;
    }

    public void setA041fechacreacion(Date a041fechacreacion) {
        this.a041fechacreacion = a041fechacreacion;
    }

    public Date getA041fechamodificacion() {
        return a041fechamodificacion;
    }

    public void setA041fechamodificacion(Date a041fechamodificacion) {
        this.a041fechamodificacion = a041fechamodificacion;
    }

    public int getA041usuariocreacion() {
        return a041usuariocreacion;
    }

    public void setA041usuariocreacion(int a041usuariocreacion) {
        this.a041usuariocreacion = a041usuariocreacion;
    }

    public Integer getA041usuariomodificacion() {
        return a041usuariomodificacion;
    }

    public void setA041usuariomodificacion(Integer a041usuariomodificacion) {
        this.a041usuariomodificacion = a041usuariomodificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a041codigo != null ? a041codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.a041codigo == null && other.a041codigo != null) || (this.a041codigo != null && !this.a041codigo.equals(other.a041codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Usuario_1[ a041codigo=" + a041codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    public Persona getA041idpersona() {
        return a041idpersona;
    }

    public void setA041idpersona(Persona a041idpersona) {
        this.a041idpersona = a041idpersona;
    }

    public Lista getA041idclasusr() {
        return a041idclasusr;
    }

    public void setA041idclasusr(Lista a041idclasusr) {
        this.a041idclasusr = a041idclasusr;
    }
    
}
