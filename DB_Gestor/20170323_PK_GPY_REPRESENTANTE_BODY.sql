create or replace PACKAGE          "PK_GPY_REPRESENTANTE" is
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
                      para la administración de representante legal

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 16/11/2016

  FECHA MODIFICA    : 23/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Manejo de excepciones, se adicionan los procedimientos
                      Pr_RegistrarAdjunto, Pr_ConsultarAdjuntoPorId y Pr_ActualizarAdjunto
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_REPRESENTANTE';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_RegistrarRepresentante (p_IdPersonaJuridica IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                                       p_A053TIPOREPRESENTANTE IN GPYT_T053_REPLEGAL.A053TIPOREPRESENTANTE%TYPE,
                                       p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                                       p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                                       p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                                       p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                                       p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,  
                                       p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                                       p_A052LGREXPCNDOCMNT IN GPYT_T052_PERSONA.A052LGREXPCNDOCMNT%TYPE,
                                       p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                                       p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                                       p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                                       p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                                       p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                                       p_A052CODGCIIU IN GPYT_T052_PERSONA.A052CODGCIIU%TYPE,
                                       p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE, 
                                       p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                                       p_idUsuario IN NUMBER,
                                       p_Respuesta OUT CURSOR_SALIDA,
                                       p_codError OUT NUMBER,
                                       p_msjError OUT VARCHAR2);                 

  procedure Pr_RegistrarAdjunto (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2);

  procedure Pr_ConsultarRepresentantePorId (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                            p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                                            p_idUsuario IN NUMBER,
                                            p_Respuesta OUT CURSOR_SALIDA,
                                            p_codError OUT NUMBER,
                                            p_msjError OUT VARCHAR2); 

  procedure Pr_ActualizarRepresentante (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                        p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                                        p_A053TIPOREPRESENTANTE IN GPYT_T053_REPLEGAL.A053TIPOREPRESENTANTE%TYPE,
                                        p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                                        p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                                        p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                                        p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                                        p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,  
                                        p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                                        p_A052LGREXPCNDOCMNT IN GPYT_T052_PERSONA.A052LGREXPCNDOCMNT%TYPE,
                                        p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                                        p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                                        p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                                        p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                                        p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                                        p_A052CODGCIIU IN GPYT_T052_PERSONA.A052CODGCIIU%TYPE,
                                        p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE, 
                                        p_idUsuario IN NUMBER,
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
                                        p_msjError OUT VARCHAR2);              

  procedure Pr_ActualizarAdjunto (p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                  p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                  p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                  p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2);     

  procedure Pr_ConsultarAdjuntoPorId (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                      p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                      p_idUsuario IN NUMBER,
                                      p_Respuesta OUT CURSOR_SALIDA,
                                      p_codError OUT NUMBER,
                                      p_msjError OUT VARCHAR2);     

end PK_GPY_REPRESENTANTE;