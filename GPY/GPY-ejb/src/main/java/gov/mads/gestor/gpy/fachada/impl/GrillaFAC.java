/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.modelo.impl.GrillaDAO;
import gov.mads.gestor.gpy.fachada.IGrillaFAC;
import gov.mads.gestor.gpy.vista.ListarActividadesOE;
import gov.mads.gestor.gpy.vista.ListarActividadesPorFiltroOE;
import gov.mads.gestor.gpy.vista.ListarProyectoFiltradoOE;
import gov.mads.gestor.gpy.vista.ListarProyectoOE;
/**
 *
 * @author juanmetalmolina
 */
public class GrillaFAC implements IGrillaFAC{
    GrillaDAO grilla = new GrillaDAO();
    public ObjetoSalida listarProyecto(ListarProyectoOE OE) {
        return grilla.listarProyectos(OE);
    }

    public ObjetoSalida listarProyectoFiltrado(ListarProyectoFiltradoOE OE) {
        return grilla.listarProyectoFiltrado(OE);
    }

    @Override
    public ObjetoSalida listarActividades(ListarActividadesOE OE) {
        return grilla.listarActividades(OE);
    }

    @Override
    public ObjetoSalida listarActividadesFiltrado(ListarActividadesPorFiltroOE OE) {
        return grilla.listarActividadesFiltrado(OE);
    }
    
}
