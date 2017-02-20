/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('politica.controllers', ['ngSanitize'])
        .controller('politicaCtrl', ['$scope', '$routeParams', 'comunSrv', 'listadoSrv','politicaSrv', function ($scope, $routeParams, comunSrv, listadoSrv, politicaSrv) {

                console.log("Controller de politicas!!");
        
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;
                $scope.campoObligatorio = 'Campo obligatorio';
                
                $scope.mensaje;
                $scope.listaPoliticas = [];
                $scope.politica = [];

                $scope.cargarConfiguracion = function () {

                    $scope.objeto = {};
                    $scope.objeto.idUsuario = $scope.idUsuario;
                    $scope.objeto.idpoliticaproyecto = $scope.pid;
                    
                    politicaSrv.listar($scope.objeto)
                            .then(function (response) {
                                console.log(">>>>>>>>>>>"+JSON.stringify(response));
                                $scope.listaPoliticas = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                $scope.cargarConfiguracion();

                $scope.actualizar = function () {

                    politicaSrv.actualizar($scope.politica)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {

                    politicaSrv.insertar($scope.politica)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    politicaSrv.borrar($scope.politica.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }]);





