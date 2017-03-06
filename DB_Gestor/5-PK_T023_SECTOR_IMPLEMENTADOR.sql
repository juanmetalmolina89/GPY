create or replace package PK_T023_SECTOR_IMPLEMENTADOR is

  /****************************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T023_SECTOR_IMPLEMENTADOR

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 15/11/2016

  FECHA MODIFICA    : 06/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ******************************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T023_SECTOR_IMPLEMENTADOR';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
 
  PROCEDURE Pr_Insertar (p_A023DESCSECTRIMPLMNTDR IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023DESCSECTRIMPLMNTDR%TYPE,
			 p_A023IDTIPPROYCT IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023IDTIPPROYCT%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A023CODIGO IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023CODIGO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Actualizar (p_A023CODIGO IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023CODIGO%TYPE,
                           p_A023DESCSECTRIMPLMNTDR IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023DESCSECTRIMPLMNTDR%TYPE,
                           p_A023IDTIPPROYCT IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023IDTIPPROYCT%TYPE,                           
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2);

  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);
                                                                                          
end PK_T023_SECTOR_IMPLEMENTADOR;