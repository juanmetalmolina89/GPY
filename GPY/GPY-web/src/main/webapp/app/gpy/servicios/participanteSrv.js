/* 
 * Autor: Fernando Camargo S
 */
'use strict';

angular.module('participante.services')
	.factory('participanteSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'participante';
	    var datos = {};
			
	    datos.listar = function (OE) {
	        return $http.post(urlBase + '/listarParticipantesProyecto', OE);
	    };

	    datos.consultarPorId = function (OE) {
	        return $http.post(urlBase + '/consultarParticipante', OE);
	    };

	    datos.insertar = function (OE) {
	        return $http.post(urlBase + '/registrarParticipante', OE);
	    };
		
	    datos.actualizar = function (OE) {
	        return $http.post(urlBase + '/actualizarParticipante', OE);
	    };

	    datos.borrar = function (OE) {
	        return $http.post(urlBase + '/eliminarParticipante', OE);
	    };

	    return datos;
	}]);