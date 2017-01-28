var app = angular.module('GPYApp');

app.controller('gestionProyectosCtrl', function ($scope, $location, $routeParams, $uibModal, $rootScope, comunSrv, listadoSrv, datosBasicosSrv, infoProyecto) {

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

    //dejar disponibles las constantes en la vista
    $scope.INVITADO = INVITADO;
    $scope.NUEVO = NUEVO;
    $scope.PREREGISTRO = PREREGISTRO;
    $scope.REGISTRO = REGISTRO;
    $scope.SEGUIMIENTO = SEGUIMIENTO;
    $scope.MDL = MDL;
    $scope.MDL_POA = MDL_POA;
    $scope.NAMA = NAMA;
    $scope.PBDBCRC = PBDBCRC;
    $scope.CPA = CPA;

    /**************************************************************/
    /* Métodos */


    $scope.consultarProyectoPorId = function (idProy) {
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        $scope.OE.a002codigo = idProy;

        datosBasicosSrv.consultarProyectoPorId($scope.OE).then(function (response) {

            if (response.data.respuesta[0] !== undefined) {

                //Se valida que el tipo de proyecto corresponda, de lo contrario lo deja en la pantalla para crear uno nuevo (se puede dar el caso que el usuario modifique la URL)
                if ($scope.tpid != response.data.respuesta[0].a002tipproyct) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no válida.", "info");
                    $location.path('/gpy/datbaspre/' + $scope.tpid);
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
                        "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento
                    };
                    $scope.proyecto.a002idalcance = {
                        "a102codigo": response.data.respuesta[0].a002idalcance
                    };

                    //@todo faltan los sectores implementadores

                    //info MDL etp1 pre
                    $scope.proyecto.a002nombrproyctingls = response.data.respuesta[0].a002nombrproyctingls;
                    $scope.proyecto.a002tecnlgcontmpld = response.data.respuesta[0].a002tecnlgcontmpld;
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

                    //para el manejo del proyecto a lo largo de las pantallas
                    $scope.estadoProy = $scope.proyecto.a002estadoproyecto;
                    infoProyecto.proyecto = $scope.proyecto;
                }
            }
            //inicializa combos
            var rutaDatosBasicos = '/gpy/datbaspre/';
            if ($location.path().substr(0, rutaDatosBasicos.length) === rutaDatosBasicos) {
                $rootScope.$emit("llamaInicializaDatosBasicos", {});
            }

        }, function (error) {
            comunSrv.mensajeSalida(error);
            console.log(error.data.respuesta);
        });
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

    $scope.listaproyectos = [];

    $scope.listarTodosLosProyectosUsuario = function () {
        $scope.OE = new Object();
        $scope.OE.idUsuario = $scope.idUsuario;
        $scope.OE.a041codigo = $scope.idUsuario;
        datosBasicosSrv.listarProyectosUsuario($scope.OE)
                .then(function (response) {
                    $scope.listaproyectos = response.data.respuesta;
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

    $scope.filtroproyecto = {};

    $scope.filtrarProyectos = function () {

        if ($scope.filtroproyecto.palabra) {
            $scope.filtroproyecto.filtro = $scope.filtroproyecto.palabra;
        }
        if ($scope.filtroproyecto.autoridad) {
            $scope.filtroproyecto.filtro = $scope.filtroproyecto.autoridad.a001nombre;
        }
        if ($scope.filtroproyecto.tipoproy) {
            $scope.filtroproyecto.filtro = $scope.filtroproyecto.tipoproy.a102valorcorto;
        }
        if ($scope.filtroproyecto.estadoproy) {
            $scope.filtroproyecto.filtro = $scope.filtroproyecto.estadoproy.a102valor;
        }

        if ($scope.filtroproyecto.filtro) {
            $scope.OE = new Object();
            $scope.OE.idUsuario = $scope.idUsuario;
            $scope.OE.idUsuario = $scope.idUsuario;
            $scope.OE.filtro = $scope.filtroproyecto.filtro;
            console.log(JSON.stringify($scope.filtroproyecto));

            datosBasicosSrv.listarProyectosFiltro($scope.OE)
                    .then(function (response) {
                        $scope.listaproyectos = response.data.respuesta;
                        $scope.filtroproyecto = {};
                    }, function (error) {
                        comunSrv.mensajeSalida(error);
                    });
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