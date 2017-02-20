/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('persona.controllers', ['ngSanitize'])
        .controller('miCuentaCtrl', ['$scope', '$location', 'personaSrv', 'listadoSrv', 'comunSrv', function ($scope, $location, personaSrv, listadoSrv, comunSrv) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                if ($scope.sesion.perfil == INVITADO) {
                    comunSrv.mensaje("Está intentando ingresar a una opción no permitida", "info");
                    $location.path('/gpy');
                }

                /**************************************************************/
                /* Variables */
                $scope.persona = new Object();
                $scope.tiposDoc = [];
                $scope.tiposPerJuri = [];
                $scope.codigosCIIU = [];
                $scope.NATURAL = NATURAL;
                $scope.JURIDICA = JURIDICA;
                //esto es para que muestre el cargando 
                $scope.persona.a052idtippersn = CERO;

                /**************************************************************/
                /* Métodos */
                $scope.consultarPersonaPorId = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a052codigo = $scope.sesion.idpersona;

                    personaSrv.consultarPersonaPorId($scope.OE)
                            .then(function (response) {
                                //setear los campos (primero propios, luego llaves foráneas)
                                $scope.persona.a052codigo = response.data.respuesta[0].a052codigo;
                                $scope.persona.a052nombre = response.data.respuesta[0].a052nombre;
                                $scope.persona.a052apellido = response.data.respuesta[0].a052apellido;
                                $scope.persona.a052numrdocmnt = response.data.respuesta[0].a052numrdocmnt;
                                $scope.persona.a052lgrexpcndocmnt = response.data.respuesta[0].a052lgrexpcndocmnt;
                                $scope.persona.a052digtchqu = response.data.respuesta[0].a052digtchqu;
                                $scope.persona.a052dirccncorrspndnc = response.data.respuesta[0].a052dirccncorrspndnc;
                                $scope.persona.a052celular = response.data.respuesta[0].a052celular;
                                $scope.persona.a052telefono = response.data.respuesta[0].a052telefono;
                                $scope.persona.a052correlctrnc = response.data.respuesta[0].a052correlctrnc;
                                $scope.persona.a052idtippersn = {
                                    "a102codigo": response.data.respuesta[0].a052idtippersn,
                                    "a102valor": response.data.respuesta[0].desctippersn
                                };
                                $scope.persona.a052tipdocmnt = {
                                    "a015descrpcntipdocmnt": response.data.respuesta[0].a015descrpcntipdocmnt,
                                    "a015codigo": response.data.respuesta[0].a052tipdocmnt
                                };
                                $scope.persona.a052codgciiu = {
                                    "a049codigo": response.data.respuesta[0].a052codgciiu,
                                    "a049descripcionciiu": response.data.respuesta[0].a049descripcionciiu
                                };
                                $scope.persona.a052loclzcn = {
                                    "a020codigo": response.data.respuesta[0].a020codigo,
                                    "a020nommunicipio": response.data.respuesta[0].a020nommunicipio,
                                    "a020coddepartamento": response.data.respuesta[0].a020coddepartamento,
                                    "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento,
                                    "a020codpais": response.data.respuesta[0].a020codpais,
                                    "a020nompais": response.data.respuesta[0].a020nompais
                                };
                                $scope.persona.a052identidad = {
                                    "a001nombre": response.data.respuesta[0].a001nombre,
                                    "a001sigla": response.data.respuesta[0].a001sigla,
                                    "a001codigo": response.data.respuesta[0].a052identidad
                                };


                                //inicializa combos
                                $scope.cargaPaises();
                                $scope.listarTipoDocumento($scope.persona.a052idtippersn.a102codigo === NATURAL ? NATURAL : JURIDICA);
                                if ($scope.persona.a052idtippersn.a102codigo !== NATURAL) {
                                    $scope.listarTipoPerJuridica();
                                    $scope.listarCodigosCIIU();
                                }

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoDocumento = function (tipodocumento) {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.tipodocumento = tipodocumento;
                    listadoSrv.listarTipoDocumento($scope.OE)
                            .then(function (response) {
                                $scope.tiposDoc = response.data.respuesta;

                                //Selecciona el que venga en BD
                                angular.forEach($scope.tiposDoc, function (value, key) {
                                    if (value.a015codigo === $scope.persona.a052tipdocmnt.a015codigo) {
                                        $scope.persona.a052tipdocmnt = value;
                                    }
                                });

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarTipoPerJuridica = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.categoria = TIPOPERSJURIDICA;
                    listadoSrv.listarParametros($scope.OE)
                            .then(function (response) {
                                $scope.tiposPerJuri = response.data.respuesta;

                                //Selecciona el que venga en BD
                                angular.forEach($scope.tiposPerJuri, function (value, key) {
                                    if (value.a102codigo === $scope.persona.a052idtippersn.a102codigo) {
                                        $scope.persona.a052idtippersn = value;
                                    }
                                });
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.listarCodigosCIIU = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    listadoSrv.listarCodigosCIIU($scope.OE)
                            .then(function (response) {
                                $scope.codigosCIIU = response.data.respuesta;

                                //Selecciona el que venga en BD
                                angular.forEach($scope.codigosCIIU, function (value, key) {
                                    if (value.a049codigo === $scope.persona.a052codgciiu.a049codigo) {
                                        $scope.persona.a052codgciiu = value;
                                    }
                                });
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                //Método para actualizar persona natural y jurídica
                $scope.actualizarPersona = function () {
                    console.log($scope.persona);

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.persona = $scope.persona;

                    personaSrv.actualizarPersona($scope.OE)
                            .then(function (response) {
                                comunSrv.mensajeSalida(response);
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                /* DIVIPOLA */
                $scope.paises = [];
                $scope.departamentos = [];
                $scope.municipios = [];
                $scope.paisSel = new Object();
                $scope.departamentoSel = new Object();

                $scope.cargaPaises = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;

                    listadoSrv.listarPaises($scope.OE)
                            .then(function (response) {
                                $scope.paises = response.data.respuesta;

                                //Selecciona el que venga en BD
                                angular.forEach($scope.paises, function (value, key) {
                                    if (value.a020codpais === $scope.persona.a052loclzcn.a020codpais) {
                                        $scope.paisSel = value;
                                    }
                                });
                                if ($scope.paisSel.a020codpais !== undefined && $scope.paisSel.a020codpais !== null)
                                    $scope.cargaDepartamentos($scope.paisSel);
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
                                    angular.forEach($scope.departamentos, function (value, key) {
                                        if (value.a020coddepartamento === $scope.persona.a052loclzcn.a020coddepartamento) {
                                            $scope.departamentoSel = value;
                                        }
                                    });
                                    if ($scope.departamentoSel.a020coddepartamento !== undefined && $scope.departamentoSel.a020coddepartamento !== null)
                                        $scope.cargaMunicipios($scope.departamentoSel);
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

                                    angular.forEach($scope.municipios, function (value, key) {
                                        if (value.a020codigo === $scope.persona.a052loclzcn.a020codigo) {
                                            $scope.persona.a052loclzcn = value;
                                        }
                                    });
                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        $scope.municipios = [];
                    }
                };

                /**************************************************************/
                /* Inicializar formulario */
                $scope.consultarPersonaPorId();

            }]);



