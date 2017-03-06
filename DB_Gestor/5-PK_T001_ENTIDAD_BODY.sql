create or replace package body PK_T001_ENTIDAD is
  
  PROCEDURE Pr_Insertar (p_A001SIGLA IN GPYT_T001_ENTIDAD.A001SIGLA%TYPE,
                         p_A001NOMBRE IN GPYT_T001_ENTIDAD.A001NOMBRE%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A001CODIGO         NUMBER;
    
  BEGIN
      -- obtenemos el siguiente id
      p_A001CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T001_ENTIDAD_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A001NOMBRE);
  
      INSERT INTO GPYT_T001_ENTIDAD (A001CODIGO, A001SIGLA, A001NOMBRE, A001ESTADOREGISTRO, A001FECHACREACION, A001USUARIOCREACION)
      VALUES (p_A001CODIGO, p_A001SIGLA, p_A001NOMBRE, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
	  
      OPEN p_resultado FOR SELECT p_A001CODIGO A001CODIGO FROM dual; 
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A001NOMBRE);
						 
  END Pr_Insertar;						 

  PROCEDURE Pr_Eliminar (p_A001CODIGO IN GPYT_T001_ENTIDAD.A001CODIGO%TYPE,
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
                                        p_descripcion   => 'Entro a Pr_Eliminar ' || p_A001CODIGO);
     
     UPDATE GPYT_T001_ENTIDAD 
     SET A001ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, 
         A001FECHAMODIFICACION = sysdate, 
         A001USUARIOMODIFICACION = p_idUsuario 
     WHERE A001CODIGO = p_A001CODIGO;
     
     OPEN p_resultado FOR SELECT '' FROM dual;
     p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
     p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 


     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Salio de Pr_Eliminar ' || p_A001CODIGO);
  
  END Pr_Eliminar;	                         
  
  PROCEDURE Pr_Actualizar (p_A001CODIGO  IN GPYT_T001_ENTIDAD.A001CODIGO%TYPE,
                           p_A001SIGLA IN GPYT_T001_ENTIDAD.A001SIGLA%TYPE,
                           p_A001NOMBRE IN GPYT_T001_ENTIDAD.A001NOMBRE%TYPE,
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
                                        p_descripcion   => 'Entro a Pr_Actualizar ' || p_A001CODIGO);
  
      IF p_A001CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T001_ENTIDAD WHERE A001CODIGO = p_A001CODIGO AND A001ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      IF numReg > 0 THEN
         UPDATE GPYT_T001_ENTIDAD 
         SET A001SIGLA = p_A001SIGLA, A001NOMBRE = p_A001NOMBRE, A001FECHAMODIFICACION = sysdate,
             A001USUARIOMODIFICACION = p_idUsuario 
         WHERE A001CODIGO = p_A001CODIGO;    
	     
         OPEN p_resultado FOR SELECT p_A001CODIGO A001CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A001CODIGO);
                        
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
         SELECT * FROM GPYT_T001_ENTIDAD WHERE A001ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
         return; 
      END IF;                                         
      
      p_Temp := q'{ AND A001ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T001_ENTIDAD WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);      

  END Pr_ConsultarPorFiltro;	  
   
end PK_T001_ENTIDAD;