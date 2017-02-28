/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('reporte.services')
        .factory('reporteSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'reporte';
                var datos = {};
                
                datos.listarReportes = function (OE) {
                    return $http.post(urlBase + '/ListarReporteProyecto', OE);
                };

                datos.reporteGeneral = function (OE) {
                    return $http.post(urlBase + '/reporteGeneral', OE);
                    //return $http.get(urlBase + '/download/xls');
                };


                return datos;
            }]);


