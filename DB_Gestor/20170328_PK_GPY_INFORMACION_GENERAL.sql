create or replace PACKAGE          "PK_GPY_INFORMACION_GENERAL" 
IS
  /*******************************************************************************
  DESCRIPCION       : Paquete encargado de la administración funcional del
                    : pre registro de control de registro de informacion general del proyecto.
  REALIZADO POR     : Fernando Mondragón Amaya
  FECHA CREACION    : 03/03/2017
  FECHA MODIFICA    : 03/03/2017
  MODIFICADO POR    :
  DESCRIPCION CAMBIO:
  *********************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_INFORMACION_GENERAL';
  TYPE CURSOR_SALIDA IS REF CURSOR;
  ----
    PROCEDURE Pr_RegistrarInfoProyect(
        p_A013FECHREPRT            IN GPYT_T013_Avance_Proyecto.A013FECHREPRT%TYPE,
        p_A013CAMBSIGNFCTV         IN GPYT_T013_Avance_Proyecto.A013CAMBSIGNFCTV%TYPE,
        p_A013COSTTONLD            IN GPYT_T013_Avance_Proyecto.A013COSTTONLD%TYPE,
        p_A013FINANCCN             IN GPYT_T013_Avance_Proyecto.A013FINANCCN%TYPE,
        p_A013FECHAVNCPROYCT       IN GPYT_T013_Avance_Proyecto.A013FECHAVNCPROYCT%TYPE,
        p_A013OPTAPAGORESULTADOS   IN GPYT_T013_Avance_Proyecto.A013OPTAPAGORESULTADOS%TYPE,
        p_A013IDPROYECTO           IN GPYT_T013_Avance_Proyecto.A013IDPROYECTO%TYPE,
        p_A013EMISREDCXVERIFICAR   IN GPYT_T013_Avance_Proyecto.A013EMISREDCXVERIFICAR%TYPE,
        p_A013EMISREDCVERIFICADAS  IN GPYT_T013_Avance_Proyecto.A013EMISREDCVERIFICADAS%TYPE,
        p_A013EMISREDCDISPNTRANSAR IN GPYT_T013_Avance_Proyecto.A013EMISREDCDISPNTRANSAR%TYPE,
        p_A013EMISREDCTRANSADAS    IN GPYT_T013_Avance_Proyecto.A013EMISREDCTRANSADAS%TYPE,
        p_A013IDARCHV              IN GPYT_T013_Avance_Proyecto.A013IDARCHV%TYPE,
        p_A013NROCPAS              IN GPYT_T013_Avance_Proyecto.A013NROCPAS%TYPE,
        p_A013HAYNUEVOCPA          IN GPYT_T013_Avance_Proyecto.A013HAYNUEVOCPA%TYPE,
        p_idUsuario                IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
	---	
	PROCEDURE Pr_ActualizarInfoProyect(
        p_A013CODIGO               IN GPYT_T013_Avance_Proyecto. A013CODIGO%TYPE,
        p_A013FECHREPRT            IN GPYT_T013_Avance_Proyecto.A013FECHREPRT%TYPE,
        p_A013CAMBSIGNFCTV         IN GPYT_T013_Avance_Proyecto.A013CAMBSIGNFCTV%TYPE,
        p_A013COSTTONLD            IN GPYT_T013_Avance_Proyecto.A013COSTTONLD%TYPE,
        p_A013FINANCCN             IN GPYT_T013_Avance_Proyecto.A013FINANCCN%TYPE,
        p_A013FECHAVNCPROYCT       IN GPYT_T013_Avance_Proyecto.A013FECHAVNCPROYCT%TYPE,
        p_A013OPTAPAGORESULTADOS   IN GPYT_T013_Avance_Proyecto.A013OPTAPAGORESULTADOS%TYPE,
        p_A013IDPROYECTO           IN GPYT_T013_Avance_Proyecto.A013IDPROYECTO%TYPE,
        p_A013EMISREDCXVERIFICAR   IN GPYT_T013_Avance_Proyecto.A013EMISREDCXVERIFICAR%TYPE,
        p_A013EMISREDCVERIFICADAS  IN GPYT_T013_Avance_Proyecto.A013EMISREDCVERIFICADAS%TYPE,
        p_A013EMISREDCDISPNTRANSAR IN GPYT_T013_Avance_Proyecto.A013EMISREDCDISPNTRANSAR%TYPE,
        p_A013EMISREDCTRANSADAS    IN GPYT_T013_Avance_Proyecto.A013EMISREDCTRANSADAS%TYPE,
        p_A013IDARCHV              IN GPYT_T013_Avance_Proyecto.A013IDARCHV%TYPE,
        p_A013NROCPAS              IN GPYT_T013_Avance_Proyecto.A013NROCPAS%TYPE,
        p_A013HAYNUEVOCPA          IN GPYT_T013_Avance_Proyecto.A013HAYNUEVOCPA%TYPE,
        p_idUsuario                IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
	---	
	PROCEDURE Pr_ConsultarInfoProyect(      
        p_A013IDPROYECTO           IN GPYT_T013_Avance_Proyecto.A013IDPROYECTO%TYPE,      
        p_idUsuario                IN NUMBER,
        p_resultado OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);	
 
  END PK_GPY_INFORMACION_GENERAL;
  /************************************************************************
  FIN creación del HEADER del package PK_GPY_INFORMACION_GENERAL
  ************************************************************************/