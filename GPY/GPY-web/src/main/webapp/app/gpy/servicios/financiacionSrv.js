/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('financiacion.services')
	    .factory('financiacionSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'financiacion';
	    var datos = {};

	    datos.listar = function () {
	        return $http.get(urlBase);
	    };

	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    datos.insertar = function (financiacion) {
	        return $http.post(urlBase, financiacion);
	    };

	    datos.actualizar = function (financiacion) {
	        return $http.put(urlBase + '/' + financiacion.id, financiacion);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);





