/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
@Table(name = "GPYT_T002_PROYECTO", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A002CODIGO")
    private Integer a002codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "A002NOMBRPROYCT")
    private String a002nombrproyct;
    @Size(max = 500)
    @Column(name = "A002DESCRPCINPROYCT")
    private String a002descrpcinproyct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A002DURCNPREVST")
    private short a002durcnprevst;
    @Size(max = 2)
    @Column(name = "A002SOCEXTRNJR")
    private String a002socextrnjr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "A002COSTSESTMDTOTL")
    private BigDecimal a002costsestmdtotl;
    @Column(name = "A002COSTSESTMDFORMLCN")
    private BigDecimal a002costsestmdformlcn;
    @Column(name = "A002COSTTONLDRDCR")
    private BigDecimal a002costtonldrdcr;
    @Column(name = "A002TRM")
    private BigDecimal a002trm;
    @Size(max = 2)
    @Column(name = "A002BUSQUDFINNCCN")
    private String a002busqudfinnccn;
    @Size(max = 50)
    @Column(name = "A002PLANPRGRMNACNL")
    private String a002planprgrmnacnl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A002OBJTVGENRL")
    private String a002objtvgenrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A002POTNCLESTMDREDCCN")
    private BigDecimal a002potnclestmdredccn;
    @Size(max = 50)
    @Column(name = "A002NOMBRPROYCTINGLS")
    private String a002nombrproyctingls;
    @Size(max = 300)
    @Column(name = "A002TECNLGCONTMPLD")
    private String a002tecnlgcontmpld;
    @Column(name = "A002NROCPAS")
    private Short a002nrocpas;
    @Size(max = 2)
    @Column(name = "A002PROCSVALDCNEC")
    private String a002procsvaldcnec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A002VIDAUTL")
    private short a002vidautl;
    @Column(name = "A002FECHINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a002fechinicio;
    @Column(name = "A002FECHFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a002fechfin;
    @Size(max = 2)
    @Column(name = "A002APLICMERCDVOLNTR")
    private String a002aplicmercdvolntr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A002ESTADOREGISTRO")
    private Character a002estadoregistro;
    @Column(name = "A002FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a002fechacreacion;
    @Column(name = "A002FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a002fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A002USUARIOCREACION")
    private int a002usuariocreacion;
    @Column(name = "A002USUARIOMODIFICACION")
    private Integer a002usuariomodificacion;
    @JoinColumn(name = "A002IDESTDPROCSVALDCN", referencedColumnName = "A102CODIGO")
    @ManyToOne
    private Lista a002idestdprocsvaldcn;
    @JoinColumn(name = "A002PROYTASCD", referencedColumnName = "A002CODIGO")
    @ManyToOne
    private Proyecto a002proytascd;
    @JoinColumn(name = "A002LOCLZCN", referencedColumnName = "A020CODIGO")
    @ManyToOne(optional = false)
    private Divipola a002loclzcn;
    @JoinColumn(name = "A002IDESCALA", referencedColumnName = "A102CODIGO")
    @ManyToOne
    private Lista a002idescala;
    @JoinColumn(name = "A002IDMETDLGMDL", referencedColumnName = "A028CODIGO")
    @ManyToOne
    private MetodologiaMdl a002idmetdlgmdl;
    @JoinColumn(name = "A002ESTADOPROYECTO", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a002estadoproyecto;
    @JoinColumn(name = "A002IDUSR", referencedColumnName = "A041CODIGO")
    @ManyToOne(optional = false)
    private Usuario a002idusr;
    @JoinColumn(name = "A002IDALCANCE", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a002idalcance;
    @JoinColumn(name = "A002UBCCN", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a002ubccn;
    @JoinColumn(name = "A002TIPPROYCT", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a002tipproyct;
    @JoinColumn(name = "A002IDPROYCTMDL", referencedColumnName = "A102CODIGO")
    @ManyToOne
    private Lista a002idproyctmdl;
    @JoinColumn(name = "A002IDTIPPERDACRDTCN", referencedColumnName = "A102CODIGO")
    @ManyToOne
    private Lista a002idtipperdacrdtcn;
    @JoinColumn(name = "A002IDESTNDRMERCDVOLNTR", referencedColumnName = "A102CODIGO")
    @ManyToOne
    private Lista a002idestndrmercdvolntr;
    @JoinColumn(name = "A002IDSECTORALSCOPE", referencedColumnName = "A102CODIGO")
    @ManyToOne
    private Lista a002idsectoralscope;
    //Se dejan estos listadodos porque si se utilizan
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a004idproyecto")
    private List<ProyFteFinanc> proyFteFinancList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a006idproyecto")
    private List<ProySectrImplmntdr> proySectrImplmntdrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a007idproyecto")
    private List<ProyPolitica> proyPoliticaList;
    
    public Proyecto() {
    }

    public Proyecto(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

    public Proyecto(Integer a002codigo, String a002nombrproyct, short a002durcnprevst, String a002objtvgenrl, BigDecimal a002potnclestmdredccn, short a002vidautl, Character a002estadoregistro, int a002usuariocreacion) {
        this.a002codigo = a002codigo;
        this.a002nombrproyct = a002nombrproyct;
        this.a002durcnprevst = a002durcnprevst;
        this.a002objtvgenrl = a002objtvgenrl;
        this.a002potnclestmdredccn = a002potnclestmdredccn;
        this.a002vidautl = a002vidautl;
        this.a002estadoregistro = a002estadoregistro;
        this.a002usuariocreacion = a002usuariocreacion;
    }

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

    public String getA002nombrproyct() {
        return a002nombrproyct;
    }

    public void setA002nombrproyct(String a002nombrproyct) {
        this.a002nombrproyct = a002nombrproyct;
    }

    public String getA002descrpcinproyct() {
        return a002descrpcinproyct;
    }

    public void setA002descrpcinproyct(String a002descrpcinproyct) {
        this.a002descrpcinproyct = a002descrpcinproyct;
    }

    public short getA002durcnprevst() {
        return a002durcnprevst;
    }

    public void setA002durcnprevst(short a002durcnprevst) {
        this.a002durcnprevst = a002durcnprevst;
    }

    public String getA002socextrnjr() {
        return a002socextrnjr;
    }

    public void setA002socextrnjr(String a002socextrnjr) {
        this.a002socextrnjr = a002socextrnjr;
    }

    public BigDecimal getA002costsestmdtotl() {
        return a002costsestmdtotl;
    }

    public void setA002costsestmdtotl(BigDecimal a002costsestmdtotl) {
        this.a002costsestmdtotl = a002costsestmdtotl;
    }

    public BigDecimal getA002costsestmdformlcn() {
        return a002costsestmdformlcn;
    }

    public void setA002costsestmdformlcn(BigDecimal a002costsestmdformlcn) {
        this.a002costsestmdformlcn = a002costsestmdformlcn;
    }

    public BigDecimal getA002costtonldrdcr() {
        return a002costtonldrdcr;
    }

    public void setA002costtonldrdcr(BigDecimal a002costtonldrdcr) {
        this.a002costtonldrdcr = a002costtonldrdcr;
    }

    public BigDecimal getA002trm() {
        return a002trm;
    }

    public void setA002trm(BigDecimal a002trm) {
        this.a002trm = a002trm;
    }

    public String getA002busqudfinnccn() {
        return a002busqudfinnccn;
    }

    public void setA002busqudfinnccn(String a002busqudfinnccn) {
        this.a002busqudfinnccn = a002busqudfinnccn;
    }

    public String getA002planprgrmnacnl() {
        return a002planprgrmnacnl;
    }

    public void setA002planprgrmnacnl(String a002planprgrmnacnl) {
        this.a002planprgrmnacnl = a002planprgrmnacnl;
    }

    public String getA002objtvgenrl() {
        return a002objtvgenrl;
    }

    public void setA002objtvgenrl(String a002objtvgenrl) {
        this.a002objtvgenrl = a002objtvgenrl;
    }

    public BigDecimal getA002potnclestmdredccn() {
        return a002potnclestmdredccn;
    }

    public void setA002potnclestmdredccn(BigDecimal a002potnclestmdredccn) {
        this.a002potnclestmdredccn = a002potnclestmdredccn;
    }

    public String getA002nombrproyctingls() {
        return a002nombrproyctingls;
    }

    public void setA002nombrproyctingls(String a002nombrproyctingls) {
        this.a002nombrproyctingls = a002nombrproyctingls;
    }

    public String getA002tecnlgcontmpld() {
        return a002tecnlgcontmpld;
    }

    public void setA002tecnlgcontmpld(String a002tecnlgcontmpld) {
        this.a002tecnlgcontmpld = a002tecnlgcontmpld;
    }

    public Short getA002nrocpas() {
        return a002nrocpas;
    }

    public void setA002nrocpas(Short a002nrocpas) {
        this.a002nrocpas = a002nrocpas;
    }

    public String getA002procsvaldcnec() {
        return a002procsvaldcnec;
    }

    public void setA002procsvaldcnec(String a002procsvaldcnec) {
        this.a002procsvaldcnec = a002procsvaldcnec;
    }

    public short getA002vidautl() {
        return a002vidautl;
    }

    public void setA002vidautl(short a002vidautl) {
        this.a002vidautl = a002vidautl;
    }

    public Date getA002fechinicio() {
        return a002fechinicio;
    }

    public void setA002fechinicio(Date a002fechinicio) {
        this.a002fechinicio = a002fechinicio;
    }

    public Date getA002fechfin() {
        return a002fechfin;
    }

    public void setA002fechfin(Date a002fechfin) {
        this.a002fechfin = a002fechfin;
    }

    public String getA002aplicmercdvolntr() {
        return a002aplicmercdvolntr;
    }

    public void setA002aplicmercdvolntr(String a002aplicmercdvolntr) {
        this.a002aplicmercdvolntr = a002aplicmercdvolntr;
    }

    public Character getA002estadoregistro() {
        return a002estadoregistro;
    }

    public void setA002estadoregistro(Character a002estadoregistro) {
        this.a002estadoregistro = a002estadoregistro;
    }

    public Date getA002fechacreacion() {
        return a002fechacreacion;
    }

    public void setA002fechacreacion(Date a002fechacreacion) {
        this.a002fechacreacion = a002fechacreacion;
    }

    public Date getA002fechamodificacion() {
        return a002fechamodificacion;
    }

    public void setA002fechamodificacion(Date a002fechamodificacion) {
        this.a002fechamodificacion = a002fechamodificacion;
    }

    public int getA002usuariocreacion() {
        return a002usuariocreacion;
    }

    public void setA002usuariocreacion(int a002usuariocreacion) {
        this.a002usuariocreacion = a002usuariocreacion;
    }

    public Integer getA002usuariomodificacion() {
        return a002usuariomodificacion;
    }

    public void setA002usuariomodificacion(Integer a002usuariomodificacion) {
        this.a002usuariomodificacion = a002usuariomodificacion;
    }

    public Lista getA002idestdprocsvaldcn() {
        return a002idestdprocsvaldcn;
    }

    public void setA002idestdprocsvaldcn(Lista a002idestdprocsvaldcn) {
        this.a002idestdprocsvaldcn = a002idestdprocsvaldcn;
    }

    public Proyecto getA002proytascd() {
        return a002proytascd;
    }

    public void setA002proytascd(Proyecto a002proytascd) {
        this.a002proytascd = a002proytascd;
    }

    public Divipola getA002loclzcn() {
        return a002loclzcn;
    }

    public void setA002loclzcn(Divipola a002loclzcn) {
        this.a002loclzcn = a002loclzcn;
    }

    public Lista getA002idescala() {
        return a002idescala;
    }

    public void setA002idescala(Lista a002idescala) {
        this.a002idescala = a002idescala;
    }

    public MetodologiaMdl getA002idmetdlgmdl() {
        return a002idmetdlgmdl;
    }

    public void setA002idmetdlgmdl(MetodologiaMdl a002idmetdlgmdl) {
        this.a002idmetdlgmdl = a002idmetdlgmdl;
    }

    public Lista getA002estadoproyecto() {
        return a002estadoproyecto;
    }

    public void setA002estadoproyecto(Lista a002estadoproyecto) {
        this.a002estadoproyecto = a002estadoproyecto;
    }

    public Usuario getA002idusr() {
        return a002idusr;
    }

    public void setA002idusr(Usuario a002idusr) {
        this.a002idusr = a002idusr;
    }

    public Lista getA002idalcance() {
        return a002idalcance;
    }

    public void setA002idalcance(Lista a002idalcance) {
        this.a002idalcance = a002idalcance;
    }

    public Lista getA002ubccn() {
        return a002ubccn;
    }

    public void setA002ubccn(Lista a002ubccn) {
        this.a002ubccn = a002ubccn;
    }

    public Lista getA002tipproyct() {
        return a002tipproyct;
    }

    public void setA002tipproyct(Lista a002tipproyct) {
        this.a002tipproyct = a002tipproyct;
    }

    public Lista getA002idproyctmdl() {
        return a002idproyctmdl;
    }

    public void setA002idproyctmdl(Lista a002idproyctmdl) {
        this.a002idproyctmdl = a002idproyctmdl;
    }

    public Lista getA002idtipperdacrdtcn() {
        return a002idtipperdacrdtcn;
    }

    public void setA002idtipperdacrdtcn(Lista a002idtipperdacrdtcn) {
        this.a002idtipperdacrdtcn = a002idtipperdacrdtcn;
    }

    public Lista getA002idestndrmercdvolntr() {
        return a002idestndrmercdvolntr;
    }

    public void setA002idestndrmercdvolntr(Lista a002idestndrmercdvolntr) {
        this.a002idestndrmercdvolntr = a002idestndrmercdvolntr;
    }

    public Lista getA002idsectoralscope() {
        return a002idsectoralscope;
    }

    public void setA002idsectoralscope(Lista a002idsectoralscope) {
        this.a002idsectoralscope = a002idsectoralscope;
    }

    //@XmlTransient
    //@JsonIgnore
    public List<ProySectrImplmntdr> getProySectrImplmntdrList() {
        return proySectrImplmntdrList;
    }

    public void setProySectrImplmntdrList(List<ProySectrImplmntdr> proySectrImplmntdrList) {
        this.proySectrImplmntdrList = proySectrImplmntdrList;
    }
    
//    @XmlTransient
//    @JsonIgnore
    public List<ProyFteFinanc> getProyFteFinancList() {
        return proyFteFinancList;
    }

    public void setProyFteFinancList(List<ProyFteFinanc> proyFteFinancList) {
        this.proyFteFinancList = proyFteFinancList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a002codigo != null ? a002codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.a002codigo == null && other.a002codigo != null) || (this.a002codigo != null && !this.a002codigo.equals(other.a002codigo))) {
            return false;
        }
        return true;
    }    

    public List<ProyPolitica> getProyPoliticaList() {
        return proyPoliticaList;
    }

    public void setProyPoliticaList(List<ProyPolitica> proyPoliticaList) {
        this.proyPoliticaList = proyPoliticaList;
    }
}
