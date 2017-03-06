--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-23-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_T003_POLITICA
--------------------------------------------------------

create or replace PACKAGE PK_T003_POLITICA
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla GPYT_T003_POLITICA
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 21/12/2016
  FECHA MODIFICA    : 21/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T003_POLITICA';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    ----
    PROCEDURE Pr_Insertar(
        p_A003NIVEL1        IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
        p_A003NOMNIVEL1     IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
        p_A003NIVEL2        IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
        p_A003NOMNIVEL2     IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
        p_A003NIVEL3        IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
        p_A003NOMNIVEL3     IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
        p_A003NIVEL4        IN GPYT_T003_POLITICA.A003NIVEL4%TYPE,
        p_A003NOMNIVEL4      IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
        p_A003DESCRPCNPOLTC IN GPYT_T003_POLITICA.A003DESCRPCNPOLTC%TYPE,
        p_A003IDARCHIV      IN GPYT_T003_POLITICA.A003IDARCHIV%TYPE,
        p_idUsuario         IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_Eliminar(
        p_A003CODIGO IN GPYT_T003_POLITICA.A003CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_Actualizar(
        p_A003CODIGO        IN GPYT_T003_POLITICA. A003CODIGO%TYPE,
        p_A003NIVEL1        IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
        p_A003NOMNIVEL1     IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
        p_A003NIVEL2        IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
        p_A003NOMNIVEL2     IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
        p_A003NIVEL3        IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
        p_A003NOMNIVEL3     IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
        p_A003NIVEL4        IN GPYT_T003_POLITICA.A003NIVEL4%TYPE,
        p_A003NOMNIVEL4      IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
        p_A003DESCRPCNPOLTC IN GPYT_T003_POLITICA.A003DESCRPCNPOLTC%TYPE,
        p_A003IDARCHIV      IN GPYT_T003_POLITICA.A003IDARCHIV%TYPE,
        p_idUsuario         IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ConsultarPorFiltro(
        p_Filtro    IN VARCHAR2,
        p_idUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_T003_POLITICA;
  /************************************************************************
  FIN creación del HEADER del package PK_T003_POLITICA
  ************************************************************************/

/
