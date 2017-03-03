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
                    return $http.get(urlBase + '/reporteGeneral/'+ OE.idUsuario + "/" + OE.anio + "/" + OE.a001codigo + "/"  + OE.a103codigo );
                };


                return datos;
            }]);


