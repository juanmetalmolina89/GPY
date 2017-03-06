--------------------------------------------------------
-- Archivo creado  - jueves-febrero-02-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_GPY_FINANCIACION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "GESTOR"."PK_GPY_FINANCIACION" 
IS
  /****************************************************************************
  DESCRIPCION       : Paquete encargado de la administración funcional del
  : pre registro de Pre registro de Costos y Financiación .
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 29/12/2016
  FECHA MODIFICA    : 29/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_FINANCIACION';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    /*****
    Este procedimiento(Pr_RegistrarCostosProyecto) Registra y actualiza los costos por por proyecto
    ---*****/
    PROCEDURE Pr_RegistrarCostosProyecto(
        p_A002CODIGO            IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
        p_A002COSTSESTMDTOTL    IN GPYT_T002_PROYECTO.A002COSTSESTMDTOTL%TYPE,
        P_A002COSTSESTMDFORMLCN IN GPYT_T002_PROYECTO.A002COSTSESTMDFORMLCN%TYPE,
        P_A002COSTTONLDRDCR     IN GPYT_T002_PROYECTO.A002COSTTONLDRDCR%TYPE,
        P_A002TRM               IN GPYT_T002_PROYECTO.A002TRM%TYPE,
        P_A002BUSQUDFINNCCN     IN GPYT_T002_PROYECTO.A002BUSQUDFINNCCN%TYPE,
        p_idUsuario             IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    /*****
    Se definió con arquitectura, que en el momento de ingresar las posibles fuentes de financiación para un proyecto,
    la capa de acceso a base de datos enviará  o dará manejo
    por cada fuente enviándola por individual al procedimiento (Pr_RegistrarFuenteFinaciacion) encargado de dicho registro.
    ---*****/
    PROCEDURE Pr_RegistrarFuenteFinaciacion(
        P_A004IDPROYECTO    IN GPYT_T004_PROY_FTE_FINANC.A004IDPROYECTO%TYPE,
        P_A004IDFUNTFINNCCN IN GPYT_T004_PROY_FTE_FINANC.A004IDFUNTFINNCCN%TYPE,
        p_idUsuario         IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    /*****
    Se definió con arquitectura, que en el momento de eliminar las posibles fuentes de financiación para un proyecto,
    la capa de acceso a base de datos enviará  o dará manejo
    por cada fuente enviándola por individual al procedimiento (Pr_EliminarFuenteFinaciacion) encargado de dicho registro.
    ---*****/
    PROCEDURE Pr_EliminarFuenteFinaciacion(
        P_A004IDPROYECTO    IN GPYT_T004_PROY_FTE_FINANC.A004IDPROYECTO%TYPE,
        P_A004IDFUNTFINNCCN IN GPYT_T004_PROY_FTE_FINANC.A004IDFUNTFINNCCN%TYPE,
        p_idUsuario         IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ListarCostosProyecto(
        p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ListarFuenteFinaciacion(
        P_A004IDPROYECTO IN GPYT_T004_PROY_FTE_FINANC.A004IDPROYECTO%TYPE,
        p_idUsuario      IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_RegistrarInstrmnt_FinnccnP(
        p_A009IDTIPINSTRMNTF  IN GPYT_T009_Instrmnt_Finnccn.A009IDTIPINSTRMNTF%TYPE,
        p_A009IDPROYECTO      IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
        p_A009PORFINNCCNESTMD IN GPYT_T009_Instrmnt_Finnccn.A009PORFINNCCNESTMD%TYPE,
        p_idUsuario           IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_ListarInstrmnt_FinnccnP(
        p_A009IDPROYECTO IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
        p_idUsuario      IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_EliminarInstrmnt_FinnccnP(
        p_A009CODIGO IN GPYT_T009_Instrmnt_Finnccn.A009CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_GPY_FINANCIACION;
  /************************************************************************
  FIN creación del HEADER del package PK_GPY_FINANCIACION
  ************************************************************************/

/
