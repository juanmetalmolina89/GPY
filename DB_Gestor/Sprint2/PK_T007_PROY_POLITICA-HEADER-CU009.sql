--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-23-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_T007_PROY_POLITICA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "GESTOR"."PK_T007_PROY_POLITICA" 
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla GPYT_T007_Proy_Politica
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 21/12/2016
  FECHA MODIFICA    : 21/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T007_Proy_Politica';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    ----
    PROCEDURE Pr_Insertar(
        p_A007IDPROYECTO          IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
        p_A007IDPOLITICA          IN GPYT_T007_Proy_Politica.A007IDPOLITICA%TYPE,
        p_idUsuario               IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_Eliminar(
        p_A007CODIGO IN GPYT_T007_Proy_Politica.A007CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
	----	
    PROCEDURE Pr_Actualizar(
        p_A007CODIGO              IN GPYT_T007_Proy_Politica. A007CODIGO%TYPE,
        p_A007IDPROYECTO          IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
        p_A007IDPOLITICA          IN GPYT_T007_Proy_Politica.A007IDPOLITICA%TYPE,
        p_idUsuario               IN NUMBER,
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
  END PK_T007_Proy_Politica;
  /************************************************************************
  FIN creación del HEADER del package PK_T007_Proy_Politica
  ************************************************************************/

/
