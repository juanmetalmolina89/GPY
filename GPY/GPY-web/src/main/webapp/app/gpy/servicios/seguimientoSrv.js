/* 
 * Autor: Fernando Camargo
 */
'use strict';

angular.module('seguimiento.services')
	    .factory('seguimientoSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'infogeneral';
	    var datos = {};

	   datos.registrarInfoGeneral = function (OE) {
	        return $http.post(urlBase + '/registrarInfoGeneral', OE);
	    };

            datos.actualizarInfoGeneral = function (OE) {
	        return $http.post(urlBase + '/actualizarInfoGeneral', OE);
	    };
            
            datos.consultarInfoGeneral = function (OE) {
	        return $http.post(urlBase + '/consultarInfoGeneral', OE);
	    };
            
	    return datos;
	}]);


