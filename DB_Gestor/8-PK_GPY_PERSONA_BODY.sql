CREATE OR REPLACE package body GESTOR.PK_GPY_PERSONA is
 
-- metodos definidos
  
  PROCEDURE Pr_RegistrarPersona (p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
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
                                 p_msjError OUT VARCHAR2) IS 
                                 
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarPersona';
    codExcepcion         NUMBER;    
     
    BEGIN
      PK_T052_PERSONA.Pr_Insertar (p_A052TIPDOCMNT => p_A052TIPDOCMNT,
                                   p_A052NUMRDOCMNT => p_A052NUMRDOCMNT,
                                   p_A052DIGTCHQU => p_A052DIGTCHQU,
                                   p_A052IDTIPPERSN => p_A052IDTIPPERSN,
                                   p_A052NOMBRE => p_A052NOMBRE,
                                   p_A052APELLIDO => p_A052APELLIDO,
                                   p_A052LGREXPCNDOCMNT => p_A052LGREXPCNDOCMNT,
                                   p_A052DIRCCNCORRSPNDNC => p_A052DIRCCNCORRSPNDNC,
                                   p_A052LOCLZCN => p_A052LOCLZCN,
                                   p_A052TELEFONO => p_A052TELEFONO,
                                   p_A052CELULAR => p_A052CELULAR,
                                   p_A052CORRELCTRNC => p_A052CORRELCTRNC,
                                   p_A052CODGCIIU => p_A052CODGCIIU,
                                   p_A052IDENTIDAD => p_A052IDENTIDAD,
                                   p_idUsuario => p_IdUsuario,                         
                                   p_resultado => p_Respuesta,
                                   p_codError => p_codError,
                                   p_msjError => p_msjError); 
    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);              
     
  END Pr_RegistrarPersona;
 
  PROCEDURE Pr_ConsultarPersonaPorId (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                                      p_idUsuario IN NUMBER,
                                      p_Respuesta OUT CURSOR_SALIDA,
                                      p_codError OUT NUMBER,
                                      p_msjError OUT VARCHAR2) IS 
                                 
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPersonaPorId';
    codExcepcion         NUMBER;    
      
    BEGIN
       OPEN p_Respuesta FOR SELECT * FROM GPYV_008_PERSONAS WHERE A052CODIGO = p_A052CODIGO AND A052ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;                                      
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);       
               
    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion); 
                                                                  
  END Pr_ConsultarPersonaPorId;
  
  procedure Pr_ConsultarPersonaPorDoc (p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                                       p_idUsuario IN NUMBER,
                                       p_Respuesta OUT CURSOR_SALIDA,
                                       p_codError OUT NUMBER,
                                       p_msjError OUT VARCHAR2) IS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPersonaPorDoc';
    codExcepcion         NUMBER;    
      
    BEGIN
       OPEN p_Respuesta FOR SELECT * FROM GPYV_008_PERSONAS WHERE A052NUMRDOCMNT = p_A052NUMRDOCMNT AND A052ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;                                      
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);       
               
    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);                                        
                                       
 END Pr_ConsultarPersonaPorDoc;
     
  PROCEDURE Pr_ActualizarPersona (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
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
                                  p_msjError OUT VARCHAR2) IS
 
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarPersona';
    codExcepcion         NUMBER;    
     
    BEGIN
      PK_T052_PERSONA.Pr_Actualizar (p_A052CODIGO => p_A052CODIGO,
                                     p_A052IDTIPPERSN => p_A052IDTIPPERSN,
                                     p_A052NOMBRE => p_A052NOMBRE,
                                     p_A052APELLIDO => p_A052APELLIDO,
                                     p_A052TIPDOCMNT => p_A052TIPDOCMNT,
                                     p_A052DIGTCHQU => p_A052DIGTCHQU,
                                     p_A052NUMRDOCMNT => p_A052NUMRDOCMNT,
                                     p_A052LGREXPCNDOCMNT => p_A052LGREXPCNDOCMNT,
                                     p_A052DIRCCNCORRSPNDNC => p_A052DIRCCNCORRSPNDNC,
                                     p_A052LOCLZCN => p_A052LOCLZCN,
                                     p_A052TELEFONO => p_A052TELEFONO,
                                     p_A052CELULAR => p_A052CELULAR,
                                     p_A052CORRELCTRNC => p_A052CORRELCTRNC,
                                     p_A052CODGCIIU => p_A052CODGCIIU,
                                     p_A052IDENTIDAD => p_A052IDENTIDAD,
                                     p_idUsuario => p_IdUsuario,                         
                                     p_resultado => p_Respuesta,
                                     p_codError => p_codError,
                                     p_msjError => p_msjError);
    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion); 
                                   
  END Pr_ActualizarPersona;
                                   
END PK_GPY_PERSONA;
