/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('infoMDL.services')
        .factory('infoMDLSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'datosMdl';
                var datos = {};

                datos.registrarConsiderac = function (OE) {
                    return $http.post(urlBase + '/registrarConsiderac', OE);
                };

                datos.consultarConsiderac = function (OE) {
                    return $http.post(urlBase + '/consultarConsiderac', OE);
                };

                datos.actualizarConsiderac = function (OE) {
                    return $http.post(urlBase + '/actualizarConsiderac', OE);
                };

                datos.registrarCartaNObj = function (OE) {
                    return $http.post(urlBase + '/registrarCartaNObj', OE);
                };

                datos.consultarCartaNObj = function (OE) {
                    return $http.post(urlBase + '/consultarCartaNObj', OE);
                };

                datos.actualizarCartaNObj = function (OE) {
                    return $http.post(urlBase + '/actualizarCartaNObj', OE);
                };

                datos.listarAdjuntos = function (OE) {
                    return $http.post(urlBase + '/listarAdjuntos', OE);
                };

                datos.registrarAdjunto = function (OE) {
                    return $http.post(urlBase + '/registrarAdjunto', OE);
                };

                datos.consultarAdjunto = function (OE) {
                    return $http.post(urlBase + '/consultarAdjunto', OE);
                };

                return datos;
            }])

        .service('adjuntosMDLSrv', ['Upload', function (Upload) {

                var urlBase = urlBackEnd + 'datosMdl';

                this.registrarAdjunto = function (adjunto, idUsuario, idProyecto, numrradcd, idAdjnt) {
                    return Upload.upload({
                        method: 'POST',
                        url: urlBase + '/registrarAdjunto',
                        data: {file: adjunto, 'idUsuario': idUsuario, 'idProyecto': idProyecto, 'numrradcd': numrradcd, 'idAdjnt': idAdjnt}
                    });
                };

            }]);


