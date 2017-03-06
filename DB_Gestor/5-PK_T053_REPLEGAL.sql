create or replace package PK_T053_REPLEGAL is

  /********************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T053_REPLEGAL

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016

  FECHA MODIFICA    : 07/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T053_REPLEGAL';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                         p_A053IDREPRESENTANTE IN GPYT_T053_REPLEGAL.A053IDREPRESENTANTE%TYPE,
                         p_A053TIPOREPRESENTANTE IN GPYT_T053_REPLEGAL.A053TIPOREPRESENTANTE%TYPE, 
                         p_A053IDARCHIVO IN GPYT_T053_REPLEGAL.A053IDARCHIVO%TYPE, 
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                           p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                           p_A053IDREPRESENTANTE IN GPYT_T053_REPLEGAL.A053IDREPRESENTANTE%TYPE,
                           p_A053TIPOREPRESENTANTE IN GPYT_T053_REPLEGAL.A053TIPOREPRESENTANTE%TYPE,
                           p_A053IDARCHIVO IN GPYT_T053_REPLEGAL.A053IDARCHIVO%TYPE,                           
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			                     p_msjError OUT VARCHAR2);	
					   
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
				                           p_msjError OUT VARCHAR2);	                           	                          

end PK_T053_REPLEGAL;