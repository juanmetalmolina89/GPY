create or replace package body PK_T052_PERSONA is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                         p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                         p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                         p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                         p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                         p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                         p_A052LGREXPCNDOCMNT IN GPYT_T052_PERSONA.A052LGREXPCNDOCMNT%TYPE,
                         p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                         p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                         p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                         p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                         p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                         p_A052CODGCIIU IN GPYT_T052_PERSONA.A052CODGCIIU%TYPE,
                         p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A052CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A052CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T051_PARTICIPANTE_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A052APELLIDO);
      
      INSERT INTO GPYT_T052_PERSONA (A052CODIGO, A052TIPDOCMNT, A052NUMRDOCMNT, A052DIGTCHQU, A052IDTIPPERSN, A052NOMBRE, A052APELLIDO, A052LGREXPCNDOCMNT, A052DIRCCNCORRSPNDNC, 
	    A052LOCLZCN, A052TELEFONO, A052CELULAR, A052CORRELCTRNC, A052CODGCIIU, A052IDENTIDAD, A052ESTADOREGISTRO, A052FECHACREACION, A052USUARIOCREACION) 
      VALUES (p_A052CODIGO, p_A052TIPDOCMNT, p_A052NUMRDOCMNT, p_A052DIGTCHQU, p_A052IDTIPPERSN, p_A052NOMBRE, p_A052APELLIDO, p_A052LGREXPCNDOCMNT, p_A052DIRCCNCORRSPNDNC, 
	    p_A052LOCLZCN, p_A052TELEFONO, p_A052CELULAR, p_A052CORRELCTRNC, p_A052CODGCIIU, p_A052IDENTIDAD, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A052CODIGO A052CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A052APELLIDO);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A052CODIGO);
  
      UPDATE GPYT_T052_PERSONA 
      SET A052ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A052FECHAMODIFICACION = sysdate,
          A052USUARIOMODIFICACION = p_idUsuario 
      WHERE A052CODIGO = p_A052CODIGO;
              
      OPEN p_resultado FOR SELECT p_A052CODIGO A052CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A052CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A052CODIGO IN GPYT_T052_PERSONA.A052CODIGO%TYPE,
                           p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                           p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                           p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                           p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                           p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                           p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE,
                           p_A052LGREXPCNDOCMNT IN GPYT_T052_PERSONA.A052LGREXPCNDOCMNT%TYPE,
                           p_A052DIRCCNCORRSPNDNC IN GPYT_T052_PERSONA.A052DIRCCNCORRSPNDNC%TYPE,
                           p_A052LOCLZCN IN GPYT_T052_PERSONA.A052LOCLZCN%TYPE,
                           p_A052TELEFONO IN GPYT_T052_PERSONA.A052TELEFONO%TYPE,
                           p_A052CELULAR IN GPYT_T052_PERSONA.A052CELULAR%TYPE,
                           p_A052CORRELCTRNC IN GPYT_T052_PERSONA.A052CORRELCTRNC%TYPE,
                           p_A052CODGCIIU IN GPYT_T052_PERSONA.A052CODGCIIU%TYPE,
                           p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A052CODIGO);
      
      IF p_A052CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T052_PERSONA 
      WHERE A052CODIGO = p_A052CODIGO AND A052ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T052_PERSONA 
         SET A052TIPDOCMNT = NVL(p_A052TIPDOCMNT, A052TIPDOCMNT), 
             A052NUMRDOCMNT = NVL(p_A052NUMRDOCMNT, A052NUMRDOCMNT),
             A052DIGTCHQU = NVL(p_A052DIGTCHQU, A052DIGTCHQU),
             A052IDTIPPERSN = NVL(p_A052IDTIPPERSN, A052IDTIPPERSN),
             A052NOMBRE = NVL(p_A052NOMBRE, A052NOMBRE),
             A052APELLIDO = NVL(p_A052APELLIDO, A052APELLIDO),
             A052LGREXPCNDOCMNT = NVL(p_A052LGREXPCNDOCMNT, A052LGREXPCNDOCMNT),
             A052DIRCCNCORRSPNDNC = NVL(p_A052DIRCCNCORRSPNDNC, A052DIRCCNCORRSPNDNC),
             A052LOCLZCN = NVL(p_A052LOCLZCN, A052LOCLZCN),
             A052TELEFONO = NVL(p_A052TELEFONO, A052TELEFONO),
             A052CELULAR = NVL(p_A052CELULAR, A052CELULAR),
             A052CORRELCTRNC = NVL(p_A052CORRELCTRNC, A052CORRELCTRNC),
             A052CODGCIIU = NVL(p_A052CODGCIIU, A052CODGCIIU),
             A052IDENTIDAD = NVL(p_A052IDENTIDAD, A052IDENTIDAD),
             A052USUARIOMODIFICACION = p_idUsuario, A052FECHAMODIFICACION = sysdate 
         WHERE A052CODIGO = p_A052CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A052CODIGO A052CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A052CODIGO);
  
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
           SELECT * FROM GPYT_T052_PERSONA WHERE A052ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A052ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T052_PERSONA WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T052_PERSONA;