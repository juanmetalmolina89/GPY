CREATE OR REPLACE package PK_T015_TIPO_DOCUMENTO is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla PK_T015_TIPO_DOCUMENTO
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016
  FECHA MODIFICA    : 06/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T015_TIPO_DOCUMENTO';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A015DESCRPCNTIPDOCMNT IN GPYT_T015_TIPO_DOCUMENTO.A015DESCRPCNTIPDOCMNT%TYPE,
                         p_A015IDTIPPERSN IN GPYT_T015_TIPO_DOCUMENTO.A015IDTIPPERSN%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A015CODIGO IN GPYT_T015_TIPO_DOCUMENTO.A015CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A015CODIGO IN GPYT_T015_TIPO_DOCUMENTO.A015CODIGO%TYPE,
                           p_A015DESCRPCNTIPDOCMNT IN GPYT_T015_TIPO_DOCUMENTO.A015DESCRPCNTIPDOCMNT%TYPE,
                           p_A015IDTIPPERSN IN GPYT_T015_TIPO_DOCUMENTO.A015IDTIPPERSN%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T015_TIPO_DOCUMENTO; 