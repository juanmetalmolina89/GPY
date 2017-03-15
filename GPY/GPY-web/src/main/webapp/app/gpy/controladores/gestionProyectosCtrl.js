var app = angular.module('GPYApp');

app.controller('gestionProyectosCtrl', function ($scope, $location, $routeParams, $uibModal, $rootScope, $filter, comunSrv, listadoSrv, datosBasicosSrv, infoProyecto, $q) {

    /**************************************************************/
    /* Manejo sesión */
    $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();

    $scope.idUsuario = $scope.sesion.sub;

    /**************************************************************/
    /* Variables */
    $scope.tipoProyectoSel = 0;
    $scope.tiposProyecto = [];
    $scope.listEstadosProyecto = [];
    $scope.listaAutoridadAmb = [];

    $scope.tpid = $routeParams.tpid;
    $scope.pid = $routeParams.pid;
    $scope.tp = new Object();

    $scope.proyectos = [];
    $scope.proyecto = new Object();
    $scope.proyecto.a002tipproyct = {"a102codigo": $scope.tpid};
    $scope.listaproyectos = [];
    $scope.filtroproyecto = {};
    $scope.filtroproyecto.palabra = "";
    $scope.filtroproyecto.tipoproy = "";
    $scope.filtroproyecto.autoridad = "";
    $scope.filtroproyecto.estadoproy = "";
    
    //dejar disponibles las constantes en la vista
    $scope.INVITADO = INVITADO;

    $scope.NUEVO = NUEVO;
    $scope.PREREGISTRO = PREREGISTRO;
    $scope.SOLMDL1 = SOLMDL1;
    $scope.APRMDL1 = APRMDL1;
    $scope.DEVUELTAMDL1 = DEVUELTAMDL1;
    $scope.SOLMDL3 = SOLMDL3;
    $scope.APRMDL3 = APRMDL3;
    $scope.DEVUELTAMDL3 = DEVUELTAMDL3;    
    $scope.REGISTRO = REGISTRO;
    $scope.SEGUIMIENTO = SEGUIMIENTO;
    $scope.RECHAZADO = RECHAZADO;
    $scope.SOLPRE = SOLPRE;
    $scope.SOLREG = SOLREG;
    $scope.APRREG = APRREG;
    $scope.DEVUELTAREG = DEVUELTAREG;

    $scope.MDL = MDL;
    $scope.MDL_POA = MDL_POA;
    $scope.NAMA = NAMA;
    $scope.PBDBCRC = PBDBCRC;
    $scope.CPA = CPA;

    $scope.FUNCMADS = FUNCMADS;
    $scope.ADMINAA = ADMINAA;
    $scope.GESTPROY = GESTPROY;
    $scope.PUBLICADOR = PUBLICADOR;
    $scope.INVITADO = INVITADO;

    $scope.totalItems = 0;
    $scope.currentPage = 1;
    $scope.itemsPerPage = 10;
    $scope.maxSize = 10;
    /**************************************************************/
    /* Métodos */


    $scope.consultarProyectoPorId = function (idProy) {
        var def = $q.defer();
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        $scope.OE.a002codigo = idProy;

        datosBasicosSrv.consultarProyectoPorId($scope.OE).then(function (response) {
            if (response.data.respuesta[0] !== undefined) {

                //Se valida que el tipo de proyecto corresponda, de lo contrario lo deja en la pantalla para crear uno nuevo (se puede dar el caso que el usuario modifique la URL)
                if ($scope.tpid != response.data.respuesta[0].a002tipproyct) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no válida.", "info");
                    $location.path('/gpy/datbaspre/' + $scope.tpid);
                    def.reject( 'error' );
                } else {

                    //setear los campos 
                    //info gral pre
                    $scope.proyecto.a002codigo = response.data.respuesta[0].a002codigo;
                    $scope.proyecto.a002estadoproyecto = response.data.respuesta[0].a002estadoproyecto;
                    $scope.proyecto.a002nombrproyct = response.data.respuesta[0].a002nombrproyct;
                    $scope.proyecto.a002descrpcinproyct = response.data.respuesta[0].a002descrpcinproyct;
                    $scope.proyecto.a002durcnprevst = response.data.respuesta[0].a002durcnprevst;
                    $scope.proyecto.a002vidautl = response.data.respuesta[0].a002vidautl;
                    $scope.proyecto.a002potnclestmdredccn = response.data.respuesta[0].a002potnclestmdredccn;
                    $scope.proyecto.a002nrocpas = response.data.respuesta[0].a002nrocpas;
                    $scope.proyecto.a002objtvgenrl = response.data.respuesta[0].a002objtvgenrl;
                    $scope.proyecto.a002socextrnjr = response.data.respuesta[0].a002socextrnjr;
                    $scope.proyecto.coddivipola = response.data.respuesta[0].coddivipola;
                    $scope.proyecto.a002proytascd = {
                        "a002codigo": response.data.respuesta[0].a002proytascd
                    };
                    $scope.proyecto.a002ubccn = {
                        "a102codigo": response.data.respuesta[0].a002ubccn
                    };
                    $scope.proyecto.a002loclzcn = {
                        "a020codigo": response.data.respuesta[0].a002loclzcn,
                        "a020nommunicipio": response.data.respuesta[0].a020nommunicipio,
                        "a020coddepartamento": response.data.respuesta[0].a020coddepartamento,
                        "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento,
                        "a020divipola": response.data.respuesta[0].coddivipola
                    };
                    $scope.proyecto.a002idalcance = {
                        "a102codigo": response.data.respuesta[0].a002idalcance
                    };

                    //@todo faltan los sectores implementadores

                    //info MDL etp1 pre
                    $scope.proyecto.a002nombrproyctingls = response.data.respuesta[0].a002nombrproyctingls;
                    $scope.proyecto.a002tecnlgcontmpld = response.data.respuesta[0].a002tecnlgcontmpld;
                    //$scope.proyecto.a002idsectoralscope = response.data.respuesta[0].a002idsectoralscope;
                   $scope.proyecto.a002idsectoralscope = {
                        "a102codigo": response.data.respuesta[0].a002idsectoralscope
                    };

                    //info MDL etp2 pre
                    $scope.proyecto.a002idmetdlgmdl = {
                        "a028codigo": response.data.respuesta[0].a002idmetdlgmdl
                    };
                    $scope.proyecto.a002idescala = {
                        "a102codigo": response.data.respuesta[0].a002idescala
                    };

                    //info gral reg 
                    $scope.proyecto.a002idproyctmdl = {
                        "a102codigo": response.data.respuesta[0].a002idproyctmdl
                    };
                    
                    $scope.proyecto.a002idestndrmercdvolntr = {
                        "a102codigo": response.data.respuesta[0].a002idestndrmercdvolntr
                    };
                    
                    $scope.proyecto.a002idtipperdacrdtcn = {
                        "a102codigo": response.data.respuesta[0].a002idtipperdacrdtcn
                    };
                    
                    $scope.proyecto.a002idestdprocsvaldcn = {
                        "a102codigo": response.data.respuesta[0].a002idestdprocsvaldcn
                    };
                   
                    $scope.proyecto.a002procsvaldcnec = response.data.respuesta[0].a002procsvaldcnec ;
                    $scope.proyecto.a002fechinicio = new Date(response.data.respuesta[0].a002fechinicio) ;
                    $scope.proyecto.a002fechfin = new Date(response.data.respuesta[0].a002fechfin) ;
                    $scope.proyecto.a002aplicmercdvolntr = response.data.respuesta[0].a002aplicmercdvolntr ;
 
 
 
                    //para el manejo del proyecto a lo largo de las pantallas
                    $scope.estadoProy = $scope.proyecto.a002estadoproyecto;
                    infoProyecto.proyecto = $scope.proyecto;
                    def.resolve( true );
                }                
            }
            //inicializa combos
            var rutaDatosBasicos = '/gpy/datbaspre/';
            if ($location.path().substr(0, rutaDatosBasicos.length) === rutaDatosBasicos) {
                $rootScope.$emit("llamaInicializaDatosBasicos", {});
            }
            rutaDatosBasicos = '/gpy/datbasreg/';
            if ($location.path().substr(0, rutaDatosBasicos.length) === rutaDatosBasicos) {
                $rootScope.$emit("llamaInicializaDatosBasicos", {}); // ver si es necesario otro para registro
            }

        }, function (error) {
            comunSrv.mensajeSalida(error);
            console.log(error.data.respuesta);
            def.reject( 'error' );
        });
        return def.promise;
    };

    //Ventana modal para elegir el tipo del proyecto nuevo
    $scope.eligeTipoProyModal = function (size) {
        //Si es invitado debe pedir autenticación
        if ($scope.sesion.perfil == INVITADO) {
            comunSrv.mensaje("Para gestionar proyectos debe iniciar sesión como un usuario autorizado", "info");
            $location.path('/ingresar');
        } else {

            var eligeTipoProyModalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'app/gpy/vistas/tipoProyModal.html',
                controller: 'modalTipoProyCtrl',
                size: size,
                resolve: {
                    tiposProyecto: function () {
                        return $scope.tiposProyecto;
                    }
                }
            });

            eligeTipoProyModalInstance.result.then(function (seleccionado) {
                $scope.tipoProyectoSel = seleccionado;
                $location.path('/gpy/datbaspre/' + $scope.tipoProyectoSel);
            }, function () {

            });
        }
    };

    $scope.listarTiposProyectos = function () {
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        $scope.OE.categoria = TIPOPROYECTO;
        listadoSrv.listarParametros($scope.OE)
                .then(function (response) {
                    $scope.tiposProyecto = response.data.respuesta;

                    angular.forEach($scope.tiposProyecto, function (value, key) {
                        if (value.a102codigo == $scope.tpid) {
                            $scope.tp = value;
                        }
                    });
                }, function (error) {
                    comunSrv.mensajeSalida(error);
                });
    };
    $scope.listarEstadosProyectos = function () {
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        $scope.OE.categoria = "ESTADOPROYECTO";
        listadoSrv.listarParametros($scope.OE)
                .then(function (response) {
                    $scope.listEstadosProyecto = response.data.respuesta;
                }, function (error) {
                    comunSrv.mensajeSalida(error);
                });
    };
    $scope.listarAutoridadAmbiental = function () {
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        listadoSrv.listarAutoridades($scope.OE)
                .then(function (response) {
                    $scope.listaAutoridadAmb = response.data.respuesta;
                    if ($scope.sesion.perfil == PUBLICADOR)
                    {
                        $scope.listaAutoridadAmb = $filter("filter")( $scope.listaAutoridadAmb, {'a001codigo':parseInt($scope.sesion.autoridadambiental)},true);
                       
                    }
                }, function (error) {
                    comunSrv.mensajeSalida(error);
                });
    };

    /**************************************************************/
    /* Inicializar formulario */
    //se listan los tiposde proyecto para la ventana modal
    $scope.listarTiposProyectos();
    $scope.listarEstadosProyectos();
    $scope.listarAutoridadAmbiental();

    //si no han seleccionado el tipo de proyectos está en el listado de proyectos
    if ($scope.tpid == undefined) {
        //@todo Aquí listar proyectos CU GPY_001

    }

    //si viene el id del proyecto se debe consultar la información, de lo contrario se entiende que es un proyecto nuevo
    if ($scope.pid != undefined) {
        $scope.consultarProyectoPorId($scope.pid);
    } else {
        $scope.estadoProy = NUEVO;
    }


    $scope.listarTodosLosProyectosUsuario = function () {
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        $scope.OE.a041codigo = $scope.idUsuario;
        datosBasicosSrv.listarProyectosUsuario($scope.OE)
                .then(function (response) {
                    $scope.listaproyectos = response.data.respuesta;
                    $scope.proyectos = response.data.respuesta;
                    $scope.totalItems = $scope.proyectos.length;
                }, function (error) {
                    comunSrv.mensajeSalida(error);
                });
    };
    $scope.listarTodosLosProyectosUsuario();

    $scope.verdalleproy = function (proyecto) {
        $scope.tpid = proyecto.a002tipproyct;
        console.log('url redireccion: >>>> /gpy/datbaspre/' + proyecto.a002tipproyct + '/' + proyecto.a002codigo);
        $location.path('/gpy/datbaspre/' + proyecto.a002tipproyct + '/' + proyecto.a002codigo);
        $scope.consultarProyectoPorId(proyecto.a002codigo);
    };

    //invoca un servicio para cambio de estado del proyecto
    $scope.cambiarEstado = function (proyecto, nuevoEstado) {
        var def = $q.defer();
        $scope.OE = {};
        $scope.OE.idUsuario = $scope.idUsuario;        
        $scope.OE.a002codigo = proyecto.a002codigo;
        $scope.OE.estadoproyecto = nuevoEstado;
        datosBasicosSrv.cambiarEstado($scope.OE)
            .then(function (response) {
                response.data.msgError = 'Se ha enviado la solicitud con éxito.';
                comunSrv.mensajeSalida(response);
                $scope.listarTodosLosProyectosUsuario();
                console.log($scope.mensaje);
                def.resolve( true );
            }, function (error) {
                $scope.mensaje = error.data.respuesta;
                console.log($scope.mensaje);
                def.reject( 'error' );
            });
        return def.promise;
     };

    // validar la activación de botones
    $scope.habilitarLink = function (opcion, proyecto) {
        var respuesta = false;
        switch(opcion) {
            case "SOLMDL1": // usuario solicita aprobación del MDL1
                if ((($scope.sesion.perfil == GESTPROY) || ($scope.sesion.perfil == PUBLICADOR)) && ((proyecto.a002tipproyct == MDL) || (proyecto.a002tipproyct == MDL_POA)) && ((proyecto.idestadoproyecto == PREREGISTRO) || (proyecto.idestadoproyecto == DEVUELTAMDL1)) )
                {
                    respuesta = true;
                }                
                break;
            case "SOLMDL3": // usuario solicita aprobación del MDL3
                if ((($scope.sesion.perfil == GESTPROY) || ($scope.sesion.perfil == PUBLICADOR)) && ((proyecto.a002tipproyct == MDL) || (proyecto.a002tipproyct == MDL_POA)) && ((proyecto.idestadoproyecto == APRMDL1) || (proyecto.idestadoproyecto == DEVUELTAMDL3)))
                {
                    respuesta = true;
                }

                break;
            case "SOLPRE": // usuario solicita aprobación del prerregistro ( pasar a fase de registro)
                if (($scope.sesion.perfil == GESTPROY) || ($scope.sesion.perfil == PUBLICADOR))                            
                {
                    if (((proyecto.a002tipproyct == MDL) || (proyecto.a002tipproyct == MDL_POA)) && (proyecto.idestadoproyecto == APRMDL3)) 
                    {
                        respuesta = true;                        
                    }
                    if((proyecto.a002tipproyct !== MDL) && (proyecto.a002tipproyct !== MDL_POA) && (proyecto.idestadoproyecto == PREREGISTRO))
                    {
                        respuesta = true;
                    }                     
                }

                break;
            case "SOLREG": // usuario solicita aprobación del registro (pasar a fase de proyecto)
                if ((($scope.sesion.perfil == GESTPROY) || ($scope.sesion.perfil == PUBLICADOR)) && ((proyecto.idestadoproyecto == REGISTRO) || (proyecto.idestadoproyecto == DEVUELTAREG)) )
                {
                    respuesta = true;
                }

                break;
            case "GESMDL1": // MADS va a gestionar la aprobación de un MDL1 (puede aprobar y pasa a aprobadomdl1 o rechazarmdl1)
                if ((($scope.sesion.perfil == FUNCMADS) || ($scope.sesion.perfil == ADMINAA))&& (proyecto.idestadoproyecto == SOLMDL1))
                {
                    respuesta = true;
                }

                break;  
            case "GESMDL3": // MADS va a gestionar la aprobación de un MDL3 (puede aprobar y pasa a aprobadomdl3 o rechazarmdl3)
                if ((($scope.sesion.perfil == FUNCMADS) || ($scope.sesion.perfil == ADMINAA))&& (proyecto.idestadoproyecto == SOLMDL3))
                {
                    respuesta = true;
                }

                break;
            case "GESPRE": // MADS va a gestionar la aprobación de un prerregistro (puede aprobar y pasa a registro, o rechazar)
                if ((($scope.sesion.perfil == FUNCMADS) || ($scope.sesion.perfil == ADMINAA))&& (proyecto.idestadoproyecto == SOLPRE))
                {
                    respuesta = true;
                }

                break;
            case "GESREG": // MADS va a gestionar la aprobación de un registro (puede aprobar y pasa a proyecto o rechazar)
                if ((($scope.sesion.perfil == FUNCMADS) || ($scope.sesion.perfil == ADMINAA))&& (proyecto.idestadoproyecto == SOLREG))
                {
                    respuesta = true;
                }

                break;  
             default:
                respuesta = false;
        } 
        return respuesta;
    };
    
    // arma el link para redirigir las acciones
    $scope.procesarLink = function (opcion, proyecto) {
        var respuesta = "";
        switch(opcion) {
            case "SOLMDL1": // usuario solicita aprobación del MDL1
                // invoca un servicio de cambio de estado   
                $scope.cambiarEstado(proyecto,SOLMDL1);
                break;
            case "SOLMDL3": // usuario solicita aprobación del MDL3                
                // invoca un servicio de cambio de estado
                $scope.cambiarEstado(proyecto,SOLMDL3);
                break;
            case "SOLPRE": // usuario solicita aprobación del prerregistro ( pasar a fase de registro)
                // invoca un servicio de cambio de estado
                $scope.cambiarEstado(proyecto,SOLPRE);
                break;
            case "SOLREG": // usuario solicita aprobación del registro (pasar a fase de proyecto)
                // invoca un servicio de cambio de estado
                $scope.cambiarEstado(proyecto,SOLREG);
                break;
            case "GESMDL1": // MADS va a gestionar la aprobación de un MDL1 (puede aprobar y pasa a aprobadomdl1 o rechazarmdl1)
                // redirige al formulario de MDL1, en donde le deben aparecer dos botones (aprobar, rechazar) en lugar del guardado
                $location.path('/gpy/etapa1pre/' + proyecto.a002tipproyct + '/' + proyecto.a002codigo);
                break;  
            case "GESMDL3": // MADS va a gestionar la aprobación de un MDL3 (puede aprobar y pasa a aprobadomdl3 o rechazarmdl3)
                // redirige al formulario de MDL3, en donde le deben aparecer dos botones (aprobar, rechazar) en lugar del guardado
                $location.path('/gpy/etapa3pre/' + proyecto.a002tipproyct + '/' + proyecto.a002codigo);
                break;
            case "GESPRE": // MADS va a gestionar la aprobación de un prerregistro (puede aprobar y pasa a registro, o rechazar)
                // redirige al formulario de aprobar
                $location.path('/gpy/aprobacionpre/' + proyecto.a002tipproyct + '/' + proyecto.a002codigo);
                break;
            case "GESREG": // MADS va a gestionar la aprobación de un registro (puede aprobar y pasa a proyecto o rechazar)
                // redirige al formulario de aprobar
                $location.path('/gpy/aprobacionreg/' + proyecto.a002tipproyct + '/' + proyecto.a002codigo);
                break;  
             default:
                respuesta = false;
        } 
        return respuesta;
    };
    
    
    
    $scope.filtrarProyectos = function () {
        $scope.filtroproyecto.resultados = $scope.proyectos;
        $numFiltros = 0;
        if ($scope.filtroproyecto.palabra) {
            //$scope.filtroproyecto.filtro = $scope.filtroproyecto.palabra;
            $scope.filtroproyecto.resultados = $filter('filter')($scope.filtroproyecto.resultados , {'a002nombrproyct':$scope.filtroproyecto.palabra});
            $numFiltros++;
        }
        if ($scope.filtroproyecto.autoridad) {
            //$scope.filtroproyecto.filtro = $scope.filtroproyecto.autoridad.a001nombre;
            $scope.filtroproyecto.resultados = $filter('filter')($scope.filtroproyecto.resultados , {'a001sigla':$scope.filtroproyecto.autoridad.a001sigla}, true);
             $numFiltros++;
        }
        if ($scope.filtroproyecto.tipoproy) {
            //$scope.filtroproyecto.filtro = $scope.filtroproyecto.tipoproy.a102valorcorto;
            $scope.filtroproyecto.resultados = $filter('filter')($scope.filtroproyecto.resultados , {'tipoproyecto':$scope.filtroproyecto.tipoproy.a102valorcorto},true);
             $numFiltros++;
        }
        if ($scope.filtroproyecto.estadoproy) {
            //$scope.filtroproyecto.filtro = $scope.filtroproyecto.estadoproy.a102valor;
             $scope.filtroproyecto.resultados = $filter('filter')($scope.filtroproyecto.resultados , {'estadoproyecto':$scope.filtroproyecto.estadoproy.a102valor},true);
              $numFiltros++;
        }
        
         //if ($scope.filtroproyecto.resultados.length !== $scope.listaproyectos.length) {
         if( $numFiltros !== 0) {
             $scope.listaproyectos = $scope.filtroproyecto.resultados;
             $scope.totalItems = $scope.listaproyectos.length;
         } else {
            $scope.listarTodosLosProyectosUsuario();
        }

    };



})
        .controller('modalTipoProyCtrl', function ($scope, $uibModalInstance, $location, tiposProyecto) {

            $scope.tiposProyecto = tiposProyecto;
            $scope.tipoProyectoSel = {index: 0};
            $scope.mostrarError = false;

            $scope.ok = function () {
                if ($scope.tipoProyectoSel.index === 0) {
                    $scope.mostrarError = true;
                } else {
                    $uibModalInstance.close($scope.tipoProyectoSel.index);
                }
            };

            $scope.cancel = function () {
                $uibModalInstance.dismiss('cancel');
                $location.path('/gpy');
            };
        })
        ;