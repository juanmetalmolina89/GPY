/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarProyectoOE;

import gov.mads.gestor.gpy.vista.ConsultarProyectoAsociadoOE;

import gov.mads.gestor.gpy.vista.ConsultarProyectoPorIdOE;

import gov.mads.gestor.gpy.vista.ConsultarSectorImplementOE;

import gov.mads.gestor.gpy.vista.RegistrarProyectoOE;

import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;

import gov.mads.gestor.gpy.vista.ListarProyectosOE;


/**
 *
 * @author juanmetalmolina
 */
public interface IDatosBasicosDAO {
    ObjetoSalida registrarProyecto(RegistrarProyectoOE guardarproyectoOE);
    ObjetoSalida registrarSectorImplementador(RegistrarSectorImplementadorOE registrarsectorimplementadorOE);
    ObjetoSalida consultarProyectoPorId(ConsultarProyectoPorIdOE consultarproyectoporidOE);
    ObjetoSalida actualizarProyecto(ActualizarProyectoOE actualizarproyectoOE);
    ObjetoSalida consultarProyectoAsociado(ConsultarProyectoAsociadoOE consultarproyectoasociadoOE);
    ObjetoSalida listarProyectos (ListarProyectosOE listarproyectosOE);
    ObjetoSalida consultarSectorImplement (ConsultarSectorImplementOE consultarsectorimplementOE);
    
}
