/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('contacto.controllers', ['ngSanitize'])
        .controller('contactoCtrl', ['$scope', 'contactoSrv', 'listadoSrv', 'comunSrv', 'personaSrv', function ($scope, contactoSrv, listadoSrv, comunSrv, personaSrv) {

                /**************************************************************/
                /* Manejo sesión */
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                /**************************************************************/
                /* Variables */
                $scope.contacto = new Object();
                $scope.contacto.a054idcontacto = new Object();
                $scope.tiposDocum = [];

                /**************************************************************/
                /* Métodos */
                $scope.consultaContactoPorIdPersona = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.idpersona = $scope.sesion.idpersona;

                    contactoSrv.consultaContacto($scope.OE)
                            .then(function (response) {
                                if (response.data.respuesta[0] !== undefined) {
                                    //setear los campos 
                                    $scope.contacto.a054codigo = response.data.respuesta[0].a054codigo;
                                    $scope.contacto.a054idcontacto.a052codigo = response.data.respuesta[0].a052codigo;
                                    $scope.contacto.a054idcontacto.a052nombre = response.data.respuesta[0].a052nombre;
                                    $scope.contacto.a054idcontacto.a052apellido = response.data.respuesta[0].a052apellido;
                                    $scope.contacto.a054idcontacto.a052numrdocmnt = response.data.respuesta[0].a052numrdocmnt;
                                    $scope.contacto.a054idcontacto.a052dirccncorrspndnc = response.data.respuesta[0].a052dirccncorrspndnc;
                                    $scope.contacto.a054idcontacto.a052telefono = response.data.respuesta[0].a052telefono;
                                    $scope.contacto.a054idcontacto.a052celular = response.data.respuesta[0].a052celular;
                                    $scope.contacto.a054idcontacto.a052correlctrnc = response.data.respuesta[0].a052correlctrnc;

                                    $scope.contacto.a054idpersona = {"a052codigo": response.data.respuesta[0].a054idpersona};

                                    $scope.contacto.a054idcontacto.a052tipdocmnt = {
                                        "a015descrpcntipdocmnt": response.data.respuesta[0].a015descrpcntipdocmnt,
                                        "a015codigo": response.data.respuesta[0].a052tipdocmnt
                                    };

                                    $scope.contacto.a054idcontacto.a052loclzcn = {
                                        "a020codigo": response.data.respuesta[0].a020codigo,
                                        "a020nommunicipio": response.data.respuesta[0].a020nommunicipio,
                                        "a020coddepartamento": response.data.respuesta[0].a020coddepartamento,
                                        "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento,
                                        "a020codpais": response.data.respuesta[0].a020codpais,
                                        "a020nompais": response.data.respuesta[0].a020nompais
                                    };
                                }

                                //inicializa combos
                                $scope.cargaPaises();
                                $scope.listarTipoDocumento();

                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.consultaContactoPorId = function (id) {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a054codigo = id;

                    contactoSrv.consultaContacto($scope.OE)
                            .then(function (response) {
                                if (response.data.respuesta[0] !== undefined) {
                                    //setear los campos 
                                    $scope.contacto.a054codigo = response.data.respuesta[0].a054codigo;
                                    $scope.contacto.a054idcontacto.a052codigo = response.data.respuesta[0].a052codigo;
                                    $scope.contacto.a054idcontacto.a052nombre = response.data.respuesta[0].a052nombre;
                                    $scope.contacto.a054idcontacto.a052apellido = response.data.respuesta[0].a052apellido;
                                    $scope.contacto.a054idcontacto.a052numrdocmnt = response.data.respuesta[0].a052numrdocmnt;
                                    $scope.contacto.a054idcontacto.a052dirccncorrspndnc = response.data.respuesta[0].a052dirccncorrspndnc;
                                    $scope.contacto.a054idcontacto.a052telefono = response.data.respuesta[0].a052telefono;
                                    $scope.contacto.a054idcontacto.a052celular = response.data.respuesta[0].a052celular;
                                    $scope.contacto.a054idcontacto.a052correlctrnc = response.data.respuesta[0].a052correlctrnc;

                                    $scope.contacto.a054idpersona = {"a052codigo": response.data.respuesta[0].a054idpersona};

                                    $scope.contacto.a054idcontacto.a052tipdocmnt = {
                                        "a015descrpcntipdocmnt": response.data.respuesta[0].a015descrpcntipdocmnt,
                                        "a015codigo": response.data.respuesta[0].a052tipdocmnt
                                    };

                                    $scope.contacto.a054idcontacto.a052loclzcn = {
                                        "a020codigo": response.data.respuesta[0].a020codigo,
                                        "a020nommunicipio": response.data.respuesta[0].a020nommunicipio,
                                        "a020coddepartamento": response.data.respuesta[0].a020coddepartamento,
                                        "a020nomdepartamento": response.data.respuesta[0].a020nomdepartamento,
                                        "a020codpais": response.data.respuesta[0].a020codpais,
                                        "a020nompais": response.data.respuesta[0].a020nompais
                                    };
                                }

                                //inicializa combos
                                $scope.cargaPaises();
                                $scope.listarTipoDocumento();
                            }, function (error) {
                                comunSrv.mensajeSalida(error);
                            });
                };

                $scope.guardarContacto = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.contacto = $scope.contacto;

                    //Si ya existe lo actualiza, de lo contrario lo registra
                    if ($scope.contacto.a054codigo !== undefined && $scope.contacto.a054codigo !== null && $scope.contacto.a054codigo !== '') {

                        $scope.contacto.a054codigo = null;

                        contactoSrv.actualizarContacto($scope.OE)
                                .then(function (response) {
                                    comunSrv.mensajeSalida(response);

                                }, function (error) {
                                    comunSrv.mensajeSalida(error);
                                });
                    } else {
                        //valida si la persona existe para enviar el id
                        personaSrv.consultarPersonaPorDocumento({"idUsuario": $scope.idUsuario, "a052numrdocmnt": $scope.contacto.a054idcontacto.a052numrdocmnt}).then(function (response) {
                            
                            if (response.data.respuesta.length > 0) 
                            {
                                $scope.contacto.a054idcontacto.a052codigo =  response.data.respuesta[0].a052codigo;
                            }
                                                            
                                
                            $scope.contacto.a054idpersona = {"a052codigo": $scope.sesion.idpersona};

                            contactoSrv.registrarContacto($scope.OE)
                                    .then(function (response) {
                                        comunSrv.mensajeSalida(response);
                                        $scope.consultaContactoPorIdPersona();//para que traiga el id con el que lo creó, ya que la pantalla queda disponible para seguir editando el representante @todo quitar cuando se haga el CRUD
                                    }, function (error) {
                                        comunSrv.mensajeSalida(error);
                                    });
                        }, function (error) {
                            comunSrv.mensajeSalida(error);
                        });
                    }
                };

                $scope.listarTipoDocumento = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.tipodocumento = NATURAL;
                    listadoSrv.listarTipoDocumento($scope.OE)
                            .then(function (response) {
                                $scope.tiposDocum = response.data.respuesta;

                                //Selecciona el que venga en BD
                                if ($scope.contacto.a054idcontacto.a052tipdocmnt !== undefined) {
                                    angular.forEach($scope.tiposDocu, function (value, key) {
                                        if (value.a102codigo === $scope.contacto.a054idcontacto.a052tipdocmnt.a102codigo) {
                                            $scope.contacto.a054idcontacto.a052tipdocmnt = value;
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
                $scope.paisContSel = new Object();
                $scope.departamentoContSel = new Object();

                $scope.cargaPaises = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;

                    listadoSrv.listarPaises($scope.OE)
                            .then(function (response) {
                                $scope.paises = response.data.respuesta;

                                //Selecciona el que venga en BD
                                if ($scope.contacto.a054idcontacto !== undefined && $scope.contacto.a054idcontacto.a052loclzcn !== undefined) {
                                    angular.forEach($scope.paises, function (value, key) {
                                        if (value.a020codpais === $scope.contacto.a054idcontacto.a052loclzcn.a020codpais) {
                                            $scope.paisContSel = value;
                                        }
                                    });
                                }
                                if ($scope.paisContSel.a020codpais !== undefined && $scope.paisContSel.a020codpais !== null)
                                    $scope.cargaDepartamentos($scope.paisContSel);
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
                                    if ($scope.contacto.a054idcontacto !== undefined && $scope.contacto.a054idcontacto.a052loclzcn !== undefined) {
                                        angular.forEach($scope.departamentos, function (value, key) {
                                            if (value.a020coddepartamento === $scope.contacto.a054idcontacto.a052loclzcn.a020coddepartamento) {
                                                $scope.departamentoContSel = value;
                                            }
                                        });
                                    }
                                    if ($scope.departamentoContSel.a020coddepartamento !== undefined && $scope.departamentoContSel.a020coddepartamento !== null)
                                        $scope.cargaMunicipios($scope.departamentoContSel);
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
                                    if ($scope.contacto.a054idcontacto !== undefined && $scope.contacto.a054idcontacto.a052loclzcn !== undefined) {
                                        angular.forEach($scope.municipios, function (value, key) {
                                            if (value.a020codigo === $scope.contacto.a054idcontacto.a052loclzcn.a020codigo) {
                                                $scope.contacto.a054idcontacto.a052loclzcn = value;
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
                $scope.consultaContactoPorIdPersona();

            }]);



