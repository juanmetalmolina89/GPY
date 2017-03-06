create or replace package PK_T058_TIPO_ACTIV_REDUCCION is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T058_TIPO_ACTIV_REDUCCION
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 25/01/2017
  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T058_TIPO_ACTIV_REDUCCION';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A058DESCRIPCION IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058DESCRIPCION%TYPE,   
                         p_A058TIPPROYCT IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058TIPPROYCT%TYPE,   
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A058CODIGO IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A058CODIGO IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058CODIGO%TYPE, 
			   p_A058DESCRIPCION IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058DESCRIPCION%TYPE,   
                           p_A058TIPPROYCT IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058TIPPROYCT%TYPE,   
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T058_TIPO_ACTIV_REDUCCION;