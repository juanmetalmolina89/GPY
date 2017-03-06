create or replace package PK_T006_PROY_SECTR_IMPLMNTDR is

  /****************************************************************************************
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla T006_PROY_SECTR_IMPLMNTDR

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016

  FECHA MODIFICA    : 02/12/2017
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes a los metodos, se eliminan Listar y consultar por Id
  ******************************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T006_PROY_SECTR_IMPLMNTDR';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
 
  PROCEDURE Pr_Insertar (p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                         p_A006IDSECTRIMPLMNTDR IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDSECTRIMPLMNTDR%TYPE,
                         p_A006DETALLEOTRO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006DETALLEOTRO%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A006CODIGO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006CODIGO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Actualizar (p_A006CODIGO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006CODIGO%TYPE,
                           p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                           p_A006IDSECTRIMPLMNTDR IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDSECTRIMPLMNTDR%TYPE,
                           p_A006DETALLEOTRO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006DETALLEOTRO%TYPE,
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2);

  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);                               
                               
end PK_T006_PROY_SECTR_IMPLMNTDR;