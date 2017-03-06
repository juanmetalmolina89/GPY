create or replace package body PK_GPY_CONTACTO is

  PROCEDURE Pr_RegistrarContacto (p_IdPersona IN NUMBER, -- Identificador del usuario al que se le asigna el contacto
                                  p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
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
                                  p_msjError OUT VARCHAR2) IS  
                                
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarContacto';
    codExcepcion         NUMBER;    
    p_A052IDTIPPERSN     NUMBER;
    p_A052CODIGO2         NUMBER;
    
    BEGIN
	   IF p_A052CODIGO IS NOT NULL THEN
          PK_T054_CONTACTO.Pr_Insertar (p_A054IDPERSONA => p_IdPersona,
                                        p_A054IDCONTACTO => p_A052CODIGO,
                                        p_idUsuario => p_IdUsuario,                         
                                        p_resultado => p_Respuesta,
                                        p_codError => p_codError,
                                        p_msjError => p_msjError);	      
	   ELSE
          p_A052IDTIPPERSN := PK_UTL_LISTADOS.Fn_TraerCodigo('Persona Natural');
          PK_T052_PERSONA.Pr_Insertar (p_A052TIPDOCMNT => p_A052TIPDOCMNT,
                                       p_A052NUMRDOCMNT => p_A052NUMRDOCMNT,
                                       p_A052DIGTCHQU => NULL,
                                       p_A052IDTIPPERSN => p_A052IDTIPPERSN,
                                       p_A052NOMBRE => p_A052NOMBRE,
                                       p_A052APELLIDO => p_A052APELLIDO,
                                       p_A052LGREXPCNDOCMNT => NULL,
                                       p_A052DIRCCNCORRSPNDNC => p_A052DIRCCNCORRSPNDNC,
                                       p_A052LOCLZCN => p_A052LOCLZCN,
                                       p_A052TELEFONO => p_A052TELEFONO,
                                       p_A052CELULAR => p_A052CELULAR,
                                       p_A052CORRELCTRNC => p_A052CORRELCTRNC,
                                       p_A052CODGCIIU => NULL,
                                       p_A052IDENTIDAD => p_A052IDENTIDAD,
                                       p_idUsuario => p_idUsuario,                         
                                       p_resultado => p_Respuesta,
                                       p_codError => p_codError,
                                       p_msjError => p_msjError);

          FETCH p_Respuesta INTO p_A052CODIGO2;         
          PK_T054_CONTACTO.Pr_Insertar (p_A054IDPERSONA => p_IdPersona,
                                        p_A054IDCONTACTO => p_A052CODIGO2,
                                        p_idUsuario => p_IdUsuario,                         
                                        p_resultado => p_Respuesta,
                                        p_codError => p_codError,
                                        p_msjError => p_msjError);	   
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
    
  END Pr_RegistrarContacto;

  PROCEDURE Pr_ActualizarContacto (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
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
                                   p_msjError OUT VARCHAR2) IS
                                   
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarContacto';
    codExcepcion         NUMBER;    
    
    BEGIN
       PK_T052_PERSONA.Pr_Actualizar (p_A052CODIGO => p_A052CODIGO,
                                      p_A052TIPDOCMNT => p_A052TIPDOCMNT,
                                      p_A052NUMRDOCMNT => p_A052NUMRDOCMNT,
                                      p_A052DIGTCHQU => NULL,
                                      p_A052IDTIPPERSN => NULL,
                                      p_A052NOMBRE => p_A052NOMBRE,
                                      p_A052APELLIDO => p_A052APELLIDO,
                                      p_A052LGREXPCNDOCMNT => NULL,
                                      p_A052DIRCCNCORRSPNDNC => p_A052DIRCCNCORRSPNDNC,
                                      p_A052LOCLZCN => p_A052LOCLZCN,
                                      p_A052TELEFONO => p_A052TELEFONO,
                                      p_A052CELULAR => p_A052CELULAR,
                                      p_A052CORRELCTRNC => p_A052CORRELCTRNC,
                                      p_A052CODGCIIU => NULL,
                                      p_A052IDENTIDAD => NULL,
                                      p_idUsuario => p_idUsuario,                         
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
  
  END Pr_ActualizarContacto;

  PROCEDURE Pr_ConsultarContactoPorId (p_A054IDPERSONA IN GPYT_T054_CONTACTO.A054IDPERSONA%TYPE,
                                       p_A054CODIGO IN GPYT_T054_CONTACTO.A054CODIGO%TYPE,
                                       p_idUsuario IN NUMBER,
                                       p_Respuesta OUT CURSOR_SALIDA,
                                       p_codError OUT NUMBER,
                                       p_msjError OUT VARCHAR2) IS
                                       
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarContactoPorId';
    codExcepcion         NUMBER;    
    
    BEGIN
      IF p_A054IDPERSONA IS NOT NULL AND p_A054CODIGO IS NOT NULL THEN   
         OPEN p_Respuesta FOR 
           SELECT * FROM GPYV_004_CONTACTOS WHERE A054CODIGO = p_A054CODIGO AND A054IDPERSONA = p_A054IDPERSONA;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;
      END IF;      
      IF p_A054IDPERSONA IS NULL THEN
         OPEN p_Respuesta FOR SELECT * FROM GPYV_004_CONTACTOS WHERE A054CODIGO = p_A054CODIGO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;
      END IF;
      IF p_A054CODIGO IS NULL THEN
         OPEN p_Respuesta FOR SELECT * FROM GPYV_004_CONTACTOS WHERE A054IDPERSONA = p_A054IDPERSONA;
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
                                       
  END Pr_ConsultarContactoPorId;
   
  
END PK_GPY_CONTACTO;