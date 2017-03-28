create or replace PACKAGE BODY          "PK_T013_AVANCE_PROYECTO" 
AS
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
      p_msjError OUT VARCHAR2)
  AS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A013CODIGO         NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A013IDPROYECTO);
    -- Validamos obligatoriedad de datos
    IF p_A013FINANCCN IS NULL OR p_A013IDPROYECTO IS NULL OR p_A013IDARCHV IS NULL THEN
      p_codError      := 4;
      p_msjError      := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- obtenemos el siguiente id
    p_A013CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T013_AVANCE_PROYECTO_SEQ');
    --
    INSERT
    INTO GPYT_T013_AVANCE_PROYECTO
      (
        A013CODIGO,
        A013FECHREPRT,
        A013CAMBSIGNFCTV,
        A013COSTTONLD,
        A013FINANCCN,
        A013FECHAVNCPROYCT,
        A013OPTAPAGORESULTADOS, 
        A013IDPROYECTO,
        A013EMISREDCXVERIFICAR,
        A013EMISREDCVERIFICADAS,
        A013EMISREDCDISPNTRANSAR,
        A013EMISREDCTRANSADAS,
        A013IDARCHV,
        A013NROCPAS,
        A013HAYNUEVOCPA,
        A013ESTADOREGISTRO,
        A013FECHACREACION,
        A013FECHAMODIFICACION,
        A013USUARIOCREACION,
        A013USUARIOMODIFICACION
      )
      VALUES
      (
        p_A013CODIGO,
        p_A013FECHREPRT,
        p_A013CAMBSIGNFCTV,
        p_A013COSTTONLD,
        p_A013FINANCCN,
        p_A013FECHAVNCPROYCT,
        p_A013OPTAPAGORESULTADOS,
        p_A013IDPROYECTO,
        p_A013EMISREDCXVERIFICAR,
        p_A013EMISREDCVERIFICADAS,
        p_A013EMISREDCDISPNTRANSAR,
        p_A013EMISREDCTRANSADAS,
        p_A013IDARCHV,
        p_A013NROCPAS,
        p_A013HAYNUEVOCPA,
        PK_UTL_CONSTANTE.COD_ACTIVO,
        sysdate,
        sysdate,
        p_idUsuario,
        ''
      );
    ---
    OPEN p_resultado FOR SELECT p_A013CODIGO A013CODIGO FROM dual;
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A013CODIGO);
  END Pr_Insertar;
---
  PROCEDURE Pr_Eliminar
    (
      p_A013CODIGO IN GPYT_T013_Avance_Proyecto.A013CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2
    )
  AS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Eliminar';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A013CODIGO);
    ----
    IF p_A013CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T013_AVANCE_PROYECTO
    WHERE A013CODIGO       = p_A013CODIGO
    AND A013ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T013_AVANCE_PROYECTO
      SET A013ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A013FECHAMODIFICACION   = sysdate,
        A013USUARIOMODIFICACION = p_idUsuario
      WHERE A013CODIGO          = p_A013CODIGO;
      ---
      OPEN p_resultado FOR SELECT p_A013CODIGO A013CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A013CODIGO);
  END Pr_Eliminar;
---
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
      p_msjError OUT VARCHAR2)
  AS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Actualizar';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A013CODIGO);
    -- Validamos obligatoriedad de datos
    IF p_A013CODIGO IS NULL OR p_A013FINANCCN IS NULL OR p_A013IDPROYECTO IS NULL OR p_A013IDARCHV IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T013_AVANCE_PROYECTO
    WHERE A013CODIGO       = p_A013CODIGO
    AND A013ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T013_AVANCE_PROYECTO
      SET A013FECHREPRT          =NVL(p_A013FECHREPRT, A013FECHREPRT),
        A013CAMBSIGNFCTV         =NVL(p_A013CAMBSIGNFCTV,A013CAMBSIGNFCTV),
        A013COSTTONLD            =NVL(p_A013COSTTONLD,A013COSTTONLD),
        A013FINANCCN             =NVL(p_A013FINANCCN,A013FINANCCN),
        A013FECHAVNCPROYCT       =NVL(p_A013FECHAVNCPROYCT,A013FECHAVNCPROYCT),
        A013OPTAPAGORESULTADOS = NVL(p_A013OPTAPAGORESULTADOS,A013OPTAPAGORESULTADOS),
        A013IDPROYECTO           =NVL(p_A013IDPROYECTO,A013IDPROYECTO),
        A013EMISREDCXVERIFICAR   =NVL(P_A013EMISREDCXVERIFICAR,A013EMISREDCXVERIFICAR),
        A013EMISREDCVERIFICADAS  =NVL(P_A013EMISREDCVERIFICADAS,A013EMISREDCVERIFICADAS),
        A013EMISREDCDISPNTRANSAR =NVL(P_A013EMISREDCDISPNTRANSAR,A013EMISREDCDISPNTRANSAR),
        A013EMISREDCTRANSADAS    =NVL(P_A013EMISREDCTRANSADAS,A013EMISREDCTRANSADAS),
        A013IDARCHV              =NVL(P_A013IDARCHV,A013IDARCHV),
        A013NROCPAS              =NVL(P_A013NROCPAS,A013NROCPAS),
        A013HAYNUEVOCPA          =NVL(P_A013HAYNUEVOCPA,A013HAYNUEVOCPA),
        A013FECHAMODIFICACION    = sysdate,
        A013USUARIOMODIFICACION  = p_idUsuario
      WHERE A013CODIGO           = p_A013CODIGO
      AND A013ESTADOREGISTRO     = PK_UTL_CONSTANTE.COD_ACTIVO;
      --
      OPEN p_resultado FOR SELECT p_A013CODIGO A013CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Actualizar ' || p_A013CODIGO);
  END Pr_Actualizar;
---
  PROCEDURE Pr_ConsultarPorFiltro(
      p_Filtro    IN VARCHAR2,
      p_idUsuario IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorFiltro';
    estadoReg            VARCHAR2(1);
    strSQL               VARCHAR2(255);
    strSQL2              VARCHAR2(500);
  BEGIN
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
    IF p_Filtro                                                                            IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T013_AVANCE_PROYECTO WHERE A013ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                           := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                           := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T051_PARTICIPANTE WHERE ' || p_Filtro || ' AND A013ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
END PK_T013_AVANCE_PROYECTO;