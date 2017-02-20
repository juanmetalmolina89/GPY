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

            //escenarios base:
            
	    datos.listarEscenarioBase = function (OE) {
	        return $http.post(urlBase + '/listarEscenarioBase', OE);
	    };

	    datos.insertarEscenarioBase = function (OE) {
	        return $http.post(urlBase + '/registrarEscenarioBase', OE);
	    };

	    datos.borrarEscenarioBase = function (OE) {
	        return $http.post(urlBase + '/eliminarEscenarioBase', OE);
	    };
            
	    return datos;
	}]);

