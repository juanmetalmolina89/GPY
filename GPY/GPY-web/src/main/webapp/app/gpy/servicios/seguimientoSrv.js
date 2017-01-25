/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('seguimiento.services')
	    .factory('seguimientoSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'seguimiento';
	    var datos = {};

	    datos.listar = function () {
	        return $http.get(urlBase);
	    };

	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    datos.insertar = function (seguimiento) {
	        return $http.post(urlBase, seguimiento);
	    };

	    datos.actualizar = function (seguimiento) {
	        return $http.put(urlBase + '/' + seguimiento.id, seguimiento);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);


