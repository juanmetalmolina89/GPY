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
@Table(name = "PART_T101_CATEGORIA", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")})
public class Categoria implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a102categoria")
    private Collection<Lista> listaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A101CODIGO")
    private Integer a101codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "A101NOMBRE")
    private String a101nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A101ESTADOREGISTRO")
    private Character a101estadoregistro;
    @Column(name = "A101FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a101fechacreacion;
    @Column(name = "A101FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a101fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A101USUARIOCREACION")
    private int a101usuariocreacion;
    @Column(name = "A101USUARIOMODIFICACION")
    private Integer a101usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a102categoria")
//    private Collection<Lista> listaCollection;

    public Categoria() {
    }

    public Categoria(Integer a101codigo) {
        this.a101codigo = a101codigo;
    }

    public Categoria(Integer a101codigo, String a101nombre, Character a101estadoregistro, int a101usuariocreacion) {
        this.a101codigo = a101codigo;
        this.a101nombre = a101nombre;
        this.a101estadoregistro = a101estadoregistro;
        this.a101usuariocreacion = a101usuariocreacion;
    }

    public Integer getA101codigo() {
        return a101codigo;
    }

    public void setA101codigo(Integer a101codigo) {
        this.a101codigo = a101codigo;
    }

    public String getA101nombre() {
        return a101nombre;
    }

    public void setA101nombre(String a101nombre) {
        this.a101nombre = a101nombre;
    }

    public Character getA101estadoregistro() {
        return a101estadoregistro;
    }

    public void setA101estadoregistro(Character a101estadoregistro) {
        this.a101estadoregistro = a101estadoregistro;
    }

    public Date getA101fechacreacion() {
        return a101fechacreacion;
    }

    public void setA101fechacreacion(Date a101fechacreacion) {
        this.a101fechacreacion = a101fechacreacion;
    }

    public Date getA101fechamodificacion() {
        return a101fechamodificacion;
    }

    public void setA101fechamodificacion(Date a101fechamodificacion) {
        this.a101fechamodificacion = a101fechamodificacion;
    }

    public int getA101usuariocreacion() {
        return a101usuariocreacion;
    }

    public void setA101usuariocreacion(int a101usuariocreacion) {
        this.a101usuariocreacion = a101usuariocreacion;
    }

    public Integer getA101usuariomodificacion() {
        return a101usuariomodificacion;
    }

    public void setA101usuariomodificacion(Integer a101usuariomodificacion) {
        this.a101usuariomodificacion = a101usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public Collection<Lista> getListaCollection() {
//        return listaCollection;
//    }
//
//    public void setListaCollection(Collection<Lista> listaCollection) {
//        this.listaCollection = listaCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a101codigo != null ? a101codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.a101codigo == null && other.a101codigo != null) || (this.a101codigo != null && !this.a101codigo.equals(other.a101codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mads.gestor.comun.entidades.Categoria[ a101codigo=" + a101codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Lista> getListaCollection() {
        return listaCollection;
    }

    public void setListaCollection(Collection<Lista> listaCollection) {
        this.listaCollection = listaCollection;
    }
    
}
