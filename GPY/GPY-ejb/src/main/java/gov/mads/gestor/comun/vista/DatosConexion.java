/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.vista;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author juanmetalmolina
 */
public class DatosConexion {
    @XmlElement(required=true)
    public String aliasUsuarioOrigen;
    @XmlElement(required=true)
    public String aliasUsuarioDestino;
    @XmlElement(required=true)
    public String sistemaOrigen;
    @XmlElement(required=true)
    public String sistemaDestino;
    @XmlElement(required=true)
    public String codigoOperacion;
    /*
    <aliasUsuarioOrigen>xxxx</aliasUsuarioOrigen>
    <aliasUsuarioDestino>xxxx</aliasUsuarioDestino>
    <autoridadAmbiental>xxxx</autoridadAmbiental>
    <sistemaOrigen>xxxx</sistemaOrigen>
    <sistemaDestino>xxxx</sistemaDestino>
    <codigoOperacion>xxxxx</codigoOperacion>
    */ 
   
    
}
