/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('reporte.controllers', ['ngSanitize'])
        .controller('reporteCtrl', ['$scope', 'reporteSrv', 'listadoSrv','comunSrv' , '$filter',  function ($scope, reporteSrv, listadoSrv, comunSrv, $filter) {

                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();

                $scope.mensaje;
                $scope.reporte = []; 
                $scope.idUsuario = $scope.sesion.sub;
                
                $scope.listarAutoridadAmbiental = function () {
                       $scope.OE = new Object();
                       $scope.OE.idUsuario = $scope.idUsuario;
                       listadoSrv.listarAutoridades($scope.OE)
                               .then(function (response) {
                                   $scope.listaAutoridadAmb = response.data.respuesta;
                                   if ($scope.sesion.perfil !== PUBLICADOR)
                                   {
                                       $scope.listaAutoridadAmb = $filter("filter")( $scope.listaAutoridadAmb, {'a001codigo':parseInt($scope.sesion.autoridadambiental)},true);
                                   }
                               }, function (error) {
                                   comunSrv.mensajeSalida(error);
                               });
                   };
                

                $scope.abrirReporte = function (reporte) {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario=$scope.idUsuario;
                    $scope.OE.a103codigo=reporte.a103codigo;
                    $scope.OE.anio=$scope.anio;

                    if(!$scope.autoridad) 
                    {
                        $scope.OE.a001codigo=-1;
                    }
                    else
                    { 
                        $scope.OE.a001codigo=$scope.autoridad.a001codigo;
                    }
                    
                    reporteSrv.reporteGeneral($scope.OE)
                           .then(function (response) {
                               comunSrv.descargarArchivo(response);
                           }, function (error) {
                               comunSrv.mensajeSalida(error);
                           });
                };
                 
                $scope.listarReportes = function () {
                       $scope.OE = new Object();
                       $scope.OE.idUsuario = $scope.idUsuario;
                       $scope.tiposReporte = [];
                       $scope.reportes = [];
                       $scope.OE.categoria = TIPOREPORTE;
                       // trae todos los tipos de reportes
                       listadoSrv.listarParametros($scope.OE)
                               .then(function (response) {
                                   // ahora sí trae los reportes
                                   $scope.tiposReporte = response.data.respuesta;
                                   $scope.OE2 = new Object();
                                   $scope.OE2.idUsuario = $scope.idUsuario;
                                    reporteSrv.listarReportes($scope.OE2)
                                        .then(function (response) {
                                            $scope.reportes = response.data.respuesta;
                                        }, function (error) {
                                            comunSrv.mensajeSalida(error);
                                        });
                          
                               }, function (error) {
                                   comunSrv.mensajeSalida(error);
                               });
                   };
                   
                // lista las autoridades ambientales, apra el filtro
                $scope.listarAutoridadAmbiental();
                
                // llena los reportes
                $scope.listarReportes();
            }]);


