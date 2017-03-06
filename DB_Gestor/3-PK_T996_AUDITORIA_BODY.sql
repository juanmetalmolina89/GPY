create or replace package body PK_T996_AUDITORIA is

  /********************************************************************************
  DESCRIPCION    : Procedimiento basico que permite realizar la inserciOn del
                   registro en la tabla T996_AUDITORIA
  PARAMETROS    :
  IN    :
                        p_A996IDOBJETO      Id del objeto afectado
                        p_A996OBJETO        Nombre de la tabla afectada
                        p_A996OPERACION     Operacion realizada : ELIMINAR, INSERTAR, ACTUALIZAR
                        p_A996USUARIO       Id del usuario que realiza operacion
                        p_A996PROCEDIMIENTO Procedimiento que realizo operacion
                        p_A996PAQUETE       Paquete donde esta procedimiento
  
  OUT    :
          p_A996CODIGO Id del registro creado en auditoria
  
  REALIZADO POR    : Hugo Armando Cendales Prieto
  FECHA CREACION    : 5/OCT/2016
  
  FECHA MODIFICA      :  dd/MMM/aaaa
  MODIFICADO POR      :
  DESCRIPCION CAMBIOS :
  *******************************************************************************/
  PROCEDURE Pr_Insertar(p_A996IDOBJETO      IN SIST_T996_AUDITORIA.A996IDOBJETO%TYPE,
                        p_A996OBJETO        IN SIST_T996_AUDITORIA.A996OBJETO%TYPE,
                        p_A996OPERACION     IN SIST_T996_AUDITORIA.A996OPERACION%TYPE,
                        p_A996USUARIO       IN SIST_T996_AUDITORIA.A996USUARIO%TYPE,
                        p_A996PROCEDIMIENTO IN SIST_T996_AUDITORIA.A996PROCEDIMIento%TYPE,
                        p_A996PAQUETE       IN SIST_T996_AUDITORIA.A996PAQUETE%TYPE,
                        p_A996CODIGO        OUT SIST_T996_AUDITORIA.A996CODIGO%TYPE) IS
  
  BEGIN
  
    p_A996CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T996_AUDITORIA_SEQ');
  
    INSERT INTO SIST_T996_AUDITORIA
      (A996CODIGO,
       A996FECHA,
       A996IDOBJETO,
       A996OBJETO,
       A996OPERACION,
       A996USUARIO,
       A996PROCEDIMIENTO,
       A996PAQUETE)
    VALUES
      (P_A996CODIGO,
       SYSDATE,
       P_A996IDOBJETO,
       P_A996OBJETO,
       P_A996OPERACION,
       P_A996USUARIO,
       P_A996PROCEDIMIENTO,
       P_A996PAQUETE);
  
  END Pr_Insertar;

end PK_T996_AUDITORIA;