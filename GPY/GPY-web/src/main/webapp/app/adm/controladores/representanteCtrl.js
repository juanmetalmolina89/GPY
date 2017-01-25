/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('representante.controllers', ['ngSanitize'])
        .controller('representanteCtrl', ['$scope', 'representanteSrv', 'listadoSrv', 'personaSrv', 'comunSrv', 'adjuntoSrv', function ($scope, representanteSrv, listadoSrv, personaSrv, comunSrv, adjuntoSrv) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.representante = new Object();
                $scope.tiposRepresentante = [];
                $scope.tiposDocu = [];
                $scope.APODERADO = APODERADO;
                $scope.poder = {'adjunto': ''};

                /**************************************************************/
                /* Métodos */
                $scope.consultaRepPorIdPersona = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a053idpersonajurd = $scope.sesion.idpersona;

                    representanteSrv.consultaRepresentante($scope.OE)
                            .then(function (response) {
                                if (response.data.respuesta[0] !== undefined) {
                                    //setear los campos 
                                    $scope.representante.a053codigo = response.data.respuesta[0].a053codigo;
                                    $scope.representante.a053idrepresentante = new Object();
                                    $scope.representante.a053idrepresentante.a052codigo = response.data.respuesta[0].a052codigo;
                                    $scope.representante.a053idrepresentante.a052nombre = response.data.respuesta[0].a052nombre;
                                    $scope.representante.a053idrepresentante.a052nombre = response.data.respuesta[0].a052nombre;
                                    $scope.representante.a053idrepresentante.a052apellido = response.data.respuesta[0].a052apellido;
                                    $scope.representante.a053idrepresentante.a052numrdocmnt = response.data.respuesta[0].a052numrdocmnt;
                                    $scope.representante.a053idrepresentante.a052lgrexpcndocmnt = response.data.respuesta[0].a052lgrexpcndocmnt;
                                    $scope.representante.a053idrepresentante.a052dirccncorrspndnc = response.data.respuesta[0].a052dirccncorrspndnc;
                                    $scope.representante.a053idrepresentante.a052telefono = response.data.respuesta[0].a052telefono;
                                    $scope.representante.a053idrepresentante.a052celular = response.data.respuesta[0].a052celular;
                                    $scope.representante.a053idrepresentante.a052correlctrnc = response.data.respuesta[0].a052correlctrnc;
                                    $scope.representante.a053idpersonajurd = {"a052codigo": response.data.respuesta[0].a053idpersonajurd};
                                    $scope.representante.a053tiporepresentante = {
                                        "a102codigo": response.data.respuesta[0].a053tiporepresentante,
                                        "a102valor": response.data.respuesta[0].tiporeplegal
                                    };
                                    $scope.representante.a053idrepresentante.a052idtippersn = {
                                        "a102codigo": response.data.respuesta[0].a052idtippersn,
                                        "a102valor": response.data.respuesta[0].desctippersn
                                    };
                                    $scope.representante.a053idrepresentante.a052tipdocmnt = {
                                        "a015descrpcntipdocmnt": response.data.respuesta[0].a015descrpcntipdocmnt,
                                        "a015codigo": response.data.respuesta[0].a052tipdocmnt
                                    };
                                    $scope.representante.a053idrepresentante.a052loclzcn = {
                                        "a020codigo": response.data.respuesta[0].a052loclzcn,
                                        "a020nommunicipio": response.data.respuesta[0].a020nommunicipio,
                                        "a020coddepartamento": response.data.respuesta[0].a020coddepartamento,
                                        "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento,
                                        "a020codpais": response.data.respuesta[0].a020codpais,
                                        "a020nompais": response.data.respuesta[0].a020nompais
                                    };
//                                    //@todo pendiente manejo archivo
//                                    $scope.representante.a053idarchivo = new Object();
//                                    $scope.representante.a053idarchivo.a026codigo = response.data.respuesta[0].a053idarchivo;
//                                    $scope.representante.a053idarchivo.a026rutarchiv = response.data.respuesta[0].a026rutarchiv;
//                                    $scope.representante.a053idarchivo.a026descrpcnarchiv = response.data.respuesta[0].a026descrpcnarchiv;
//                                    $scope.representante.a053idarchivo.a026hasharchivo = response.data.respuesta[0].a026hasharchivo;
                                }

                                //inicializa combos
                                $scope.cargaPaises();
                                $scope.listarTipoRepresentante();
                                $scope.listarTipoDocumento();

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.consultaRepPorId = function (id) {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a053codigo = id;
                    representanteSrv.consultaRepresentante($scope.OE)
                            .then(function (response) {
                                if (response.data.respuesta[0] !== undefined) {
                                    //setear los campos 
                                    $scope.representante.a053codigo = response.data.respuesta[0].a053codigo;
                                    $scope.representante.a053idrepresentante = new Object();
                                    $scope.representante.a053idrepresentante.a052codigo = response.data.respuesta[0].a052codigo;
                                    $scope.representante.a053idrepresentante.a052nombre = response.data.respuesta[0].a052nombre;
                                    $scope.representante.a053idrepresentante.a052nombre = response.data.respuesta[0].a052nombre;
                                    $scope.representante.a053idrepresentante.a052apellido = response.data.respuesta[0].a052apellido;
                                    $scope.representante.a053idrepresentante.a052numrdocmnt = response.data.respuesta[0].a052numrdocmnt;
                                    $scope.representante.a053idrepresentante.a052lgrexpcndocmnt = response.data.respuesta[0].a052lgrexpcndocmnt;
                                    $scope.representante.a053idrepresentante.a052dirccncorrspndnc = response.data.respuesta[0].a052dirccncorrspndnc;
                                    $scope.representante.a053idrepresentante.a052telefono = response.data.respuesta[0].a052telefono;
                                    $scope.representante.a053idrepresentante.a052celular = response.data.respuesta[0].a052celular;
                                    $scope.representante.a053idrepresentante.a052correlctrnc = response.data.respuesta[0].a052correlctrnc;
                                    $scope.representante.a053idpersonajurd = {"a052codigo": response.data.respuesta[0].a053idpersonajurd};
                                    $scope.representante.a053tiporepresentante = {
                                        "a102codigo": response.data.respuesta[0].a053tiporepresentante,
                                        "a102valor": response.data.respuesta[0].tiporeplegal
                                    };
                                    $scope.representante.a053idrepresentante.a052idtippersn = {
                                        "a102codigo": response.data.respuesta[0].a052idtippersn,
                                        "a102valor": response.data.respuesta[0].desctippersn
                                    };
                                    $scope.representante.a053idrepresentante.a052tipdocmnt = {
                                        "a015descrpcntipdocmnt": response.data.respuesta[0].a015descrpcntipdocmnt,
                                        "a015codigo": response.data.respuesta[0].a052tipdocmnt
                                    };
                                    $scope.representante.a053idrepresentante.a052loclzcn = {
                                        "a020codigo": response.data.respuesta[0].a052loclzcn,
                                        "a020nommunicipio": response.data.respuesta[0].a020nommunicipio,
                                        "a020coddepartamento": response.data.respuesta[0].a020coddepartamento,
                                        "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento,
                                        "a020codpais": response.data.respuesta[0].a020codpais,
                                        "a020nompais": response.data.respuesta[0].a020nompais
                                    };
                                    //@todo pendiente manejo archivo
//                                    $scope.representante.a053idarchivo = new Object();
//                                    $scope.representante.a053idarchivo.a026codigo = response.data.respuesta[0].a053idarchivo;
//                                    $scope.representante.a053idarchivo.a026rutarchiv = response.data.respuesta[0].a026rutarchiv;
//                                    $scope.representante.a053idarchivo.a026descrpcnarchiv = response.data.respuesta[0].a026descrpcnarchiv;
//                                    $scope.representante.a053idarchivo.a026hasharchivo = response.data.respuesta[0].a026hasharchivo;
                                }

                                //inicializa combos
                                $scope.cargaPaises();
                                $scope.listarTipoRepresentante();
                                $scope.listarTipoDocumento();

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.guardarRepLegal = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.representante = $scope.representante;

                    //Si ya existe lo actualiza, de lo contrario lo registra
                    if ($scope.representante.a053codigo !== undefined && $scope.representante.a053codigo !== null && $scope.representante.a053codigo !== '') {

                        $scope.representante.a053idrepresentante.a052idtippersn = {"a102codigo": NATURAL};
                        representanteSrv.actualizarRepresentante($scope.OE)
                                .then(function (response) {
                                    comunSrv.mensajeSalida(response);
                                    $scope.adjuntarDocumento();
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        //valida si la persona existe para enviar el id
                        personaSrv.consultarPersonaPorDocumento({"idUsuario": $scope.idUsuario, "a052numrdocmnt": $scope.representante.a053idrepresentante.a052numrdocmnt}).then(function (response) {

                            if (response.data.respuesta.lenght > 0)
                                $scope.representante.a053idrepresentante = {"a052codigo": response.data.respuesta[0].a052codigo};

                            $scope.representante.a053idpersonajurd = {"a052codigo": $scope.sesion.idpersona};
                            $scope.representante.a053idrepresentante.a052idtippersn = {"a102codigo": NATURAL};

                            representanteSrv.registrarRepresentante($scope.OE)
                                    .then(function (response) {
                                        comunSrv.mensajeSalida(response);
                                        $scope.representante.a053codigo = response.respuesta.a053codigo;
                                        $scope.adjuntarDocumento();
                                    }, function (error) {
                                        comunSrv.mensajeSalida(error);
                                    });
                        }, function (error) {
                            comunSrv.mensajeSalida(error);
                        });
                    }
                };

                $scope.adjuntarDocumento = function () {

                    adjuntoSrv.adjuntarDocumento($scope.representante.a053codigo, $scope.poder.adjunto, $scope.idUsuario)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoRepresentante = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOREPRESENTANTE;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposRepresentante = response.data.respuesta;

                                //Selecciona el que venga en BD
                                if ($scope.representante.a053tiporepresentante !== undefined) {
                                    angular.forEach($scope.tiposRepresentante, function (value, key) {
                                        if (value.a102codigo === $scope.representante.a053tiporepresentante.a102codigo) {
                                            $scope.representante.a053tiporepresentante = value;
                                        }
                                    });
                                }
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoDocumento = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.tipodocumento = NATURAL;
                    listadoSrv.listarTipoDocumento($scope.OE)
                            .then(function (response) {
                                $scope.tiposDocu = response.data.respuesta;

                                //Selecciona el que venga en BD
                                if ($scope.representante.a053idrepresentante !== undefined) {
                                    angular.forEach($scope.tiposDocu, function (value, key) {
                                        if (value.a102codigo === $scope.representante.a053idrepresentante.a052tipdocmnt.a102codigo) {
                                            $scope.representante.a053idrepresentante.a052tipdocmnt = value;
                                        }
                                    });
                                }
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /* DIVIPOLA */
                $scope.paises = [];
                $scope.departamentos = [];
                $scope.municipios = [];
                $scope.paisRepSel = new Object();
                $scope.departamentoRepSel = new Object();

                $scope.cargaPaises = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    listadoSrv.listarPaises($scope.OE)
                            .then(function (response) {
                                $scope.paises = response.data.respuesta;

                                //Selecciona el que venga en BD
                                if ($scope.representante.a053idrepresentante !== undefined && $scope.representante.a053idrepresentante.a052loclzcn !== undefined) {
                                    angular.forEach($scope.paises, function (value, key) {
                                        if (value.a020codpais === $scope.representante.a053idrepresentante.a052loclzcn.a020codpais) {
                                            $scope.paisRepSel = value;
                                        }
                                    });
                                }
                                if ($scope.paisRepSel.a020codpais !== undefined && $scope.paisRepSel.a020codpais !== null)
                                    $scope.cargaDepartamentos($scope.paisRepSel);

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.cargaDepartamentos = function (pais) {
                    if (pais !== undefined) {
                        $scope.OE = new Object();
                        $scope.OE.idUsuario = $scope.idUsuario;
                        $scope.OE.paises = pais;
                        listadoSrv.listarDepartamentosPorPais($scope.OE)
                                .then(function (response) {
                                    $scope.departamentos = response.data.respuesta;

                                    //Selecciona el que venga en BD
                                    if ($scope.representante.a053idrepresentante !== undefined && $scope.representante.a053idrepresentante.a052loclzcn !== undefined) {
                                        angular.forEach($scope.departamentos, function (value, key) {
                                            if (value.a020coddepartamento === $scope.representante.a053idrepresentante.a052loclzcn.a020coddepartamento) {
                                                $scope.departamentoRepSel = value;
                                            }
                                        });
                                    }
                                    if ($scope.departamentoRepSel.a020coddepartamento !== undefined && $scope.departamentoRepSel.a020coddepartamento !== null)
                                        $scope.cargaMunicipios($scope.departamentoRepSel);
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
                                    if ($scope.representante.a053idrepresentante !== undefined && $scope.representante.a053idrepresentante.a052loclzcn !== undefined) {
                                        angular.forEach($scope.municipios, function (value, key) {
                                            if (value.a020codigo === $scope.representante.a053idrepresentante.a052loclzcn.a020codigo) {
                                                $scope.representante.a053idrepresentante.a052loclzcn = value;
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
                $scope.consultaRepPorIdPersona();

            }]);



