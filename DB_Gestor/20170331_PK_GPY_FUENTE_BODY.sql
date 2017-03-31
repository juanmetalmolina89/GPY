create or replace PACKAGE BODY          "PK_GPY_FUENTE" 
AS
  PROCEDURE Pr_RegistrarFuente(
      p_A038NOMBRFUNT      IN GPYT_T038_FUENTE.A038NOMBRFUNT%TYPE,
      p_A038IDPROYECTO     IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
      p_A038IDDESGRCATIPCC IN GPYT_T038_FUENTE.A038IDDESGRCATIPCC%TYPE,
      p_A038FACTOREMISION  IN GPYT_T038_FUENTE.A038FACTOREMISION%TYPE,
      p_A038IDUNIDAD       IN GPYT_T038_FUENTE.A038IDUNIDAD%TYPE, 
      p_idUsuario          IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarFuente';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarFuente ');
    --
    PK_T038_FUENTE.PR_INSERTAR( P_A038NOMBRFUNT => P_A038NOMBRFUNT, P_A038IDPROYECTO => P_A038IDPROYECTO, P_A038IDDESGRCATIPCC => P_A038IDDESGRCATIPCC, P_A038FACTOREMISION => P_A038FACTOREMISION, P_A038IDUNIDAD => P_A038IDUNIDAD, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarFuente');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarFuente;
---****
  PROCEDURE Pr_EliminarFuente(
      p_A038CODIGO IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarFuente';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_EliminarFuente ');
    --
    PK_T038_FUENTE.PR_ELIMINAR( P_A038CODIGO => P_A038CODIGO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_EliminarFuente');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_EliminarFuente;
----****
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
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarFuente';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ActualizarFuente ');
    --
    PK_T038_FUENTE.PR_ACTUALIZAR( P_A038CODIGO => P_A038CODIGO, P_A038NOMBRFUNT => P_A038NOMBRFUNT, P_A038IDPROYECTO => P_A038IDPROYECTO, P_A038IDDESGRCATIPCC => P_A038IDDESGRCATIPCC, P_A038FACTOREMISION => P_A038FACTOREMISION, P_A038IDUNIDAD => P_A038IDUNIDAD, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ActualizarFuente ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ActualizarFuente;
----***
  PROCEDURE Pr_ConsultarFtesId(
      p_A038CODIGO IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarFtesId';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ConsultarFtesId ');
    --
    IF p_A038CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_008_FUENTE FUE WHERE FUE.A038CODIGO = p_A038CODIGO AND FUE.A038ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                                  := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                                  := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarFtesId');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ConsultarFtesId;
----****
  PROCEDURE Pr_ListarFuentesProyecto(
      p_A038IDPROYECTO IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
      p_IdUsuario      IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarFuentesProyecto';
    codExcepcion         NUMBER;
    numReg               NUMBER;
  BEGIN
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarFuentesProyecto ');
    -- TAREA: Se necesita implantación para PROCEDURE PK_PARTICIPANTE.Pr_ListarParticipantesProyecto
    IF p_A038IDPROYECTO IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_008_FUENTE FUE WHERE FUE.A038IDPROYECTO = p_A038IDPROYECTO AND FUE.A038ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                                      := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                                      := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarFuentesProyecto');
    --
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarFuentesProyecto;
  ----****
  PROCEDURE Pr_RegistrarEscenarioBase(
        p_A010REPRTANFUNT IN GPYT_T010_Reporte_Anio_Fuente.A010REPRTANFUNT%TYPE,
        p_A010VALREMSN    IN GPYT_T010_Reporte_Anio_Fuente.A010VALREMSN%TYPE,
        p_A010IDFUENTE    IN GPYT_T010_Reporte_Anio_Fuente.A010IDFUENTE%TYPE,
        p_idUsuario       IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarEscenarioBase';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarEscenarioBase');
    --
    PK_T010_REPORTE_ANIO_FUENTE.PR_INSERTAR(
    P_A010REPRTANFUNT => P_A010REPRTANFUNT,
    P_A010VALREMSN => P_A010VALREMSN,
    P_A010IDFUENTE => P_A010IDFUENTE,
    P_IDUSUARIO => P_IDUSUARIO,
    P_RESULTADO => P_RESULTADO,
    P_CODERROR => P_CODERROR,
    P_MSJERROR => P_MSJERROR
  );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarEscenarioBase');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarEscenarioBase;
---****
   PROCEDURE Pr_EliminarEscenarioBase(
        p_A010CODIGO IN GPYT_T010_Reporte_Anio_Fuente.A010CODIGO%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarEscenarioBase';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_EliminarEscenarioBase');
    --
    PK_T010_REPORTE_ANIO_FUENTE.PR_ELIMINAR(
    P_A010CODIGO => P_A010CODIGO,
    P_IDUSUARIO => P_IDUSUARIO,
    P_RESULTADO => P_RESULTADO,
    P_CODERROR => P_CODERROR,
    P_MSJERROR => P_MSJERROR
  );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_EliminarEscenarioBase');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_EliminarEscenarioBase;
---****
  PROCEDURE Pr_ListarEscenarioBase(
        p_A010IDFUENTE  IN GPYT_T010_Reporte_Anio_Fuente.A010IDFUENTE%TYPE,
        p_idUsuario  IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarEscenarioBase';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarEscenarioBase');
    --
	 IF p_A010IDFUENTE IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_012_ESCENARIOBASEFNTS ESC WHERE ESC.A010IDFUENTE = p_A010IDFUENTE AND ESC.A010ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                                      := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                                      := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarEscenarioBase');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarEscenarioBase;
---****
END PK_GPY_FUENTE;