/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('reporte.controllers', ['ngSanitize'])
        .controller('reporteCtrl', ['$scope', 'reporteSrv', function ($scope, reporteSrv) {

                $scope.mensaje;
                $scope.reporte = [];

            }]);


