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
@Table(name = "GPYT_T026_ARCHIVO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")})
public class Archivo implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a013idarchv")
    private List<AvanceProyecto> avanceProyectoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a008idarchv")
    private List<ProyAdjunto> proyAdjuntoList;
    @OneToMany(mappedBy = "a053idarchivo")
    private List<RepLegal> repLegalList;
    @OneToMany(mappedBy = "a005idsoportecalculo")
    private List<Actividad> actividadList;
    @OneToMany(mappedBy = "a005idsoporte")
    private List<Actividad> actividadList1;
    @OneToMany(mappedBy = "a003idarchiv")
    private List<Politica> politicaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A026CODIGO")
    private Integer a026codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A026DESCRPCNARCHIV")
    private String a026descrpcnarchiv;
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A026HASHARCHIVO")
    private String a026hasharchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A026NOMARCHIVO")
    private String a026nomarchivo;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A026RUTARCHIV")
    private String a026rutarchiv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A026ESTADOREGISTRO")
    private Character a026estadoregistro;
    @Column(name = "A026FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a026fechacreacion;
    @Column(name = "A026FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a026fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A026USUARIOCREACION")
    private int a026usuariocreacion;
    @Column(name = "A026USUARIOMODIFICACION")
    private Integer a026usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a008idarchv")
//    private List<ProyAdjunto> proyAdjuntoList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053idarchivo")
//    private List<RepLegal> repLegalList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a007idarchiv")
//    private List<Politica> politicaList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a005idsoporte")
//    private List<Actividad> actividadList;

    public Archivo() {
    }

    public Archivo(Integer a026codigo) {
        this.a026codigo = a026codigo;
    }

    public Archivo(Integer a026codigo, String a026descrpcnarchiv, String a026rutarchiv, Character a026estadoregistro, int a026usuariocreacion) {
        this.a026codigo = a026codigo;
        this.a026descrpcnarchiv = a026descrpcnarchiv;
        this.a026rutarchiv = a026rutarchiv;
        this.a026estadoregistro = a026estadoregistro;
        this.a026usuariocreacion = a026usuariocreacion;
    }

    public Integer getA026codigo() {
        return a026codigo;
    }

    public void setA026codigo(Integer a026codigo) {
        this.a026codigo = a026codigo;
    }

    public String getA026descrpcnarchiv() {
        return a026descrpcnarchiv;
    }

    public void setA026descrpcnarchiv(String a026descrpcnarchiv) {
        this.a026descrpcnarchiv = a026descrpcnarchiv;
    }

    public String getA026hasharchivo() {
        return a026hasharchivo;
    }

    public void setA026hasharchivo(String a026hasharchivo) {
        this.a026hasharchivo = a026hasharchivo;
    }

    public String getA026nomarchivo() {
        return a026nomarchivo;
    }

    public void setA026nomarchivo(String a026nomarchivo) {
        this.a026nomarchivo = a026nomarchivo;
    }

    public String getA026rutarchiv() {
        return a026rutarchiv;
    }

    public void setA026rutarchiv(String a026rutarchiv) {
        this.a026rutarchiv = a026rutarchiv;
    }

    public Character getA026estadoregistro() {
        return a026estadoregistro;
    }

    public void setA026estadoregistro(Character a026estadoregistro) {
        this.a026estadoregistro = a026estadoregistro;
    }

    public Date getA026fechacreacion() {
        return a026fechacreacion;
    }

    public void setA026fechacreacion(Date a026fechacreacion) {
        this.a026fechacreacion = a026fechacreacion;
    }

    public Date getA026fechamodificacion() {
        return a026fechamodificacion;
    }

    public void setA026fechamodificacion(Date a026fechamodificacion) {
        this.a026fechamodificacion = a026fechamodificacion;
    }

    public int getA026usuariocreacion() {
        return a026usuariocreacion;
    }

    public void setA026usuariocreacion(int a026usuariocreacion) {
        this.a026usuariocreacion = a026usuariocreacion;
    }

    public Integer getA026usuariomodificacion() {
        return a026usuariomodificacion;
    }

    public void setA026usuariomodificacion(Integer a026usuariomodificacion) {
        this.a026usuariomodificacion = a026usuariomodificacion;
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
//
//    @XmlTransient
//    @JsonIgnore
//    public List<RepLegal> getRepLegalList() {
//        return repLegalList;
//    }
//
//    public void setRepLegalList(List<RepLegal> repLegalList) {
//        this.repLegalList = repLegalList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<Politica> getPoliticaList() {
//        return politicaList;
//    }
//
//    public void setPoliticaList(List<Politica> politicaList) {
//        this.politicaList = politicaList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<Actividad> getActividadList() {
//        return actividadList;
//    }
//
//    public void setActividadList(List<Actividad> actividadList) {
//        this.actividadList = actividadList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a026codigo != null ? a026codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.a026codigo == null && other.a026codigo != null) || (this.a026codigo != null && !this.a026codigo.equals(other.a026codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Archivo[ a026codigo=" + a026codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<ProyAdjunto> getProyAdjuntoList() {
        return proyAdjuntoList;
    }

    public void setProyAdjuntoList(List<ProyAdjunto> proyAdjuntoList) {
        this.proyAdjuntoList = proyAdjuntoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RepLegal> getRepLegalList() {
        return repLegalList;
    }

    public void setRepLegalList(List<RepLegal> repLegalList) {
        this.repLegalList = repLegalList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Actividad> getActividadList1() {
        return actividadList1;
    }

    public void setActividadList1(List<Actividad> actividadList1) {
        this.actividadList1 = actividadList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Politica> getPoliticaList() {
        return politicaList;
    }

    public void setPoliticaList(List<Politica> politicaList) {
        this.politicaList = politicaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<AvanceProyecto> getAvanceProyectoList() {
        return avanceProyectoList;
    }

    public void setAvanceProyectoList(List<AvanceProyecto> avanceProyectoList) {
        this.avanceProyectoList = avanceProyectoList;
    }
    
}
