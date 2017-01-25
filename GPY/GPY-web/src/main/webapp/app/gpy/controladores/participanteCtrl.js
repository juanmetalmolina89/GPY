/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('participante.controllers', ['ngSanitize'])
        .controller('participanteCtrl', ['$scope', 'participanteSrv', function ($scope, participanteSrv) {

                $scope.mensaje;
                $scope.participantes = []; 
                $scope.participante = []; 

                $scope.listar = function () {
                    participanteSrv.listar()
                            .then(function (response) {
                                $scope.participantes = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {
                    
                    participanteSrv.actualizar($scope.participante)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {
                   
                    participanteSrv.insertar($scope.participante)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    participanteSrv.borrar($scope.participante.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);
