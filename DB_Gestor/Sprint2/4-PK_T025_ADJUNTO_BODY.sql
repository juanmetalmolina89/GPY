create or replace package body PK_T025_ADJUNTO is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A025NOMBRADJNT IN GPYT_T025_ADJUNTO.A025NOMBRADJNT%TYPE,   
                         p_A025DESCRPCNADJNT IN GPYT_T025_ADJUNTO.A025DESCRPCNADJNT%TYPE,  
                         p_A025IDTIPPROYCT IN GPYT_T025_ADJUNTO.A025IDTIPPROYCT%TYPE,    
                         p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,     
                         p_A025APLICPCNADJNT IN GPYT_T025_ADJUNTO.A025APLICPCNADJNT%TYPE,  
                         p_A025NOMFORMATO IN GPYT_T025_ADJUNTO.A025NOMFORMATO%TYPE, 
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A025CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A025CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T025_ADJUNTO_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A025NOMBRADJNT);
      
      INSERT INTO GPYT_T025_ADJUNTO (A025CODIGO, A025NOMBRADJNT, A025DESCRPCNADJNT, A025IDTIPPROYCT, A025IDPANTALLA, A025APLICPCNADJNT, A025NOMFORMATO, 
      A025ESTADOREGISTRO, A025FECHACREACION, A025USUARIOCREACION) 
      VALUES (p_A025CODIGO, p_A025NOMBRADJNT, p_A025DESCRPCNADJNT, p_A025IDTIPPROYCT, p_A025IDPANTALLA, p_A025APLICPCNADJNT, p_A025NOMFORMATO, 
      PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A025CODIGO A025CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A025NOMBRADJNT);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A025CODIGO IN GPYT_T025_ADJUNTO.A025CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A025CODIGO);
  
      UPDATE GPYT_T025_ADJUNTO 
      SET A025ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A025FECHAMODIFICACION = sysdate,
          A025USUARIOMODIFICACION = p_idUsuario 
      WHERE A025CODIGO = p_A025CODIGO;
              
      OPEN p_resultado FOR SELECT p_A025CODIGO A025CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A025CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A025CODIGO IN GPYT_T025_ADJUNTO.A025CODIGO%TYPE,
                           p_A025NOMBRADJNT IN GPYT_T025_ADJUNTO.A025NOMBRADJNT%TYPE,   
			   p_A025DESCRPCNADJNT IN GPYT_T025_ADJUNTO.A025DESCRPCNADJNT%TYPE,  
			   p_A025IDTIPPROYCT IN GPYT_T025_ADJUNTO.A025IDTIPPROYCT%TYPE,    
			   p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,     
			   p_A025APLICPCNADJNT IN GPYT_T025_ADJUNTO.A025APLICPCNADJNT%TYPE,  
                           p_A025NOMFORMATO IN GPYT_T025_ADJUNTO.A025NOMFORMATO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A025CODIGO);
      
      IF p_A025CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T025_ADJUNTO 
      WHERE A025CODIGO = p_A025CODIGO AND A025ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T025_ADJUNTO 
         SET A025NOMBRADJNT = NVL(p_A025NOMBRADJNT, A025NOMBRADJNT),
             A025DESCRPCNADJNT = NVL(p_A025DESCRPCNADJNT, A025DESCRPCNADJNT),
             A025IDTIPPROYCT = NVL(p_A025IDTIPPROYCT, A025IDTIPPROYCT),
             A025IDPANTALLA = NVL(p_A025IDPANTALLA, A025IDPANTALLA),
             A025APLICPCNADJNT = NVL(p_A025APLICPCNADJNT, A025APLICPCNADJNT),
             A025NOMFORMATO = NVL(p_A025NOMFORMATO, A025NOMFORMATO),
             A025USUARIOMODIFICACION = p_idUsuario, A025FECHAMODIFICACION = sysdate 
         WHERE A025CODIGO = p_A025CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A025CODIGO A025CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A025CODIGO);
  
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
           SELECT * FROM GPYT_T025_ADJUNTO WHERE A025ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A025ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T025_ADJUNTO WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T025_ADJUNTO;