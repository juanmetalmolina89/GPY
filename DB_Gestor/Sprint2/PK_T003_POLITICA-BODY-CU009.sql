--------------------------------------------------------
-- Archivo creado  - viernes-diciembre-23-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_T003_POLITICA
--------------------------------------------------------

create or replace PACKAGE BODY PK_T003_POLITICA
AS
  PROCEDURE Pr_Insertar(
      p_A003NIVEL1        IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
      p_A003NOMNIVEL1     IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
      p_A003NIVEL2        IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
      p_A003NOMNIVEL2     IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
      p_A003NIVEL3        IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
      p_A003NOMNIVEL3     IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
      p_A003NIVEL4        IN GPYT_T003_POLITICA.A003NIVEL4%TYPE,
      p_A003NOMNIVEL4      IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
      p_A003DESCRPCNPOLTC IN GPYT_T003_POLITICA.A003DESCRPCNPOLTC%TYPE,
      p_A003IDARCHIV      IN GPYT_T003_POLITICA.A003IDARCHIV%TYPE,
      p_idUsuario         IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    codExcepcion         NUMBER;
    p_A003CODIGO         NUMBER;
    numreg               NUMBER;
  BEGIN
    --
    pk_utl_utilidad.pr_registrardebug ( p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Insertar ' || p_A003NOMNIVEL4);
    -- Validamos obligatoriedad de datos
    IF p_A003NIVEL1 IS NULL OR p_A003NOMNIVEL1 IS NULL OR p_A003NIVEL2 IS NULL OR p_A003NOMNIVEL2 IS NULL OR p_A003NIVEL3 IS NULL OR p_A003NOMNIVEL3 IS NULL OR p_A003NIVEL4 IS NULL OR p_A003NIVEL4 IS NULL OR p_A003IDARCHIV IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- obtenemos el siguiente id
    p_A003CODIGO := PK_UTL_UTILIDAD.Fn_Obtenerid('T003_POLITICA_SEQ');
    ---
    SELECT COUNT(A026CODIGO)
    INTO numreg
    FROM GPYT_T026_ARCHIVO
    WHERE A026CODIGO = p_A003IDARCHIV;
    IF numReg        > 0 THEN
      INSERT
      INTO GPYT_T003_POLITICA
        (
          A003CODIGO,
          A003NIVEL1,
          A003NOMNIVEL1,
          A003NIVEL2,
          A003NOMNIVEL2,
          A003NIVEL3,
          A003NOMNIVEL3,
          A003NIVEL4,
          A003NOMNIVEL4,
          A003DESCRPCNPOLTC,
          A003IDARCHIV,
          A003ESTADOREGISTRO,
          A003FECHACREACION,
          A003FECHAMODIFICACION,
          A003USUARIOCREACION,
          A003USUARIOMODIFICACION
        )
        VALUES
        (
          p_A003CODIGO,
          p_A003NIVEL1,
          p_A003NOMNIVEL1,
          p_A003NIVEL2,
          p_A003NOMNIVEL2,
          p_A003NIVEL3,
          p_A003NOMNIVEL3,
          p_A003NIVEL4,
          p_A003NOMNIVEL4,
          p_A003DESCRPCNPOLTC,
          p_A003IDARCHIV,
          PK_UTL_CONSTANTE.COD_ACTIVO,
          sysdate,
          sysdate,
          p_idUsuario,
          ''
        );
      ---
      OPEN p_resultado FOR SELECT p_A003CODIGO A003CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError) || ' de archivo de politica';
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Insertar ' || p_A003CODIGO);
  END Pr_Insertar;
---
  PROCEDURE Pr_Eliminar
    (
      p_A003CODIGO IN GPYT_T003_POLITICA.A003CODIGO%TYPE,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Eliminar ' || p_A003CODIGO);
    ----
    IF p_A003CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    ----
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T003_POLITICA
    WHERE A003CODIGO       = p_A003CODIGO
    AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T003_POLITICA
      SET A003ESTADOREGISTRO    = PK_UTL_CONSTANTE.COD_INACTIVO,
        A003FECHAMODIFICACION   = sysdate,
        A003USUARIOMODIFICACION = p_idUsuario
      WHERE A003CODIGO          = p_A003CODIGO;
      ---
      OPEN p_resultado FOR SELECT p_A003CODIGO A003CODIGO FROM dual;
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
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A003CODIGO);
  END Pr_Eliminar;
-----*****
  PROCEDURE Pr_Actualizar(
      p_A003CODIGO        IN GPYT_T003_POLITICA. A003CODIGO%TYPE,
      p_A003NIVEL1        IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
      p_A003NOMNIVEL1     IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
      p_A003NIVEL2        IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
      p_A003NOMNIVEL2     IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
      p_A003NIVEL3        IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
      p_A003NOMNIVEL3     IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
      p_A003NIVEL4        IN GPYT_T003_POLITICA.A003NIVEL4%TYPE,
      p_A003NOMNIVEL4      IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
      p_A003DESCRPCNPOLTC IN GPYT_T003_POLITICA.A003DESCRPCNPOLTC%TYPE,
      p_A003IDARCHIV      IN GPYT_T003_POLITICA.A003IDARCHIV%TYPE,
      p_idUsuario         IN NUMBER,
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
    pk_utl_utilidad.pr_registrardebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_Actualizar ' || p_A003CODIGO);
    --
    IF p_A003CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    ----
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T003_POLITICA
    WHERE A003CODIGO       = p_A003CODIGO
    AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    IF numReg > 0 THEN
      UPDATE GPYT_T003_POLITICA
      SET A003NIVEL1            =NVL(p_A003NIVEL1, A003NIVEL1),
        A003NOMNIVEL1           =NVL(p_A003NOMNIVEL1,A003NOMNIVEL1),
        A003NIVEL2              =NVL(p_A003NIVEL2,A003NIVEL2),
        A003NOMNIVEL2           =NVL(p_A003NOMNIVEL2,A003NOMNIVEL2),
        A003NIVEL3              =NVL(p_A003NIVEL3,A003NIVEL3),
        A003NOMNIVEL3           =NVL(p_A003NOMNIVEL3,A003NOMNIVEL3),
        A003NIVEL4              =NVL(p_A003NIVEL4,A003NIVEL4),
        A003NOMNIVEL4            =NVL(p_A003NOMNIVEL4,A003NOMNIVEL4),
        A003DESCRPCNPOLTC       =NVL(p_A003DESCRPCNPOLTC,A003DESCRPCNPOLTC),
        A003IDARCHIV            =NVL(p_A003IDARCHIV,A003IDARCHIV),
        A003FECHAMODIFICACION   = sysdate,
        A003USUARIOMODIFICACION = p_idUsuario
      WHERE A003CODIGO          = p_A003CODIGO;
      ---
      OPEN p_resultado FOR SELECT p_A003CODIGO A003CODIGO FROM dual;
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
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_Eliminar ' || p_A003CODIGO);
  END Pr_Actualizar;
----****
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
    IF p_Filtro                                                                     IS NULL THEN
      OPEN p_resultado FOR SELECT * FROM GPYT_T003_POLITICA WHERE A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ;
      p_codError                                                                    := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                    := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
      RETURN;
    END IF;
    strSQL2 := 'SELECT * FROM GPYT_T003_POLITICA WHERE ' || p_Filtro || ' AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO' ;
    OPEN p_resultado FOR strSQL2;
    pk_utl_utilidad.pr_registrardebug(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;
END PK_T003_POLITICA;

/
