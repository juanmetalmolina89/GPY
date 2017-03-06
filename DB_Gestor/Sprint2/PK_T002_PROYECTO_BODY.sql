  PROCEDURE Pr_ActualizarCostos(
      p_A002CODIGO            IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
      p_A002COSTSESTMDTOTL    IN GPYT_T002_PROYECTO.A002COSTSESTMDTOTL%TYPE,
      p_A002COSTSESTMDFORMLCN IN GPYT_T002_PROYECTO.A002COSTSESTMDFORMLCN%TYPE,
      p_A002COSTTONLDRDCR     IN GPYT_T002_PROYECTO.A002COSTTONLDRDCR%TYPE,
      p_A002TRM               IN GPYT_T002_PROYECTO.A002TRM%TYPE,
      p_A002BUSQUDFINNCCN     IN GPYT_T002_PROYECTO.A002BUSQUDFINNCCN%TYPE,
      p_idUsuario             IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarCostos';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ActualizarCostos ' || p_A002CODIGO);
    IF p_A002CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T002_PROYECTO
    WHERE A002CODIGO       = p_A002CODIGO
    AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    IF numReg              > 0 THEN
      UPDATE GPYT_T002_PROYECTO
      SET A002COSTSESTMDTOTL    = NVL(p_A002COSTSESTMDTOTL, A002COSTSESTMDTOTL),
        A002COSTSESTMDFORMLCN   = NVL(p_A002COSTSESTMDFORMLCN, A002COSTSESTMDFORMLCN),
        A002COSTTONLDRDCR       = NVL(p_A002COSTTONLDRDCR, A002COSTTONLDRDCR),
        A002TRM                 = NVL(p_A002TRM, A002TRM),
        A002BUSQUDFINNCCN       = NVL(p_A002BUSQUDFINNCCN, A002BUSQUDFINNCCN),
        A002USUARIOMODIFICACION = p_idUsuario,
        A002FECHAMODIFICACION   = sysdate
      WHERE A002CODIGO          = p_A002CODIGO;
      OPEN p_resultado FOR SELECT p_A002CODIGO A002CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ActualizarCostos ' || p_A002CODIGO);
  END Pr_ActualizarCostos;