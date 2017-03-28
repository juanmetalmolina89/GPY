/* 
 * Autor: Fernando Camargo
 */
'use strict';

angular.module('seguimiento.controllers', ['ngSanitize'])
        .controller('seguimientoCtrl', ['$scope', 'seguimientoSrv','infoProyecto', 'comunSrv', '$route', '$routeParams','listadoSrv','datosBasicosSrv','financiacionSrv' , function ($scope, seguimientoSrv, infoProyecto, comunSrv, $route, $routeParams, listadoSrv, datosBasicosSrv, financiacionSrv) {

                $scope.mensaje;
                $scope.avance = {}; 
                $scope.pantalla = 22;
                $scope.formEnviado = false;
                $scope.tiposInstrumentos = [];
                $scope.instrumentos = [];
                $scope.editarFuente=false; 
                $scope.tpid = $routeParams.tpid;

                // busca un seguimiento previo   
                $scope.consultarInfoGeneral = function () {  
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a013idproyecto = $scope.pid;
                    
                    seguimientoSrv.consultarInfoGeneral($scope.OE)
                        .then(function (response) {
                            if(response.data.respuesta.length>0)
                            {
                                $scope.avance = response.data.respuesta[0];
                                $scope.avance.a013fechavncproyct = new Date($scope.avance.a013fechavncproyct);
                                $scope.avance.a013fechreprt = new Date($scope.avance.a013fechreprt);
                            }
                           
                         }, function (error) {
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                };

                $scope.guardarInfoGeneral = function () {
                    if(!$scope.avance.a013fechavncproyct)
                    {
                        $scope.avance.a013fechavncproyct= new Date();
                    }
                    
                    if($scope.avance.a013codigo) // existe el id?
                    {
                        // si: es un update
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.avanceproyecto = $scope.avance;                       
                        seguimientoSrv.actualizarInfoGeneral($scope.OE)
                        .then(function (response) {
                            //$scope.mensaje = 'fuente actualizada con éxito.';
                            //response.data.msgError = 'Se ha enviado la solicitud con éxito.';
                            
                            // pegar esta llamada para procesar el envío.
                            $scope.$broadcast ('procesar');
                            comunSrv.mensajeSalida(response);
                         }, function (error) {
                            $scope.formEnviado = true;
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                    }
                    else
                    {
                        // no: es un insert
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.avanceproyecto = $scope.avance;
                        $scope.OE.avanceproyecto.a013idproyecto = {"a002codigo":$scope.pid};
                        $scope.OE.avanceproyecto.a013idarchv = {"a026codigo":1};
                        
                        seguimientoSrv.registrarInfoGeneral($scope.OE)
                        .then(function (response) {
                           //$scope.mensaje = 'fuente actualizada con éxito.';
                   
                            // pegar esta llamada para procesar el envío.
                            $scope.$broadcast ('procesar');
                            comunSrv.mensajeSalida(response);
                         }, function (error) {
                            $scope.formEnviado = true;
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                    }
                    
                    // se guarda también el proyecto. No importa que sea asíncrono
                    $scope.OEp = new Object();
                    $scope.OEp.idUsuario = $scope.idUsuario;
                    $scope.OEp.proyecto = $scope.proyecto;
                    delete $scope.OEp.proyecto.coddivipola; // para no tener que alterar todos los SP
                    $scope.OEp.proyecto.a002idusr = {"a041codigo": $scope.idUsuario};
                    datosBasicosSrv.actualizarProyecto($scope.OEp)
                        .then(function (response) {
                            comunSrv.mensajeSalida(response);                          
                        }, function (error) {
                            comunSrv.mensajeSalida(error);
                        });
                    
                };
                                               
                
                $scope.ActualizarDatosDeProyecto = function () {
                    //hace un update a los campos del proyecto desde $scope.proyecto
                    
                };
                
                /**************************** llenado de listas ***********************************/
                  
                $scope.listarEstandaresMVC = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = STANDARMRCDOVOL;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposEstandarMVC = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                
                $scope.listarPeriodosAcreditacion = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOPERIODOACREDITA;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposPeriodo = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                $scope.listarProcesosValidacion = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = ESTADOPROCSVALIDA;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.estadosPV = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                $scope.consultarProyectoAsociado = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002tipproyct = $scope.tpid;
                    $scope.OE.a002codigo = $scope.pid;

                    datosBasicosSrv.consultarProyectoAsociado($scope.OE)
                            .then(function (response) {
                                $scope.proyectos = response.data.respuesta;

                                //Se arma el listado con el id y el nombre del proyecto, ya que el resto de campos generan conflicto con el obj de entrada
                                angular.forEach($scope.proyectos, function (value, key) {
                                    if ($scope.pid != undefined && $scope.pid != null && $scope.pid == value.a002codigo) {
                                        //Si estamos editando un proyecto, no debe traer como proyecto asociado a sí mismo
                                    } else {
                                        $scope.proyectosAsoc.push({"a002codigo": value.a002codigo, "a002nombrproyct": value.a002nombrproyct});
                                    }
                                });
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                
                /**************************** fuentes de financiación  ***********************************/
                
               
                $scope.listarTiposInstrumentos = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOINSTRUFINAN;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposInstrumentos = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
                $scope.listarInstrumentosFinanciacion = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a009idproyecto = $scope.pid;
					
                    financiacionSrv.listarInstrumentos($scope.OE)
                            .then(function (response) {
                                $scope.instrumentos = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                
                $scope.mostrarForm = function (instrumento) {
                    $scope.editarFuente=true; 
                    
                };
                
                $scope.eliminarInstrumento = function (instrumento) {
                    $scope.editarFuente=false; 
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a009codigo = instrumento.a009codigo;
					
                    financiacionSrv.borrarInstrumento($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response); 
                                $scope.listarInstrumentosFinanciacion();
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                
                
                
                

                $scope.guardarInstrumento = function () {
                    $scope.editarFuente=false;   
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.instrumentofinanciacion = new Object();
                    
                    $scope.OE.instrumentofinanciacion.a009idtipinstrmntf = $scope.instrumento.a009idtipinstrmntf;
                    $scope.OE.instrumentofinanciacion.a009idproyecto = {"a002codigo":$scope.pid};					
                    $scope.OE.instrumentofinanciacion.a009porfinnccnestmd = $scope.instrumento.a009porfinnccnestmd;
                                      
                    financiacionSrv.insertarInstrumento($scope.OE)
                        .then(function (response) {
                                comunSrv.mensajeSalida(response); 
                                $scope.instrumentofinanciacion=[];
                                $scope.listarInstrumentosFinanciacion();
                                console.log($scope.mensaje);
                        }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                        }); 
			
                };
                
                
                $scope.cancelar = function () {
                    $scope.editarFuente=false;                    
                };
                
                
               /**************************** inicialización ***********************************/
                 
                if (infoProyecto.proyecto=="")
                {                    
                    $scope.$parent.consultarProyectoPorId($scope.pid)
                        .then(function (response) {
                            $scope.proyecto = $scope.$parent.proyecto;
                         }, function (error) {
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                }
                else
                {
                    $scope.proyecto = infoProyecto.proyecto;
                }
                
                $scope.listarProcesosValidacion();
                $scope.listarEstandaresMVC(); 
                
                $scope.consultarInfoGeneral();
                $scope.listarTiposInstrumentos();
                $scope.listarInstrumentosFinanciacion();
                $scope.listarPeriodosAcreditacion();
                
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
            }]);



