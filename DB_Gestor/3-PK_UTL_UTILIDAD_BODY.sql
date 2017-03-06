create or replace package body PK_UTL_UTILIDAD is

  /********************************************************************************
   DESCRIPCION   : Funcion para asignar los consecutivos a los identificadores
                   de llave primaria
  
   PARAMETROS    :
   IN            : p_nombreSeq    Nombre de la secuencia correspondiente de la tabla
                                   a la que se le va a generar el consecutivo
  
   OUT           : p_valor    Retorna el consecutivo respectivo de la tabla
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION   : 31/08/2016
  
  FECHA MODIFICA    : 13/11/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Se elimina el campo de filtro
  *******************************************************************************/

  FUNCTION fn_ObtenerId (p_nombreSeq IN VARCHAR2) RETURN NUMBER IS
  
    sentencia VARCHAR2(1000);
    p_valor   NUMBER;
  
  BEGIN
  
    sentencia := 'SELECT ' || p_nombreSeq || '.NEXTVAL FROM DUAL';
    EXECUTE IMMEDIATE sentencia
      INTO p_valor;
  
    RETURN p_valor;
  
  END fn_ObtenerId;

  /********************************************************************************
  DESCRIPCION    : Procedimiento para registrar los mensajes de depuracion
                   Se activan los mensajes utilizando las tablas de
                   NIVEL_DEPURACION_SISTEMA, NIVEL_DEPURACION_PROCEDIMIENTO
  
  PARAMETROS    :
  IN    :
          p_nivelDepuracion          Nivel del mensaje
          p_paquete                  Nombre del paquete
          p_procedimiento            Nombre del procedimiento
          p_usuario                  Usuario que realiza la operacion
          p_descripcion              Descripcion de la operacion realizada
  
  OUT    :
          p_codError        Codigo de error generado
          p_msjError        Mensaje del error generado
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION    : 31/AGO/2016
  
  FECHA MODIFICA    : dd/MMM/aaaa
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  
  *******************************************************************************/
  PROCEDURE pr_RegistrarDebug (p_nivelDebug    IN NUMBER,
                               p_paquete       IN VARCHAR2,
                               p_procedimiento IN VARCHAR2,
                               p_usuario       IN NUMBER,
                               p_descripcion   IN VARCHAR2) IS
  
    NOMBRE_PROCEDIMIENTO varchar2(50) := 'pr_RegistraDebug';
  
    numReg           NUMBER;
    nivelActualDebug NUMBER;
    codExcepcion     NUMBER;  
    p_A997CODIGO     NUMBER;
  
  BEGIN
  
    -- validar si el paquete y procedimiento tienen debug activo
    SELECT COUNT(*)
      INTO numReg
      FROM DEBT_T901_NIVEL_PROCEDIMIENTO
     WHERE A901PAQUETE = P_PAQUETE
       AND A901PROCEDIMIENTO = P_PROCEDIMIENTO
       AND A901ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
  
    -- Si no esta parametrizado no registra debug
    IF (numReg = 0) THEN
      return;
    END IF;
  
    -- validar nivel de log activo
  
    SELECT A900CODIGO
      INTO NIVELACTUALDEBUG
      FROM DEBT_T900_NIVEL_SISTEMA
     WHERE A900ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
  
    -- No hay ningun nivel activado
    IF (nivelActualDebug IS NULL) THEN
      return;
    END IF;
  
    -- Si el nivel actual es menor que el del mensaje no registrar
    IF (nivelActualDebug < p_nivelDebug) THEN
      return;
    END IF;
  
    PK_T997_MENSAJE_DEBUG.Pr_Insertar (SYSDATE,
                                       p_usuario,
                                       p_paquete,
                                       p_procedimiento,
                                       p_descripcion,
                                       p_nivelDebug,
                                       p_A997CODIGO);
  
  EXCEPTION
    WHEN OTHERS THEN
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
  END pr_RegistrarDebug;

  /********************************************************************************
   DESCRIPCION   : Funcion para devolver el mensaje de respuesta
  
   PARAMETROS    :
   IN            : p_codError    Codigo del error
  
   OUT           : p_msjRespuesta    Retorna el mensaje de respuesta
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION   : 31/AGO/2016
  
  FECHA MODIFICA    : dd/MMM/aaaa
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  
  *******************************************************************************/
  FUNCTION fn_ObtenerMensaje(p_codError IN VARCHAR2) RETURN VARCHAR2 IS
  
    CURSOR c_msj IS
      SELECT A999MENSAJE
        FROM SIST_T999_MENSAJE_RESPUESTA
       WHERE A999CODIGO = P_CODERROR
         AND A999ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
  
    p_msjRespuesta SIST_T999_MENSAJE_RESPUESTA.A999MENSAJE%TYPE;
  
  BEGIN
  
    OPEN c_msj;
    FETCH c_msj
      INTO p_msjRespuesta;
    CLOSE c_msj;
  
    IF p_msjRespuesta IS NULL THEN
    
      p_msjRespuesta := 'MENSAJE NO PARAMETRIZADO ' || p_codError;
    
    END IF;
  
    RETURN p_msjRespuesta;
  
  END fn_ObtenerMensaje;

  /********************************************************************************
   DESCRIPCION   : Funcion para registrar excepcion del sistema y retornar el codigo asignado
  
   PARAMETROS    :
   IN            :         p_usuario        Usuario que esta ejecutando la operacion,
                           p_paquete        Paquete donde se genero la excepcion,
                           p_procedimiento  Procedimiento que genero la excepcio,
                           p_codError       Codigo de error generado por oracle,
                           p_msjError       Descripcion de la excepcion generado por oracle
  
   OUT           : p_codigoExcepcion    Retorna el codigo de excepcion
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION   : 31/AGO/2016
  
  FECHA MODIFICA    : dd/MMM/aaaa
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  
  *******************************************************************************/
  FUNCTION fn_RegistrarExcepcion (p_usuario       IN NUMBER,
                                  p_paquete       IN VARCHAR2,
                                  p_procedimiento IN VARCHAR2,
                                  p_codError      IN NUMBER,
                                  p_msjError      IN VARCHAR2) RETURN NUMBER IS
  
    v_codigoExcepcion NUMBER;
  BEGIN
  
    -- REGISTRA EXCEPCION EN TABLA T98
  
    PK_T998_EXCEPCION.Pr_Insertar (SYSDATE,
                                   p_usuario,
                                   p_paquete,
                                   p_procedimiento,
                                   p_codError,
                                   p_msjError,
                                   v_codigoExcepcion);
  
    return v_codigoExcepcion;
  
  END fn_RegistrarExcepcion;

  /********************************************************************************
   DESCRIPCION   : Funcion para registrar la auditoria sobre los datos
  
   PARAMETROS    :
   IN    :
                        p_A996IDOBJETO      Id del objeto afectado
                        p_A996OBJETO        Nombre de la tabla afectada
                        p_A996OPERACION     Operacion realizada : ELIMINAR, INSERTAR, ACTUALIZAR
                        p_A996USUARIO       Id del usuario que realiza operacion
                        p_A996PROCEDIMIENTO Procedimiento que realizo operacion
                        p_A996PAQUETE       Paquete donde esta procedimiento
  
   OUT    :             p_A996CODIGO Id del registro creado en auditoria
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION   : 05/OCT/2016
  
  FECHA MODIFICA    : dd/MMM/aaaa
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  
  *******************************************************************************/
  FUNCTION Fn_RegistrarAuditoria (p_A996IDOBJETO      IN NUMBER,
                                  p_A996OBJETO        IN VARCHAR2,
                                  p_A996OPERACION     IN VARCHAR2,
                                  p_A996USUARIO       IN NUMBER,
                                  p_A996PROCEDIMIENTO IN VARCHAR2,
                                  p_A996PAQUETE       IN VARCHAR2) RETURN NUMBER IS
  
    p_A996CODIGO NUMBER;
  BEGIN
  
    -- REGISTRA AUDITORIA EN TABLA T996
  
    PK_T996_AUDITORIA.Pr_Insertar (p_A996IDOBJETO,
                                   p_A996OBJETO,
                                   p_A996OPERACION,
                                   p_A996USUARIO,
                                   p_A996PROCEDIMIENTO,
                                   p_A996PAQUETE,
                                   p_A996CODIGO);
  
    return p_A996CODIGO;
  
  END Fn_RegistrarAuditoria;

  /********************************************************************************
  DESCRIPCION    : Procedimiento para consultar las diferentes listas por categoria
  
  PARAMETROS    :
  IN    :
          p_categoria    Valor de la categoria a consultar
          p_filtro       Valor del filtro sobre la lista
  
  OUT    :
          p_resultado       Cursor con el resultado generado
          p_codError        Codigo de error generado
          p_msjError        Mensaje del error generado
  
  REALIZADO POR    : Hugo Cendales Prieto
  
  
  FECHA CREACION    : 05/OCT/2016
  
  FECHA MODIFICA    : dd/mmm/yyyy
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  
  *******************************************************************************/
  PROCEDURE Pr_ConsultarLista (p_Categoria IN VARCHAR2,
                               p_datRespuesta OUT CURSOR_SALIDA,
                               p_codError  OUT NUMBER,
                               p_msjError  OUT VARCHAR2) IS
  
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarLista';
    numReg               NUMBER;
    SIN_REGISTRO_ACTIVO  EXCEPTION;
  
  BEGIN
  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Entro a Pr_ConsultarLista ' || p_Categoria);
  
    -- VALIDAR QUE ESTE PRESENTE LA CATEGORIA
    IF p_Categoria IS NULL THEN    
      p_codError := 2;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
      return;    
    END IF;
  
    BEGIN
      SELECT COUNT(*) INTO numReg FROM PART_T102_LISTA, PART_T101_CATEGORIA
      WHERE A102CATEGORIA = A101CODIGO
      AND UPPER(A101NOMBRE) = UPPER(p_Categoria)
      AND A102ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
           dbms_output.put_line('****numReg:' || numReg);
      IF numReg > 0 THEN     
         OPEN p_datRespuesta FOR
         SELECT A102CODIGO, A102VALOR, A102VALORCORTO
         FROM PART_T102_LISTA, PART_T101_CATEGORIA
         WHERE A102CATEGORIA = A101CODIGO
         AND UPPER(A101NOMBRE) = UPPER(p_Categoria)
         AND A102ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    ELSE
        RAISE SIN_REGISTRO_ACTIVO;
    END IF;
    
    EXCEPTION
      WHEN SIN_REGISTRO_ACTIVO THEN
        p_codError := 3;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
        return;    
      WHEN NO_DATA_FOUND THEN
        p_codError := 3;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
        return;
    END;
  
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Salio de Pr_ConsultarLista ' || p_Categoria);
  
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
  
  EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion(PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                            NOMBRE_PAQUETE,
                                                            NOMBRE_PROCEDIMIENTO,
                                                            SQLCODE,
                                                            SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  end Pr_ConsultarLista;

end PK_UTL_UTILIDAD;