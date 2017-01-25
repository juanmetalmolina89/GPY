/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('lstProy.services')
        .factory('lstProySrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'lstProy';
                var datos = {};

                datos.listar = function () {
                    return $http.get(urlBase);
                };
            }]);



