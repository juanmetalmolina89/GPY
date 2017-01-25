/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('fuente.services')
	    .factory('fuenteSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'fuente';
	    var datos = {};

	    datos.listar = function () {
	        return $http.get(urlBase);
	    };

	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    datos.insertar = function (fuente) {
	        return $http.post(urlBase, fuente);
	    };

	    datos.actualizar = function (fuente) {
	        return $http.put(urlBase + '/' + fuente.id, fuente);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);

