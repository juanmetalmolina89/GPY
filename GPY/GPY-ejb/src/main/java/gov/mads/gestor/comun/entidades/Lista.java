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
@Table(name = "PART_T102_LISTA", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l")})
public class Lista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A102CODIGO")
    private Integer a102codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A102VALOR")
    private String a102valor;
    @Size(max = 30)
    @Column(name = "A102VALORCORTO")
    private String a102valorcorto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A102ESTADOREGISTRO")
    private Character a102estadoregistro;
    @Column(name = "A102FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a102fechacreacion;
    @Column(name = "A102FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a102fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A102USUARIOCREACION")
    private int a102usuariocreacion;
    @Column(name = "A102USUARIOMODIFICACION")
    private Integer a102usuariomodificacion;
    @JoinColumn(name = "A102CATEGORIA", referencedColumnName = "A101CODIGO")
    @ManyToOne(optional = false)
    private Categoria a102categoria;

    public Lista() {
    }

    public Lista(Integer a102codigo) {
        this.a102codigo = a102codigo;
    }

    public Lista(Integer a102codigo, String a102valor, Character a102estadoregistro, int a102usuariocreacion) {
        this.a102codigo = a102codigo;
        this.a102valor = a102valor;
        this.a102estadoregistro = a102estadoregistro;
        this.a102usuariocreacion = a102usuariocreacion;
    }

    public Integer getA102codigo() {
        return a102codigo;
    }

    public void setA102codigo(Integer a102codigo) {
        this.a102codigo = a102codigo;
    }

    public String getA102valor() {
        return a102valor;
    }

    public void setA102valor(String a102valor) {
        this.a102valor = a102valor;
    }

    public String getA102valorcorto() {
        return a102valorcorto;
    }

    public void setA102valorcorto(String a102valorcorto) {
        this.a102valorcorto = a102valorcorto;
    }

    public Character getA102estadoregistro() {
        return a102estadoregistro;
    }

    public void setA102estadoregistro(Character a102estadoregistro) {
        this.a102estadoregistro = a102estadoregistro;
    }

    public Date getA102fechacreacion() {
        return a102fechacreacion;
    }

    public void setA102fechacreacion(Date a102fechacreacion) {
        this.a102fechacreacion = a102fechacreacion;
    }

    public Date getA102fechamodificacion() {
        return a102fechamodificacion;
    }

    public void setA102fechamodificacion(Date a102fechamodificacion) {
        this.a102fechamodificacion = a102fechamodificacion;
    }

    public int getA102usuariocreacion() {
        return a102usuariocreacion;
    }

    public void setA102usuariocreacion(int a102usuariocreacion) {
        this.a102usuariocreacion = a102usuariocreacion;
    }

    public Integer getA102usuariomodificacion() {
        return a102usuariomodificacion;
    }

    public void setA102usuariomodificacion(Integer a102usuariomodificacion) {
        this.a102usuariomodificacion = a102usuariomodificacion;
    }

    public Categoria getA102categoria() {
        return a102categoria;
    }

    public void setA102categoria(Categoria a102categoria) {
        this.a102categoria = a102categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a102codigo != null ? a102codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.a102codigo == null && other.a102codigo != null) || (this.a102codigo != null && !this.a102codigo.equals(other.a102codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mads.gestor.comun.entidades.Lista[ a102codigo=" + a102codigo + " ]";
    }
    
}
