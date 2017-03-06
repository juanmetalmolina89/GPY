--------------------------------------------------------
-- Archivo creado  - jueves-enero-05-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_T004_PROY_FTE_FINANC
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "PK_T004_PROY_FTE_FINANC" 
IS
  PROCEDURE Pr_Insertar(
      p_A004IDPROYECTO    IN GPYT_T004_Proy_Fte_Financ.A004IDPROYECTO%TYPE,
      p_A004IDFUNTFINNCCN IN GPYT_T004_Proy_Fte_Financ.A004IDFUNTFINNCCN%TYPE,
      p_idUsuario         IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A004CODIGO         NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A004CODIGO);
    -- Validamos obligatoriedad de datos
    IF p_A004IDPROYECTO IS NULL OR p_A004IDFUNTFINNCCN IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- obtenemos el siguiente id
    p_A004CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T004_Proy_Fte_Financ_SEQ');
    INSERT
    INTO GPYT_T004_Proy_Fte_Financ
      (
        A004CODIGO,
        A004IDPROYECTO,
        A004IDFUNTFINNCCN,
        A004ESTADOREGISTRO,
        A004FECHACREACION,
        A004FECHAMODIFICACION,
        A004USUARIOCREACION,
        A004USUARIOMODIFICACION
      )
      VALUES
      (
        p_A004CODIGO,
        p_A004IDPROYECTO,
        p_A004IDFUNTFINNCCN,
        PK_UTL_CONSTANTE.COD_ACTIVO,
        SYSDATE,
        SYSDATE,
        p_idUsuario,
        ''
      );
    ---
    OPEN p_resultado FOR SELECT p_A004CODIGO A004CODIGO FROM dual;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    --
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A004CODIGO);
  END Pr_Insertar;
---****
  PROCEDURE Pr_Actualizar
    (
      p_A004CODIGO        IN GPYT_T004_Proy_Fte_Financ.A004CODIGO%TYPE,
      p_A004IDPROYECTO    IN GPYT_T004_Proy_Fte_Financ.A004IDPROYECTO%TYPE,
      p_A004IDFUNTFINNCCN IN GPYT_T004_Proy_Fte_Financ.A004IDFUNTFINNCCN%TYPE,
      p_idUsuario         IN NUMBER,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A004CODIGO);
    --
    IF p_A004CODIGO IS NULL OR p_A004IDPROYECTO IS NULL OR p_A004IDFUNTFINNCCN IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T004_Proy_Fte_Financ
    WHERE A004CODIGO       = p_A004CODIGO
    AND A004ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T004_Proy_Fte_Financ
      SET A004IDPROYECTO        =NVL(p_A004IDPROYECTO, A004IDPROYECTO),
        A004IDFUNTFINNCCN       =NVL(p_A004IDFUNTFINNCCN,A004IDFUNTFINNCCN),
        A004FECHAMODIFICACION   =sysdate,
        A004USUARIOMODIFICACION =p_idUsuario
      WHERE A004CODIGO          = p_A004CODIGO;
      --
      OPEN p_resultado FOR SELECT p_A004CODIGO A004CODIGO FROM dual;
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
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Actualizar ' || p_A004CODIGO);
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
    IF p_Filtro                                                                            IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T004_Proy_Fte_Financ WHERE A004ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                           := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                           := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T004_Proy_Fte_Financ WHERE ' || p_Filtro || ' AND A004ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
-----****
  PROCEDURE Pr_Eliminar(
      p_A004CODIGO IN GPYT_T004_Proy_Fte_Financ.A004CODIGO%TYPE,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A004CODIGO);
    --
    IF p_A004CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T004_Proy_Fte_Financ
    WHERE A004CODIGO       = p_A004CODIGO
    AND A004ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T004_Proy_Fte_Financ
      SET A004ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A004FECHAMODIFICACION   = sysdate,
        A004USUARIOMODIFICACION = p_idUsuario
      WHERE A004CODIGO          = p_A004CODIGO;
      OPEN p_resultado FOR SELECT '' FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A004CODIGO);
  END Pr_Eliminar;
END PK_T004_Proy_Fte_Financ;
/************************************************************************
FIN creaci\F3n del BODY del package PK_T004_Proy_Fte_Financ
************************************************************************/

/
