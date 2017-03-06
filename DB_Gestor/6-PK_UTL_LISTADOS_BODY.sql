--------------------------------------------------------
-- Archivo creado  - domingo-febrero-19-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PK_UTL_LISTADOS
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "GESTOR"."PK_UTL_LISTADOS" is
                          
 PROCEDURE Pr_ListarAutoridades (p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2) IS
  
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarAutoridades';

  BEGIN 
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ListarAutoridades ');

      PK_T001_ENTIDAD.Pr_ConsultarPorFiltro (p_Filtro => NULL,
                                             p_idUsuario => p_idUsuario,  
                                             p_resultado => p_Respuesta,
                                             p_codError => p_codError,
                                             p_msjError => p_msjError);	          

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ListarAutoridades ');      

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

 END Pr_ListarAutoridades;

 PROCEDURE Pr_ListarParametricas (p_Categoria IN VARCHAR2,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,                               
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarParametricas';

  BEGIN  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Entro a Pr_ListarParametricas ');

    PK_UTL_UTILIDAD.Pr_ConsultarLista (p_Categoria => p_Categoria,
                                       p_datRespuesta => p_Respuesta,
                                       p_codError => p_codError,
                                       p_msjError => p_msjError);

    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Salio de Pr_ListarParametricas ');

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);                                    

 END Pr_ListarParametricas;

 -- Lista los sectores implementadores por tipo de proyecto
 PROCEDURE Pr_ListarSectorImplementador (p_A023IDTIPPROYCT IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023IDTIPPROYCT%TYPE,
                                         p_idUsuario IN NUMBER,
                                         p_Respuesta OUT CURSOR_SALIDA,
                                         p_codError OUT NUMBER,
                                         p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarSectorImplementador';
    p_Filtro             VARCHAR2(50) := 'A023IDTIPPROYCT = ' || p_A023IDTIPPROYCT;

  BEGIN  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Entro a Pr_ListarSectorImplementador ');

    PK_T023_SECTOR_IMPLEMENTADOR.Pr_ConsultarPorFiltro (p_Filtro => p_Filtro,
                                                        p_idUsuario => p_idUsuario, 
                                                        p_resultado => p_Respuesta,
                                                        p_codError => p_codError,
                                                        p_msjError => p_msjError);

    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Salio de Pr_ListarSectorImplementador ');

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);                                    

  END Pr_ListarSectorImplementador;

 PROCEDURE Pr_ListarPaises (p_idUsuario IN NUMBER,
                            p_Respuesta OUT CURSOR_SALIDA,
                            p_codError OUT NUMBER,
                            p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarPaises';

  BEGIN  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Entro a Pr_ListarPaises ');

    OPEN p_Respuesta FOR 
    SELECT DISTINCT A020CODPAIS, A020NOMPAIS
    FROM GPYT_T020_DIVIPOLA 
    WHERE A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;

    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Salio de Pr_ListarPaises ');

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);                                    

 END Pr_ListarPaises;                            

 PROCEDURE Pr_ListarDepartamentos (p_A020CODPAIS IN GPYT_T020_DIVIPOLA.A020CODPAIS%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarDepartamentos';

  BEGIN  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Entro a Pr_ListarDepartamentos ');

    OPEN p_Respuesta FOR 
    SELECT DISTINCT A020CODDEPARTAMENTO, A020NOMDEPARTAMENTO
    FROM GPYT_T020_DIVIPOLA 
    WHERE A020CODPAIS = p_A020CODPAIS AND A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;

    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Salio de Pr_ListarDepartamentos ');

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);                                    

  END Pr_ListarDepartamentos;

 PROCEDURE Pr_ListarMunicipios (p_A020CODDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020CODDEPARTAMENTO%TYPE,
                                p_idUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarMunicipios';

  BEGIN  
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Entro a Pr_ListarMunicipios ');

    OPEN p_Respuesta FOR 
    SELECT DISTINCT A020CODIGO, A020CODMUNICIPIO, A020NOMMUNICIPIO
    FROM GPYT_T020_DIVIPOLA 
    WHERE A020CODDEPARTAMENTO = p_A020CODDEPARTAMENTO AND A020ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;

    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                       p_paquete       => NOMBRE_PAQUETE,
                                       p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                       p_usuario       => 0,
                                       p_descripcion   => 'Salio de Pr_ListarMunicipios ');

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);                                    

  END Pr_ListarMunicipios;  

  PROCEDURE Pr_ListarCodigoCIIU (p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarCodigoCIIU';

  BEGIN 
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ListarCodigoCIIU ');

      PK_T049_CODIGOCIIU.Pr_ConsultarPorFiltro (p_Filtro => NULL,
                                                p_idUsuario => p_idUsuario,  
                                                p_resultado => p_Respuesta,
                                                p_codError => p_codError,
                                                p_msjError => p_msjError);	          

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ListarCodigoCIIU ');      

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

 END Pr_ListarCodigoCIIU;

 PROCEDURE Pr_ListarTipoDocumento (p_TipoPersona IN NUMBER,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarTipoDocumento';

  BEGIN 
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ListarTipoDocumento ');

      PK_T015_TIPO_DOCUMENTO.Pr_ConsultarPorFiltro (p_Filtro => 'A015IDTIPPERSN = ' || p_TipoPersona,
                                                    p_idUsuario => p_idUsuario,  
                                                    p_resultado => p_Respuesta,
                                                    p_codError => p_codError,
                                                    p_msjError => p_msjError);	          

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ListarTipoDocumento ');      

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

 END Pr_ListarTipoDocumento;

 FUNCTION Fn_TraerCodigo (p_VALOR IN VARCHAR2) RETURN NUMBER IS
    p_Codigo   NUMBER;
  BEGIN
    SELECT A102CODIGO INTO p_Codigo FROM PART_T102_LISTA WHERE UPPER(A102VALOR) = UPPER(p_Valor);
    RETURN p_Codigo;
 END Fn_TraerCodigo;
/*
 PROCEDURE Pr_ListarTipoActividad (p_A022IDTIPPROYCT IN NUMBER,
                                   p_A022IDTIPPROYCTMDL IN NUMBER,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarTipoActividad';
    pFiltro              VARCHAR2(50);

  BEGIN 
      IF p_A022IDTIPPROYCTMDL IS NOT NULL THEN
         pFiltro := q'{ A022IDTIPPROYCT = '}' || p_A022IDTIPPROYCT || q'{' AND A022IDTIPPROYCTMDL = '}' || p_A022IDTIPPROYCTMDL || q'{'}';
      ELSE
         pFiltro := q'{ A022IDTIPPROYCT = '}' || p_A022IDTIPPROYCT || q'{'}';
      END IF;
      PK_T022_TIPO_ACTIVIDAD.Pr_ConsultarPorFiltro (p_Filtro => pFiltro,
                                                    p_idUsuario => p_idUsuario,  
                                                    p_resultado => p_Respuesta,
                                                    p_codError => p_codError,
                                                    p_msjError => p_msjError);	  

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

 END Pr_ListarTipoActividad; 
*/
PROCEDURE Pr_ListarTipoActividad (p_A022IDTIPPROYCT IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCT%TYPE, 
                                   p_idUsuario IN NUMBER, 
                                   p_Respuesta OUT CURSOR_SALIDA, 
                                   p_codError OUT NUMBER, 
                                   p_msjError OUT VARCHAR2) IS 

    codExcepcion         NUMBER; 
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarTipoActividad'; 
    pFiltro              VARCHAR2(50); 

  BEGIN  
      OPEN p_Respuesta FOR SELECT A022CODIGO, A022DESCRPCNACTVDD, A022IDTIPPROYCTMDL, A022ACTESPECIAL, A102VALOR TIPPROYCTMDL 
         FROM GPYT_T022_TIPO_ACTIVIDAD 
         LEFT JOIN PART_T102_LISTA ON A022IDTIPPROYCTMDL = A102CODIGO 
         WHERE A022IDTIPPROYCT = p_A022IDTIPPROYCT AND A022ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA; 
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);          

  EXCEPTION 
      WHEN OTHERS THEN   
        ROLLBACK; 

      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, 
                                                             NOMBRE_PAQUETE, 
                                                             NOMBRE_PROCEDIMIENTO, 
                                                             SQLCODE, 
                                                             SQLERRM); 

      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL; 
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion); 

 END Pr_ListarTipoActividad; 

PROCEDURE Pr_ListarMetodMDL (p_A028IDESCL IN GPYT_T028_METODOLOGIA_MDL.A028IDESCL%TYPE, 
                              p_A028IDSECTORALSCOPE IN GPYT_T028_METODOLOGIA_MDL.A028IDSECTORALSCOPE%TYPE,
                              p_idUsuario IN NUMBER,
                              p_Respuesta OUT CURSOR_SALIDA,
                              p_codError OUT NUMBER,
                              p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarTipoDocumento';
    pFiltro              VARCHAR2(50);

  BEGIN

      OPEN p_Respuesta FOR SELECT A028CODIGO, A028DESCMETDLGMDL FROM GPYT_T028_METODOLOGIA_MDL 
        WHERE A028IDESCL = p_A028IDESCL AND A028IDSECTORALSCOPE = p_A028IDSECTORALSCOPE
        AND A028ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);  

  EXCEPTION
    WHEN OTHERS THEN  
        ROLLBACK;

        codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                               NOMBRE_PAQUETE,
                                                               NOMBRE_PROCEDIMIENTO,
                                                               SQLCODE,
                                                               SQLERRM);

        p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
        p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

  END Pr_ListarMetodMDL;  

  PROCEDURE Pr_ListarActividadesReduc (p_A058TIPPROYCT IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058TIPPROYCT%TYPE,       
                                      p_idUsuario IN NUMBER,
                                      p_Respuesta OUT CURSOR_SALIDA,
                                      p_codError OUT NUMBER,
                                      p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarActividadesReduc';
    pFiltro              VARCHAR2(50);

  BEGIN

      OPEN p_Respuesta FOR SELECT A058CODIGO, A058DESCRIPCION FROM GPYT_T058_TIPO_ACTIV_REDUCCION
        WHERE A058TIPPROYCT = p_A058TIPPROYCT AND A058ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);    

  EXCEPTION
    WHEN OTHERS THEN  
        ROLLBACK;

        codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                               NOMBRE_PAQUETE,
                                                               NOMBRE_PROCEDIMIENTO,
                                                               SQLCODE,
                                                               SQLERRM);

        p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
        p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);

  END Pr_ListarActividadesReduc;


  /*****************************************************************/
  /* Desarrollados por Feernando Mondragon (2016.12.20)            */                        
  /*****************************************************************/

 ----****
  PROCEDURE Pr_ListarSectorIPCC(
      p_idUsuario IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarSectorIPCC';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarSectorIPCC ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A045CODIGO, A045NOMBRE
    FROM GPYT_T045_SECTOR_IPCC
    WHERE A045ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    --
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarSectorIPCC ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarSectorIPCC;
----****

  PROCEDURE Pr_ListarCategoriaIPCC(
      p_A046IDSUBGRUPOIPCC IN GPYT_T046_CATEGORIA_IPCC.A046IDSUBGRUPOIPCC%TYPE,
      p_idUsuario    IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarCategoriaIPCC';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarCategoriaIPCC ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A046CODIGO, A046NOMBRE, A046IDSUBGRUPOIPCC
    FROM GPYT_T046_CATEGORIA_IPCC
    WHERE A046IDSUBGRUPOIPCC  = p_A046IDSUBGRUPOIPCC
    AND A046ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    --
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarCategoriaIPCC ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarCategoriaIPCC;
----****
  PROCEDURE Pr_ListarSubCategoriaIPCC(
      p_A047IDCATIPCC IN GPYT_T047_SUBCATEGORIA_IPCC.A047IDCATIPCC%TYPE,
      p_idUsuario     IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarSubCategoríaIPCC';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarSubCategoríaIPCC ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A047CODIGO, A047NOMBRE, A047IDCATIPCC
    FROM GPYT_T047_SUBCATEGORIA_IPCC
    WHERE A047IDCATIPCC    = p_A047IDCATIPCC
    AND A047ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    --
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarSubCategoríaIPCC ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarSubCategoriaIPCC;
----****
  PROCEDURE Pr_ListarDesagregacionIPCC(
      p_A048IDSUBCATIPCC IN GPYT_T048_DESAGREGACATG_IPCC.A048IDSUBCATIPCC%TYPE,
      p_idUsuario        IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarDesagregacionIPCC';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarDesagregacionIPCC ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A048CODIGO, A048NOMBRE, A048IDSUBCATIPCC
    FROM GPYT_T048_DESAGREGACATG_IPCC
    WHERE A048IDSUBCATIPCC = p_A048IDSUBCATIPCC
    AND A048ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    --
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarDesagregacionIPCC ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarDesagregacionIPCC;
--****
 PROCEDURE Pr_ListarSubGrupoIPCC(
        p_A043IDSECTORIPCC IN GPYT_T043_Subgrupo_IPCC.A043IDSECTORIPCC%TYPE,
        p_idUsuario    IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarSubGrupoIPCC';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarSubGrupoIPCC ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A043CODIGO,A043NOMBRE,A043IDSECTORIPCC
    FROM GPYT_T043_SUBGRUPO_IPCC
    WHERE A043IDSECTORIPCC = p_A043IDSECTORIPCC 
    AND A043ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    --
    p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError := PK_UTL_UTILIDAD.fn_ObtenerMensaje(p_codError);
    --
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarSubGrupoIPCC ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarSubGrupoIPCC;
----****
--****

 --****
 PROCEDURE Pr_Listar_arbolPol_nvl_1(
      p_idUsuario IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Listar_arbolPol_nvl_1';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_Listar_arbolPol_nvl_1 ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT  A003NIVEL1, A003NOMNIVEL1
    FROM GPYT_T003_POLITICA
    WHERE A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_Listar_arbolPol_nvl_1 ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_Listar_arbolPol_nvl_1;
  ---***
 PROCEDURE Pr_Listar_arbolPol_nvl_2(
      p_A003NIVEL1 IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
      p_idUsuario   IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Listar_arbolPol_nvl_2';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_Listar_arbolPol_nvl_2');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A003NIVEL2, A003NOMNIVEL2
    FROM GPYT_T003_POLITICA
    WHERE A003NIVEL1  = p_A003NIVEL1
    AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_Listar_arbolPol_nvl_2');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_Listar_arbolPol_nvl_2;
   ---***
  PROCEDURE Pr_Listar_arbolPol_nvl_3(
      p_A003NIVEL2 IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
      p_idUsuario   IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Listar_arbolPol_nvl_3';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_Listar_arbolPol_nvl_3');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A003NIVEL3, A003NOMNIVEL3
    FROM GPYT_T003_POLITICA
    WHERE A003NIVEL2      = p_A003NIVEL2
    AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_Listar_arbolPol_nvl_3');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_Listar_arbolPol_nvl_3;
  ---***
  PROCEDURE Pr_Listar_arbolPol_nvl_4(
      p_A003NIVEL3 IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
      p_idUsuario  IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Listar_arbolPol_nvl_4';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_Listar_arbolPol_nvl_4');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A003NIVEL4, A003NOMNIVEL4
    FROM GPYT_T003_POLITICA
    WHERE A003NIVEL3   = p_A003NIVEL3
    AND A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_Listar_arbolPol_nvl_4');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_Listar_arbolPol_nvl_4;
  ---**
  ---****
 PROCEDURE Pr_ListarFuentesFinanciacion(
      p_idUsuario   IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarFuentesFinanciacion';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarFuentesFinanciacion ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A102CODIGO,
           A102CATEGORIA,
			A102VALOR
	FROM PART_T102_LISTA 
	WHERE A102ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO
	AND A102CATEGORIA = PK_UTL_CONSTANTE.COD_CAT_FNTSFINACIACION;
	p_codError                                      := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                      := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarFuentesFinanciacion ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarFuentesFinanciacion;
  ----****  
  PROCEDURE Pr_ListarInstrmntsFinanciacion(
      p_idUsuario   IN NUMBER,
      p_Respuesta OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarInstrmntsFinanciacion';
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarInstrmntsFinanciacion ');
    OPEN p_Respuesta FOR
    SELECT DISTINCT A102CODIGO,
           A102CATEGORIA,
			A102VALOR
	FROM PART_T102_LISTA 
	WHERE A102ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO
	AND A102CATEGORIA = PK_UTL_CONSTANTE.COD_CAT_INSTRMTSFINACIACION;
	p_codError                                      := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
    p_msjError                                      := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarInstrmntsFinanciacion ');
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
    p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
    p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
  END Pr_ListarInstrmntsFinanciacion;
  --***
PROCEDURE Pr_ListarPoliticas(
    p_idUsuario IN NUMBER,
    p_Respuesta OUT CURSOR_SALIDA,
    p_codError OUT NUMBER,
    p_msjError OUT VARCHAR2)
IS
  codExcepcion         NUMBER;
  NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarPoliticas';
BEGIN
  PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Entro a Pr_ListarPoliticas ');
  OPEN p_Respuesta FOR
  SELECT DISTINCT A003CODIGO,
    A003NIVEL1,
    A003NOMNIVEL1,
    A003NIVEL2,
    A003NOMNIVEL2,
    A003NIVEL3,
    A003NOMNIVEL3,
    A003NIVEL4,
    A003NOMNIVEL4,
    A003DESCRPCNPOLTC,
    A003IDARCHIV
  FROM GPYT_T003_POLITICA
  WHERE A003ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
  PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => 0, p_descripcion => 'Salio de Pr_ListarPoliticas ');
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;
  codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO, NOMBRE_PAQUETE, NOMBRE_PROCEDIMIENTO, SQLCODE, SQLERRM);
  p_codError   := PK_UTL_CONSTANTE.ERROR_GENERAL;
  p_msjError   := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
END Pr_ListarPoliticas;
--***
END PK_UTL_LISTADOS;
