/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanmetalmolina
 */
@Entity
@Table(name = "PART_T103_REPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByA103codigo", query = "SELECT r FROM Reporte r WHERE r.a103codigo = :a103codigo"),
    @NamedQuery(name = "Reporte.findByA103nombre", query = "SELECT r FROM Reporte r WHERE r.a103nombre = :a103nombre"),
    @NamedQuery(name = "Reporte.findByA103descripcion", query = "SELECT r FROM Reporte r WHERE r.a103descripcion = :a103descripcion"),
    @NamedQuery(name = "Reporte.findByA103sql", query = "SELECT r FROM Reporte r WHERE r.a103sql = :a103sql"),
    @NamedQuery(name = "Reporte.findByA103nombreplantilla", query = "SELECT r FROM Reporte r WHERE r.a103nombreplantilla = :a103nombreplantilla"),
    @NamedQuery(name = "Reporte.findByA103icono", query = "SELECT r FROM Reporte r WHERE r.a103icono = :a103icono"),
    @NamedQuery(name = "Reporte.findByA103estadoregistro", query = "SELECT r FROM Reporte r WHERE r.a103estadoregistro = :a103estadoregistro"),
    @NamedQuery(name = "Reporte.findByA103fechacreacion", query = "SELECT r FROM Reporte r WHERE r.a103fechacreacion = :a103fechacreacion"),
    @NamedQuery(name = "Reporte.findByA103fechamodificacion", query = "SELECT r FROM Reporte r WHERE r.a103fechamodificacion = :a103fechamodificacion"),
    @NamedQuery(name = "Reporte.findByA103usuariocreacion", query = "SELECT r FROM Reporte r WHERE r.a103usuariocreacion = :a103usuariocreacion"),
    @NamedQuery(name = "Reporte.findByA103usuariomodificacion", query = "SELECT r FROM Reporte r WHERE r.a103usuariomodificacion = :a103usuariomodificacion")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "A103CODIGO")
    private Integer a103codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "A103NOMBRE")
    private String a103nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "A103DESCRIPCION")
    private String a103descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "A103SQL")
    private String a103sql;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "A103NOMBREPLANTILLA")
    private String a103nombreplantilla;
    @Size(max = 50)
    @Column(name = "A103ICONO")
    private String a103icono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A103ESTADOREGISTRO")
    private Character a103estadoregistro;
    @Column(name = "A103FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a103fechacreacion;
    @Column(name = "A103FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date a103fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A103USUARIOCREACION")
    private int a103usuariocreacion;
    @Column(name = "A103USUARIOMODIFICACION")
    private Integer a103usuariomodificacion;
    @JoinColumn(name = "A103CATEGORIA", referencedColumnName = "A102CODIGO")
    @ManyToOne(optional = false)
    private Lista a103categoria;

    public Reporte() {
    }

    public Reporte(Integer a103codigo) {
        this.a103codigo = a103codigo;
    }

    public Reporte(Integer a103codigo, String a103nombre, String a103descripcion, String a103sql, String a103nombreplantilla, Character a103estadoregistro, int a103usuariocreacion) {
        this.a103codigo = a103codigo;
        this.a103nombre = a103nombre;
        this.a103descripcion = a103descripcion;
        this.a103sql = a103sql;
        this.a103nombreplantilla = a103nombreplantilla;
        this.a103estadoregistro = a103estadoregistro;
        this.a103usuariocreacion = a103usuariocreacion;
    }

    public Integer getA103codigo() {
        return a103codigo;
    }

    public void setA103codigo(Integer a103codigo) {
        this.a103codigo = a103codigo;
    }

    public String getA103nombre() {
        return a103nombre;
    }

    public void setA103nombre(String a103nombre) {
        this.a103nombre = a103nombre;
    }

    public String getA103descripcion() {
        return a103descripcion;
    }

    public void setA103descripcion(String a103descripcion) {
        this.a103descripcion = a103descripcion;
    }

    public String getA103sql() {
        return a103sql;
    }

    public void setA103sql(String a103sql) {
        this.a103sql = a103sql;
    }

    public String getA103nombreplantilla() {
        return a103nombreplantilla;
    }

    public void setA103nombreplantilla(String a103nombreplantilla) {
        this.a103nombreplantilla = a103nombreplantilla;
    }

    public String getA103icono() {
        return a103icono;
    }

    public void setA103icono(String a103icono) {
        this.a103icono = a103icono;
    }

    public Character getA103estadoregistro() {
        return a103estadoregistro;
    }

    public void setA103estadoregistro(Character a103estadoregistro) {
        this.a103estadoregistro = a103estadoregistro;
    }

    public Date getA103fechacreacion() {
        return a103fechacreacion;
    }

    public void setA103fechacreacion(Date a103fechacreacion) {
        this.a103fechacreacion = a103fechacreacion;
    }

    public Date getA103fechamodificacion() {
        return a103fechamodificacion;
    }

    public void setA103fechamodificacion(Date a103fechamodificacion) {
        this.a103fechamodificacion = a103fechamodificacion;
    }

    public int getA103usuariocreacion() {
        return a103usuariocreacion;
    }

    public void setA103usuariocreacion(int a103usuariocreacion) {
        this.a103usuariocreacion = a103usuariocreacion;
    }

    public Integer getA103usuariomodificacion() {
        return a103usuariomodificacion;
    }

    public void setA103usuariomodificacion(Integer a103usuariomodificacion) {
        this.a103usuariomodificacion = a103usuariomodificacion;
    }

    public Lista getA103categoria() {
        return a103categoria;
    }

    public void setA103categoria(Lista a103categoria) {
        this.a103categoria = a103categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (a103codigo != null ? a103codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.a103codigo == null && other.a103codigo != null) || (this.a103codigo != null && !this.a103codigo.equals(other.a103codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.mads.gestor.comun.entidades.Reporte[ a103codigo=" + a103codigo + " ]";
    }
    
}
