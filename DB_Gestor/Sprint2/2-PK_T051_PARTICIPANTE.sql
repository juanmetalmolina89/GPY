--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-16-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_T051_PARTICIPANTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "GESTOR"."PK_T051_PARTICIPANTE" 
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla GPYT_T051_PARTICIPANTE
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 12/12/2016
  FECHA MODIFICA    : 12/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T051_PARTICIPANTE';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    ----
    PROCEDURE Pr_Insertar(
        p_A05IDPROYECTO           IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
        p_A051IDPERSONA           IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
        p_A051RESPONSABILIDAD     IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,      
        p_idUsuario               IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        ----
    PROCEDURE Pr_Eliminar(
        p_A051CODIGO IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        ----
    PROCEDURE Pr_Actualizar(
        p_A051CODIGO              IN GPYT_T051_PARTICIPANTE. A051CODIGO%TYPE,
        p_A05IDPROYECTO           IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
        p_A051IDPERSONA           IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
        p_A051RESPONSABILIDAD     IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,       
        p_idUsuario               IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        -----
    PROCEDURE Pr_ConsultarPorFiltro(
        p_Filtro    IN VARCHAR2,
        p_idUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_T051_PARTICIPANTE;
  /************************************************************************
  FIN creación del HEADER del package PK_T051_PARTICIPANTE
  ************************************************************************/

/
