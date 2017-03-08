/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('politica.controllers', ['ngSanitize'])
        .controller('politicaCtrl', ['$scope', '$routeParams', 'comunSrv', 'listadoSrv','politicaSrv','$filter', function ($scope, $routeParams, comunSrv, listadoSrv, politicaSrv, $filter) {

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
                                $scope.listaPoliticas = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                $scope.cargarConfiguracion();

                $scope.marcar = function (scope) {
                    scope.toggle();
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;                  
                    $scope.OE.proyecto = new Object();
                    $scope.OE.proyecto.proyPoliticaList = [{"a007idpolitica":{"a003codigo": scope.$element["0"].childNodes[1].value},"a007idproyecto":{"a002codigo":$scope.pid}}];
                  
                    if(scope.$element["0"].childNodes[1].checked) 
                    {
                      //si lo seleccionó lo debe insertar
                          politicaSrv.registrarPolitica($scope.OE)
                              .then(function (response) {
                                  //$scope.listaPoliticas = response.data.respuesta;
                                  // en lugar de esto debe actualizar la lista de seleccionadas

                              }, function (error) {
                                  $scope.mensaje = error.data.respuesta;
                                  console.log($scope.mensaje);
                              });
                    }
                    else
                    {
                      //si lo desactivó lo debe eliminar
                            politicaSrv.eliminarPolitica($scope.OE)
                            .then(function (response) {
                                //$scope.listaPoliticas = response.data.respuesta;
                                // en lugar de esto debe actualizar la lista de seleccionadas

                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                    }

                };

                $scope.toggle = function (scope) {
                  scope.toggle();                  
                };

                $scope.verNodo = function (nodo) {
                  console.log(">>>>>>>>>>>"+JSON.stringify(nodo));
                };
                

                $scope.collapseAll = function () {
                  $scope.$broadcast('angular-ui-tree:collapse-all');
                };

                $scope.expandAll = function () {
                  $scope.$broadcast('angular-ui-tree:expand-all');
                };

                
                $scope.adicioanrHijo = function (hijo, padre) {
                  padre.items.push(hijo)
                };
                
                $scope.listarPoliticas = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    politicaSrv.listarPoliticas($scope.OE)
                            .then(function (response) {
                              
                                $scope.listaPoliticas = response.data.respuesta;
                                // ahora debemos traer las politicas del proyecto, 
                                // listarPoliticaProyecto
                                // recorrerlas y con ellas barrer el arbol para ponerle un nuevo atributo a las que estén seleccionadas.
                                // ese atributo es el id
                                // de esa forma queda el ciclo completo
                                
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                
                $scope.listarPoliticas();
   
  
            }]);





