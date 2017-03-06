create or replace package body PK_GPY_DATOSMDL is

  -- Lista la especificacion de los archivos addjuntos que se piden por pantalla
  PROCEDURE Pr_ListarAdjuntos (p_A002TIPPROYCT IN GPYT_T002_PROYECTO.A002TIPPROYCT%TYPE,
                               p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,
                               p_idUsuario IN NUMBER,
			       p_Respuesta OUT CURSOR_SALIDA,
			       p_codError OUT NUMBER,
                               p_msjError OUT VARCHAR2) IS
                                   
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarAdjuntos';
     
  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ListarAdjuntos');

      OPEN p_Respuesta FOR 
        SELECT A025CODIGO, A025NOMBRADJNT, A025DESCRPCNADJNT, A025APLICPCNADJNT, A025NOMFORMATO 
        FROM GPYT_T025_ADJUNTO WHERE A025IDTIPPROYCT = p_A002TIPPROYCT 
        AND A025IDPANTALLA = p_A025IDPANTALLA
        AND A025ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);                                              

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ListarAdjuntos');      

  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  END Pr_ListarAdjuntos;

  PROCEDURE Pr_RegistrarConsiderac (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                    p_A002NOMBRPROYCTINGLS IN GPYT_T002_PROYECTO.A002NOMBRPROYCTINGLS%TYPE,
                                    p_A002IDSECTORALSCOPE IN GPYT_T002_PROYECTO.A002IDSECTORALSCOPE%TYPE,
                                    p_A002TECNLGCONTMPLD IN GPYT_T002_PROYECTO.A002TECNLGCONTMPLD%TYPE,                                    
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarConsiderac';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarConsiderac');                                 
                                 
      PK_T002_PROYECTO.Pr_Actualizar (p_A002CODIGO => p_A002CODIGO,
                                      p_A002NOMBRPROYCT => NULL,
                                      p_A002DESCRPCINPROYCT => NULL,
                                      p_A002TIPPROYCT => NULL,
                                      p_A002DURCNPREVST => NULL,
                                      p_A002PROYTASCD => NULL,
                                      p_A002UBCCN => NULL,
                                      p_A002LOCLZCN => NULL,
                                      p_A002IDUSR => NULL,
                                      p_A002SOCEXTRNJR => NULL,
                                      p_A002COSTSESTMDTOTL => NULL,
                                      p_A002COSTSESTMDFORMLCN => NULL,
                                      p_A002COSTTONLDRDCR => NULL,
                                      p_A002TRM => NULL,
                                      p_A002BUSQUDFINNCCN => NULL,
                                      p_A002PLANPRGRMNACNL => NULL,
                                      p_A002OBJTVGENRL => NULL,
                                      p_A002POTNCLESTMDREDCCN => NULL,
                                      p_A002NOMBRPROYCTINGLS => p_A002NOMBRPROYCTINGLS,
                                      p_A002IDSECTORALSCOPE => p_A002IDSECTORALSCOPE,
                                      p_A002TECNLGCONTMPLD => p_A002TECNLGCONTMPLD,
                                      p_A002IDESCALA => NULL,
                                      p_A002IDALCANCE => NULL,
                                      p_A002IDMETDLGMDL => NULL,
                                      p_A002NROCPAS => NULL,
                                      p_A002PROCSVALDCNEC => NULL,
                                      p_A002IDESTDPROCSVALDCN => NULL,
                                      p_A002IDPROYCTMDL => NULL,
                                      p_A002VIDAUTL => NULL,
                                      p_A002IDTIPPERDACRDTCN => NULL,
                                      p_A002FECHINICIO => NULL,
                                      p_A002FECHFIN => NULL,
                                      p_A002APLICMERCDVOLNTR => NULL,
                                      p_A002IDESTNDRMERCDVOLNTR => NULL,
                                      p_idUsuario => p_idUsuario,
                                      p_resultado => p_Respuesta,
                                      p_codError => p_codError,
                                      p_msjError => p_msjError);			           
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarConsiderac');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  END Pr_RegistrarConsiderac;        
  
  PROCEDURE Pr_ConsultarConsiderac (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,                                    
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarConsiderac';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarConsiderac');    
                                         
      --OPEN p_Respuesta FOR SELECT A002NOMBRPROYCTINGLS, A002IDSECTORALSCOPE, A002TECNLGCONTMPLD
      OPEN p_Respuesta FOR SELECT A002NOMBRPROYCTINGLS, A002TECNLGCONTMPLD
        FROM GPYT_T002_PROYECTO WHERE A002CODIGO = p_A002CODIGO;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);        
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarConsiderac');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_ConsultarConsiderac;  
  
  PROCEDURE Pr_ActualizarConsiderac (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                    p_A002NOMBRPROYCTINGLS IN GPYT_T002_PROYECTO.A002NOMBRPROYCTINGLS%TYPE,
                                    p_A002IDSECTORALSCOPE IN GPYT_T002_PROYECTO.A002IDSECTORALSCOPE%TYPE,
                                    p_A002TECNLGCONTMPLD IN GPYT_T002_PROYECTO.A002TECNLGCONTMPLD%TYPE,                                    
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarConsiderac';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ActualizarConsiderac');                                 
                                 
      PK_T002_PROYECTO.Pr_Actualizar (p_A002CODIGO => p_A002CODIGO,
                                      p_A002NOMBRPROYCT => NULL,
                                      p_A002DESCRPCINPROYCT => NULL,
                                      p_A002TIPPROYCT => NULL,
                                      p_A002DURCNPREVST => NULL,
                                      p_A002PROYTASCD => NULL,
                                      p_A002UBCCN => NULL,
                                      p_A002LOCLZCN => NULL,
                                      p_A002IDUSR => NULL,
                                      p_A002SOCEXTRNJR => NULL,
                                      p_A002COSTSESTMDTOTL => NULL,
                                      p_A002COSTSESTMDFORMLCN => NULL,
                                      p_A002COSTTONLDRDCR => NULL,
                                      p_A002TRM => NULL,
                                      p_A002BUSQUDFINNCCN => NULL,
                                      p_A002PLANPRGRMNACNL => NULL,
                                      p_A002OBJTVGENRL => NULL,
                                      p_A002POTNCLESTMDREDCCN => NULL,
                                      p_A002NOMBRPROYCTINGLS => p_A002NOMBRPROYCTINGLS,
                                      p_A002IDSECTORALSCOPE => p_A002IDSECTORALSCOPE,
                                      p_A002TECNLGCONTMPLD => p_A002TECNLGCONTMPLD,
                                      p_A002IDESCALA => NULL,
                                      p_A002IDALCANCE => NULL,
                                      p_A002IDMETDLGMDL => NULL,
                                      p_A002NROCPAS => NULL,
                                      p_A002PROCSVALDCNEC => NULL,
                                      p_A002IDESTDPROCSVALDCN => NULL,
                                      p_A002IDPROYCTMDL => NULL,
                                      p_A002VIDAUTL => NULL,
                                      p_A002IDTIPPERDACRDTCN => NULL,
                                      p_A002FECHINICIO => NULL,
                                      p_A002FECHFIN => NULL,
                                      p_A002APLICMERCDVOLNTR => NULL,
                                      p_A002IDESTNDRMERCDVOLNTR => NULL,
                                      p_idUsuario => p_idUsuario,
                                      p_resultado => p_Respuesta,
                                      p_codError => p_codError,
                                      p_msjError => p_msjError);			           
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ActualizarConsiderac');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
    
  END Pr_ActualizarConsiderac;    
  
  -- Registrar los datos de la Carta de No Objecion                                    
  PROCEDURE Pr_RegistrarCartaNObj (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,     
                                   p_A002IDESCALA IN GPYT_T002_PROYECTO.A002IDESCALA%TYPE,
                                   p_A002IDMETDLGMDL IN GPYT_T002_PROYECTO.A002IDMETDLGMDL%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarConsiderac';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarCartaNObj');    

      PK_T002_PROYECTO.Pr_Actualizar (p_A002CODIGO => p_A002CODIGO,
                                      p_A002NOMBRPROYCT => NULL,
                                      p_A002DESCRPCINPROYCT => NULL,
                                      p_A002TIPPROYCT => NULL,
                                      p_A002DURCNPREVST => NULL,
                                      p_A002PROYTASCD => NULL,
                                      p_A002UBCCN => NULL,
                                      p_A002LOCLZCN => NULL,
                                      p_A002IDUSR => NULL,
                                      p_A002SOCEXTRNJR => NULL,
                                      p_A002COSTSESTMDTOTL => NULL,
                                      p_A002COSTSESTMDFORMLCN => NULL,
                                      p_A002COSTTONLDRDCR => NULL,
                                      p_A002TRM => NULL,
                                      p_A002BUSQUDFINNCCN => NULL,
                                      p_A002PLANPRGRMNACNL => NULL,
                                      p_A002OBJTVGENRL => NULL,
                                      p_A002POTNCLESTMDREDCCN => NULL,
                                      p_A002NOMBRPROYCTINGLS => NULL,
                                      p_A002IDSECTORALSCOPE => NULL,
                                      p_A002TECNLGCONTMPLD => NULL,
                                      p_A002IDESCALA => p_A002IDESCALA,
                                      p_A002IDALCANCE => NULL,
                                      p_A002IDMETDLGMDL => p_A002IDMETDLGMDL,
                                      p_A002NROCPAS => NULL,
                                      p_A002PROCSVALDCNEC => NULL,
                                      p_A002IDESTDPROCSVALDCN => NULL,
                                      p_A002IDPROYCTMDL => NULL,
                                      p_A002VIDAUTL => NULL,
                                      p_A002IDTIPPERDACRDTCN => NULL,
                                      p_A002FECHINICIO => NULL,
                                      p_A002FECHFIN => NULL,
                                      p_A002APLICMERCDVOLNTR => NULL,
                                      p_A002IDESTNDRMERCDVOLNTR => NULL,
                                      p_idUsuario => p_idUsuario,
                                      p_resultado => p_Respuesta,
                                      p_codError => p_codError,
                                      p_msjError => p_msjError);  
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarCartaNObj');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_RegistrarCartaNObj;    
  
  PROCEDURE Pr_ConsultarCartaNObj (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,     
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarCartaNObj';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarCartaNObj');    
                                         
      OPEN p_Respuesta FOR SELECT A002IDESCALA, A002IDMETDLGMDL
        FROM GPYT_T002_PROYECTO WHERE A002CODIGO = p_A002CODIGO;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);   
                                   
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarCartaNObj');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_ConsultarCartaNObj; 
  
  PROCEDURE Pr_ActualizarCartaNObj (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,     
                                    p_A002IDESCALA IN GPYT_T002_PROYECTO.A002IDESCALA%TYPE,
                                    p_A002IDMETDLGMDL IN GPYT_T002_PROYECTO.A002IDMETDLGMDL%TYPE,
                                    p_idUsuario IN NUMBER,
                                    p_Respuesta OUT CURSOR_SALIDA,
                                    p_codError OUT NUMBER,
                                    p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarCartaNObj';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ActualizarCartaNObj');    

      PK_T002_PROYECTO.Pr_Actualizar (p_A002CODIGO => p_A002CODIGO,
                                      p_A002NOMBRPROYCT => NULL,
                                      p_A002DESCRPCINPROYCT => NULL,
                                      p_A002TIPPROYCT => NULL,
                                      p_A002DURCNPREVST => NULL,
                                      p_A002PROYTASCD => NULL,
                                      p_A002UBCCN => NULL,
                                      p_A002LOCLZCN => NULL,
                                      p_A002IDUSR => NULL,
                                      p_A002SOCEXTRNJR => NULL,
                                      p_A002COSTSESTMDTOTL => NULL,
                                      p_A002COSTSESTMDFORMLCN => NULL,
                                      p_A002COSTTONLDRDCR => NULL,
                                      p_A002TRM => NULL,
                                      p_A002BUSQUDFINNCCN => NULL,
                                      p_A002PLANPRGRMNACNL => NULL,
                                      p_A002OBJTVGENRL => NULL,
                                      p_A002POTNCLESTMDREDCCN => NULL,
                                      p_A002NOMBRPROYCTINGLS => NULL,
                                      p_A002IDSECTORALSCOPE => NULL,
                                      p_A002TECNLGCONTMPLD => NULL,
                                      p_A002IDESCALA => p_A002IDESCALA,
                                      p_A002IDALCANCE => NULL,
                                      p_A002IDMETDLGMDL => p_A002IDMETDLGMDL,
                                      p_A002NROCPAS => NULL,
                                      p_A002PROCSVALDCNEC => NULL,
                                      p_A002IDESTDPROCSVALDCN => NULL,
                                      p_A002IDPROYCTMDL => NULL,
                                      p_A002VIDAUTL => NULL,
                                      p_A002IDTIPPERDACRDTCN => NULL,
                                      p_A002FECHINICIO => NULL,
                                      p_A002FECHFIN => NULL,
                                      p_A002APLICMERCDVOLNTR => NULL,
                                      p_A002IDESTNDRMERCDVOLNTR => NULL,
                                      p_idUsuario => p_idUsuario,
                                      p_resultado => p_Respuesta,
                                      p_codError => p_codError,
                                      p_msjError => p_msjError);  
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ActualizarCartaNObj');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_ActualizarCartaNObj;      
  
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
                                 p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarAdjunto';
    p_A008IDARCHV        NUMBER;

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_RegistrarAdjunto'); 
       
      -- Insertar en la tabla GPYT_T026_ARCHIVO
      PK_T026_ARCHIVO.Pr_Insertar (p_A026DESCRPCNARCHIV => p_A026DESCRPCNARCHIV,
                                   p_A026NOMARCHIVO => p_A026NOMARCHIVO,
                                   p_A026HASHARCHIVO =>p_A026HASHARCHIVO,
                                   p_idUsuario => p_idUsuario,                         
                                   p_resultado => p_Respuesta,
                                   p_codError => p_codError,
                                   p_msjError => p_msjError);
      
      FETCH p_Respuesta INTO p_A008IDARCHV;
                                   
      -- Insertar en la tabla GPYT_T008_PROY_ADJUNTO
      PK_T008_PROY_ADJUNTO.Pr_Insertar (p_A008IDPROYECTO => p_A002CODIGO,
                                        p_A008IDADJNT => p_A008IDADJNT,
                                        p_A008IDARCHV => p_A008IDARCHV,
                                        p_A008NUMRRADCD => p_A008NUMRRADCD,
                                        p_A008FECHADJNT => TO_CHAR(p_A008FECHADJNT,'YYYY-MM-DD'),
                                        p_idUsuario => p_idUsuario,                         
                                        p_resultado => p_Respuesta,
                                        p_codError => p_codError,
                                        p_msjError => p_msjError);
                                                                        
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_RegistrarAdjunto');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_RegistrarAdjunto; 
                                   
  PROCEDURE Pr_ConsultarAdjuntos (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                  p_A025IDPANTALLA IN GPYT_T025_ADJUNTO.A025IDPANTALLA%TYPE,
                                  p_idUsuario IN NUMBER,
			          p_Respuesta OUT CURSOR_SALIDA,
			          p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarAdjunto';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarAdjuntos'); 
                                         
      OPEN p_Respuesta FOR SELECT A008CODIGO, A008IDADJNT, A008IDARCHV, A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO, A008NUMRRADCD, A008FECHADJNT
        FROM GPYT_T008_PROY_ADJUNTO, GPYT_T026_ARCHIVO, GPYT_T025_ADJUNTO
        WHERE A008IDARCHV = A026CODIGO AND A025CODIGO = A008IDADJNT AND A008IDPROYECTO = p_A002CODIGO AND A025IDPANTALLA = p_A025IDPANTALLA
        AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;   
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);          
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarAdjuntos');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_ConsultarAdjuntos;   
  
  PROCEDURE Pr_ConsultarAdjuntoPorId (p_A008IDADJNT IN GPYT_T008_PROY_ADJUNTO.A008IDADJNT%TYPE,
                                      p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                      p_idUsuario IN NUMBER,
			              p_Respuesta OUT CURSOR_SALIDA,
			              p_codError OUT NUMBER,
                                      p_msjError OUT VARCHAR2) IS
                                 
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarAdjunto';

  BEGIN                                    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Entro a Pr_ConsultarAdjuntoPorId'); 
                                         
      OPEN p_Respuesta FOR SELECT A008CODIGO, A008IDADJNT, A008IDARCHV, A026DESCRPCNARCHIV, A026NOMARCHIVO, A026HASHARCHIVO, A008NUMRRADCD, A008FECHADJNT
        FROM GPYT_T008_PROY_ADJUNTO, GPYT_T026_ARCHIVO, GPYT_T025_ADJUNTO
        WHERE A008IDARCHV = A026CODIGO AND A025CODIGO = A008IDADJNT AND A008IDPROYECTO = p_A002CODIGO 
        AND A008IDADJNT = p_A008IDADJNT AND A026ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;   
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);          
  
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => 0,
                                         p_descripcion   => 'Salio de Pr_ConsultarAdjuntoPorId');      
  EXCEPTION
      WHEN OTHERS THEN  
        ROLLBACK;
    
      codExcepcion := PK_UTL_UTILIDAD.Fn_RegistrarExcepcion (PK_UTL_CONSTANTE.COD_USUARIO_DEFECTO,
                                                             NOMBRE_PAQUETE,
                                                             NOMBRE_PROCEDIMIENTO,
                                                             SQLCODE,
                                                             SQLERRM);
    
      p_codError := PK_UTL_CONSTANTE.ERROR_GENERAL;
      p_msjError := PK_UTL_CONSTANTE.MSJ_EXCEPCION_GENERAL || TO_CHAR(codExcepcion);
      
  END Pr_ConsultarAdjuntoPorId;       
 
                                  
end PK_GPY_DATOSMDL;