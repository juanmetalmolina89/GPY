create or replace package PK_GPY_PUBLICADOR is
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
                      para la administración de usuarios publicadores.
                      (Son registrados por una persona juridica)
  
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 15/11/2016
  
  FECHA MODIFICA    : 10/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Manejo de excepciones, se adicionan los procedimientos
                      Pr_ConsultarPublicadorPorId y Pr_ActualizarPublicador
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_PUBLICADOR';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_RegistrarPublicador (p_IdPersona IN NUMBER, -- Identificador del usuario al que se le asigna el contacto
                                    p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                                    p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                                    p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                                    p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                                    p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                                    p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                                    p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                                    p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                                    p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                                    p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE,
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);                                    

  procedure Pr_ConsultarPublicadorPorId (p_A055IDPERSONA IN GPYT_T055_PUBLICADOR.A055IDPERSONA%TYPE,
                                         p_A055CODIGO IN GPYT_T055_PUBLICADOR.A055CODIGO%TYPE,
                                         p_idUsuario IN NUMBER,
                                         p_Respuesta OUT CURSOR_SALIDA,
                                         p_codError OUT NUMBER,
                                         p_msjError OUT VARCHAR2); 

-- p_IdPersona IN NUMBER, -- Identificador del usuario al que se le asigna el contacto
  procedure Pr_ActualizarPublicador (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                                     p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                                     p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                                     p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                                     p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                                     p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                                     p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                                     p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                                     p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                                     p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                                     p_idUsuario IN NUMBER,
                                     p_Respuesta OUT CURSOR_SALIDA,
                                     p_codError OUT NUMBER,
                                     p_msjError OUT VARCHAR2);   

  end PK_GPY_PUBLICADOR;