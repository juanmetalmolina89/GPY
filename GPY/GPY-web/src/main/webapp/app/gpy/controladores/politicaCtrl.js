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

                $scope.politicasP  = [];
                $scope.politicaPr = {};
                
                $scope.model = {
                        isDisabled: false
                };
                /**************************************************************/
                /**************************************************************/
                /*************        POLÍTICAS ARBOL          ****************/
                /**************************************************************/
                /**************************************************************/
                                

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
                  //console.log(">>>>>>>>>>>"+JSON.stringify(nodo));
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
                
                $scope.evaluar = function (dato) {
                  if(dato!==0)
                  {
                      return true;
                  }
                  else
                  {
                      return false;
                  }
                };
                
                $scope.listarPoliticas = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    politicaSrv.listarPoliticas($scope.OE)
                            .then(function (response) {                              
                                var r1 = response.data.respuesta;
                                $scope.OEP = {};
                                $scope.OEP.idUsuario = $scope.idUsuario;
                                $scope.OEP.idpoliticaproyecto = $scope.pid;
                                politicaSrv.listarPoliticaProyecto ($scope.OEP)
                                    .then(function (response) {
                                        var r2 = response.data.respuesta;

                                        angular.forEach( r1, function(val1){
                                            //promises.push(writeSome(value));
                                            val1.a007codigo = 0;
                                            angular.forEach( r2, function(val2){
                                                //promises.push(writeSome(value));                                                
                                                if(val2.a007idpolitica === val1.a003codigo)
                                                {
                                                    val1.a007codigo=val2.a007codigo;  // le adiciona el id del rompe
                                                }
                                            });                                            
                                        });
                                        
                                        $scope.listaPoliticas = r1;
                                                                                
                                    }, function (error) {
                                        $scope.mensaje = error.data.respuesta;
                                        console.log($scope.mensaje);
                                    });
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                
                
                /**************************************************************/
                /**************************************************************/
                /*************      POLÍTICAS PROPIAS          ****************/
                /**************************************************************/
                /**************************************************************/

                // manejo del formulario
                // viene con parámetro cuando se invoca desde el botón de actualizar de la grilla
                $scope.mostrarForm = function (estaPoliticaP) {				

                   if (estaPoliticaP != undefined && estaPoliticaP != null) 
                   {
                             $scope.politicaPr.a059idproyecto = $scope.pid;
                             $scope.politicaPr.a059descripcion = estaPoliticaP.a059descripcion;
                             $scope.politicaPr.a059codigo = estaPoliticaP.a059codigo;
                             //$scope.model.isDisabled = false;
                     } 
                     else 
                     {
                             $scope.politicaPr = new Object();
                             $scope.politicaPr.a059idproyecto = $scope.pid;
                             $scope.politicaPr.a059descripcion = "";
                    }
				
                };
                
                $scope.guardar = function () {				

                   if ($scope.politicaPr.a059codigo != undefined && $scope.politicaPr.a059codigo  != null) 
                   {
                        // update
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.politica = {};
                        $scope.OE.politica.a059codigo= $scope.politicaPr.a059codigo;
                        $scope.OE.politica.a059descripcion= $scope.politicaPr.a059descripcion;
                        $scope.OE.politica.a059idproyecto = {"a002codigo":$scope.pid};
                        
                        politicaSrv.actualizarPoliticaNueva($scope.OE)
                                .then(function (response) {
                                    $scope.listar();
                                    comunSrv.mensajeSalida(response);
                                }, function (error) {
                                    $scope.mensaje = error.data.respuesta;
                                    console.log($scope.mensaje);
                                });
                        $scope.mostrarForm();        
                        //$scope.model.isDisabled = false;
                     } 
                     else 
                     {
                        // nuevo
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.politica = {};
                        $scope.OE.politica.a059descripcion= $scope.politicaPr.a059descripcion;
                        $scope.OE.politica.a059idproyecto = {"a002codigo":$scope.pid};
                        
                        politicaSrv.registrarPoliticaNueva($scope.OE)
                                .then(function (response) {
                                    $scope.mensaje = 'Creada con éxito.';
                                    comunSrv.mensajeSalida(response);
                                    $scope.listar();

                                }, function (error) {
                                    $scope.mensaje = error.data.respuesta;

                                });
                        
                        $scope.mostrarForm();
                        //$scope.model.isDisabled = false;
                        return true;
                    }
				
                };
                
                
                
                $scope.cancelar = function () {	
                    $scope.mostrarForm();
                };
                
                $scope.eliminarPoliticaP = function (estaPoliticaP) {  
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;            
                    $scope.OE.a059codigo= estaPoliticaP.a059codigo;
                    politicaSrv.eliminarPoliticaNueva($scope.OE)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                comunSrv.mensajeSalida(response);
                                $scope.listar();

                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };



                $scope.listar = function () {                   

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a059idproyecto = $scope.pid;

                    politicaSrv.listarPoliticaNueva($scope.OE)
                            .then(function (response) {
                                $scope.politicasP = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                }; 

                $scope.listarPoliticas();
                $scope.listar();
  
            }]);





