create or replace package PK_T001_ENTIDAD is

  /********************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T001_ENTIDAD

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016

  FECHA MODIFICA    : 02/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T001_ENTIDAD';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A001SIGLA IN GPYT_T001_ENTIDAD.A001SIGLA%TYPE,
                         p_A001NOMBRE IN GPYT_T001_ENTIDAD.A001NOMBRE%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A001CODIGO IN GPYT_T001_ENTIDAD.A001CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A001CODIGO IN GPYT_T001_ENTIDAD.A001CODIGO%TYPE,
                           p_A001SIGLA IN GPYT_T001_ENTIDAD.A001SIGLA%TYPE,
                           p_A001NOMBRE IN GPYT_T001_ENTIDAD.A001NOMBRE%TYPE,
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
					   
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
				   p_msjError OUT VARCHAR2);	                           	                          

end PK_T001_ENTIDAD;