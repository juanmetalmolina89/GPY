--------------------------------------------------------
-- Archivo creado  - jueves-enero-05-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_T004_PROY_FTE_FINANC
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "PK_T004_PROY_FTE_FINANC" 
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla PK_T004_PROY_FTE_FINANC
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 29/12/2016
  FECHA MODIFICA    : 29/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T004_Proy_Fte_Financ';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    ----
    PROCEDURE Pr_Insertar(
        p_A004IDPROYECTO    IN GPYT_T004_Proy_Fte_Financ.A004IDPROYECTO%TYPE,
        p_A004IDFUNTFINNCCN IN GPYT_T004_Proy_Fte_Financ.A004IDFUNTFINNCCN%TYPE,
        p_idUsuario         IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_Eliminar(
        p_A004CODIGO IN GPYT_T004_Proy_Fte_Financ.A004CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_Actualizar(
        p_A004CODIGO        IN GPYT_T004_Proy_Fte_Financ. A004CODIGO%TYPE,
        p_A004IDPROYECTO    IN GPYT_T004_Proy_Fte_Financ.A004IDPROYECTO%TYPE,
        p_A004IDFUNTFINNCCN IN GPYT_T004_Proy_Fte_Financ.A004IDFUNTFINNCCN%TYPE,
        p_idUsuario         IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ConsultarPorFiltro(
        p_Filtro    IN VARCHAR2,
        p_idUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_T004_Proy_Fte_Financ;
  /************************************************************************
  FIN creación del HEADER del package PK_T004_Proy_Fte_Financ
  ************************************************************************/

/
