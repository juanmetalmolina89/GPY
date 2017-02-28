/* 
 * Autor: Fernando Camargo S
 */
'use strict';
	
angular.module('participante.controllers', ['ngSanitize'])
        .controller('participanteCtrl', ['$scope', 'participanteSrv', '$routeParams', 'listadoSrv', 'personaSrv', function ($scope, participanteSrv, $routeParams, listadoSrv, personaSrv) {

		        $scope.pid = $routeParams.pid;
						
                $scope.mensaje;
                $scope.participantes = []; 
                $scope.participante = []; 
				//$scope.persona = []; 
				$scope.tiposDocumento = []; 

                $scope.participante = new Object();
                $scope.participante.a051idproyecto = $scope.pid;
				
				$scope.muestraForm = true;
				
				$scope.model = {
					isDisabled: false
				};
				
                $scope.listar = function () {
					$scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a051idproyecto = $scope.pid;
					
                    participanteSrv.listar($scope.OE)
                            .then(function (response) {
                                $scope.participantes = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.eliminar = function (esteParticipante) {
                    // {"idUsuario":1,"participante":{"a051codigo":1}}
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.participante={"a051codigo":esteParticipante.a051codigo}
					//$scope.OE.participante.a051codigo = esteParticipante.a051codigo;
					
                    participanteSrv.borrar($scope.OE)
                            .then(function (response) {
								$scope.mensaje = 'Participante eliminado con éxito.';
								$scope.participante=[];
								$scope.listar();  
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
				

                $scope.guardar = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.participante = new Object();
                    $scope.OE.participante.a051responsabilidad = $scope.participante.a051responsabilidad;
                    $scope.OE.participante.a05idproyecto = {"a002codigo":$scope.pid};					

                    if($scope.participante.a051codigo != undefined && $scope.participante.a051codigo != null)
                    {
                            // es un update
                            $scope.OE.participante.a051codigo = $scope.participante.a051codigo;
                            $scope.OE.participante.a051idpersona={"a052codigo":$scope.participante.persona.a051idpersona}
                            //{"idUsuario":1,"participante":{"a051codigo":1,"a05idproyecto":{"a002codigo":1},"a051idpersona":{"a052codigo":1},"a051responsabilidad":"Supervisor"}}
                            participanteSrv.actualizar($scope.OE)
                                            .then(function (response) {
                                                    $scope.mensaje = 'Participante actualizado con éxito.';
                                                    $scope.participante=[];
                                                    $scope.listar();
                                                    console.log($scope.mensaje);
                                            }, function (error) {
                                                    $scope.mensaje = error.data.respuesta;
                                                    console.log($scope.mensaje);
                                            });
                    }
                    else
                    {
                        // es un insert
                        if ($scope.participante.persona.a052codigo != undefined && $scope.participante.persona.a052codigo != null) 
                        {
                                //si existe la persona , debe obtener el Id
                                $scope.OE.participante.a051idpersona = {"a052codigo":$scope.participante.persona.a052codigo};
                                participanteSrv.insertar($scope.OE)
                                        .then(function (response) {
                                                $scope.mensaje = 'Participante insertado con éxito.';
                                                $scope.participante=[];
                                                $scope.listar();
                                                console.log($scope.mensaje);
                                        }, function (error) {
                                                $scope.mensaje = error.data.respuesta;
                                                console.log($scope.mensaje);
                                        });
                        }
                        else
                        {
                                // si no existe la persona, se debe crear primero y con el Id se debe hacer el insert						
                                //$scope.NP_OE = {"idUsuario":$scope.idUsuario, "persona":{ "a052nombre":$scope.participante.persona.a052nombre, "a052apellido":$scope.participante.persona.a052apellido,"a052dirccncorrspndnc":"NA","a052loclzcn":{},"a052tipdocmnt":{"a015fechacreacion":1481488850000, "a015usuariocreacion":0, "a015fechamodificacion":null, "a015usuariomodificacion":null, "a015descrpcntipdocmnt":"Cédula de Ciudadanía","a015estadoregistro":"A","a015idtippersn":1,"a015codigo":1},"a052idtippersn":{"a102valor":"Persona Natural","a102codigo":1,"a102valorcorto":"PN"},"a052digtchqu":"0","a052lgrexpcndocmnt":"NA","a052numrdocmnt":$scope.participante.persona.a052numrdocmnt,"a052telefono":"0","a052celular":"0","a052correlctrnc":$scope.participante.persona.a052correlctrnc,"a052codgciiu":{},"a052identidad":{}}};
                                $scope.tipoDocumento = $scope.completarTipoDoc($scope.participante.persona.a015codigo);
                                $scope.NP_OE = {"idUsuario":$scope.idUsuario, "persona":{ "a052nombre":$scope.participante.persona.a052nombre, "a052apellido":$scope.participante.persona.a052apellido,"a052dirccncorrspndnc":"NA","a052loclzcn":{},"a052tipdocmnt":$scope.tipoDocumento,"a052idtippersn":{"a102valor":"Persona Natural","a102codigo":1,"a102valorcorto":"PN"},"a052digtchqu":"0","a052lgrexpcndocmnt":"NA","a052numrdocmnt":$scope.participante.persona.a052numrdocmnt,"a052telefono":"0","a052celular":"0","a052correlctrnc":$scope.participante.persona.a052correlctrnc,"a052codgciiu":{},"a052identidad":{}}};

                                personaSrv.registrarPersona($scope.NP_OE)
                                        .then(function (response) {		
                                                // buscar response.a052codigo, ahi viene el id de la persona
                                                $scope.OE.participante.a051idpersona = {"a052codigo":response.data.respuesta[0].a052codigo};

                                                participanteSrv.insertar($scope.OE)
                                                .then(function (response) {								
                                                        $scope.mensaje = 'Insertado con éxito.';
                                                        $scope.participante=[];
                                                        $scope.listar();
                                                        console.log($scope.mensaje);
                                                }, function (error) {
                                                        $scope.mensaje = error.data.respuesta;
                                                        console.log($scope.mensaje);
                                                });

                                        }, function (error) {
                                                $scope.mensaje = error.data.respuesta;
                                                console.log($scope.mensaje);
                                        });
                        }	
                    }
					
                };


                // manejo del formulario
                // viene con parámetro cuando se invoca desde el botón de actualizar de la grilla
                $scope.mostrarForm = function (esteParticipante) {				

                   if (esteParticipante != undefined && esteParticipante != null) 
                   {
                        // TODO: poner los campos definitivos
                             $scope.participante.a051idproyecto = $scope.pid;
                             $scope.participante.a051codigo = esteParticipante.a051codigo; // id del registro del participante, cuando viene de edición

                             $scope.participante.persona=[];						
                         $scope.participante.persona.a015codigo = '' // tipo de documento												
                             $scope.participante.persona.a052numrdocmnt = '0'; // numero de documento	
                             $scope.participante.persona.a052nombre =  esteParticipante.a052nombre;
                             $scope.participante.persona.a052apellido =  esteParticipante.a052apellido;
                             $scope.participante.persona.a052correlctrnc =  '';
                             $scope.participante.a051responsabilidad = esteParticipante.a051responsabilidad;

                             $scope.participante.persona.a051idpersona = esteParticipante.a051idpersona;	
                             $scope.model.isDisabled = true;

                             // TODO: traer los datos del array de participantes.
                             $scope.consultarPersonaPorId($scope.participante.persona.a051idpersona);

                     } 
                     else 
                     {
                             $scope.participante = new Object();
                             $scope.participante.a051idproyecto = $scope.pid;
                             $scope.participante.persona=[];
                             $scope.participante.persona.a052tipdocmnt.a015codigo = "";
                             $scope.participante.persona.a052tipdocmnt.a052numrdocmnt =  "";
                             $scope.participante.persona.a052nombre =  "";
                             $scope.participante.persona.a052apellido =  "";
                             $scope.participante.persona.a052correlctrnc =  "";
                             $scope.participante.a051responsabilidad = "";

                             $scope.participante.persona.a051idpersona="";
                    }
				
                };
				
                //trae datos de una persona por su Id
                $scope.consultarPersonaPorId = function (id) {
                    $scope.OE = {};
                    $scope.OE.idUsuario = $scope.idUsuario;
					$scope.OE.a052codigo = id;
                    personaSrv.consultarPersonaPorId($scope.OE)
                            .then(function (response) {
								//$scope.persona = response.data.respuesta;									
								$scope.participante.persona = response.data.respuesta[0];
								$scope.participante.persona.a015codigo = $scope.participante.persona.a052tipdocmnt; 
								$scope.participante.persona.a051idpersona = $scope.participante.persona.a052codigo;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };	
				
                //se sabe el id del documento de identidad, se quiere completar el json correspondiente.
                $scope.completarTipoDoc = function (id) 
                {
                        for (var i = 0; i < $scope.tiposDocumento.length; i++) {
                          if ($scope.tiposDocumento[i].a015codigo==id)
                                {
                                        var objeto= {"a015fechacreacion":$scope.tiposDocumento[i].a015fechacreacion, "a015usuariocreacion": $scope.tiposDocumento[i].a015usuariocreacion, "a015fechamodificacion":$scope.tiposDocumento[i].a015fechamodificacion, "a015usuariomodificacion":$scope.tiposDocumento[i].a015usuariomodificacion, "a015descrpcntipdocmnt":$scope.tiposDocumento[i].a015descrpcntipdocmnt,"a015estadoregistro":$scope.tiposDocumento[i].a015estadoregistro,"a015idtippersn":$scope.tiposDocumento[i].a015idtippersn,"a015codigo":$scope.tiposDocumento[i].a015codigo};
                                        return objeto;
                                }
                        }
                }

                //trae datos de una persona por su documento de identidad
                $scope.consultarPersonaPorDocumento = function (id) {
                $scope.OE = {};
                $scope.OE.idUsuario = $scope.idUsuario;
                                    $scope.OE.a052numrdocmnt = id;
                personaSrv.consultarPersonaPorDocumento($scope.OE)
                    .then(function (response) {
                        if(response.data.respuesta.length>0)
                        {
                                //$scope.persona = response.data.respuesta;	
                                $scope.participante.persona = response.data.respuesta[0];
                                $scope.participante.persona.a015codigo = $scope.participante.persona.a052tipdocmnt; 
                                $scope.participante.persona.a051idpersona = $scope.participante.persona.a052codigo;
                                $scope.model.isDisabled = true;
                        }
                        else
                        {

                                //$scope.persona = [];	
                                $scope.participante.persona.a052numrdocmnt = id;
                                $scope.model.isDisabled = false;
                        }


                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                    });
                };
				
				
                // poblar tipos de documento de identidad
                $scope.listarTipoDocumento = function () {
                    $scope.OE = {};
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.tipodocumento= {"a102valor": "Persona Natural", "a102codigo": 1, "a102valorcorto": "PN"};
                    listadoSrv.listarTipoDocumento($scope.OE)
                            .then(function (response) {
                                $scope.tiposDocumento = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
				
                $scope.listar();
                $scope.listarTipoDocumento();
            }]);
