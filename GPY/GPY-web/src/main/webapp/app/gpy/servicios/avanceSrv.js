/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('avance.services')
        .factory('avanceSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'avance';
                var datos = {};

                datos.registrarAvance = function (OE) {
                    return $http.post(urlBase +'/registrarAvance', OE);
                };
                
                datos.consultarAvance = function (OE) {
                    return $http.post(urlBase +'/consultarAvance', OE);
                };

                return datos;
            }]);


