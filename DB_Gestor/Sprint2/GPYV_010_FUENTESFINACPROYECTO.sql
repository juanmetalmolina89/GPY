--------------------------------------------------------
-- Archivo creado  - viernes-febrero-03-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View GPYV_010_FUENTESFINACPROYECTO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "GPYV_010_FUENTESFINACPROYECTO" ("A004CODIGO", "A002CODIGO", "A002NOMBRPROYCT", "A102CODIGO", "A102VALOR", "A004ESTADOREGISTRO") AS 
  SELECT PF.A004CODIGO,
         PR.A002CODIGO,
         PR.A002NOMBRPROYCT,
         LST.A102CODIGO,
         LST.A102VALOR,
         PF.A004ESTADOREGISTRO
  FROM GPYT_T004_PROY_FTE_FINANC PF        
  LEFT JOIN PART_T102_LISTA LST 
  ON PF.A004IDFUNTFINNCCN = LST.A102CODIGO                                    
  LEFT JOIN GPYT_T002_PROYECTO PR
  ON PR.A002CODIGO = PF.A004IDPROYECTO
  ORDER BY LST.A102VALOR DESC;

