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
@Table(name = "GPYT_T052_PERSONA", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a054idpersona")
    private Collection<Contacto> contactoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a054idcontacto")
    private Collection<Contacto> contactoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a055idpersona")
    private Collection<Publicador> gpytT055PublicadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a055idpublicador")
    private Collection<Publicador> gpytT055PublicadorCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a051idpersona")
    private Collection<Participante> participanteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053idrepresentante")
    private Collection<RepLegal> repLegalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053idpersonajurd")
    private Collection<RepLegal> repLegalCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041idpersona")
    private Collection<Usuario> usuarioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A052CODIGO")
    private Integer a052codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "A052NUMRDOCMNT")
    private String a052numrdocmnt;
    @Column(name = "A052DIGTCHQU")
    private Character a052digtchqu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A052NOMBRE")
    private String a052nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "A052APELLIDO")
    private String a052apellido;
    @Size(max = 80)
    @Column(name = "A052LGREXPCNDOCMNT")
    private String a052lgrexpcndocmnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A052DIRCCNCORRSPNDNC")
    private String a052dirccncorrspndnc;
    @Size(max = 12)
    @Column(name = "A052TELEFONO")
    private String a052telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "A052CELULAR")
    private String a052celular;
    @Size(max = 40)
    @Column(name = "A052CORRELCTRNC")
    private String a052correlctrnc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A052ESTADOREGISTRO")
    private Character a052estadoregistro;
    @Column(name = "A052FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a052fechacreacion;
    @Column(name = "A052FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a052fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A052USUARIOCREACION")
    private int a052usuariocreacion;
    @Column(name = "A052USUARIOMODIFICACION")
    private Integer a052usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a054idpersona")
//    private List<Contacto> contactoList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a054idcontacto")
//    private List<Contacto> contactoList1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a051idpersona")
//    private List<Participante> participanteList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053idrepresentante")
//    private List<RepLegal> repLegalList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a053idpersonajurd")
//    private List<RepLegal> repLegalList1;
    @JoinColumn(name = "A052IDENTIDAD", referencedColumnName = "A001CODIGO")
    @ManyToOne
    private Entidad a052identidad;
    @JoinColumn(name = "A052TIPDOCMNT", referencedColumnName = "A015CODIGO")
    @ManyToOne(optional = false)
    private TipoDocumento a052tipdocmnt;
    @JoinColumn(name = "A052LOCLZCN", referencedColumnName = "A020CODIGO")
    @ManyToOne(optional = false)
    private Divipola a052loclzcn;
    @JoinColumn(name = "A052CODGCIIU", referencedColumnName = "A049CODIGO")
    @ManyToOne
    private CodigoCiiu a052codgciiu;
    @JoinColumn(name = "A052IDTIPPERSN", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a052idtippersn;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a041idpersona")
//    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(Integer a052codigo) {
        this.a052codigo = a052codigo;
    }

    public Persona(Integer a052codigo, String a052numrdocmnt, String a052nombre, String a052apellido, String a052dirccncorrspndnc, String a052celular, Character a052estadoregistro, int a052usuariocreacion) {
        this.a052codigo = a052codigo;
        this.a052numrdocmnt = a052numrdocmnt;
        this.a052nombre = a052nombre;
        this.a052apellido = a052apellido;
        this.a052dirccncorrspndnc = a052dirccncorrspndnc;
        this.a052celular = a052celular;
        this.a052estadoregistro = a052estadoregistro;
        this.a052usuariocreacion = a052usuariocreacion;
    }

    public Integer getA052codigo() {
        return a052codigo;
    }

    public void setA052codigo(Integer a052codigo) {
        this.a052codigo = a052codigo;
    }

    public String getA052numrdocmnt() {
        return a052numrdocmnt;
    }

    public void setA052numrdocmnt(String a052numrdocmnt) {
        this.a052numrdocmnt = a052numrdocmnt;
    }

    public Character getA052digtchqu() {
        return a052digtchqu;
    }

    public void setA052digtchqu(Character a052digtchqu) {
        this.a052digtchqu = a052digtchqu;
    }

    public String getA052nombre() {
        return a052nombre;
    }

    public void setA052nombre(String a052nombre) {
        this.a052nombre = a052nombre;
    }

    public String getA052apellido() {
        return a052apellido;
    }

    public void setA052apellido(String a052apellido) {
        this.a052apellido = a052apellido;
    }

    public String getA052lgrexpcndocmnt() {
        return a052lgrexpcndocmnt;
    }

    public void setA052lgrexpcndocmnt(String a052lgrexpcndocmnt) {
        this.a052lgrexpcndocmnt = a052lgrexpcndocmnt;
    }

    public String getA052dirccncorrspndnc() {
        return a052dirccncorrspndnc;
    }

    public void setA052dirccncorrspndnc(String a052dirccncorrspndnc) {
        this.a052dirccncorrspndnc = a052dirccncorrspndnc;
    }

    public String getA052telefono() {
        return a052telefono;
    }

    public void setA052telefono(String a052telefono) {
        this.a052telefono = a052telefono;
    }

    public String getA052celular() {
        return a052celular;
    }

    public void setA052celular(String a052celular) {
        this.a052celular = a052celular;
    }

    public String getA052correlctrnc() {
        return a052correlctrnc;
    }

    public void setA052correlctrnc(String a052correlctrnc) {
        this.a052correlctrnc = a052correlctrnc;
    }

    public Character getA052estadoregistro() {
        return a052estadoregistro;
    }

    public void setA052estadoregistro(Character a052estadoregistro) {
        this.a052estadoregistro = a052estadoregistro;
    }

    public Date getA052fechacreacion() {
        return a052fechacreacion;
    }

    public void setA052fechacreacion(Date a052fechacreacion) {
        this.a052fechacreacion = a052fechacreacion;
    }

    public Date getA052fechamodificacion() {
        return a052fechamodificacion;
    }

    public void setA052fechamodificacion(Date a052fechamodificacion) {
        this.a052fechamodificacion = a052fechamodificacion;
    }

    public int getA052usuariocreacion() {
        return a052usuariocreacion;
    }

    public void setA052usuariocreacion(int a052usuariocreacion) {
        this.a052usuariocreacion = a052usuariocreacion;
    }

    public Integer getA052usuariomodificacion() {
        return a052usuariomodificacion;
    }

    public void setA052usuariomodificacion(Integer a052usuariomodificacion) {
        this.a052usuariomodificacion = a052usuariomodificacion;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Contacto> getContactoList() {
//        return contactoList;
//    }
//
//    public void setContactoList(List<Contacto> contactoList) {
//        this.contactoList = contactoList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<Contacto> getContactoList1() {
//        return contactoList1;
//    }
//
//    public void setContactoList1(List<Contacto> contactoList1) {
//        this.contactoList1 = contactoList1;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<Participante> getParticipanteList() {
//        return participanteList;
//    }
//
//    public void setParticipanteList(List<Participante> participanteList) {
//        this.participanteList = participanteList;
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
//    public List<RepLegal> getRepLegalList1() {
//        return repLegalList1;
//    }
//
//    public void setRepLegalList1(List<RepLegal> repLegalList1) {
//        this.repLegalList1 = repLegalList1;
//    }

    public Entidad getA052identidad() {
        return a052identidad;
    }

    public void setA052identidad(Entidad a052identidad) {
        this.a052identidad = a052identidad;
    }

    public TipoDocumento getA052tipdocmnt() {
        return a052tipdocmnt;
    }

    public void setA052tipdocmnt(TipoDocumento a052tipdocmnt) {
        this.a052tipdocmnt = a052tipdocmnt;
    }

    public Divipola getA052loclzcn() {
        return a052loclzcn;
    }

    public void setA052loclzcn(Divipola a052loclzcn) {
        this.a052loclzcn = a052loclzcn;
    }

    public CodigoCiiu getA052codgciiu() {
        return a052codgciiu;
    }

    public void setA052codgciiu(CodigoCiiu a052codgciiu) {
        this.a052codgciiu = a052codgciiu;
    }

    public Lista getA052idtippersn() {
        return a052idtippersn;
    }

    public void setA052idtippersn(Lista a052idtippersn) {
        this.a052idtippersn = a052idtippersn;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Usuario> getUsuarioList() {
//        return usuarioList;
//    }
//
//    public void setUsuarioList(List<Usuario> usuarioList) {
//        this.usuarioList = usuarioList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a052codigo != null ? a052codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.a052codigo == null && other.a052codigo != null) || (this.a052codigo != null && !this.a052codigo.equals(other.a052codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Persona[ a052codigo=" + a052codigo + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Contacto> getContactoCollection() {
        return contactoCollection;
    }

    public void setContactoCollection(Collection<Contacto> contactoCollection) {
        this.contactoCollection = contactoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Contacto> getContactoCollection1() {
        return contactoCollection1;
    }

    public void setContactoCollection1(Collection<Contacto> contactoCollection1) {
        this.contactoCollection1 = contactoCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Publicador> getGpytT055PublicadorCollection() {
        return gpytT055PublicadorCollection;
    }

    public void setGpytT055PublicadorCollection(Collection<Publicador> gpytT055PublicadorCollection) {
        this.gpytT055PublicadorCollection = gpytT055PublicadorCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Publicador> getGpytT055PublicadorCollection1() {
        return gpytT055PublicadorCollection1;
    }

    public void setGpytT055PublicadorCollection1(Collection<Publicador> gpytT055PublicadorCollection1) {
        this.gpytT055PublicadorCollection1 = gpytT055PublicadorCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Participante> getParticipanteCollection() {
        return participanteCollection;
    }

    public void setParticipanteCollection(Collection<Participante> participanteCollection) {
        this.participanteCollection = participanteCollection;
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
    public Collection<RepLegal> getRepLegalCollection1() {
        return repLegalCollection1;
    }

    public void setRepLegalCollection1(Collection<RepLegal> repLegalCollection1) {
        this.repLegalCollection1 = repLegalCollection1;
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
