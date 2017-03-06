CREATE OR REPLACE PACKAGE PK_GPY_APROBNACIONAL IS
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos 
                      y funciones para la administración de aprovbacion pre registro

  REALIZADO POR     : Andres Felipe Vargas Clavijo
  FECHA CREACION    : 25/01/2017

  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_APROBNACIONAL';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_CambiarEstado (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                p_EstadoProyecto IN GPYT_T002_PROYECTO.A002ESTADOPROYECTO%TYPE,
                                p_IdUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2);                              

  procedure Pr_AdjuntarArchivo (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                 p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                                 p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE, 
                                 p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,         
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2);                               
 

end PK_GPY_APROBNACIONAL;