package gov.mads.gestor.gpy.modelo;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import gov.mads.gestor.gpy.vista.ActualizarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ActualizarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ActualizarConsideracOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoOE;
import gov.mads.gestor.gpy.vista.ConsultarAdjuntoPorIdOE;
import gov.mads.gestor.gpy.vista.ConsultarCartaNObjOE;
import gov.mads.gestor.gpy.vista.ConsultarConsideracOE;
import gov.mads.gestor.gpy.vista.ListarAdjuntosOE;
import gov.mads.gestor.gpy.vista.RegistrarAdjuntoOE;
import gov.mads.gestor.gpy.vista.RegistrarConsideracOE;
import gov.mads.gestor.gpy.vista.RegistrarCartaNObjOE;

/**
 *
 * @author Ivan Chacon
 */
public interface IDatosMdlDAO { 

	ObjetoSalida registrarConsiderac(RegistrarConsideracOE registrarConsideracOE);
	ObjetoSalida registrarCartaNObj(RegistrarCartaNObjOE registrarCartaNObjOE);
        //Se Ingresaron consultar
        ObjetoSalida consultarConsiderac(ConsultarConsideracOE OE);
        ObjetoSalida consultarCartaNObj(ConsultarCartaNObjOE OE);
        ObjetoSalida registrarAdjunto(RegistrarAdjuntoOE OE);
        ObjetoSalida consultarAdjunto(ConsultarAdjuntoOE OE);
        ObjetoSalida listarAdjuntos(ListarAdjuntosOE OE);
        // Se ingresan Actualizar
        ObjetoSalida actualizarConsiderac(ActualizarConsideracOE OE);
        ObjetoSalida actualizarCartaNObj(ActualizarCartaNObjOE OE);
        ObjetoSalida actualizarAdjunto(ActualizarAdjuntoOE OE);
        ObjetoSalida consultarAdjuntoPorID(ConsultarAdjuntoPorIdOE OE);
}
