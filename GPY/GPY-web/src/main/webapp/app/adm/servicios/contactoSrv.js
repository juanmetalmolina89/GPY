/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('contacto.services')
        .factory('contactoSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'contacto';
                var datos = {};

                datos.consultaContacto = function (OE) {
                    return $http.post(urlBase + '/consultarContactoPorId', OE);
                };

                datos.registrarContacto = function (OE) {
                    return $http.post(urlBase + '/registrarContacto', OE);
                };

                datos.actualizarContacto = function (OE) {
                    return $http.post(urlBase + '/actualizarContacto', OE);
                };

                return datos;
            }]);


