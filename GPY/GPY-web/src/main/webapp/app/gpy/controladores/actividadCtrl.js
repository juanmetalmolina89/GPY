/* 
 * Autor: Yeimmy Lee
 */
'use strict';
angular.module('actividad.controllers', ['ngSanitize'])
        .controller('actividadCtrl', ['$scope', '$routeParams', '$location', '$window', 'actividadSrv', 'soporteActividadSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'grillaSrv', 'infoProyecto', 'fuenteSrv', function ($scope, $routeParams, $location, $window, actividadSrv, soporteActividadSrv, comunSrv, listadoSrv, avanceSrv, grillaSrv, infoProyecto, fuenteSrv) {

                /**************************************************************/
                /**********************   SESIÓN      *************************/

                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /********************     VARIABLES    ************************/

                $scope.tpid = $routeParams.tpid; //@todo preguntar por el funcionamiento de estos dos
                $scope.pid = $routeParams.pid;


                $scope.actividadPadre = new Object();
                $scope.actividad = new Object();
                $scope.actividad.a005idproyecto = {"a002codigo": $scope.pid};
                $scope.actividad.a005idsoporte = {"a026codigo": '', "a026nomarchivo": ''};
                $scope.soporte = {'adjunto': ''};

                $scope.actividades = [];
                $scope.tiposActividades = [];
                $scope.tiposActivReduccion = [];
                $scope.categoriaMitigacion = '';
                $scope.fuentes = [];
                 
                $scope.nombresIndicador = [];
                $scope.tiposIndicador = [];

                $scope.mtdcalcreduccbaseline = [];

                $scope.muestraForm = false;
                $scope.muestraListTpActRed = false;
                $scope.muestraCampoSoporte = false;
                $scope.muestraFormIndicadores = false;
                $scope.muestraListaIndicadores = false;
                $scope.muestraListaMetas = false;
                $scope.muestraFormMetas = false;

                //geometria
                $scope.geometria = '';
                $scope.a042geometriasitio = '';
                $scope.a042geometriaintersec = '';

                //grilla
                $scope.busquedaOE = {'palabraClave': ''};
                $scope.totalItems = 0;
                $scope.currentPage = 1;
                $scope.itemsPerPage = 5;
                $scope.maxSize = 5;

                /**************************************************************/
                /**************************************************************/
                /*************            ACTIVIDADES          ****************/
                /**************************************************************/
                /**************************************************************/

                /**************************************************************/
                /*****************     Métodos DATOS     **********************/

                $scope.guardarActividad = function () {
                    console.log("geometria: " + $scope.a042geometriasitio);
                    //valida que exista o haya elegido un adjunto
                    if ($scope.actividad.a005idsoporte.a026codigo != '' || $scope.soporte.adjunto != '') {
                        //Valida que haya elegido geometria
                        if ($scope.a042geometriasitio != '' ) {

                            //Empieza a armar el objeto de entrada
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.actividad = $scope.actividad;
                            
                            /* los campos de la fase de registro se pasan vacíos o en ceros */
                            if ($location.path().substr(0, '/gpy/actividadesreg/'.length) === '/gpy/actividadespre/') 
                            {
                                $scope.OE.actividad.a005costototal = 0;
                                $scope.OE.actividad.a005contrbcnprop = 0;
                                $scope.OE.actividad.a005contrbcnextrn = 0;
                            }
                            $scope.OE.actividad.a005idsectoripcc = 1; // bloqueado por ahora
                            $scope.OE.actividad.a005idmtdcalcreduccbaseline = 1; // bloqueado por ahora
                            
                            $scope.OE.actividad.a005idtipactvdd = {"a022codigo": $scope.actividad.a005idtipactvdd.a022codigo}; //Sólo necesito el id (si envío el obj completo voy a tener problemas con el valor tipproyctmdl que se trae para mostrarse, pero no pertenece a la entidad como tal.                    
                            $scope.OE.geometria = $scope.geometria;
                            $scope.OE.a042geometriasitio = $scope.a042geometriasitio;
                            $scope.OE.a042geometriaintersec = $scope.a042geometriaintersec;

                            //Si ya existe lo actualiza, de lo contrario lo registra
                            if ($scope.actividad.a005codigo !== undefined && $scope.actividad.a005codigo !== null && $scope.actividad.a005codigo !== '') {

                                actividadSrv.actualizarActividad($scope.OE).then(function (response) {
                                    //Oculta formulario
                                    $scope.muestraForm = false;
                                    //Si el usuario actualizó el archivo se llama el método para actualizarlo
                                    if ($scope.muestraCampoSoporte == true && $scope.soporte.adjunto != '') {
                                        $scope.actualizarSoporte();
                                        $scope.muestraCampoSoporte = false;
                                    }
                                    comunSrv.mensajeSalida(response);
                                    //Registra avance
                                    /*
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                //comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                    */
                                    //recarga la lista de actividades
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                            } else {
                                //Si el registro es nuevo, llama al método para registrarlo                                
                                actividadSrv.registrarActividad($scope.OE).then(function (response) {
                                    //Oculta formulario
                                    $scope.muestraForm = false;
                                    //actualiza el id actividad y el id de la geometría con el valor devuelto
                                    $scope.actividad.a005codigo = response.data.respuesta[0].a005codigo;
                                    $scope.geometria.a042codigo = response.data.respuesta[1].a042codigo;
                                    //guarda el archivo adjunto
                                    $scope.registrarSoporte();
                                    comunSrv.mensajeSalida(response);
                                    //Registra avance
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                //comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                    //recarga la lista de actividades
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                            }

                        } else { //else validación geometría
                            comunSrv.mensaje("Debe seleccionar una geometría.", "error");
                        }

                    } else { //else validación adjunto
                        comunSrv.mensaje("Debe adjuntar un soporte de la actividad a realizar.", "error");
                    }
                };

                $scope.registrarSoporte = function () {

                    soporteActividadSrv.registrarSoporte($scope.actividad.a005codigo, $scope.soporte.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                $scope.listarActividadPorClave();
                                //comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.actualizarSoporte = function () {

                    soporteActividadSrv.actualizarSoporte($scope.actividad.a005idsoporte.a026codigo, $scope.actividad.a005codigo, $scope.soporte.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                $scope.listarActividadPorClave();
                                //comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.consultarSoportePorId = function () {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a005codigo = $scope.actividad.a005codigo;
                    $scope.OE.a026codigo = $scope.actividad.a005idsoporte.a026codigo;
                    $scope.OE.a005idproyecto = $scope.pid;

                    actividadSrv.consultarSoportePorId($scope.OE).then(function (response) {
                        //Se llama método de utilería que descarga del archivo
                        comunSrv.descargarArchivo(response);
                        //comunSrv.mensajeSalida(response);
                    }, function (error) {
                        comunSrv.mensajeSalida(error);
                    });
                };

                $scope.eliminarActividad = function (act) {

                    if ($window.confirm('Confirme que desea eliminar la actividad.')) {
                        console.log("eliminar actividad");

                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.actividad = {"a005codigo": act.a005codigo};

                        actividadSrv.eliminarActividad($scope.OE)
                                .then(function (response) {
                                    comunSrv.mensajeSalida(response);
                                    //recargar el listado
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        console.log("usuario canceló la acción de eliminar");
                    }
                };

                /**************************************************************/
                /*****************    Métodos VISUALES  ***********************/

                $scope.mostrarForm = function (act) {
                    $scope.muestraForm = true;
                    $scope.muestraFormIndicadores = false;
                    //si viene una actividad como parámetro es edición
                    if (act != undefined && act != null) {
                        $scope.actividad.a005codigo = act.a005codigo;
                        $scope.actividad.a005descrpcnactvdd = act.a005descrpcnactvdd;
                        $scope.actividad.a005fechainicio = new Date(act.a005fechainicio);
                        $scope.actividad.a005fechafinal = new Date(act.a005fechafinal);
                        $scope.actividad.a005costototal = act.a005costototal;
                        $scope.actividad.a005contrbcnprop = act.a005contrbcnprop;
                        $scope.actividad.a005contrbcnextrn = act.a005contrbcnextrn;
                        $scope.actividad.a005idtipactvdd = {"a022codigo": act.a005idtipactvdd};
                        $scope.actividad.a005idtipactvdreduc = {"a58codigo": act.a005idtipactvdreduc};
                        $scope.actividad.a005idsoporte = {"a026codigo": act.a005idsoporte, "a026nomarchivo": act.a026nomarchivo};
                        $scope.consultarGeometria();
                    } else {
                        $scope.actividad = new Object();
                        $scope.actividad.a005idproyecto = {"a002codigo": $scope.pid};
                        $scope.actividad.a005idsoporte = {"a026codigo": '', "a026nomarchivo": ''};
                    }
                    $scope.actualizaCategoriaMitigacion();
                };

                $scope.ocultarForm = function () {
                    $scope.muestraForm = false;
                };

                $scope.mostrarCampoSoporte = function () {
                    $scope.muestraCampoSoporte = true;
                };

                $scope.ocultarCampoSoporte = function () {
                    $scope.muestraCampoSoporte = false;
                };

                $scope.actualizaCategoriaMitigacion = function () {

                    if ($scope.actividad.a005idtipactvdd != undefined) {
                        angular.forEach($scope.tiposActividades, function (value, key) {
                            if ($scope.actividad.a005idtipactvdd.a022codigo === value.a022codigo) {
                                $scope.actividad.a005idtipactvdd = value;
                                $scope.categoriaMitigacion = value.tipproyctmdl;
                            }
                        });

                        //Si la actividad seleccionada es la actividad "especial", se debe mostrar el listado de actividades de reducción
                        if ($scope.actividad.a005idtipactvdd.a022actespecial == 'S') {
                            $scope.muestraListTpActRed = true;
                        } else {
                            $scope.muestraListTpActRed = false;
                        }
                    }
                };

                /**************************************************************/
                /***************  Métodos GRILLAS Y LISTAS  *******************/

                $scope.listarActividadPorClave = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a005idproyecto = $scope.pid;
                    $scope.OE.filtro = $scope.busquedaOE.palabraClave;
                    grillaSrv.listarActividadPorClave($scope.OE)
                            .then(function (response) {
                                $scope.actividades = response.data.respuesta;
                                $scope.totalItems = $scope.actividades.length;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoActividades = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a022idtipproyct = $scope.tpid;
                    listadoSrv.listarTipoActividades($scope.OE)
                            .then(function (response) {
                                $scope.tiposActividades = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoActividadReduccion = function () {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a058tipproyct = $scope.tpid;
                    listadoSrv.listarTipoActividadReduccion($scope.OE)
                            .then(function (response) {
                                $scope.tiposActivReduccion = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };


                $scope.listarMtdcalcreduccbaseline = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = MTDCALCREDUCCBASELINE;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.mtdcalcreduccbaseline = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                /**************************************************************/
                /**************************************************************/
                /*************            INDICADORES          ****************/
                /**************************************************************/
                /**************************************************************/
               
               
                $scope.listarNombresIndicador = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = NOMBREINDICADOR;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.nombresIndicador = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };  
                
                $scope.listarTiposIndicador = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOINDICADOR;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposIndicador = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };                                
                
                $scope.listarIndicadores = function (actividad) {
                    // ocultar form de actividades y mostrar el de indicadores
                    $scope.ocultarForm();
                    $scope.mostrarListaIndicadores();
                    $scope.ocultarListaMetas();
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.indicador={};
                    $scope.actividadPadre = actividad;
                    //$scope.OE.indicador.a011codigo = null;
                    $scope.OE.indicador.a011idactvdd = {"a005codigo":actividad.a005codigo};
                    
                    actividadSrv.consultarIndicador($scope.OE)
                            .then(function (response) {
                                $scope.indicadores = response.data.respuesta;
                                $scope.nombreActividadActual = actividad.a005descrpcnactvdd;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.eliminarIndicador = function (indicador) {
                    // ocultar form de actividades y mostrar el de indicadores
                    $scope.ocultarForm();
                    $scope.ocultarFormIndicadores();
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.indicador = {};
                    $scope.OE.indicador.a011codigo = indicador.a011codigo;
                    
                    actividadSrv.eliminarIndicador($scope.OE)
                            .then(function (response) {
                                $scope.indicadores = response.data.respuesta;
                                $scope.listarIndicadores($scope.actividadPadre);
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                $scope.guardarIndicador = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.indicador = {};
                    $scope.OE.indicador.a011nombrindcdr = $scope.indicador.a011nombrindcdr;
                    $scope.OE.indicador.a011idfuente ={"a038codigo":$scope.indicador.a011idfuente.a038codigo} ;
                    $scope.OE.indicador.a011idtipindcdr = {"a034codigo":$scope.indicador.a011idtipindcdr.a102codigo};
                    $scope.OE.indicador.a011idactvdd={"a005codigo":$scope.actividadPadre.a005codigo};
                    $scope.OE.indicador.a011idtipaccion={"a050codigo":1};
                    //Si ya existe lo actualiza, de lo contrario lo registra
                    if ($scope.indicador.a011codigo !== undefined && $scope.indicador.a011codigo !== null && $scope.indicador.a011codigo !== '') 
                    { 
                        actividadSrv.actualizarIndicador($scope.OE)
                                .then(function (response) {
                                    $scope.indicadores = response.data.respuesta;
                                    $scope.listarIndicadores($scope.actividadPadre);
                                    comunSrv.mensajeSalida(response);
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    }
                    else
                    {
                        actividadSrv.registrarIndicador($scope.OE)
                                .then(function (response) {
                                    $scope.indicadores = response.data.respuesta;
                                    $scope.listarIndicadores($scope.actividadPadre);
                                    comunSrv.mensajeSalida(response);
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    }
                    
                };


                /**************************************************************/
                /*****************    Métodos VISUALES  ***********************/
                $scope.mostrarListaFuentes = function () {

                $scope.OE = new Object();
                $scope.OE.idUsuario = $scope.idUsuario;
                $scope.OE.a038idproyecto = $scope.pid;

                fuenteSrv.listar($scope.OE)
                        .then(function (response) {
                            $scope.fuentes = response.data.respuesta;
                        }, function (error) {
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                }; 
        
                $scope.mostrarListaIndicadores  = function (indicador) {
                    $scope.muestraListaIndicadores = true;
                    $scope.muestraFormIndicadores = false;
                    $scope.ocultarListaMetas();
                   

                };

                $scope.ocultarListaIndicadores  = function () {
                    $scope.muestraListaIndicadores = false;
                    $scope.ocultarListaMetas();
                };
                
                $scope.mostrarFormIndicadores  = function (indicador) {
                    $scope.muestraFormIndicadores = true;
                    $scope.ocultarListaMetas();
                    //si viene una actividad como parámetro es edición
                    if (indicador != undefined && indicador != null) {
                        $scope.indicador.a005codigo = indicador.a005codigo;
                        $scope.indicador.a005descrpcnactvdd = indicador.a005descrpcnactvdd;
                        $scope.indicador.a005fechainicio = new Date(indicador.a005fechainicio);
                        $scope.indicador.a005fechafinal = new Date(indicador.a005fechafinal);
                        $scope.indicador.a005idtipactvdd = {"a022codigo": indicador.a005idtipactvdd};
                        $scope.indicador.a005idtipactvdreduc = {"a58codigo": indicador.a005idtipactvdreduc};
                    } else {
                        $scope.indicador = new Object();
                        $scope.indicador.a005idproyecto = {"a002codigo": $scope.pid};
                    }

                };

                $scope.ocultarFormIndicadores  = function () {
                    $scope.muestraFormIndicadores = false;
                };                
                
                $scope.cancelarIndicador = function () {	
                   $scope.muestraFormIndicadores = false;
                };
                
                
                /**************************************************************/
                /**************************************************************/
                /*************                METAS            ****************/
                /**************************************************************/
                /**************************************************************/
               

                $scope.listarMetas = function (indicador) {
                    $scope.ocultarForm();
                    $scope.ocultarListaIndicadores();
                    $scope.mostrarListaMetas();
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.meta={};                    
                    $scope.indicadorPadre = indicador;
                    //$scope.OE.indicador.a011codigo = null;
                    $scope.OE.meta.a012codigo = indicador.a011codigo;
                    
                    actividadSrv.consultarMeta($scope.OE)
                            .then(function (response) {
                                $scope.metas = response.data.respuesta;                               
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.eliminarMeta = function (meta) {
                    // ocultar form de actividades y mostrar el de indicadores
                    $scope.ocultarForm();
                    $scope.ocultarListaIndicadores();
                    $scope.ocultarFormMetas();
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.meta  = {};
                    $scope.OE.meta.a012codigo = meta.a012codigo;
                    
                    actividadSrv.eliminarMeta($scope.OE)
                            .then(function (response) {
                                //$scope.metas = response.data.respuesta;
                                $scope.listarMetas($scope.indicadorPadre);
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                $scope.guardarMeta = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.meta = {};
                    $scope.OE.meta.a012fechameta = $scope.meta.a012fechameta ;
                    $scope.OE.meta.a012valormeta = $scope.meta.a012valormeta ;
                    $scope.OE.meta.a012uniddmedd = $scope.meta.a012uniddmedd ;
                    $scope.OE.meta.a012idindcdr = {"a011codigo":$scope.indicadorPadre.a011codigo} ;
                    $scope.OE.meta.a012idfuente={"a039codigo":1};
                    if ($scope.meta.a012valrlogrd !== undefined && $scope.meta.a012valrlogrd !== null && $scope.meta.a012valrlogrd !== '') 
                    {
                        $scope.OE.meta.a012valrlogrd=$scope.meta.a012valrlogrd;
                    }
                    else
                    {
                        $scope.OE.meta.a012valrlogrd=0;
                    }
                    
                    if ($scope.meta.a012accionesrealizadas !== undefined && $scope.meta.a012accionesrealizadas !== null && $scope.meta.a012accionesrealizadas !== '') 
                    {
                        $scope.OE.meta.a012accionesrealizadas=$scope.meta.a012accionesrealizadas;
                    }
                    else
                    {
                        $scope.OE.meta.a012accionesrealizadas=" ";
                    }
                    
                    if ($scope.meta.a012recurssinvrtds !== undefined && $scope.meta.a012recurssinvrtds !== null && $scope.meta.a012recurssinvrtds !== '') 
                    {
                        $scope.OE.meta.a012recurssinvrtds=$scope.meta.a012recurssinvrtds;
                    }
                    else
                    {
                        $scope.OE.meta.a012recurssinvrtds= 0;
                    }
                   
                    if ($scope.meta.a012reprtanfuntindicdr !== undefined && $scope.meta.a012reprtanfuntindicdr !== null && $scope.meta.a012reprtanfuntindicdr !== '') 
                    {
                        $scope.OE.meta.a012reprtanfuntindicdr=$scope.meta.a012reprtanfuntindicdr;
                    }
                    else
                    {
                        $scope.OE.meta.a012reprtanfuntindicdr= $scope.meta.a012fechameta;
                    }	 
                    
                    
                    //Si ya existe lo actualiza, de lo contrario lo registra
                    if ($scope.meta.a012codigo !== undefined && $scope.meta.a012codigo !== null && $scope.meta.a012codigo !== '') 
                    { 
                        actividadSrv.actualizarMeta($scope.OE)
                                .then(function (response) {
                                    $scope.metas = response.data.respuesta;
                                    $scope.listarMetas($scope.indicadorPadre);
                                    comunSrv.mensajeSalida(response);
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    }
                    else
                    {
                        actividadSrv.registrarMeta($scope.OE)
                                .then(function (response) {
                                    $scope.metas = response.data.respuesta;
                                    $scope.listarMetas($scope.indicadorPadre);
                                    comunSrv.mensajeSalida(response);
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    }
                    
                };


                /**************************************************************/
                /*****************    Métodos VISUALES  ***********************/

                $scope.mostrarListaMetas  = function (meta) {
                    $scope.muestraListaIndicadores = true;
                    $scope.muestraFormIndicadores = false;
                    $scope.muestraListaMetas = true;
                    $scope.muestraFormMetas = false;
                    
                };

                $scope.ocultarListaMetas  = function () {
                    $scope.muestraListaMetas = false;
                };
                
                $scope.mostrarFormMetas  = function (meta) {
                    $scope.muestraFormMetas = true;
                    //si viene una actividad como parámetro es edición
                    if (meta != undefined && meta != null) {
                        $scope.meta.a012codigo = meta.a012codigo;
                        $scope.meta.a012fechameta =  new Date(meta.a012fechameta);
                        $scope.meta.a012valormeta = meta.a012valormeta;
                        $scope.meta.a012uniddmedd = meta.a012uniddmedd;
                    } else {
                        $scope.meta = new Object();
                        $scope.meta.a012idindcdr = {"a011codigo": $scope.indicadorPadre.a011codigo};
                    }

                };

                $scope.ocultarFormMetas  = function () {
                    $scope.muestraFormMetas = false;
                };                
                
                $scope.cancelarMeta = function () {	
                   $scope.muestraFormMeta = false;
                };
                
                
                
                
                
                
                
                
                /**************************************************************/
                /**************************************************************/
                /*************             GEOMETRÍA           ****************/
                /**************************************************************/
                /**************************************************************/

                $scope.cargarGeometria = function () {

                    $('#geometria').modal('show');
                    try {
                        $scope.urlGeo = './geometria/index.html?divipola=' + $scope.proyecto.coddivipola + '&idModulo=' + IDMODULO + '&idSistema=' + IDSISTEMA;
                        var ctrlGeo = document.getElementById('ctrlGeo');
                        if (ctrlGeo) {
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.a042idproyecto = $scope.pid;
                            $scope.OE.a042idactividad = $scope.actividad.a005codigo;

                            actividadSrv.consultarGeografia($scope.OE)
                                    .then(function (response) {

                                        var geometria = {};
                                        if (response.data.respuesta.length === 0) {

                                            geometria = {
                                                'type': 'Feature',
                                                'properties': {
                                                    'name': 'Feature de prueba'
                                                },
                                                'geometry': {
                                                    'type': 'Point',
                                                    'coordinates': [-74.2478957, 4.6482837]
                                                }
                                            };
                                        } else {

                                            geometria = JSON.parse(response.data.respuesta[0].a042geometria_sitio);
                                        }

                                        setTimeout(function () {
                                            (ctrlGeo.contentWindow || ctrlGeo.contentDocument).establecerGeometria(geometria);
                                        }, 3000);
                                        //comunSrv.mensajeSalida(response);
                                    }, function (error) {
                                        comunSrv.mensajeSalida(error);
                                    });
                        }
                    } catch (e) {
                        comunSrv.mensaje('No se puede cargar la geometría de la actividad, intente de nuevo<br><br>' + e.message, 'error');
                        $scope.a042geometriasitio = e.message;
                    }
                };

                $scope.obtenerGeometria = function () {

                    try {

                        var ctrlGeo = document.getElementById('ctrlGeo');
                        if (ctrlGeo) {
                            $scope.a042geometriasitio = (ctrlGeo.contentWindow || ctrlGeo.contentDocument).obtenerGeometria();
                            $('#geometria').modal('hide');
                        }
                    } catch (e) {

                        comunSrv.mensaje('No se puede seleccionar la geometría de la actividad, intente de nuevo<br><br>' + e.message, 'error');
                        $scope.a042geometriasitio = e.message;
                    }
                };

                $scope.consultarGeometria = function () {

                    //Se inicializan los objetos
                    $scope.inicializarObjetosGeografia();

                    //Se empieza a armar el objeto de entrada para consultar la geografía
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    //$scope.OE.a042idproyecto = $scope.pid;
                    $scope.OE.a042idactividad = $scope.actividad.a005codigo;
                    actividadSrv.consultarGeografia($scope.OE).then(function (response) {
                        $scope.geometria.a042codigo = response.data.respuesta[0].a042codigo;
                        $scope.geometria.a042idproyecto = {"a002codigo": $scope.pid}; //response.data.respuesta[0].a042idproyecto;
                        $scope.geometria.a042idactvdd = $scope.actividad.a005codigo; //response.data.respuesta[0].a042idactvdd;
                        $scope.geometria.a042nrositio = response.data.respuesta[0].a042nrositio;
                        $scope.a042geometria_intersecc = JSON.parse(response.data.respuesta[0].a042geometria_intersecc);
                        $scope.a042geometriasitio = JSON.parse(response.data.respuesta[0].a042geometria_sitio);
                        //comunSrv.mensajeSalida(response);
                    }, function (error) {
                        comunSrv.mensajeSalida(error);
                    });
                };

                $scope.inicializarObjetosGeografia = function () {
                    $scope.geometria = {"a042idproyecto": {"a002codigo": $scope.pid}, "a042nrositio": 1 /*, "a042geometriaSitio": '', "a042geometriaIntersecc": ''*/};
                    $scope.a042geometriasitio = '';
                    $scope.a042geometriaintersec = {"Prueba": {"codigo": 1, "nombre": "nombre", "apellido": "apellido"}}; //@todo pendiente que definan qué debe ir en este campo
                };


                /**************************************************************/
                /* Inicializar formulario */
                
                if (infoProyecto.proyecto=="")
                {                    
                    $scope.$parent.consultarProyectoPorId($scope.pid)
                        .then(function (response) {
                            $scope.proyecto = $scope.$parent.proyecto;
                         }, function (error) {
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                }
                else
                {
                    $scope.proyecto = infoProyecto.proyecto;
                }
                
                //Definir pantalla para registrar avance
                if ($location.path().substr(0, '/gpy/actividadespre/'.length) === '/gpy/actividadespre/') {
                    $scope.pantalla = ACTIVIDADESPRE;
                } else if ($location.path().substr(0, '/gpy/actividadesreg/'.length) === '/gpy/actividadesreg/') {
                    $scope.pantalla = ACTIVIDADESREG;
                    $scope.listarNombresIndicador();
                    $scope.listarTiposIndicador();
                    $scope.listarMtdcalcreduccbaseline();
                }

                $scope.inicializarObjetosGeografia();
                $scope.listarActividadPorClave();
                $scope.listarTipoActividades();
                $scope.listarTipoActividadReduccion();
                $scope.mostrarListaFuentes();

            }]);


