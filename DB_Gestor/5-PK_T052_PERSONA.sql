create or replace package PK_T052_PERSONA is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla GPYT_T052_PERSONA
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016
  FECHA MODIFICA    : 06/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T052_PERSONA';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                         p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                         p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                         p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                         p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                         p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                         p_A052LGREXPCNDOCMNT IN GPYT_T052_PERSONA.A052LGREXPCNDOCMNT%TYPE,
                         p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                         p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                         p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                         p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                         p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                         p_A052CODGCIIU IN GPYT_T052_PERSONA.A052CODGCIIU%TYPE,
                         p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);				 

  PROCEDURE Pr_Eliminar (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                           p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                           p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                           p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                           p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                           p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                           p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                           p_A052LGREXPCNDOCMNT IN GPYT_T052_PERSONA.A052LGREXPCNDOCMNT%TYPE,
                           p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                           p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                           p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                           p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                           p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                           p_A052CODGCIIU IN GPYT_T052_PERSONA.A052CODGCIIU%TYPE,
                           p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			   p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T052_PERSONA;