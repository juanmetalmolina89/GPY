create or replace package body PK_GPY_AVANCE is

  PROCEDURE Pr_RegistrarAvance (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                                p_idUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2) IS
                                   
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarAvance';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarAvance');

      PK_T057_AVANCE_PANTALLA.Pr_Insertar (p_A057IDPROYECTO => p_A002CODIGO,
                                           p_A057IDPANTALLA => p_A057IDPANTALLA, 
                                           p_idUsuario => p_IdUsuario,                         
                                           p_resultado => p_Respuesta,
                                           p_codError => p_codError,
                                           p_msjError => p_msjError);                                        

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarAvance');      

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  END Pr_RegistrarAvance;

  PROCEDURE Pr_ConsultarAvance (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,  
                                p_idUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarAvance';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarAvance');                                 
                                 
      PK_T057_AVANCE_PANTALLA.Pr_ConsultarPorFiltro (p_Filtro => 'A057IDPROYECTO = ' || p_A002CODIGO,
                                                     p_idUsuario => p_idUsuario,
                                                     p_resultado => p_Respuesta,
                                                     p_codError => p_codError,
			                             p_msjError => p_msjError);			           
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarAvance');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  END Pr_ConsultarAvance;           
  
  PROCEDURE Pr_ActualizarAvance (p_A057CODIGO IN GPYT_T057_AVANCE_PANTALLA.A057CODIGO%TYPE,
                                 p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                 p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2) IS
                                   
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarAvance';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ActualizarAvance');

      PK_T057_AVANCE_PANTALLA.Pr_Actualizar (p_A057CODIGO => p_A057CODIGO,
                                             p_A057IDPROYECTO => p_A002CODIGO,
                                             p_A057IDPANTALLA => p_A057IDPANTALLA, 
                                             p_idUsuario => p_IdUsuario,                         
                                             p_resultado => p_Respuesta,
                                             p_codError => p_codError,
                                             p_msjError => p_msjError);                                        

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ActualizarAvance');      

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  END Pr_ActualizarAvance;
  
end PK_GPY_AVANCE;