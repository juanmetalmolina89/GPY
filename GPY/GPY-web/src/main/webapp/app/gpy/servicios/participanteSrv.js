/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('participante.services')
	    .factory('participanteSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'participante';
	    var datos = {};

	    datos.listar = function () {
	        return $http.get(urlBase);
	    };

	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    datos.insertar = function (participante) {
	        return $http.post(urlBase, participante);
	    };

	    datos.actualizar = function (participante) {
	        return $http.put(urlBase + '/' + participante.id, participante);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);