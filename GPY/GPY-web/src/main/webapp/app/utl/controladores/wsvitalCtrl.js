/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('wsvital.controllers', ['ngSanitize'])
        .controller('wsvitalCtrl', ['$scope', 'wsvitalSrv', function ($scope, wsvitalSrv) {

                $scope.mensaje;
                $scope.wsvital = [];

            }]);



