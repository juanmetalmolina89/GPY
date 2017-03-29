package gov.mads.gestor.comun.servicio;

import gov.mads.gestor.adm.vista.OS_ConsultarFuncionarios;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ObjetoSalida;

import javax.ws.rs.core.Response;

//@ApplicationPath("servicios")
public class API /*extends Application*/ {
    
    public static Response retornarRespuesta(ObjetoSalida objetoSalida) {

        if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA)
            return Response.status(Response.Status.OK).entity(objetoSalida).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(objetoSalida).build();
    }
    
    public static Response retornarRespuestaVital(OS_ConsultarFuncionarios objetoSalida) {

        if (objetoSalida.getCodigoError() == CodError.OPERACION_CORRECTA.getValor())
            return Response.status(Response.Status.OK).entity(objetoSalida).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(objetoSalida).build();
    }
   // @Override
   /* public Set<Class<?>> getClasses() {

        Set<Class<?>> clazzes = new HashSet();
        clazzes.add(JWTFiltro.class);
        clazzes.add(ListadosSERV.class);
        clazzes.add(UsuarioSERV.class);
        clazzes.add(DatosBasicosSERV.class);
        clazzes.add(ContactoSERV.class);
        clazzes.add(PersonaSERV.class);
        clazzes.add(RepresentanteSERV.class);
        return clazzes;
    }*/
}
