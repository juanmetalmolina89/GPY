--------------------------------------------------------
-- Archivo creado  - lunes-diciembre-19-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_T038_FUENTE
--------------------------------------------------------
create or replace PACKAGE PK_T038_FUENTE
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla GPYT_T038_FUENTE
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 13/12/2016
  FECHA MODIFICA    : 13/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T038_FUENTE';
  TYPE CURSOR_SALIDA IS REF CURSOR;
  ----
    PROCEDURE Pr_Insertar(
        p_A038NOMBRFUNT      IN GPYT_T038_FUENTE.A038NOMBRFUNT%TYPE,
        p_A038IDPROYECTO     IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
        p_A038IDDESGRCATIPCC IN GPYT_T038_FUENTE.A038IDDESGRCATIPCC%TYPE,
        p_A038FACTOREMISION  IN GPYT_T038_FUENTE.A038FACTOREMISION%TYPE,
        p_idUsuario          IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        ----
    PROCEDURE Pr_Eliminar(
        p_A038CODIGO IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        ----
    PROCEDURE Pr_Actualizar(
        p_A038CODIGO         IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
        p_A038NOMBRFUNT      IN GPYT_T038_FUENTE.A038NOMBRFUNT%TYPE,
        p_A038IDPROYECTO     IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
        p_A038IDDESGRCATIPCC IN GPYT_T038_FUENTE.A038IDDESGRCATIPCC%TYPE,
        p_A038FACTOREMISION  IN GPYT_T038_FUENTE.A038FACTOREMISION%TYPE,
        P_idUsuario          IN NUMBER,
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
  END PK_T038_FUENTE;
  /************************************************************************
  FIN creación del HEADER del package PK_T038_FUENTE
  ************************************************************************/

/
