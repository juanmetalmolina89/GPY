/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('adjunto.services')
    .factory('adjuntoSrv', ['$http', function($http) {

	    var datos = {};

            datos.consultarAdjuntoPorFiltro = function (OE) {
                return $http.post(urlBackEnd + 'datosMdl/consultarAdjuntoPorFiltro', OE);
            };

            datos.consultarSoportePorId = function (OE) {
                return $http.post(urlBackEnd + 'datosMdl/consultarAdjuntoPorId', OE, {responseType: 'arraybuffer'});
            };


	    return datos;
	}])
    
    .service('adjuntoUploadSrv', ['Upload', function (Upload) {

                var urlBase = urlBackEnd + 'datosMdl';

                this.registrarAdjunto = function (adjunto, idUsuario, idProyecto, numrradcd, idAdjnt) {
                    return Upload.upload({
                        method: 'POST',
                        url: urlBase + '/registrarAdjunto',
                        data: {file: adjunto, 'idUsuario': idUsuario, 'idProyecto': idProyecto, 'numrradcd': numrradcd, 'idAdjnt': idAdjnt}
                    });
                };

            }]);

