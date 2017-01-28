/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.modelo;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.ListarActividadesPorFiltroOE;
import gov.mads.gestor.gpy.vista.ListarProyectoOE;
import gov.mads.gestor.gpy.vista.ListarProyectoFiltradoOE;
/**
 *
 * @author juanmetalmolina
 */
public interface IGrillaDAO {
    ObjetoSalida listarProyecto(ListarProyectoOE OE);
    ObjetoSalida listarProyectoFiltrado(ListarProyectoFiltradoOE OE);
    ObjetoSalida listarActividades(ListarActividadesOE OE);
    ObjetoSalida listarActividadesFiltrado(ListarActividadesPorFiltroOE OE);
}
