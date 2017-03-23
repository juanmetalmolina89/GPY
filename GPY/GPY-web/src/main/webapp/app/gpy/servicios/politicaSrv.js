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
	        return $http.post( urlBase + '/listarPoliticaProyecto', OE);
	    };
            
            // POLITICAS PROPIAS QUE SOLO ATAÑEN AL PROYECTO
            
            datos.registrarPoliticaNueva = function (OE) {
	        return $http.post( urlBase + '/registrarPoliticaNueva', OE);
	    };
            
            datos.actualizarPoliticaNueva = function (OE) {
	        return $http.post( urlBase + '/actualizarPoliticaNueva', OE);
	    };
            
            datos.eliminarPoliticaNueva = function (OE) {
	        return $http.post( urlBase + '/eliminarPoliticaNueva', OE);
	    };
            
            datos.listarPoliticaNueva = function (OE) {
	        return $http.post( urlBase + '/listarPoliticaNueva', OE);
	    };
            
            datos.consultarSoportePorId = function (OE) {
                    //return $http.post(urlBackEnd + 'representante' + '/consultarDocumento', OE, {responseType: 'arraybuffer'});
                    return $http.post(urlBackEnd + 'representante' + '/consultarDocumento', OE);
                };
                
	    return datos;
	}])
        .service('politicaAdjuntoSrv', ['Upload', function (Upload) {

                var urlBase = urlBackEnd + 'politica';
        
                this.registrarAdjunto = function (idProyecto, adjunto, idUsuario) {
                    return Upload.upload({
                        method: 'POST',
                        url: urlBase + '/registrarAdjuntarPolitica',
                        data: {file: adjunto, 'idProyecto': idProyecto, 'idUsuario': idUsuario}
                    });
                };                          
                

            }]);
;

