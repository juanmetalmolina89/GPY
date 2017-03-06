--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-16-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_T051_PARTICIPANTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "GESTOR"."PK_T051_PARTICIPANTE" 
IS
  PROCEDURE Pr_Insertar(
      p_A05IDPROYECTO       IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
      p_A051IDPERSONA       IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
      p_A051RESPONSABILIDAD IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,
      p_idUsuario           IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A051CODIGO         NUMBER;
    ---
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A051IDPERSONA);
    -- Validamos obligatoriedad de datos
    IF p_A05IDPROYECTO IS NULL OR p_A051IDPERSONA IS NULL OR p_A051RESPONSABILIDAD IS NULL THEN
      p_codError       := 4;
      p_msjError       := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- obtenemos el siguiente id
    p_A051CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T051_PARTICIPANTE_SEQ');
    INSERT
    INTO GPYT_T051_PARTICIPANTE
      (
        A051CODIGO,
        A05IDPROYECTO,
        A051IDPERSONA,
        A051RESPONSABILIDAD,
        A051ESTADOREGISTRO,
        A051FECHACREACION,
        A051FECHAMODIFICACION,
        A051USUARIOCREACION,
        A051USUARIOMODIFICACION
      )
      VALUES
      (
        p_A051CODIGO,
        p_A05IDPROYECTO,
        p_A051IDPERSONA,
        p_A051RESPONSABILIDAD,
        PK_UTL_CONSTANTE.COD_ACTIVO,
        sysdate,
        sysdate,
        p_idUsuario,
        ''
      );
    ---
    OPEN p_resultado FOR SELECT p_A051CODIGO A051CODIGO FROM dual;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A05IDPROYECTO);
    --
  END Pr_Insertar;
----****
  PROCEDURE Pr_Actualizar
    (
      p_A051CODIGO          IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
      p_A05IDPROYECTO       IN GPYT_T051_PARTICIPANTE.A05IDPROYECTO%TYPE,
      p_A051IDPERSONA       IN GPYT_T051_PARTICIPANTE.A051IDPERSONA%TYPE,
      p_A051RESPONSABILIDAD IN GPYT_T051_PARTICIPANTE.A051RESPONSABILIDAD%TYPE,
      p_idUsuario           IN NUMBER,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A051CODIGO);
    --
    IF p_A05IDPROYECTO IS NULL OR p_A051IDPERSONA IS NULL OR p_A051RESPONSABILIDAD IS NULL THEN
      p_codError       := 4;
      p_msjError       := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    IF p_A051CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T051_PARTICIPANTE
    WHERE A051CODIGO       = p_A051CODIGO
    AND A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T051_PARTICIPANTE
      SET A05IDPROYECTO         =NVL(p_A05IDPROYECTO, A05IDPROYECTO),
        A051IDPERSONA           =NVL(p_A051IDPERSONA,A051IDPERSONA),
        A051RESPONSABILIDAD     =NVL(p_A051RESPONSABILIDAD,A051RESPONSABILIDAD),
        A051FECHAMODIFICACION   =sysdate,
        A051USUARIOMODIFICACION = p_idUsuario
      WHERE A051CODIGO          = p_A051CODIGO
      AND A051ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_ACTIVO;
      --
      OPEN p_resultado FOR SELECT p_A051CODIGO A051CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Actualizar ' || p_A051CODIGO);
  END Pr_Actualizar;
------****
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
    --
  BEGIN
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
    IF p_Filtro                                                                         IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T051_PARTICIPANTE WHERE A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                        := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                        := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T051_PARTICIPANTE WHERE ' || p_Filtro || ' AND A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
-----******
  PROCEDURE Pr_Eliminar(
      p_A051CODIGO IN GPYT_T051_PARTICIPANTE.A051CODIGO%TYPE,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A051CODIGO);
    ----
    IF p_A051CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T051_PARTICIPANTE
    WHERE A051CODIGO       = p_A051CODIGO
    AND A051ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T051_PARTICIPANTE
      SET A051ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A051FECHAMODIFICACION   = sysdate,
        A051USUARIOMODIFICACION = p_idUsuario
      WHERE A051CODIGO          = p_A051CODIGO;
      ---
      OPEN p_resultado FOR SELECT p_A051CODIGO A051CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A051CODIGO);
    ---
  END Pr_Eliminar;
END PK_T051_PARTICIPANTE;
/************************************************************************
FIN creación del BODY del package PK_T051_PARTICIPANTE
************************************************************************/

/
