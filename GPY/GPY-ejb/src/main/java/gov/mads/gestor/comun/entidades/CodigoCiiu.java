/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "GPYT_T049_CODIGOCIIU", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoCiiu.findAll", query = "SELECT c FROM CodigoCiiu c")})
public class CodigoCiiu implements Serializable {

    @OneToMany(mappedBy = "a052codgciiu")
    private Collection<Persona> personaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A049CODIGO")
    private Integer a049codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A049CODIGOCIIU")
    private int a049codigociiu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "A049DESCRIPCIONCIIU")
    private String a049descripcionciiu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A049ESTADOREGISTRO")
    private Character a049estadoregistro;
    @Column(name = "A049FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a049fechacreacion;
    @Column(name = "A049FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a049fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A049USUARIOCREACION")
    private int a049usuariocreacion;
    @Column(name = "A049USUARIOMODIFICACION")
    private Integer a049usuariomodificacion;
//    @OneToMany(mappedBy = "a052codgciiu")
//    private List<Persona> personaList;

    public CodigoCiiu() {
    }

    public CodigoCiiu(Integer a049codigo) {
        this.a049codigo = a049codigo;
    }

    public CodigoCiiu(Integer a049codigo, int a049codigociiu, String a049descripcionciiu, Character a049estadoregistro, int a049usuariocreacion) {
        this.a049codigo = a049codigo;
        this.a049codigociiu = a049codigociiu;
        this.a049descripcionciiu = a049descripcionciiu;
        this.a049estadoregistro = a049estadoregistro;
        this.a049usuariocreacion = a049usuariocreacion;
    }

    public Integer getA049codigo() {
        return a049codigo;
    }

    public void setA049codigo(Integer a049codigo) {
        this.a049codigo = a049codigo;
    }

    public int getA049codigociiu() {
        return a049codigociiu;
    }

    public void setA049codigociiu(int a049codigociiu) {
        this.a049codigociiu = a049codigociiu;
    }

    public String getA049descripcionciiu() {
        return a049descripcionciiu;
    }

    public void setA049descripcionciiu(String a049descripcionciiu) {
        this.a049descripcionciiu = a049descripcionciiu;
    }

    public Character getA049estadoregistro() {
        return a049estadoregistro;
    }

    public void setA049estadoregistro(Character a049estadoregistro) {
        this.a049estadoregistro = a049estadoregistro;
    }

    public Date getA049fechacreacion() {
        return a049fechacreacion;
    }

    public void setA049fechacreacion(Date a049fechacreacion) {
        this.a049fechacreacion = a049fechacreacion;
    }

    public Date getA049fechamodificacion() {
        return a049fechamodificacion;
    }

    public void setA049fechamodificacion(Date a049fechamodificacion) {
        this.a049fechamodificacion = a049fechamodificacion;
    }

    public int getA049usuariocreacion() {
        return a049usuariocreacion;
    }

    public void setA049usuariocreacion(int a049usuariocreacion) {
        this.a049usuariocreacion = a049usuariocreacion;
    }

    public Integer getA049usuariomodificacion() {
        return a049usuariomodificacion;
    }

    public void setA049usuariomodificacion(Integer a049usuariomodificacion) {
        this.a049usuariomodificacion = a049usuariomodificacion;
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
        hash += (a049codigo != null ? a049codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoCiiu)) {
            return false;
        }
        CodigoCiiu other = (CodigoCiiu) object;
        if ((this.a049codigo == null && other.a049codigo != null) || (this.a049codigo != null && !this.a049codigo.equals(other.a049codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.CodigoCiiu[ a049codigo=" + a049codigo + " ]";
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
