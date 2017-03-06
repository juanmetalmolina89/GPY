CREATE OR REPLACE PACKAGE BODY PK_GPY_APROBNACIONAL IS


PROCEDURE Pr_CambiarEstado (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                p_EstadoProyecto IN GPYT_T002_PROYECTO.A002ESTADOPROYECTO%TYPE,
                                p_IdUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_CambiarEstado';
	numReg               NUMBER;
	ESTADO_ANTERIOR		 NUMBER;

	BEGIN
		PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_CambiarEstado'); 
										 
		IF p_A002CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_Respuesta FOR SELECT '' FROM dual;
         return;      
      END IF;
	
	SELECT COUNT(*) INTO numReg FROM GPYT_T002_PROYECTO 
		WHERE A002CODIGO = p_A002CODIGO AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
	  
	SELECT A002ESTADOPROYECTO INTO ESTADO_ANTERIOR FROM GPYT_T002_PROYECTO
		WHERE A002CODIGO = p_A002CODIGO AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
	
	IF numReg > 0 THEN
		
		UPDATE GPYT_T044_CAMBIOS_ESTADO
			SET A044FECHCAMBIO        = TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'YYYY-MM-DD')
			, A044ESTADOREGISTRO      = PK_UTL_CONSTANTE.COD_INACTIVO
			, A044FECHAMODIFICACION   = TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'YYYY-MM-DD')
			, A044USUARIOMODIFICACION = p_IdUsuario
		WHERE A044IDPRYTO             = p_A002CODIGO
		AND A044ESTADOREGISTRO        = PK_UTL_CONSTANTE.COD_ACTIVO;
		
		COMMIT;
		

		INSERT INTO GPYT_T044_CAMBIOS_ESTADO ( 
                                          A044CODIGO,
                                          A044IDPRYTO,
                                          A044ESTANTES,
                                          A044ESTDESPUES,
                                          A044FECHCAMBIO,
                                          A044ESTADOREGISTRO,
                                          A044FECHACREACION,
                                          A044FECHAMODIFICACION,
                                          A044USUARIOCREACION,
                                          A044USUARIOMODIFICACION ) 
                                          VALUES ( 
                                          T044_CAMBIOS_ESTADO_SEQ.NEXTVAL,
                                          p_A002CODIGO,
                                          ESTADO_ANTERIOR,
                                          p_EstadoProyecto,
                                          TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'YYYY-MM-DD'),
                                          PK_UTL_CONSTANTE.COD_ACTIVO,
                                          TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'YYYY-MM-DD'),
                                          NULL,
                                          21,
                                          NULL
                                          );
		

		UPDATE GPYT_T002_PROYECTO
		SET GPYT_T002_PROYECTO.A002ESTADOPROYECTO = p_EstadoProyecto
		WHERE A002CODIGO = p_A002CODIGO;
		
		COMMIT;
		
		OPEN p_Respuesta FOR SELECT p_A002CODIGO A002CODIGO FROM dual;
        p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
        return;
    ELSE
        p_codError := 5;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);  
        OPEN p_Respuesta FOR SELECT '' FROM dual;
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

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

  END Pr_CambiarEstado;
  
  
  
PROCEDURE Pr_AdjuntarArchivo (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                 p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                                 p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
								 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
								 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                                 p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_AdjuntarArchivo';
    p_A008IDARCHV        NUMBER;
	numReg               NUMBER;

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_AdjuntarArchivo'); 

      -- Insertar en la tabla GPYT_T026_ARCHIVO
      PK_T026_ARCHIVO.Pr_Insertar (p_A026DESCRPCNARCHIV => p_A026DESCRPCNARCHIV,
                                   p_A026NOMARCHIVO => p_A026NOMARCHIVO,
                                   p_A026HASHARCHIVO =>p_A026HASHARCHIVO,
                                   p_idUsuario => p_idUsuario,                         
                                   p_resultado => p_Respuesta,
                                   p_codError => p_codError,
                                   p_msjError => p_msjError);

      FETCH p_Respuesta INTO p_A008IDARCHV;

      -- Insertar en la tabla GPYT_T008_PROY_ADJUNTO
      PK_T008_PROY_ADJUNTO.Pr_Insertar (p_A008IDPROYECTO => p_A002CODIGO,
                                        p_A008IDADJNT => p_A008IDADJNT,
                                        p_A008IDARCHV => p_A008IDARCHV,
                                        p_A008NUMRRADCD => p_A008NUMRRADCD,
                                        p_A008FECHADJNT => TO_CHAR(p_A008FECHADJNT,'YYYY-MM-DD'),
                                        p_idUsuario => p_idUsuario,                         
                                        p_resultado => p_Respuesta,
                                        p_codError => p_codError,
                                        p_msjError => p_msjError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_AdjuntarArchivo');      
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

  END Pr_AdjuntarArchivo;
  
END PK_GPY_APROBNACIONAL;