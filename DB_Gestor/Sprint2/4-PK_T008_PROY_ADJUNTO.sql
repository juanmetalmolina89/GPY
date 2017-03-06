create or replace package PK_T008_PROY_ADJUNTO is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T008_PROY_ADJUNTO
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 25/12/2016
  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T008_PROY_ADJUNTO';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A008IDPROYECTO IN GPYT_T008_PROY_ADJUNTO.A008IDPROYECTO%TYPE,
                         p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                         p_A008IDARCHV IN GPYT_T008_PROY_ADJUNTO.A008IDARCHV%TYPE,
                         p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                         p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A008CODIGO IN GPYT_T008_PROY_ADJUNTO.A008CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A008CODIGO IN GPYT_T008_PROY_ADJUNTO.A008CODIGO%TYPE,
                           p_A008IDPROYECTO IN GPYT_T008_PROY_ADJUNTO.A008IDPROYECTO%TYPE,
			   p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
			   p_A008IDARCHV IN GPYT_T008_PROY_ADJUNTO.A008IDARCHV%TYPE,
			   p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                           p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T008_PROY_ADJUNTO;