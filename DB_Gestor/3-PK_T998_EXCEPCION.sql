create or replace package PK_T998_EXCEPCION is

  PROCEDURE Pr_Insertar(p_A998FECHAEXCEPCION IN SIST_T998_EXCEPCION.A998FECHAEXCEPCION%TYPE,
                        p_A998USUARIO        IN SIST_T998_EXCEPCION.A998USUARIO%TYPE,
                        p_A998PAQUETE        IN SIST_T998_EXCEPCION.A998PAQUETE%TYPE,
                        p_A998PROCEDIMIENTO  IN SIST_T998_EXCEPCION.A998PROCEDIMIENTO%TYPE,
                        p_A998CODERROR       IN SIST_T998_EXCEPCION.A998CODERROR%TYPE,
                        p_A998MSJERROR       IN SIST_T998_EXCEPCION.A998MSJERROR%TYPE,
                        p_A998CODIGO         OUT SIST_T998_EXCEPCION.A998CODIGO%TYPE);

end PK_T998_EXCEPCION;