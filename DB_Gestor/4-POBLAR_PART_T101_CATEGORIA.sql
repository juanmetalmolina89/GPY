DELETE FROM PART_T102_LISTA;
DELETE FROM PART_T101_CATEGORIA;

-- TIPO PERSONA
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (1, 'TIPOPERSONA','A', 0);
-- TIPO REPRESENTANTE LEGAL
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (2, 'TIPOREPRESENTANTE','A', 0);
-- TIPO PERSONA JURIDICA
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (3, 'TIPOPERSJURIDICA','A', 0);
-- CLASE DE USUARIO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (4, 'CLASEUSUARIO','A', 0);
-- TIPO DE PROYECTO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (5, 'TIPOPROYECTO','A', 0);
-- ALCANCE
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (6, 'ALCANCE','A', 0);
-- UBICACION DEL PROYECTO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (7, 'UBICACION','A', 0);
-- ESTASO DEL PROYECTO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (8, 'ESTADOPROYECTO','A', 0);
-- Categoria de mitigacion
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (9, 'TIPOPROYECTOMDL','A', 0);
-- Sectoral / Scope, solo aplica para MDL y MDLPoA
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (10, 'SECTORAL','A', 0);
-- Escala
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (11, 'ESCALA','A', 0);
-- FUENTE FINANCIACION
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (12, 'TIPOFUENTEFIN','A', 0);
-- TIPO INSTRUMENTO FINANCIACION
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (13, 'TIPOINSTRUFINAN','A', 0);
-- ESTADO PROCESO VALIDA 
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (14, 'ESTADOPROCSVALIDA','A', 0);
-- TIPO PERIODO ACREDITA
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (15, 'TIPOPERIODOACREDITA','A', 0);
-- TIPO INDICADOR
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (16, 'TIPOINDICADOR','A', 0);
-- TIPO META
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (17, 'TIPOMETA','A', 0);
-- RUTA ADJUNTO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (18, 'RUTAADJUNTO','A', 0);
-- RUTA ARCHIVO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (19, 'RUTAARCHIVO','A', 0);
-- TIEMPO SESION
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (20, 'TIEMPOSESION','A', 0);
-- ID SISTEMA
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (21, 'IDSISTEMA','A', 0);
-- ID MODULO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (22, 'IDMODULO','A', 0);
-- ID CATEGORUA DEL ESTANDAR VOLUNTARIO DEL CARBONO
INSERT INTO PART_T101_CATEGORIA (A101CODIGO, A101NOMBRE, A101ESTADOREGISTRO, A101USUARIOCREACION) VALUES (23, 'STANDARMRCDOVOL','A', 0);

COMMIT;