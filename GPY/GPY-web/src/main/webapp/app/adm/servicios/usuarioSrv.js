/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('usuario.services')
        .factory('usuarioSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'usuario';
                var datos = {};


                datos.registrarUsuario = function (OE) {
                    return $http.post(urlBase + '/registrarUsuario', OE);
                };

                datos.cambiarContrasena = function (OE) {
                    return $http.post(urlBase + '/cambiarContrasena', OE);
                };
                datos.validarUsuario = function (OE) {
                    return $http.post(urlBase + '/validarUsuario', OE);
                };

                return datos;
            }]);
