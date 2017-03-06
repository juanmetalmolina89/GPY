create or replace package PK_T049_CODIGOCIIU is

  /********************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T049_CODIGOCIIU

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 29/11/2016

  FECHA MODIFICA    : 06/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: 
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T049_CODIGOCIIU';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A049CODIGOCIIU IN GPYT_T049_CODIGOCIIU.A049CODIGOCIIU%TYPE,
                         p_A049DESCRIPCIONCIIU IN GPYT_T049_CODIGOCIIU.A049DESCRIPCIONCIIU%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
						             p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A049CODIGO IN GPYT_T049_CODIGOCIIU.A049CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
						             p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A049CODIGO IN GPYT_T049_CODIGOCIIU.A049CODIGO%TYPE,
                           p_A049CODIGOCIIU IN GPYT_T049_CODIGOCIIU.A049CODIGOCIIU%TYPE,
                           p_A049DESCRIPCIONCIIU IN GPYT_T049_CODIGOCIIU.A049DESCRIPCIONCIIU%TYPE,
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
						               p_msjError OUT VARCHAR2);	
					   
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
						                       p_msjError OUT VARCHAR2);	                           
                       
end PK_T049_CODIGOCIIU;