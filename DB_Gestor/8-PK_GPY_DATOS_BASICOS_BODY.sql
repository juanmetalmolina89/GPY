create or replace package body PK_GPY_DATOS_BASICOS is
 
  PROCEDURE Pr_RegistrarProyecto (p_A002NOMBRPROYCT IN GPYT_T002_PROYECTO.A002NOMBRPROYCT%TYPE,
                                  p_A002DESCRPCINPROYCT IN GPYT_T002_PROYECTO.A002DESCRPCINPROYCT%TYPE,
                                  p_A002TIPPROYCT IN GPYT_T002_PROYECTO.A002TIPPROYCT%TYPE,
                                  p_A002DURCNPREVST IN GPYT_T002_PROYECTO.A002DURCNPREVST%TYPE,
                                  p_A002PROYTASCD IN GPYT_T002_PROYECTO.A002PROYTASCD%TYPE,
                                  p_A002UBCCN IN GPYT_T002_PROYECTO.A002UBCCN%TYPE,
                                  p_A002LOCLZCN IN GPYT_T002_PROYECTO.A002LOCLZCN%TYPE,
                                  p_A002IDUSR IN GPYT_T002_PROYECTO.A002IDUSR%TYPE,
                                  p_A002SOCEXTRNJR IN GPYT_T002_PROYECTO.A002SOCEXTRNJR%TYPE,
                                  p_A002COSTSESTMDTOTL IN GPYT_T002_PROYECTO.A002COSTSESTMDTOTL%TYPE,
                                  p_A002COSTSESTMDFORMLCN IN GPYT_T002_PROYECTO.A002COSTSESTMDFORMLCN%TYPE,
                                  p_A002COSTTONLDRDCR IN GPYT_T002_PROYECTO.A002COSTTONLDRDCR%TYPE,
                                  p_A002TRM IN GPYT_T002_PROYECTO.A002TRM%TYPE,
                                  p_A002BUSQUDFINNCCN IN GPYT_T002_PROYECTO.A002BUSQUDFINNCCN%TYPE,
                                  p_A002PLANPRGRMNACNL IN GPYT_T002_PROYECTO.A002PLANPRGRMNACNL%TYPE,
                                  p_A002OBJTVGENRL IN GPYT_T002_PROYECTO.A002OBJTVGENRL%TYPE,
                                  p_A002POTNCLESTMDREDCCN IN GPYT_T002_PROYECTO.A002POTNCLESTMDREDCCN%TYPE,
                                  p_A002NOMBRPROYCTINGLS IN GPYT_T002_PROYECTO.A002NOMBRPROYCTINGLS%TYPE,
                                  p_A002IDSECTORALSCOPE IN GPYT_T002_PROYECTO.A002IDSECTORALSCOPE%TYPE,
                                  p_A002TECNLGCONTMPLD IN GPYT_T002_PROYECTO.A002TECNLGCONTMPLD%TYPE,
                                  p_A002IDESCALA IN GPYT_T002_PROYECTO.A002IDESCALA%TYPE,
                                  p_A002IDALCANCE IN GPYT_T002_PROYECTO.A002IDALCANCE%TYPE,
                                  p_A002IDMETDLGMDL IN GPYT_T002_PROYECTO.A002IDMETDLGMDL%TYPE,
                                  p_A002NROCPAS IN GPYT_T002_PROYECTO.A002NROCPAS%TYPE,
                                  p_A002PROCSVALDCNEC IN GPYT_T002_PROYECTO.A002PROCSVALDCNEC%TYPE,
                                  p_A002IDESTDPROCSVALDCN IN GPYT_T002_PROYECTO.A002IDESTDPROCSVALDCN%TYPE,
                                  p_A002IDPROYCTMDL IN GPYT_T002_PROYECTO.A002IDPROYCTMDL%TYPE,
                                  p_A002VIDAUTL IN GPYT_T002_PROYECTO.A002VIDAUTL%TYPE,
                                  p_A002IDTIPPERDACRDTCN IN GPYT_T002_PROYECTO.A002IDTIPPERDACRDTCN%TYPE,
                                  p_A002FECHINICIO IN GPYT_T002_PROYECTO.A002FECHINICIO%TYPE,
                                  p_A002FECHFIN IN GPYT_T002_PROYECTO.A002FECHFIN%TYPE,
                                  p_A002APLICMERCDVOLNTR IN GPYT_T002_PROYECTO.A002APLICMERCDVOLNTR%TYPE,
                                  p_A002IDESTNDRMERCDVOLNTR IN GPYT_T002_PROYECTO.A002IDESTNDRMERCDVOLNTR%TYPE,
                                  p_idUsuario IN NUMBER,
                                  p_Respuesta OUT CURSOR_SALIDA,
                                  p_codError OUT NUMBER,
                                  p_msjError OUT VARCHAR2) IS  
                                
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarProyecto';
    codExcepcion         NUMBER;    
    p_A002ESTADOPROYECTO NUMBER;
    p_A002CODIGO         NUMBER;
    
    BEGIN
       p_A002ESTADOPROYECTO := PK_UTL_LISTADOS.Fn_TraerCodigo('PREREGISTRO');
       PK_T002_PROYECTO.Pr_Insertar (p_A002NOMBRPROYCT => p_A002NOMBRPROYCT,
                                     p_A002DESCRPCINPROYCT => p_A002DESCRPCINPROYCT,
                                     p_A002TIPPROYCT => p_A002TIPPROYCT,
                                     p_A002DURCNPREVST => p_A002DURCNPREVST,
                                     p_A002PROYTASCD => p_A002PROYTASCD,
                                     p_A002UBCCN => p_A002UBCCN,
                                     p_A002LOCLZCN => p_A002LOCLZCN,
                                     p_A002IDUSR => p_A002IDUSR,
                                     p_A002SOCEXTRNJR => p_A002SOCEXTRNJR,
                                     p_A002COSTSESTMDTOTL => p_A002COSTSESTMDTOTL,
                                     p_A002COSTSESTMDFORMLCN => p_A002COSTSESTMDFORMLCN,
                                     p_A002COSTTONLDRDCR => p_A002COSTTONLDRDCR,
                                     p_A002TRM => p_A002TRM,
                                     p_A002BUSQUDFINNCCN => p_A002BUSQUDFINNCCN,
                                     p_A002PLANPRGRMNACNL => p_A002PLANPRGRMNACNL,
                                     p_A002OBJTVGENRL => p_A002OBJTVGENRL,
                                     p_A002POTNCLESTMDREDCCN => p_A002POTNCLESTMDREDCCN,
                                     p_A002NOMBRPROYCTINGLS => p_A002NOMBRPROYCTINGLS,
                                     p_A002IDSECTORALSCOPE => p_A002IDSECTORALSCOPE,
                                     p_A002TECNLGCONTMPLD => p_A002TECNLGCONTMPLD,
                                     p_A002IDESCALA => p_A002IDESCALA,
                                     p_A002IDALCANCE => p_A002IDALCANCE,
                                     p_A002IDMETDLGMDL => p_A002IDMETDLGMDL,
                                     p_A002NROCPAS => p_A002NROCPAS,
                                     p_A002PROCSVALDCNEC => p_A002PROCSVALDCNEC,
                                     p_A002IDESTDPROCSVALDCN => p_A002IDESTDPROCSVALDCN,
                                     p_A002IDPROYCTMDL => p_A002IDPROYCTMDL,
                                     p_A002VIDAUTL => p_A002VIDAUTL,
                                     p_A002IDTIPPERDACRDTCN => p_A002IDTIPPERDACRDTCN,
                                     p_A002FECHINICIO => p_A002FECHINICIO,
                                     p_A002FECHFIN => p_A002FECHFIN,
                                     p_A002APLICMERCDVOLNTR => p_A002APLICMERCDVOLNTR,
                                     p_A002IDESTNDRMERCDVOLNTR => p_A002IDESTNDRMERCDVOLNTR,
                                     p_A002ESTADOPROYECTO => p_A002ESTADOPROYECTO,
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
    
  END Pr_RegistrarProyecto;
  
  PROCEDURE Pr_RegistrarSectorImplement (p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                                         p_A006IDSECTRIMPLMNTDR IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDSECTRIMPLMNTDR%TYPE, 	
                                         p_A006DETALLEOTRO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006DETALLEOTRO%TYPE,
                                         p_idUsuario IN NUMBER,
                                         p_Respuesta OUT CURSOR_SALIDA,
                                         p_codError OUT NUMBER,
                                         p_msjError OUT VARCHAR2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_RegistrarSectorImplement';
    codExcepcion         NUMBER;    
    
    BEGIN                                
      PK_T006_PROY_SECTR_IMPLMNTDR.Pr_Insertar (p_A006IDPROYECTO => p_A006IDPROYECTO,
                                                p_A006IDSECTRIMPLMNTDR => p_A006IDSECTRIMPLMNTDR,
                                                p_A006DETALLEOTRO => p_A006DETALLEOTRO,
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
          
  END Pr_RegistrarSectorImplement;
  
  PROCEDURE Pr_ConsultarProyectoPorId (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                       p_idUsuario IN NUMBER,
                                       p_Respuesta OUT CURSOR_SALIDA,
                                       p_codError OUT NUMBER,
                                       p_msjError OUT VARCHAR2) IS
                                       
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarProyectoPorId';
    codExcepcion         NUMBER;    
    
    BEGIN                                
       OPEN p_Respuesta FOR SELECT * FROM GPYV_003_DATOSBASICOS WHERE A002CODIGO = p_A002CODIGO;
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);      
                                     
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
          
  END Pr_ConsultarProyectoPorId;                                       
  
  PROCEDURE Pr_ActualizarProyecto (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                   p_A002NOMBRPROYCT IN GPYT_T002_PROYECTO.A002NOMBRPROYCT%TYPE,
                                   p_A002DESCRPCINPROYCT IN GPYT_T002_PROYECTO.A002DESCRPCINPROYCT%TYPE,
                                   p_A002TIPPROYCT IN GPYT_T002_PROYECTO.A002TIPPROYCT%TYPE,
                                   p_A002DURCNPREVST IN GPYT_T002_PROYECTO.A002DURCNPREVST%TYPE,
                                   p_A002PROYTASCD IN GPYT_T002_PROYECTO.A002PROYTASCD%TYPE,
                                   p_A002UBCCN IN GPYT_T002_PROYECTO.A002UBCCN%TYPE,
                                   p_A002LOCLZCN IN GPYT_T002_PROYECTO.A002LOCLZCN%TYPE,
                                   p_A002IDUSR IN GPYT_T002_PROYECTO.A002IDUSR%TYPE,
                                   p_A002SOCEXTRNJR IN GPYT_T002_PROYECTO.A002SOCEXTRNJR%TYPE,
                                   p_A002COSTSESTMDTOTL IN GPYT_T002_PROYECTO.A002COSTSESTMDTOTL%TYPE,
                                   p_A002COSTSESTMDFORMLCN IN GPYT_T002_PROYECTO.A002COSTSESTMDFORMLCN%TYPE,
                                   p_A002COSTTONLDRDCR IN GPYT_T002_PROYECTO.A002COSTTONLDRDCR%TYPE,
                                   p_A002TRM IN GPYT_T002_PROYECTO.A002TRM%TYPE,
                                   p_A002BUSQUDFINNCCN IN GPYT_T002_PROYECTO.A002BUSQUDFINNCCN%TYPE,
                                   p_A002PLANPRGRMNACNL IN GPYT_T002_PROYECTO.A002PLANPRGRMNACNL%TYPE,
                                   p_A002OBJTVGENRL IN GPYT_T002_PROYECTO.A002OBJTVGENRL%TYPE,
                                   p_A002POTNCLESTMDREDCCN IN GPYT_T002_PROYECTO.A002POTNCLESTMDREDCCN%TYPE,
                                   p_A002NOMBRPROYCTINGLS IN GPYT_T002_PROYECTO.A002NOMBRPROYCTINGLS%TYPE,
                                   p_A002IDSECTORALSCOPE IN GPYT_T002_PROYECTO.A002IDSECTORALSCOPE%TYPE,
                                   p_A002TECNLGCONTMPLD IN GPYT_T002_PROYECTO.A002TECNLGCONTMPLD%TYPE,
                                   p_A002IDESCALA IN GPYT_T002_PROYECTO.A002IDESCALA%TYPE,
                                   p_A002IDALCANCE IN GPYT_T002_PROYECTO.A002IDALCANCE%TYPE,
                                   p_A002IDMETDLGMDL IN GPYT_T002_PROYECTO.A002IDMETDLGMDL%TYPE,
                                   p_A002NROCPAS IN GPYT_T002_PROYECTO.A002NROCPAS%TYPE,
                                   p_A002PROCSVALDCNEC IN GPYT_T002_PROYECTO.A002PROCSVALDCNEC%TYPE,
                                   p_A002IDESTDPROCSVALDCN IN GPYT_T002_PROYECTO.A002IDESTDPROCSVALDCN%TYPE,
                                   p_A002IDPROYCTMDL IN GPYT_T002_PROYECTO.A002IDPROYCTMDL%TYPE,
                                   p_A002VIDAUTL IN GPYT_T002_PROYECTO.A002VIDAUTL%TYPE,
                                   p_A002IDTIPPERDACRDTCN IN GPYT_T002_PROYECTO.A002IDTIPPERDACRDTCN%TYPE,
                                   p_A002FECHINICIO IN GPYT_T002_PROYECTO.A002FECHINICIO%TYPE,
                                   p_A002FECHFIN IN GPYT_T002_PROYECTO.A002FECHFIN%TYPE,
                                   p_A002APLICMERCDVOLNTR IN GPYT_T002_PROYECTO.A002APLICMERCDVOLNTR%TYPE,
                                   p_A002IDESTNDRMERCDVOLNTR IN GPYT_T002_PROYECTO.A002IDESTNDRMERCDVOLNTR%TYPE,
                                   p_idUsuario IN NUMBER,
                                   p_Respuesta OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarProyecto';
    codExcepcion         NUMBER;    
    
    BEGIN                
       PK_T002_PROYECTO.Pr_Actualizar (p_A002CODIGO => p_A002CODIGO,
                                       p_A002NOMBRPROYCT => p_A002NOMBRPROYCT,
                                       p_A002DESCRPCINPROYCT => p_A002DESCRPCINPROYCT,
                                       p_A002TIPPROYCT => p_A002TIPPROYCT,
                                       p_A002DURCNPREVST => p_A002DURCNPREVST,
                                       p_A002PROYTASCD => p_A002PROYTASCD,
                                       p_A002UBCCN => p_A002UBCCN,
                                       p_A002LOCLZCN => p_A002LOCLZCN,
                                       p_A002IDUSR => p_A002IDUSR,
                                       p_A002SOCEXTRNJR => p_A002SOCEXTRNJR,
                                       p_A002COSTSESTMDTOTL => p_A002COSTSESTMDTOTL,
                                       p_A002COSTSESTMDFORMLCN => p_A002COSTSESTMDFORMLCN,
                                       p_A002COSTTONLDRDCR => p_A002COSTTONLDRDCR,
                                       p_A002TRM => p_A002TRM,
                                       p_A002BUSQUDFINNCCN => p_A002BUSQUDFINNCCN,
                                       p_A002PLANPRGRMNACNL => p_A002PLANPRGRMNACNL,
                                       p_A002OBJTVGENRL => p_A002OBJTVGENRL,
                                       p_A002POTNCLESTMDREDCCN => p_A002POTNCLESTMDREDCCN,
                                       p_A002NOMBRPROYCTINGLS => p_A002NOMBRPROYCTINGLS,
                                       p_A002IDSECTORALSCOPE => p_A002IDSECTORALSCOPE,
                                       p_A002TECNLGCONTMPLD => p_A002TECNLGCONTMPLD,
                                       p_A002IDESCALA => p_A002IDESCALA,
                                       p_A002IDALCANCE => p_A002IDALCANCE,
                                       p_A002IDMETDLGMDL => p_A002IDMETDLGMDL,
                                       p_A002NROCPAS => p_A002NROCPAS,
                                       p_A002PROCSVALDCNEC => p_A002PROCSVALDCNEC,
                                       p_A002IDESTDPROCSVALDCN => p_A002IDESTDPROCSVALDCN,
                                       p_A002IDPROYCTMDL => p_A002IDPROYCTMDL,
                                       p_A002VIDAUTL => p_A002VIDAUTL,
                                       p_A002IDTIPPERDACRDTCN => p_A002IDTIPPERDACRDTCN,
                                       p_A002FECHINICIO => p_A002FECHINICIO,
                                       p_A002FECHFIN => p_A002FECHFIN,
                                       p_A002APLICMERCDVOLNTR => p_A002APLICMERCDVOLNTR,
                                       p_A002IDESTNDRMERCDVOLNTR => p_A002IDESTNDRMERCDVOLNTR,
                                       p_idUsuario => p_idUsuario,                           
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

  END Pr_ActualizarProyecto;           
  
  PROCEDURE Pr_ConsultarProyectoAsociado (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                          p_A002TIPPROYCT IN GPYT_T002_PROYECTO.A002TIPPROYCT%TYPE,			
                                          p_idUsuario IN NUMBER,
                                          p_Respuesta OUT CURSOR_SALIDA,
                                          p_codError OUT NUMBER,
                                          p_msjError OUT VARCHAR2) IS

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarProyectoAsociado';
    codExcepcion         NUMBER;    
    tipoProyecto         VARCHAR2(30);
    
    BEGIN                
       SELECT A102VALORCORTO INTO tipoProyecto FROM PART_T102_LISTA WHERE A102CODIGO = p_A002TIPPROYCT;
       -- trae solo los proyectos del mismo tipo
       IF tipoProyecto <> 'MDL' AND p_A002CODIGO IS NOT NULL THEN
          OPEN p_Respuesta FOR SELECT A002CODIGO, A002NOMBRPROYCT, A002DESCRPCINPROYCT, A002TIPPROYCT
             FROM GPYT_T002_PROYECTO
             WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A002TIPPROYCT = p_A002TIPPROYCT
             AND A002CODIGO <> p_A002CODIGO;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);  
       END IF;   
       IF tipoProyecto <> 'MDL' AND p_A002CODIGO IS NULL THEN
          OPEN p_Respuesta FOR SELECT A002CODIGO, A002NOMBRPROYCT, A002DESCRPCINPROYCT, A002TIPPROYCT
             FROM GPYT_T002_PROYECTO
             WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A002TIPPROYCT = p_A002TIPPROYCT;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);  
       END IF;   
       -- muestra todos los tipos de proyecto
       IF tipoProyecto = 'MDL' AND p_A002CODIGO IS NULL THEN 
          OPEN p_Respuesta FOR SELECT A002CODIGO, A002NOMBRPROYCT, A002DESCRPCINPROYCT, A002TIPPROYCT
             FROM GPYT_T002_PROYECTO
             WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError); 
       END IF;      
       IF tipoProyecto = 'MDL' AND p_A002CODIGO IS NOT NULL THEN 
          OPEN p_Respuesta FOR SELECT A002CODIGO, A002NOMBRPROYCT, A002DESCRPCINPROYCT, A002TIPPROYCT
             FROM GPYT_T002_PROYECTO
             WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO AND A002CODIGO <> p_A002CODIGO;
          p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
          p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError); 
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
                                          
  END Pr_ConsultarProyectoAsociado;                                             
    
 -- Esta es la consulta para la grilla
  PROCEDURE Pr_ListarProyectos (p_idUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2) is

    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ListarProyectos';
    codExcepcion         NUMBER;    
    
    BEGIN                                
       OPEN p_Respuesta FOR 
       SELECT * FROM GPYV_003_DATOSBASICOS WHERE A002IDUSR = p_idUsuario;
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje(p_codError);      
                                     
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
  
  END Pr_ListarProyectos;
	
 PROCEDURE Pr_ConsultarSectorImplement (p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                                        p_idUsuario IN NUMBER,
                                        p_Respuesta OUT CURSOR_SALIDA,
                                        p_codError OUT NUMBER,
                                        p_msjError OUT VARCHAR2) IS
                                        
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarSectorImplement';
    codExcepcion         NUMBER;    
    
    BEGIN                                
       OPEN p_Respuesta FOR 
         SELECT A006CODIGO, A006IDSECTRIMPLMNTDR, A023DESCSECTRIMPLMNTDR, A006DETALLEOTRO
         FROM GPYT_T006_PROY_SECTR_IMPLMNTDR I, GPYT_T023_SECTOR_IMPLEMENTADOR S
         WHERE S.A023CODIGO = A006IDSECTRIMPLMNTDR AND I.A006IDPROYECTO = p_A006IDPROYECTO;
       p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
       p_msjError := PK_UTL_UTILIDAD.Fn_Obtenermensaje(p_codError);      
                                     
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
                                         
  END Pr_ConsultarSectorImplement;
   
END PK_GPY_DATOS_BASICOS;