/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('proyecto.controllers', ['ngSanitize'])
        .controller('proyectoCtrl', ['$scope', 'proyectoSrv', '$location', 'comunSrv', 'listadoSrv', function ($scope, proyectoSrv, $location, comunSrv, listadoSrv, $uibModal) {

                /**************************************************************/
                /* Manejo sesión */                
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;
                
                /**************************************************************/                
                /* Variables */
                $scope.mensaje;
                $scope.proyectos = [];
                $scope.proyecto = new Object();

                /**************************************************************/
                /* Métodos */

                /**************************************************************/
                /** DUMMY */

                $scope.listarProyectos = function () {
                    proyectoSrv.listarProyectos()
                            .then(function (response) {
                                $scope.listaProyectos = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.actualizar = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = idUsuario; 
                    $scope.OE.proyecto = $scope.proyecto;

                    proyectoSrv.actualizar($scope.OE)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = idUsuario; 
                    $scope.OE.proyecto = $scope.proyecto;

                    proyectoSrv.insertar($scope.OE)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.listarProyectosAsoc = function () {
                    proyectoSrv.listarProyectosAsoc($scope.proyecto.id)
                            .then(function (response) {
                                $scope.listaProyectosAsoc = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.consultarPorId = function (id) {

                    id = 1; //@todo esto es temporal

                    proyectoSrv.consultarPorId(id)
                            .then(function (response) {
                                $scope.proyecto = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

            }])

        ;

