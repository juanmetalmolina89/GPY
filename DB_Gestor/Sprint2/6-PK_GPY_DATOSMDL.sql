create or replace package PK_GPY_DATOSMDL is

  /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
                      para la registrar la los dartos de las etapas MDL y MDLPoA

  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 24/12/2016

  FECHA MODIFICA    : 18/01/2017
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Incluir los metodos de actualizacion
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_DATOSMDL';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  -- Lista la especificacion de los archivos adjuntos que se piden por pantalla y por tipo de proyecto
  PROCEDURE Pr_ListarAdjuntos (p_A002TIPPROYCT IN GPYT_T002_PROYECTO.A002TIPPROYCT%TYPE,
                               p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,
                               p_idUsuario IN NUMBER,
			       p_Respuesta OUT CURSOR_SALIDA,
                               p_codError OUT NUMBER,
                               p_msjError OUT VARCHAR2);  
  
  -- Registrar la Consideracion Temprana
  PROCEDURE Pr_RegistrarConsiderac (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                    p_A002NOMBRPROYCTINGLS IN GPYT_T002_PROYECTO.A002NOMBRPROYCTINGLS%TYPE,
                                    p_A002IDSECTORALSCOPE IN GPYT_T002_PROYECTO.A002IDSECTORALSCOPE%TYPE,
                                    p_A002TECNLGCONTMPLD IN GPYT_T002_PROYECTO.A002TECNLGCONTMPLD%TYPE,                                    
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);                                                                                                             	
                                 
  PROCEDURE Pr_ConsultarConsiderac (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,                                    
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);        

  PROCEDURE Pr_ActualizarConsiderac (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                     p_A002NOMBRPROYCTINGLS IN GPYT_T002_PROYECTO.A002NOMBRPROYCTINGLS%TYPE,
                                     p_A002IDSECTORALSCOPE IN GPYT_T002_PROYECTO.A002IDSECTORALSCOPE%TYPE,
                                     p_A002TECNLGCONTMPLD IN GPYT_T002_PROYECTO.A002TECNLGCONTMPLD%TYPE,                                    
                                     p_idUsuario IN NUMBER,
                                     p_Respuesta OUT CURSOR_SALIDA,
                                     p_codError OUT NUMBER,
                                     p_msjError OUT VARCHAR2);    
                                    
  -- Registrar los datos de la Carta de No Objecion                                    
  PROCEDURE Pr_RegistrarCartaNObj (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,     
                                   p_A002IDESCALA IN GPYT_T002_PROYECTO.A002IDESCALA%TYPE,
                                   p_A002IDMETDLGMDL IN GPYT_T002_PROYECTO.A002IDMETDLGMDL%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2);    
                                      
  PROCEDURE Pr_ConsultarCartaNObj (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,     
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2); 
                                                                       
  PROCEDURE Pr_ActualizarCartaNObj (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,     
                                    p_A002IDESCALA IN GPYT_T002_PROYECTO.A002IDESCALA%TYPE,
                                    p_A002IDMETDLGMDL IN GPYT_T002_PROYECTO.A002IDMETDLGMDL%TYPE,
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);                                                                        
                                                                       
  PROCEDURE Pr_RegistrarAdjunto (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                 p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                                 p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                                 p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                 p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                 p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE, 
                                 p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,         
                                 p_idUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2);                                     
                                                                          
  PROCEDURE Pr_ConsultarAdjuntos (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                  p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,
                                  p_idUsuario IN NUMBER,
			          p_Respuesta OUT CURSOR_SALIDA,
			          p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2);           
                                  
  PROCEDURE Pr_ConsultarAdjuntoPorId (p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                                      p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                      p_idUsuario IN NUMBER,
			              p_Respuesta OUT CURSOR_SALIDA,
			              p_codError OUT NUMBER,
                                      p_msjError OUT VARCHAR2);                                     
                                  
/*  PROCEDURE Pr_ActualizarAdjunto (p_A025CODIGO IN GPYT_T025_ADJUNTO.A025CODIGO%TYPE,
                                  p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                  p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                                  p_A008NUMRRADCD IN GPYT_T008_PROY_ADJUNTO.A008NUMRRADCD%TYPE,
                                  p_A026DESCRPCNARCHIV IN GPYT_T026_ARCHIVO.A026DESCRPCNARCHIV%TYPE,
                                  p_A026NOMARCHIVO IN GPYT_T026_ARCHIVO.A026NOMARCHIVO%TYPE,
                                  p_A026HASHARCHIVO IN GPYT_T026_ARCHIVO.A026HASHARCHIVO%TYPE, 
                                  p_A008FECHADJNT IN GPYT_T008_PROY_ADJUNTO.A008FECHADJNT%TYPE,         
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2);                                     
 */ 
end PK_GPY_DATOSMDL;