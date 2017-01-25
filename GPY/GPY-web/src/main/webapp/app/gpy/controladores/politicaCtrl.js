/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('politica.controllers', ['ngSanitize'])
        .controller('politicaCtrl', ['$scope', 'politicaSrv', function ($scope, politicaSrv) {

                $scope.mensaje;
                $scope.politicas = [];
                $scope.politica = [];

                $scope.listar = function () {
                    politicaSrv.listar()
                            .then(function (response) {
                                $scope.politica = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {

                    politicaSrv.actualizar($scope.politica)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {

                    politicaSrv.insertar($scope.politica)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    politicaSrv.borrar($scope.politica.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);





