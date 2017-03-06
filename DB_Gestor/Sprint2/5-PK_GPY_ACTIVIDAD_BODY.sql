create or replace package body PK_GPY_ACTIVIDAD is

  PROCEDURE Pr_RegistrarActividad (p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
                                   p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,                                   
                                   p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                                   p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
                                   p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                                   p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,	
                                   p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
                                   p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                                   p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS
                                   
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarActividad';
    p_A005IDSOPORTE      NUMBER;
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarActividad');

      PK_T005_ACTIVIDAD.Pr_Insertar (p_A005DESCRPCNACTVDD => p_A005DESCRPCNACTVDD,
                                     p_A005IDTIPACTVDD => p_A005IDTIPACTVDD,
                                     p_A005IDPROYECTO => p_A005IDPROYECTO,
                                     p_A005IDSECTORIPCC => p_A005IDSECTORIPCC,
                                     p_A005IDSOPORTE => NULL,
                                     p_A005FECHAINICIO => p_A005FECHAINICIO,
                                     p_A005FECHAFINAL => p_A005FECHAFINAL,
                                     p_A005COSTOTOTAL => p_A005COSTOTOTAL,
                                     p_A005CONTRBCNPROP => p_A005CONTRBCNPROP,
                                     p_A005CONTRBCNEXTRN => p_A005CONTRBCNEXTRN,
                                     p_idUsuario => p_idUsuario,
                                     p_resultado => p_Respuesta,
                                     p_codError => p_codError,
			             p_msjError => p_msjError);                                         

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarActividad');      

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
    
  END Pr_RegistrarActividad;

  PROCEDURE Pr_RegistrarSoporte (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,  
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarSoporte';
    p_A005IDSOPORTE      NUMBER;
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarSoporte');                                 
                                 
      -- Insertamos el archivo soporte
      PK_T026_ARCHIVO.Pr_Insertar (p_A026DESCRPCNARCHIV => p_A026DESCRPCNARCHIV,
                                   p_A026NOMARCHIVO => p_A026NOMARCHIVO,
                                   p_A026HASHARCHIVO => p_A026HASHARCHIVO,
                                   p_idUsuario => p_idUsuario,
                                   p_resultado => p_Respuesta,
                                   p_codError => p_codError,
			           p_msjError => p_msjError);			           
			          
      FETCH p_Respuesta INTO p_A005IDSOPORTE;    
      -- actualizamos el registro de la actividad
      UPDATE GPYT_T005_ACTIVIDAD SET A005IDSOPORTE = p_A005IDSOPORTE WHERE A005CODIGO = p_A005CODIGO;
      OPEN p_Respuesta FOR SELECT p_A005IDSOPORTE A005IDSOPORTE FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarSoporte');      
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
    
  END Pr_RegistrarSoporte;           
  
  PROCEDURE Pr_RegistrarGeografia (p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                                   p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                                   p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
                                   p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                                   p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,  
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarGeografia';
    p_A005IDSOPORTE      NUMBER;
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarGeografia');      

      PK_T042_ACTIVIDAD_GEOMETRIA.Pr_Insertar (p_A042IDPROYECTO => p_A042IDPROYECTO,
      					       p_A042IDACTVDD => p_A042IDACTVDD,
      					       p_A042NROSITIO => p_A042NROSITIO,
      					       p_A042GEOMETRIA_SITIO => p_A042GEOMETRIA_SITIO,
      					       p_A042GEOMETRIA_INTERSECC => p_A042GEOMETRIA_INTERSECC,
                                               p_idUsuario => p_idUsuario,
                                               p_resultado => p_Respuesta,
                                               p_codError => p_codError,
			                       p_msjError => p_msjError);      					       
                                 
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarGeografia');      
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
    
  END Pr_RegistrarGeografia;                                   

  PROCEDURE Pr_ActualizarActividad (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                    p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
                                    p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,
                                    p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,    
                                    p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
                                    p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                                    p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,	
                                    p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
                                    p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                                    p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                                    p_idUsuario IN NUMBER,                           
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
			            p_msjError OUT VARCHAR2) IS 
			            
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarActividad';
    p_A005IDSOPORTE      NUMBER;
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ActualizarActividad');
                                                                           
      -- actualizamos la actividad
      PK_T005_ACTIVIDAD.Pr_Actualizar (p_A005CODIGO => p_A005CODIGO,
                                       p_A005DESCRPCNACTVDD => p_A005DESCRPCNACTVDD,
                                       p_A005IDTIPACTVDD => p_A005IDTIPACTVDD,
                                       p_A005IDPROYECTO =>  p_A005IDPROYECTO,
                                       p_A005IDSECTORIPCC => p_A005IDSECTORIPCC,
                                       p_A005IDSOPORTE => NULL,
                                       p_A005FECHAINICIO => p_A005FECHAINICIO,
                                       p_A005FECHAFINAL => p_A005FECHAFINAL,                                       
                                       p_A005COSTOTOTAL => p_A005COSTOTOTAL,
                                       p_A005CONTRBCNPROP => p_A005CONTRBCNPROP,
                                       p_A005CONTRBCNEXTRN => p_A005CONTRBCNEXTRN,
                                       p_idUsuario => p_idUsuario,
                                       p_resultado => p_Respuesta,
                                       p_codError => p_codError,
			               p_msjError => p_msjError); 	
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ActualizarActividad');      
                                         
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
      
  END Pr_ActualizarActividad;      
  
  PROCEDURE Pr_ActualizarSoporte (p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                  p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                  p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                  p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2) IS
			            
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarSoporte';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ActualizarSoporte');

      -- actualizamos el archivo
      PK_T026_ARCHIVO.Pr_Actualizar (p_A026CODIGO => p_A026CODIGO,
                                     p_A026DESCRPCNARCHIV => p_A026DESCRPCNARCHIV,
                                     p_A026NOMARCHIVO => p_A026NOMARCHIVO,
                                     p_A026HASHARCHIVO => p_A026HASHARCHIVO,
                                     p_idUsuario => p_idUsuario,
                                     p_resultado => p_Respuesta,
                                     p_codError => p_codError,
                                     p_msjError => p_msjError);                                           
                                         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ActualizarSoporte');      
                                         
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
      
  END Pr_ActualizarSoporte;      
                                    
  PROCEDURE Pr_EliminarActividad (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2) IS
                                   
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarActividad';
    p_A005IDSOPORTE      NUMBER;
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_EliminarActividad');
                                         
      -- Buscamos el archivo soporte
      OPEN p_Respuesta FOR SELECT A005IDSOPORTE FROM GPYT_T005_ACTIVIDAD WHERE A005CODIGO = p_A005CODIGO;
      FETCH p_Respuesta INTO p_A005IDSOPORTE;
      
      -- Borramos el adjunto
      PK_T026_ARCHIVO.Pr_Eliminar (p_A026CODIGO => p_A005IDSOPORTE,
                                   p_idUsuario => p_idUsuario,
                                   p_resultado => p_Respuesta,
                                   p_codError => p_codError,
			           p_msjError => p_msjError);      
			           
      PK_T005_ACTIVIDAD.Pr_Eliminar (p_A005CODIGO => p_A005CODIGO,
                                     p_idUsuario => p_idUsuario,
                                     p_resultado => p_Respuesta,
                                     p_codError => p_codError,
			             p_msjError => p_msjError);   			                                               

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_EliminarActividad');      

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
    
  END Pr_EliminarActividad;
    
  PROCEDURE Pr_ConsultarActividadPorId (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                        p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                        p_idUsuario IN NUMBER,  
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
				        p_msjError OUT VARCHAR2) IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarActividadPorId';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarActividadPorId');	

      IF (p_A005CODIGO IS NULL) THEN
         OPEN p_Respuesta FOR SELECT * FROM GPYV_009_ACTIVIDADES WHERE A005IDPROYECTO = p_A002CODIGO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;
      END IF;
      IF (p_A002CODIGO IS NULL) THEN
         OPEN p_Respuesta FOR SELECT * FROM GPYV_009_ACTIVIDADES WHERE A005CODIGO = p_A005CODIGO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;
      END IF;				        
		
      IF (p_A002CODIGO IS NOT NULL AND p_A005CODIGO IS NOT NULL) THEN
         OPEN p_Respuesta FOR SELECT * FROM GPYV_009_ACTIVIDADES 
            WHERE A005CODIGO = p_A005CODIGO AND A005IDPROYECTO = p_A002CODIGO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;
      END IF;
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarActividadPorId');      

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
    
  END Pr_ConsultarActividadPorId;
    
  PROCEDURE Pr_ConsultarSoportePorId (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                                      p_A026CODIGO IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                                      p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                                      p_idUsuario IN NUMBER,  
                                      p_Respuesta OUT CURSOR_SALIDA,
                                      p_codError OUT NUMBER,
				      p_msjError OUT VARCHAR2) IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarSoportePorId';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarSoportePorId');	                                      

      IF p_A026CODIGO IS NOT NULL THEN
         OPEN p_Respuesta FOR SELECT A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO 
         FROM GPYT_T026_ARCHIVO WHERE A026CODIGO = p_A026CODIGO AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;         
      END IF;
      
      IF p_A005CODIGO IS NOT NULL THEN
         OPEN p_Respuesta FOR SELECT A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO 
         FROM GPYT_T026_ARCHIVO, GPYT_T005_ACTIVIDAD
         WHERE A026CODIGO = A005IDSOPORTE AND A005CODIGO = p_A005CODIGO 
         AND A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;          
      END IF;
      
      IF p_A005IDPROYECTO IS NOT NULL THEN
         OPEN p_Respuesta FOR SELECT A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO 
         FROM GPYT_T026_ARCHIVO, GPYT_T005_ACTIVIDAD
         WHERE A026CODIGO = A005IDSOPORTE AND A005IDPROYECTO = p_A005IDPROYECTO 
         AND A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;       
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;        
      END IF;


      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarSoportePorId');      

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
    
  END Pr_ConsultarSoportePorId;
    
  PROCEDURE Pr_ConsultarGeografiaPorId (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                                        p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                                        p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE, 
                                        p_idUsuario IN NUMBER,
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
                                        p_msjError OUT VARCHAR2) IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarSoportePorId';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarGeografiaPorId');	  
                                         
      IF p_A042CODIGO IS NOT NULL THEN
         OPEN p_Respuesta FOR SELECT A042NROSITIO, A042GEOMETRIA_SITIO, A042GEOMETRIA_INTERSECC
         FROM GPYT_T042_ACTIVIDAD_GEOMETRIA WHERE A042CODIGO = p_A042CODIGO
         AND A042ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;           
      END IF;

      IF p_A042IDPROYECTO IS NOT NULL THEN
         OPEN p_Respuesta FOR SELECT A042NROSITIO, A042GEOMETRIA_SITIO, A042GEOMETRIA_INTERSECC
         FROM GPYT_T042_ACTIVIDAD_GEOMETRIA WHERE A042IDPROYECTO = p_A042IDPROYECTO
         AND A042ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;           
      END IF;
      
      IF p_A042IDACTVDD IS NOT NULL THEN
         OPEN p_Respuesta FOR SELECT A042NROSITIO, A042GEOMETRIA_SITIO, A042GEOMETRIA_INTERSECC
         FROM GPYT_T042_ACTIVIDAD_GEOMETRIA WHERE A042IDACTVDD = p_A042IDACTVDD
         AND A042ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
	 p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
         return;           
      END IF;
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarGeografiaPorId');      

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
    
  END Pr_ConsultarGeografiaPorId;
  
  PROCEDURE Pr_ActualizarGeografia (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                                    p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                                    p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                                    p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
                                    p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                                    p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,  
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2) IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarGeografia';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ActualizarGeografia');	  
  
        PK_T042_ACTIVIDAD_GEOMETRIA.Pr_Actualizar (p_A042CODIGO => p_A042CODIGO,
                                                   p_A042IDPROYECTO => p_A042IDPROYECTO,
                                                   p_A042IDACTVDD => p_A042IDACTVDD,
      					           p_A042NROSITIO => p_A042NROSITIO,
      					           p_A042GEOMETRIA_SITIO => p_A042GEOMETRIA_SITIO,
      					           p_A042GEOMETRIA_INTERSECC => p_A042GEOMETRIA_INTERSECC,
                                                   p_idUsuario => p_idUsuario,
                                                   p_resultado => p_Respuesta,
                                                   p_codError => p_codError,
			                           p_msjError => p_msjError);  
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ActualizarGeografia');      

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
  
  END Pr_ActualizarGeografia;
  
end PK_GPY_ACTIVIDAD;