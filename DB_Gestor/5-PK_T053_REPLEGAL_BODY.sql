create or replace package body PK_T053_REPLEGAL is
  
  PROCEDURE Pr_Insertar (p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                         p_A053IDREPRESENTANTE IN GPYT_T053_REPLEGAL.A053IDREPRESENTANTE%TYPE,
                         p_A053TIPOREPRESENTANTE IN GPYT_T053_REPLEGAL.A053TIPOREPRESENTANTE%TYPE,                         
                         p_A053IDARCHIVO IN GPYT_T053_REPLEGAL.A053IDARCHIVO%TYPE, 
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A053CODIGO         NUMBER;
    
  BEGIN
      -- obtenemos el siguiente id
      p_A053CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T053_REPLEGAL_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A053IDPERSONAJURD);
  
      INSERT INTO GPYT_T053_REPLEGAL (A053CODIGO, A053IDPERSONAJURD, A053IDREPRESENTANTE, A053TIPOREPRESENTANTE, A053IDARCHIVO, A053ESTADOREGISTRO, A053FECHACREACION, A053USUARIOCREACION)
      VALUES (p_A053CODIGO, p_A053IDPERSONAJURD, p_A053IDREPRESENTANTE, p_A053TIPOREPRESENTANTE, p_A053IDARCHIVO, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
	  
      OPEN p_resultado FOR SELECT p_A053CODIGO A053CODIGO FROM dual; 
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A053IDPERSONAJURD);
						 
  END Pr_Insertar;						 

  PROCEDURE Pr_Eliminar (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			 p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Eliminar';

   BEGIN
  
     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Entro a Pr_Eliminar ' || p_A053CODIGO);
     
     UPDATE GPYT_T053_REPLEGAL 
     SET A053ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, 
         A053FECHAMODIFICACION = sysdate, 
         A053USUARIOMODIFICACION = p_idUsuario 
     WHERE A053CODIGO = p_A053CODIGO;
     
     OPEN p_resultado FOR SELECT '' FROM dual;
     p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
     p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 


     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Salio de Pr_Eliminar ' || p_A053CODIGO);  
  END Pr_Eliminar;	                         
  
  PROCEDURE Pr_Actualizar (p_A053CODIGO IN GPYT_T053_REPLEGAL.A053CODIGO%TYPE,
                           p_A053IDPERSONAJURD IN GPYT_T053_REPLEGAL.A053IDPERSONAJURD%TYPE,
                           p_A053IDREPRESENTANTE IN GPYT_T053_REPLEGAL.A053IDREPRESENTANTE%TYPE,
                           p_A053TIPOREPRESENTANTE IN GPYT_T053_REPLEGAL.A053TIPOREPRESENTANTE%TYPE,                           
                           p_A053IDARCHIVO IN GPYT_T053_REPLEGAL.A053IDARCHIVO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A053CODIGO);
  
      IF p_A053CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T053_REPLEGAL WHERE A053CODIGO = p_A053CODIGO AND A053ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      IF numReg > 0 THEN
         UPDATE GPYT_T053_REPLEGAL 
         SET A053IDPERSONAJURD = p_A053IDPERSONAJURD, A053IDREPRESENTANTE = p_A053IDREPRESENTANTE, A053TIPOREPRESENTANTE = p_A053TIPOREPRESENTANTE,
             A053IDARCHIVO = p_A053IDARCHIVO, A053FECHAMODIFICACION = sysdate, A053USUARIOMODIFICACION = p_idUsuario 
         WHERE A053CODIGO = p_A053CODIGO;    
	     
         OPEN p_resultado FOR SELECT p_A053CODIGO A053CODIGO FROM dual;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A053CODIGO);
                        
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
                                         p_descripcion   => 'Entro a Pr_ConsultarPorId ' || p_Filtro);
  
      IF p_Filtro IS NULL THEN
         OPEN p_resultado FOR
         SELECT * FROM GPYT_T053_REPLEGAL WHERE A053ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
         return; 
      END IF;                                         
      
      p_Temp := q'{ AND A053ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T053_REPLEGAL WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);      
  END Pr_ConsultarPorFiltro;	  
   
   
end PK_T053_REPLEGAL;