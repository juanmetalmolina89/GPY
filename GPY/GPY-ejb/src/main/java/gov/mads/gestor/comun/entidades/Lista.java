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
    private List<InstrmntFinnccn> instrmntFinnccnList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a025idtipproyct")
    private List<Adjunto> adjuntoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a015idtippersn")
    private List<TipoDocumento> tipoDocumentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a022idtipproyct")
    private List<TipoActividad> tipoActividadList;
    @OneToMany(mappedBy = "a022idtipproyctmdl")
    private List<TipoActividad> tipoActividadList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a046idtipoproyectomdl")
    private List<CategoriaIpcc> categoriaIpccList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a023idtipproyct")
    private List<SectorImplementador> sectorImplementadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a044estdespues")
    private List<CambiosEstado> cambiosEstadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a044estantes")
    private List<CambiosEstado> cambiosEstadoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a036idtipproyct")
    private List<TipoActivRemocion> tipoActivRemocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053tiporepresentante")
    private List<RepLegal> repLegalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a028idescl")
    private List<MetodologiaMdl> metodologiaMdlList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a028idsectoralscope")
    private List<MetodologiaMdl> metodologiaMdlList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a004idfuntfinnccn")
    private List<ProyFteFinanc> proyFteFinancList;
    @OneToMany(mappedBy = "a005idmtdcalcreduccbaseline")
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a103categoria")
    private List<Reporte> reporteList;
    @OneToMany(mappedBy = "a002idestdprocsvaldcn")
    private List<Proyecto> proyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002estadoproyecto")
    private List<Proyecto> proyectoList1;
    @OneToMany(mappedBy = "a002idescala")
    private List<Proyecto> proyectoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002idalcance")
    private List<Proyecto> proyectoList3;
    @OneToMany(mappedBy = "a002idsectoralscope")
    private List<Proyecto> proyectoList4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002ubccn")
    private List<Proyecto> proyectoList5;
    @OneToMany(mappedBy = "a002idestndrmercdvolntr")
    private List<Proyecto> proyectoList6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002tipproyct")
    private List<Proyecto> proyectoList7;
    @OneToMany(mappedBy = "a002idproyctmdl")
    private List<Proyecto> proyectoList8;
    @OneToMany(mappedBy = "a002idtipperdacrdtcn")
    private List<Proyecto> proyectoList9;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a052idtippersn")
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a034idtipproyct")
    private List<TipoIndicador> tipoIndicadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a002tipproyct")
    private List<TipoAccion> tipoAccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041idclasusr")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a058tipproyct")
    private List<TipoActivReduccion> tipoActivReduccionList;

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

    @XmlTransient
    @JsonIgnore
    public List<InstrmntFinnccn> getInstrmntFinnccnList() {
        return instrmntFinnccnList;
    }

    public void setInstrmntFinnccnList(List<InstrmntFinnccn> instrmntFinnccnList) {
        this.instrmntFinnccnList = instrmntFinnccnList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adjunto> getAdjuntoList() {
        return adjuntoList;
    }

    public void setAdjuntoList(List<Adjunto> adjuntoList) {
        this.adjuntoList = adjuntoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoDocumento> getTipoDocumentoList() {
        return tipoDocumentoList;
    }

    public void setTipoDocumentoList(List<TipoDocumento> tipoDocumentoList) {
        this.tipoDocumentoList = tipoDocumentoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoActividad> getTipoActividadList() {
        return tipoActividadList;
    }

    public void setTipoActividadList(List<TipoActividad> tipoActividadList) {
        this.tipoActividadList = tipoActividadList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoActividad> getTipoActividadList1() {
        return tipoActividadList1;
    }

    public void setTipoActividadList1(List<TipoActividad> tipoActividadList1) {
        this.tipoActividadList1 = tipoActividadList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<CategoriaIpcc> getCategoriaIpccList() {
        return categoriaIpccList;
    }

    public void setCategoriaIpccList(List<CategoriaIpcc> categoriaIpccList) {
        this.categoriaIpccList = categoriaIpccList;
    }

    @XmlTransient
    @JsonIgnore
    public List<SectorImplementador> getSectorImplementadorList() {
        return sectorImplementadorList;
    }

    public void setSectorImplementadorList(List<SectorImplementador> sectorImplementadorList) {
        this.sectorImplementadorList = sectorImplementadorList;
    }

    @XmlTransient
    @JsonIgnore
    public List<CambiosEstado> getCambiosEstadoList() {
        return cambiosEstadoList;
    }

    public void setCambiosEstadoList(List<CambiosEstado> cambiosEstadoList) {
        this.cambiosEstadoList = cambiosEstadoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<CambiosEstado> getCambiosEstadoList1() {
        return cambiosEstadoList1;
    }

    public void setCambiosEstadoList1(List<CambiosEstado> cambiosEstadoList1) {
        this.cambiosEstadoList1 = cambiosEstadoList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoActivRemocion> getTipoActivRemocionList() {
        return tipoActivRemocionList;
    }

    public void setTipoActivRemocionList(List<TipoActivRemocion> tipoActivRemocionList) {
        this.tipoActivRemocionList = tipoActivRemocionList;
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
    public List<MetodologiaMdl> getMetodologiaMdlList() {
        return metodologiaMdlList;
    }

    public void setMetodologiaMdlList(List<MetodologiaMdl> metodologiaMdlList) {
        this.metodologiaMdlList = metodologiaMdlList;
    }

    @XmlTransient
    @JsonIgnore
    public List<MetodologiaMdl> getMetodologiaMdlList1() {
        return metodologiaMdlList1;
    }

    public void setMetodologiaMdlList1(List<MetodologiaMdl> metodologiaMdlList1) {
        this.metodologiaMdlList1 = metodologiaMdlList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<ProyFteFinanc> getProyFteFinancList() {
        return proyFteFinancList;
    }

    public void setProyFteFinancList(List<ProyFteFinanc> proyFteFinancList) {
        this.proyFteFinancList = proyFteFinancList;
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
    public List<Reporte> getReporteList() {
        return reporteList;
    }

    public void setReporteList(List<Reporte> reporteList) {
        this.reporteList = reporteList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList1() {
        return proyectoList1;
    }

    public void setProyectoList1(List<Proyecto> proyectoList1) {
        this.proyectoList1 = proyectoList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList2() {
        return proyectoList2;
    }

    public void setProyectoList2(List<Proyecto> proyectoList2) {
        this.proyectoList2 = proyectoList2;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList3() {
        return proyectoList3;
    }

    public void setProyectoList3(List<Proyecto> proyectoList3) {
        this.proyectoList3 = proyectoList3;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList4() {
        return proyectoList4;
    }

    public void setProyectoList4(List<Proyecto> proyectoList4) {
        this.proyectoList4 = proyectoList4;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList5() {
        return proyectoList5;
    }

    public void setProyectoList5(List<Proyecto> proyectoList5) {
        this.proyectoList5 = proyectoList5;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList6() {
        return proyectoList6;
    }

    public void setProyectoList6(List<Proyecto> proyectoList6) {
        this.proyectoList6 = proyectoList6;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList7() {
        return proyectoList7;
    }

    public void setProyectoList7(List<Proyecto> proyectoList7) {
        this.proyectoList7 = proyectoList7;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList8() {
        return proyectoList8;
    }

    public void setProyectoList8(List<Proyecto> proyectoList8) {
        this.proyectoList8 = proyectoList8;
    }

    @XmlTransient
    @JsonIgnore
    public List<Proyecto> getProyectoList9() {
        return proyectoList9;
    }

    public void setProyectoList9(List<Proyecto> proyectoList9) {
        this.proyectoList9 = proyectoList9;
    }

    @XmlTransient
    @JsonIgnore
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoIndicador> getTipoIndicadorList() {
        return tipoIndicadorList;
    }

    public void setTipoIndicadorList(List<TipoIndicador> tipoIndicadorList) {
        this.tipoIndicadorList = tipoIndicadorList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoAccion> getTipoAccionList() {
        return tipoAccionList;
    }

    public void setTipoAccionList(List<TipoAccion> tipoAccionList) {
        this.tipoAccionList = tipoAccionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TipoActivReduccion> getTipoActivReduccionList() {
        return tipoActivReduccionList;
    }

    public void setTipoActivReduccionList(List<TipoActivReduccion> tipoActivReduccionList) {
        this.tipoActivReduccionList = tipoActivReduccionList;
    }
    
}
