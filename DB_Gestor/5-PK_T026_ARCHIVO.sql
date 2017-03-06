create or replace package PK_T026_ARCHIVO is

  /********************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T026_ARCHIVO

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016

  FECHA MODIFICA    : 19/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T026_ARCHIVO';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                         p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                         p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                           p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                           p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                           p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
					   
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
			           p_msjError OUT VARCHAR2);	                                                   

end PK_T026_ARCHIVO;