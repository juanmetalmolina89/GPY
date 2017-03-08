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

	    datos.actualizar = function (politica) {
	        return $http.put(urlBase + '/' + politica.id, politica);
	    };

	    datos.registrarPolitica = function (OE) {
	        return $http.post(urlBase+'/registrarPolitica', OE);
	    };

	    datos.eliminarPolitica = function (OE) {
	        return $http.post(urlBase+'/eliminarPolitica', OE);
	    };

            datos.listarPoliticas = function (OE) {
	        return $http.post( urlBackEnd + 'listados/listarPoliticas', OE);
	    };
            
            datos.listarPoliticaProyecto = function (OE) {
	        return $http.post( urlBackEnd + '/listarPoliticaProyecto', OE);
	    };
            
            
            
	    return datos;
	}]);


