/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.fachada;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.CambiarEstadoProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author juanmetalmolina
 */
public interface IAprobNacionalFAC {
    public ObjetoSalida cambiarEstadoProyecto(CambiarEstadoProyectoOE OE);
    public ObjetoSalida adjuntarDocumento(MultipartFormDataInput OE);
}
