/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('seguimiento.controllers', ['ngSanitize'])
        .controller('seguimientoCtrl', ['$scope', 'seguimientoSrv', function ($scope, seguimientoSrv) {

                $scope.mensaje;
                $scope.seguimientos = []; 
                $scope.seguimiento = []; 

                $scope.listar = function () {
                    seguimientoSrv.listar()
                            .then(function (response) {
                                $scope.seguimiento = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {
                    
                    seguimientoSrv.actualizar($scope.seguimiento)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {
                   
                    seguimientoSrv.insertar($scope.seguimiento)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    seguimientoSrv.borrar($scope.seguimiento.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);



