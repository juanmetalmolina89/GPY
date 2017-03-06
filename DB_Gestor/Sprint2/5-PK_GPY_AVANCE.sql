create or replace package PK_GPY_AVANCE is
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos 
                      y funciones para la administración del avance en el 
                      ingreso de la información
  
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 25/12/2016
  
  FECHA MODIFICA    : 14/01/2017
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Se agrega el metodo actualizar_avance
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_AVANCE';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_RegistrarAvance (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                                p_IdUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2);                              
                                 
  procedure Pr_ConsultarAvance (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                p_IdUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2);                              

  procedure Pr_ActualizarAvance (p_A057CODIGO IN GPYT_T057_AVANCE_PANTALLA.A057CODIGO%TYPE,
                                 p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                 p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                                 p_IdUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2);  
                                         
end PK_GPY_AVANCE;