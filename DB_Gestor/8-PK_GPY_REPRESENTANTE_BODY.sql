create or replace package body PK_GPY_REPRESENTANTE is
  
  PROCEDURE Pr_RegistrarRepresentante (p_IdPersonaJuridica IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
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
                                       p_msjError OUT VARCHAR2) IS 
                                 
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarRepresentante';
    codExcepcion         NUMBER;    
    p_A052CODIGO         NUMBER;
     
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
                                    
      FETCH p_Respuesta INTO p_A052CODIGO;               
       
      PK_T053_REPLEGAL.Pr_Insertar (p_A053IDPERSONAJURD => p_IdPersonaJuridica,
                                    p_A053IDREPRESENTANTE => p_A052CODIGO,
                                    p_A053TIPOREPRESENTANTE => p_A053TIPOREPRESENTANTE,
                                    p_A053IDARCHIVO => NULL,
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
--dbms_output.put_line("SQLCODE: " || SQLCODE);                                                            
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);              
     
  END Pr_RegistrarRepresentante;
 
  -- Se puede consultar por el id del Representante o por el Id de la Persona
  PROCEDURE Pr_ConsultarRepresentantePorId (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                            p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                                            p_idUsuario IN NUMBER,
                                            p_Respuesta OUT CURSOR_SALIDA,
                                            p_codError OUT NUMBER,
                                            p_msjError OUT VARCHAR2) IS
                                 
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarRepresentantePorId';
    codExcepcion         NUMBER;    
     
    BEGIN
      IF (p_A053CODIGO IS NOT NULL AND p_A053IDPERSONAJURD IS NOT NULL) THEN                               
          OPEN p_Respuesta FOR SELECT * FROM GPYV_002_REPLEGAL 
          WHERE A053IDPERSONAJURD = p_A053IDPERSONAJURD AND A053CODIGO = p_A053CODIGO;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          return;
      END IF;      
      IF (p_A053CODIGO IS NULL AND p_A053IDPERSONAJURD IS NOT NULL) THEN                               
          OPEN p_Respuesta FOR SELECT * FROM GPYV_002_REPLEGAL WHERE A053IDPERSONAJURD = p_A053IDPERSONAJURD;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          return;
      END IF;
      IF (p_A053IDPERSONAJURD IS NULL AND p_A053CODIGO IS NULL) THEN                               
          OPEN p_Respuesta FOR SELECT * FROM GPYV_002_REPLEGAL WHERE A053CODIGO = p_A053CODIGO;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          return;
      END IF;
     
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
           
  END Pr_ConsultarRepresentantePorId;                                             
   
  PROCEDURE Pr_ActualizarRepresentante (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
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
                                        p_msjError OUT VARCHAR2) IS
 
    NOMBRE_PROCEDIMIENTO  VARCHAR2(50) := 'Pr_ActualizarRepresentante';
    codExcepcion          NUMBER;    
    p_A053IDREPRESENTANTE NUMBER;
 
    BEGIN
      OPEN p_Respuesta FOR
      SELECT A053IDREPRESENTANTE FROM GPYT_T053_REPLEGAL 
      WHERE A053IDPERSONAJURD = p_A053IDPERSONAJURD;
      FETCH p_Respuesta INTO p_A053IDREPRESENTANTE;
       
      PK_T052_PERSONA.Pr_Actualizar (p_A052CODIGO => p_A053IDREPRESENTANTE,
                                     p_A052TIPDOCMNT => p_A052TIPDOCMNT,
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
 
 
      PK_T053_REPLEGAL.Pr_Actualizar (p_A053CODIGO => p_A053CODIGO,
                                      p_A053IDPERSONAJURD => p_A053IDPERSONAJURD,
                                      p_A053IDREPRESENTANTE => p_A053IDREPRESENTANTE,
                                      p_A053TIPOREPRESENTANTE => p_A053TIPOREPRESENTANTE,
                                      p_A053IDARCHIVO => NULL,  
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
 
  END Pr_ActualizarRepresentante;                                        
  
  PROCEDURE Pr_RegistrarAdjunto (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2) IS
 
    NOMBRE_PROCEDIMIENTO    VARCHAR2(50) := 'Pr_RegistrarAdjunto';
    codExcepcion            NUMBER;    
    p_A026CODIGO            NUMBER;
    p_A053IDPERSONAJURD     NUMBER;
    p_A053IDREPRESENTANTE   NUMBER;
    p_A053TIPOREPRESENTANTE NUMBER;
     
    BEGIN                                
      PK_T026_ARCHIVO.Pr_Insertar (p_A026DESCRPCNARCHIV => p_A026DESCRPCNARCHIV,
                                   p_A026NOMARCHIVO => p_A026NOMARCHIVO,
                                   p_A026HASHARCHIVO => p_A026HASHARCHIVO, 
                                   p_idUsuario => p_IdUsuario,                         
                                   p_resultado => p_Respuesta,
                                   p_codError => p_codError,
                                   p_msjError => p_msjError);
                                    
      FETCH p_Respuesta INTO p_A026CODIGO;       
      OPEN p_Respuesta FOR SELECT A053IDPERSONAJURD, A053IDREPRESENTANTE, A053TIPOREPRESENTANTE
        FROM GPYT_T053_REPLEGAL WHERE A053CODIGO = p_A053CODIGO;
      FETCH p_Respuesta INTO p_A053IDPERSONAJURD, p_A053IDREPRESENTANTE, p_A053TIPOREPRESENTANTE;
       
      PK_T053_REPLEGAL.Pr_Actualizar (p_A053CODIGO => p_A053CODIGO,
                                      p_A053IDPERSONAJURD => p_A053IDPERSONAJURD,
                                      p_A053IDREPRESENTANTE => p_A053IDREPRESENTANTE,
                                      p_A053TIPOREPRESENTANTE => p_A053TIPOREPRESENTANTE,
                                      p_A053IDARCHIVO => p_A026CODIGO,                           
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
           
   END Pr_RegistrarAdjunto;
  
   PROCEDURE Pr_ActualizarAdjunto (p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                   p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                   p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                   p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS
  
    NOMBRE_PROCEDIMIENTO  VARCHAR2(50) := 'Pr_ActualizarAdjunto';
    codExcepcion          NUMBER;    
 
    BEGIN
      PK_T026_ARCHIVO.Pr_Actualizar (p_A026CODIGO => p_A026CODIGO,
                                     p_A026DESCRPCNARCHIV => p_A026DESCRPCNARCHIV,
                                     p_A026NOMARCHIVO => p_A026NOMARCHIVO,
                                     p_A026HASHARCHIVO => p_A026HASHARCHIVO,
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
           
   END Pr_ActualizarAdjunto;
    
   PROCEDURE Pr_ConsultarAdjuntoPorId (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                                       p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                       p_idUsuario IN NUMBER,
                                       p_Respuesta OUT CURSOR_SALIDA,
                                       p_codError OUT NUMBER,
                                       p_msjError OUT VARCHAR2) IS
  
    NOMBRE_PROCEDIMIENTO  VARCHAR2(50) := 'Pr_ConsultarAdjuntoPorId';
    codExcepcion          NUMBER;    
 
    BEGIN  
      IF p_A026CODIGO IS NULL THEN
        OPEN p_Respuesta FOR
          SELECT A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO FROM GPYT_T026_ARCHIVO
          WHERE A026CODIGO = p_A026CODIGO AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
        p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
        return;
      END IF;
      IF p_A053CODIGO IS NULL THEN
        OPEN p_Respuesta FOR
          SELECT A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO FROM GPYT_T026_ARCHIVO, GPYT_T053_REPLEGAL
          WHERE A026CODIGO = A053IDARCHIVO AND A053CODIGO = p_A053CODIGO
          AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
        p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
        return;
      END IF;                                       
      IF p_A053CODIGO IS NOT NULL AND p_A026CODIGO IS NOT NULL THEN
        OPEN p_Respuesta FOR
          SELECT A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO FROM GPYT_T026_ARCHIVO, GPYT_T053_REPLEGAL
          WHERE A026CODIGO = p_A026CODIGO AND A053CODIGO = p_A053CODIGO
          AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
        p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
        return;
      END IF; 
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
           
   END Pr_ConsultarAdjuntoPorId;
    
 END PK_GPY_REPRESENTANTE;
