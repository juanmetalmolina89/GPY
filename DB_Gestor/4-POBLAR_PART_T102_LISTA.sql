DELETE FROM PART_T102_LISTA;
-- Tipo de persona
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (1, 1, 'Persona Natural', 'PN', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (2, 1, 'Persona Juridica', 'PJ', 'A', 0);
-- Tipo de representante
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (3, 2, 'Representante Legal', 'RL', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (4, 2, 'Apoderado', 'AP', 'A', 0);
-- Tipo de persona juridica
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (5, 3, 'Persona Juridica Pública', 'JN', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (6, 3, 'Persona Juridica Privada', 'JP', 'A', 0);
-- Clase usuario
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (7, 4, 'Funcionario MADS', 'FM', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (8, 4, 'Administrador Autoridad Ambiental', 'AA', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (9, 4, 'Gestor del Proyecto', 'GP', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (10, 4, 'Publicador', 'PB', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (11, 4, 'Invitado', 'IV', 'A', 0);
-- Tipo proyecto
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (12, 5, 'Acciones de Mitigación Nacionalmente Apropiadas', 'NAMA', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (13, 5, 'Proyectos de Desarrollo Bajo en Carbono y Resilientes al Clima', 'PBDBCRC', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (14, 5, 'Mecanismo de Desarrollo Limpio', 'MDL', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (15, 5, 'Project of Activity - MDL', 'MDL-POA', 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (16, 5, 'Component Project Activity', 'CPA', 'A', 0);
-- Alcance
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (17, 6, 'Una política, programa o meta nacional', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (18, 6, 'Una política, programa o meta regional', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (19, 6, 'Una política, programa o meta sectorial', NULL, 'A', 0);
-- Ubicacion
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (20, 7, 'Local', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (21, 7, 'Regional', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (22, 7, 'Nacional', NULL, 'A', 0);
-- Estado proyecto
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (23, 8, 'En Proceso', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (24, 8, 'Pendiente de aprobación', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (25, 8, 'Aprobado', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (26, 8, 'Rechazado', NULL, 'A', 0);

-- Tipo de Proyecto MDL
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (30, 9, 'Fuente', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (31, 9, 'Sumidero', NULL, 'A', 0);

-- Sectoral / Scope (aplica solo para MDL y MDLPoA)
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (32, 10, 'Industrias de la energia (fuentes renovables y no renovables)', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (33, 10, 'Distribucion de energía', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (34, 10, 'Demanda de energia', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (35, 10, 'Industrias manufactureras', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (36, 10, 'Industrias quimicas', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (37, 10, 'Construccion', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (38, 10, 'Transporte', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (39, 10, 'Produccion de minerales/Mineria', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (40, 10, 'Produccion de metales', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (41, 10, 'Emisiones fugitivas de combustibles (solidos, petroleo y gas)', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (42, 10, 'Emisiones fugitivas de la producción y consumo de halocarbonos y hexafluoruros de azufre', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (43, 10, 'Uso de solventes', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (44, 10, 'Manejo y disposicion de residuos', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (45, 10, 'Aforestación y reforestacion', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (46, 10, 'Agricultura', NULL, 'A', 0);

-- ESCALA
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (47, 11, 'Pequeña escala', NULL, 'A', 0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES (48, 11, 'Gran escala', NULL, 'A', 0);

-- TIPO FUENTE FINANCIACION
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (49,12,'Nacionales publicas', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (50,12,'Nacionales privadas', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (51,12,'Internacionales Publicas', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (52,12,'Internacionales Privadas', NULL, 'A',0);

-- TIPO INSTRUMENTO FINANCIACION
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (53,13,'Préstamo con fuentes de recursos públicos nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (54,13,'Préstamo con fuentes de recursos públicos internacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (55,13,'Préstamo con fuentes de recursos privados nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (56,13,'Préstamo con fuentes de recursos privados internacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (57,13,'Inversión (Equity) con fuentes de recursos públicos nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (58,13,'Inversión (Equity) con fuentes de recursos públicos internacionales ',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (59,13,'Inversión (Equity) con fuentes de recursos privados nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (60,13,'Inversión (Equity) con fuentes de recursos privados internacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (61,13,'Donación con fuentes de recursos públicos nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (62,13,'Donación con fuentes de recursos públicos internacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (63,13,'Donación con fuentes de recursos privados nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (64,13,'Donación con fuentes de recursos privados internacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (65,13,'Garantías con fuentes de recursos públicos nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (66,13,'Garantías con fuentes de recursos públicos internacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (67,13,'Garantías con fuentes de recursos privados nacionales',null,'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (68,13,'Garantías con fuentes de recursos privados internacionales',null,'A',0);
-- ESTADOS PROCESO VALIDACION
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (69,14,'En Procso', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (70,14,'Finalizada', NULL, 'A',0);
-- TIPOS DE PERIODOS DE ACREDITACION 
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (71,15,'7 años - hasta 2 veces renovable', NULL, 'A', 0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (72,15,'10 años - sin posibilidad de renovación', NULL, 'A', 0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (73,15,'20 años - hasta 2 veces renovable', NULL, 'A', 0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (74,15,'30 años - sin posibilidad de renovación', NULL, 'A',0);
-- TIPO INDICADOR
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (75,16, 'Indicador de impacto GEI', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (76,16, 'Indicador de impacto No GEI', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (77,16, 'Indicador de resultados intermedios', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (78,16, 'Indicador de Gestión', NULL, 'A',0);
-- TIPO DE META
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (79,17, 'Reducción de emisiones de GEI', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (80,17, 'Co-beneficios em Adaptación', NULL, 'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (81,17, 'Otros Co-beneficios', NULL, 'A',0);

-- RUTA ADJUNTOS
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (82,18, 'C:\GPY\Adjuntos', NULL, 'A',0);
-- RUTA SUMIDEROS
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (83,19, 'C:\GPY\Archivos', NULL, 'A',0);
-- TIEMPO SESION
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (84,20, '10', NULL, 'A',0);
-- IDENTIFICADOR SISTEMA GESTOR
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (85,21, '1','GESTOR', 'A',0);
-- IDENTIFICADOR MODULO 1 (FUENTES)
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (86,22, '1', 'Fuente', 'A',0);
-- IDENTIFICADOR MODULO 2 (SUMIDEROS)
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (87,22, '2', 'Sumidero',  'A',0);
-- ESTANDAR DEL MERCADO VOLUNTARIO DEL CARBONO
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (88,23, 'Verified Carbon Standard', 'VCS',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (89,23, 'Gold Standard', 'GS',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (90,23, 'Gold Standard LUF', 'GSL',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (91,23, 'Plan Vivo', 'PVIVO',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (92,23, 'Climate Action Reserve', 'CAR',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (93,23, 'Climate, Community and Biodiversity Standards', 'CCBS',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (94,23, 'American Carbon Registry', 'ACR',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (95,23, 'ISO-14064/65', 'ISO14064',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (96,23, 'SOCIAL CARBON', 'SC',  'A',0);
Insert into PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) values (97,23, 'ICONTEC', 'ICONTEC',  'A',0);
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('99', '8', 'Solicitada Aprobación MDL1', 'SolMDL1', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('100', '8', 'Aprobada Aprobación MDL1', 'AprMDL1', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('101', '8', 'Devuelta MDL1', 'DevMDL1', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('102', '8', 'Solicitada Aprobación MDL3', 'SolMDL3', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('103', '8', 'Aprobada Aprobacion MDL3', 'AprMDL3', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('104', '8', 'Devuelta MDL3', 'DevMDL3', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('107', '8', 'Solicitada Aprobación prerregistro', 'SolReg', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('108', '8', 'Solicitada Aprobación proyecto', 'SolPro', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('109', '8', 'Proyecto aprobado', 'AprPro', 'A', '0');
INSERT INTO PART_T102_LISTA (A102CODIGO, A102CATEGORIA, A102VALOR, A102VALORCORTO, A102ESTADOREGISTRO, A102USUARIOCREACION) VALUES ('110', '8', 'Proyecto no aprobado', 'DevPro', 'A', '0');
COMMIT;