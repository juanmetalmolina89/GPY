/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('financiacion.controllers', ['ngSanitize'])
        .controller('financiacionCtrl', ['$scope', '$routeParams', '$location', '$rootScope', 'financiacionSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'infoProyecto',
            function ($scope, $routeParams, $location, $rootScope, financiacionSrv, comunSrv, listadoSrv, avanceSrv, infoProyecto) {

                alert("controller");
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;
                
                console.log("idproy "+$scope.pid);
                $scope.campoObligatorio = 'Campo obligatorio';


                $scope.listfuentesfinanc = [];
                $scope.listafuentesConfig = [];
                $scope.listfuentesfinancSelected = [];
                $scope.verlist = true;
                $scope.verformreg = false;
                $scope.formEnviado = false;
                $scope.valselectFuente = false;

                $scope.mensaje;
                $scope.listCostosYFinancia = [];

                $scope.objparametrows = {};
                $scope.financiacion = {};
                $scope.financiacion.a002codigo = $scope.pid;

                $scope.cargarInfoProyecto = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002codigo = $scope.pid;
                    financiacionSrv.cargarCostos($scope.OE)
                            .then(function (response) {
                                $scope.costos = response.data.respuesta[0];
                                if ($scope.costos.a002costsestmdformlcn && $scope.costos.a002busqudfinnccn && $scope.costos.a002costtonldrdcr && $scope.costos.a002costsestmdtotl && $scope.costos.a002trm) {
                                    $scope.financiacion.a002costsestmdformlcn = $scope.costos.a002costsestmdformlcn;
                                    $scope.financiacion.a002busqudfinnccn = $scope.costos.a002busqudfinnccn;
                                    $scope.financiacion.a002costtonldrdcr = $scope.costos.a002costtonldrdcr;
                                    $scope.financiacion.a002costsestmdtotl = $scope.costos.a002costsestmdtotl;
                                    $scope.financiacion.a002trm = $scope.costos.a002trm;
                                    
                                } else {
                                    $scope.financiacion = {};
                                }
                                $scope.cargarFuentesConfiguradas();
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                $scope.cargarInfoProyecto();

                $scope.cargarFuentesConfiguradas = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a004idproyecto = $scope.pid;
                    financiacionSrv.cargarFuentes($scope.OE)
                            .then(function (response) {
                                console.log(JSON.stringify(response));
                                $scope.listafuentesConfig = response.data.respuesta;
                                $scope.listarFuentesFinanciacion();
                                console.log(">>>>>" + JSON.stringify($scope.listafuentesConfig));
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listemp = [];
                $scope.objtemp = {};

                //cargar configuraicon
                $scope.listarFuentesFinanciacion = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = 'TIPOFUENTEFIN';
                    var existe = false;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.listemp = response.data.respuesta;
                                console.log("----------------- " + JSON.stringify($scope.listemp));
                                if ($scope.listafuentesConfig && $scope.listafuentesConfig.length > 0) {
                                    for (var i = 0; i < $scope.listemp.length; i++) {
                                        $scope.objtemp = $scope.listemp[i];
                                        for (var j = 0; j < $scope.listafuentesConfig.length; j++) {

                                            if ($scope.listafuentesConfig[j].a102codigo === $scope.listemp[i].a102codigo) {
                                                $scope.objtemp.a102valorcorto = true;
                                                existe = true;
                                                break;
                                            }
                                        }
                                        if (!existe) {
                                            $scope.objtemp.a102valorcorto = false;
                                        }
                                        $scope.listfuentesfinanc.push($scope.objtemp);
                                        existe = false;
                                    }
                                } else {
                                    for (var i = 0; i < $scope.listemp.length; i++) {
                                        $scope.objtemp = $scope.listemp[i];
                                        $scope.objtemp.a102valorcorto = false;
                                        $scope.listfuentesfinanc.push($scope.objtemp);
                                    }
                                }


                                console.log("************ " + JSON.stringify($scope.listfuentesfinanc));

                                $scope.listemp = [];
                                $scope.objtemp = {};
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.a004idproyecto = {};
                $scope.guardar = function (form) {
                    console.log("guardardoi info...");
                    if (form.$valid) {
                        for (var i = 0; i < $scope.listfuentesfinanc.length; i++) {
                            if ($scope.listfuentesfinanc[i].a102valorcorto !== null) {
                                $scope.object = {};

                                $scope.a004idproyecto = {};
                                $scope.a004idproyecto.a002codigo = $scope.pid;
                                $scope.a004idfuntfinnccn = {};
                                $scope.a004idfuntfinnccn.a102codigo = $scope.listfuentesfinanc[i].a102codigo;

                                $scope.object = {};
                                $scope.object.a004idproyecto = $scope.a004idproyecto;
                                $scope.object.a004idfuntfinnccn = $scope.a004idfuntfinnccn;
                                $scope.listfuentesfinancSelected.push($scope.object);
                            }
                        }
                        $scope.financiacion.proyFteFinancList = $scope.listfuentesfinancSelected;
                        $scope.objparametrows.idUsuario = $scope.idUsuario;
                        $scope.objparametrows.proyecto = $scope.financiacion;


                        console.log(JSON.stringify($scope.objparametrows));

                        financiacionSrv.guardarInformacion($scope.objparametrows)
                                .then(function (response) {
                                    console.log(JSON.stringify(response));
                                    comunSrv.mensajeOk("La información se guardo exitosamente!!!");
                                    $scope.limpiar();
                                }, function (error) {
                                    comunSrv.mensajeError(error.data.msgError);
                                });
                    } else {
                        $scope.formEnviado = true;
                        comunSrv.mensajeInfo("Ingrese la información marcada como obligatoria *");
                        var cont = 0;
                        for (var i = 0; i < $scope.listfuentesfinanc.length; i++) {
                            if ($scope.listfuentesfinanc[i].a102valorcorto !== null) {
                                cont++;
                                break;
                            }
                        }
                        if (cont === 0) {
                            $scope.valselectFuente = true;
                        } else {
                            $scope.valselectFuente = false;
                        }
                    }
                };

                $scope.limpiar = function () {
                    $scope.objparametrows = {};
                    $scope.listfuentesfinancSelected = [];
                    $scope.financiacion = {};
                    $scope.formEnviado = false;

                };


                $scope.actualizar = function () {

                    financiacionSrv.actualizar($scope.financiacion)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {

                    financiacionSrv.insertar($scope.financiacion)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    financiacionSrv.borrar($scope.financiacion.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);





