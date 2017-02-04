/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.fachada.impl;

import gov.mads.gestor.utl.modelo.impl.ListadosDAO;
import gov.mads.gestor.utl.vista.ListarAutoridadesOE;
import gov.mads.gestor.utl.vista.ListarTipoProyectoOE;
import gov.mads.gestor.utl.vista.ListarTipoPersonaOE;
import gov.mads.gestor.utl.vista.ListarAlcanceProyectoOE;
import gov.mads.gestor.utl.vista.ListarClaseUsuarioOE;
import gov.mads.gestor.utl.vista.ListarTipoDocumentoOE;
import gov.mads.gestor.utl.vista.ListarUbicacionProyectoOE;
import gov.mads.gestor.utl.vista.ListarSectorImplementadorOE;
import gov.mads.gestor.utl.vista.ListarDepartamentoOE;
import gov.mads.gestor.utl.vista.ListarMunicipioOE;
import gov.mads.gestor.utl.vista.ListarPaisesOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.fachada.IListadosFAC;
import gov.mads.gestor.utl.vista.ListarCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarCodigoCIIUOE;
import gov.mads.gestor.utl.vista.ListarDesagregacionIPCCOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv3OE;
import gov.mads.gestor.utl.vista.ListarFtesFinancOE;
import gov.mads.gestor.utl.vista.ListarMetdMDLOE;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import gov.mads.gestor.utl.vista.ListarParticipanteOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv2OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv4OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv1OE;
import gov.mads.gestor.utl.vista.ListarSectorIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubGrupoIPCCOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadReducOE;
/**
 *
 * @author juanmetalmolina
 */
public class ListadosFAC implements IListadosFAC {

    private final ListadosDAO UtlListadosDAO = new ListadosDAO ();

    public ObjetoSalida listarAutoridades(ListarAutoridadesOE OE) {

        return UtlListadosDAO.listarAutoridades(OE);
    }
    
    public ObjetoSalida listarTipoProyecto(ListarTipoProyectoOE OE) {

        return UtlListadosDAO.listarTipoProyecto(OE);
    }
    
    public ObjetoSalida listarTipoDocumento(ListarTipoDocumentoOE OE) {

        return UtlListadosDAO.listarTipoDocumento(OE);
    }
    
    public ObjetoSalida listarTipoPersona(ListarTipoPersonaOE OE) {

        return UtlListadosDAO.listarTipoPersona(OE);
    }
    
    public ObjetoSalida listarClaseUsuario(ListarClaseUsuarioOE OE) {

        return UtlListadosDAO.listarClaseUsuario(OE);
    }
    
    public ObjetoSalida listarUbicacionProyecto(ListarUbicacionProyectoOE OE) {

        return UtlListadosDAO.listarUbicacionProyecto(OE);
    }
    public ObjetoSalida listarAlcanceProyecto(ListarAlcanceProyectoOE OE){

        return UtlListadosDAO.listarAlcanceProyecto(OE);
    }
    public ObjetoSalida listarSectorImplementador(ListarSectorImplementadorOE OE) {

        return UtlListadosDAO.listarSectorImplementador(OE);
    }
    public ObjetoSalida listarPaises(ListarPaisesOE OE) {

        return UtlListadosDAO.listarPaises(OE);
    }
    public ObjetoSalida listarDepartamentos(ListarDepartamentoOE OE) {

        return UtlListadosDAO.listarDepartamento(OE);
    }
    public ObjetoSalida listarMunicipio(ListarMunicipioOE OE) {

        return UtlListadosDAO.listarMunicipio(OE);
    }
    
    public ObjetoSalida listarParametrico(ListarParametricoOE OE) {

        return UtlListadosDAO.listarParametrico(OE);
    }
    
    public ObjetoSalida listarCodigoCIIU(ListarCodigoCIIUOE OE) {

        return UtlListadosDAO.listarCodigoCIIU(OE);
    }
    
    public ObjetoSalida listarTipoActividad(ListarTipoActividadOE OE) {

        return UtlListadosDAO.listarTipoActividades(OE);
    }
    
    public ObjetoSalida listarSectorIPCC(ListarSectorIPCCOE OE) {

        return UtlListadosDAO.listarSectorIPCC(OE);
    }
    
    public ObjetoSalida listarCategoriaIPCC(ListarCategoriaIPCCOE OE) {

        return UtlListadosDAO.listarCategoriaIPCC(OE);
    }
    
    public ObjetoSalida listarSubCategoriaIPCC(ListarSubCategoriaIPCCOE OE) {

        return UtlListadosDAO.listarSubCategoriaIPCC(OE);
    }
    
    public ObjetoSalida listarDesagregacionIPCC(ListarDesagregacionIPCCOE OE){
        return UtlListadosDAO.listarDesagregacionIPCC(OE);
    }
    
    public ObjetoSalida listarMetdMDL(ListarMetdMDLOE OE){
        return UtlListadosDAO.listarMetdMDL(OE);
    }
    
    public ObjetoSalida listarParticipante(ListarParticipanteOE OE){
        return UtlListadosDAO.listarParticipante(OE);
    }

    public ObjetoSalida listarArbolPolNv4(ListarArbolPolNv4OE OE) {
        return UtlListadosDAO.listarArbolPolNv4(OE);
    }

    public ObjetoSalida listarArbolPolNv2(ListarArbolPolNv2OE OE) {
        return UtlListadosDAO.listarArbolPolNv2(OE);
    }

    public ObjetoSalida listarArbolPolNv3(ListarArbolPolNv3OE OE) {
        return UtlListadosDAO.listarArbolPolNv3(OE);
    }

    public ObjetoSalida listarArbolPolNv1(ListarArbolPolNv1OE OE) {
        return UtlListadosDAO.listarArbolPolNv1(OE);
    }

    public ObjetoSalida listarFuentesFinanciacion(ListarFtesFinancOE OE) {
        return UtlListadosDAO.listarFuentesFinanciacion(OE);
    }

    public ObjetoSalida listarTipoActividadReduccion(ListarTipoActividadReducOE OE) {
        return UtlListadosDAO.listarTipoActividadReduccion(OE);
    }

    public ObjetoSalida listarSubgrupoIPCC(ListarSubGrupoIPCCOE OE) {
        return UtlListadosDAO.listarSubgrupoIPCC(OE);
    }
    
}
