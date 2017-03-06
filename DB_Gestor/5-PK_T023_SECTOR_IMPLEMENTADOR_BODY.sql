create or replace package body PK_T023_SECTOR_IMPLEMENTADOR is

  PROCEDURE Pr_Insertar (p_A023DESCSECTRIMPLMNTDR IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023DESCSECTRIMPLMNTDR%TYPE,
			 p_A023IDTIPPROYCT IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023IDTIPPROYCT%TYPE,
                         p_idUsuario IN NUMBER,                         
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
    p_A023CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A023CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T023_SECTOR_IMPLEMENTADOR_SEQ');
   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A023DESCSECTRIMPLMNTDR);
  
      INSERT INTO GPYT_T023_SECTOR_IMPLEMENTADOR (A023CODIGO, A023DESCSECTRIMPLMNTDR, A023IDTIPPROYCT, A023ESTADOREGISTRO, A023FECHACREACION,
        A023USUARIOCREACION) VALUES (p_A023CODIGO, p_A023DESCSECTRIMPLMNTDR, p_A023IDTIPPROYCT, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate,
        p_idUsuario);
      OPEN p_resultado FOR SELECT p_A023CODIGO A023CODIGO FROM dual; 
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A023DESCSECTRIMPLMNTDR); 
         
  END Pr_Insertar;                         
 
  PROCEDURE Pr_Actualizar (p_A023CODIGO IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023CODIGO%TYPE,
                           p_A023DESCSECTRIMPLMNTDR IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023DESCSECTRIMPLMNTDR%TYPE,
                           p_A023IDTIPPROYCT IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023IDTIPPROYCT%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A023CODIGO);

      IF p_A023CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T023_SECTOR_IMPLEMENTADOR 
      WHERE A023CODIGO = p_A023CODIGO AND A023ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      IF numReg > 0 THEN
         UPDATE GPYT_T023_SECTOR_IMPLEMENTADOR SET A023DESCSECTRIMPLMNTDR = NVL(p_A023DESCSECTRIMPLMNTDR, A023DESCSECTRIMPLMNTDR), 
           A023IDTIPPROYCT = NVL(p_A023IDTIPPROYCT, A023IDTIPPROYCT), 
           A023USUARIOMODIFICACION = p_idUsuario, A023FECHAMODIFICACION = sysdate WHERE A023CODIGO = p_A023CODIGO;   
	       OPEN p_resultado FOR SELECT p_A023CODIGO A023CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A023CODIGO);
  END Pr_Actualizar;	 
  
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorFiltro';
    estadoReg            VARCHAR2(1);                         
    strSQL               VARCHAR2(255);
    p_Temp               VARCHAR2(30);
    
   BEGIN
     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
  
        IF p_Filtro IS NULL THEN
         OPEN p_resultado FOR
         SELECT * FROM GPYT_T023_SECTOR_IMPLEMENTADOR WHERE A023ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
         return; 
      END IF;                                         
      
      p_Temp := q'{ AND A023ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T023_SECTOR_IMPLEMENTADOR WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro); 
    END Pr_ConsultarPorFiltro;	
  
  PROCEDURE Pr_Eliminar (p_A023CODIGO IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023CODIGO%TYPE,
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
                                        p_descripcion   => 'Entro a Pr_Eliminar ' || p_A023CODIGO);
  
     UPDATE GPYT_T023_SECTOR_IMPLEMENTADOR 
     SET A023ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, 
         A023FECHAMODIFICACION = sysdate, 
         A023USUARIOMODIFICACION = p_idUsuario 
     WHERE A023CODIGO = p_A023CODIGO;
     
     OPEN p_resultado FOR SELECT '' FROM dual;
     p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
     p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 


     PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                        p_paquete       => NOMBRE_PAQUETE,
                                        p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                        p_usuario       => p_idUsuario,
                                        p_descripcion   => 'Salio de Pr_Eliminar ' || p_A023CODIGO);  
  END Pr_Eliminar;	  
   
end PK_T023_SECTOR_IMPLEMENTADOR;