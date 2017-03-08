create or replace PACKAGE BODY          "PK_GPY_POLITICA" 
AS
  PROCEDURE Pr_RegistrarPolitica(
      p_A007IDPROYECTO IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
      p_A003NIVEL1     IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
      p_A003NOMNIVEL1  IN GPYT_T003_POLITICA.A003NOMNIVEL1%TYPE,
      p_A003NIVEL2     IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
      p_A003NOMNIVEL2  IN GPYT_T003_POLITICA.A003NOMNIVEL2%TYPE,
      p_A003NIVEL3     IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
      p_A003NOMNIVEL3  IN GPYT_T003_POLITICA.A003NOMNIVEL3%TYPE,
      p_A003NOMNIVEL4   IN GPYT_T003_POLITICA.A003NOMNIVEL4%TYPE,
      P_A026CODIGO     IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
      p_idUsuario      IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarPolitica';
    codExcepcion         NUMBER;
    P_A007IDPOLITICA     NUMBER;
    P_A003NIVEL4         NUMBER; --Codigo de politica para ser insertado
    P_A003CODIGO         NUMBER; -- Llave primaria de politica, para insercion politica proyecto
    P_A007CODIGO         NUMBER; -- llave primaria proyecto politica
    mumreg               NUMBER;
  BEGIN
    -- TAREA: Se necesita implantaciï¿½n para PROCEDURE PK_GPY_POLITICA.Pr_RegistrarPolitica
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarPolitica ');
    -- Valida datos obligatorios para insertar una nueva politica
    IF p_A007IDPROYECTO IS NULL OR p_A003NIVEL1 IS NULL OR p_A003NOMNIVEL1 IS NULL OR p_A003NIVEL2 IS NULL OR p_A003NOMNIVEL2 IS NULL OR p_A003NIVEL3 IS NULL OR p_A003NOMNIVEL3 IS NULL OR p_A003NOMNIVEL4 IS NULL OR P_A026CODIGO IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError) || 's , necesarios para ingreso politica ';
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    -- valida si el arbol de politica existe
    SELECT COUNT(DISTINCT(POL.A003CODIGO))
    INTO mumreg
    FROM GPYT_T003_POLITICA POL
    WHERE A003NIVEL1           = p_A003NIVEL1
    AND A003NIVEL2             = p_A003NIVEL2
    AND A003NIVEL3             = p_A003NIVEL3
    AND POL.A003NOMNIVEL4       = p_A003NOMNIVEL4
    AND POL.A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    ---Si politica existe
    IF mumreg > 0 THEN
      -- Traer codigo de politica
      SELECT POL.A003CODIGO
      INTO P_A007IDPOLITICA
      FROM GPYT_T003_POLITICA POL
      WHERE A003NIVEL1           = p_A003NIVEL1
      AND A003NIVEL2             = p_A003NIVEL2
      AND A003NIVEL3             = p_A003NIVEL3
      AND POL.A003NOMNIVEL4       = p_A003NOMNIVEL4
      AND POL.A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      --Validar si politica ya esta asignada al proyecto
      SELECT COUNT(DISTINCT(PP.A007CODIGO))
      INTO P_A007CODIGO
      FROM GPYT_T007_PROY_POLITICA PP
      WHERE PP.A007IDPOLITICA   = P_A007IDPOLITICA
      AND PP.A007IDPROYECTO     = P_A007IDPROYECTO
      AND PP.A007ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      --
      IF P_A007CODIGO > 0 THEN ---Valida si politica ya esta asociada al proyecto
        p_codError   := 10;
        p_msjError   := 'Politica ya asociada a proyecto';
        OPEN p_resultado FOR SELECT '' FROM dual;
      ELSE
        PK_T007_PROY_POLITICA.PR_INSERTAR( P_A007IDPROYECTO => P_A007IDPROYECTO, P_A007IDPOLITICA => P_A007IDPOLITICA, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
      END IF;
    ELSE --Si politica no existe
      SELECT MAX(GPYT_T003_POLITICA.A003NIVEL4)+1
      INTO P_A003NIVEL4
      FROM GPYT_T003_POLITICA
      WHERE A003NIVEL1       = p_A003NIVEL1
      AND A003NIVEL2         = p_A003NIVEL2
      AND A003NIVEL3         = p_A003NIVEL3
      AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      ---
      PK_T003_POLITICA.PR_INSERTAR( P_A003NIVEL1 => P_A003NIVEL1, P_A003NOMNIVEL1 => P_A003NOMNIVEL1, P_A003NIVEL2 => P_A003NIVEL2, P_A003NOMNIVEL2 => P_A003NOMNIVEL2, P_A003NIVEL3 => P_A003NIVEL3, P_A003NOMNIVEL3 => P_A003NOMNIVEL3, P_A003NIVEL4 => P_A003NIVEL4, P_A003NOMNIVEL4 => P_A003NOMNIVEL4, P_A003DESCRPCNPOLTC => P_A003NOMNIVEL4, P_A003IDARCHIV => P_A026CODIGO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
      FETCH P_RESULTADO INTO P_A003CODIGO;
      -- Asociar politica a proyecto
      PK_T007_PROY_POLITICA.PR_INSERTAR( P_A007IDPROYECTO => P_A007IDPROYECTO, P_A007IDPOLITICA => P_A003CODIGO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    END IF;
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarFuente');
    --
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarPolitica;
----****
  PROCEDURE Pr_EliminarPolitica(
      p_A007CODIGO IN GPYT_T007_Proy_Politica.A007CODIGO%TYPE,
      p_idUsuario  IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    ----*****
    -- Procedimeinto que desasigna la politca al proyecto
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarPolitica';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_EliminarPolitica ');
    --
    PK_T007_PROY_POLITICA.PR_ELIMINAR( P_A007CODIGO => P_A007CODIGO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_EliminarPolitica');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_EliminarPolitica;
---***
  PROCEDURE Pr_ListarPoliticasProyecto(
      p_A007IDPROYECTO IN GPYT_T007_Proy_Politica.A007IDPROYECTO%TYPE,
      p_IdUsuario      IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarPoliticasProyecto';
    codExcepcion         NUMBER;
    numReg               NUMBER;
  BEGIN
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ListarPoliticasProyecto ');
    -- TAREA: Se necesita implantaciï¿½n para PROCEDURE PK_PARTICIPANTE.Pr_ListarParticipantesProyecto
    IF p_A007IDPROYECTO IS NULL THEN
      p_codError        := 4;
      p_msjError        := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    --
    OPEN p_resultado FOR SELECT * FROM GPYT_T007_PROY_POLITICA FUE WHERE FUE.A007IDPROYECTO = p_A007IDPROYECTO AND FUE.A007ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    p_codError                                                                               := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                                                               := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ListarPoliticasProyecto');
    --
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarPoliticasProyecto;
---***
  PROCEDURE Pr_RegistrarArchivoPolitica(
      p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
      p_A026NOMARCHIVO     IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
      p_A026HASHARCHIVO    IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
      p_IdUsuario          IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  AS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarArchivoPolitica';
    codExcepcion         NUMBER;
    numReg               NUMBER;
  BEGIN
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_RegistrarArchivoPolitica ');
    --
    PK_T026_ARCHIVO.PR_INSERTAR( P_A026DESCRPCNARCHIV => P_A026DESCRPCNARCHIV, p_A026NOMARCHIVO => p_A026NOMARCHIVO,p_A026HASHARCHIVO => p_A026HASHARCHIVO, P_IDUSUARIO => P_IDUSUARIO, P_RESULTADO => P_RESULTADO, P_CODERROR => P_CODERROR, P_MSJERROR => P_MSJERROR );
    --
    PK_UTL_UTILIDAD.PR_REGISTRARDEBUG(p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_RegistrarArchivoPolitica');
    --
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_resultado FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_RegistrarArchivoPolitica;
END PK_GPY_POLITICA;