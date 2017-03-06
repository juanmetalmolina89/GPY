create or replace PACKAGE body PK_T009_INSTRMNT_FINNCCN
IS
  PROCEDURE Pr_Insertar(
      p_A009IDTIPINSTRMNTF  IN GPYT_T009_Instrmnt_Finnccn.A009IDTIPINSTRMNTF%TYPE,
      p_A009IDPROYECTO      IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
      p_A009PORFINNCCNESTMD IN GPYT_T009_Instrmnt_Finnccn.A009PORFINNCCNESTMD%TYPE,
      p_idUsuario           IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A009CODIGO         NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A009IDPROYECTO);
    -- Validamos obligatoriedad de datos
    IF p_A009IDTIPINSTRMNTF IS NULL OR p_A009IDPROYECTO IS NULL OR p_A009PORFINNCCNESTMD IS NULL THEN
      p_codError            := 4;
      p_msjError            := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- obtenemos el siguiente id
    p_A009CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T009_Instrmnt_Finnccn_SEQ');
    INSERT
    INTO GPYT_T009_INSTRMNT_FINNCCN
      (
        A009CODIGO,
        A009IDTIPINSTRMNTF,
        A009IDPROYECTO,
        A009PORFINNCCNESTMD,
        A009ESTADOREGISTRO,
        A009FECHACREACION,
        A009FECHAMODIFICACION,
        A009USUARIOCREACION,
        A009USUARIOMODIFICACION
      )
      VALUES
      (
        p_A009CODIGO,
        p_A009IDTIPINSTRMNTF,
        p_A009IDPROYECTO,
        p_A009PORFINNCCNESTMD,
        PK_UTL_CONSTANTE.COD_ACTIVO,
        sysdate,
        sysdate,
        p_idUsuario,
        ''
      );
    ---
    OPEN p_resultado FOR SELECT p_A009CODIGO A009CODIGO FROM dual;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A009IDTIPINSTRMNTF);
  END Pr_Insertar;
--***
  PROCEDURE Pr_Actualizar
    (
      p_A009CODIGO          IN GPYT_T009_Instrmnt_Finnccn.A009CODIGO%TYPE,
      p_A009IDTIPINSTRMNTF  IN GPYT_T009_Instrmnt_Finnccn.A009IDTIPINSTRMNTF%TYPE,
      p_A009IDPROYECTO      IN GPYT_T009_Instrmnt_Finnccn.A009IDPROYECTO%TYPE,
      p_A009PORFINNCCNESTMD IN GPYT_T009_Instrmnt_Finnccn.A009PORFINNCCNESTMD%TYPE,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A009CODIGO);
    IF p_A009CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T009_INSTRMNT_FINNCCN
    WHERE A009CODIGO       = p_A009CODIGO
    AND A009ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T009_INSTRMNT_FINNCCN
      SET A009IDTIPINSTRMNTF  =NVL(p_A009IDTIPINSTRMNTF, A009IDTIPINSTRMNTF),
        A009IDPROYECTO        =NVL(p_A009IDPROYECTO,A009IDPROYECTO),
        A009PORFINNCCNESTMD   =NVL(p_A009PORFINNCCNESTMD,A009PORFINNCCNESTMD),
        A009FECHAMODIFICACION =sysdate,  
        A009USUARIOMODIFICACION =p_idUsuario
      WHERE A009CODIGO          = p_A009CODIGO;
      --
      OPEN p_resultado FOR SELECT p_A009CODIGO A009CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Actualizar ' || p_A009CODIGO);
  END Pr_Actualizar;
---***
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
    IF p_Filtro                                                                             IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T009_Instrmnt_Finnccn WHERE A009ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                            := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                            := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T009_Instrmnt_Finnccn WHERE ' || p_Filtro || ' AND A009ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
---***
  PROCEDURE Pr_Eliminar(
      p_A009CODIGO IN GPYT_T009_Instrmnt_Finnccn.A009CODIGO%TYPE,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A009CODIGO);
    --
    IF p_A009CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T009_INSTRMNT_FINNCCN
    WHERE A009CODIGO       = p_A009CODIGO
    AND A009ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      --
      UPDATE GPYT_T009_INSTRMNT_FINNCCN
      SET A009ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A009FECHAMODIFICACION   = sysdate,
        A009USUARIOMODIFICACION = p_idUsuario
      WHERE A009CODIGO          = p_A009CODIGO;
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
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A009CODIGO);
  END Pr_Eliminar;
END PK_T009_INSTRMNT_FINNCCN;
/************************************************************************
FIN creación del BODY del package PK_T009_Instrmnt_Finnccn
************************************************************************/