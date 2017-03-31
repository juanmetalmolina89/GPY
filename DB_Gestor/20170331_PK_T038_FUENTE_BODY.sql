create or replace PACKAGE BODY          "PK_T038_FUENTE" 
IS
  PROCEDURE Pr_Insertar(
      p_A038NOMBRFUNT      IN GPYT_T038_FUENTE.A038NOMBRFUNT%TYPE,
      p_A038IDPROYECTO     IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
      p_A038IDDESGRCATIPCC IN GPYT_T038_FUENTE.A038IDDESGRCATIPCC%TYPE,
      p_A038FACTOREMISION  IN GPYT_T038_FUENTE.A038FACTOREMISION%TYPE,
      p_A038IDUNIDAD       IN GPYT_T038_FUENTE.A038IDUNIDAD%TYPE, 
      p_idUsuario          IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A038CODIGO         NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A038NOMBRFUNT);
    -- Validamos obligatoriedad de datos
    IF p_A038NOMBRFUNT IS NULL OR p_A038IDPROYECTO IS NULL OR p_A038IDDESGRCATIPCC IS NULL OR p_A038FACTOREMISION IS NULL THEN
      p_codError       := 4;
      p_msjError       := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- obtenemos el siguiente id
    p_A038CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T038_FUENTE_SEQ');
    --
    INSERT
    INTO GPYT_T038_FUENTE
      (
        A038CODIGO,
        A038NOMBRFUNT,
        A038IDPROYECTO,
        A038IDDESGRCATIPCC,
        A038FACTOREMISION,
        A038IDUNIDAD, 
        A038ESTADOREGISTRO,
        A038FECHACREACION,
        A038FECHAMODIFICACION,
        A038USUARIOCREACION,
        A038USUARIOMODIFICACION
      )
      VALUES
      (
        p_A038CODIGO,
        p_A038NOMBRFUNT,
        p_A038IDPROYECTO,
        p_A038IDDESGRCATIPCC,
        p_A038FACTOREMISION,
        p_A038IDUNIDAD,
        PK_UTL_CONSTANTE.COD_ACTIVO,
        sysdate,
        sysdate,
        p_idUsuario,
        ''
      );
    ---
    OPEN p_resultado FOR SELECT p_A038CODIGO A038CODIGO FROM dual;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A038NOMBRFUNT);
  END Pr_Insertar;
----****
  PROCEDURE Pr_Actualizar
    (
      p_A038CODIGO         IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
      p_A038NOMBRFUNT      IN GPYT_T038_FUENTE.A038NOMBRFUNT%TYPE,
      p_A038IDPROYECTO     IN GPYT_T038_FUENTE.A038IDPROYECTO%TYPE,
      p_A038IDDESGRCATIPCC IN GPYT_T038_FUENTE.A038IDDESGRCATIPCC%TYPE,
      p_A038FACTOREMISION  IN GPYT_T038_FUENTE.A038FACTOREMISION%TYPE,
      p_A038IDUNIDAD       IN GPYT_T038_FUENTE.A038IDUNIDAD%TYPE, 
      p_idUsuario          IN NUMBER,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A038NOMBRFUNT);
    --
    IF p_A038CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T038_FUENTE
    WHERE A038CODIGO       = p_A038CODIGO
    AND A038ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T038_FUENTE
      SET A038NOMBRFUNT         =NVL(p_A038NOMBRFUNT, A038NOMBRFUNT),
        A038IDPROYECTO          =NVL(p_A038IDPROYECTO, A038IDPROYECTO),
        A038IDDESGRCATIPCC      =NVL(p_A038IDDESGRCATIPCC,A038IDDESGRCATIPCC),
        A038FACTOREMISION       =NVL(p_A038FACTOREMISION,A038FACTOREMISION),
        A038IDUNIDAD            =NVL(p_A038IDUNIDAD,A038IDUNIDAD),
        A038FECHAMODIFICACION   =sysdate,
        A038USUARIOMODIFICACION = p_idUsuario
      WHERE A038CODIGO          = p_A038CODIGO
      AND A038ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_ACTIVO;
      --
      OPEN p_resultado FOR SELECT p_A038CODIGO A038CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Actualizar ' || p_A038NOMBRFUNT);
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
    --
  BEGIN
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
    IF p_Filtro                                                                   IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T038_FUENTE WHERE A038ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                  := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                  := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T038_FUENTE WHERE ' || p_Filtro || ' AND A038ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
-----******
  PROCEDURE Pr_Eliminar(
      p_A038CODIGO IN GPYT_T038_FUENTE.A038CODIGO%TYPE,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A038CODIGO);
    ----
    IF p_A038CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    ----
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T038_FUENTE
    WHERE A038CODIGO       = p_A038CODIGO
    AND A038ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T038_FUENTE
      SET A038ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A038FECHAMODIFICACION   = sysdate,
        A038USUARIOMODIFICACION = p_idUsuario
      WHERE A038CODIGO          = p_A038CODIGO;
      ---
      OPEN p_resultado FOR SELECT p_A038CODIGO A038CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    ---
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A038CODIGO);
  END Pr_Eliminar;
END PK_T038_FUENTE;
/************************************************************************
FIN creación del BODY del package PK_T038_FUENTE
************************************************************************/