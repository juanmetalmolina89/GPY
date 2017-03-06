create or replace package PK_T025_ADJUNTO is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T025_ADJUNTO
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 25/12/2016
  FECHA MODIFICA    : 
  MODIFICADO POR    : 
  DESCRIPCION CAMBIO: 
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T025_ADJUNTO';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A025NOMBRADJNT IN GPYT_T025_ADJUNTO.A025NOMBRADJNT%TYPE,   
                         p_A025DESCRPCNADJNT IN GPYT_T025_ADJUNTO.A025DESCRPCNADJNT%TYPE,  
                         p_A025IDTIPPROYCT IN GPYT_T025_ADJUNTO.A025IDTIPPROYCT%TYPE,    
                         p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,     
                         p_A025APLICPCNADJNT IN GPYT_T025_ADJUNTO.A025APLICPCNADJNT%TYPE,  
                         p_A025NOMFORMATO IN GPYT_T025_ADJUNTO.A025NOMFORMATO%TYPE,     
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A025CODIGO IN GPYT_T025_ADJUNTO.A025CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A025CODIGO IN GPYT_T025_ADJUNTO.A025CODIGO%TYPE,
                           p_A025NOMBRADJNT IN GPYT_T025_ADJUNTO.A025NOMBRADJNT%TYPE,   
			   p_A025DESCRPCNADJNT IN GPYT_T025_ADJUNTO.A025DESCRPCNADJNT%TYPE,  
			   p_A025IDTIPPROYCT IN GPYT_T025_ADJUNTO.A025IDTIPPROYCT%TYPE,    
			   p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,     
			   p_A025APLICPCNADJNT IN GPYT_T025_ADJUNTO.A025APLICPCNADJNT%TYPE,  
                           p_A025NOMFORMATO IN GPYT_T025_ADJUNTO.A025NOMFORMATO%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T025_ADJUNTO;