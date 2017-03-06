--------------------------------------------------------
-- Archivo creado  - mi�rcoles-febrero-01-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_GPY_POLITICA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "PK_GPY_POLITICA" 
IS
  /****************************************************************************
  DESCRIPCION       : Paquete encargado de la administraci�n funcional del
  : pre registro de politicas asociadas un proyecto existente.
  REALIZADO POR     : Fernando Mondrag�n Amaya
  FECHA CREACION    : 21/12/2016
  FECHA MODIFICA    : 21/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_POLITICA';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    ----
    PROCEDURE Pr_RegistrarPolitica(
        p_A007IDPROYECTO IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
        p_A003NIVEL1     IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
        p_A003NOMNIVEL1  IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
        p_A003NIVEL2     IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
        p_A003NOMNIVEL2  IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
        p_A003NIVEL3     IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
        p_A003NOMNIVEL3  IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
        p_A003NOMNIVEL4   IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
        P_A026CODIGO     IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
        p_idUsuario      IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_EliminarPolitica(
        p_A007CODIGO IN GPYT_T007_Proy_Politica.A007CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ListarPoliticasProyecto(
        p_A007IDPROYECTO IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
        p_IdUsuario      IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_RegistrarArchivoPolitica(
        p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
        p_A026NOMARCHIVO     IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
        p_A026HASHARCHIVO    IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
        p_IdUsuario          IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_GPY_POLITICA;
  /************************************************************************
  FIN creaci�n del HEADER del package PK_GPY_POLITICA
  ************************************************************************/

/
