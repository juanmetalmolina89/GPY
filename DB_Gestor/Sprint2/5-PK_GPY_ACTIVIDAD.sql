create or replace package PK_GPY_ACTIVIDAD is

  /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
                      para la administración de actividades

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 18/12/2016

  FECHA MODIFICA    : 19/01/2017
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Se incluyen el procedure ConsultarSoporte
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_ACTIVIDAD';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete

  PROCEDURE Pr_RegistrarActividad (p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
                                   p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,                                   
                                   p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                                   p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
                                   p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                                   p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,	                                   
                                   p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
                                   p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                                   p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);   
                                   
  PROCEDURE Pr_RegistrarSoporte (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,  
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2); 
                                 
  PROCEDURE Pr_RegistrarGeografia (p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                                   p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                                   p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
                                   p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                                   p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,  
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);                                    
  
  PROCEDURE Pr_ActualizarActividad (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                    p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
                                    p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,
                                    p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,    
                                    p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
                                    p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                                    p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,	                                    
                                    p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
                                    p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                                    p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                                    p_idUsuario IN NUMBER,                           
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
			            p_msjError OUT VARCHAR2);	
			            
  PROCEDURE Pr_ActualizarSoporte (p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                  p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                  p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                  p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2);   	                                

  -- elimina tambien el archivo de soporte			            
  PROCEDURE Pr_EliminarActividad (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2);
                                  
  PROCEDURE Pr_ConsultarActividadPorId (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                        p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                        p_idUsuario IN NUMBER,  
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
				        p_msjError OUT VARCHAR2);	                           	                          

  PROCEDURE Pr_ConsultarSoportePorId (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                      p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                      p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                                      p_idUsuario IN NUMBER,  
                                      p_Respuesta OUT CURSOR_SALIDA,
                                      p_codError OUT NUMBER,
				      p_msjError OUT VARCHAR2); 

  PROCEDURE Pr_ConsultarGeografiaPorId (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                                        p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                                        p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                                        p_idUsuario IN NUMBER,
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
                                        p_msjError OUT VARCHAR2); 	
                                        
  PROCEDURE Pr_ActualizarGeografia (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                                    p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                                    p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                                    p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
                                    p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                                    p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,  
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);                                          
				        
end PK_GPY_ACTIVIDAD;