CREATE OR REPLACE package PK_T041_USUARIO is

 /********************************************************************************  
  DESCRIPCION       : Contiene los servicios CRUD sobre la tabla PK_T041_USUARIO
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 10/11/2016
  FECHA MODIFICA    : 06/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Ajustes
 *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_T041_USUARIO';

  TYPE CURSOR_SALIDA IS REF CURSOR;

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                         p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                         p_A041PRIMRINGRS IN GPYT_T041_USUARIO.A041PRIMRINGRS%TYPE,
                         p_A041IDPERSONA IN GPYT_T041_USUARIO.A041IDPERSONA%TYPE,
                         p_A041IDCLASUSR IN GPYT_T041_USUARIO.A041IDCLASUSR%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			             p_msjError OUT VARCHAR2);

  PROCEDURE Pr_Eliminar (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                         p_idUsuario IN NUMBER,  
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			             p_msjError OUT VARCHAR2);
  
  PROCEDURE Pr_Actualizar (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                           p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                           p_A041PRIMRINGRS IN GPYT_T041_USUARIO.A041PRIMRINGRS%TYPE,
                           p_A041IDPERSONA IN GPYT_T041_USUARIO.A041IDPERSONA%TYPE,
                           p_A041IDCLASUSR IN GPYT_T041_USUARIO.A041IDCLASUSR%TYPE,
                           p_idUsuario IN NUMBER,
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
			               p_msjError OUT VARCHAR2);	
                           
   PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                    p_idUsuario IN NUMBER,  
                                    p_resultado OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2);
                                    
  end PK_T041_USUARIO; 