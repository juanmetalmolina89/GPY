create or replace package body PK_T042_ACTIVIDAD_GEOMETRIA is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
                         p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
                         p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
                         p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                         p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A042CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A042CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T042_ACTIVIDAD_GEOMETRIA_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A042NROSITIO);
      
      INSERT INTO GPYT_T042_ACTIVIDAD_GEOMETRIA (A042CODIGO, A042IDPROYECTO, A042IDACTVDD, A042NROSITIO, A042GEOMETRIA_SITIO, A042GEOMETRIA_INTERSECC,  
        A042ESTADOREGISTRO, A042FECHACREACION, A042USUARIOCREACION) 
      VALUES (p_A042CODIGO, p_A042IDPROYECTO, p_A042IDACTVDD, p_A042NROSITIO, p_A042GEOMETRIA_SITIO, p_A042GEOMETRIA_INTERSECC, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A042CODIGO A042CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A042NROSITIO);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A042CODIGO);
  
      UPDATE GPYT_T042_ACTIVIDAD_GEOMETRIA 
      SET A042ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A042FECHAMODIFICACION = sysdate,
          A042USUARIOMODIFICACION = p_idUsuario 
      WHERE A042CODIGO = p_A042CODIGO;
              
      OPEN p_resultado FOR SELECT p_A042CODIGO A042CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A042CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A042CODIGO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042CODIGO%TYPE,
                           p_A042IDPROYECTO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDPROYECTO%TYPE,
			   p_A042IDACTVDD IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042IDACTVDD%TYPE,
			   p_A042NROSITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042NROSITIO%TYPE,
			   p_A042GEOMETRIA_SITIO IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_SITIO%TYPE,
                           p_A042GEOMETRIA_INTERSECC IN GPYT_T042_ACTIVIDAD_GEOMETRIA.A042GEOMETRIA_INTERSECC%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A042CODIGO);
      
      IF p_A042CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T042_ACTIVIDAD_GEOMETRIA 
      WHERE A042CODIGO = p_A042CODIGO AND A042ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T042_ACTIVIDAD_GEOMETRIA 
         SET A042IDPROYECTO = NVL(p_A042IDPROYECTO, A042IDPROYECTO),
             A042IDACTVDD = NVL(p_A042IDACTVDD, A042IDACTVDD),
             A042NROSITIO = NVL(p_A042NROSITIO, A042NROSITIO),
             A042GEOMETRIA_INTERSECC = NVL(p_A042GEOMETRIA_INTERSECC, A042GEOMETRIA_INTERSECC),
             A042USUARIOMODIFICACION = p_idUsuario, A042FECHAMODIFICACION = sysdate 
         WHERE A042CODIGO = p_A042CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A042CODIGO A042CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A042CODIGO);
  
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
           SELECT * FROM GPYT_T042_ACTIVIDAD_GEOMETRIA WHERE A042ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A042ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T042_ACTIVIDAD_GEOMETRIA WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T042_ACTIVIDAD_GEOMETRIA;