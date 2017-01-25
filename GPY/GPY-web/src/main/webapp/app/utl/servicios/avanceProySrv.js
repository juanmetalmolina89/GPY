/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('avanceProy.services')
        .factory('avanceProySrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'avanceProy';
                var datos = {};

                /**************************************************************/
                /** DUMMY */
                datos.listar = function () {
                    return $http.get(urlBase);
                };

                datos.consultarPorId = function (id) {
                    return $http.get(urlBase + '/' + id);
                };

                datos.insertar = function (avanceProy) {
                    return $http.post(urlBase, avanceProy);
                };

                datos.actualizar = function (avanceProy) {
                    return $http.put(urlBase + '/' + avanceProy.id, avanceProy);
                };

                datos.borrar = function (id) {
                    return $http.delete(urlBase + '/' + id);
                };

                return datos;
            }]);


