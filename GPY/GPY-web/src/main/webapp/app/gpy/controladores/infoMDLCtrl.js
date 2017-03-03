/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('infoMDL.controllers', ['ngSanitize'])
        .controller('infoMDLCtrl', ['$scope', '$routeParams', '$location', 'infoMDLSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'adjuntosMDLSrv', 'infoProyecto','datosBasicosSrv', function ($scope, $routeParams, $location, infoMDLSrv, comunSrv, listadoSrv, avanceSrv, adjuntosMDLSrv, infoProyecto, datosBasicosSrv) {

                $scope.ADMINAA = ADMINAA;
                $scope.FUNCMADS = FUNCMADS;
                $scope.INVITADO = INVITADO;
                $scope.GESTPROY = GESTPROY;
                $scope.PUBLICADOR = PUBLICADOR;


                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.tpid = $routeParams.tpid;//@todo preguntar por el funcionamiento de estos dos
                $scope.pid = $routeParams.pid;

                if ($scope.tpid != MDL && $scope.tpid != MDL_POA && $scope.tpid != CPA) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no válida para el tipo de proyecto que está gestionando", "info");
                    $location.path('/gpy/datbaspre/' + $scope.tpid + '/' + $scope.pid);
                }

                $scope.sectoralScopes = [];
                $scope.escalas = [];
                $scope.metodologiasMDL = [];
                $scope.adjuntos = [];


                /**************************************************************/
                /**************************************************************/
                /* Métodos */

                /* Operaciones con registros */

                //invoca un servicio para cambio de estado del proyecto
                $scope.cambiarEstado = function (nuevoEstado) {
                    $scope.OE = {};
                    $scope.OE.idUsuario = $scope.idUsuario;        
                    $scope.OE.a002codigo = $scope.pid;
                    $scope.OE.estadoproyecto = nuevoEstado;
                    datosBasicosSrv.cambiarEstado($scope.OE)
                        .then(function (response) {
                            response.data.msgError = 'Se ha enviado la solicitud con éxito.';
                            comunSrv.mensajeSalida(response);
                            $scope.listarTodosLosProyectosUsuario();
                            console.log($scope.mensaje);
                        }, function (error) {
                            $scope.mensaje = error.data.respuesta;
                            console.log($scope.mensaje);
                        });
                 };
                
                $scope.registrarConsiderac = function () {
                    $scope.OE = {};
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.proyecto = {}; //$scope.proyecto;
                    $scope.OE.proyecto.a002codigo = $scope.pid;
                    delete $scope.OE.proyecto.coddivipola; // para no tener que alterar todos los SP
                    infoMDLSrv.registrarConsiderac($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                                //guardar adjuntos
                                $scope.guardarAdjuntos();
                                //registrar avance
                                avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                        .then(function (response) {
                                            comunSrv.mensajeSalida(response);
                                        }, function (error) {
                                            comunSrv.mensajeSalida(error);
                                        });

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.registrarCartaNObj = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.proyecto = $scope.proyecto;
                    delete $scope.OE.proyecto.coddivipola; // para no tener que alterar todos los SP
                    infoMDLSrv.registrarCartaNObj($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                                //guardar adjuntos
                                $scope.guardarAdjuntos();

                                //registrar avance
                                avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                        .then(function (response) {
                                            comunSrv.mensajeSalida(response);
                                        }, function (error) {
                                            comunSrv.mensajeSalida(error);
                                        });
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.registrarAutorizacionEntCoord = function () {
                    //guardar adjuntos
                    $scope.guardarAdjuntos();

                    //registrar avance
                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });


                };
                $scope.gestionarConsiderac = function (aprobar) {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    if(aprobar===true)
                    {
                        $scope.$parent.cambiarEstado($scope.proyecto,APRMDL1 )
                            .then(function (response) {
                                $location.path('/gpy/');
                             }, function (error) {
                                $location.path('/gpy/');
                            });      
                    }
                    else
                    {
                        $scope.$parent.cambiarEstado($scope.proyecto,DEVUELTAMDL1);                        
                    }
                    // Hacer lo mismo para gestionar autorizacion de Entidad Coordinadora
                };


                /* Operaciones de consulta de listas */


                $scope.listarSectoralScopes = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = SECTORAL;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.sectoralScopes = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarEscalas = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = ESCALA;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.escalas = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarMetdMDL = function () {
                    //para poder listar las metodologías MDL debe conocer la escala y el sector
                    //primero valida que existan los objetos
                    if (($scope.proyecto.a002idescala != undefined || $scope.proyecto.a002idescala != null) && ($scope.proyecto.a002idsectoralscope != undefined || $scope.proyecto.a002idsectoralscope)) {
                        //luego valida que existan los id dentro de los objetos
                        if (($scope.proyecto.a002idescala.a102codigo != undefined || $scope.proyecto.a002idescala.a102codigo != null) && ($scope.proyecto.a002idsectoralscope.a102codigo != undefined || $scope.proyecto.a002idsectoralscope.a102codigo)) {
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.a028idescl = $scope.proyecto.a002idescala.a102codigo;
                            $scope.OE.a028idsectoralscope = $scope.proyecto.a002idsectoralscope.a102codigo;
                            listadoSrv.listarMetdMDL($scope.OE)
                                    .then(function (response) {
                                        $scope.metodologiasMDL = response.data.respuesta;
                                    }, function (error) {
                                        comunSrv.mensajeSalida(error);
                                    });
                        }
                    }
                };

                /* Operaciones con adjuntos */

                $scope.listarAdjuntos = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002tipproyct = $scope.tpid;
                    $scope.OE.a0025idpantalla = $scope.pantalla;
                    $scope.adjuntos = [];
                    $scope.filtro={"idUsuario":$scope.idUsuario ,"filtro":" NVL(A008IDPROYECTO," + $scope.pid + ") = " + $scope.pid +" AND A025IDPANTALLA=" + $scope.pantalla + " AND A025IDTIPPROYCT=" + $scope.tpid }; //7: Consideración temprana (mdl1)
                    infoMDLSrv.consultarAdjuntoPorFiltro($scope.filtro)
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

                    angular.forEach($scope.adjuntos, function (value, key) {
                        if(value.adjunto)
                        {
                            $scope.registrarAdjunto(value);
                        }
          

                    });
                };

                $scope.registrarAdjunto = function (adjunto) {

                    adjuntosMDLSrv.registrarAdjunto(adjunto.adjunto, $scope.idUsuario, $scope.pid, adjunto.radicado, adjunto.a025codigo)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };                               
                
                $scope.consultarSoportePorId = function (archivo) {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002codigo = parseInt($scope.pid);
                    $scope.OE.a008idadjunto = parseInt(archivo.a008idadjnt);

                    infoMDLSrv.consultarSoportePorId($scope.OE).then(function (response) {
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
                
                /**************************************************************/
                /* Inicializar formulario */
                
                // este archivo puede ser accedido sin entrar a datos básicos, cpor lo cual no está precargada la información del proyecto.
                // es necesario traerla:                
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
                
                if ($location.path().substr(0, '/gpy/etapa1pre/'.length) === '/gpy/etapa1pre/') {
                    //etapa 1
                    $scope.pantalla = MDLETP1PRE;
                    $scope.listarSectoralScopes();
                } else if ($location.path().substr(0, '/gpy/etapa2pre/'.length) === '/gpy/etapa2pre/') {
                    //etapa 2
                    $scope.pantalla = MDLETP2PRE;
                    $scope.listarEscalas();
                    $scope.listarMetdMDL();
                
                } else if ($location.path().substr(0, '/gpy/etapa3pre/'.length) === '/gpy/etapa3pre/') {
                    //etapa 2
                    $scope.pantalla = MDLETP3PRE;
                }
                $scope.listarAdjuntos();
                $scope.numAdjuntos = $scope.adjuntos.length;

            }]);



