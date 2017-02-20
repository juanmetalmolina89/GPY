/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('politica.services')
	    .factory('politicaSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd + 'politica';
	    var datos = {};

	    datos.listar = function (OE) {
	        return $http.post(urlBase+'/listarPoliticaProyecto', OE);
	    };

	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    datos.insertar = function (politica) {
	        return $http.post(urlBase, politica);
	    };

	    datos.actualizar = function (politica) {
	        return $http.put(urlBase + '/' + politica.id, politica);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);


