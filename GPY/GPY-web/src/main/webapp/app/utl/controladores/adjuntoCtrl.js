/* 
 * Autor: Fernando Camargo S
 * * se utiliza dentro de un ng-include sí que hace referencia al $scope.$parent.$parent
 */
'use strict';

angular.module('adjunto.controllers', ['ngSanitize'])
        .controller('adjuntoCtrl', ['$scope', 'adjuntoSrv','adjuntoUploadSrv','comunSrv','$q', function ($scope, adjuntoSrv,adjuntoUploadSrv,comunSrv, $q ) {

                $scope.mensaje;
                $scope.idUsuario = $scope.$parent.$parent.idUsuario;
                $scope.pid = $scope.$parent.$parent.pid;
                $scope.pantalla = $scope.$parent.$parent.pantalla;
                $scope.tpid = $scope.$parent.$parent.tpid;
        
                $scope.adjuntos = [];
                $scope.adjunto = [];
                $scope.listarAdjuntos = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.$parent.$parent.idUsuario;
                    $scope.OE.a002tipproyct = $scope.$parent.$parent.tpid;
                    $scope.OE.a0025idpantalla = $scope.$parent.$parent.pantalla;
                    $scope.adjuntos = [];
                    $scope.filtro={"idUsuario":$scope.OE.idUsuario ,"filtro":" NVL(A008IDPROYECTO," + $scope.pid + ") = " + $scope.pid +" AND A025IDPANTALLA=" + $scope.pantalla + " AND A025IDTIPPROYCT=" + $scope.tpid }; 
                    adjuntoSrv.consultarAdjuntoPorFiltro($scope.filtro)
                            .then(function (response) {
                                for(var i=0; i< response.data.respuesta.length; i++) {
                                    var respuesta = response.data.respuesta[i];
                                    respuesta.radicado = respuesta.a008numrradcd
                                    if(respuesta.a026nomarchivo)
                                    {
                                        respuesta.mostrarUpload = false;                                       
                                    }
                                    else
                                    {
                                        respuesta.mostrarUpload = true;
                                    }
                                    $scope.adjuntos.push(respuesta);
                                    //$scope.filtro={"idUsuario":$scope.idUsuario ,"filtro":"A008IDPROYECTO=" + $scope.pid +" AND A008IDADJNT= " + response.data.respuesta[i].a025codigo};
                                }
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.guardarAdjuntos = function () {
                    /* esto no funciona asincrono. para confirmar al usuario debemos esperar a que pasen todos los archivos*/
                    /*
                    angular.forEach($scope.adjuntos, function (value, key) {
                        if(value.adjunto)
                        {
                            $scope.registrarAdjunto(value)
                                .then(function (response) {
                                    def.resolve( true )
                                }, function (error) {
                                    def.reject( 'error' );
                                });
                        }
                    });
                    */
                   var def = $q.defer();
                   $scope.adjuntos.reduce(function(p, value) {
                        return p.then(function() {
                            if(value.adjunto)
                            {
                                $scope.registrarAdjunto(value)
                            }
                        });
                    }, Promise.resolve()).then(function(finalResult) {
                        def.resolve( true )
                    }, function(err) {
                        def.reject( 'error' );
                    });
                    return def.promise;
                };

                $scope.registrarAdjunto = function (adjunto) {
                    var def = $q.defer();
                    adjuntoUploadSrv.registrarAdjunto(adjunto.adjunto, $scope.idUsuario, $scope.pid, adjunto.radicado, adjunto.a025codigo)
                            .then(function (response) {
                                def.resolve( true )
                            }, function (error) {
                                def.reject( 'error' );
                            });
                    return def.promise;
                };
                
                adjuntoUploadSrv.consultarSoportePorId = function (archivo) {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002codigo = parseInt($scope.pid);
                    $scope.OE.a008idadjunto = parseInt(archivo.a008idadjnt);

                    adjuntoSrv.consultarSoportePorId($scope.OE).then(function (response) {
                        //Se llama método de utilería que descarga del archivo
                        comunSrv.descargarArchivo(response);
                        //comunSrv.mensajeSalida(response);
                    }, function (error) {
                        comunSrv.mensajeSalida(error);
                    });
                };
                
                $scope.mostrarCampoUpload = function (adjunto, mostrar) {
                    adjunto.mostrarUpload = mostrar;
                };
           
                $scope.listarAdjuntos();
                
                $scope.$on('procesar', function(event, args) {  
                    // cuando reciba la petición, procese
                    $scope.guardarAdjuntos()
                        .then(function (response) {
                                // cuando termine, emita un mensaje con "true" que recibirá el parent        
                                $scope.$emit('procesado', {
                                    resultado:true
                                });
                            }, function (error) {
                                // cuando termine, emita un mensaje con "false" que recibirá el parent         
                                $scope.$emit('procesado', {
                                    resultado: false
                                });
                            });
                });


            }]);



