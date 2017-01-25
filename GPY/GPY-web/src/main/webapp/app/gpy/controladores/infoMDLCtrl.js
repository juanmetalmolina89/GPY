/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('infoMDL.controllers', ['ngSanitize'])
        .controller('infoMDLCtrl', ['$scope', '$routeParams', '$location', 'infoMDLSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'infoProyecto', function ($scope, $routeParams, $location, infoMDLSrv, comunSrv, listadoSrv, avanceSrv, infoProyecto) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.tpid = $routeParams.tpid;//@todo preguntar por el funcionamiento de estos dos
                $scope.pid = $routeParams.pid;

                if ($scope.tpid != MDL && $scope.tpid != MDL_POA && $scope.tpid != CPA) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no válida para el tipo de proyecto que está gestionando", "info");
                    $location.path('/gpy/datbaspre/' + $scope.tpid + '/' + $scope.pid);
                }

                $scope.sectoralScopes = [];
                $scope.escalas = [];
                $scope.metodologiasMDL = [];
                $scope.adjuntos = [];


                /**************************************************************/
                /* Métodos */

                $scope.registrarConsiderac = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.proyecto = $scope.proyecto;

                    infoMDLSrv.registrarConsiderac($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                                //guardar adjuntos

                                //registrar avance
                                avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                        .then(function (response) {
                                            comunSrv.mensajeSalida(response);
                                        }, function (error) {
                                            comunSrv.mensajeSalida(error);
                                        });

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.registrarCartaNObj = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.proyecto = $scope.proyecto;

                    infoMDLSrv.registrarCartaNObj($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                                //guardar adjuntos

                                //registrar avance
                                avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                        .then(function (response) {
                                            comunSrv.mensajeSalida(response);
                                        }, function (error) {
                                            comunSrv.mensajeSalida(error);
                                        });
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.registrarAutorizacionEntCoord = function () {
                    //guardar adjuntos

                    //registrar avance
                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });


                };

                $scope.listarSectoralScopes = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = SECTORAL;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.sectoralScopes = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarEscalas = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = ESCALA;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.escalas = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarMetdMDL = function () {
                    //para poder listar las metodologías MDL debe conocer la escala y el sector
                    console.log("a002idescala " + $scope.proyecto.a002idescala.a102codigo);
                    console.log("a028idsectoralscope " + $scope.proyecto.a002idsectoralscope.a102codigo);
                    if (($scope.proyecto.a002idescala.a102codigo != undefined || $scope.proyecto.a002idescala.a102codigo != null) && ($scope.proyecto.a002idsectoralscope.a102codigo != undefined || $scope.proyecto.a002idsectoralscope.a102codigo)) {
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.a028idescl = $scope.proyecto.a002idescala.a102codigo;
                        $scope.OE.a028idsectoralscope = $scope.proyecto.a002idsectoralscope.a102codigo;
                        listadoSrv.listarMetdMDL($scope.OE)
                                .then(function (response) {
                                    $scope.metodologiasMDL = response.data.respuesta;
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    }
                };

                $scope.listarAdjuntos = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002tipproyct = $scope.tpid;
                    $scope.OE.a0025idpantalla = $scope.pantalla;
                    infoMDLSrv.listarAdjuntos($scope.OE)
                            .then(function (response) {
                                $scope.adjuntos = response.data.respuesta;
                                //@todo mostrar adjuntos de acuerdo a este resultado
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /**************************************************************/
                /* Inicializar formulario */
                $scope.proyecto = infoProyecto.proyecto;
                
                if ($location.path().substr(0, '/gpy/etapa1pre/'.length) === '/gpy/etapa1pre/') {
                    //etapa 1
                    $scope.pantalla = MDLETP1PRE;
                    $scope.listarSectoralScopes();
                } else if ($location.path().substr(0, '/gpy/etapa2pre/'.length) === '/gpy/etapa2pre/') {
                    //etapa 2
                    $scope.pantalla = MDLETP2PRE;
                    $scope.listarEscalas();
                    $scope.listarMetdMDL();
                } else if ($location.path().substr(0, '/gpy/etapa3pre/'.length) === '/gpy/etapa3pre/') {
                    //etapa 2
                    $scope.pantalla = MDLETP3PRE;
                }
                $scope.listarAdjuntos();


            }]);



