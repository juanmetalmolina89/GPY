create or replace PACKAGE          "PK_GPY_FUENTE" 
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
        p_A038IDUNIDAD       IN GPYT_T038_FUENTE.A038IDUNIDAD%TYPE, 
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
        p_A038IDUNIDAD       IN GPYT_T038_FUENTE.A038IDUNIDAD%TYPE, 
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
	    ---	
    PROCEDURE Pr_ListarFuentesProyecto(
        p_A038IDPROYECTO  IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
        p_IdUsuario IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);		
	    ---	
	PROCEDURE Pr_RegistrarEscenarioBase(
        p_A010REPRTANFUNT IN GPYT_T010_Reporte_Anio_Fuente.A010REPRTANFUNT%TYPE,
        p_A010VALREMSN    IN GPYT_T010_Reporte_Anio_Fuente.A010VALREMSN%TYPE,
        p_A010IDFUENTE    IN GPYT_T010_Reporte_Anio_Fuente.A010IDFUENTE%TYPE,
        p_idUsuario       IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
		---
	 PROCEDURE Pr_EliminarEscenarioBase(
        p_A010CODIGO IN GPYT_T010_Reporte_Anio_Fuente.A010CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
	    ---
	  PROCEDURE Pr_ListarEscenarioBase(
        p_A010IDFUENTE  IN GPYT_T010_Reporte_Anio_Fuente.A010IDFUENTE%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
  END PK_GPY_FUENTE;
  /************************************************************************
  FIN creación del HEADER del package PK_GPY_FUENTE
  ************************************************************************/