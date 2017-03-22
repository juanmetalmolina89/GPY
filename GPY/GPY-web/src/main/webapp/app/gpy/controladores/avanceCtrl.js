/* 
 * Autor: Yeimmy Lee
 */
'use strict';
angular.module('avance.controllers', ['ngSanitize'])
        .controller('avanceCtrl', ['$scope', '$routeParams', '$location', '$window', 'actividadSrv', 'soporteActividadSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'grillaSrv', 'infoProyecto', function ($scope, $routeParams, $location, $window, actividadSrv, soporteActividadSrv, comunSrv, listadoSrv, avanceSrv, grillaSrv, infoProyecto) {
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
                /*****************    Métodos VISUALES  ***********************/

                $scope.mostrarForm = function (act) {
                    $scope.muestraForm = true;
                    $scope.muestraFormIndicadores = false;
                    //si viene una actividad como parámetro es edición                    
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

                /**************************************************************/
                /**************************************************************/
                /*************            INDICADORES          ****************/
                /**************************************************************/
                /**************************************************************/                                     
                
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

                /**************************************************************/
                /*****************    Métodos VISUALES  ***********************/

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
               
                $scope.guardarMeta = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.meta = {};
                    $scope.OE.meta.a012codigo = $scope.meta.a012codigo ;
                    $scope.OE.meta.a012fechameta = $scope.meta.a012fechameta ;
                    $scope.OE.meta.a012valormeta = $scope.meta.a012valormeta ;
                    $scope.OE.meta.a012uniddmedd = $scope.meta.a012uniddmedd ;
                    
                    $scope.OE.meta.a012reprtanfuntindicdr = $scope.meta.a012reprtanfuntindicdr ;
                    $scope.OE.meta.a012valrlogrd = $scope.meta.a012valrlogrd ;
                    $scope.OE.meta.a012accionesrealizadas = $scope.meta.a012accionesrealizadas ;
                    $scope.OE.meta.a012recurssinvrtds = $scope.meta.a012recurssinvrtds ;
                                     
                    $scope.OE.meta.a012idindcdr = {"a011codigo":$scope.indicadorPadre.a011codigo} ;
                    $scope.OE.meta.a012idfuente={"a039codigo":1};                   
                    
                    
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
                    //si viene una actividad como parámetro es edición ( a diferencia del frm de atividades, en avance siempre vendrá en modo update)
                    $scope.meta = {};
                    if (meta != undefined && meta != null) {
                        $scope.meta.a012codigo = meta.a012codigo;
                        $scope.meta.a012fechameta =  new Date(meta.a012fechameta);
                        $scope.meta.a012valormeta = meta.a012valormeta;
                        $scope.meta.a012uniddmedd = meta.a012uniddmedd;
                        $scope.meta.a012reprtanfuntindicdr = new Date(meta.a012reprtanfuntindicdr);
                        $scope.meta.a012valrlogrd =  meta.a012valrlogrd;
                        $scope.meta.a012accionesrealizadas = meta.a012accionesrealizadas;
                        $scope.meta.a012recurssinvrtds = meta.a012recurssinvrtds;
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
                /* Inicializar formulario */
                $scope.proyecto = infoProyecto.proyecto;
 
                $scope.listarActividadPorClave();


            }]);


