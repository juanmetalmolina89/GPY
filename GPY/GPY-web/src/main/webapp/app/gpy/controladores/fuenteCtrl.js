/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('fuente.controllers', ['ngSanitize'])
        .controller('fuenteCtrl', ['$scope', 'fuenteSrv', function ($scope, fuenteSrv) {

                $scope.mensaje;
                $scope.fuentes = [];
                $scope.fuente = [];

                $scope.listar = function () {
                    fuenteSrv.listar()
                            .then(function (response) {
                                $scope.fuente = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {

                    fuenteSrv.actualizar($scope.fuente)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {

                    fuenteSrv.insertar($scope.fuente)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    fuenteSrv.borrar($scope.fuente.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);


