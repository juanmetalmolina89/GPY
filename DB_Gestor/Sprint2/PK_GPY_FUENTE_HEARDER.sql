--------------------------------------------------------
-- Archivo creado  - martes-diciembre-20-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_GPY_FUENTE
--------------------------------------------------------

create or replace PACKAGE PK_GPY_FUENTE
IS
  /*******************************************************************************
  DESCRIPCION       : Paquete encargado de la administración funcional del
                    : pre registro de control de fuentes deu n proyecto existente.
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 14/12/2016
  FECHA MODIFICA    : 14/12/2016
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  *********************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_FUENTE';
  TYPE CURSOR_SALIDA IS REF CURSOR;
  ----
    PROCEDURE Pr_RegistrarFuente(
        p_A038NOMBRFUNT      IN GPYT_T038_FUENTE.A038NOMBRFUNT%TYPE,
        p_A038IDPROYECTO     IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
        p_A038IDDESGRCATIPCC IN GPYT_T038_FUENTE.A038IDDESGRCATIPCC%TYPE,
        p_A038FACTOREMISION  IN GPYT_T038_FUENTE.A038FACTOREMISION%TYPE,
        p_idUsuario          IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        ----
    PROCEDURE Pr_EliminarFuente(
        p_A038CODIGO IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
        ----
    PROCEDURE Pr_ActualizarFuente(
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
    PROCEDURE Pr_ConsultarFtesId(
        p_A038CODIGO  IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
        p_idUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
	
    PROCEDURE Pr_ListarFuentesProyecto(
        p_A038IDPROYECTO  IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
        p_IdUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_GPY_FUENTE;
  /************************************************************************
  FIN creación del HEADER del package PK_GPY_FUENTE
  ************************************************************************/

/
