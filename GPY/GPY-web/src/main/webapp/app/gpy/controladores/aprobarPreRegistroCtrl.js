/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('aprobarprereg.controllers', ['ngSanitize'])
        .controller('aprobarpreregCtrl', ['$scope', '$routeParams', 'comunSrv', 'listadoSrv', 'aprobarPreRegSrv', function ($scope, $routeParams, comunSrv, listadoSrv, aprobarPreRegSrv) {

                console.log("Controller de aprobare pre registro!!");

                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;
                $scope.campoObligatorio = 'Campo obligatorio';

                $scope.mensaje;
                $scope.listaPoliticas = [];
                $scope.aprobarPreReg = {};

                $scope.listadoEstados = [];
                $scope.estadoAprobado = {};
                $scope.estadoRechazado = {};

                //como los estados del proyecto parametricos
                $scope.listarEstadosProyecto = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = 'ESTADOPROYECTO';
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.listadoEstados = response.data.respuesta;
                                if ($scope.listadoEstados && $scope.listadoEstados.length > 0) {
                                    for (var i = 0; i < $scope.listadoEstados.length; i++) {
                                        if ($scope.listadoEstados[i].a102valor === 'Aprobado')
                                        {
                                            $scope.estadoAprobado = $scope.listadoEstados[i];
                                        } else {
                                            if ($scope.listadoEstados[i].a102valor === 'Rechazado')
                                            {
                                                $scope.estadoRechazado = $scope.listadoEstados[i];
                                            }
                                        }
                                    }
                                }

                                console.log(JSON.stringify($scope.estadoAprobado));
                                console.log(JSON.stringify($scope.estadoRechazado));
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });



                };

                $scope.formEnviado = false;
                $scope.listarEstadosProyecto();
                // idProyecto, idAdjnt, idUsuario, numrradcd
                $scope.regdocumento = {};

                $scope.guardar = function (form) {

                    

                    if (form.$valid) {
                        $scope.regdocumento.idProyecto = $scope.pid;
                        $scope.regdocumento.idUsuario = $scope.idUsuario;
                        
                        console.log(">>>>" + JSON.stringify($scope.regdocumento));

                        aprobarPreRegSrv.actualizarProyecto($scope.regdocumento)
                                .then(function (response) {
                                    $scope.mensaje = 'Actualizado con éxito.';
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
            }]);





