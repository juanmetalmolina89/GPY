--------------------------------------------------------
-- Archivo creado  - domingo-febrero-19-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PK_UTL_LISTADOS
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "GESTOR"."PK_UTL_LISTADOS" 
IS
  /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
  para la generaciï¿½n de listados
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 09/11/2016
  FECHA MODIFICA    : 25/11/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Se generaliza el procedimiento por Catagorias
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_UTL_LISTADOS';
TYPE CURSOR_SALIDA
IS
  REF
  CURSOR;
    PROCEDURE Pr_ListarAutoridades(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarParametricas(
        p_Categoria IN VARCHAR2,
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarSectorImplementador(
        p_A023IDTIPPROYCT IN GPYT_T023_SECTOR_IMPLEMENTADOR.A023IDTIPPROYCT%TYPE,
        p_idUsuario       IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarPaises(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarDepartamentos(
        p_A020CODPAIS IN GPYT_T020_DIVIPOLA.A020CODPAIS%TYPE,
        p_idUsuario   IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarMunicipios(
        p_A020CODDEPARTAMENTO IN GPYT_T020_DIVIPOLA.A020CODDEPARTAMENTO%TYPE,
        p_idUsuario           IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarCodigoCIIU(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarTipoDocumento(
        p_TipoPersona IN NUMBER,
        p_idUsuario   IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    /*procedure Pr_ListarTipoActividad (p_A022IDTIPPROYCT IN NUMBER,
    p_A022IDTIPPROYCTMDL IN NUMBER,
    p_idUsuario IN NUMBER,
    p_Respuesta OUT CURSOR_SALIDA,
    p_codError OUT NUMBER,
    p_msjError OUT VARCHAR2);   */
    PROCEDURE Pr_ListarTipoActividad(
        p_A022IDTIPPROYCT IN GPYT_T022_TIPO_ACTIVIDAD.A022IDTIPPROYCT%TYPE,
        p_idUsuario       IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarMetodMDL(
        p_A028IDESCL          IN GPYT_T028_METODOLOGIA_MDL.A028IDESCL%TYPE,
        p_A028IDSECTORALSCOPE IN GPYT_T028_METODOLOGIA_MDL.A028IDSECTORALSCOPE%TYPE,
        p_idUsuario           IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarActividadesReduc(
        p_A058TIPPROYCT IN GPYT_T058_TIPO_ACTIV_REDUCCION.A058TIPPROYCT%TYPE,
        p_idUsuario     IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    FUNCTION Fn_TraerCodigo(
        p_VALOR IN VARCHAR2)
      RETURN NUMBER;
    /*****************************************************************/
    /* Desarrollados por Feernando Mondragon (2016.12.20)            */
    /*****************************************************************/
    PROCEDURE Pr_ListarSectorIPCC(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarCategoriaIPCC(
        p_A046IDSUBGRUPOIPCC IN GPYT_T046_CATEGORIA_IPCC.A046IDSUBGRUPOIPCC%TYPE,
        p_idUsuario          IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarSubCategoriaIPCC(
        p_A047IDCATIPCC IN GPYT_T047_SUBCATEGORIA_IPCC.A047IDCATIPCC%TYPE,
        p_idUsuario     IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarDesagregacionIPCC(
        p_A048IDSUBCATIPCC IN GPYT_T048_DESAGREGACATG_IPCC.A048IDSUBCATIPCC%TYPE,
        p_idUsuario        IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_ListarSubGrupoIPCC(
        p_A043IDSECTORIPCC IN GPYT_T043_Subgrupo_IPCC.A043IDSECTORIPCC%TYPE,
        p_idUsuario        IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    PROCEDURE Pr_Listar_arbolPol_nvl_1(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    --**
    PROCEDURE Pr_Listar_arbolPol_nvl_2(
        p_A003NIVEL1 IN GPYT_T003_POLITICA.A003NIVEL1%TYPE,
        p_idUsuario  IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    --**
    PROCEDURE Pr_Listar_arbolPol_nvl_3(
        p_A003NIVEL2 IN GPYT_T003_POLITICA.A003NIVEL2%TYPE,
        p_idUsuario  IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    --**
    PROCEDURE Pr_Listar_arbolPol_nvl_4(
        p_A003NIVEL3 IN GPYT_T003_POLITICA.A003NIVEL3%TYPE,
        p_idUsuario  IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ---**
    PROCEDURE Pr_ListarFuentesFinanciacion(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ---** 
    PROCEDURE Pr_ListarInstrmntsFinanciacion(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    ---***
    PROCEDURE Pr_ListarPoliticas(
        p_idUsuario IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    --**
  END PK_UTL_LISTADOS;