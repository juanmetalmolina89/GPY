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

                datos.consultarSoportePorId = function (OE) {
                    return $http.post(urlBase + '/consultarSoportePorId', OE, {responseType: 'arraybuffer'});
                };

                datos.consultarGeografia = function (OE) {
                    return $http.post(urlBase + '/consultarGeografia', OE);
                };

                return datos;
            }])

        .service('soporteActividadSrv', ['Upload', function (Upload) {

                var urlBase = urlBackEnd + 'actividad';

                this.registrarSoporte = function (idActividad, adjunto, idUsuario) {
                    return Upload.upload({
                        method: 'POST',
                        url: urlBase + '/registrarSoporte',
                        data: {file: adjunto, 'idActividad': idActividad, 'idUsuario': idUsuario}
                    });
                };

                this.actualizarSoporte = function (idSoporte, idActividad, adjunto, idUsuario) {
                    return Upload.upload({
                        method: 'POST',
                        url: urlBase + '/actualizarSoporte',
                        data: {file: adjunto, 'idSoporte': idSoporte , 'idActividad': idActividad, 'idUsuario': idUsuario}
                    });
                };

            }]);

