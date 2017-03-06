create or replace package PK_UTL_UTILIDAD is

  /********************************************************************************
  DESCRIPCION    : Paquete utilizado para agrupar todos los procedimientos y funciones
                   de utilidades como declaraciones de variables, tipos, listas genericas,
                   registro de log de operaciones, registro de excepciones, mensajes de respuesta
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION    : 31/08/2016
  
  FECHA MODIFICA    : 13/11/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Se elimina el filtro
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_UTL_UTILIDAD';

  TYPE CURSOR_SALIDA IS REF CURSOR;

 
  -- Funciones y Procedimientos del paquete

  FUNCTION Fn_ObtenerId (p_nombreSeq IN VARCHAR2) RETURN NUMBER;

  PROCEDURE Pr_RegistrarDebug (p_nivelDebug    IN NUMBER,
                               p_paquete       IN VARCHAR2,
                               p_procedimiento IN VARCHAR2,
                               p_usuario       IN NUMBER,
                               p_descripcion   IN VARCHAR2);

  FUNCTION Fn_ObtenerMensaje (p_codError IN VARCHAR2) RETURN VARCHAR2;

  FUNCTION Fn_RegistrarExcepcion (p_usuario       IN NUMBER,
                                  p_paquete       IN VARCHAR2,
                                  p_procedimiento IN VARCHAR2,
                                  p_codError      IN NUMBER,
                                  p_msjError      IN VARCHAR2) RETURN NUMBER;

  FUNCTION Fn_RegistrarAuditoria (p_A996IDOBJETO      IN NUMBER,
                                  p_A996OBJETO        IN VARCHAR2,
                                  p_A996OPERACION     IN VARCHAR2,
                                  p_A996USUARIO       IN NUMBER,
                                  p_A996PROCEDIMIENTO IN VARCHAR2,
                                  p_A996PAQUETE       IN VARCHAR2) RETURN NUMBER;
    
    
  PROCEDURE Pr_ConsultarLista (p_Categoria IN VARCHAR2,
                               p_datRespuesta OUT CURSOR_SALIDA,
                               p_codError  OUT NUMBER,
                               p_msjError  OUT VARCHAR2);
                              
end PK_UTL_UTILIDAD;