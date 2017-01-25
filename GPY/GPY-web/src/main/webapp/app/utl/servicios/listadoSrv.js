/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('listado.services')
        .factory('listadoSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'listados';
                var datos = {};

                datos.listarParametros = function (OE) {
                    return $http.post(urlBase + '/listar', OE);
                };

                datos.listarTipoDocumento = function (OE) {
                    return $http.post(urlBase + '/listarTipoDocumento', OE);
                };
                
                datos.listarAutoridades = function (OE) {
                    return $http.post(urlBase +'/listarAutoridades', OE);
                };

                datos.listarPaises = function (OE) {
                    return $http.post(urlBase +'/paises', OE);
                };

                datos.listarDepartamentosPorPais = function (OE) {
                    return $http.post(urlBase +'/departamentos', OE);
                };

                datos.listarMunicipiosPorDepartamento = function (OE) {
                    return $http.post(urlBase +'/municipios', OE);
                };                

                datos.listarCodigosCIIU = function (OE) {
                    return $http.post(urlBase +'/listarCodigoCIIU', OE);
                };

                datos.listarSectorImplementador = function (OE) {
                    return $http.post(urlBase +'/listarSectorImplementador', OE);
                };

                datos.listarTipoActividades = function (OE) {
                    return $http.post(urlBase +'/listarTipoActividades', OE);
                };

                datos.listarMetdMDL = function (OE) {
                    return $http.post(urlBase +'/listarMetdMDL', OE);
                };

                datos.listarActividades = function (OE) {
                    return $http.post(urlBase +'/listarActividades', OE);
                };
                
                
                /**************************************************************/
                /* DUMMY */

                datos.listarTipoActividadReduccion = function (OE) {
                    return $http.post(urlBase +'/listarTipoActividadReduccion', OE);
                };

                return datos;

            }]);


