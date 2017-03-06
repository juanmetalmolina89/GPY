create or replace package body PK_T006_PROY_SECTR_IMPLMNTDR is

  PROCEDURE Pr_Insertar (p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                         p_A006IDSECTRIMPLMNTDR IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDSECTRIMPLMNTDR%TYPE,
                         p_A006DETALLEOTRO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006DETALLEOTRO%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A006CODIGO         NUMBER;
    
  BEGIN
      -- obtenemos el siguiente id
      p_A006CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T006_PROY_SECTR_IMPLMNTDR_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A006IDSECTRIMPLMNTDR);
  
      INSERT INTO GPYT_T006_PROY_SECTR_IMPLMNTDR (A006CODIGO, A006IDPROYECTO, A006IDSECTRIMPLMNTDR, A006DETALLEOTRO, A006ESTADOREGISTRO, A006FECHACREACION,
        A006USUARIOCREACION) 
      VALUES (p_A006CODIGO, p_A006IDPROYECTO, p_A006IDSECTRIMPLMNTDR, p_A006DETALLEOTRO, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate,
        p_idUsuario);
      
      OPEN p_resultado FOR SELECT p_A006CODIGO A006CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A006IDSECTRIMPLMNTDR);      
            
  END Pr_Insertar;                         

  PROCEDURE Pr_Actualizar (p_A006CODIGO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006CODIGO%TYPE,
                           p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                           p_A006IDSECTRIMPLMNTDR IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDSECTRIMPLMNTDR%TYPE,
                           p_A006DETALLEOTRO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006DETALLEOTRO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A006CODIGO);
  
      IF p_A006CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T006_PROY_SECTR_IMPLMNTDR 
      WHERE A006CODIGO = p_A006CODIGO AND A006ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      IF numReg > 0 THEN
         UPDATE GPYT_T006_PROY_SECTR_IMPLMNTDR 
         SET A006IDPROYECTO = NVL(p_A006IDPROYECTO, A006IDPROYECTO), 
             A006IDSECTRIMPLMNTDR = NVL(p_A006IDSECTRIMPLMNTDR, A006IDSECTRIMPLMNTDR), 
             A006DETALLEOTRO = NVL(p_A006DETALLEOTRO, p_A006DETALLEOTRO),
             A006USUARIOMODIFICACION = p_idUsuario, A006FECHAMODIFICACION = sysdate 
         WHERE A006CODIGO = p_A006CODIGO;   
	    
         OPEN p_resultado FOR SELECT p_A006CODIGO A006CODIGO FROM dual;
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
                                        p_descripcion   => 'Salio de Pr_Actualizar ' || p_A006CODIGO);
                    
  END Pr_Actualizar;	 
  
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,
                                   p_resultado OUT CURSOR_SALIDA,                          
                                   p_codError OUT NUMBER,
			                             p_msjError OUT VARCHAR2) IS						   

     codExcepcion         NUMBER;
     NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorId';                       
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
        SELECT A006IDPROYECTO, A006IDSECTRIMPLMNTDR 
        FROM GPYT_T006_PROY_SECTR_IMPLMNTDR
        WHERE A006ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
        p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
        p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
        return; 
      END IF;

      p_Temp := q'{ AND A006ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T006_PROY_SECTR_IMPLMNTDR WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;	 

  PROCEDURE Pr_Eliminar (p_A006CODIGO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A006CODIGO);
                                         
      UPDATE GPYT_T006_PROY_SECTR_IMPLMNTDR 
      SET A006ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A006FECHAMODIFICACION = sysdate,
          A006USUARIOMODIFICACION = p_idUsuario 
      WHERE A006CODIGO = p_A006CODIGO;
      OPEN p_resultado FOR SELECT p_A006CODIGO A006CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A006CODIGO);      
 
  END Pr_Eliminar;	  
   
end PK_T006_PROY_SECTR_IMPLMNTDR;