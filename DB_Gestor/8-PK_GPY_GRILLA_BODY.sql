--------------------------------------------------------
-- Archivo creado  - domingo-febrero-19-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_GPY_GRILLA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "GESTOR"."PK_GPY_GRILLA" 
IS
  -- Funciones y Procedimientos del paquete
   PROCEDURE Pr_ListarProyectos(
      p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
      p_IdUsuario  IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarProyectos';
    codExcepcion         NUMBER;
    p_CLASUSR            VARCHAR2(10);
	p_AA				 NUMBER;
  BEGIN
    -- Obtenemos el tipo de usuario
    OPEN p_Respuesta FOR SELECT A102VALORCORTO FROM GPYT_T041_USUARIO, PART_T102_LISTA WHERE A041CODIGO = p_A041CODIGO AND A102CODIGO = A041IDCLASUSR;
    FETCH p_Respuesta INTO p_CLASUSR;
    --***
  /*  IF p_CLASUSR != 'PB' THEN
      OPEN p_Respuesta FOR SELECT * FROM GPYV_006_PROYECTOS WHERE A002IDUSR = p_A041CODIGO OR A055IDPUBLICADOR = p_A041CODIGO AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      p_codError                                                           := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                           := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      RETURN;
    END IF; */	
	 CASE 
      WHEN p_CLASUSR = 'FM' OR p_CLASUSR = 'IV'  THEN 
				OPEN p_Respuesta FOR SELECT * FROM GPYV_006_PROYECTOS WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ORDER BY A002FECHACREACION DESC;
				p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
				p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      WHEN p_CLASUSR = 'AA' THEN
				---**
				OPEN p_Respuesta FOR SELECT A001CODIGO FROM GPYT_T001_ENTIDAD EN LEFT JOIN GPYT_T052_PERSONA PR ON EN.A001CODIGO = PR.A052IDENTIDAD LEFT JOIN GPYT_T041_USUARIO US ON PR.A052CODIGO = US.A041IDPERSONA WHERE US.A041CODIGO = p_A041CODIGO AND US.A041ESTADOREGISTRO =PK_UTL_CONSTANTE.COD_ACTIVO;
				FETCH p_Respuesta INTO p_AA;
				---**
				OPEN p_Respuesta FOR SELECT * FROM GPYV_006_PROYECTOS WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A001CODIGO = p_AA ORDER BY A002FECHACREACION DESC;
				p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
				p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      WHEN  p_CLASUSR = 'PB' OR p_CLASUSR = 'GP' THEN 
				OPEN p_Respuesta FOR SELECT * FROM GPYV_006_PROYECTOS WHERE A002IDUSR = p_A041CODIGO OR A055IDPUBLICADOR = p_A041CODIGO AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ORDER BY A002FECHACREACION DESC;
				p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
				p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);     
      ELSE
				OPEN p_Respuesta FOR SELECT * FROM GPYV_006_PROYECTOS WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO ORDER BY A002FECHACREACION DESC;
				p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
				p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
   END CASE; 
   ---***    
   RETURN;
  
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_Respuesta FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarProyectos;
  ---***
  PROCEDURE Pr_ListarProyectosPorClave(
      p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
      p_Clave      IN VARCHAR2,
      p_IdUsuario  IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarProyectosPorClave';
    codExcepcion         NUMBER;
    p_CLASUSR            CHAR(2);
    p_Temp               VARCHAR2(8000);
    strSQL               VARCHAR2(500);
  BEGIN
    -- Obtenemos el tipo de usuario
    OPEN p_Respuesta FOR SELECT A102VALORCORTO FROM GPYT_T041_USUARIO,
    PART_T102_LISTA WHERE A041CODIGO = p_IdUsuario AND A102CODIGO = A041IDCLASUSR;
    FETCH p_Respuesta INTO p_CLASUSR;
    p_Temp       := q'{ AND (INSTR(UPPER(A001NOMBRE),UPPER('}' || p_Clave || q'{')) > 0                     
OR INSTR(UPPER(A002DESCRPCINPROYCT),UPPER('}' || p_Clave || q'{')) > 0                    
OR INSTR(UPPER(A002TIPPROYCT),UPPER('}' || p_Clave || q'{')) > 0                    
OR INSTR(UPPER(TIPOPROYECTO),UPPER('}' || p_Clave || q'{')) > 0                    
OR INSTR(UPPER(ESTADOPROYECTO), UPPER('}' || p_Clave || q'{')) > 0)                                          
AND A002ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
    IF p_CLASUSR != 'PB' THEN
      strSQL     := 'SELECT * FROM GPYV_006_PROYECTOS WHERE (A002IDUSR = ' || p_A041CODIGO || ' OR A055IDPUBLICADOR = ' || p_A041CODIGO || ') ' || p_Temp;
      dbms_output.put_line('strSQL: ' || strSQL);
      OPEN p_Respuesta FOR strSQL || ' ' || p_Temp;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      RETURN;
    END IF;
    IF p_CLASUSR = 'PB' THEN
      strSQL    := q'{SELECT * FROM GPYV_006_PROYECTOS WHERE A002ESTADOREGISTRO ='}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}' || p_Temp;
      dbms_output.put_line('strSQL: ' || strSQL);
      OPEN p_Respuesta FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
      RETURN;
    END IF;
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_Respuesta FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarProyectosPorClave;
  PROCEDURE Pr_ListarActividades(
      p_A005CODIGO     IN GPYT_T005_ACTIVIDAD.A005CODIGO%TYPE,
      p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
      p_IdUsuario      IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarActividades';
    codExcepcion         NUMBER;
  BEGIN
    IF p_A005IDPROYECTO IS NULL THEN
      OPEN p_Respuesta FOR SELECT A005CODIGO,
      A005DESCRPCNACTVDD,
      A005IDTIPACTVDD,
      A022DESCRPCNACTVDD,
      A005IDSECTORIPCC,
      A045NOMBRE,
      A005IDSOPORTE,
      A026DESCRPCNARCHIV,
      A026NOMARCHIVO,
      A005FECHAINICIO,
      A005FECHAFINAL FROM GPYT_T005_ACTIVIDAD LEFT JOIN GPYT_T022_TIPO_ACTIVIDAD ON A022CODIGO = A005IDTIPACTVDD LEFT JOIN GPYT_T045_SECTOR_IPCC ON A045CODIGO = A005IDSECTORIPCC LEFT JOIN GPYT_T026_ARCHIVO ON A026CODIGO = A005IDSOPORTE WHERE A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A005CODIGO = p_A005CODIGO;
      p_codError                                                                              := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                              := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
    END IF;
    IF p_A005CODIGO IS NULL THEN
      OPEN p_Respuesta FOR SELECT A005CODIGO,
      A005DESCRPCNACTVDD,
      A005IDTIPACTVDD,
      A022DESCRPCNACTVDD,
      A005IDSECTORIPCC,
      A045NOMBRE,
      A005IDSOPORTE,
      A026DESCRPCNARCHIV,
      A026NOMARCHIVO,
      A005FECHAINICIO,
      A005FECHAFINAL FROM GPYT_T005_ACTIVIDAD LEFT JOIN GPYT_T022_TIPO_ACTIVIDAD ON A022CODIGO = A005IDTIPACTVDD LEFT JOIN GPYT_T045_SECTOR_IPCC ON A045CODIGO = A005IDSECTORIPCC LEFT JOIN GPYT_T026_ARCHIVO ON A026CODIGO = A005IDSOPORTE WHERE A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A005IDPROYECTO = p_A005IDPROYECTO;
      p_codError                                                                              := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                              := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
    END IF;
    IF p_A005CODIGO IS NOT NULL AND p_A005IDPROYECTO IS NOT NULL THEN
      OPEN p_Respuesta FOR SELECT A005CODIGO,
      A005DESCRPCNACTVDD,
      A005IDTIPACTVDD,
      A022DESCRPCNACTVDD,
      A005IDSECTORIPCC,
      A045NOMBRE,
      A005IDSOPORTE,
      A026DESCRPCNARCHIV,
      A026NOMARCHIVO,
      A005FECHAINICIO,
      A005FECHAFINAL FROM GPYT_T005_ACTIVIDAD LEFT JOIN GPYT_T022_TIPO_ACTIVIDAD ON A022CODIGO = A005IDTIPACTVDD LEFT JOIN GPYT_T045_SECTOR_IPCC ON A045CODIGO = A005IDSECTORIPCC LEFT JOIN GPYT_T026_ARCHIVO ON A026CODIGO = A005IDSOPORTE WHERE A005CODIGO = p_A005CODIGO AND A005IDPROYECTO = p_A005IDPROYECTO AND A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      p_codError                                                                              := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                              := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
    END IF;
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_Respuesta FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarActividades;
  PROCEDURE Pr_ListarActividadesPorClave(
      p_A005IDPROYECTO IN GPYT_T005_ACTIVIDAD.A005IDPROYECTO%TYPE,
      p_Clave          IN VARCHAR2,
      p_IdUsuario      IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarActividadesPorClave';
    codExcepcion         NUMBER;
    p_Temp               VARCHAR2(8000);
    strSQL               VARCHAR2(8000);
  BEGIN
    strSQL     := 'SELECT A005CODIGO, A005DESCRPCNACTVDD, A005IDTIPACTVDD, A022DESCRPCNACTVDD, A005IDSECTORIPCC, A045NOMBRE,            
A005IDSOPORTE, A026DESCRPCNARCHIV, A026NOMARCHIVO, A005FECHAINICIO, A005FECHAFINAL           
FROM GPYT_T005_ACTIVIDAD           
LEFT JOIN GPYT_T022_TIPO_ACTIVIDAD ON A022CODIGO = A005IDTIPACTVDD           
LEFT JOIN GPYT_T045_SECTOR_IPCC ON A045CODIGO = A005IDSECTORIPCC           
LEFT JOIN GPYT_T026_ARCHIVO ON A026CODIGO = A005IDSOPORTE WHERE ';
    IF p_Clave IS NOT NULL THEN
      p_Temp   := q'{ (INSTR(UPPER(A005DESCRPCNACTVDD),UPPER('}' || p_Clave || q'{')) > 0                     
OR INSTR(UPPER(A022DESCRPCNACTVDD),UPPER('}' || p_Clave || q'{')) > 0                    
OR INSTR(UPPER(A045NOMBRE),UPPER('}' || p_Clave || q'{')) > 0                    
OR INSTR(UPPER(A026DESCRPCNARCHIV),UPPER('}' || p_Clave || q'{')) > 0                    
OR INSTR(UPPER(A026NOMARCHIVO), UPPER('}' || p_Clave || q'{')) > 0)                                          
AND A005ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'                    
AND A005IDPROYECTO = '}' || p_A005IDPROYECTO || q'{'}';
      OPEN p_Respuesta FOR strSQL || p_Temp;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
    END IF;
    IF p_A005IDPROYECTO IS NOT NULL AND p_Clave IS NULL THEN
      OPEN p_Respuesta FOR SELECT A005CODIGO,
      A005DESCRPCNACTVDD,
      A005IDTIPACTVDD,
      A022DESCRPCNACTVDD,
      A005IDSECTORIPCC,
      A045NOMBRE,
      A005IDSOPORTE,
      A026DESCRPCNARCHIV,
      A026NOMARCHIVO,
      A005FECHAINICIO,
      A005FECHAFINAL FROM GPYT_T005_ACTIVIDAD LEFT JOIN GPYT_T022_TIPO_ACTIVIDAD ON A022CODIGO = A005IDTIPACTVDD LEFT JOIN GPYT_T045_SECTOR_IPCC ON A045CODIGO = A005IDSECTORIPCC LEFT JOIN GPYT_T026_ARCHIVO ON A026CODIGO = A005IDSOPORTE WHERE A005ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A005IDPROYECTO = p_A005IDPROYECTO;
      p_codError                                                                              := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError                                                                              := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
    END IF;
    dbms_output.put_line('strSQL: ' || strSQL || p_Temp);
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    OPEN p_Respuesta FOR SELECT '' FROM dual;
    p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarActividadesPorClave;
END PK_GPY_GRILLA;
