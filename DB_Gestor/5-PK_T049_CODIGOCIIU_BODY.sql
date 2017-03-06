create or replace package body PK_T049_CODIGOCIIU is
  
  PROCEDURE Pr_Insertar (p_A049CODIGOCIIU IN GPYT_T049_CODIGOCIIU.A049CODIGOCIIU%TYPE,
                         p_A049DESCRIPCIONCIIU IN GPYT_T049_CODIGOCIIU.A049DESCRIPCIONCIIU%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A049CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A049CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T049_CODIGOCIIU_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A049CODIGOCIIU);
  
      dbms_output.put_line('p_A049CODIGOCIIU: '|| p_A049CODIGOCIIU );
	    INSERT INTO GPYT_T049_CODIGOCIIU (A049CODIGO, A049CODIGOCIIU, A049DESCRIPCIONCIIU, A049ESTADOREGISTRO, A049FECHACREACION, A049USUARIOCREACION)
        VALUES (p_A049CODIGO, p_A049CODIGOCIIU, p_A049DESCRIPCIONCIIU, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
      
      OPEN p_resultado FOR SELECT p_A049CODIGO A049CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A049CODIGOCIIU);
						 
  END Pr_Insertar;						 

  PROCEDURE Pr_Eliminar (p_A049CODIGO IN GPYT_T049_CODIGOCIIU.A049CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A049CODIGO);
  
      UPDATE GPYT_T049_CODIGOCIIU 
      SET A049ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A049FECHAMODIFICACION = sysdate,
          A049USUARIOMODIFICACION = p_idUsuario 
      WHERE A049CODIGO = p_A049CODIGO;
              
      OPEN p_resultado FOR SELECT p_A049CODIGO A049CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
     
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A049CODIGO);

  END Pr_Eliminar;	                         
  
  PROCEDURE Pr_Actualizar (p_A049CODIGO IN GPYT_T049_CODIGOCIIU.A049CODIGO%TYPE,
                           p_A049CODIGOCIIU IN GPYT_T049_CODIGOCIIU.A049CODIGOCIIU%TYPE,
                           p_A049DESCRIPCIONCIIU IN GPYT_T049_CODIGOCIIU.A049DESCRIPCIONCIIU%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A049CODIGO);
      
      IF p_A049CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T049_CODIGOCIIU 
      WHERE A049CODIGO = p_A049CODIGO AND A049ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T049_CODIGOCIIU 
         SET A049CODIGOCIIU = p_A049CODIGOCIIU, A049DESCRIPCIONCIIU = p_A049DESCRIPCIONCIIU, A049FECHAMODIFICACION = sysdate,
           A049USUARIOMODIFICACION = p_idUsuario 
         WHERE A049CODIGO = p_A049CODIGO;    
	       OPEN p_resultado FOR SELECT p_A049CODIGO A049CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A049CODIGO);
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
           SELECT * FROM GPYT_T049_CODIGOCIIU WHERE A049ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A049ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T049_CODIGOCIIU WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          
  
end PK_T049_CODIGOCIIU;