/*
 * Entidades creadas directamente de la BD
 */
package gov.mads.gestor.comun.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "GPYT_T003_POLITICA", catalog = "", schema = "GESTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Politica.findAll", query = "SELECT p FROM Politica p")})
public class Politica implements Serializable {

    @Column(name = "A003NIVEL1")
    private BigInteger a003nivel1;
    @Column(name = "A003NIVEL2")
    private BigInteger a003nivel2;
    @Column(name = "A003NIVEL3")
    private Integer a003nivel3;
    @Column(name = "A003NIVEL4")
    private Integer a003nivel4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a007idpolitica")
    private List<ProyPolitica> proyPoliticaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A003CODIGO")
    private Integer a003codigo;
    @Size(max = 40)
    @Column(name = "A003NOMNIVEL1")
    private String a003nomnivel1;
    @Size(max = 40)
    @Column(name = "A003NOMNIVEL2")
    private String a003nomnivel2;
    @Size(max = 40)
    @Column(name = "A003NOMNIVEL3")
    private String a003nomnivel3;
    @Size(max = 40)
    @Column(name = "A003NOMNIVEL4")
    private String a003nomnivel4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "A003DESCRPCNPOLTC")
    private String a003descrpcnpoltc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A003ESTADOREGISTRO")
    private Character a003estadoregistro;
    @Column(name = "A003FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a003fechacreacion;
    @Column(name = "A003FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a003fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A003USUARIOCREACION")
    private int a003usuariocreacion;
    @Column(name = "A003USUARIOMODIFICACION")
    private Integer a003usuariomodificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a007idpolitica")
//    private List<ProyPolitica> proyPoliticaList;
    @JoinColumn(name = "A003IDARCHIV", referencedColumnName = "A026CODIGO")
    @ManyToOne
    private Archivo a003idarchiv;

    public Politica() {
    }

    public Politica(Integer a003codigo) {
        this.a003codigo = a003codigo;
    }

    public Politica(Integer a003codigo, String a003descrpcnpoltc, Character a003estadoregistro, int a003usuariocreacion) {
        this.a003codigo = a003codigo;
        this.a003descrpcnpoltc = a003descrpcnpoltc;
        this.a003estadoregistro = a003estadoregistro;
        this.a003usuariocreacion = a003usuariocreacion;
    }

    public Integer getA003codigo() {
        return a003codigo;
    }

    public void setA003codigo(Integer a003codigo) {
        this.a003codigo = a003codigo;
    }


    public String getA003nomnivel1() {
        return a003nomnivel1;
    }

    public void setA003nomnivel1(String a003nomnivel1) {
        this.a003nomnivel1 = a003nomnivel1;
    }


    public String getA003nomnivel2() {
        return a003nomnivel2;
    }

    public void setA003nomnivel2(String a003nomnivel2) {
        this.a003nomnivel2 = a003nomnivel2;
    }


    public String getA003nomnivel3() {
        return a003nomnivel3;
    }

    public void setA003nomnivel3(String a003nomnivel3) {
        this.a003nomnivel3 = a003nomnivel3;
    }


    public String getA003nomnivel4() {
        return a003nomnivel4;
    }

    public void setA003nomnivel4(String a003nomnivel4) {
        this.a003nomnivel4 = a003nomnivel4;
    }

    public String getA003descrpcnpoltc() {
        return a003descrpcnpoltc;
    }

    public void setA003descrpcnpoltc(String a003descrpcnpoltc) {
        this.a003descrpcnpoltc = a003descrpcnpoltc;
    }

    public Character getA003estadoregistro() {
        return a003estadoregistro;
    }

    public void setA003estadoregistro(Character a003estadoregistro) {
        this.a003estadoregistro = a003estadoregistro;
    }

    public Date getA003fechacreacion() {
        return a003fechacreacion;
    }

    public void setA003fechacreacion(Date a003fechacreacion) {
        this.a003fechacreacion = a003fechacreacion;
    }

    public Date getA003fechamodificacion() {
        return a003fechamodificacion;
    }

    public void setA003fechamodificacion(Date a003fechamodificacion) {
        this.a003fechamodificacion = a003fechamodificacion;
    }

    public int getA003usuariocreacion() {
        return a003usuariocreacion;
    }

    public void setA003usuariocreacion(int a003usuariocreacion) {
        this.a003usuariocreacion = a003usuariocreacion;
    }

    public Integer getA003usuariomodificacion() {
        return a003usuariomodificacion;
    }

    public void setA003usuariomodificacion(Integer a003usuariomodificacion) {
        this.a003usuariomodificacion = a003usuariomodificacion;
    }

//    @XmlTransient
//    public List<ProyPolitica> getProyPoliticaList() {
//        return proyPoliticaList;
//    }
//
//    public void setProyPoliticaList(List<ProyPolitica> proyPoliticaList) {
//        this.proyPoliticaList = proyPoliticaList;
//    }

    public Archivo getA003idarchiv() {
        return a003idarchiv;
    }

    public void setA003idarchiv(Archivo a003idarchiv) {
        this.a003idarchiv = a003idarchiv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a003codigo != null ? a003codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Politica)) {
            return false;
        }
        Politica other = (Politica) object;
        if ((this.a003codigo == null && other.a003codigo != null) || (this.a003codigo != null && !this.a003codigo.equals(other.a003codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Politica[ a003codigo=" + a003codigo + " ]";
    }

    public BigInteger getA003nivel1() {
        return a003nivel1;
    }

    public void setA003nivel1(BigInteger a003nivel1) {
        this.a003nivel1 = a003nivel1;
    }

    public BigInteger getA003nivel2() {
        return a003nivel2;
    }

    public void setA003nivel2(BigInteger a003nivel2) {
        this.a003nivel2 = a003nivel2;
    }

    public Integer getA003nivel3() {
        return a003nivel3;
    }

    public void setA003nivel3(Integer a003nivel3) {
        this.a003nivel3 = a003nivel3;
    }

    public Integer getA003nivel4() {
        return a003nivel4;
    }

    public void setA003nivel4(Integer a003nivel4) {
        this.a003nivel4 = a003nivel4;
    }

    @XmlTransient
    @JsonIgnore
    public List<ProyPolitica> getProyPoliticaList() {
        return proyPoliticaList;
    }

    public void setProyPoliticaList(List<ProyPolitica> proyPoliticaList) {
        this.proyPoliticaList = proyPoliticaList;
    }
    
}
