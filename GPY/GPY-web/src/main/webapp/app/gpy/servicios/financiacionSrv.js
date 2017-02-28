/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('financiacion.services')
	    .factory('financiacionSrv', ['$http', function($http) {

	    var urlBase = urlBackEnd+'financiacion';
	    var datos = {};
                        
            datos.guardarInformacion = function (OE) {
	        return $http.post(urlBase + '/registrarCostosProyecto', OE);
	    };
            
            datos.cargarCostos = function (OE) {
	        return $http.post(urlBase + '/listarCostosProyecto', OE);
	    };
            
            datos.cargarFuentes = function (OE) {
	        return $http.post(urlBase + '/listarFtesFinanc', OE);
	    };
            
            datos.eliminarFuenteFinanciacion = function (OE) {
	        return $http.post(urlBase + '/eliminarFtesFinanc', OE);
	    };
            
            datos.insertarInstrumento = function (OE) {
	        return $http.post(urlBase + '/registrarInstrmntFinnccnP', OE);
	    };
             
            datos.listarInstrumentos = function (OE) {
	        return $http.post(urlBase + '/listarInstrmntFinnccnP', OE);
	    };
            
	    datos.listar = function () {
	        return $http.get(urlBase);
	    };
            
            datos.borrarInstrumento = function (OE) {
	        return $http.post(urlBase + '/eliminarInstrmntFinnccnP', OE);
	    };

            
	    datos.consultarPorId = function (id) {
	        return $http.get(urlBase + '/' + id);
	    };

	    

	    datos.actualizar = function (financiacion) {
	        return $http.put(urlBase + '/' + financiacion.id, financiacion);
	    };

	    datos.borrar = function (id) {
	        return $http.delete(urlBase + '/' + id);
	    };

	    return datos;
	}]);





