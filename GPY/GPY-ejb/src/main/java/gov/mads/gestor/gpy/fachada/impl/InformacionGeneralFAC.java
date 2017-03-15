/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.gpy.fachada.impl;

import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.fachada.IInformacionGeneralFAC;
import gov.mads.gestor.gpy.modelo.impl.InformacionGeneralDAO;
import gov.mads.gestor.gpy.vista.ActualizarInfoProyectOE;
import gov.mads.gestor.gpy.vista.ConsultarInfoProyectOE;
import gov.mads.gestor.gpy.vista.RegistrarInfoProyectOE;

/**
 *
 * @author juanmetalmolina
 */
public class InformacionGeneralFAC implements IInformacionGeneralFAC{

    private final InformacionGeneralDAO infogeneral = new InformacionGeneralDAO();
    public ObjetoSalida registrarInfoProyect(RegistrarInfoProyectOE OE) {
        return infogeneral.registrarInfoProyect(OE);
    }

    @Override
    public ObjetoSalida actualizarInfoProyect(ActualizarInfoProyectOE OE) {
        return infogeneral.actualizarInfoProyect(OE);
    }

    @Override
    public ObjetoSalida consultarInfoProyect(ConsultarInfoProyectOE OE) {
        return infogeneral.consultarInfoProyect(OE);
    }
    
}
