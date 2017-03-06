create or replace package body PK_T057_AVANCE_PANTALLA is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A057IDPROYECTO IN GPYT_T057_AVANCE_PANTALLA.A057IDPROYECTO%TYPE,
                         p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A057CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A057CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T057_AVANCE_PANTALLA_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A057IDPANTALLA);
      
      INSERT INTO GPYT_T057_AVANCE_PANTALLA (A057CODIGO, A057IDPROYECTO, A057IDPANTALLA, A057ESTADOREGISTRO, A057FECHACREACION, A057USUARIOCREACION) 
      VALUES (p_A057CODIGO, p_A057IDPROYECTO, p_A057IDPANTALLA, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A057CODIGO A057CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A057IDPANTALLA);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A057CODIGO IN GPYT_T057_AVANCE_PANTALLA.A057CODIGO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Eliminar';
    estadoReg            VARCHAR2(1);     
    numReg               NUMBER;

   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A057CODIGO);
  
      UPDATE GPYT_T057_AVANCE_PANTALLA 
      SET A057ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A057FECHAMODIFICACION = sysdate,
          A057USUARIOMODIFICACION = p_idUsuario 
      WHERE A057CODIGO = p_A057CODIGO;
              
      OPEN p_resultado FOR SELECT p_A057CODIGO A057CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A057CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A057CODIGO IN GPYT_T057_AVANCE_PANTALLA.A057CODIGO%TYPE,
                           p_A057IDPROYECTO IN GPYT_T057_AVANCE_PANTALLA.A057IDPROYECTO%TYPE,
                           p_A057IDPANTALLA IN GPYT_T057_AVANCE_PANTALLA.A057IDPANTALLA%TYPE,
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2) IS
     
      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Actualizar';
      numReg               NUMBER;

   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A057CODIGO);
      
      IF p_A057CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T057_AVANCE_PANTALLA 
      WHERE A057CODIGO = p_A057CODIGO AND A057ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T057_AVANCE_PANTALLA 
         SET A057CODIGO = NVL(p_A057CODIGO, A057CODIGO),
             A057IDPANTALLA = NVL(p_A057IDPANTALLA, A057IDPANTALLA),
             A057USUARIOMODIFICACION = p_idUsuario, A057FECHAMODIFICACION = sysdate 
         WHERE A057CODIGO = p_A057CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A057CODIGO A057CODIGO FROM dual;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return;
      ELSE
         p_codError := 5;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);  
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;
      END IF;
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A057CODIGO);
  
  END Pr_Actualizar;	 	
					   
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorFiltro';                     
    strSQL               VARCHAR2(500);
    p_Temp               VARCHAR2(30);
    
   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
  
      IF p_Filtro IS NULL THEN
         OPEN p_resultado FOR
           SELECT * FROM GPYT_T057_AVANCE_PANTALLA WHERE A057ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A057ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T057_AVANCE_PANTALLA WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T057_AVANCE_PANTALLA;