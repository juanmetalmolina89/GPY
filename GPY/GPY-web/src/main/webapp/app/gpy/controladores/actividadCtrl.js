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
                $scope.soporte = {'adjunto': ''};

                $scope.actividades = [];
                $scope.tiposActividades = [];
                $scope.tiposActivReduccion = [];
                $scope.categoriaMitigacion = '';

                $scope.muestraForm = false;
                $scope.muestraListTpActRed = false;
                $scope.muestraCampoSoporte = false;

                //geometria
                $scope.geometria = '';
                $scope.a042geometriasitio = '';
                $scope.a042geometriaintersec = '';

                //grilla
                $scope.busquedaOE = {'palabraClave': ''};
                $scope.totalItems = 0;
                $scope.currentPage = 1;
                $scope.itemsPerPage = 5;
                $scope.maxSize = 5;


                /**************************************************************/
                /* Métodos */

                $scope.guardarActividad = function () {
                    console.log("geometria: " + $scope.a042geometriasitio);
                    //valida que exista o haya elegido un adjunto
                    if ($scope.actividad.a005idsoporte.a026codigo != '' || $scope.soporte.adjunto != '') {
                        //Valida que haya elegido geometria
                        if ($scope.a042geometriasitio != '') {

                            //Empieza a armar el objeto de entrada
                            $scope.OE = new Object();
                            $scope.OE.idUsuario = $scope.idUsuario;
                            $scope.OE.actividad = $scope.actividad;
                            $scope.OE.actividad.a005idtipactvdd = {"a022codigo": $scope.actividad.a005idtipactvdd.a022codigo}; //Sólo necesito el id (si envío el obj completo voy a tener problemas con el valor tipproyctmdl que se trae para mostrarse, pero no pertenece a la entidad como tal.                    
                            $scope.OE.geometria = $scope.geometria;
                            $scope.OE.a042geometriasitio = $scope.a042geometriasitio;
                            $scope.OE.a042geometriaintersec = $scope.a042geometriaintersec;

                            //Si ya existe lo actualiza, de lo contrario lo registra
                            if ($scope.actividad.a005codigo !== undefined && $scope.actividad.a005codigo !== null && $scope.actividad.a005codigo !== '') {

                                actividadSrv.actualizarActividad($scope.OE).then(function (response) {
                                    //Oculta formulario
                                    $scope.muestraForm = false;
                                    //Si el usuario actualizó el archivo se llama el método para actualizarlo
                                    if ($scope.muestraCampoSoporte == true && $scope.soporte.adjunto != '') {
                                        $scope.actualizarSoporte();
                                        $scope.muestraCampoSoporte = false;
                                    }
                                    comunSrv.mensajeSalida(response);
                                    //Registra avance
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                //comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                    //recarga la lista de actividades
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                            } else {
                                //Si el registro es nuevo, llama al método para registrarlo                                
                                actividadSrv.registrarActividad($scope.OE).then(function (response) {
                                    //Oculta formulario
                                    $scope.muestraForm = false;
                                    //actualiza el id actividad y el id de la geometría con el valor devuelto
                                    $scope.actividad.a005codigo = response.data.respuesta[0].a005codigo;
                                    $scope.geometria.a042codigo = response.data.respuesta[1].a042codigo;
                                    //guarda el archivo adjunto
                                    $scope.registrarSoporte();
                                    comunSrv.mensajeSalida(response);
                                    //Registra avance
                                    avanceSrv.registrarAvance({"idUsuario": $scope.idUsuario, "a002codigo": $scope.proyecto.a002codigo, "a057idpantalla": $scope.pantalla})
                                            .then(function (response) {
                                                //comunSrv.mensajeSalida(response);
                                            }, function (error) {
                                                comunSrv.mensajeSalida(error);
                                            });
                                    //recarga la lista de actividades
                                    $scope.listarActividadPorClave();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                            }

                        } else { //else validación geometría
                            comunSrv.mensaje("Debe seleccionar una geometría.", "error");
                        }

                    } else { //else validación adjunto
                        comunSrv.mensaje("Debe adjuntar un soporte de la actividad a realizar.", "error");
                    }
                };

                $scope.registrarSoporte = function () {

                    soporteActividadSrv.registrarSoporte($scope.actividad.a005codigo, $scope.soporte.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                $scope.listarActividadPorClave();
                                //comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.actualizarSoporte = function () {

                    soporteActividadSrv.actualizarSoporte($scope.actividad.a005idsoporte.a026codigo, $scope.actividad.a005codigo, $scope.soporte.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                $scope.listarActividadPorClave();
                                //comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.consultarSoportePorId = function () {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a005codigo = $scope.actividad.a005codigo;
                    $scope.OE.a026codigo = $scope.actividad.a005idsoporte.a026codigo;
                    $scope.OE.a005idproyecto = $scope.pid;

                    actividadSrv.consultarSoportePorId($scope.OE).then(function (response) {
                        //Se llama método de utilería que descarga del archivo
                        comunSrv.descargarArchivo(response);
                        //comunSrv.mensajeSalida(response);
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
                        $scope.actividad.a005fechainicio = new Date(act.a005fechainicio);
                        $scope.actividad.a005fechafinal = new Date(act.a005fechafinal);
                        $scope.actividad.a005idtipactvdd = {"a022codigo": act.a005idtipactvdd};
                        $scope.actividad.a005idtipactvdreduc = {"a58codigo": act.a005idtipactvdreduc};
                        $scope.actividad.a005idsoporte = {"a026codigo": act.a005idsoporte, "a026nomarchivo": act.a026nomarchivo};
                        $scope.consultarGeometria();
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

                    if ($scope.actividad.a005idtipactvdd != undefined) {
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
                            //$scope.OE.a042idproyecto = $scope.pid;
                            $scope.OE.a042idactividad = $scope.actividad.a005codigo;

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

                                            geometria = JSON.parse(response.data.respuesta[0].a042geometria_sitio);
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
                        $scope.a042geometriasitio = e.message;
                    }
                };

                $scope.obtenerGeometria = function () {

                    try {

                        var ctrlGeo = document.getElementById('ctrlGeo');
                        if (ctrlGeo) {
                            $scope.a042geometriasitio = (ctrlGeo.contentWindow || ctrlGeo.contentDocument).obtenerGeometria();
                            $('#geometria').modal('hide');
                        }
                    } catch (e) {

                        comunSrv.mensaje('No se puede seleccionar la geometría de la actividad, intente de nuevo<br><br>' + e.message, 'error');
                        $scope.a042geometriasitio = e.message;
                    }
                };

                $scope.consultarGeometria = function () {

                    //Se inicializan los objetos
                    $scope.inicializarObjetosGeografia();

                    //Se empieza a armar el objeto de entrada para consultar la geografía
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    //$scope.OE.a042idproyecto = $scope.pid;
                    $scope.OE.a042idactividad = $scope.actividad.a005codigo;
                    actividadSrv.consultarGeografia($scope.OE).then(function (response) {
                        $scope.geometria.a042codigo = response.data.respuesta[0].a042codigo;
                        $scope.geometria.a042idproyecto = {"a002codigo": $scope.pid}; //response.data.respuesta[0].a042idproyecto;
                        $scope.geometria.a042idactvdd = $scope.actividad.a005codigo; //response.data.respuesta[0].a042idactvdd;
                        $scope.geometria.a042nrositio = response.data.respuesta[0].a042nrositio;
                        $scope.a042geometria_intersecc = JSON.parse(response.data.respuesta[0].a042geometria_intersecc);
                        $scope.a042geometriasitio = JSON.parse(response.data.respuesta[0].a042geometria_sitio);
                        //comunSrv.mensajeSalida(response);
                    }, function (error) {
                        comunSrv.mensajeSalida(error);
                    });
                };

                $scope.inicializarObjetosGeografia = function () {
                    $scope.geometria = {"a042idproyecto": {"a002codigo": $scope.pid}, "a042nrositio": 1 /*, "a042geometriaSitio": '', "a042geometriaIntersecc": ''*/};
                    $scope.a042geometriasitio = '';
                    $scope.a042geometriaintersec = {"Prueba": {"codigo": 1, "nombre": "nombre", "apellido": "apellido"}}; //@todo pendiente que definan qué debe ir en este campo
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

                $scope.inicializarObjetosGeografia();
                $scope.listarActividadPorClave();
                $scope.listarTipoActividades();
                $scope.listarTipoActividadReduccion();

            }]);


