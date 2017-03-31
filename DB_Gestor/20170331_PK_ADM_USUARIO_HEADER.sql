create or replace package PK_ADM_USUARIO is
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
                      para la administraci�n de usuarios
  
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 04/11/2016
  
  FECHA MODIFICA    : 09/11/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Manejo de excepciones
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_ADM_USUARIO';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_ConsultarUsuario (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                                 p_IdUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT NUMBER,
                                 p_msjError OUT VARCHAR2);                              
                                 
   procedure Pr_ListarUsuario (p_IdUsuario IN NUMBER,   
                               p_Respuesta OUT CURSOR_SALIDA,
                               p_codError OUT NUMBER,
                               p_msjError OUT VARCHAR2);     
                            
  procedure Pr_RegistrarUsuario (p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
                                 p_A052APELLIDO IN GPYT_T052_PERSONA.A052APELLIDO%TYPE, 
                                 p_A052IDTIPPERSN IN GPYT_T052_PERSONA.A052IDTIPPERSN%TYPE,
                                 p_A052TIPDOCMNT IN GPYT_T052_PERSONA.A052TIPDOCMNT%TYPE,
                                 p_A052NUMRDOCMNT IN GPYT_T052_PERSONA.A052NUMRDOCMNT%TYPE,
                                 p_A052DIGTCHQU IN GPYT_T052_PERSONA.A052DIGTCHQU%TYPE,
                                 p_A052IDENTIDAD IN GPYT_T052_PERSONA.A052IDENTIDAD%TYPE,
                                 p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                                 p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                                 p_IdUsuario IN NUMBER,
                                 p_Respuesta OUT CURSOR_SALIDA,
                                 p_codError OUT number,
                                 p_msjError OUT varchar2);	
			         
  procedure Pr_EliminarUsuario (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
			                    p_IdUsuario IN NUMBER,
			                    p_Respuesta OUT CURSOR_SALIDA,                                
			                    p_codError OUT number,
			                    p_msjError OUT varchar2);			
                                
  procedure Pr_ValidarUsuario (p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                               p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                               p_IdUsuario IN NUMBER,
                               p_Respuesta OUT CURSOR_SALIDA,
                               p_codError OUT number,
                               p_msjError OUT varchar2);		        
                         
  procedure Pr_CambiarContrasena (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                                  p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                                  p_A041CLAVEANT IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                                  p_A041CLAVENUEVA IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                                  p_IdUsuario IN NUMBER,       
                                  p_Respuesta OUT CURSOR_SALIDA,                                    
                                  p_codError OUT number,
                                  p_msjError OUT varchar2);	
  PROCEDURE Pr_ConsultarUsrPrUsname(
        p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
        p_IdUsuario  IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
    --- 
  PROCEDURE Pr_ConsultarUsrsEntidad(
        p_A001SIGLA IN GPYT_T001_ENTIDAD.A001SIGLA%TYPE,
        p_IdUsuario  IN NUMBER,
        p_Respuesta OUT CURSOR_SALIDA,
        p_codError OUT NUMBER,
        p_msjError OUT VARCHAR2);
                                  

end PK_ADM_USUARIO;
