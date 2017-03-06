create or replace package body PK_T022_TIPO_ACTIVIDAD is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A022DESCRPCNACTVDD IN GPYT_T022_TIPO_ACTIVIDAD.A022DESCRPCNACTVDD%TYPE,
                         p_A022IDTIPPROYCT IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCT%TYPE,
                         p_A022IDTIPPROYCTMDL IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCTMDL%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A022CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A022CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T022_TIPO_ACTIVIDAD_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A022DESCRPCNACTVDD);
      
      INSERT INTO GPYT_T022_TIPO_ACTIVIDAD (A022CODIGO, A022DESCRPCNACTVDD, A022IDTIPPROYCT, A022IDTIPPROYCTMDL, A022ESTADOREGISTRO, A022FECHACREACION, A022USUARIOCREACION) 
      VALUES (p_A022CODIGO, p_A022DESCRPCNACTVDD, p_A022IDTIPPROYCT, p_A022IDTIPPROYCTMDL, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A022CODIGO A022CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A022DESCRPCNACTVDD);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A022CODIGO IN GPYT_T022_TIPO_ACTIVIDAD.A022CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A022CODIGO);
  
      UPDATE GPYT_T022_TIPO_ACTIVIDAD 
      SET A022ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A022FECHAMODIFICACION = sysdate,
          A022USUARIOMODIFICACION = p_idUsuario 
      WHERE A022CODIGO = p_A022CODIGO;
              
      OPEN p_resultado FOR SELECT p_A022CODIGO A022CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A022CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A022CODIGO IN GPYT_T022_TIPO_ACTIVIDAD.A022CODIGO%TYPE,
                           p_A022DESCRPCNACTVDD IN GPYT_T022_TIPO_ACTIVIDAD.A022DESCRPCNACTVDD%TYPE,
                           p_A022IDTIPPROYCT IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCT%TYPE,
                           p_A022IDTIPPROYCTMDL IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCTMDL%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A022CODIGO);
      
      IF p_A022CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T022_TIPO_ACTIVIDAD 
      WHERE A022CODIGO = p_A022CODIGO AND A022ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T022_TIPO_ACTIVIDAD 
         SET A022DESCRPCNACTVDD = NVL(p_A022DESCRPCNACTVDD, A022DESCRPCNACTVDD),
             A022IDTIPPROYCT = NVL(p_A022IDTIPPROYCT, A022IDTIPPROYCT),
             A022IDTIPPROYCTMDL = NVL(p_A022IDTIPPROYCTMDL, A022IDTIPPROYCTMDL),
             A022USUARIOMODIFICACION = p_idUsuario, A022FECHAMODIFICACION = sysdate 
         WHERE A022CODIGO = p_A022CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A022CODIGO A022CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A022CODIGO);
  
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
           SELECT * FROM GPYT_T022_TIPO_ACTIVIDAD WHERE A022ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A022ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T022_TIPO_ACTIVIDAD WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T022_TIPO_ACTIVIDAD;