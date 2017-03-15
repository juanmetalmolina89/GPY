/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('representante.services')
        .factory('representanteSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'representante';
                var datos = {};

                datos.consultaRepresentante = function (OE) {
                    return $http.post(urlBase + '/consultarRepresentantePorId', OE);
                };

                datos.registrarRepresentante = function (OE) {
                    return $http.post(urlBase + '/registrarRepresentante', OE);
                };

                datos.actualizarRepresentante = function (OE) {
                    return $http.post(urlBase + '/actualizarRepresentante', OE);
                };

                datos.consultarDocumento = function (OE) {
                    return $http.post(urlBase + '/consultarDocumento', OE);
                };                               
                   
//                datos.adjuntarDocumento = function (OE) {
//                    return $http.post(urlBase + '/adjuntarDocumento', OE);
//                };

                return datos;
            }])

        .service('RepAdjuntoSrv', ['Upload', function (Upload) {

                var urlBase = urlBackEnd + 'representante';
        
                this.registrarAdjunto = function (idRepresentante, adjunto, idUsuario) {
                    return Upload.upload({
                        method: 'POST',
                        url: urlBase + '/adjuntarDocumento',
                        data: {file: adjunto, 'idRepresentante': idRepresentante, 'idUsuario': idUsuario}
                    });
                };                          
                

            }]);
;

