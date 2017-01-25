/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('actividad.controllers', ['ngSanitize'])
        .controller('actividadCtrl', ['$scope', '$routeParams', '$location', 'actividadSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'infoProyecto', function ($scope, $routeParams, $location, actividadSrv, comunSrv, listadoSrv, avanceSrv, infoProyecto) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.tpid = $routeParams.tpid;//@todo preguntar por el funcionamiento de estos dos
                $scope.pid = $routeParams.pid;

                $scope.actividades = [];
                $scope.actividad = [];
                $scope.tiposActividades = [];
                $scope.tiposActivReduccion = [];

                $scope.muestraForm = false;

                //grilla
                $scope.busquedaOE = {'palabraClave': ''};
                $scope.totalItems = 0;
                $scope.currentPage = 1;
                $scope.itemsPerPage = 5;
                $scope.maxSize = 5;


                /**************************************************************/
                /* Métodos */

                $scope.guardarActividad = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    //@todo completar el obj de entrada

                    //Si ya existe lo actualiza, de lo contrario lo registra
                    if ($scope.actividad.a005codigo !== undefined && $scope.actividad.a005codigo !== null && $scope.actividad.a005codigo !== '') {

                        actividadSrv.actualizarActividad($scope.OE)
                                .then(function (response) {
                                    comunSrv.mensajeSalida(response);
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {

                        actividadSrv.registrarActividad($scope.OE)
                                .then(function (response) {
                                    //actualiza el id actividad con el valor devuelto
                                    $scope.actividad.a005codigo = response.data.respuesta[0].a005codigo;
                                    comunSrv.mensajeSalida(response);
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    }
                };

                $scope.listarActividades = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.palabraClave = $scope.busquedaOE.palabraClave;
                    /* @todo completar obj de entrada */

                    listadoSrv.listarActividades($scope.OE)
                            .then(function (response) {
                                $scope.actividades = response.data.respuesta;
                                $scope.totalItems = $scope.actividades.length;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.mostrarForm = function (act) {
                    $scope.muestraForm = true;
                    if (act != undefined && act != null) {
                        $scope.actividad = act;
                    }
                };

                $scope.ocultarForm = function () {
                    $scope.muestraForm = false;
                };

                $scope.eliminarActividad = function (act) {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    /* @todo completar obj de entrada */

                    actividadSrv.eliminarActividad($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                                //recargar el listado
                                $scope.listarActividades();
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoActividades = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a022idtipproyct = $scope.tpid;
                    $scope.OE.a022idtipproyctmdl = $scope.proyecto.a002idproyctmdl.a102codigo;

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
                    /* @todo completar obj de entrada */

                    listadoSrv.listarTipoActividadReduccion($scope.OE)
                            .then(function (response) {
                                $scope.tiposActivReduccion = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /**************************************************************/
                /* Inicializar formulario */
                $scope.proyecto = infoProyecto.proyecto;

                //Definir pantalla para registrar avance
                if ($location.path().substr(0, '/gpy/actividadespre/'.length) === '/gpy/actividadespre/') {
                    $scope.pantalla = ACTIVIDADESPRE;
                } else if ($location.path().substr(0, '/gpy/actividadesreg/'.length) === '/gpy/actividadesreg/') {
                    $scope.pantalla = ACTIVIDADESREG;
                }

                $scope.listarActividades();
                $scope.listarTipoActividades();
                $scope.listarTipoActividadReduccion();




            }]);


