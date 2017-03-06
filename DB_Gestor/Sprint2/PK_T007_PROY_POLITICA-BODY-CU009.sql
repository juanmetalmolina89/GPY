--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-23-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_T007_PROY_POLITICA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "GESTOR"."PK_T007_PROY_POLITICA" 
IS
  PROCEDURE Pr_Insertar(
      p_A007IDPROYECTO IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
      p_A007IDPOLITICA IN GPYT_T007_Proy_Politica.A007IDPOLITICA%TYPE,
      p_idUsuario      IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A007CODIGO         NUMBER;
  BEGIN
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A007IDPOLITICA);
    --
    -- Validamos obligatoriedad de datos
    IF p_A007IDPROYECTO IS NULL OR p_A007IDPOLITICA IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    p_A007CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T007_Proy_Politica_SEQ');
    --
    INSERT INTO GPYT_T007_Proy_Politica
      (
        A007CODIGO,
        A007IDPROYECTO,
        A007IDPOLITICA,
        A007ESTADOREGISTRO,
        A007FECHACREACION,
        A007FECHAMODIFICACION,
        A007USUARIOCREACION,
        A007USUARIOMODIFICACION
      )
      VALUES
      (
        p_A007CODIGO,
        p_A007IDPROYECTO,
        p_A007IDPOLITICA,
        PK_UTL_CONSTANTE.COD_ACTIVO,
        sysdate,
        sysdate,
        p_idUsuario,
        ''
      );
    --
    OPEN p_resultado FOR SELECT p_A007CODIGO A007CODIGO FROM dual;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A007IDPROYECTO);
  END Pr_Insertar;
---***
  PROCEDURE Pr_Actualizar
    (
      p_A007CODIGO     IN GPYT_T007_Proy_Politica.A007CODIGO%TYPE,
      p_A007IDPROYECTO IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
      p_A007IDPOLITICA IN GPYT_T007_Proy_Politica.A007IDPOLITICA%TYPE,
      p_idUsuario      IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2
    )
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Actualizar';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A007CODIGO);
    --
    IF p_A007CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T007_Proy_Politica
    WHERE A007CODIGO       = p_A007CODIGO
    AND A007ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    ---***
    IF numReg > 0 THEN
      UPDATE GPYT_T007_Proy_Politica
      SET A007IDPROYECTO        =NVL(p_A007IDPROYECTO, A007IDPROYECTO),
        A007IDPOLITICA          =NVL(p_A007IDPOLITICA,A007IDPOLITICA),
        A007FECHAMODIFICACION   = sysdate,
        A007USUARIOMODIFICACION = p_idUsuario
      WHERE A007CODIGO          = p_A007CODIGO
      AND A007ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_ACTIVO;
      --
      OPEN p_resultado FOR SELECT p_A007CODIGO A007CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Actualizar ' || p_A007CODIGO);
  END Pr_Actualizar;
----****
  PROCEDURE Pr_ConsultarPorFiltro(
      p_Filtro    IN VARCHAR2,
      p_idUsuario IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorFiltro';
    estadoReg            VARCHAR2(1);
    strSQL               VARCHAR2(255);
    strSQL2              VARCHAR2(500);
  BEGIN
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
    IF p_Filtro                                                                          IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T007_Proy_Politica WHERE A007ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                         := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                         := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T007_Proy_Politica WHERE ' || p_Filtro || ' AND A007ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
----****
  PROCEDURE Pr_Eliminar(
      p_A007CODIGO IN GPYT_T007_Proy_Politica.A007CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Eliminar';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A007CODIGO);
    --
    IF p_A007CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T007_Proy_Politica
    WHERE A007CODIGO       = p_A007CODIGO
    AND A007ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    ---***
    IF numReg > 0 THEN
      UPDATE GPYT_T007_Proy_Politica
      SET A007ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A007FECHAMODIFICACION   = sysdate,
        A007USUARIOMODIFICACION = p_idUsuario
      WHERE A007CODIGO          = p_A007CODIGO;
      OPEN p_resultado FOR SELECT p_A007CODIGO A007CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A007CODIGO);
  END Pr_Eliminar;
END PK_T007_Proy_Politica;
/************************************************************************
FIN creación del BODY del package PK_T007_Proy_Politica
************************************************************************/

/
