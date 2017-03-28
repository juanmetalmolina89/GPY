create or replace PACKAGE          "PK_T013_AVANCE_PROYECTO" 
IS
  /************************************************************************
  DESCRIPCION       : Servicios CRUD sobre la tabla GPYT_T013_Avance_Proyecto
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 03/03/2017
  FECHA MODIFICA    : 03/03/2017
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  ************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T013_AVANCE_PROYECTO';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    ----
    PROCEDURE Pr_Insertar(
        p_A013FECHREPRT            IN GPYT_T013_Avance_Proyecto.A013FECHREPRT%TYPE,
        p_A013CAMBSIGNFCTV         IN GPYT_T013_Avance_Proyecto.A013CAMBSIGNFCTV%TYPE,
        p_A013COSTTONLD            IN GPYT_T013_Avance_Proyecto.A013COSTTONLD%TYPE,
        p_A013FINANCCN             IN GPYT_T013_Avance_Proyecto.A013FINANCCN%TYPE,
        p_A013FECHAVNCPROYCT       IN GPYT_T013_Avance_Proyecto.A013FECHAVNCPROYCT%TYPE,
        p_A013OPTAPAGORESULTADOS   IN GPYT_T013_Avance_Proyecto.A013OPTAPAGORESULTADOS%TYPE,
        p_A013IDPROYECTO           IN GPYT_T013_Avance_Proyecto.A013IDPROYECTO%TYPE,
        p_A013EMISREDCXVERIFICAR   IN GPYT_T013_Avance_Proyecto.A013EMISREDCXVERIFICAR%TYPE,
        p_A013EMISREDCVERIFICADAS  IN GPYT_T013_Avance_Proyecto.A013EMISREDCVERIFICADAS%TYPE,
        p_A013EMISREDCDISPNTRANSAR IN GPYT_T013_Avance_Proyecto.A013EMISREDCDISPNTRANSAR%TYPE,
        p_A013EMISREDCTRANSADAS    IN GPYT_T013_Avance_Proyecto.A013EMISREDCTRANSADAS%TYPE,
        p_A013IDARCHV              IN GPYT_T013_Avance_Proyecto.A013IDARCHV%TYPE,
        p_A013NROCPAS              IN GPYT_T013_Avance_Proyecto.A013NROCPAS%TYPE,
        p_A013HAYNUEVOCPA          IN GPYT_T013_Avance_Proyecto.A013HAYNUEVOCPA%TYPE,
        p_idUsuario                IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_Eliminar(
        p_A013CODIGO IN GPYT_T013_Avance_Proyecto.A013CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ----
    PROCEDURE Pr_Actualizar(
        p_A013CODIGO               IN GPYT_T013_Avance_Proyecto. A013CODIGO%TYPE,
        p_A013FECHREPRT            IN GPYT_T013_Avance_Proyecto.A013FECHREPRT%TYPE,
        p_A013CAMBSIGNFCTV         IN GPYT_T013_Avance_Proyecto.A013CAMBSIGNFCTV%TYPE,
        p_A013COSTTONLD            IN GPYT_T013_Avance_Proyecto.A013COSTTONLD%TYPE,
        p_A013FINANCCN             IN GPYT_T013_Avance_Proyecto.A013FINANCCN%TYPE,
        p_A013FECHAVNCPROYCT       IN GPYT_T013_Avance_Proyecto.A013FECHAVNCPROYCT%TYPE,
        p_A013OPTAPAGORESULTADOS   IN GPYT_T013_Avance_Proyecto.A013OPTAPAGORESULTADOS%TYPE,
        p_A013IDPROYECTO           IN GPYT_T013_Avance_Proyecto.A013IDPROYECTO%TYPE,
        p_A013EMISREDCXVERIFICAR   IN GPYT_T013_Avance_Proyecto.A013EMISREDCXVERIFICAR%TYPE,
        p_A013EMISREDCVERIFICADAS  IN GPYT_T013_Avance_Proyecto.A013EMISREDCVERIFICADAS%TYPE,
        p_A013EMISREDCDISPNTRANSAR IN GPYT_T013_Avance_Proyecto.A013EMISREDCDISPNTRANSAR%TYPE,
        p_A013EMISREDCTRANSADAS    IN GPYT_T013_Avance_Proyecto.A013EMISREDCTRANSADAS%TYPE,
        p_A013IDARCHV              IN GPYT_T013_Avance_Proyecto.A013IDARCHV%TYPE,
        p_A013NROCPAS              IN GPYT_T013_Avance_Proyecto.A013NROCPAS%TYPE,
        p_A013HAYNUEVOCPA          IN GPYT_T013_Avance_Proyecto.A013HAYNUEVOCPA%TYPE,
        p_idUsuario                IN NUMBER,
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
  END PK_T013_AVANCE_PROYECTO;
  /************************************************************************
  FIN creación del HEADER del package PK_T013_AVANCE_PROYECTO
  ************************************************************************/