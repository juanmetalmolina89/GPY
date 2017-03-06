create or replace package PK_T022_TIPO_ACTIVIDAD is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T022_TIPO_ACTIVIDAD
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 17/11/2016
  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T022_TIPO_ACTIVIDAD';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A022DESCRPCNACTVDD IN GPYT_T022_TIPO_ACTIVIDAD.A022DESCRPCNACTVDD%TYPE,
                         p_A022IDTIPPROYCT IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCT%TYPE,
                         p_A022IDTIPPROYCTMDL IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCTMDL%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A022CODIGO IN GPYT_T022_TIPO_ACTIVIDAD.A022CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A022CODIGO IN GPYT_T022_TIPO_ACTIVIDAD.A022CODIGO%TYPE,
                           p_A022DESCRPCNACTVDD IN GPYT_T022_TIPO_ACTIVIDAD.A022DESCRPCNACTVDD%TYPE,
                           p_A022IDTIPPROYCT IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCT%TYPE,
                           p_A022IDTIPPROYCTMDL IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCTMDL%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T022_TIPO_ACTIVIDAD;