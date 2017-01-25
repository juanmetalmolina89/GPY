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
@Table(name = "GPYT_T034_TIPO_INDICADOR", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIndicador.findAll", query = "SELECT t FROM TipoIndicador t")})
public class TipoIndicador implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a011idtipindcdr")
    private Collection<Indicador> indicadorCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A034CODIGO")
    private Integer a034codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A034DESCTIPINDCDR")
    private String a034desctipindcdr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A034ESTADOREGISTRO")
    private Character a034estadoregistro;
    @Column(name = "A034FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a034fechacreacion;
    @Column(name = "A034FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a034fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A034USUARIOCREACION")
    private int a034usuariocreacion;
    @Column(name = "A034USUARIOMODIFICACION")
    private Integer a034usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a011idtipindcdr")
//    private List<Indicador> indicadorList;
    @JoinColumn(name = "A034IDTIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a034idtipproyct;

    public TipoIndicador() {
    }

    public TipoIndicador(Integer a034codigo) {
        this.a034codigo = a034codigo;
    }

    public TipoIndicador(Integer a034codigo, String a034desctipindcdr, Character a034estadoregistro, int a034usuariocreacion) {
        this.a034codigo = a034codigo;
        this.a034desctipindcdr = a034desctipindcdr;
        this.a034estadoregistro = a034estadoregistro;
        this.a034usuariocreacion = a034usuariocreacion;
    }

    public Integer getA034codigo() {
        return a034codigo;
    }

    public void setA034codigo(Integer a034codigo) {
        this.a034codigo = a034codigo;
    }

    public String getA034desctipindcdr() {
        return a034desctipindcdr;
    }

    public void setA034desctipindcdr(String a034desctipindcdr) {
        this.a034desctipindcdr = a034desctipindcdr;
    }

    public Character getA034estadoregistro() {
        return a034estadoregistro;
    }

    public void setA034estadoregistro(Character a034estadoregistro) {
        this.a034estadoregistro = a034estadoregistro;
    }

    public Date getA034fechacreacion() {
        return a034fechacreacion;
    }

    public void setA034fechacreacion(Date a034fechacreacion) {
        this.a034fechacreacion = a034fechacreacion;
    }

    public Date getA034fechamodificacion() {
        return a034fechamodificacion;
    }

    public void setA034fechamodificacion(Date a034fechamodificacion) {
        this.a034fechamodificacion = a034fechamodificacion;
    }

    public int getA034usuariocreacion() {
        return a034usuariocreacion;
    }

    public void setA034usuariocreacion(int a034usuariocreacion) {
        this.a034usuariocreacion = a034usuariocreacion;
    }

    public Integer getA034usuariomodificacion() {
        return a034usuariomodificacion;
    }

    public void setA034usuariomodificacion(Integer a034usuariomodificacion) {
        this.a034usuariomodificacion = a034usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Indicador> getIndicadorList() {
//        return indicadorList;
//    }
//
//    public void setIndicadorList(List<Indicador> indicadorList) {
//        this.indicadorList = indicadorList;
//    }

    public Lista getA034idtipproyct() {
        return a034idtipproyct;
    }

    public void setA034idtipproyct(Lista a034idtipproyct) {
        this.a034idtipproyct = a034idtipproyct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a034codigo != null ? a034codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIndicador)) {
            return false;
        }
        TipoIndicador other = (TipoIndicador) object;
        if ((this.a034codigo == null && other.a034codigo != null) || (this.a034codigo != null && !this.a034codigo.equals(other.a034codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.TipoIndicador[ a034codigo=" + a034codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Indicador> getIndicadorCollection() {
        return indicadorCollection;
    }

    public void setIndicadorCollection(Collection<Indicador> indicadorCollection) {
        this.indicadorCollection = indicadorCollection;
    }
    
}
