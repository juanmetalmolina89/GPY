/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.adm.vista.RegistrarRepresentanteOE;
import gov.mads.gestor.adm.vista.ConsultarRepresentantePorIdOE;
import gov.mads.gestor.adm.vista.ActualizarRepresentanteOE;
import gov.mads.gestor.gpy.vista.AdjuntarDocumentoOE;


/**
 *
 * @author juanmetalmolina
 */
public interface IRepresentanteDAO {
    ObjetoSalida registrarRepresentante(RegistrarRepresentanteOE OE);
    ObjetoSalida consultarRepresentantePorId(ConsultarRepresentantePorIdOE OE);
    ObjetoSalida actualizarRepresentante(ActualizarRepresentanteOE OE);
    ObjetoSalida adjuntarDocumento(AdjuntarDocumentoOE OE);
    ObjetoSalida actualizarDocumento(AdjuntarDocumentoOE OE);
    ObjetoSalida consultarDocumentoPorId(AdjuntarDocumentoOE OE); 
}
