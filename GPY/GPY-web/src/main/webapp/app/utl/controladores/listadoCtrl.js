/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('listado.controllers', ['ngSanitize'])
        .controller('listadoCtrl', ['$scope', 'listadoSrv', function ($scope, listadoSrv) {

                $scope.mensaje;
                $scope.listados = [];
                $scope.listado = [];

                $scope.listarAutoridades = function () {
                    listadoSrv.listarAutoridades()
                            .then(function (response) {
                                $scope.listaAutoridades = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarTipoProyecto = function () {
                    listadoSrv.listarTipoProyecto()
                            .then(function (response) {
                                $scope.listaTipoProyecto = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };



                $scope.listarEstadoProyecto = function () {
                    listadoSrv.listarEstadoProyecto()
                            .then(function (response) {
                                $scope.listaEstadoProyecto = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarUbicacionProyecto = function () {
                    listadoSrv.listarUbicacionProyecto()
                            .then(function (response) {
                                $scope.listaUbicacionProyecto = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarDepartamentos = function () {
                    listadoSrv.listarDepartamentos()
                            .then(function (response) {
                                $scope.listaDepartamentos = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarMunicipiosPorDepartamento = function () {
                    listadoSrv.listarMunicipiosPorDepartamento()
                            .then(function (response) {
                                $scope.listaMunicipiosPorDepartamento = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarAlcanceProyecto = function () {
                    listadoSrv.listarAlcanceProyecto()
                            .then(function (response) {
                                $scope.listaAlcanceProyecto = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarSectorImplementador = function () {
                    listadoSrv.listarSectorImplementador()
                            .then(function (response) {
                                $scope.listaSectorImplementador = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarTipoDocumento = function () {
                    listadoSrv.listarTipoDocumento()
                            .then(function (response) {
                                $scope.listaTipoDocumento = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarPaises = function () {
                    listadoSrv.listarPaises()
                            .then(function (response) {
                                $scope.listaPaises = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarTipoPersonaJuridica = function () {
                    listadoSrv.listarTipoPersonaJuridica()
                            .then(function (response) {
                                $scope.listaTipoPersonaJuridica = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarCodigosCIIU = function () {
                    listadoSrv.listarCodigosCIIU()
                            .then(function (response) {
                                $scope.listaCodigosCIIU = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarTipoDeRepresentante = function () {
                    listadoSrv.listarTipoDeRepresentante()
                            .then(function (response) {
                                $scope.listaTipoDeRepresentante = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

				$scope.listarSectorIPCC = function () {
                    listadoSrv.listarSectorIPCC()
                            .then(function (response) {
                                $scope.listaSectorIPCC = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

				$scope.listarSubgrupoIPCC = function () {
                    listadoSrv.listarSubgrupoIPCC()
                            .then(function (response) {
                                $scope.listaSubgrupoIPCC = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

				$scope.listarCategoriaIPCC = function () {
                    listadoSrv.listarCategoriaIPCC()
                            .then(function (response) {
                                $scope.listaCategoriaIPCC = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

				$scope.listarSubcategoriaIPCC = function () {
                    listadoSrv.listarSubcategoriaIPCC()
                            .then(function (response) {
                                $scope.listaSubcategoriaIPCC = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };				
				$scope.listarDesagregacionIPCC = function () {
                    listadoSrv.listarDesagregacionIPCC()
                            .then(function (response) {
                                $scope.listaDesagregacionIPCC = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);


