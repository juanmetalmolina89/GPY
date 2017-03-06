create or replace package PK_T042_ACTIVIDAD_GEOMETRIA is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T042_ACTIVIDAD_GEOMETRIA
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 18/12/2016
  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T042_ACTIVIDAD_GEOMETRIA';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                         p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                         p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
                         p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                         p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                           p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
			   p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
			   p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
			   p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                           p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T042_ACTIVIDAD_GEOMETRIA;