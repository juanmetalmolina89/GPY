/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('comun.controllers', ['ngSanitize'])
        .controller('comunCtrl', ['$scope', 'comunSrv', function ($scope, comunSrv) {

                /**************************************************************/
                /* Variables */
                $scope.INVITADO = INVITADO;


                /**************************************************************/
                /* Métodos */
                $scope.obtenerSesion = function () {

                    return comunSrv.obtenerSesion();
                };

                $scope.cerrarSesion = function () {

                    comunSrv.cerrarSesion();
                };


            }])
        .controller('menuCtrl', function ($scope, $location) {

            /**************************************************************/
            /* Variables */
            $scope.FUNCMADS = FUNCMADS;
            $scope.ADMINAA = ADMINAA;
            $scope.GESTPROY = GESTPROY;
            $scope.PUBLICADOR = PUBLICADOR;
            $scope.INVITADO = INVITADO;

            /**************************************************************/
            /* Métodos */
            $scope.getClassMenu = function (ruta, deshabilitar) {
                if (deshabilitar !== undefined && deshabilitar !== null && deshabilitar === true)
                    return 'disabled';
                else
                    return ($location.path().substr(0, ruta.length) === ruta) ? 'active' : '';
            };
        })
        ;