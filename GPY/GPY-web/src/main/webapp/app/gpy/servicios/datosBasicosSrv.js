/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('datosBasicos.services')
        .factory('datosBasicosSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'datosbasicos';
                var datos = {};

                datos.listarProyectos = function (OE) {
                    return $http.post(urlBase + '/listarProyectos', OE);
                };

                datos.registrarProyecto = function (OE) {
                    return $http.post(urlBase + '/registrarProyecto', OE);
                };

                datos.actualizarProyecto = function (OE) {
                    return $http.post(urlBase + '/actualizarProyecto', OE);
                };

                datos.consultarProyectoPorId = function (OE) {
                    return $http.post(urlBase + '/consultarProyectoPorId', OE);
                };

                datos.consultarSectImplPorIdProy = function (OE) {
                    return $http.post(urlBase + '/consultarSectorImplement', OE);
                };

                datos.consultarProyectoAsociado = function (OE) {
                    return $http.post(urlBase + '/consultarProyectoAsociado', OE);
                };

                return datos;
            }])
        .factory('infoProyecto', function () {
            return {proyecto: ''};
        });
;


