create or replace package PK_T020_DIVIPOLA is

  /******************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T020_DIVIPOLA

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 25/11/2016

  FECHA MODIFICA    : 20/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Se ajusta de acuerdo al DDL de la tabla
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T020_DIVIPOLA';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
 
  PROCEDURE Pr_Insertar (p_A020DIVIPOLA IN GPYT_T020_DIVIPOLA.A020DIVIPOLA%TYPE,         
                         p_A020CODPAIS IN GPYT_T020_DIVIPOLA.A020CODPAIS%TYPE,              
                         p_A020NOMPAIS IN GPYT_T020_DIVIPOLA.A020NOMPAIS%TYPE,                 
                         p_A020CODDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020CODDEPARTAMENTO%TYPE,      
                         p_A020NOMDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020NOMDEPARTAMENTO%TYPE,         
                         p_A020CODMUNICIPIO IN GPYT_T020_DIVIPOLA.A020CODMUNICIPIO%TYPE,         
                         p_A020NOMMUNICIPIO IN GPYT_T020_DIVIPOLA.A020NOMMUNICIPIO%TYPE,            
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Eliminar (p_A020CODIGO IN GPYT_T020_DIVIPOLA.A020CODIGO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Actualizar (p_A020CODIGO IN GPYT_T020_DIVIPOLA.A020CODIGO%TYPE,
                           p_A020DIVIPOLA IN GPYT_T020_DIVIPOLA.A020DIVIPOLA%TYPE,         
                           p_A020CODPAIS IN GPYT_T020_DIVIPOLA.A020CODPAIS%TYPE,              
                           p_A020NOMPAIS IN GPYT_T020_DIVIPOLA.A020NOMPAIS%TYPE,                 
                           p_A020CODDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020CODDEPARTAMENTO%TYPE,      
                           p_A020NOMDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020NOMDEPARTAMENTO%TYPE,         
                           p_A020CODMUNICIPIO IN GPYT_T020_DIVIPOLA.A020CODMUNICIPIO%TYPE,         
                           p_A020NOMMUNICIPIO IN GPYT_T020_DIVIPOLA.A020NOMMUNICIPIO%TYPE,            
                           p_idUsuario IN NUMBER,                         
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2);

  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);

  PROCEDURE Pr_ConsultarPorId (p_A020CODIGO IN GPYT_T020_DIVIPOLA.A020CODIGO%TYPE,
                               p_idUsuario IN NUMBER,  
                               p_Respuesta OUT CURSOR_SALIDA,
                               p_codError OUT NUMBER,
                               p_msjError OUT VARCHAR2);
                                                                                                   
end PK_T020_DIVIPOLA;