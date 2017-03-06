create or replace package PK_T005_ACTIVIDAD is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T005_ACTIVIDAD
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 17/12/2016
  FECHA MODIFICA    : Luis Felipe Galeano Castro
  MODIFICADO POR    : 24/12/2016
  DESCRIPCION CAMBIO: Se incluyen los campos fecha inicial y final
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T005_ACTIVIDAD';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
                         p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,
                         p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                         p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
                         p_A005IDSOPORTE IN GPYT_T005_ACTIVIDAD.A005IDSOPORTE%TYPE,
                         p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                         p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,
                         p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
                         p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                         p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                           p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
			   p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,
			   p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
			   p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
			   p_A005IDSOPORTE IN GPYT_T005_ACTIVIDAD.A005IDSOPORTE%TYPE,
                           p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                           p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,			   
                           p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
			   p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                           p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T005_ACTIVIDAD;