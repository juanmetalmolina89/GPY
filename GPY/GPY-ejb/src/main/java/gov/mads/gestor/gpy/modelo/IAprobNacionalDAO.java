/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.modelo;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.CambiarEstadoProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IAprobNacionalDAO {
    ObjetoSalida cambiarEstadoProyecto(CambiarEstadoProyectoOE OE);
    ObjetoSalida adjuntarDocumento(RegistrarAdjuntoOE OE);
}
