/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('adjunto.services')
	    .factory('adjuntoSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'adjunto';
	    var datos = {};

	    datos.listar = function () {
	        return $http.get(urlBase);
	    };

	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    datos.insertar = function (adjunto) {
	        return $http.post(urlBase, adjunto);
	    };

	    datos.actualizar = function (adjunto) {
	        return $http.put(urlBase + '/' + adjunto.id, adjunto);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);

