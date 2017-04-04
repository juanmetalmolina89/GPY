/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('comun.controllers', ['ngSanitize'])
        .controller('comunCtrl', ['$scope', 'comunSrv','$location','store', function ($scope, comunSrv,$location,store) {

                /**************************************************************/
                /* Variables */
                $scope.FUNCMADS = FUNCMADS;
                $scope.ADMINAA = ADMINAA;
                $scope.GESTPROY = GESTPROY;
                $scope.PUBLICADOR = PUBLICADOR;
                $scope.INVITADO = INVITADO;

                /**************************************************************/
                /* Si llega desde vital */
                if($location.path().substr(5,5)=='token')
                {
                    store.set('token', $location.path().substr(11));
                    $location.path('/gpy');
                }
               
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