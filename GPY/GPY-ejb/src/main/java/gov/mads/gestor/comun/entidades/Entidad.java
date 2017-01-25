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
@Table(name = "GPYT_T001_ENTIDAD", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e")})
public class Entidad implements Serializable {

    @OneToMany(mappedBy = "a052identidad")
    private Collection<Persona> personaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A001CODIGO")
    private Integer a001codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A001SIGLA")
    private String a001sigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "A001NOMBRE")
    private String a001nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A001ESTADOREGISTRO")
    private Character a001estadoregistro;
    @Column(name = "A001FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a001fechacreacion;
    @Column(name = "A001FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a001fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A001USUARIOCREACION")
    private int a001usuariocreacion;
    @Column(name = "A001USUARIOMODIFICACION")
    private Integer a001usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052identidad")
//    private List<Persona> personaList;

    public Entidad() {
    }

    public Entidad(Integer a001codigo) {
        this.a001codigo = a001codigo;
    }

    public Entidad(Integer a001codigo, String a001sigla, String a001nombre, Character a001estadoregistro, int a001usuariocreacion) {
        this.a001codigo = a001codigo;
        this.a001sigla = a001sigla;
        this.a001nombre = a001nombre;
        this.a001estadoregistro = a001estadoregistro;
        this.a001usuariocreacion = a001usuariocreacion;
    }

    public Integer getA001codigo() {
        return a001codigo;
    }

    public void setA001codigo(Integer a001codigo) {
        this.a001codigo = a001codigo;
    }

    public String getA001sigla() {
        return a001sigla;
    }

    public void setA001sigla(String a001sigla) {
        this.a001sigla = a001sigla;
    }

    public String getA001nombre() {
        return a001nombre;
    }

    public void setA001nombre(String a001nombre) {
        this.a001nombre = a001nombre;
    }

    public Character getA001estadoregistro() {
        return a001estadoregistro;
    }

    public void setA001estadoregistro(Character a001estadoregistro) {
        this.a001estadoregistro = a001estadoregistro;
    }

    public Date getA001fechacreacion() {
        return a001fechacreacion;
    }

    public void setA001fechacreacion(Date a001fechacreacion) {
        this.a001fechacreacion = a001fechacreacion;
    }

    public Date getA001fechamodificacion() {
        return a001fechamodificacion;
    }

    public void setA001fechamodificacion(Date a001fechamodificacion) {
        this.a001fechamodificacion = a001fechamodificacion;
    }

    public int getA001usuariocreacion() {
        return a001usuariocreacion;
    }

    public void setA001usuariocreacion(int a001usuariocreacion) {
        this.a001usuariocreacion = a001usuariocreacion;
    }

    public Integer getA001usuariomodificacion() {
        return a001usuariomodificacion;
    }

    public void setA001usuariomodificacion(Integer a001usuariomodificacion) {
        this.a001usuariomodificacion = a001usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Persona> getPersonaList() {
//        return personaList;
//    }
//
//    public void setPersonaList(List<Persona> personaList) {
//        this.personaList = personaList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a001codigo != null ? a001codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.a001codigo == null && other.a001codigo != null) || (this.a001codigo != null && !this.a001codigo.equals(other.a001codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Entidad[ a001codigo=" + a001codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }
    
}
