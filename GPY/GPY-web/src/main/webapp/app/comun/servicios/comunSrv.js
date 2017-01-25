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




            }]);


