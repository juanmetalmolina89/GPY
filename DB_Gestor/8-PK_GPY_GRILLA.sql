create or replace package PK_GPY_GRILLA is
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos 
                      y funciones para la administración de las grillas
  
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/12/2016
  
  FECHA MODIFICA    : 26/01/2017
  MODIFICADO POR    : Luis Felipe Galeano Castro 
  DESCRIPCION CAMBIO: Se agregan los metodos: Pr_ListarActividades y 
                      Pr_ListarActividadesPorClave
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_GRILLA';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_ListarProyectos (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                                p_IdUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2);                              
                                 
  procedure Pr_ListarProyectosPorClave (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                                        p_Clave IN VARCHAR2,
                                        p_IdUsuario IN NUMBER,
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
                                        p_msjError OUT VARCHAR2);                              

  procedure Pr_ListarActividades (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                  p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                                  p_IdUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2);  
                                  
  procedure Pr_ListarActividadesPorClave (p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                                          p_Clave IN VARCHAR2,
                                          p_IdUsuario IN NUMBER,
                                          p_Respuesta OUT CURSOR_SALIDA,
                                          p_codError OUT NUMBER,
                                          p_msjError OUT VARCHAR2);                                   
                                          
end PK_GPY_GRILLA;