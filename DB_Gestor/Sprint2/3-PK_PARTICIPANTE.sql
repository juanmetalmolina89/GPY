--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-16-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_PARTICIPANTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "GESTOR"."PK_PARTICIPANTE" 
IS
  /************************************************************************
  DESCRIPCION       : Paquete encargado de la administración funcional del
                    : pre registro de participantes a un proyecto existente.
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 12/12/2016
  FECHA MODIFICA    : 12/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_PARTICIPANTE';
  TYPE CURSOR_SALIDA IS REF CURSOR;
    ----
    PROCEDURE Pr_RegistrarParticipante(
        p_A05IDPROYECTO       IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
        p_A051IDPERSONA       IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
        p_A051RESPONSABILIDAD IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,
        p_idUsuario           IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_EliminarParticipante(
        p_A051CODIGO IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ActualizarParticipante(
        p_A051CODIGO          IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
        p_A05IDPROYECTO       IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
        p_A051IDPERSONA       IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
        p_A051RESPONSABILIDAD IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,
        p_idUsuario           IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    -----
    PROCEDURE Pr_ConsultarParticipante(
        p_A051CODIGO IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
        p_IdUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ListarParticipantes(
        p_IdUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ListarParticipantesProyecto(
        p_A05IDPROYECTO IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
        p_IdUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_PARTICIPANTE;
  /************************************************************************
  FIN creación del HEADER del package PK_PARTICIPANTE
  ************************************************************************/

/
