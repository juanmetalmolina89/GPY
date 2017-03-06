create or replace package body PK_T020_DIVIPOLA is
  
  PROCEDURE Pr_Insertar (p_A020DIVIPOLA IN GPYT_T020_DIVIPOLA.A020DIVIPOLA%TYPE,         
                         p_A020CODPAIS IN GPYT_T020_DIVIPOLA.A020CODPAIS%TYPE,              
                         p_A020NOMPAIS IN GPYT_T020_DIVIPOLA.A020NOMPAIS%TYPE,                 
                         p_A020CODDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020CODDEPARTAMENTO%TYPE,      
                         p_A020NOMDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020NOMDEPARTAMENTO%TYPE,         
                         p_A020CODMUNICIPIO IN GPYT_T020_DIVIPOLA.A020CODMUNICIPIO%TYPE,         
                         p_A020NOMMUNICIPIO IN GPYT_T020_DIVIPOLA.A020NOMMUNICIPIO%TYPE,            
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A020CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A020CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T020_ENTIDAD_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A020DIVIPOLA);
                                               
      INSERT INTO GPYT_T020_DIVIPOLA (A020CODIGO, A020DIVIPOLA, A020CODPAIS, A020NOMPAIS, A020CODDEPARTAMENTO, A020NOMDEPARTAMENTO, A020CODMUNICIPIO, A020NOMMUNICIPIO, 
        A020ESTADOREGISTRO, A020FECHACREACION, A020USUARIOCREACION)
      VALUES (p_A020CODIGO, p_A020DIVIPOLA, p_A020CODPAIS, p_A020NOMPAIS, p_A020CODDEPARTAMENTO, p_A020NOMDEPARTAMENTO, p_A020CODMUNICIPIO, p_A020NOMMUNICIPIO,
        PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
        
      OPEN p_resultado FOR SELECT p_A020CODIGO A020CODIGO FROM dual;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A020DIVIPOLA);       
  END Pr_Insertar;						 

  PROCEDURE Pr_Eliminar (p_A020CODIGO IN GPYT_T020_DIVIPOLA.A020CODIGO%TYPE,
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
                                        p_descripcion   => 'Entro a Pr_Eliminar ' || p_A020CODIGO);
  
     UPDATE GPYT_T020_DIVIPOLA 
     SET A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A020FECHAMODIFICACION = sysdate, A020USUARIOMODIFICACION = p_idUsuario 
     WHERE A020CODIGO = p_A020CODIGO;
     OPEN p_resultado FOR SELECT p_A020CODIGO A020CODIGO FROM dual;
     p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
     p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError); 

     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Salio de Pr_Eliminar ' || p_A020CODIGO);  
  END Pr_Eliminar;	                         
  
  PROCEDURE Pr_Actualizar (p_A020CODIGO IN GPYT_T020_DIVIPOLA.A020CODIGO%TYPE,
                           p_A020DIVIPOLA IN GPYT_T020_DIVIPOLA.A020DIVIPOLA%TYPE,         
                           p_A020CODPAIS IN GPYT_T020_DIVIPOLA.A020CODPAIS%TYPE,              
                           p_A020NOMPAIS IN GPYT_T020_DIVIPOLA.A020NOMPAIS%TYPE,                 
                           p_A020CODDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020CODDEPARTAMENTO%TYPE,      
                           p_A020NOMDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020NOMDEPARTAMENTO%TYPE,         
                           p_A020CODMUNICIPIO IN GPYT_T020_DIVIPOLA.A020CODMUNICIPIO%TYPE,         
                           p_A020NOMMUNICIPIO IN GPYT_T020_DIVIPOLA.A020NOMMUNICIPIO%TYPE,            
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
                                        p_descripcion   => 'Entro a Pr_Actualizar ' || p_A020CODIGO);

      IF p_A020CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T020_DIVIPOLA WHERE A020CODIGO = p_A020CODIGO AND A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      IF numReg > 0 THEN
         UPDATE GPYT_T020_DIVIPOLA 
         SET A020DIVIPOLA = p_A020DIVIPOLA, A020CODPAIS = p_A020CODPAIS, A020NOMPAIS = p_A020NOMPAIS,
           A020CODDEPARTAMENTO = p_A020CODDEPARTAMENTO, A020NOMDEPARTAMENTO = p_A020NOMDEPARTAMENTO, A020CODMUNICIPIO = p_A020CODMUNICIPIO,
           A020NOMMUNICIPIO = p_A020NOMMUNICIPIO, A020FECHAMODIFICACION = sysdate, A020USUARIOMODIFICACION = p_idUsuario 
         WHERE A020CODIGO = p_A020CODIGO;    
	       OPEN p_resultado FOR SELECT p_A020CODIGO A020CODIGO FROM dual;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
         return;
      ELSE
         p_codError := 5;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);  
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;
      END IF;
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A020CODIGO);
  END Pr_Actualizar;	                                       
  
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorFiltro';                       
    strSQL               VARCHAR2(255);
    p_Temp               VARCHAR2(30);
    
   BEGIN  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => p_idUsuario,
                                       p_descripcion   => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
  
      IF p_Filtro IS NULL THEN
         OPEN p_Respuesta FOR SELECT * FROM GPYT_T020_DIVIPOLA WHERE A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A020ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T020_DIVIPOLA WHERE ' || p_Filtro  || p_Temp;         
      OPEN p_Respuesta FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);
  END Pr_ConsultarPorFiltro;	

  PROCEDURE Pr_ConsultarPorId (p_A020CODIGO IN GPYT_T020_DIVIPOLA.A020CODIGO%TYPE,
                               p_idUsuario IN NUMBER,  
                               p_Respuesta OUT CURSOR_SALIDA,
                               p_codError OUT NUMBER,
                               p_msjError OUT VARCHAR2) IS

     codExcepcion         NUMBER;
     NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorId';                       
    
  BEGIN  
     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => p_idUsuario,
                                       p_descripcion   => 'Entro a Pr_ConsultarPorId ' || p_A020CODIGO);       
                                       
      OPEN p_Respuesta FOR SELECT * FROM GPYT_T020_DIVIPOLA 
        WHERE A020CODIGO = p_A020CODIGO AND A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorId ' || p_A020CODIGO);                                       
  END Pr_ConsultarPorId;	

end PK_T020_DIVIPOLA;