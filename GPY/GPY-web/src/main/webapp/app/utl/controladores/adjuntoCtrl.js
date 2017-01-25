/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('adjunto.controllers', ['ngSanitize'])
        .controller('adjuntoCtrl', ['$scope', 'adjuntoSrv', function ($scope, adjuntoSrv) {

                $scope.mensaje;
                $scope.adjuntos = [];
                $scope.adjunto = [];

                $scope.listar = function () {
                    adjuntoSrv.listar()
                            .then(function (response) {
                                $scope.adjunto = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {

                    adjuntoSrv.actualizar($scope.adjunto)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {

                    adjuntoSrv.insertar($scope.adjunto)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    adjuntoSrv.borrar($scope.adjunto.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);



