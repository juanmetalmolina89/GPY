/*
 * Clase DAO de Datos basicos de proyecto
 */
package gov.mads.gestor.gpy.fachada.impl;
import gov.mads.gestor.comun.entidades.ProySectrImplmntdr;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.gpy.modelo.impl.DatosBasicosDAO;
import gov.mads.gestor.gpy.vista.RegistrarProyectoOE;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.RegistrarSectorImplementadorOE;
import gov.mads.gestor.gpy.fachada.IDatosBasicosFAC;
import gov.mads.gestor.gpy.vista.ActualizarProyectoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoAsociadoOE;
import gov.mads.gestor.gpy.vista.ConsultarProyectoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarSectorImplementOE;
import gov.mads.gestor.gpy.vista.ListarProyectosOE;
import java.math.BigDecimal;


public class DatosBasicosFAC implements IDatosBasicosFAC {

    private final DatosBasicosDAO GpyDatosBasicosDAO = new DatosBasicosDAO ();

    public ObjetoSalida registrarProyecto(RegistrarProyectoOE registrarproyectoOE) {
        ObjetoSalida objetoSalida = GpyDatosBasicosDAO.registrarProyecto(registrarproyectoOE);
        
        if(objetoSalida.getRespuesta() != null){
            Integer a002ccdigo =  ((BigDecimal) objetoSalida.getRespuesta().get(0).get("a002codigo")).intValue();
            if (a002ccdigo > 0){
                 for (ProySectrImplmntdr item : registrarproyectoOE.getProyecto().getProySectrImplmntdrList()) {
                    RegistrarSectorImplementadorOE OE = new RegistrarSectorImplementadorOE();
                    OE.setA002codigo(a002ccdigo);
                    OE.setSector(item);
                    OE.setIdUsuario(1);
                    ObjetoSalida objetoSalidaContaminante = GpyDatosBasicosDAO.registrarSectorImplementador(OE);
                    if (objetoSalidaContaminante.getCodError() != CodError.OPERACION_CORRECTA) {
                        objetoSalida.setMsgError(objetoSalida.getMsgError() + "<br><br>" + objetoSalidaContaminante.getMsgError());
                    }
                }
            }
        }
        return objetoSalida;
    }
    
    public ObjetoSalida registrarSectorImplementador(RegistrarSectorImplementadorOE registrarsectorimplementadorOE) {

        return GpyDatosBasicosDAO.registrarSectorImplementador(registrarsectorimplementadorOE);
    }

    public ObjetoSalida consultarProyectoPorId(ConsultarProyectoPorIdOE consultarproyectoporidOE) {
        
        return GpyDatosBasicosDAO.consultarProyectoPorId(consultarproyectoporidOE);
        
    }

    
    public ObjetoSalida actualizarProyecto(ActualizarProyectoOE actualizarproyectoOE) {
        
        return GpyDatosBasicosDAO.actualizarProyecto(actualizarproyectoOE);
    }

    
    public ObjetoSalida consultarProyectoAsociado(ConsultarProyectoAsociadoOE consultarproyectoasociadoOE) {
        
        return GpyDatosBasicosDAO.consultarProyectoAsociado(consultarproyectoasociadoOE);
    }

    public ObjetoSalida listarProyectos(ListarProyectosOE listarproyectosOE) {
        return GpyDatosBasicosDAO.listarProyectos(listarproyectosOE);
    }

    public ObjetoSalida consultarSectorImplement(ConsultarSectorImplementOE consultarsectorimplementOE) {
        return GpyDatosBasicosDAO.consultarSectorImplement(consultarsectorimplementOE);
    }

    
}
