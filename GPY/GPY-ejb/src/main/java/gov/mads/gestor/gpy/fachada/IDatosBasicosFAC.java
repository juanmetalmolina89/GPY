/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.fachada;

/**
 *
 * @author juanmetalmolina
 */
import gov.mads.gestor.gpy.vista.RegistrarProyectoOE;
import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarProyectoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoAsociadoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSectorImplementOE;
import gov.mads.gestor.gpy.vista.ListarProyectosOE;


public interface IDatosBasicosFAC {
    public ObjetoSalida registrarProyecto(RegistrarProyectoOE registrarproyectoOE);
    public ObjetoSalida registrarSectorImplementador(RegistrarSectorImplementadorOE guardarsectorimplementadorOE);
    public ObjetoSalida consultarProyectoPorId(ConsultarProyectoPorIdOE consultarproyectoporidOE);
    public ObjetoSalida actualizarProyecto(ActualizarProyectoOE actualizarproyectoOE);
    public ObjetoSalida consultarProyectoAsociado(ConsultarProyectoAsociadoOE consultarproyectoasociadoOE);
    public ObjetoSalida listarProyectos (ListarProyectosOE listarproyectosOE);
    public ObjetoSalida consultarSectorImplement (ConsultarSectorImplementOE consultarsectorimplementOE);
     
}
