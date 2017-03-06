create or replace package PK_T054_CONTACTO is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T054_CONTACTO
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016
  FECHA MODIFICA    : 06/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T054_CONTACTO';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A054IDPERSONA IN GPYT_T054_CONTACTO.A054IDPERSONA%TYPE,
                         p_A054IDCONTACTO IN GPYT_T054_CONTACTO.A054IDCONTACTO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A054CODIGO IN GPYT_T054_CONTACTO.A054CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A054CODIGO IN GPYT_T054_CONTACTO.A054CODIGO%TYPE,
                           p_A054IDPERSONA IN GPYT_T054_CONTACTO.A054IDPERSONA%TYPE,
                           p_A054IDCONTACTO IN GPYT_T054_CONTACTO.A054IDCONTACTO%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			                     p_msjError OUT VARCHAR2);	
                           
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);
                                   
  end PK_T054_CONTACTO;