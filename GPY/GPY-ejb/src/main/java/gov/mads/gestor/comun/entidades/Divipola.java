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
@Table(name = "GPYT_T020_DIVIPOLA", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divipola.findAll", query = "SELECT d FROM Divipola d")})
public class Divipola implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002loclzcn")
    private Collection<Proyecto> proyectoCollection;
    @OneToMany(mappedBy = "a052loclzcn")
    private Collection<Persona> personaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A020CODIGO")
    private Integer a020codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "A020DIVIPOLA")
    private String a020divipola;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A020CODPAIS")
    private short a020codpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "A020NOMPAIS")
    private String a020nompais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A020CODDEPARTAMENTO")
    private short a020coddepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "A020NOMDEPARTAMENTO")
    private String a020nomdepartamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A020CODMUNICIPIO")
    private short a020codmunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A020NOMMUNICIPIO")
    private String a020nommunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A020ESTADOREGISTRO")
    private Character a020estadoregistro;
    @Column(name = "A020FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a020fechacreacion;
    @Column(name = "A020FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a020fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A020USUARIOCREACION")
    private int a020usuariocreacion;
    @Column(name = "A020USUARIOMODIFICACION")
    private Integer a020usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052loclzcn")
//    private List<Gpyv004Contactos> gpyv004ContactosList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002loclzcn")
//    private List<Proyecto> proyectoList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052loclzcn")
//    private List<Persona> personaList;

    public Divipola() {
    }

    public Divipola(Integer a020codigo) {
        this.a020codigo = a020codigo;
    }

    public Divipola(Integer a020codigo, String a020divipola, short a020codpais, String a020nompais, short a020coddepartamento, String a020nomdepartamento, short a020codmunicipio, String a020nommunicipio, Character a020estadoregistro, int a020usuariocreacion) {
        this.a020codigo = a020codigo;
        this.a020divipola = a020divipola;
        this.a020codpais = a020codpais;
        this.a020nompais = a020nompais;
        this.a020coddepartamento = a020coddepartamento;
        this.a020nomdepartamento = a020nomdepartamento;
        this.a020codmunicipio = a020codmunicipio;
        this.a020nommunicipio = a020nommunicipio;
        this.a020estadoregistro = a020estadoregistro;
        this.a020usuariocreacion = a020usuariocreacion;
    }

    public Integer getA020codigo() {
        return a020codigo;
    }

    public void setA020codigo(Integer a020codigo) {
        this.a020codigo = a020codigo;
    }

    public String getA020divipola() {
        return a020divipola;
    }

    public void setA020divipola(String a020divipola) {
        this.a020divipola = a020divipola;
    }

    public short getA020codpais() {
        return a020codpais;
    }

    public void setA020codpais(short a020codpais) {
        this.a020codpais = a020codpais;
    }

    public String getA020nompais() {
        return a020nompais;
    }

    public void setA020nompais(String a020nompais) {
        this.a020nompais = a020nompais;
    }

    public short getA020coddepartamento() {
        return a020coddepartamento;
    }

    public void setA020coddepartamento(short a020coddepartamento) {
        this.a020coddepartamento = a020coddepartamento;
    }

    public String getA020nomdepartamento() {
        return a020nomdepartamento;
    }

    public void setA020nomdepartamento(String a020nomdepartamento) {
        this.a020nomdepartamento = a020nomdepartamento;
    }

    public short getA020codmunicipio() {
        return a020codmunicipio;
    }

    public void setA020codmunicipio(short a020codmunicipio) {
        this.a020codmunicipio = a020codmunicipio;
    }

    public String getA020nommunicipio() {
        return a020nommunicipio;
    }

    public void setA020nommunicipio(String a020nommunicipio) {
        this.a020nommunicipio = a020nommunicipio;
    }

    public Character getA020estadoregistro() {
        return a020estadoregistro;
    }

    public void setA020estadoregistro(Character a020estadoregistro) {
        this.a020estadoregistro = a020estadoregistro;
    }

    public Date getA020fechacreacion() {
        return a020fechacreacion;
    }

    public void setA020fechacreacion(Date a020fechacreacion) {
        this.a020fechacreacion = a020fechacreacion;
    }

    public Date getA020fechamodificacion() {
        return a020fechamodificacion;
    }

    public void setA020fechamodificacion(Date a020fechamodificacion) {
        this.a020fechamodificacion = a020fechamodificacion;
    }

    public int getA020usuariocreacion() {
        return a020usuariocreacion;
    }

    public void setA020usuariocreacion(int a020usuariocreacion) {
        this.a020usuariocreacion = a020usuariocreacion;
    }

    public Integer getA020usuariomodificacion() {
        return a020usuariomodificacion;
    }

    public void setA020usuariomodificacion(Integer a020usuariomodificacion) {
        this.a020usuariomodificacion = a020usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Gpyv004Contactos> getGpyv004ContactosList() {
//        return gpyv004ContactosList;
//    }
//
//    public void setGpyv004ContactosList(List<Gpyv004Contactos> gpyv004ContactosList) {
//        this.gpyv004ContactosList = gpyv004ContactosList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<Proyecto> getProyectoList() {
//        return proyectoList;
//    }
//
//    public void setProyectoList(List<Proyecto> proyectoList) {
//        this.proyectoList = proyectoList;
//    }
//
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
        hash += (a020codigo != null ? a020codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divipola)) {
            return false;
        }
        Divipola other = (Divipola) object;
        if ((this.a020codigo == null && other.a020codigo != null) || (this.a020codigo != null && !this.a020codigo.equals(other.a020codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Divipola[ a020codigo=" + a020codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
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
