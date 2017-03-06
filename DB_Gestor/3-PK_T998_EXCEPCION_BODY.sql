create or replace package body PK_T998_EXCEPCION is

  /********************************************************************************
  DESCRIPCION    : Procedimiento basico que permite realizar la inserciOn del
                   registro en la tabla T998_EXCEPCION
  PARAMETROS    :
  IN    :
          p_A998FECHAEXCEPCION
          p_A998USUARIO
          p_A998PAQUETE
          p_A998PROCEDIMIENTO
          p_A998CODERROR
          p_A998MSGERROR

  OUT    :
          p_A998_CODIGO

  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION    : 18/AGO/2016

  FECHA MODIFICA      :  dd/MMM/aaaa
  MODIFICADO POR      :
  DESCRIPCION CAMBIOS :
  *******************************************************************************/
  PROCEDURE Pr_Insertar (p_A998FECHAEXCEPCION IN SIST_T998_EXCEPCION.A998FECHAEXCEPCION%TYPE,
                         p_A998USUARIO        IN SIST_T998_EXCEPCION.A998USUARIO%TYPE,
                         p_A998PAQUETE        IN SIST_T998_EXCEPCION.A998PAQUETE%TYPE,
                         p_A998PROCEDIMIENTO  IN SIST_T998_EXCEPCION.A998PROCEDIMIENTO%TYPE,
                         p_A998CODERROR       IN SIST_T998_EXCEPCION.A998CODERROR%TYPE,
                         p_A998MSJERROR       IN SIST_T998_EXCEPCION.A998MSJERROR%TYPE,
                         p_A998CODIGO         OUT SIST_T998_EXCEPCION.A998CODIGO%TYPE) IS

  BEGIN

    p_A998CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T998_EXCEPCION_SEQ');

    INSERT INTO SIST_T998_EXCEPCION
      (A998CODIGO,
       A998FECHAEXCEPCION,
       A998PAQUETE,
       A998PROCEDIMIENTO,
       A998USUARIO,
       A998CODERROR,
       A998MSJERROR)
    VALUES
      (p_A998CODIGO,
       p_A998FECHAEXCEPCION,
       p_A998PAQUETE,
       p_A998PROCEDIMIENTO,
       p_A998USUARIO,
       p_A998CODERROR,
       p_A998MSJERROR);

  END Pr_Insertar;

end PK_T998_EXCEPCION;