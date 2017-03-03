/* 
 * Autor: Fernando Camargo S
 */
'use strict';

angular.module('aprobacionNacional.controllers', ['ngSanitize'])
        .controller('aprobacionNacionalCtrl', ['$scope', '$routeParams', 'comunSrv', 'datosBasicosSrv', '$route', function ($scope,  $routeParams, comunSrv, datosBasicosSrv, $route) {

                $scope.REGISTRO = REGISTRO;
                $scope.RECHAZADO = RECHAZADO;
                $scope.APRREG = APRREG;
                $scope.DEVUELTAREG = DEVUELTAREG;

                $scope.FUNCMADS = FUNCMADS;
                $scope.ADMINAA = ADMINAA;
                $scope.GESTPROY = GESTPROY;
                $scope.PUBLICADOR = PUBLICADOR;
                $scope.INVITADO = INVITADO;

                $scope.pantalla = 17;
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;
                $scope.campoObligatorio = 'Campo obligatorio';

                $scope.mensaje;
                $scope.listaPoliticas = [];

                $scope.formEnviado = false;


                
                $scope.guardar = function (form) {
                    
                    comunSrv.mensajeInfo("Por favor, espere un instante mientras se procesa la subida al servidor.");
                    if (form.$valid) {
                        
                        // pegar esta llamada para procesar el envío.
                        $scope.$broadcast ('procesar');
                        $scope.OE = {};                      
                    } else {                        
                    }
                };
                
                //pegar este método para verificar cuándo se hayan subido correctamente los archivos.
                $scope.$on('procesado', function(event, args) {
                    if(args.resultado === true)
                    {
                        $scope.formEnviado = true;                       
                        comunSrv.mensajeOk("Archivos almacenados correctamente");
                        $route.reload();
                    }
                    else
                    {
                        $scope.formEnviado = false;                       
                        comunSrv.mensajeInfo("No se ha completado el envío. Intente de nuevo por favor");                        
                    }
                });

                
                
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
