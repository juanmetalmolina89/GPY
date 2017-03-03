/* 
 * Autor: Fernando Camargo S
 */
'use strict';

angular.module('aprobacionregistro.controllers', ['ngSanitize'])
        .controller('aprobacionregistroCtrl', ['$scope', '$routeParams', 'comunSrv', 'datosBasicosSrv', function ($scope,  $routeParams, comunSrv, datosBasicosSrv) {

                $scope.REGISTRO = REGISTRO;
                $scope.RECHAZADO = RECHAZADO;
                $scope.APRREG = APRREG;
                $scope.DEVUELTAREG = DEVUELTAREG;

                $scope.FUNCMADS = FUNCMADS;
                $scope.ADMINAA = ADMINAA;
                $scope.GESTPROY = GESTPROY;
                $scope.PUBLICADOR = PUBLICADOR;
                $scope.INVITADO = INVITADO;

                $scope.pantalla = 21;
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;
                $scope.campoObligatorio = 'Campo obligatorio';

                $scope.mensaje;
                $scope.listaPoliticas = [];

                $scope.formEnviado = false;


                // idProyecto, idAdjnt, idUsuario, numrradcd
                $scope.guardar = function (form) {

                    if (form.$valid) { 
                        $scope.$broadcast ('procesar'); // procesa los archivos en el scope hijo
                        $scope.OE = {};
                        $scope.OE.idUsuario = $scope.idUsuario;        
                        $scope.OE.a002codigo = $scope.proyecto.a002codigo;
                        $scope.OE.estadoproyecto = $scope.proyecto.a002estadoproyecto;
                        datosBasicosSrv.cambiarEstado($scope.OE)
                            .then(function (response) {
                                response.data.msgError = 'Se ha cambiado el estado.';
                                comunSrv.mensajeSalida(response);
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);      
                            });

                    } else {
                        $scope.formEnviado = true;                       
                        comunSrv.mensajeInfo("Ingrese la información marcada como obligatoria *");
                    }
                };
                
                
                // este archivo puede ser accedido sin entrar a datos básicos, cpor lo cual no está precargada la información del proyecto.
                // es necesario traerla:                
                if (!$scope.proyecto.a002estadoproyecto)
                {                    
                    $scope.$parent.consultarProyectoPorId($scope.pid)
                        .then(function (response) {
                            $scope.proyecto = $scope.$parent.proyecto;
                         }, function (error) {
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                }
                
            }]);
