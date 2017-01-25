/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('avanceProy.controllers', ['ngSanitize'])
        .controller('avanceProyCtrl', ['$scope', 'avanceProySrv', function ($scope, avanceProySrv) {

                $scope.mensaje;
                $scope.avanceProyectos = []; 
                $scope.avanceProy = []; 

                $scope.listar = function () {
                    avanceProySrv.listar()
                            .then(function (response) {
                                $scope.avanceProy = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {
                    
                    avanceProySrv.actualizar($scope.avanceProy)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {
                   
                    avanceProySrv.insertar($scope.avanceProy)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    avanceProySrv.borrar($scope.avanceProy.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);



