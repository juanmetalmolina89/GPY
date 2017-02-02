/* 
 * Autor: Fernando Camargo
 */
'use strict';

angular.module('fuente.services')
	    .factory('fuenteSrv', ['$http', function($http) { 

	    var urlBase = urlBackEnd+'fuentes';
	    var datos = {};

	    datos.listar = function (OE) {
	        return $http.post(urlBase + '/listarFuenteProyecto', OE);
	    };

	    datos.insertar = function (OE) {
	        return $http.post(urlBase + '/registrarFuente', OE);
	    };

	    datos.actualizar = function (OE) {
	        return $http.post(urlBase + '/actualizarFuente', OE);
	    };

	    datos.borrar = function (OE) {
	        return $http.post(urlBase + '/eliminarFuente', OE);
	    };

	    return datos;
	}]);

