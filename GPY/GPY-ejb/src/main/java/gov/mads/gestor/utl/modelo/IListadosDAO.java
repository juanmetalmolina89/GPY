/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.utl.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.utl.vista.ListarAlcanceProyectoOE;
import gov.mads.gestor.utl.vista.ListarAutoridadesOE;
import gov.mads.gestor.utl.vista.ListarTipoDocumentoOE;
import gov.mads.gestor.utl.vista.ListarTipoProyectoOE;
import gov.mads.gestor.utl.vista.ListarTipoPersonaOE;
import gov.mads.gestor.utl.vista.ListarClaseUsuarioOE;
import gov.mads.gestor.utl.vista.ListarUbicacionProyectoOE;
import gov.mads.gestor.utl.vista.ListarSectorImplementadorOE;
import gov.mads.gestor.utl.vista.ListarPaisesOE;
import gov.mads.gestor.utl.vista.ListarDepartamentoOE;
import gov.mads.gestor.utl.vista.ListarDesagregacionIPCCOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv3OE;
import gov.mads.gestor.utl.vista.ListarFtesFinancOE;
import gov.mads.gestor.utl.vista.ListarMetdMDLOE;
import gov.mads.gestor.utl.vista.ListarMunicipioOE;
import gov.mads.gestor.utl.vista.ListarParametricoOE;
import gov.mads.gestor.utl.vista.ListarParticipanteOE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv2OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv4OE;
import gov.mads.gestor.utl.vista.ListarArbolPolNv1OE;
import gov.mads.gestor.utl.vista.ListarSectorIPCCOE;
import gov.mads.gestor.utl.vista.ListarSubGrupoIPCCOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadOE;
import gov.mads.gestor.utl.vista.ListarTipoActividadReducOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IListadosDAO {
    ObjetoSalida listarAutoridades(ListarAutoridadesOE OE);
    ObjetoSalida listarTipoProyecto(ListarTipoProyectoOE OE);
    ObjetoSalida listarTipoDocumento(ListarTipoDocumentoOE OE);
    ObjetoSalida listarTipoPersona(ListarTipoPersonaOE OE);
    ObjetoSalida listarClaseUsuario(ListarClaseUsuarioOE OE);
    ObjetoSalida listarUbicacionProyecto(ListarUbicacionProyectoOE OE);
    ObjetoSalida listarAlcanceProyecto(ListarAlcanceProyectoOE OE);
    ObjetoSalida listarSectorImplementador(ListarSectorImplementadorOE OE);
    ObjetoSalida listarPaises(ListarPaisesOE OE);
    ObjetoSalida listarDepartamento(ListarDepartamentoOE OE);
    ObjetoSalida listarMunicipio(ListarMunicipioOE OE);
    ObjetoSalida listarParametrico(ListarParametricoOE OE);
    ObjetoSalida listarTipoActividad(ListarTipoActividadOE OE);
    ObjetoSalida listarSectorIPCC(ListarSectorIPCCOE OE);
    ObjetoSalida listarCategoriaIPCC(ListarSectorIPCCOE OE);
    ObjetoSalida listarSubCategoriaIPCC(ListarSectorIPCCOE OE);
    ObjetoSalida listarDesagregacionIPCC(ListarDesagregacionIPCCOE OE);
    ObjetoSalida listarMetdMDL(ListarMetdMDLOE OE);
    ObjetoSalida listarParticipante(ListarParticipanteOE OE);
    ObjetoSalida listarArbolPolNv4(ListarArbolPolNv4OE OE);
    ObjetoSalida listarArbolPolNv2(ListarArbolPolNv2OE OE);
    ObjetoSalida listarArbolPolNv3(ListarArbolPolNv3OE OE);
    ObjetoSalida listarArbolPolNv1(ListarArbolPolNv1OE OE);
    //ObjetoSalida listarActividades(ListarActividadesOE OE);
    ObjetoSalida listarFuentesFinanciacion(ListarFtesFinancOE OE);
    ObjetoSalida listarTipoActividadReduccion(ListarTipoActividadReducOE OE);
    ObjetoSalida listarSubgrupoIPCC(ListarSubGrupoIPCCOE OE);
}
