/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('lstProy.controllers', ['ngSanitize'])
        .controller('lstProyCtrl', ['$scope', 'lstProySrv', function ($scope, lstProySrv) {

                $scope.mensaje;
                $scope.lstProy = [];

                $scope.listar = function () {
                    lstProySrv.listar()
                            .then(function (response) {
                                $scope.lstProy = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
            }]);


