create or replace package body PK_T997_MENSAJE_DEBUG is

  /********************************************************************************
  DESCRIPCION    : Procedimiento basico que permite realizar la insercion del
                   registro en la tabla T997_MENSAJE_DEBUG
  PARAMETROS    :
  IN    :
          p_A997FECHAOPERACIOn
          p_A997USUARIO
          p_A997PAQUETE
          p_A997PROCEDIMIENTO
          p_A997DESCRIPCION
          p_A997NIVEL

  OUT    :
          p_A997CODIGO        Codigo generado

  REALIZADO POR     : Hugo Armando Cendales Prieto
  FECHA CREACION    : 18/02/2016

  FECHA MODIFICA    : dd/MMM/aaaa
  MODIFICADO POR    :
  CAMBIOS           :
  *******************************************************************************/
  PROCEDURE Pr_Insertar(p_A997FECHAOPERACION IN SIST_T997_MENSAJE_DEBUG.A997FECHAOPERACION%TYPE,
                        p_A997USUARIO        IN SIST_T997_MENSAJE_DEBUG.A997USUARIO%TYPE,
                        p_A997PAQUETE        IN SIST_T997_MENSAJE_DEBUG.A997PAQUETE%TYPE,
                        p_A997PROCEDIMIENTO  IN SIST_T997_MENSAJE_DEBUG.A997PROCEDIMIENTO%TYPE,
                        p_A997DESCRIPCION    IN SIST_T997_MENSAJE_DEBUG.A997DESCRIPCION%TYPE,
                        p_A997NIVEL          IN SIST_T997_MENSAJE_DEBUG.A997NIVEL%TYPE,
                        p_A997CODIGO         OUT SIST_T997_MENSAJE_DEBUG.A997CODIGO%TYPE) IS

    v_A997CODIGO SIST_T997_MENSAJE_DEBUG.A997CODIGO%TYPE;

  BEGIN

    p_A997CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T997_MENSAJE_DEBUG_SEQ');

    INSERT INTO SIST_T997_MENSAJE_DEBUG
      (A997CODIGO,
       A997FECHAOPERACION,
       A997PAQUETE,
       A997PROCEDIMIENTO,
       A997USUARIO,
       A997DESCRIPCION,
       A997NIVEL)
    VALUES
      (p_A997CODIGO,
       p_A997FECHAOPERACION,
       p_A997PAQUETE,
       p_A997PROCEDIMIENTO,
       p_A997USUARIO,
       p_A997DESCRIPCION,
       p_A997NIVEL);

  END Pr_Insertar;

end PK_T997_MENSAJE_DEBUG;