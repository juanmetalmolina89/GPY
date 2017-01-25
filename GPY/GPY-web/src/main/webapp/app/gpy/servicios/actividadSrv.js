/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('actividad.services')
        .factory('actividadSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'actividad';
                var datos = {};

                datos.consultarActividadPorId = function (OE) {
                    return $http.post(urlBase + '/consultarActividadPorId', OE);
                };

                datos.registrarActividad = function (OE) {
                    return $http.post(urlBase + '/registrarActividad', OE);
                };

                datos.actualizarActividad = function (OE) {
                    return $http.post(urlBase + '/actualizarActividad', OE);
                };

                datos.eliminarActividad = function (OE) {
                    return $http.post(urlBase + '/eliminarActividad', OE);
                };

                datos.registrarSoporte = function (OE) {
                    return $http.post(urlBase + '/registrarSoporte', OE);
                };

                datos.actualizarSoporte = function (OE) {
                    return $http.post(urlBase + '/actualizarSoporte', OE);
                };

                datos.consultarSoportePorId = function (OE) {
                    return $http.post(urlBase + '/consultarSoportePorId', OE);
                };

                return datos;
            }]);

