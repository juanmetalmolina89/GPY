CREATE OR REPLACE PACKAGE PK_T009_INSTRMNT_FINNCCN
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla PK_T009_INSTRMNT_FINNCCN
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 12/01/2017
  FECHA MODIFICA    : 12/01/2017
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T009_INSTRMNT_FINNCCN';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    -- Funciones y Procedimientos del paquete:
    -- PROCEDURE Pr_Insertar
    -- PROCEDURE Pr_Eliminar
    -- PROCEDURE Pr_Actualizar
    -- PROCEDURE Pr_ConsultarPorFiltro
    ----
    PROCEDURE Pr_Insertar(
        p_A009IDTIPINSTRMNTF      IN GPYT_T009_Instrmnt_Finnccn.A009IDTIPINSTRMNTF%TYPE,
        p_A009IDPROYECTO          IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
        p_A009PORFINNCCNESTMD     IN GPYT_T009_Instrmnt_Finnccn.A009PORFINNCCNESTMD%TYPE,       
        p_idUsuario               IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_Eliminar(
        p_A009CODIGO IN GPYT_T009_Instrmnt_Finnccn.A009CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_Actualizar(
        p_A009CODIGO              IN GPYT_T009_Instrmnt_Finnccn. A009CODIGO%TYPE,
        p_A009IDTIPINSTRMNTF      IN GPYT_T009_Instrmnt_Finnccn.A009IDTIPINSTRMNTF%TYPE,
        p_A009IDPROYECTO          IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
        p_A009PORFINNCCNESTMD     IN GPYT_T009_Instrmnt_Finnccn.A009PORFINNCCNESTMD%TYPE,      
        p_idUsuario               IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ConsultarPorFiltro(
        p_Filtro    IN VARCHAR2,
        p_idUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_T009_INSTRMNT_FINNCCN;
  /************************************************************************
  FIN creación del HEADER del package PK_T009_INSTRMNT_FINNCCN
  ************************************************************************/ 