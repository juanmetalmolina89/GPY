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
@Table(name = "GPYT_T025_ADJUNTO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adjunto.findAll", query = "SELECT a FROM Adjunto a")})
public class Adjunto implements Serializable {

    @JoinColumn(name = "A025IDPANTALLA", referencedColumnName = "A056CODIGO")
    @ManyToOne
    private Pantalla a025idpantalla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a008idadjnt")
    private Collection<ProyAdjunto> proyAdjuntoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A025CODIGO")
    private Integer a025codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "A025NOMBRADJNT")
    private String a025nombradjnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A025DESCRPCNADJNT")
    private String a025descrpcnadjnt;
    @Column(name = "A025ETPADJNT")
    private Short a025etpadjnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "A025APLICPCNADJNT")
    private String a025aplicpcnadjnt;
    @Size(max = 30)
    @Column(name = "A025NOMFORMATO")
    private String a025nomformato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A025ESTADOREGISTRO")
    private Character a025estadoregistro;
    @Column(name = "A025FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a025fechacreacion;
    @Column(name = "A025FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a025fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A025USUARIOCREACION")
    private int a025usuariocreacion;
    @Column(name = "A025USUARIOMODIFICACION")
    private Integer a025usuariomodificacion;
    @JoinColumn(name = "A025IDTIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a025idtipproyct;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a008idadjnt")
//    private List<ProyAdjunto> proyAdjuntoList;

    public Adjunto() {
    }

    public Adjunto(Integer a025codigo) {
        this.a025codigo = a025codigo;
    }

    public Adjunto(Integer a025codigo, String a025nombradjnt, String a025descrpcnadjnt, String a025aplicpcnadjnt, Character a025estadoregistro, int a025usuariocreacion) {
        this.a025codigo = a025codigo;
        this.a025nombradjnt = a025nombradjnt;
        this.a025descrpcnadjnt = a025descrpcnadjnt;
        this.a025aplicpcnadjnt = a025aplicpcnadjnt;
        this.a025estadoregistro = a025estadoregistro;
        this.a025usuariocreacion = a025usuariocreacion;
    }

    public Integer getA025codigo() {
        return a025codigo;
    }

    public void setA025codigo(Integer a025codigo) {
        this.a025codigo = a025codigo;
    }

    public String getA025nombradjnt() {
        return a025nombradjnt;
    }

    public void setA025nombradjnt(String a025nombradjnt) {
        this.a025nombradjnt = a025nombradjnt;
    }

    public String getA025descrpcnadjnt() {
        return a025descrpcnadjnt;
    }

    public void setA025descrpcnadjnt(String a025descrpcnadjnt) {
        this.a025descrpcnadjnt = a025descrpcnadjnt;
    }

    public Short getA025etpadjnt() {
        return a025etpadjnt;
    }

    public void setA025etpadjnt(Short a025etpadjnt) {
        this.a025etpadjnt = a025etpadjnt;
    }

    public String getA025aplicpcnadjnt() {
        return a025aplicpcnadjnt;
    }

    public void setA025aplicpcnadjnt(String a025aplicpcnadjnt) {
        this.a025aplicpcnadjnt = a025aplicpcnadjnt;
    }

    public String getA025nomformato() {
        return a025nomformato;
    }

    public void setA025nomformato(String a025nomformato) {
        this.a025nomformato = a025nomformato;
    }

    public Character getA025estadoregistro() {
        return a025estadoregistro;
    }

    public void setA025estadoregistro(Character a025estadoregistro) {
        this.a025estadoregistro = a025estadoregistro;
    }

    public Date getA025fechacreacion() {
        return a025fechacreacion;
    }

    public void setA025fechacreacion(Date a025fechacreacion) {
        this.a025fechacreacion = a025fechacreacion;
    }

    public Date getA025fechamodificacion() {
        return a025fechamodificacion;
    }

    public void setA025fechamodificacion(Date a025fechamodificacion) {
        this.a025fechamodificacion = a025fechamodificacion;
    }

    public int getA025usuariocreacion() {
        return a025usuariocreacion;
    }

    public void setA025usuariocreacion(int a025usuariocreacion) {
        this.a025usuariocreacion = a025usuariocreacion;
    }

    public Integer getA025usuariomodificacion() {
        return a025usuariomodificacion;
    }

    public void setA025usuariomodificacion(Integer a025usuariomodificacion) {
        this.a025usuariomodificacion = a025usuariomodificacion;
    }

    public Lista getA025idtipproyct() {
        return a025idtipproyct;
    }

    public void setA025idtipproyct(Lista a025idtipproyct) {
        this.a025idtipproyct = a025idtipproyct;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<ProyAdjunto> getProyAdjuntoList() {
//        return proyAdjuntoList;
//    }
//
//    public void setProyAdjuntoList(List<ProyAdjunto> proyAdjuntoList) {
//        this.proyAdjuntoList = proyAdjuntoList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a025codigo != null ? a025codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adjunto)) {
            return false;
        }
        Adjunto other = (Adjunto) object;
        if ((this.a025codigo == null && other.a025codigo != null) || (this.a025codigo != null && !this.a025codigo.equals(other.a025codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Adjunto[ a025codigo=" + a025codigo + " ]";
    }

    public Pantalla getA025idpantalla() {
        return a025idpantalla;
    }

    public void setA025idpantalla(Pantalla a025idpantalla) {
        this.a025idpantalla = a025idpantalla;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProyAdjunto> getProyAdjuntoCollection() {
        return proyAdjuntoCollection;
    }

    public void setProyAdjuntoCollection(Collection<ProyAdjunto> proyAdjuntoCollection) {
        this.proyAdjuntoCollection = proyAdjuntoCollection;
    }
    
}
