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
@Table(name = "GPYT_T015_TIPO_DOCUMENTO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")})
public class TipoDocumento implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052idtippersn")
    private Collection<Persona> personaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A015CODIGO")
    private Integer a015codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A015DESCRPCNTIPDOCMNT")
    private String a015descrpcntipdocmnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A015ESTADOREGISTRO")
    private Character a015estadoregistro;
    @Column(name = "A015FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a015fechacreacion;
    @Column(name = "A015FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a015fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A015USUARIOCREACION")
    private int a015usuariocreacion;
    @Column(name = "A015USUARIOMODIFICACION")
    private Integer a015usuariomodificacion;
    @JoinColumn(name = "A015IDTIPPERSN", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a015idtippersn;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052tipdocmnt")
//    private List<Persona> personaList;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer a015codigo) {
        this.a015codigo = a015codigo;
    }

    public TipoDocumento(Integer a015codigo, String a015descrpcntipdocmnt, Character a015estadoregistro, int a015usuariocreacion) {
        this.a015codigo = a015codigo;
        this.a015descrpcntipdocmnt = a015descrpcntipdocmnt;
        this.a015estadoregistro = a015estadoregistro;
        this.a015usuariocreacion = a015usuariocreacion;
    }

    public Integer getA015codigo() {
        return a015codigo;
    }

    public void setA015codigo(Integer a015codigo) {
        this.a015codigo = a015codigo;
    }

    public String getA015descrpcntipdocmnt() {
        return a015descrpcntipdocmnt;
    }

    public void setA015descrpcntipdocmnt(String a015descrpcntipdocmnt) {
        this.a015descrpcntipdocmnt = a015descrpcntipdocmnt;
    }

    public Character getA015estadoregistro() {
        return a015estadoregistro;
    }

    public void setA015estadoregistro(Character a015estadoregistro) {
        this.a015estadoregistro = a015estadoregistro;
    }

    public Date getA015fechacreacion() {
        return a015fechacreacion;
    }

    public void setA015fechacreacion(Date a015fechacreacion) {
        this.a015fechacreacion = a015fechacreacion;
    }

    public Date getA015fechamodificacion() {
        return a015fechamodificacion;
    }

    public void setA015fechamodificacion(Date a015fechamodificacion) {
        this.a015fechamodificacion = a015fechamodificacion;
    }

    public int getA015usuariocreacion() {
        return a015usuariocreacion;
    }

    public void setA015usuariocreacion(int a015usuariocreacion) {
        this.a015usuariocreacion = a015usuariocreacion;
    }

    public Integer getA015usuariomodificacion() {
        return a015usuariomodificacion;
    }

    public void setA015usuariomodificacion(Integer a015usuariomodificacion) {
        this.a015usuariomodificacion = a015usuariomodificacion;
    }

    public Lista getA015idtippersn() {
        return a015idtippersn;
    }

    public void setA015idtippersn(Lista a015idtippersn) {
        this.a015idtippersn = a015idtippersn;
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
        hash += (a015codigo != null ? a015codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.a015codigo == null && other.a015codigo != null) || (this.a015codigo != null && !this.a015codigo.equals(other.a015codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.TipoDocumento[ a015codigo=" + a015codigo + " ]";
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
