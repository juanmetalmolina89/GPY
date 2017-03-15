/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.fachada;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarInfoProyectOE;
import gov.mads.gestor.gpy.vista.ConsultarInfoProyectOE;
import gov.mads.gestor.gpy.vista.RegistrarInfoProyectOE;

/**
 *
 * @author juanmetalmolina
 */
public interface IInformacionGeneralFAC {
    public ObjetoSalida registrarInfoProyect(RegistrarInfoProyectOE OE);
    public ObjetoSalida actualizarInfoProyect(ActualizarInfoProyectOE OE);
    public ObjetoSalida consultarInfoProyect(ConsultarInfoProyectOE OE);
}
