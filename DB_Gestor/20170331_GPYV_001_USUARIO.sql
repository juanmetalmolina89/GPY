CREATE OR REPLACE FORCE VIEW "GPYV_001_USUARIO" ("A041CODIGO", "A052NOMBRE", "A052APELLIDO", "A052TIPDOCMNT", "A015DESCRPCNTIPDOCMNT", "A052NUMRDOCMNT", "A052DIGTCHQU", "A001CODIGO", "A001NOMBRE", "A001SIGLA", "A041USERNAME", "A041ESTADOREGISTRO", "A052CODIGO", "A041IDCLASUSR", "A041PRIMRINGRS", "A041CLAVE", "A052CORRELCTRNC") AS 
  SELECT A041CODIGO, NVL(A052NOMBRE, ' ') A052NOMBRE, A052APELLIDO, A052TIPDOCMNT, A015DESCRPCNTIPDOCMNT, A052NUMRDOCMNT, A052DIGTCHQU, A001CODIGO, A001NOMBRE, A001SIGLA,A041USERNAME, A041ESTADOREGISTRO, A052CODIGO, A041IDCLASUSR, A041PRIMRINGRS, A041CLAVE, A052CORRELCTRNC
FROM GPYT_T041_USUARIO, GPYT_T015_TIPO_DOCUMENTO, GPYT_T052_PERSONA
LEFT JOIN GPYT_T001_ENTIDAD ON A052IDENTIDAD = A001CODIGO 
WHERE A041IDPERSONA = A052CODIGO  
AND A015CODIGO = A052TIPDOCMNT;
