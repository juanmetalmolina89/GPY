create or replace PACKAGE BODY          "PK_T008_PROY_ADJUNTO" is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A008IDPROYECTO IN GPYT_T008_PROY_ADJUNTO.A008IDPROYECTO%TYPE,
                         p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                         p_A008IDARCHV IN GPYT_T008_PROY_ADJUNTO.A008IDARCHV%TYPE,
                         p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                         p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A008CODIGO         NUMBER;

    BEGIN
      -- obtenemos el siguiente id
      p_A008CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T008_PROY_ADJUNTO_SEQ');

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A008CODIGO);
    -- hacemos inactivos los otros registros
      UPDATE GPYT_T008_PROY_ADJUNTO
        SET  A008ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO
      WHERE A008IDPROYECTO=p_A008IDPROYECTO AND A008IDADJNT=p_A008IDADJNT;
      
      INSERT INTO GPYT_T008_PROY_ADJUNTO (A008CODIGO, A008IDPROYECTO, A008IDADJNT, A008IDARCHV, A008NUMRRADCD, A008FECHADJNT, A008ESTADOREGISTRO, A008FECHACREACION, A008USUARIOCREACION) 
      VALUES (p_A008CODIGO, p_A008IDPROYECTO, p_A008IDADJNT, p_A008IDARCHV, p_A008NUMRRADCD, TO_DATE(p_A008FECHADJNT,'YYYY-MM-DD'), PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);

      OPEN p_resultado FOR SELECT p_A008CODIGO A008CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A008CODIGO);

  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A008CODIGO IN GPYT_T008_PROY_ADJUNTO.A008CODIGO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Eliminar';     
    p_A026CODIGO         NUMBER;

   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A008CODIGO);

      UPDATE GPYT_T008_PROY_ADJUNTO 
      SET A008ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A008FECHAMODIFICACION = sysdate,
          A008USUARIOMODIFICACION = p_idUsuario 
      WHERE A008CODIGO = p_A008CODIGO;

      -- Obtenemos el identificador del archivo asociado
      OPEN p_resultado FOR SELECT A008IDARCHV FROM GPYT_T008_PROY_ADJUNTO WHERE A008CODIGO = p_A008CODIGO;
      FETCH p_resultado INTO p_A026CODIGO;

      -- Marcamos como eliminado el archivo asociado
      PK_T026_ARCHIVO.Pr_Eliminar (p_A026CODIGO => p_A026CODIGO,
                                   p_idUsuario => p_idUsuario,  
                                   p_resultado => p_resultado,
                                   p_codError => p_codError,
			           p_msjError => p_msjError);

      OPEN p_resultado FOR SELECT p_A008CODIGO A008CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A008CODIGO);

  END Pr_Eliminar;

  PROCEDURE Pr_Actualizar (p_A008CODIGO IN GPYT_T008_PROY_ADJUNTO.A008CODIGO%TYPE,
                           p_A008IDPROYECTO IN GPYT_T008_PROY_ADJUNTO.A008IDPROYECTO%TYPE,
			   p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
			   p_A008IDARCHV IN GPYT_T008_PROY_ADJUNTO.A008IDARCHV%TYPE,
			   p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                           p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A008CODIGO);

      IF p_A008CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;

      SELECT COUNT(*) INTO numReg FROM GPYT_T008_PROY_ADJUNTO 
      WHERE A008CODIGO = p_A008CODIGO AND A008ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 

      IF numReg > 0 THEN      
         UPDATE GPYT_T008_PROY_ADJUNTO 
         SET A008IDPROYECTO = NVL(p_A008IDPROYECTO, A008IDPROYECTO),
             A008IDADJNT = NVL(p_A008IDADJNT, A008IDADJNT),
             A008IDARCHV = NVL(p_A008IDARCHV, A008IDARCHV),
             A008FECHADJNT = NVL(TO_DATE(p_A008FECHADJNT,'YYYY-MM-DD'), A008FECHADJNT),
             A008USUARIOMODIFICACION = p_idUsuario, A008FECHAMODIFICACION = sysdate 
         WHERE A008CODIGO = p_A008CODIGO;   

         OPEN p_resultado FOR SELECT p_A008CODIGO A008CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A008CODIGO);

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
           SELECT * 
           FROM GPYT_T025_ADJUNTO AD 
              LEFT JOIN GPYT_T008_PROY_ADJUNTO  PA ON A008IDADJNT = A025CODIGO 
              LEFT JOIN GPYT_T026_ARCHIVO AR ON A008IDARCHV = A026CODIGO 
           WHERE A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;   

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;

      p_Temp := q'{ AND A008ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T025_ADJUNTO AD LEFT JOIN GPYT_T008_PROY_ADJUNTO PA ON A008IDADJNT = A025CODIGO LEFT JOIN GPYT_T026_ARCHIVO AR ON A008IDARCHV = A026CODIGO  WHERE  ' || p_Filtro  || p_Temp;    
                                   
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T008_PROY_ADJUNTO;