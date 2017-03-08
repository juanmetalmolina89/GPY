--------------------------------------------------------
-- Archivo creado  - domingo-febrero-26-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View GPYV_006_PROYECTOS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "GESTOR"."GPYV_006_PROYECTOS" ("A001CODIGO", "A001SIGLA", "A002CODIGO", "A001NOMBRE", "TIPOPROYECTO", "A002TIPPROYCT", "A002DESCRPCINPROYCT", "IDESTADOPROYECTO", "ESTADOPROYECTO", "A002IDUSR", "A055IDPUBLICADOR", "A002ESTADOREGISTRO", "A002FECHACREACION") AS 
  SELECT A001CODIGO,
    A001SIGLA, 
    A002CODIGO,
    A001NOMBRE,
    L1.A102VALORCORTO TIPOPROYECTO,
    A002TIPPROYCT,
    A002DESCRPCINPROYCT,
	L2.A102CODIGO IDESTADOPROYECTO,
    L2.A102VALOR ESTADOPROYECTO,
    A002IDUSR,
    A002IDUSR A055IDPUBLICADOR,
    A002ESTADOREGISTRO,
    A002FECHACREACION
  FROM GPYT_T002_PROYECTO,
    PART_T102_LISTA L1,
    GPYT_T041_USUARIO,
    PART_T102_LISTA L2,
    GPYT_T052_PERSONA
  LEFT JOIN GPYT_T001_ENTIDAD
  ON A001CODIGO       = A052IDENTIDAD
  WHERE A041IDPERSONA = A052CODIGO
  AND A002IDUSR       = A041CODIGO
  AND L1.A102CODIGO   = A002TIPPROYCT -- tipo de proyecto
  AND L2.A102CODIGO   = A002ESTADOPROYECTO
  UNION
  SELECT A001CODIGO,
    A001SIGLA,
    A002CODIGO,
    A001NOMBRE,
    L1.A102VALORCORTO TIPOPROYECTO,
    A002TIPPROYCT,
    A002DESCRPCINPROYCT,
	L2.A102CODIGO IDESTADOPROYECTO,
    L2.A102VALOR ESTADOPROYECTO,
    A002IDUSR,
    A055IDPUBLICADOR,
    A002ESTADOREGISTRO,
    A002FECHACREACION
  FROM GPYT_T002_PROYECTO,
    PART_T102_LISTA L1,
    GPYT_T041_USUARIO,
    PART_T102_LISTA L2,
    GPYT_T055_PUBLICADOR,
    GPYT_T052_PERSONA
  LEFT JOIN GPYT_T001_ENTIDAD
  ON A001CODIGO       = A052IDENTIDAD
  WHERE A041IDPERSONA = A052CODIGO
  AND A002IDUSR       = A041CODIGO
  AND L1.A102CODIGO   = A002TIPPROYCT -- tipo de proyecto
  AND L2.A102CODIGO   = A002ESTADOPROYECTO
  AND A041IDPERSONA   = A055IDPUBLICADOR