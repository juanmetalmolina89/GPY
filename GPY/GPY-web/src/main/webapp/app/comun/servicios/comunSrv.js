/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('comun.services')
        .service('comunSrv', ['$log', '$location', 'store', 'jwtHelper', function ($log, $location, store, jwtHelper) {

                toastr.options = {
                    'closeButton': true,
                    'debug': false,
                    'newestOnTop': false,
                    'progressBar': true,
                    'positionClass': 'toast-top-right',
                    'preventDuplicates': true,
                    'onclick': null,
                    'showDuration': '300',
                    'hideDuration': '1000',
                    'timeOut': '5000',
                    'extendedTimeOut': '1000',
                    'showEasing': 'swing',
                    'hideEasing': 'linear',
                    'showMethod': 'fadeIn',
                    'hideMethod': 'fadeOut'
                };

                this.mensaje = function (mensaje, tipo) {

                    //$log.log(mensaje.msgError);
                    $log.log(mensaje);
                    //toastr[tipo](mensaje.msgError, 'Gestor de Proyectos Ambientales');
                    toastr[tipo](mensaje, 'Gestor de Proyectos Ambientales');
                };

                this.mensajeSalida = function (respuesta) {

                    $log.log(respuesta);

                    var mensaje = respuesta.data.msgError || respuesta.statusText;

                    var tipoMsg = 'success';
                    if (respuesta.status !== 200)
                        tipoMsg = 'error';

                    toastr[tipoMsg](mensaje, 'Gestor de Proyectos Ambientales');
                };



                this.obtenerSesion = function () {
//                    return {'nombre': 'Nombre de Prueba', 'sub': USUARIOIDTEMP, 'idpersona': PERSONAIDTEMP, 'username': USERNAMETEMP, 'perfil': PERFILTEMP};


                    if (!isDebug) {
                        var sesion = null;
                        var token = store.get('token') || null;
                        if (!token) {
                            store.remove('token');
                            $location.path('/ingresar');
                        } else if (jwtHelper.isTokenExpired(token)) {
                            store.remove('token');
                            $location.path('/ingresar');
                        } else {
                            sesion = jwtHelper.decodeToken(token);
                        }
                        return sesion;
                    } else {
                        return {'nombre': 'nombre', 'sub': 0};
                    }
                };

                this.cerrarSesion = function () {

                    store.remove('token');
                    $location.path('/ingresar');
                };

                this.descargarArchivo = function (response) {

                    var headers = response.headers();
                    var contentDisposition = headers['content-disposition'];
                    var filename = this.obtenerNombreArchivo(contentDisposition);
                    var contentType = headers['content-type'];

                    var linkElement = document.createElement('a');
                    try {
                        var file = new Blob([response.data], {type: contentType});
                        var fileURL = URL.createObjectURL(file);

                        linkElement.setAttribute('href', fileURL);
                        linkElement.setAttribute("download", filename);

                        var clickEvent = new MouseEvent("click", {
                            "view": window,
                            "bubbles": true,
                            "cancelable": false
                        });
                        linkElement.dispatchEvent(clickEvent);
                    } catch (ex) {
                        console.log(ex);
                    }
                    
                                        
//                        //Otra opción es armar el archivo y mostrarlo en un objeto del navegador pero esto sólo funciona para PDF. (se deja el código por si deciden usarlo.                         
//                        //Así se arma el archivo
//                        var headers = response.headers();
//                        var contentDisposition = headers['content-disposition'];
//                        var filename = getFileNameFromHttpResponse(contentDisposition);
//                        var contentType = headers['content-type'];
//                        var file = new Blob([response.data], {type: contentType});
//                        var fileURL = URL.createObjectURL(file);
//                        return $sce.trustAsResourceUrl(fileURL);
//                        
//                        //En el controlador se recibiría así
//                        $scope.pdf = $sce.trustAsResourceUrl(fileURL);
//
//                        //En la vista se pondrí así
//                        <object data="{{content}}" type="application/pdf"></object>                   
                    
                    
                };

                this.obtenerNombreArchivo = function (contentDispositionHeader) {                
                    var result = contentDispositionHeader.split(';')[1].trim().split('=')[1];
                    return result.replace(/"/g, '');
                };

            }]);


