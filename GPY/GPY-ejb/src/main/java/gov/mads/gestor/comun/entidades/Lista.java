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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a009idtipinstrmntf")
    private Collection<InstrmntFinnccn> instrmntFinnccnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a025idtipproyct")
    private Collection<Adjunto> adjuntoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a010idescala")
    private Collection<ReporteAnioFuente> reporteAnioFuenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a015idtippersn")
    private Collection<TipoDocumento> tipoDocumentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a022idtipproyct")
    private Collection<TipoActividad> tipoActividadCollection;
    @OneToMany(mappedBy = "a022idtipproyctmdl")
    private Collection<TipoActividad> tipoActividadCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a023idtipproyct")
    private Collection<SectorImplementador> sectorImplementadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a044estdespues")
    private Collection<CambiosEstado> cambiosEstadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a044estantes")
    private Collection<CambiosEstado> cambiosEstadoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a036idtipproyct")
    private Collection<TipoActivRemocion> tipoActivRemocionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053tiporepresentante")
    private Collection<RepLegal> repLegalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a028idescl")
    private Collection<MetodologiaMdl> metodologiaMdlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a004idfuntfinnccn")
    private Collection<ProyFteFinanc> proyFteFinancCollection;
    @OneToMany(mappedBy = "a002idestdprocsvaldcn")
    private Collection<Proyecto> proyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idalcance")
    private Collection<Proyecto> proyectoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002ubccn")
    private Collection<Proyecto> proyectoCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002estadoproyecto")
    private Collection<Proyecto> proyectoCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002tipproyct")
    private Collection<Proyecto> proyectoCollection4;
    @OneToMany(mappedBy = "a002idproyctmdl")
    private Collection<Proyecto> proyectoCollection5;
    @OneToMany(mappedBy = "a002idtipperdacrdtcn")
    private Collection<Proyecto> proyectoCollection6;
    @OneToMany(mappedBy = "a002idestndrmercdvolntr")
    private Collection<Proyecto> proyectoCollection7;
    @OneToMany(mappedBy = "a002idescala")
    private Collection<Proyecto> proyectoCollection8;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052tipdocmnt")
    private Collection<Persona> personaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a034idtipproyct")
    private Collection<TipoIndicador> tipoIndicadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002tipproyct")
    private Collection<TipoAccion> gpytT050TipoAccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041idclasusr")
    private Collection<Usuario> usuarioCollection;

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
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a022idtipproyctmdl")
//    private Collection<TipoActividad> tipoActividadCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041idtippersn")
//    private Collection<Usuario> usuarioCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041idclasusr")
//    private Collection<Usuario> usuarioCollection1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041tipdocmnt")
//    private Collection<Usuario> usuarioCollection2;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a028idescl")
//    private Collection<MetodologiaMdl> metodologiaMdlCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a009idtipinstrmntf")
//    private Collection<InstrmntFinnccn> instrmntFinnccnCollection;
    @JoinColumn(name = "A102CATEGORIA", referencedColumnName = "A101CODIGO")
    @ManyToOne(optional = false)
    private Categoria a102categoria;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a010idescala")
//    private Collection<ReporteAnioFuente> reporteAnioFuenteCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idtipperdacrdtcn")
//    private Collection<Proyecto> proyectoCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idproyctmdl")
//    private Collection<Proyecto> proyectoCollection1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idestdprocsvaldcn")
//    private Collection<Proyecto> proyectoCollection2;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002ubccn")
//    private Collection<Proyecto> proyectoCollection3;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002tipproyct")
//    private Collection<Proyecto> proyectoCollection4;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002estndrmercdvolntr")
//    private Collection<Proyecto> proyectoCollection5;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002estadoproyecto")
//    private Collection<Proyecto> proyectoCollection6;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idescala")
//    private Collection<Proyecto> proyectoCollection7;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a023idtipproyct")
//    private Collection<SectorImplementador> sectorImplementadorCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a034idtipproyct")
//    private Collection<TipoIndicador> tipoIndicadorCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a044estdespues")
//    private Collection<CambiosEstado> cambiosEstadoCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a044estantes")
//    private Collection<CambiosEstado> cambiosEstadoCollection1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a004idfuntfinnccn")
//    private Collection<ProyFteFinanc> proyFteFinancCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a025idtipproyct")
//    private Collection<Adjunto> adjuntoCollection;

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

//    @XmlTransient
//    @JsonIgnore
//    public Collection<TipoActividad> getTipoActividadCollection() {
//        return tipoActividadCollection;
//    }
//
//    public void setTipoActividadCollection(Collection<TipoActividad> tipoActividadCollection) {
//        this.tipoActividadCollection = tipoActividadCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Usuario> getUsuarioCollection() {
//        return usuarioCollection;
//    }
//
//    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
//        this.usuarioCollection = usuarioCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Usuario> getUsuarioCollection1() {
//        return usuarioCollection1;
//    }
//
//    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
//        this.usuarioCollection1 = usuarioCollection1;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Usuario> getUsuarioCollection2() {
//        return usuarioCollection2;
//    }
//
//    public void setUsuarioCollection2(Collection<Usuario> usuarioCollection2) {
//        this.usuarioCollection2 = usuarioCollection2;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<MetodologiaMdl> getMetodologiaMdlCollection() {
//        return metodologiaMdlCollection;
//    }
//
//    public void setMetodologiaMdlCollection(Collection<MetodologiaMdl> metodologiaMdlCollection) {
//        this.metodologiaMdlCollection = metodologiaMdlCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<InstrmntFinnccn> getInstrmntFinnccnCollection() {
//        return instrmntFinnccnCollection;
//    }
//
//    public void setInstrmntFinnccnCollection(Collection<InstrmntFinnccn> instrmntFinnccnCollection) {
//        this.instrmntFinnccnCollection = instrmntFinnccnCollection;
//    }

    public Categoria getA102categoria() {
        return a102categoria;
    }

    public void setA102categoria(Categoria a102categoria) {
        this.a102categoria = a102categoria;
    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<ReporteAnioFuente> getReporteAnioFuenteCollection() {
//        return reporteAnioFuenteCollection;
//    }
//
//    public void setReporteAnioFuenteCollection(Collection<ReporteAnioFuente> reporteAnioFuenteCollection) {
//        this.reporteAnioFuenteCollection = reporteAnioFuenteCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection() {
//        return proyectoCollection;
//    }
//
//    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
//        this.proyectoCollection = proyectoCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection1() {
//        return proyectoCollection1;
//    }
//
//    public void setProyectoCollection1(Collection<Proyecto> proyectoCollection1) {
//        this.proyectoCollection1 = proyectoCollection1;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection2() {
//        return proyectoCollection2;
//    }
//
//    public void setProyectoCollection2(Collection<Proyecto> proyectoCollection2) {
//        this.proyectoCollection2 = proyectoCollection2;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection3() {
//        return proyectoCollection3;
//    }
//
//    public void setProyectoCollection3(Collection<Proyecto> proyectoCollection3) {
//        this.proyectoCollection3 = proyectoCollection3;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection4() {
//        return proyectoCollection4;
//    }
//
//    public void setProyectoCollection4(Collection<Proyecto> proyectoCollection4) {
//        this.proyectoCollection4 = proyectoCollection4;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection5() {
//        return proyectoCollection5;
//    }
//
//    public void setProyectoCollection5(Collection<Proyecto> proyectoCollection5) {
//        this.proyectoCollection5 = proyectoCollection5;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection6() {
//        return proyectoCollection6;
//    }
//
//    public void setProyectoCollection6(Collection<Proyecto> proyectoCollection6) {
//        this.proyectoCollection6 = proyectoCollection6;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Proyecto> getProyectoCollection7() {
//        return proyectoCollection7;
//    }
//
//    public void setProyectoCollection7(Collection<Proyecto> proyectoCollection7) {
//        this.proyectoCollection7 = proyectoCollection7;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<SectorImplementador> getSectorImplementadorCollection() {
//        return sectorImplementadorCollection;
//    }
//
//    public void setSectorImplementadorCollection(Collection<SectorImplementador> sectorImplementadorCollection) {
//        this.sectorImplementadorCollection = sectorImplementadorCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<TipoIndicador> getTipoIndicadorCollection() {
//        return tipoIndicadorCollection;
//    }
//
//    public void setTipoIndicadorCollection(Collection<TipoIndicador> tipoIndicadorCollection) {
//        this.tipoIndicadorCollection = tipoIndicadorCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<CambiosEstado> getCambiosEstadoCollection() {
//        return cambiosEstadoCollection;
//    }
//
//    public void setCambiosEstadoCollection(Collection<CambiosEstado> cambiosEstadoCollection) {
//        this.cambiosEstadoCollection = cambiosEstadoCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<CambiosEstado> getCambiosEstadoCollection1() {
//        return cambiosEstadoCollection1;
//    }
//
//    public void setCambiosEstadoCollection1(Collection<CambiosEstado> cambiosEstadoCollection1) {
//        this.cambiosEstadoCollection1 = cambiosEstadoCollection1;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<ProyFteFinanc> getProyFteFinancCollection() {
//        return proyFteFinancCollection;
//    }
//
//    public void setProyFteFinancCollection(Collection<ProyFteFinanc> proyFteFinancCollection) {
//        this.proyFteFinancCollection = proyFteFinancCollection;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public Collection<Adjunto> getAdjuntoCollection() {
//        return adjuntoCollection;
//    }
//
//    public void setAdjuntoCollection(Collection<Adjunto> adjuntoCollection) {
//        this.adjuntoCollection = adjuntoCollection;
//    }

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

    @XmlTransient
    @JsonIgnore
    public Collection<InstrmntFinnccn> getInstrmntFinnccnCollection() {
        return instrmntFinnccnCollection;
    }

    public void setInstrmntFinnccnCollection(Collection<InstrmntFinnccn> instrmntFinnccnCollection) {
        this.instrmntFinnccnCollection = instrmntFinnccnCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Adjunto> getAdjuntoCollection() {
        return adjuntoCollection;
    }

    public void setAdjuntoCollection(Collection<Adjunto> adjuntoCollection) {
        this.adjuntoCollection = adjuntoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ReporteAnioFuente> getReporteAnioFuenteCollection() {
        return reporteAnioFuenteCollection;
    }

    public void setReporteAnioFuenteCollection(Collection<ReporteAnioFuente> reporteAnioFuenteCollection) {
        this.reporteAnioFuenteCollection = reporteAnioFuenteCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TipoDocumento> getTipoDocumentoCollection() {
        return tipoDocumentoCollection;
    }

    public void setTipoDocumentoCollection(Collection<TipoDocumento> tipoDocumentoCollection) {
        this.tipoDocumentoCollection = tipoDocumentoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TipoActividad> getTipoActividadCollection() {
        return tipoActividadCollection;
    }

    public void setTipoActividadCollection(Collection<TipoActividad> tipoActividadCollection) {
        this.tipoActividadCollection = tipoActividadCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TipoActividad> getTipoActividadCollection1() {
        return tipoActividadCollection1;
    }

    public void setTipoActividadCollection1(Collection<TipoActividad> tipoActividadCollection1) {
        this.tipoActividadCollection1 = tipoActividadCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<SectorImplementador> getSectorImplementadorCollection() {
        return sectorImplementadorCollection;
    }

    public void setSectorImplementadorCollection(Collection<SectorImplementador> sectorImplementadorCollection) {
        this.sectorImplementadorCollection = sectorImplementadorCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CambiosEstado> getCambiosEstadoCollection() {
        return cambiosEstadoCollection;
    }

    public void setCambiosEstadoCollection(Collection<CambiosEstado> cambiosEstadoCollection) {
        this.cambiosEstadoCollection = cambiosEstadoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CambiosEstado> getCambiosEstadoCollection1() {
        return cambiosEstadoCollection1;
    }

    public void setCambiosEstadoCollection1(Collection<CambiosEstado> cambiosEstadoCollection1) {
        this.cambiosEstadoCollection1 = cambiosEstadoCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TipoActivRemocion> getTipoActivRemocionCollection() {
        return tipoActivRemocionCollection;
    }

    public void setTipoActivRemocionCollection(Collection<TipoActivRemocion> tipoActivRemocionCollection) {
        this.tipoActivRemocionCollection = tipoActivRemocionCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<RepLegal> getRepLegalCollection() {
        return repLegalCollection;
    }

    public void setRepLegalCollection(Collection<RepLegal> repLegalCollection) {
        this.repLegalCollection = repLegalCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MetodologiaMdl> getMetodologiaMdlCollection() {
        return metodologiaMdlCollection;
    }

    public void setMetodologiaMdlCollection(Collection<MetodologiaMdl> metodologiaMdlCollection) {
        this.metodologiaMdlCollection = metodologiaMdlCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProyFteFinanc> getProyFteFinancCollection() {
        return proyFteFinancCollection;
    }

    public void setProyFteFinancCollection(Collection<ProyFteFinanc> proyFteFinancCollection) {
        this.proyFteFinancCollection = proyFteFinancCollection;
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
    public Collection<Proyecto> getProyectoCollection1() {
        return proyectoCollection1;
    }

    public void setProyectoCollection1(Collection<Proyecto> proyectoCollection1) {
        this.proyectoCollection1 = proyectoCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection2() {
        return proyectoCollection2;
    }

    public void setProyectoCollection2(Collection<Proyecto> proyectoCollection2) {
        this.proyectoCollection2 = proyectoCollection2;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection3() {
        return proyectoCollection3;
    }

    public void setProyectoCollection3(Collection<Proyecto> proyectoCollection3) {
        this.proyectoCollection3 = proyectoCollection3;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection4() {
        return proyectoCollection4;
    }

    public void setProyectoCollection4(Collection<Proyecto> proyectoCollection4) {
        this.proyectoCollection4 = proyectoCollection4;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection5() {
        return proyectoCollection5;
    }

    public void setProyectoCollection5(Collection<Proyecto> proyectoCollection5) {
        this.proyectoCollection5 = proyectoCollection5;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection6() {
        return proyectoCollection6;
    }

    public void setProyectoCollection6(Collection<Proyecto> proyectoCollection6) {
        this.proyectoCollection6 = proyectoCollection6;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection7() {
        return proyectoCollection7;
    }

    public void setProyectoCollection7(Collection<Proyecto> proyectoCollection7) {
        this.proyectoCollection7 = proyectoCollection7;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Proyecto> getProyectoCollection8() {
        return proyectoCollection8;
    }

    public void setProyectoCollection8(Collection<Proyecto> proyectoCollection8) {
        this.proyectoCollection8 = proyectoCollection8;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TipoIndicador> getTipoIndicadorCollection() {
        return tipoIndicadorCollection;
    }

    public void setTipoIndicadorCollection(Collection<TipoIndicador> tipoIndicadorCollection) {
        this.tipoIndicadorCollection = tipoIndicadorCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TipoAccion> getGpytT050TipoAccionCollection() {
        return gpytT050TipoAccionCollection;
    }

    public void setGpytT050TipoAccionCollection(Collection<TipoAccion> gpytT050TipoAccionCollection) {
        this.gpytT050TipoAccionCollection = gpytT050TipoAccionCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }
    
}
