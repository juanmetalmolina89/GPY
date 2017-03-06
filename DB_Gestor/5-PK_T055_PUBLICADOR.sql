create or replace package PK_T055_PUBLICADOR is

 /***********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T055_PUBLICADOR
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016
  FECHA MODIFICA    : 10/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
 ************************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T055_PUBLICADOR';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A055IDPERSONA IN GPYT_T055_PUBLICADOR.A055IDPERSONA%TYPE,
                         p_A055IDPUBLICADOR IN GPYT_T055_PUBLICADOR.A055IDPUBLICADOR%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A055CODIGO IN GPYT_T055_PUBLICADOR.A055CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A055CODIGO IN GPYT_T055_PUBLICADOR.A055CODIGO%TYPE,
                           p_A055IDPERSONA IN GPYT_T055_PUBLICADOR.A055IDPERSONA%TYPE,
                           p_A055IDPUBLICADOR IN GPYT_T055_PUBLICADOR.A055IDPUBLICADOR%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);
                                   
  end PK_T055_PUBLICADOR;