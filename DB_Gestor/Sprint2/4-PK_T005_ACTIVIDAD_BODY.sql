create or replace package body PK_T005_ACTIVIDAD is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
                         p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,
                         p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
                         p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
                         p_A005IDSOPORTE IN GPYT_T005_ACTIVIDAD.A005IDSOPORTE%TYPE,
                         p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                         p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,                         
                         p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
                         p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                         p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			                   p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A005CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A005CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T005_ACTIVIDAD_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A005DESCRPCNACTVDD);
      
      INSERT INTO GPYT_T005_ACTIVIDAD (A005CODIGO, A005DESCRPCNACTVDD, A005IDTIPACTVDD, A005IDPROYECTO, A005IDSECTORIPCC, A005IDSOPORTE, A005FECHAINICIO, 
            A005FECHAFINAL, A005COSTOTOTAL, A005CONTRBCNPROP, A005CONTRBCNEXTRN, A005ESTADOREGISTRO, A005FECHACREACION, A005USUARIOCREACION) 
      VALUES (p_A005CODIGO, p_A005DESCRPCNACTVDD, p_A005IDTIPACTVDD, p_A005IDPROYECTO, p_A005IDSECTORIPCC, p_A005IDSOPORTE, TO_DATE(p_A005FECHAINICIO,'YYYY-MM-DD'), 
            TO_DATE(p_A005FECHAFINAL,'YYYY-MM-DD'), p_A005COSTOTOTAL, p_A005CONTRBCNPROP, p_A005CONTRBCNEXTRN, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A005CODIGO A005CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A005DESCRPCNACTVDD);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A005CODIGO);
  
      UPDATE GPYT_T005_ACTIVIDAD 
      SET A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A005FECHAMODIFICACION = sysdate,
          A005USUARIOMODIFICACION = p_idUsuario 
      WHERE A005CODIGO = p_A005CODIGO;
              
      OPEN p_resultado FOR SELECT p_A005CODIGO A005CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A005CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A005CODIGO IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
                           p_A005DESCRPCNACTVDD IN GPYT_T005_ACTIVIDAD.A005DESCRPCNACTVDD%TYPE,
			                     p_A005IDTIPACTVDD IN GPYT_T005_ACTIVIDAD.A005IDTIPACTVDD%TYPE,
                           p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
			                     p_A005IDSECTORIPCC IN GPYT_T005_ACTIVIDAD.A005IDSECTORIPCC%TYPE,
			                     p_A005IDSOPORTE IN GPYT_T005_ACTIVIDAD.A005IDSOPORTE%TYPE,
                           p_A005FECHAINICIO IN GPYT_T005_ACTIVIDAD.A005FECHAINICIO%TYPE,
                           p_A005FECHAFINAL IN GPYT_T005_ACTIVIDAD.A005FECHAFINAL%TYPE,				   
			                     p_A005COSTOTOTAL IN GPYT_T005_ACTIVIDAD.A005COSTOTOTAL%TYPE,
			                     p_A005CONTRBCNPROP IN GPYT_T005_ACTIVIDAD.A005CONTRBCNPROP%TYPE,
                           p_A005CONTRBCNEXTRN IN GPYT_T005_ACTIVIDAD.A005CONTRBCNEXTRN%TYPE,
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
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A005CODIGO);
      
      IF p_A005CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T005_ACTIVIDAD 
      WHERE A005CODIGO = p_A005CODIGO AND A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T005_ACTIVIDAD 
         SET A005DESCRPCNACTVDD = NVL(p_A005DESCRPCNACTVDD, A005DESCRPCNACTVDD),
             A005IDTIPACTVDD = NVL(p_A005IDTIPACTVDD, A005IDTIPACTVDD),
             A005IDPROYECTO = NVL(p_A005IDPROYECTO, A005IDPROYECTO),
             A005IDSECTORIPCC = NVL(p_A005IDSECTORIPCC, A005IDSECTORIPCC),
             A005IDSOPORTE = NVL(p_A005IDSOPORTE, A005IDSOPORTE),
             A005FECHAINICIO = NVL(p_A005FECHAINICIO, A005FECHAINICIO),
             A005FECHAFINAL = NVL(p_A005FECHAFINAL, A005FECHAFINAL),
             A005COSTOTOTAL = NVL(p_A005COSTOTOTAL, A005COSTOTOTAL),
             A005CONTRBCNPROP = NVL(p_A005CONTRBCNPROP, A005CONTRBCNPROP),
             A005CONTRBCNEXTRN = NVL(p_A005CONTRBCNEXTRN, A005CONTRBCNEXTRN),
             A005USUARIOMODIFICACION = p_idUsuario, A005FECHAMODIFICACION = sysdate 
         WHERE A005CODIGO = p_A005CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A005CODIGO A005CODIGO FROM dual;
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
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A005CODIGO);
  
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
           SELECT * FROM GPYT_T005_ACTIVIDAD WHERE A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A005ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYT_T005_ACTIVIDAD WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          

end PK_T005_ACTIVIDAD;