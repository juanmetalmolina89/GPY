/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('persona.services')
        .factory('personaSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'persona';
                var datos = {};
                
                
                datos.consultarPersonaPorId = function (OE) {
                    return $http.post(urlBase + '/consultarPersonaPorId', OE);
                };  
                
                datos.consultarPersonaPorDocumento = function (OE) {
                    return $http.post(urlBase + '/consultarPersonaDocumento', OE);
                };  
                
                datos.actualizarPersona = function (OE) {
                    return $http.post(urlBase + '/actualizarPersona', OE);
                };              
                

                /**************************************************************/
                /** DUMMY */
                datos.listar = function () {
                    return $http.get(urlBase);
                };

                return datos;
            }]);


