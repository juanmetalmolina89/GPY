/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('grilla.services')
        .factory('grillaSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'grilla';
                var datos = {};

                datos.listarActividades = function (OE) {
                    return $http.post(urlBase + '/listarActividades', OE);
                };
                
                datos.listarActividadPorClave = function (OE) {
                    return $http.post(urlBase + '/listarActividadPorClave', OE);
                };

                return datos;
            }]);

