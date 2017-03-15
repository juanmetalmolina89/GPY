/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('usuario.controllers', ['ngSanitize'])
        .controller('crearUsuarioCtrl', ['$scope', '$location', 'usuarioSrv', 'listadoSrv', 'comunSrv', '$filter', function ($scope, $location, usuarioSrv, listadoSrv, comunSrv, $filter) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                if ($scope.sesion.perfil == INVITADO || $scope.sesion.perfil == PUBLICADOR || $scope.sesion.perfil == GESTPROY ) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no permitida", "info");
                    $location.path('/gpy');
                }

                /**************************************************************/
                /* Variables */
                $scope.usuarios = [];
                $scope.usuario = new Object();
                $scope.persona = new Object();
                $scope.tiposDoc = [];
                $scope.tiposPersona = [];
                $scope.autoridades = [];
                $scope.NATURAL = NATURAL;
                $scope.JURIDICA = JURIDICA;
                
                if($scope.sesion.perfil == ADMINAA)
                {
                    $scope.perteneceAA = true;
                    $scope.terminos = true;                    
                    $scope.bloqueado = true;
                }
                else
                {
                    $scope.perteneceAA = false;
                    $scope.terminos = false;  
                    $scope.bloqueado = false;
                }
                
               
                /**************************************************************/
                /* Métodos */
                $scope.cambiarTipoPersona = function (tipo) {
                    if(tipo.a102codigo == JURIDICA)
                    {
                        $scope.bloqueado = true;
                    }
                    else
                    {
                        if(($scope.sesion.perfil == ADMINAA) || ($scope.sesion.perfil == FUNCMADS))
                        {                 
                            $scope.bloqueado = false;
                        }
                        else
                        {  
                            $scope.bloqueado = true;
                        }
                    }                    
                }
                
                $scope.registrarUsuario = function () {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;

                    $scope.usuario.a041username = 'GPY' + $scope.persona.a052numrdocmnt;
                    $scope.usuario.a041clave = $scope.persona.a052numrdocmnt; /** @TODO cifrar */

                    if ($scope.perteneceAA === false) {
                        $scope.persona.a052identidad = {};
                    }

                    $scope.OE.persona = $scope.persona;
                    $scope.OE.usuario = $scope.usuario;

                    usuarioSrv.registrarUsuario($scope.OE)
                            .then(function (response) {
                                response.data.msgError += ". Puede ingresar con el usuario " + $scope.usuario.a041username +" y la clave " + $scope.usuario.a041clave 
                                comunSrv.mensajeSalida(response );
                                $scope.usuario = new Object();
                                $scope.persona = new Object();
                                
                            }, function (error) {
                                error.statusText += ". Este usuario ya se encuentra registrado en la base de datos"
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.muestraAA = function () {
                    if ($scope.perteneceAA === true) {
                        $scope.perteneceAA = false;
                    } else {
                        $scope.perteneceAA = true;
                    }
                };

                $scope.listarTipoDocumento = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.tipodocumento = $scope.persona.a052idtippersn;
                    $scope.cambiarTipoPersona($scope.persona.a052idtippersn);
                    listadoSrv.listarTipoDocumento($scope.OE)
                            .then(function (response) {
                                $scope.tiposDoc = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoPersona = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOPERSONA;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposPersona = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarAutoridades = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    listadoSrv.listarAutoridades($scope.OE)
                            .then(function (response) {
                                $scope.autoridades = response.data.respuesta;
                                if($scope.sesion.perfil == ADMINAA)
                                {    
                                    $scope.filtro = $filter("filter")( $scope.autoridades, {'a001codigo':parseInt($scope.sesion.autoridadambiental)},true);
                                    $scope.persona.a052identidad = $scope.filtro[0];
                                }
                                    
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /**************************************************************/
                /* Inicializar formulario */
                $scope.listarTipoPersona();
                $scope.listarAutoridades();


            }])

        .controller('ingresoUsuarioCtrl', ['$scope', '$location', '$uibModal', 'usuarioSrv', 'comunSrv', 'store', function ($scope, $location, $uibModal, usuarioSrv, comunSrv, store) {


                /**************************************************************/
                /* Variables */
                $scope.usuario = new Object();
                $scope.OE = new Object();
                $scope.OE.idUsuario = 0;


                /**************************************************************/
                /* Métodos */

                //Método de ingreso al sistema
                $scope.validarUsuario = function () {
                    $scope.OE.username = $scope.usuario.username;
                    $scope.OE.clave = $scope.usuario.clave;
                    usuarioSrv.validarUsuario($scope.OE)
                            .then(function (response) {
                                //console.log(response);
                                if (response.data.codError === 0) {
                                    store.set('token', response.headers('token'));
                                    $location.path('/gpy');
                                } else {
                                    store.remove('token');
                                }
                                comunSrv.mensajeSalida(response);
                                //@todo revisar lo del primer ingreso

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                                store.remove('token');
                            });
                };


                //Ventana modal para mostrar información de autoridades ambientales
                $scope.infoAutoridadesModal = function (size) {

                    $uibModal.open({
                        animation: true,
                        templateUrl: 'app/adm/vistas/infoAutoridadesModal.html',
                        controller: 'infoAutoridadesModalCtrl',
                        size: size,
                        resolve: {}
                    });

                };


                //Ingreso como invitado
                $scope.invitado = function () {
                    $scope.usuario.username = "INVITADO";
                    $scope.usuario.clave = "1nv174d063570R";
                    $scope.validarUsuario();
                };

            }])

        .controller('cambiarContrasenaCtrl', ['$scope', '$location', 'usuarioSrv', 'comunSrv', function ($scope, $location, usuarioSrv, comunSrv) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                if ($scope.sesion.perfil == INVITADO) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no permitida", "info");
                    $location.path('/gpy');
                }

                /**************************************************************/
                /* Variables */
                $scope.claves = new Object();

                //Método para cambiar la clave
                $scope.cambiarContrasena = function () {

                    if ($scope.claves.a041clavenueva === $scope.claves.a041clavenuevarep) {

                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.usuario = {
                            "a041codigo": $scope.idUsuario,
                            "a041username": $scope.sesion.username
                        };
                        $scope.OE.a041claveant = $scope.claves.a041claveant; // @todo este debe ecriptarse
                        $scope.OE.a041clavenueva = $scope.claves.a041clavenueva; // @todo este debe ecriptarse

                        usuarioSrv.cambiarContrasena($scope.OE)
                                .then(function (response) {
                                    comunSrv.mensajeSalida(response);
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        comunSrv.mensaje("Las claves no coinciden", "error");
                    }
                };
            }])

        .controller('infoAutoridadesModalCtrl', ['$scope', 'listadoSrv','$uibModalInstance','comunSrv', function ($scope, listadoSrv, $uibModalInstance, comunSrv) {

            $scope.ok = function () {
                $uibModalInstance.dismiss('cancel');
            };
            
            
                $scope.listarAutoridades = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario ="1";
                    listadoSrv.listarAutoridades($scope.OE)
                            .then(function (response) {
                                $scope.autoridades = response.data.respuesta;                              
                                    
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /**************************************************************/
                /* Inicializar formulario */
                $scope.listarAutoridades();
        }]);