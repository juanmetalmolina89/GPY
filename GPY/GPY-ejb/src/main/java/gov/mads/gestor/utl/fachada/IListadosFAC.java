/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.fachada;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.vista.ListarAutoridadesOE;
import gov.mads.gestor.utl.vista.ListarTipoProyectoOE;
import gov.mads.gestor.utl.vista.ListarTipoDocumentoOE;
import gov.mads.gestor.utl.vista.ListarTipoPersonaOE;
import gov.mads.gestor.utl.vista.ListarClaseUsuarioOE;
import gov.mads.gestor.utl.vista.ListarUbicacionProyectoOE;
import gov.mads.gestor.utl.vista.ListarAlcanceProyectoOE;
import gov.mads.gestor.utl.vista.ListarCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarCodigoCIIUOE;
import gov.mads.gestor.utl.vista.ListarSectorImplementadorOE;
import gov.mads.gestor.utl.vista.ListarDepartamentoOE;
import gov.mads.gestor.utl.vista.ListarDesagregacionIPCCOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv3OE;
import gov.mads.gestor.utl.vista.ListarFtesFinancOE;
import gov.mads.gestor.utl.vista.ListarMetdMDLOE;
import gov.mads.gestor.utl.vista.ListarPaisesOE;
import gov.mads.gestor.utl.vista.ListarMunicipioOE;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import gov.mads.gestor.utl.vista.ListarParticipanteOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv2OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv4OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv1OE;
import gov.mads.gestor.utl.vista.ListarPoliticaOE;
import gov.mads.gestor.utl.vista.ListarSectorIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubCategoriaIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubGrupoIPCCOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadReducOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IListadosFAC {
    public ObjetoSalida listarAutoridades(ListarAutoridadesOE OE);
    public ObjetoSalida listarTipoProyecto(ListarTipoProyectoOE OE);
    public ObjetoSalida listarTipoDocumento(ListarTipoDocumentoOE OE);
    public ObjetoSalida listarTipoPersona(ListarTipoPersonaOE OE);
    public ObjetoSalida listarClaseUsuario(ListarClaseUsuarioOE OE);
    public ObjetoSalida listarUbicacionProyecto(ListarUbicacionProyectoOE OE);
    public ObjetoSalida listarAlcanceProyecto(ListarAlcanceProyectoOE OE);
    public ObjetoSalida listarSectorImplementador(ListarSectorImplementadorOE OE);
    public ObjetoSalida listarPaises(ListarPaisesOE OE);
    public ObjetoSalida listarDepartamentos(ListarDepartamentoOE OE);
    public ObjetoSalida listarMunicipio(ListarMunicipioOE OE);
    public ObjetoSalida listarParametrico(ListarParametricoOE OE);
    public ObjetoSalida listarCodigoCIIU(ListarCodigoCIIUOE OE);
    public ObjetoSalida listarTipoActividad(ListarTipoActividadOE OE);
    public ObjetoSalida listarSectorIPCC(ListarSectorIPCCOE OE);
    public ObjetoSalida listarCategoriaIPCC(ListarCategoriaIPCCOE OE);
    public ObjetoSalida listarSubCategoriaIPCC(ListarSubCategoriaIPCCOE OE);
    public ObjetoSalida listarDesagregacionIPCC(ListarDesagregacionIPCCOE OE);
    public ObjetoSalida listarMetdMDL(ListarMetdMDLOE OE);
    public ObjetoSalida listarParticipante(ListarParticipanteOE OE);
    public ObjetoSalida listarArbolPolNv4(ListarArbolPolNv4OE OE);
    public ObjetoSalida listarArbolPolNv2(ListarArbolPolNv2OE OE);
    public ObjetoSalida listarArbolPolNv3(ListarArbolPolNv3OE OE);
    public ObjetoSalida listarArbolPolNv1(ListarArbolPolNv1OE OE);
    public ObjetoSalida listarFuentesFinanciacion(ListarFtesFinancOE OE);
    public ObjetoSalida listarTipoActividadReduccion(ListarTipoActividadReducOE OE);
    public ObjetoSalida listarSubgrupoIPCC(ListarSubGrupoIPCCOE OE);
    public ObjetoSalida listarPoliticas(ListarPoliticaOE OE);
    public String obtenerParametro(Integer idUsuario, String nombreParametro) throws Exception;
}
