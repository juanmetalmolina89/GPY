--------------------------------------------------------
-- Archivo creado  - jueves-febrero-02-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_GPY_FINANCIACION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "GESTOR"."PK_GPY_FINANCIACION" 
AS
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
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarCostosProyecto';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarCostosProyecto ');
    --
    PK_T002_PROYECTO.PR_ACTUALIZARCOSTOS( P_A002CODIGO => P_A002CODIGO, P_A002COSTSESTMDTOTL => P_A002COSTSESTMDTOTL, P_A002COSTSESTMDFORMLCN => P_A002COSTSESTMDFORMLCN, P_A002COSTTONLDRDCR => P_A002COSTTONLDRDCR, P_A002TRM => P_A002TRM, P_A002BUSQUDFINNCCN => P_A002BUSQUDFINNCCN, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarCostosProyecto');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarCostosProyecto;
---***
  PROCEDURE Pr_RegistrarFuenteFinaciacion(
      P_A004IDPROYECTO    IN GPYT_T004_PROY_FTE_FINANC.A004IDPROYECTO%TYPE,
      P_A004IDFUNTFINNCCN IN GPYT_T004_PROY_FTE_FINANC.A004IDFUNTFINNCCN%TYPE,
      p_idUsuario         IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarFuenteFinaciacion';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarFuenteFinaciacion ');
    --
    PK_T004_PROY_FTE_FINANC.PR_INSERTAR( P_A004IDPROYECTO => P_A004IDPROYECTO, P_A004IDFUNTFINNCCN => P_A004IDFUNTFINNCCN, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarFuenteFinaciacion');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarFuenteFinaciacion;
---***
  PROCEDURE Pr_EliminarFuenteFinaciacion(
      P_A004IDPROYECTO    IN GPYT_T004_PROY_FTE_FINANC.A004IDPROYECTO%TYPE,
      P_A004IDFUNTFINNCCN IN GPYT_T004_PROY_FTE_FINANC.A004IDFUNTFINNCCN%TYPE,
      p_idUsuario         IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarFuenteFinaciacion';
    codExcepcion         NUMBER;
    P_A004CODIGO         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_EliminarFuenteFinaciacion ');
    --
    IF P_A004IDPROYECTO IS NULL OR P_A004IDFUNTFINNCCN IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError) || 's , necesarios para eliminar costos financiacion.';
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT POL.A004CODIGO
    INTO P_A004CODIGO
    FROM GPYT_T004_Proy_Fte_Financ POL
    WHERE A004IDPROYECTO       = P_A004IDPROYECTO
    AND A004IDFUNTFINNCCN      = P_A004IDFUNTFINNCCN
    AND POL.A004ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    PK_T004_PROY_FTE_FINANC.PR_ELIMINAR( P_A004CODIGO => P_A004CODIGO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_EliminarFuenteFinaciacion');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_EliminarFuenteFinaciacion;
---***
  PROCEDURE Pr_ListarCostosProyecto(
      p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarCostosProyecto';
    codExcepcion         NUMBER;
    P_A004CODIGO         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarCostosProyecto ');
    --
    OPEN p_resultado FOR SELECT A002CODIGO,
    A002COSTSESTMDTOTL,
    A002COSTSESTMDFORMLCN,
    A002COSTTONLDRDCR,
    A002TRM,
    A002BUSQUDFINNCCN FROM GPYT_T002_PROYECTO WHERE A002CODIGO = p_A002CODIGO AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarCostosProyecto');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarCostosProyecto;
---***
  PROCEDURE Pr_ListarFuenteFinaciacion(
      P_A004IDPROYECTO IN GPYT_T004_PROY_FTE_FINANC.A004IDPROYECTO%TYPE,
      p_idUsuario      IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarFuenteFinaciacion';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarCostosProyecto ');
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_010_FUENTESFINACPROYECTO WHERE A002CODIGO = P_A004IDPROYECTO AND A004ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                                       := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                                       := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarCostosProyecto');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarFuenteFinaciacion;
---
  PROCEDURE Pr_RegistrarInstrmnt_FinnccnP(
      p_A009IDTIPINSTRMNTF  IN GPYT_T009_Instrmnt_Finnccn.A009IDTIPINSTRMNTF%TYPE,
      p_A009IDPROYECTO      IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
      p_A009PORFINNCCNESTMD IN GPYT_T009_Instrmnt_Finnccn.A009PORFINNCCNESTMD%TYPE,
      p_idUsuario           IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarInstrmnt_FinnccnP';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarInstrmnt_FinnccnP ');
    --
    PK_T009_INSTRMNT_FINNCCN.PR_INSERTAR( P_A009IDTIPINSTRMNTF => P_A009IDTIPINSTRMNTF, P_A009IDPROYECTO => P_A009IDPROYECTO, P_A009PORFINNCCNESTMD => P_A009PORFINNCCNESTMD, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarInstrmnt_FinnccnP');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarInstrmnt_FinnccnP;
-----*******
  PROCEDURE Pr_EliminarInstrmnt_FinnccnP(
      p_A009CODIGO IN GPYT_T009_Instrmnt_Finnccn.A009CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarInstrmnt_FinnccnP';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_EliminarInstrmnt_FinnccnP ');
    --
    PK_T009_INSTRMNT_FINNCCN.PR_ELIMINAR( P_A009CODIGO => P_A009CODIGO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_EliminarInstrmnt_FinnccnP');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_EliminarInstrmnt_FinnccnP;
--*****
  PROCEDURE Pr_ListarInstrmnt_FinnccnP(
      p_A009IDPROYECTO IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarInstrmnt_FinnccnP';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarInstrmnt_FinnccnP ');
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_011_INSTRFINACPROYECTO IFP WHERE IFP.A009IDPROYECTO = p_A009IDPROYECTO AND IFP.A009ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                                                 := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                                                 := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarInstrmnt_FinnccnP');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarInstrmnt_FinnccnP;
END PK_GPY_FINANCIACION;
