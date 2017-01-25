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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeimmy Lee
 */
@Entity
@Table(name = "GPYT_T053_REPLEGAL", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepLegal.findAll", query = "SELECT r FROM RepLegal r")})
public class RepLegal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A053CODIGO")
    private Integer a053codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A053ESTADOREGISTRO")
    private Character a053estadoregistro;
    @Column(name = "A053FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a053fechacreacion;
    @Column(name = "A053FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a053fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A053USUARIOCREACION")
    private int a053usuariocreacion;
    @Column(name = "A053USUARIOMODIFICACION")
    private Integer a053usuariomodificacion;
    @JoinColumn(name = "A053IDARCHIVO", referencedColumnName = "A026CODIGO")
    @ManyToOne(optional = false)
    private Archivo a053idarchivo;
    @JoinColumn(name = "A053IDREPRESENTANTE", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a053idrepresentante;
    @JoinColumn(name = "A053IDPERSONAJURD", referencedColumnName = "A052CODIGO")
    @ManyToOne(optional = false)
    private Persona a053idpersonajurd;
    @JoinColumn(name = "A053TIPOREPRESENTANTE", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a053tiporepresentante;

    public RepLegal() {
    }

    public RepLegal(Integer a053codigo) {
        this.a053codigo = a053codigo;
    }

    public RepLegal(Integer a053codigo, Character a053estadoregistro, int a053usuariocreacion) {
        this.a053codigo = a053codigo;
        this.a053estadoregistro = a053estadoregistro;
        this.a053usuariocreacion = a053usuariocreacion;
    }

    public Integer getA053codigo() {
        return a053codigo;
    }

    public void setA053codigo(Integer a053codigo) {
        this.a053codigo = a053codigo;
    }

    public Character getA053estadoregistro() {
        return a053estadoregistro;
    }

    public void setA053estadoregistro(Character a053estadoregistro) {
        this.a053estadoregistro = a053estadoregistro;
    }

    public Date getA053fechacreacion() {
        return a053fechacreacion;
    }

    public void setA053fechacreacion(Date a053fechacreacion) {
        this.a053fechacreacion = a053fechacreacion;
    }

    public Date getA053fechamodificacion() {
        return a053fechamodificacion;
    }

    public void setA053fechamodificacion(Date a053fechamodificacion) {
        this.a053fechamodificacion = a053fechamodificacion;
    }

    public int getA053usuariocreacion() {
        return a053usuariocreacion;
    }

    public void setA053usuariocreacion(int a053usuariocreacion) {
        this.a053usuariocreacion = a053usuariocreacion;
    }

    public Integer getA053usuariomodificacion() {
        return a053usuariomodificacion;
    }

    public void setA053usuariomodificacion(Integer a053usuariomodificacion) {
        this.a053usuariomodificacion = a053usuariomodificacion;
    }

    public Archivo getA053idarchivo() {
        return a053idarchivo;
    }

    public void setA053idarchivo(Archivo a053idarchivo) {
        this.a053idarchivo = a053idarchivo;
    }

    public Persona getA053idrepresentante() {
        return a053idrepresentante;
    }

    public void setA053idrepresentante(Persona a053idrepresentante) {
        this.a053idrepresentante = a053idrepresentante;
    }

    public Persona getA053idpersonajurd() {
        return a053idpersonajurd;
    }

    public void setA053idpersonajurd(Persona a053idpersonajurd) {
        this.a053idpersonajurd = a053idpersonajurd;
    }

    public Lista getA053tiporepresentante() {
        return a053tiporepresentante;
    }

    public void setA053tiporepresentante(Lista a053tiporepresentante) {
        this.a053tiporepresentante = a053tiporepresentante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a053codigo != null ? a053codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepLegal)) {
            return false;
        }
        RepLegal other = (RepLegal) object;
        if ((this.a053codigo == null && other.a053codigo != null) || (this.a053codigo != null && !this.a053codigo.equals(other.a053codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.RepLegal[ a053codigo=" + a053codigo + " ]";
    }
    
}
