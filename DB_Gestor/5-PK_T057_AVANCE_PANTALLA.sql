create or replace package PK_T057_AVANCE_PANTALLA is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T057_AVANCE_PANTALLA
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 25/12/2016
  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T057_AVANCE_PANTALLA';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A057IDPROYECTO IN GPYT_T057_AVANCE_PANTALLA.A057IDPROYECTO%TYPE,
                         p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A057CODIGO IN GPYT_T057_AVANCE_PANTALLA.A057CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A057CODIGO IN GPYT_T057_AVANCE_PANTALLA.A057CODIGO%TYPE,
                           p_A057IDPROYECTO IN GPYT_T057_AVANCE_PANTALLA.A057IDPROYECTO%TYPE,
                           p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T057_AVANCE_PANTALLA;