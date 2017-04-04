/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('datosBasicos.controllers', ['ngSanitize'])
        .controller('datosBasicosCtrl', ['$scope', '$routeParams', '$location', '$rootScope', 'datosBasicosSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'infoProyecto',
            function ($scope, $routeParams, $location, $rootScope, datosBasicosSrv, comunSrv, listadoSrv, avanceSrv, infoProyecto) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;

                $scope.proyecto = new Object();
                $scope.proyecto.a002tipproyct = {"a102codigo": $scope.tpid};
                $scope.alcances = [];
                $scope.ubicaciones = [];
                $scope.sectores = [];
                $scope.proyectosAsoc = [];                
                $scope.proySectrImplmntdrList = [];

                /**************************************************************/
                /* Métodos */

                $scope.guardarProyecto = function () {
                    if (($scope.tpid == NAMA || $scope.tpid == PBDBCRC) && ($scope.proySectrImplmntdrList.length==0))
                    {
                        comunSrv.mensaje("Debe seleccionar al menos un sector implementador", "error");
                    }
                    else
                    {
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.proyecto = $scope.proyecto;
                            delete $scope.OE.proyecto.coddivipola; // para no tener que alterar todos los SP
                            $scope.OE.proyecto.a002idusr = {"a041codigo": $scope.idUsuario};

                            $scope.proyecto.proySectrImplmntdrList = [];
                            for (var i = 0; i < $scope.proySectrImplmntdrList.length; i++) {
                                $scope.proyecto.proySectrImplmntdrList.push({"a006idsectrimplmntdr": {'a023codigo': $scope.proySectrImplmntdrList[i].a023codigo}});
                            }

                            //Si ya existe lo actualiza, de lo contrario lo registra
                            if ($scope.proyecto.a002codigo !== undefined && $scope.proyecto.a002codigo !== null && $scope.proyecto.a002codigo !== '') {

                                datosBasicosSrv.actualizarProyecto($scope.OE)
                                        .then(function (response) {
                                            comunSrv.mensajeSalida(response);
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
                            } else {

                                datosBasicosSrv.registrarProyecto($scope.OE)
                                        .then(function (response) {
                                            comunSrv.mensajeSalida(response);
                                            //registrar avance
                                            avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": response.data.respuesta[0].a002codigo, "a057idpantalla": $scope.pantalla})
                                                    .then(function (response) {
                                                        comunSrv.mensajeSalida(response);
                                                    }, function (error) {
                                                        comunSrv.mensajeSalida(error);
                                                    });
                                            //cambia la URL agregando el id del proyecto
                                            $location.path('/gpy/datbaspre/' + $scope.tpid + '/' + response.data.respuesta[0].a002codigo);
                                        }, function (error) {
                                            comunSrv.mensajeSalida(error);
                                        });
                            }

                    }        
                            
                            
                };

                $scope.listarAlcance = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = ALCANCE;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.alcances = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarUbicacion = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = UBICACION;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.ubicaciones = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarSectorImplementador = function (idtipproyct) {
                    if($scope.tpid == NAMA || $scope.tpid == PBDBCRC)
                    {
                        $scope.OES = new Object();
                        $scope.OES.idUsuario = $scope.idUsuario;
                        $scope.OES.A006IDPROYECTO = $scope.pid;
                        datosBasicosSrv.consultarSectImplPorIdProy($scope.OES).then(function (response) {
                            var seleccionados = response.data.respuesta;
                            
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.idtipproyct = {"a023codigo":$scope.tpid};
                            listadoSrv.listarSectorImplementador($scope.OE)
                                    .then(function (response) {
                                        $scope.sectores = response.data.respuesta;
                                        var sectores = response.data.respuesta;
                                        for (var i = 0; i < seleccionados.length; i++) {                                            
                                            for (var j = 0; j < sectores.length; j++) {
                                                if(seleccionados[i].a006idsectrimplmntdr == sectores[j].a023codigo)
                                                {
                                                    $scope.proySectrImplmntdrList.push(sectores[j]);
                                                }                                                
                                            }                                                                                        
                                        }
                                        
                                    }, function (error) {
                                        comunSrv.mensajeSalida(error);
                                    });
                            
                            //$scope.proyecto.proySectrImplmntdrList = {"a006idsectrimplmntdr": {'a023codigo': response.data.respuesta}};
                            
                        });
                    }                    
                                      
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
                
                $scope.listarTipoProyectoMDL = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOPROYECTOMDL;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposProyectoMDL = response.data.respuesta;

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };
                
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

                $scope.cancelar = function () {
                    $location.path('/gpy');
                };

                /* Comunicación entre controladores */
                //esta opción permite que desde otro controlador se llamen los métodos de este controlador
                //en este caso lo usamos para que gestionProyectosCtrl pueda inicializar los combos del proyecto que se va a editar
                var inicializador = $rootScope.$on("llamaInicializaDatosBasicos", function () {                    
                    $scope.proyecto = infoProyecto.proyecto; //la información del proyecto a editar está en el servicio infoProyecto y fue inicializado en gestionProyectosCtrl                   
                    $scope.cargaDepartamentos({"a020codpais": COLOMBIA});                    
                    $scope.listarSectorImplementador({"a023codigo": $scope.tpid});                    
                    $scope.consultarProyectoAsociado();
                    $scope.listarUbicacion();
                    $scope.listarAlcance();
                });
                //esto es para que destruya el listener (si no se pone se ejecuta varias veces)
                $scope.$on('$destroy', function () {
                    inicializador();
                });


                /* DIVIPOLA */
                $scope.departamentos = [];
                $scope.municipios = [];
                $scope.departamentoProySel = "";

                $scope.cargaDepartamentos = function (pais) {
                    if (pais !== undefined) {
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.paises = pais;
                        listadoSrv.listarDepartamentosPorPais($scope.OE)
                                .then(function (response) {
                                    $scope.departamentos = response.data.respuesta;

                                    //Selecciona el que venga en BD
                                    if ($scope.proyecto.a002loclzcn !== undefined) {
                                        angular.forEach($scope.departamentos, function (value, key) {
                                            if (value.a020coddepartamento === $scope.proyecto.a002loclzcn.a020coddepartamento) {
                                                $scope.departamentoProySel = value;
                                            }
                                        });
                                    }
                                    if ($scope.departamentoProySel.a020coddepartamento !== undefined && $scope.departamentoProySel.a020coddepartamento !== null)
                                        $scope.cargaMunicipios($scope.departamentoProySel);
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        $scope.departamentos = [];
                    }
                };

                $scope.cargaMunicipios = function (depto) {
                    if (depto !== undefined) {
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.departamento = depto;
                        listadoSrv.listarMunicipiosPorDepartamento($scope.OE)
                                .then(function (response) {
                                    $scope.municipios = response.data.respuesta;

                                    //Selecciona el que venga en BD
                                    if ($scope.proyecto.a002loclzcn !== undefined) {
                                        angular.forEach($scope.municipios, function (value, key) {
                                            if (value.a020codigo === $scope.proyecto.a002loclzcn.a020codigo) {
                                                $scope.proyecto.a002loclzcn = value;
                                            }
                                        });
                                    }
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        $scope.municipios = [];
                    }
                };

                /**************************************************************/
                /* Inicializar formulario */

                //Definir pantalla para registrar avance
                if ($location.path().substr(0, '/gpy/datbaspre/'.length) === '/gpy/datbaspre/') {
                    $scope.pantalla = DATOSBASICOSPRE;
                } else if ($location.path().substr(0, '/gpy/datbasreg/'.length) === '/gpy/datbasreg/') {
                    $scope.pantalla = DATOSBASICOSREG;
                    
                    // inicializa los combos nuevos para la etapa de registro
                    $scope.listarProcesosValidacion();
                    $scope.listarPeriodosAcreditacion();
                    $scope.listarTipoProyectoMDL();
                    $scope.listarEstandaresMVC(); 
                }

               
                
                //se cargan los combos, si no viene el id del proyecto, de lo contrario se cargaron al consultar la info del id del proyecto que se recibe
                if ($scope.pid == undefined) {
                    $scope.cargaDepartamentos({"a020codpais": COLOMBIA});
                    $scope.listarSectorImplementador({"a023codigo": $scope.tpid});
                    $scope.consultarProyectoAsociado();
                    $scope.listarUbicacion();
                    $scope.listarAlcance();
                }

            }]);

