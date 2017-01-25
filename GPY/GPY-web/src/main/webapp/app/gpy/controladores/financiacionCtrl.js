/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('financiacion.controllers', ['ngSanitize'])
        .controller('financiacionCtrl', ['$scope', 'financiacionSrv', function ($scope, financiacionSrv) {

                $scope.mensaje;
                $scope.financiaciones = [];
                $scope.financiacion = [];

                $scope.listar = function () {
                    financiacionSrv.listar()
                            .then(function (response) {
                                $scope.financiacion = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
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





