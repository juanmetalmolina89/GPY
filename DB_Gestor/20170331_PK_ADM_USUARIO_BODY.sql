create or replace package body PK_ADM_USUARIO is
PROCEDURE Pr_ConsultarUsuario (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                               p_IdUsuario IN NUMBER,
                               p_Respuesta OUT CURSOR_SALIDA,
                               p_codError OUT NUMBER,
                               p_msjError OUT VARCHAR2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarUsuario';
    codExcepcion         NUMBER;

    BEGIN
       IF p_A041CODIGO IS NULL THEN
          p_codError := 4;
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;       
       ELSE
          OPEN p_Respuesta FOR 
          SELECT * FROM GPYV_001_USUARIO WHERE A041CODIGO = p_A041CODIGO;

          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          return;        
       END IF;

    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);          

END Pr_ConsultarUsuario;

PROCEDURE Pr_RegistrarUsuario (p_A052NOMBRE IN GPYT_T052_PERSONA.A052NOMBRE%TYPE,
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
			                         p_msjError OUT varchar2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarUsuario';
    codExcepcion         NUMBER;    
    p_A041IDPERSONA      NUMBER; --GPYT_T052_PERSONA.A041IDPERSONA
    numReg               NUMBER := 0;
    IDCLASUSR            NUMBER;
    idAutoridad          NUMBER;
    idClaseUsrPadre      NUMBER;

    BEGIN
        dbms_output.put_line ('p_A052TIPDOCMNT' || p_A052TIPDOCMNT);
       OPEN p_Respuesta FOR
         SELECT COUNT(*) FROM GPYT_T041_USUARIO WHERE A041USERNAME = p_A041USERNAME;
       FETCH p_Respuesta INTO numReg;

       IF numReg = 0 THEN
       
          -- establecemos el tipo de usuario, y de paso identificamos la aurtoridad ambiental a la que pertenece
          IF p_A052IDENTIDAD IS NOT NULL THEN
             idAutoridad := p_A052IDENTIDAD;
             IF p_A052IDENTIDAD = 41 THEN
                  IDCLASUSR := 7; -- Está creando otro funcionario MADS
              ELSE
                  IDCLASUSR := 8; -- autoridad ambiental
              END IF;
          ELSE
             -- depende del usuario creador, puede ser un gestor o un publicador.
             SELECT A052IDENTIDAD, A041IDCLASUSR INTO idAutoridad, idClaseUsrPadre FROM GPYT_T041_USUARIO LEFT JOIN  GPYT_T052_PERSONA
                ON A041IDPERSONA = A052CODIGO 
                WHERE A041CODIGO = p_IdUsuario
                AND rownum = 1;
             IF idClaseUsrPadre = 9 THEN   
                IDCLASUSR := 10; -- Publicador
             ELSE
                IDCLASUSR := 9; -- gestor
             END IF;
             
          END IF;
          
         PK_T052_PERSONA.Pr_Insertar (p_A052TIPDOCMNT => p_A052TIPDOCMNT,
                                      p_A052NUMRDOCMNT => p_A052NUMRDOCMNT,
                                      p_A052DIGTCHQU => p_A052DIGTCHQU,
                                      p_A052IDTIPPERSN => p_A052IDTIPPERSN,
                                      p_A052NOMBRE => p_A052NOMBRE,
                                      p_A052APELLIDO => p_A052APELLIDO,
                                      p_A052LGREXPCNDOCMNT => NULL, --p_A052LGREXPCNDOCMNT,
                                      p_A052DIRCCNCORRSPNDNC => NULL, --p_A052DIRCCNCORRSPNDNC,
                                      p_A052LOCLZCN => NULL, --p_A052LOCLZCN,
                                      p_A052TELEFONO => NULL, --p_A052TELEFONO,
                                      p_A052CELULAR => NULL, --p_A052CELULAR,
                                      p_A052CORRELCTRNC => NULL, -- p_A052CORRELCTRNC,
                                      p_A052CODGCIIU => NULL, --p_A052CODGCIIU,
                                      p_A052IDENTIDAD => idAutoridad ,
                                      p_idUsuario => p_IdUsuario,                         
                                      p_resultado => p_Respuesta,
                                      p_codError => p_codError,
                                      p_msjError => p_msjError);

          FETCH p_Respuesta INTO p_A041IDPERSONA;
          dbms_output.put_line ('p_A041USERNAME' || p_A041USERNAME);
          
          
          PK_T041_USUARIO.Pr_Insertar (p_A041USERNAME => p_A041USERNAME,
                                       p_A041CLAVE => p_A041CLAVE,
                                       p_A041PRIMRINGRS => 'SI', --p_A041PRIMRINGRS,
                                       p_A041IDPERSONA => p_A041IDPERSONA,
                                       p_A041IDCLASUSR => IDCLASUSR, --p_A041IDCLASUSR, Publicador
                                       p_idUsuario => p_IdUsuario,                         
                                       p_resultado => p_Respuesta,
                                       p_codError => p_codError,
                                       p_msjError => p_msjError);   
        ELSE
          p_codError := 12; -- Username ya existe
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;        
        END IF;
    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);              

END Pr_RegistrarUsuario;

PROCEDURE Pr_EliminarUsuario (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                              p_IdUsuario IN NUMBER,
                              p_Respuesta OUT CURSOR_SALIDA,
                              p_codError OUT number,
                              p_msjError OUT varchar2) IS 

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_EliminarUsuario';
    codExcepcion         NUMBER;
    p_A052CODIGO         NUMBER;

    BEGIN
       PK_T041_USUARIO.Pr_Eliminar (p_A041CODIGO => p_A041CODIGO,                                   
                                    p_idUsuario => p_IdUsuario,                         
                                    p_resultado => p_Respuesta,
                                    p_codError => p_codError,
                                    p_msjError => p_msjError);

       FETCH p_Respuesta INTO p_A052CODIGO;

       PK_T052_PERSONA.Pr_Eliminar (p_A052CODIGO => p_A052CODIGO,
                                    p_idUsuario => p_IdUsuario,                         
                                    p_resultado => p_Respuesta,
                                    p_codError => p_codError,
                                    p_msjError => p_msjError);

    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);              

END Pr_EliminarUsuario;

PROCEDURE Pr_CambiarContrasena (p_A041CODIGO IN GPYT_T041_USUARIO.A041CODIGO%TYPE,
                                p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                                p_A041CLAVEANT IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                                p_A041CLAVENUEVA IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                                p_IdUsuario IN NUMBER,       
                                p_Respuesta OUT CURSOR_SALIDA,                                    
                                p_codError OUT number,
                                p_msjError OUT varchar2) IS   

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_CambiarContrasena';
    codExcepcion         NUMBER;
    numReg               NUMBER;

    BEGIN       
       IF p_A041CODIGO IS NULL THEN
          p_codError := 4;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '-*-' FROM dual;
          return;
       END IF;
       IF p_A041USERNAME IS NULL THEN
          p_codError := 8;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;
       IF p_A041CLAVEANT IS NULL THEN
          p_codError := 9;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;      
       IF p_A041CLAVENUEVA IS NULL THEN
          p_codError := 10;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF; 

       OPEN p_Respuesta FOR
         SELECT COUNT(*) FROM GPYT_T041_USUARIO
         WHERE A041USERNAME = p_A041USERNAME AND A041CLAVE = p_A041CLAVEANT AND A041ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
       FETCH p_Respuesta INTO numReg;
       dbms_output.put_line('pFiltro :=' );       
       IF numReg > 0 THEN  -- Actualizamos la Contrasena
         PK_T041_USUARIO.Pr_Actualizar (p_A041CODIGO => p_A041CODIGO,
                                        p_A041CLAVE => p_A041CLAVENUEVA,
                                        p_A041PRIMRINGRS => NULL,
                                        p_A041IDPERSONA => NULL,
                                        p_A041IDCLASUSR => NULL,
                                        p_idUsuario => p_IdUsuario,                         
                                        p_resultado => p_Respuesta,
                                        p_codError => p_codError,
                                        p_msjError => p_msjError);   
         --dbms_output.put_line('p_codError: ' || p_codError); 
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
       ELSE
          p_codError := 13; -- Username no existe
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;           
       END IF;
     EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);              

END Pr_CambiarContrasena;      

PROCEDURE Pr_ValidarUsuario (p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                             p_A041CLAVE IN GPYT_T041_USUARIO.A041CLAVE%TYPE,
                             p_IdUsuario IN NUMBER,
                             p_Respuesta OUT CURSOR_SALIDA,
			                       p_codError OUT number,
			                       p_msjError OUT varchar2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ValidarUsuario';
    codExcepcion         NUMBER;
    codUsuario           NUMBER;
    pFiltro              VARCHAR2(255);
    strSQL               VARCHAR2(255);
    numReg               NUMBER;
    estadoReg            CHAR(1);

    BEGIN
       IF p_A041USERNAME IS NULL THEN
          p_codError := 8;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;
       IF p_A041CLAVE IS NULL THEN
          p_codError := 11;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;      
       OPEN p_Respuesta FOR SELECT COUNT(*), A041ESTADOREGISTRO FROM GPYT_T041_USUARIO WHERE A041USERNAME = p_A041USERNAME AND A041CLAVE = p_A041CLAVE GROUP BY A041ESTADOREGISTRO;
       FETCH p_Respuesta INTO numReg, estadoReg;
       IF numReg > 0 THEN
          pFiltro := q'{ A041USERNAME = '}' || p_A041USERNAME || q'{' AND A041CLAVE = '}' || p_A041CLAVE || q'{' AND A041ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
          dbms_output.put_line('pFiltro ' || pFiltro);
          strSQL := 'SELECT * FROM GPYV_001_USUARIO WHERE ' || pFiltro;
          OPEN p_Respuesta FOR strSQL;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
       ELSE
          p_codError := 13; -- usuario o contrasena incorrecta
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
       END IF;          
       IF estadoReg != PK_UTL_CONSTANTE.COD_ACTIVO THEN
          p_codError := 14; -- usuario o contraseÃ±a incorrecta
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;   

    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);          

END Pr_ValidarUsuario;

PROCEDURE Pr_ListarUsuario (p_IdUsuario IN NUMBER,   
                            p_Respuesta OUT CURSOR_SALIDA,
                            p_codError OUT NUMBER,
                            p_msjError OUT VARCHAR2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarUsuario';
    codExcepcion         NUMBER;

    BEGIN
       OPEN p_Respuesta FOR 
       SELECT * FROM GPYV_001_USUARIO;
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);    

END Pr_ListarUsuario;      

PROCEDURE Pr_ConsultarUsrPrUsname (p_A041USERNAME IN GPYT_T041_USUARIO.A041USERNAME%TYPE,
                             p_IdUsuario IN NUMBER,
                             p_Respuesta OUT CURSOR_SALIDA,
			                       p_codError OUT number,
			                       p_msjError OUT varchar2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarUsrPrUsname';
    codExcepcion         NUMBER;
    codUsuario           NUMBER;
    pFiltro              VARCHAR2(255);
    strSQL               VARCHAR2(255);
    numReg               NUMBER;
    estadoReg            CHAR(1);
    
    BEGIN
       IF p_A041USERNAME IS NULL THEN
          p_codError := 8;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;
             
       OPEN p_Respuesta FOR SELECT COUNT(*), A041ESTADOREGISTRO FROM GPYT_T041_USUARIO WHERE A041USERNAME = p_A041USERNAME GROUP BY A041ESTADOREGISTRO;
       FETCH p_Respuesta INTO numReg, estadoReg;
       IF numReg > 0 THEN
          pFiltro := q'{ A041USERNAME = '}' || p_A041USERNAME || q'{' AND A041ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
          dbms_output.put_line('pFiltro ' || pFiltro);
          strSQL := 'SELECT * FROM GPYV_001_USUARIO WHERE ' || pFiltro;
          OPEN p_Respuesta FOR strSQL;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
       ELSE
          p_codError := 13; -- usuario o contrasena incorrecta
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
       END IF;          
       IF estadoReg != PK_UTL_CONSTANTE.COD_ACTIVO THEN
          p_codError := 14; -- usuario o contraseña incorrecta
          p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          return;
       END IF;   
       
    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);          
          
END Pr_ConsultarUsrPrUsname;

PROCEDURE Pr_ConsultarUsrsEntidad (
                            p_A001SIGLA IN GPYT_T001_ENTIDAD.A001SIGLA%TYPE,
                            p_IdUsuario IN NUMBER,   
                            p_Respuesta OUT CURSOR_SALIDA,
                            p_codError OUT NUMBER,
                            p_msjError OUT VARCHAR2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarUsrsEntidad';
    codExcepcion         NUMBER;
    
    BEGIN
       OPEN p_Respuesta FOR 
       SELECT * FROM GPYV_001_USUARIO WHERE A001SIGLA = p_A001SIGLA AND A041ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

    EXCEPTION
       WHEN OTHERS THEN
          ROLLBACK;
          codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                                 NOMBRE_PAQUETE,
                                                                 NOMBRE_PROCEDIMIENTO,
                                                                 SQLCODE,
                                                                 SQLERRM);
          OPEN p_Respuesta FOR SELECT '--' FROM dual;
          p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
          p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);    
                               
END Pr_ConsultarUsrsEntidad;                              


end PK_ADM_USUARIO;
