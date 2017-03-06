create or replace package body PK_T026_ARCHIVO is
  
  PROCEDURE Pr_Insertar (p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                         p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                         p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A026CODIGO         NUMBER;
    
    BEGIN
    -- obtenemos el siguiente id
      p_A026CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T026_ARCHIVO_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A026DESCRPCNARCHIV);
  
	    INSERT INTO GPYT_T026_ARCHIVO (A026CODIGO, A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO, A026ESTADOREGISTRO, A026FECHACREACION, A026USUARIOCREACION)
      VALUES (p_A026CODIGO, p_A026DESCRPCNARCHIV, p_A026NOMARCHIVO, p_A026HASHARCHIVO, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
	    OPEN p_resultado FOR SELECT p_A026CODIGO A026CODIGO FROM dual; 
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A026DESCRPCNARCHIV); 
						 
  END Pr_Insertar;						 

  PROCEDURE Pr_Eliminar (p_A026CODIGO  IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
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
                                        p_descripcion   => 'Entro a Pr_Eliminar ' || p_A026CODIGO);
  
      UPDATE GPYT_T026_ARCHIVO 
      SET A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, 
          A026FECHAMODIFICACION = sysdate, 
          A026USUARIOMODIFICACION = p_idUsuario 
     WHERE A026CODIGO = p_A026CODIGO;
     
     OPEN p_resultado FOR SELECT '' FROM dual;
     p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
     p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 


     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Salio de Pr_Eliminar ' || p_A026CODIGO);                                        
  END Pr_Eliminar;	                         
  
  PROCEDURE Pr_Actualizar (p_A026CODIGO  IN GPYT_T026_ARCHIVO.A026CODIGO%TYPE,
                           p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                           p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                           p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A026CODIGO);
  
      IF p_A026CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T026_ARCHIVO WHERE A026CODIGO = p_A026CODIGO AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      IF numReg > 0 THEN
         UPDATE GPYT_T026_ARCHIVO 
         SET A026DESCRPCNARCHIV = p_A026DESCRPCNARCHIV, A026NOMARCHIVO = p_A026NOMARCHIVO, A026HASHARCHIVO = p_A026HASHARCHIVO, 
             A026FECHAMODIFICACION = sysdate, A026USUARIOMODIFICACION = p_idUsuario 
         WHERE A026CODIGO = p_A026CODIGO;    
	     
         OPEN p_resultado FOR SELECT p_A026CODIGO A026CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A026CODIGO);
      
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
         SELECT * FROM GPYT_T026_ARCHIVO WHERE A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
         return; 
      END IF;                                         
      
      p_Temp := q'{ AND A026ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T026_ARCHIVO WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);      

  END Pr_ConsultarPorFiltro;	  
  
end PK_T026_ARCHIVO;