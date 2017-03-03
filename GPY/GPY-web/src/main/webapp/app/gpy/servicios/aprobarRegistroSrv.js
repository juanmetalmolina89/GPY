/* 
 * Autor: ccepeda
 */
'use strict';

angular.module('aprobacionregistro.services')
	    .factory('aprobacionregistroSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd + 'preregistro';
            var urlBaseProy = urlBackEnd + 'aprobnacional';
    
	    var datos = {};

	    datos.listar = function (OE) {
	        return $http.post(urlBase+'/listarPoliticaProyecto', OE);
	    };

	    datos.actualizarProyecto = function (OE) {
	        return $http.post(urlBaseProy + '/cambiarEstado', OE);
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


