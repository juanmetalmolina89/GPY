--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-16-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_PARTICIPANTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "GESTOR"."PK_PARTICIPANTE" 
AS
  PROCEDURE Pr_RegistrarParticipante(
      p_A05IDPROYECTO       IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
      p_A051IDPERSONA       IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
      p_A051RESPONSABILIDAD IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,
      p_idUsuario           IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarParticipante';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarParticipante ');
    --
    PK_T051_PARTICIPANTE.PR_INSERTAR( P_A05IDPROYECTO => P_A05IDPROYECTO, P_A051IDPERSONA => P_A051IDPERSONA, P_A051RESPONSABILIDAD => P_A051RESPONSABILIDAD, P_IDUSUARIO => p_idUsuario, P_RESULTADO => p_resultado, P_CODERROR => p_codError, P_MSJERROR => p_msjError );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarParticipante');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarParticipante;
----****
  PROCEDURE Pr_EliminarParticipante(
      p_A051CODIGO IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarParticipante';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_EliminarParticipante ');
    -- TAREA: Se necesita implantación para PROCEDURE PK_PARTICIPANTE.Pr_EliminarParticipante
    PK_T051_PARTICIPANTE.PR_ELIMINAR( P_A051CODIGO => P_A051CODIGO, P_IDUSUARIO => p_idUsuario, P_RESULTADO => p_resultado, P_CODERROR => p_codError, P_MSJERROR => p_msjError );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_EliminarParticipante');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_EliminarParticipante;
----****
  PROCEDURE Pr_ActualizarParticipante(
      p_A051CODIGO          IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
      p_A05IDPROYECTO       IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
      p_A051IDPERSONA       IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
      p_A051RESPONSABILIDAD IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,
      p_idUsuario           IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarParticipante';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ActualizarParticipante ');
    -- TAREA: Se necesita implantación para PROCEDURE PK_PARTICIPANTE.Pr_ActualizarParticipante
    PK_T051_PARTICIPANTE.PR_ACTUALIZAR( P_A051CODIGO => P_A051CODIGO, P_A05IDPROYECTO => P_A05IDPROYECTO, P_A051IDPERSONA => P_A051IDPERSONA, P_A051RESPONSABILIDAD => P_A051RESPONSABILIDAD, P_IDUSUARIO => p_idUsuario, P_RESULTADO => p_resultado, P_CODERROR => P_CODERROR, P_MSJERROR => p_msjError );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ActualizarParticipante ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ActualizarParticipante;
----****
  PROCEDURE Pr_ConsultarParticipante(
      p_A051CODIGO IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
      p_IdUsuario IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarParticipante';
    codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ConsultarParticipante ');
    --
    IF p_A051CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_007_PARTICIPANTE PAR WHERE PAR.A051CODIGO = p_A051CODIGO AND PAR.A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarParticipante');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ConsultarParticipante;
  -----****
  PROCEDURE Pr_ListarParticipantes(
      p_IdUsuario IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
  NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarParticipantes';
  codExcepcion         NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarParticipantes ');
    -- TAREA: Se necesita implantación para PROCEDURE PK_PARTICIPANTE.Pr_ListarParticipantes
   OPEN p_resultado FOR SELECT * FROM GPYV_007_PARTICIPANTE PAR WHERE PAR.A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarParticipantes');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarParticipantes;
  ----****
  PROCEDURE Pr_ListarParticipantesProyecto(
      p_A05IDPROYECTO IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
      p_IdUsuario IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
  NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarParticipantesProyecto';
  codExcepcion         NUMBER;
  numReg               NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarParticipantesProyecto ');
    -- TAREA: Se necesita implantación para PROCEDURE PK_PARTICIPANTE.Pr_ListarParticipantesProyecto
     IF p_A05IDPROYECTO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    OPEN p_resultado FOR SELECT * FROM GPYV_007_PARTICIPANTE PAR WHERE PAR.A05IDPROYECTO = p_A05IDPROYECTO AND PAR.A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarParticipantesProyecto');
    --
    EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarParticipantesProyecto;
END PK_PARTICIPANTE;

/
