create or replace package body PK_T041_USUARIO is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                         p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                         p_A041PRIMRINGRS IN GPYT_T041_USUARIO.A041PRIMRINGRS%TYPE,
                         p_A041IDPERSONA IN GPYT_T041_USUARIO.A041IDPERSONA%TYPE,
                         p_A041IDCLASUSR IN GPYT_T041_USUARIO.A041IDCLASUSR%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A041CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A041CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T041_USUARIO_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A041USERNAME);
      
      INSERT INTO GPYT_T041_USUARIO (A041CODIGO, A041USERNAME, A041CLAVE, A041PRIMRINGRS, A041IDPERSONA, A041IDCLASUSR, A041ESTADOREGISTRO, A041FECHACREACION, A041USUARIOCREACION) 
      VALUES (p_A041CODIGO, p_A041USERNAME, p_A041CLAVE, p_A041PRIMRINGRS, p_A041IDPERSONA, p_A041IDCLASUSR, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A041CODIGO A041CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A041USERNAME);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A041CODIGO);
  
      UPDATE GPYT_T041_USUARIO 
      SET A041ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A041FECHAMODIFICACION = sysdate,
          A041USUARIOMODIFICACION = p_idUsuario 
      WHERE A041CODIGO = p_A041CODIGO;
              
      OPEN p_resultado FOR SELECT p_A041CODIGO A041CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A041CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                           p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                           p_A041PRIMRINGRS IN GPYT_T041_USUARIO.A041PRIMRINGRS%TYPE,
                           p_A041IDPERSONA IN GPYT_T041_USUARIO.A041IDPERSONA%TYPE,
                           p_A041IDCLASUSR IN GPYT_T041_USUARIO.A041IDCLASUSR%TYPE,
                           p_idUsuario IN NUMBER,                           
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2) IS
     
      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Actualizar';
      estadoReg            VARCHAR2(1); 
      numReg               NUMBER;

   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A041CODIGO);
      
      IF p_A041CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T041_USUARIO 
      WHERE A041CODIGO = p_A041CODIGO AND A041ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T041_USUARIO 
         SET A041CLAVE = NVL(p_A041CLAVE, A041CLAVE), 
             A041PRIMRINGRS = NVL(p_A041PRIMRINGRS, A041PRIMRINGRS), 
             A041IDPERSONA = NVL(p_A041IDPERSONA, A041IDPERSONA),
			 A041IDCLASUSR = NVL(p_A041IDCLASUSR, A041IDCLASUSR),
             A041USUARIOMODIFICACION = p_idUsuario, A041FECHAMODIFICACION = sysdate 
         WHERE A041CODIGO = p_A041CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A041CODIGO A041CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A041CODIGO);
  
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
           SELECT * FROM GPYT_T041_USUARIO WHERE A041ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A041ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T041_USUARIO WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T041_USUARIO;