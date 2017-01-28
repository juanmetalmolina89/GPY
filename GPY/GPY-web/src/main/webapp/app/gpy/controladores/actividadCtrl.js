/* 
 * Autor: Yeimmy Lee
 */
'use strict';
angular.module('actividad.controllers', ['ngSanitize'])
        .controller('actividadCtrl', ['$scope', '$routeParams', '$location', '$window', 'actividadSrv', 'soporteActividadSrv', 'comunSrv', 'listadoSrv', 'avanceSrv', 'grillaSrv', 'infoProyecto', function ($scope, $routeParams, $location, $window, actividadSrv, soporteActividadSrv, comunSrv, listadoSrv, avanceSrv, grillaSrv, infoProyecto) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.tpid = $routeParams.tpid; //@todo preguntar por el funcionamiento de estos dos
                $scope.pid = $routeParams.pid;


                $scope.actividad = new Object();
                $scope.actividad.a005idproyecto = {"a002codigo": $scope.pid};
                $scope.actividad.a005idsoporte = {"a026codigo": '', "a026nomarchivo": ''};
                $scope.geometria = {"a042idproyecto": $scope.pid, "a042nrositio": 1, "a042geometriaSitio": '', "a042geometriaIntersecc": ''};
                $scope.soporte = {'adjunto': ''};

                $scope.actividades = [];
                $scope.tiposActividades = [];
                $scope.tiposActivReduccion = [];
                $scope.categoriaMitigacion = '';

                $scope.muestraForm = false;
                $scope.muestraListTpActRed = false;
                $scope.muestraCampoSoporte = false;

                //grilla
                $scope.busquedaOE = {'palabraClave': ''};
                $scope.totalItems = 0;
                $scope.currentPage = 1;
                $scope.itemsPerPage = 5;
                $scope.maxSize = 5;


                /**************************************************************/
                /* Métodos */

                $scope.guardarActividad = function () {

                    //@todo Aquí validar geometria
                    if (true) {
                        //valida que exista o haya elegido un adjunto
                        if ($scope.actividad.a005idsoporte.a026codigo != '' || $scope.soporte.adjunto != '') {
                            //Empieza a armar el objeto de entrada
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.actividad = $scope.actividad;
                            $scope.OE.actividad.a005idtipactvdd = {"a022codigo": $scope.actividad.a005idtipactvdd.a022codigo}; //Sólo necesito el id (si envío el obj completo voy a tener problemas con el valor tipproyctmdl que se trae para mostrarse, pero no pertenece a la entidad como tal.                    
                            $scope.OE.geometria = $scope.geometria;

                            //@todo esto es sólo para poder continuar con las pruebas
                            $scope.OE.geometria = {"a042idproyecto": {"a002codigo": 1}, "a042nrositio": 1};
                            $scope.OE.a042geometriasitio = {"type": "Feature",
                                "properties": {},
                                "geometry": {
                                    "type": "Polygon",
                                    "coordinates": [
                                        [
                                            [-73.2843017578125, 2.9759559359447683],
                                            [-72.9547119140625, 2.213194532293419],
                                            [-71.4166259765625, 2.7784514150468644],
                                            [-71.202392578125, 2.180259769681356],
                                            [-70.675048828125, 2.8442900428132867],
                                            [-72.432861328125, 3.5298694189563014],
                                            [-73.2843017578125, 2.9759559359447683]
                                        ]
                                    ]
                                }
                            };
                            $scope.OE.a042geometriaintersec = {
                                "Prueba": {"codigo": 1, "nombre": "Juan", "apellido": "Molina"}
                            };
                            //@todo fin esto es sólo para poder continuar con las pruebs

                            //Si ya existe lo actualiza, de lo contrario lo registra
                            if ($scope.actividad.a005codigo !== undefined && $scope.actividad.a005codigo !== null && $scope.actividad.a005codigo !== '') {

                                actividadSrv.actualizarActividad($scope.OE).then(function (response) {
                                    //Si el usuario actualizó el archivo se llama el método para actualizarlo
                                    if ($scope.muestraCampoSoporte == true && $scope.soporte.adjunto != '') {
                                        $scope.actualizarSoporte();
                                    }
                                    //Oculta formulario y actualiza el listado
                                    $scope.muestraForm = false;
                                    $scope.listarActividadPorClave();
                                    comunSrv.mensajeSalida(response);
                                    //Registra avance
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
                                //Si el registro es nuevo, llama al método para registrarlo                                
                                actividadSrv.registrarActividad($scope.OE).then(function (response) {
                                    //actualiza el id actividad con el valor devuelto
                                    $scope.actividad.a005codigo = response.data.respuesta[0].a005codigo;
                                    $scope.registrarSoporte();
                                    //Oculta formulario y actualiza el listado
                                    $scope.muestraForm = false;
                                    comunSrv.mensajeSalida(response);
                                    //Registra avance
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                            }

                        } else { //else validación adjunto
                            comunSrv.mensaje("Debe adjuntar un soporte de la actividad a realizar.", "error");
                        }

                    } else { //else validación geometría
                        comunSrv.mensaje("Debe seleccionar una geometría.", "error");
                    }
                };

                $scope.registrarSoporte = function () {

                    soporteActividadSrv.registrarSoporte($scope.actividad.a005codigo, $scope.soporte.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.actualizarSoporte = function () {

                    soporteActividadSrv.actualizarSoporte($scope.actividad.a005idsoporte.a026codigo, $scope.soporte.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.eliminarActividad = function (act) {

                    if ($window.confirm('Confirme que desea eliminar la actividad.')) {
                        console.log("eliminar actividad");

                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.actividad = {"a005codigo": act.a005codigo};

                        actividadSrv.eliminarActividad($scope.OE)
                                .then(function (response) {
                                    comunSrv.mensajeSalida(response);
                                    //recargar el listado
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        console.log("usuario canceló la acción de eliminar");
                    }
                };

                /* CONTROL ELEMENTOS DE LA VISTA */

                //este formulario sirve para crear actividades nuevas y para editarlas
                $scope.mostrarForm = function (act) {
                    $scope.muestraForm = true;
                    //si viene una actividad como parámetro es edición
                    if (act != undefined && act != null) {
                        $scope.actividad.a005codigo = act.a005codigo;
                        $scope.actividad.a005descrpcnactvdd = act.a005descrpcnactvdd;
                        $scope.actividad.a005fechainicio = act.a005fechainicio;
                        $scope.actividad.a005fechafinal = act.a005fechafinal;
                        $scope.actividad.a005idtipactvdd = {"a022codigo": act.a005idtipactvdd};
                        $scope.actividad.a005idtipactvdreduc = {"a58codigo": act.a005idtipactvdreduc};
                        $scope.actividad.a005idsoporte = {"a026codigo": act.a005idsoporte, "a026nomarchivo": act.a026nomarchivo};
                        //$scope.consultarGeometria();
                    } else {
                        $scope.actividad = new Object();
                        $scope.actividad.a005idproyecto = {"a002codigo": $scope.pid};
                        $scope.actividad.a005idsoporte = {"a026codigo": '', "a026nomarchivo": ''};
                    }
                    $scope.actualizaCategoriaMitigacion();
                };

                $scope.ocultarForm = function () {
                    $scope.muestraForm = false;
                };

                $scope.mostrarCampoSoporte = function () {
                    $scope.muestraCampoSoporte = true;
                };

                $scope.ocultarCampoSoporte = function () {
                    $scope.muestraCampoSoporte = false;
                };

                $scope.actualizaCategoriaMitigacion = function () {

                    angular.forEach($scope.tiposActividades, function (value, key) {
                        if ($scope.actividad.a005idtipactvdd.a022codigo === value.a022codigo) {
                            $scope.actividad.a005idtipactvdd = value;
                            $scope.categoriaMitigacion = value.tipproyctmdl;
                        }
                    });

                    //Si la actividad seleccionada es la actividad "especial", se debe mostrar el listado de actividades de reducción
                    if ($scope.actividad.a005idtipactvdd.a022actespecial == 'S') {
                        $scope.muestraListTpActRed = true;
                    } else {
                        $scope.muestraListTpActRed = false;
                    }
                };

                /* LISTADOS Y GRILLAS */
                $scope.listarActividadPorClave = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a005idproyecto = $scope.pid;
                    $scope.OE.filtro = $scope.busquedaOE.palabraClave;
                    grillaSrv.listarActividadPorClave($scope.OE)
                            .then(function (response) {
                                $scope.actividades = response.data.respuesta;
                                $scope.totalItems = $scope.actividades.length;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoActividades = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a022idtipproyct = $scope.tpid;
                    listadoSrv.listarTipoActividades($scope.OE)
                            .then(function (response) {
                                $scope.tiposActividades = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoActividadReduccion = function () {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a058tipproyct = $scope.tpid;
                    listadoSrv.listarTipoActividadReduccion($scope.OE)
                            .then(function (response) {
                                $scope.tiposActivReduccion = response.data.respuesta;
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };


                /* GEOMETRÍA */
                $scope.cargarGeometria = function () {

                    $('#geometria').modal('show');
                    try {
                        $scope.urlGeo = './geometria/index.html?divipola=' + $scope.proyecto.a002loclzcn.a020codigo + '&idModulo=' + IDMODULO + '&idSistema=' + IDSISTEMA;
                        var ctrlGeo = document.getElementById('ctrlGeo');
                        if (ctrlGeo) {
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.a042idproyecto = $scope.pid;
                            $scope.OE.a042idactividad = 1; //$scope.actividad.a005codigo;

                            actividadSrv.consultarGeografia($scope.OE)
                                    .then(function (response) {

                                        var geometria = {};
                                        if (response.data.respuesta.length === 0) {

                                            geometria = {
                                                'type': 'Feature',
                                                'properties': {
                                                    'name': 'Feature de prueba'
                                                },
                                                'geometry': {
                                                    'type': 'Point',
                                                    'coordinates': [-74.2478957, 4.6482837]
                                                }
                                            };
                                        } else {

                                            geometria = JSON.parse(response.data.respuesta[0].a042geometriaSitio);
                                        }

                                        setTimeout(function () {
                                            (ctrlGeo.contentWindow || ctrlGeo.contentDocument).establecerGeometria(geometria);
                                        }, 3000);
                                        //comunSrv.mensajeSalida(response);
                                    }, function (error) {
                                        comunSrv.mensajeSalida(error);
                                    });
                        }
                    } catch (e) {
                        comunSrv.mensaje('No se puede cargar la geometría de la actividad, intente de nuevo<br><br>' + e.message, 'error');
                        $scope.geometria.a042geometriaSitio = e.message;
                    }
                };

                $scope.obtenerGeometria = function () {

                    try {

                        var ctrlGeo = document.getElementById('ctrlGeo');
                        if (ctrlGeo) {
                            $scope.geometria.a042geometriaSitio = (ctrlGeo.contentWindow || ctrlGeo.contentDocument).obtenerGeometria();
                            $('#geometria').modal('hide');
                        }
                    } catch (e) {

                        comunSrv.mensaje('No se puede seleccionar la geometría de la actividad, intente de nuevo<br><br>' + e.message, 'error');
                        $scope.geometria.a042geometriaSitio = e.message;
                    }
                };

                $scope.consultarGeometria = function () {

                    $scope.geometria.a042geometriaSitio = '';
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a042idproyecto = $scope.pid;
                    $scope.OE.a042idactividad = $scope.actividad.a005codigo;
                    actividadSrv.consultarGeografia($scope.OE)
                            .then(function (response) {
                                $scope.geometria.a042geometriaSitio = JSON.parse(response.data.respuesta[0].a042geometriaSitio);
                                //comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /**************************************************************/
                /* Inicializar formulario */
                $scope.proyecto = infoProyecto.proyecto;

                //Definir pantalla para registrar avance
                if ($location.path().substr(0, '/gpy/actividadespre/'.length) === '/gpy/actividadespre/') {
                    $scope.pantalla = ACTIVIDADESPRE;
                } else if ($location.path().substr(0, '/gpy/actividadesreg/'.length) === '/gpy/actividadesreg/') {
                    $scope.pantalla = ACTIVIDADESREG;
                }

                $scope.listarActividadPorClave();
                $scope.listarTipoActividades();
                $scope.listarTipoActividadReduccion();

            }]);


