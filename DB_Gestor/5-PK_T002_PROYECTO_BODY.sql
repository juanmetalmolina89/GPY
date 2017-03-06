create or replace package body PK_T002_PROYECTO is

  -- Funciones y Procedimientos del paquete
  
  PROCEDURE Pr_Insertar (p_A002NOMBRPROYCT IN GPYT_T002_PROYECTO.A002NOMBRPROYCT%TYPE,
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
                         P_A002IDALCANCE IN GPYT_T002_PROYECTO.A002IDALCANCE%TYPE,
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
			 p_A002ESTADOPROYECTO IN GPYT_T002_PROYECTO.A002ESTADOPROYECTO%TYPE, 
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
                         p_msjError OUT VARCHAR2) IS

      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Insertar';
      p_A002CODIGO         NUMBER;
    
    BEGIN
      -- obtenemos el siguiente id
      p_A002CODIGO := PK_UTL_UTILIDAD.Fn_ObtenerId('T002_PROYECTO_SEQ');
       
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Insertar ' || p_A002DESCRPCINPROYCT);
      
      INSERT INTO GPYT_T002_PROYECTO (A002CODIGO, A002NOMBRPROYCT, A002DESCRPCINPROYCT, A002TIPPROYCT, A002DURCNPREVST, A002PROYTASCD, A002UBCCN, 
            A002LOCLZCN, A002IDUSR, A002SOCEXTRNJR, A002COSTSESTMDTOTL, A002COSTSESTMDFORMLCN, A002COSTTONLDRDCR, A002TRM, A002BUSQUDFINNCCN, A002PLANPRGRMNACNL, 
            A002OBJTVGENRL, A002POTNCLESTMDREDCCN, A002NOMBRPROYCTINGLS, A002IDSECTORALSCOPE, A002TECNLGCONTMPLD, A002IDESCALA, A002IDALCANCE, A002IDMETDLGMDL, A002NROCPAS, 
            A002PROCSVALDCNEC, A002IDESTDPROCSVALDCN, A002IDPROYCTMDL, A002VIDAUTL, A002IDTIPPERDACRDTCN, A002FECHINICIO, A002FECHFIN, A002APLICMERCDVOLNTR, 
            A002IDESTNDRMERCDVOLNTR, A002ESTADOPROYECTO, A002ESTADOREGISTRO, A002FECHACREACION, A002USUARIOCREACION) 
      VALUES (p_A002CODIGO, p_A002NOMBRPROYCT, p_A002DESCRPCINPROYCT, p_A002TIPPROYCT, p_A002DURCNPREVST, p_A002PROYTASCD, p_A002UBCCN, p_A002LOCLZCN, 
            p_A002IDUSR, p_A002SOCEXTRNJR, p_A002COSTSESTMDTOTL, p_A002COSTSESTMDFORMLCN, p_A002COSTTONLDRDCR, p_A002TRM, p_A002BUSQUDFINNCCN, p_A002PLANPRGRMNACNL, 
            p_A002OBJTVGENRL, p_A002POTNCLESTMDREDCCN, p_A002NOMBRPROYCTINGLS, p_A002IDSECTORALSCOPE, p_A002TECNLGCONTMPLD, p_A002IDESCALA, p_A002IDALCANCE, 
            p_A002IDMETDLGMDL, p_A002NROCPAS, p_A002PROCSVALDCNEC, p_A002IDESTDPROCSVALDCN, p_A002IDPROYCTMDL, p_A002VIDAUTL, p_A002IDTIPPERDACRDTCN, p_A002FECHINICIO, 
            p_A002FECHFIN, p_A002APLICMERCDVOLNTR, p_A002IDESTNDRMERCDVOLNTR, p_A002ESTADOPROYECTO, PK_UTL_CONSTANTE.COD_ACTIVO, sysdate, p_idUsuario);
         
      OPEN p_resultado FOR SELECT p_A002CODIGO A002CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Insertar ' || p_A002DESCRPCINPROYCT);
      
  END Pr_Insertar;                         

  PROCEDURE Pr_Eliminar (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                         p_idUsuario IN NUMBER,
                         p_resultado OUT CURSOR_SALIDA,
                         p_codError OUT NUMBER,
			             p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Eliminar';
    estadoReg            VARCHAR2(1);     
    numReg               NUMBER;

   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Eliminar ' || p_A002CODIGO);
  
      UPDATE GPYT_T002_PROYECTO 
      SET A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_INACTIVO, A002FECHAMODIFICACION = sysdate,
          A002USUARIOMODIFICACION = p_idUsuario 
      WHERE A002CODIGO = p_A002CODIGO;
              
      OPEN p_resultado FOR SELECT p_A002CODIGO A002CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError); 
 
    
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Eliminar ' || p_A002CODIGO);
  
  END Pr_Eliminar;
  
  PROCEDURE Pr_Actualizar (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
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
                           p_resultado OUT CURSOR_SALIDA,
                           p_codError OUT NUMBER,
                           p_msjError OUT VARCHAR2) IS
     
      codExcepcion         NUMBER;
      NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_Actualizar';
      estadoReg            VARCHAR2(1); 
      numReg               NUMBER;

   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_Actualizar ' || p_A002CODIGO);
      
      IF p_A002CODIGO IS NULL THEN
         p_codError := 4;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;      
      END IF;
      
      SELECT COUNT(*) INTO numReg FROM GPYT_T002_PROYECTO 
      WHERE A002CODIGO = p_A002CODIGO AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO; 
      
      IF numReg > 0 THEN      
         UPDATE GPYT_T002_PROYECTO 
         SET A002NOMBRPROYCT = NVL(p_A002NOMBRPROYCT, A002NOMBRPROYCT), 
             A002DESCRPCINPROYCT = NVL(p_A002DESCRPCINPROYCT, A002DESCRPCINPROYCT), 
             A002TIPPROYCT = NVL(p_A002TIPPROYCT, A002TIPPROYCT), 
             A002DURCNPREVST = NVL(p_A002DURCNPREVST, A002DURCNPREVST), 
             A002PROYTASCD = NVL(p_A002PROYTASCD, A002PROYTASCD), 
             A002UBCCN = NVL(p_A002UBCCN, A002UBCCN), 
             A002LOCLZCN = NVL(p_A002LOCLZCN, A002LOCLZCN),
             A002IDUSR = NVL(p_A002IDUSR, A002IDUSR), 
             A002SOCEXTRNJR = NVL(p_A002SOCEXTRNJR, A002SOCEXTRNJR), 
             A002COSTSESTMDTOTL = NVL(p_A002COSTSESTMDTOTL, A002COSTSESTMDTOTL), 
             A002COSTSESTMDFORMLCN = NVL(p_A002COSTSESTMDFORMLCN, A002COSTSESTMDFORMLCN), 
             A002COSTTONLDRDCR = NVL(p_A002COSTTONLDRDCR, A002COSTTONLDRDCR), 
             A002TRM = NVL(p_A002TRM, A002TRM),
             A002BUSQUDFINNCCN = NVL(p_A002BUSQUDFINNCCN, A002BUSQUDFINNCCN),
             A002PLANPRGRMNACNL = NVL(p_A002PLANPRGRMNACNL, A002PLANPRGRMNACNL), 
             A002OBJTVGENRL = NVL(p_A002OBJTVGENRL, A002OBJTVGENRL), 
             A002POTNCLESTMDREDCCN = NVL(p_A002POTNCLESTMDREDCCN, A002POTNCLESTMDREDCCN), 
             A002NOMBRPROYCTINGLS = NVL(p_A002NOMBRPROYCTINGLS, A002NOMBRPROYCTINGLS), 
             A002IDSECTORALSCOPE = NVL(p_A002IDSECTORALSCOPE, A002IDSECTORALSCOPE),
             A002TECNLGCONTMPLD = NVL(p_A002TECNLGCONTMPLD, A002TECNLGCONTMPLD), 
             A002IDESCALA = NVL(p_A002IDESCALA, A002IDESCALA), 
             A002IDALCANCE = NVL(p_A002IDALCANCE, A002IDALCANCE),
             A002IDMETDLGMDL = NVL(p_A002IDMETDLGMDL, A002IDMETDLGMDL), 
             A002NROCPAS = NVL(p_A002NROCPAS, A002NROCPAS), 
             A002PROCSVALDCNEC = NVL(p_A002PROCSVALDCNEC, A002PROCSVALDCNEC), 
             A002IDESTDPROCSVALDCN = NVL(p_A002IDESTDPROCSVALDCN, A002IDESTDPROCSVALDCN), 
             A002IDPROYCTMDL = NVL(p_A002IDPROYCTMDL, A002IDPROYCTMDL), 
             A002VIDAUTL = NVL(p_A002VIDAUTL, A002VIDAUTL), 
             A002IDTIPPERDACRDTCN = NVL(p_A002IDTIPPERDACRDTCN, A002IDTIPPERDACRDTCN), 
             A002FECHINICIO = NVL(p_A002FECHINICIO, A002FECHINICIO), 
             A002FECHFIN = NVL(p_A002FECHFIN, A002FECHFIN), 
             A002APLICMERCDVOLNTR = NVL(p_A002APLICMERCDVOLNTR, A002APLICMERCDVOLNTR), 
             A002IDESTNDRMERCDVOLNTR = NVL(p_A002IDESTNDRMERCDVOLNTR, A002IDESTNDRMERCDVOLNTR),           
             A002USUARIOMODIFICACION = p_idUsuario, A002FECHAMODIFICACION = sysdate 
         WHERE A002CODIGO = p_A002CODIGO;   
	 
         OPEN p_resultado FOR SELECT p_A002CODIGO A002CODIGO FROM dual;
         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return;
      ELSE
         p_codError := 5;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);  
         OPEN p_resultado FOR SELECT '' FROM dual;
         return;
      END IF;
      
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_Actualizar ' || p_A002CODIGO);
  
  END Pr_Actualizar;	 	
					   
  PROCEDURE Pr_ConsultarPorFiltro (p_Filtro IN VARCHAR2,
                                   p_idUsuario IN NUMBER,  
                                   p_resultado OUT CURSOR_SALIDA,
                                   p_codError OUT NUMBER,
                                   p_msjError OUT VARCHAR2) IS

    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ConsultarPorFiltro';                     
    strSQL               VARCHAR2(500);
    p_Temp               VARCHAR2(30);    
    
   BEGIN
      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Entro a Pr_ConsultarPorFiltro ' || p_Filtro);
  
      IF p_Filtro IS NULL THEN
         OPEN p_resultado FOR
           SELECT * FROM GPYT_T002_PROYECTO WHERE A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;  

         p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
         p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
         return; 
      END IF;
      
      p_Temp := q'{ AND A002ESTADOREGISTRO = '}' || PK_UTL_CONSTANTE.COD_ACTIVO || q'{'}';
      strSQL := 'SELECT * FROM GPYV_007_PROYECTO WHERE ' || p_Filtro  || p_Temp;
      OPEN p_resultado FOR strSQL;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);

      PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug    => PK_UTL_CONSTANTE.NIVEL_TRACE,
                                         p_paquete       => NOMBRE_PAQUETE,
                                         p_procedimiento => NOMBRE_PROCEDIMIENTO,
                                         p_usuario       => p_idUsuario,
                                         p_descripcion   => 'Salio de Pr_ConsultarPorFiltro ' || p_Filtro);

  END Pr_ConsultarPorFiltro;		                          
  PROCEDURE Pr_ActualizarCostos(
      p_A002CODIGO            IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
      p_A002COSTSESTMDTOTL    IN GPYT_T002_PROYECTO.A002COSTSESTMDTOTL%TYPE,
      p_A002COSTSESTMDFORMLCN IN GPYT_T002_PROYECTO.A002COSTSESTMDFORMLCN%TYPE,
      p_A002COSTTONLDRDCR     IN GPYT_T002_PROYECTO.A002COSTTONLDRDCR%TYPE,
      p_A002TRM               IN GPYT_T002_PROYECTO.A002TRM%TYPE,
      p_A002BUSQUDFINNCCN     IN GPYT_T002_PROYECTO.A002BUSQUDFINNCCN%TYPE,
      p_idUsuario             IN NUMBER,
      p_resultado OUT CURSOR_SALIDA,
      p_codError OUT NUMBER,
      p_msjError OUT VARCHAR2)
  IS
    codExcepcion         NUMBER;
    NOMBRE_PROCEDIMIENTO VARCHAR2(50) := 'Pr_ActualizarCostos';
    estadoReg            VARCHAR2(1);
    numReg               NUMBER;
  BEGIN
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Entro a Pr_ActualizarCostos ' || p_A002CODIGO);
    IF p_A002CODIGO IS NULL THEN
      p_codError    := 4;
      p_msjError    := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    SELECT COUNT(*)
    INTO numReg
    FROM GPYT_T002_PROYECTO
    WHERE A002CODIGO       = p_A002CODIGO
    AND A002ESTADOREGISTRO = PK_UTL_CONSTANTE.COD_ACTIVO;
    IF numReg              > 0 THEN
      UPDATE GPYT_T002_PROYECTO
      SET A002COSTSESTMDTOTL    = NVL(p_A002COSTSESTMDTOTL, A002COSTSESTMDTOTL),
        A002COSTSESTMDFORMLCN   = NVL(p_A002COSTSESTMDFORMLCN, A002COSTSESTMDFORMLCN),
        A002COSTTONLDRDCR       = NVL(p_A002COSTTONLDRDCR, A002COSTTONLDRDCR),
        A002TRM                 = NVL(p_A002TRM, A002TRM),
        A002BUSQUDFINNCCN       = NVL(p_A002BUSQUDFINNCCN, A002BUSQUDFINNCCN),
        A002USUARIOMODIFICACION = p_idUsuario,
        A002FECHAMODIFICACION   = sysdate
      WHERE A002CODIGO          = p_A002CODIGO;
      OPEN p_resultado FOR SELECT p_A002CODIGO A002CODIGO FROM dual;
      p_codError := PK_UTL_CONSTANTE.COD_OPERACION_CORRECTA;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      RETURN;
    ELSE
      p_codError := 5;
      p_msjError := PK_UTL_UTILIDAD.Fn_ObtenerMensaje (p_codError);
      OPEN p_resultado FOR SELECT '' FROM dual;
      RETURN;
    END IF;
    PK_UTL_UTILIDAD.Pr_RegistrarDebug (p_niveldebug => PK_UTL_CONSTANTE.NIVEL_TRACE, p_paquete => NOMBRE_PAQUETE, p_procedimiento => NOMBRE_PROCEDIMIENTO, p_usuario => p_idUsuario, p_descripcion => 'Salio de Pr_ActualizarCostos ' || p_A002CODIGO);
  END Pr_ActualizarCostos;	
end PK_T002_PROYECTO;
