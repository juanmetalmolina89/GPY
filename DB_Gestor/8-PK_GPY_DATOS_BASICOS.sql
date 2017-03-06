create or replace package PK_GPY_DATOS_BASICOS is
 /********************************************************************************
  DESCRIPCION       : Paquete utilizado para agrupar todos los procedimientos y funciones
                      para la gestiòn de los datos bàsicos del proyecto
  
  REALIZADO POR     : Luis Felipe Galeano Castro
  FECHA CREACION    : 15/11/2016
  
  FECHA MODIFICA    : 13/12/2016
  MODIFICADO POR    : Luis Felipe Galeano Castro
  DESCRIPCION CAMBIO: Manejo de excepciones, ajuste de campos
                      Se adiciona el Pr_ActualizarProyecto
  *******************************************************************************/
  NOMBRE_PAQUETE CONSTANT VARCHAR2(100) := 'PK_GPY_DATOS_BASICOS';
  TYPE CURSOR_SALIDA IS REF CURSOR;

  procedure Pr_RegistrarProyecto (p_A002NOMBRPROYCT IN GPYT_T002_PROYECTO.A002NOMBRPROYCT%TYPE,
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
                                  p_msjError OUT VARCHAR2);     
                               
  procedure Pr_RegistrarSectorImplement (p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                                         p_A006IDSECTRIMPLMNTDR IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDSECTRIMPLMNTDR%TYPE, 
                                         p_A006DETALLEOTRO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006DETALLEOTRO%TYPE,
                                         p_idUsuario IN NUMBER,
                                         p_Respuesta OUT CURSOR_SALIDA,
                                         p_codError OUT NUMBER,
                                         p_msjError OUT VARCHAR2);                                             

  procedure Pr_ConsultarProyectoPorId (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                       p_idUsuario IN NUMBER,
                                       p_Respuesta OUT CURSOR_SALIDA,
                                       p_codError OUT NUMBER,
                                       p_msjError OUT VARCHAR2);

  procedure Pr_ActualizarProyecto (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
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
                                   p_msjError OUT VARCHAR2);    

  procedure Pr_ConsultarProyectoAsociado (p_A002CODIGO IN GPYT_T002_PROYECTO.A002CODIGO%TYPE,
                                          p_A002TIPPROYCT IN GPYT_T002_PROYECTO.A002TIPPROYCT%TYPE,			
                                          p_idUsuario IN NUMBER,
                                          p_Respuesta OUT CURSOR_SALIDA,
                                          p_codError OUT NUMBER,
                                          p_msjError OUT VARCHAR2);  

  procedure Pr_ListarProyectos (p_idUsuario IN NUMBER,
                                p_Respuesta OUT CURSOR_SALIDA,
                                p_codError OUT NUMBER,
                                p_msjError OUT VARCHAR2);     
                                
  procedure Pr_ConsultarSectorImplement (p_A006IDPROYECTO IN GPYT_T006_PROY_SECTR_IMPLMNTDR.A006IDPROYECTO%TYPE,
                                         p_idUsuario IN NUMBER,
                                         p_Respuesta OUT CURSOR_SALIDA,
                                         p_codError OUT NUMBER,
                                         p_msjError OUT VARCHAR2);                                    							                               
								
end PK_GPY_DATOS_BASICOS;