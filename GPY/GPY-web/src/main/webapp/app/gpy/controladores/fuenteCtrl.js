/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('fuente.controllers', ['ngSanitize'])
    .controller('fuenteCtrl', ['$scope', 'fuenteSrv', '$routeParams', 'listadoSrv', '$q', '$filter' , '$http','comunSrv' , function ($scope, fuenteSrv, $routeParams, listadoSrv, $q, $filter, $http, comunSrv) {

        $scope.mensaje;
        $scope.fuentes = [];
        $scope.fuente = [];

        $scope.sectores = [];
        $scope.subgrupos = [];
        $scope.categorias = [];
        $scope.subcategorias = [];
        $scope.desagregaciones = []; 
        $scope.unidades = []; 

        $scope.fuente = new Object();
        $scope.fuente.a038idproyecto = $scope.pid;

        $scope.fuente.a045codigo = ""; // sector
        $scope.fuente.a043codigo = ""; // subGrupo
        $scope.fuente.a046codigo = ""; // categoría
        $scope.fuente.a047codigo = ""; // subCategoría
        $scope.fuente.a048codigo = ""; // desagregación, aunque también debe venir el en objeto de la lista como a038iddesgrcatipcc			
        $scope.fuente.a038idunidad = "";

        $scope.muestraForm = true;
        $scope.muestraFormFuentes = false;           
        $scope.muestraFormReportes = false;

        $scope.cancelar = function () {            
            $scope.muestraFormFuentes = false;           
            $scope.muestraFormReportes = false;            
        };
        
        //**************************************
        // manejo de fuentes
        //**************************************        
        
        $scope.listar = function () {
                        
            $scope.OE = new Object();
            $scope.OE.idUsuario = $scope.idUsuario;
            $scope.OE.a038idproyecto = $scope.pid;

            fuenteSrv.listar($scope.OE)
                    .then(function (response) {
                        $scope.fuentes = response.data.respuesta;
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                    });
        }; 

        $scope.eliminar = function (estaFuente) {  
            $scope.OE = new Object();
            $scope.OE.idUsuario = $scope.idUsuario;            
            $scope.OE.fuente={"a038codigo":estaFuente.a038codigo}
            fuenteSrv.borrar($scope.OE)
                    .then(function (response) {
                        $scope.mensaje = 'Borrado con éxito.';
                        comunSrv.mensajeSalida(response);
                        $scope.fuente=[];
                        console.log($scope.mensaje);
                        $scope.listar();
                        $scope.listarSectorIPCC();
                        
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                    });
        };


        // manejo del formulario
        // viene con parámetro cuando se invoca desde el botón de actualizar de la grilla
        $scope.mostrarForm = function (estaFuente) {	
            
           $scope.muestraFormFuentes = true;
           $scope.muestraFormReportes = false;
           
           if (estaFuente != undefined && estaFuente != null) 
           {
                // TODO: poner los campos definitivos
                    $scope.fuente.a038idproyecto = $scope.pid;
                    $scope.fuente.a038codigo = estaFuente.a038codigo; // id del registro de la fuente, cuando viene de edición
                    $scope.fuente.a038nombrfunt = estaFuente.a038nombrfunt;
                    $scope.fuente.a038iddesgrcatipcc = estaFuente.a038iddesgrcatipcc;
                    $scope.fuente.a038factoremision = estaFuente.a038factoremision;
                    $scope.fuente.a038idunidad = estaFuente.a038idunidad;
                    // puebla automaticamente los sectores y posiciona el que estaba almacenado
                    $scope.listarSectorIPCC()
                        .then(function () {
                            $scope.fuente.a045codigo = estaFuente.a045codigo;
                                        
                            // puebla jerarquicamente los subgrupos correspondientes y asocia el que estaba almacenado 
                            $scope.listarSubgrupoIPCC()
                                .then(function () {
                                    $scope.fuente.a043codigo = estaFuente.a043codigo;

                                    // puebla jerarquicamente las categorías correspondientes y asocia la que estaba almacenadq
                                    $scope.listarCategoriaIPCC()
                                        .then(function () {
                                            $scope.fuente.a046codigo = estaFuente.a046codigo;

                                            // puebla jerarquicamente las subcategorías correspondientes y asocia la que estaba almacenadq
                                            $scope.listarSubcategoriaIPCC()
                                                .then(function () {
                                                    $scope.fuente.a047codigo = estaFuente.a047codigo;

                                                    // puebla jerarquicamente las subcategorías correspondientes y asocia la que estaba almacenadq
                                                    $scope.listarDesagregacionIPCC()
                                                        .then(function () {
                                                            $scope.fuente.a048codigo = estaFuente.a048codigo;

                                                        });

                                                });

                                        });

                                });
                            
                        });

                     
             } 
             else 
             {
                 $scope.fuente = new Object();
                 $scope.fuente.a038idproyecto = $scope.pid;
                 $scope.fuente.a038nombrfunt = "";
                 $scope.fuente.a038iddesgrcatipcc = "";
                 $scope.fuente.a038factoremision = "";						
                 $scope.fuente.a038idunidad = "";	
            }

        };

        $scope.guardar = function () {
            if($scope.fuente.a038factoremision !== undefined && $scope.fuente.a038factoremision !== null)
            {

                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    $scope.OE.a002codigo = $scope.pid; // aqui se llama es a002codigo y no a038idproyecto
                    $scope.OE.fuente = new Object();					
                    $scope.OE.fuente.a038nombrfunt = $scope.fuente.a038nombrfunt;
                    $scope.OE.fuente.a038iddesgrcatipcc = {"a048codigo":$scope.fuente.a048codigo};
                    $scope.OE.fuente.a038factoremision = parseFloat($scope.fuente.a038factoremision);
                    $scope.OE.fuente.a038idunidad = $scope.fuente.a038idunidad;
                    
                    if($scope.fuente.a038codigo !== undefined && $scope.fuente.a038codigo !== null)
                    {
                        // es un update {"idUsuario":1,"fuente":{"a038nombrfunt":"Fuente","a038iddesgrcatipcc":{"a048codigo":1},"a038factoremision":100,"a038codigo":1},"a002codigo":1}
                        $scope.OE.fuente.a038codigo = $scope.fuente.a038codigo;
                        fuenteSrv.actualizar($scope.OE)
                            .then(function (response) {
                                    $scope.mensaje = 'fuente actualizada con éxito.';
                                    comunSrv.mensajeSalida(response);
                                    $scope.fuente=[];
                                    $scope.listar();
                                    console.log($scope.mensaje);
                            }, function (error) {
                                    $scope.mensaje = error.data.respuesta;
                                    console.log($scope.mensaje);
                            });
                    }
                    else
                    {
                        // es un insert	// {"idUsuario":1,"fuente":{"a038nombrfunt":"Fuente","a038iddesgrcatipcc":{"a048codigo":1},"a038factoremision":100,"a038codigo":1},"a002codigo":1}					
                        fuenteSrv.insertar($scope.OE)
                                .then(function (response) {
                                        $scope.mensaje = 'fuente insertada con éxito.';
                                        comunSrv.mensajeSalida(response);
                                        $scope.fuente=[];
                                        $scope.listar();
                                        console.log($scope.mensaje);
                                }, function (error) {
                                        $scope.mensaje = error.data.respuesta;
                                        console.log($scope.mensaje);
                                });
                    }
            }
            else
            {
                return;
            }
        };


        //**************************************
        // Reportes de Escenario Base
        //**************************************
        
        $scope.listarEscenarioBase = function (estaFuente) {  
            $scope.fuente = estaFuente;
            $scope.OE = new Object();
            // pinta la grilla
            
            // hace invisible el formulario de fuentes
            $scope.muestraFormFuentes = false;
            
            $scope.OE = new Object();
            $scope.OE.idUsuario = $scope.idUsuario;
            $scope.OE.a010idfuentes = estaFuente.a038codigo;

            fuenteSrv.listarEscenarioBase($scope.OE)
                    .then(function (response) {
                        $scope.reportes = response.data.respuesta;
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                    });
                    
            // hace visible el formulario formReportes
            $scope.muestraFormReportes = true;
                        
            
        };
        
        
        $scope.eliminarEscenarioBase = function (esteEscenario) {  
            $scope.OE = new Object();
            $scope.OE.idUsuario  = $scope.idUsuario;            
            $scope.OE.a010codigo = esteEscenario.a010codigo;
            fuenteSrv.borrarEscenarioBase($scope.OE)
                    .then(function (response) {
                        $scope.mensaje = 'Borrado con éxito.';
                        console.log($scope.mensaje);
                        $scope.listarEscenarioBase($scope.fuente);                        
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                    });
        };
        
        $scope.insertarEscenarioBase = function () {
            $scope.OE = new Object();
            $scope.OE.idUsuario = $scope.idUsuario;            
            $scope.OE.reporteaniofuente = new Object();
            $scope.OE.reporteaniofuente.a010reprtanfunt = $filter('date')($scope.reporte.a010reprtanfunt, 'yyyy-MM-dd');  //dateFilter($scope.reporte.a010reprtanfuntdate, 'yyyy-MM-dd');
            $scope.OE.reporteaniofuente.a010valremsn=$scope.reporte.a010valremsn;
            $scope.OE.reporteaniofuente.a010idfuente={"a038codigo":$scope.fuente.a038codigo};        

            fuenteSrv.insertarEscenarioBase($scope.OE)
                .then(function (response) {
                        $scope.mensaje = 'reporte insertado con éxito.';
                        $scope.escenarioBase=[];
                        $scope.listarEscenarioBase($scope.fuente);
                        console.log($scope.mensaje);
                }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                });
        };
        
        //**************************************
        // Poblar listas desplegables
        //**************************************
        
        
        // poblar combo de sector de IPCC
        $scope.listarSectorIPCC = function () {
            var def = $q.defer();
            
            $scope.OE = {};
            $scope.OE.idUsuario = $scope.idUsuario;

            $scope.subgrupos = [];
            $scope.categorias = [];
            $scope.subcategorias = [];
            $scope.desagregaciones = []; 

            $scope.fuente.a045codigo = ""; // sector
            $scope.fuente.a043codigo = ""; // subGrupo
            $scope.fuente.a046codigo = ""; // categoría
            $scope.fuente.a047codigo = ""; // subCategoría
            $scope.fuente.a048codigo = ""; // desagregación, aunque también debe venir el en objeto de la lista como a038iddesgrcatipcc			

            //$scope.OE.a048idsubcatipcc = 1 // para mostrar datos. en teoría debe ir en null cuando lo modifiquen
            //{"idUsuario":1}
            listadoSrv.listarSectorIPCC($scope.OE)
                    .then(function (response) {
                        $scope.sectores = response.data.respuesta;
                        def.resolve( true );
                     }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                        def.reject( 'error' );
                    });
            return def.promise;
        };

        // poblar combo de subgrupo IPCC
        $scope.listarSubgrupoIPCC = function () {
            var def = $q.defer();
            $scope.OE = {};
            $scope.OE.idUsuario = $scope.idUsuario;

            $scope.fuente.a043codigo = ""; // subGrupo
            $scope.fuente.a046codigo = ""; // categoría
            $scope.fuente.a047codigo = ""; // subCategoría
            $scope.fuente.a048codigo = ""; // desagregación, aunque también debe venir el en objeto de la lista como a038iddesgrcatipcc			

            $scope.categorias = [];
            $scope.subcategorias = [];
            $scope.desagregaciones = []; 

            $scope.OE.a043idsectoripcc = $scope.fuente.a045codigo // el sector actual.
            //{  "idUsuario":1,"a043idsectoripcc":1}
            listadoSrv.listarSubgrupoIPCC($scope.OE)
                    .then(function (response) {
                        $scope.subgrupos = response.data.respuesta;
                        def.resolve( true );
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                        def.reject( 'error' );
                    });
            return def.promise;
        };

        // poblar combo de categoría IPCC
        $scope.listarCategoriaIPCC = function () {
            var def = $q.defer();
            $scope.OE = {};
            $scope.OE.idUsuario = $scope.idUsuario;

            $scope.fuente.a046codigo = ""; // categoría
            $scope.fuente.a047codigo = ""; // subCategoría
            $scope.fuente.a048codigo = ""; // desagregación, aunque también debe venir el en objeto de la lista como a038iddesgrcatipcc			

            $scope.subcategorias = [];
            $scope.desagregaciones = []; 

            $scope.OE.a046idsector = $scope.fuente.a043codigo // el subgrupo actual. confirmar el nombre como se recibe
            //{"idUsuario":1,"a046idsector":1} ... eso esta bien? no deberia ser el subgrupo?
            listadoSrv.listarCategoriaIPCC($scope.OE)
                    .then(function (response) {
                        $scope.categorias = response.data.respuesta;
                        def.resolve( true );
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                        def.reject( 'error' );
                    });
            return def.promise;                    
        };

        // poblar combo de IPCC
        $scope.listarSubcategoriaIPCC = function () {
            var def = $q.defer();
            $scope.OE = {};
            $scope.OE.idUsuario = $scope.idUsuario;

            $scope.fuente.a047codigo = ""; // subCategoría
            $scope.fuente.a048codigo = ""; // desagregación, aunque también debe venir el en objeto de la lista como a038iddesgrcatipcc			

            $scope.desagregaciones = []; 

            $scope.OE.a047idcatipcc = $scope.fuente.a046codigo // La categoría actual.
            // {"idUsuario":1,"a047idcatipcc":1}
            listadoSrv.listarSubcategoriaIPCC($scope.OE)
                    .then(function (response) {
                        $scope.subcategorias = response.data.respuesta;
                        def.resolve( true );
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                        def.reject( 'error' );
                    });
            return def.promise;                    
        };		

        // poblar combo de desagregación de IPCC
        $scope.listarDesagregacionIPCC = function () {
            var def = $q.defer();
            $scope.OE = {};
            $scope.OE.idUsuario = $scope.idUsuario;
            $scope.OE.a048idsubcatipcc = $scope.fuente.a047codigo // la subcategoría actual
            //{"idUsuario":1,"a048idsubcatipcc":1}
            listadoSrv.listarDesagregacionIPCC($scope.OE)
                    .then(function (response) {
                        $scope.desagregaciones = response.data.respuesta;
                        def.resolve( true );
                    }, function (error) {
                        $scope.mensaje = error.data.respuesta;
                        console.log($scope.mensaje);
                        def.reject( 'error' );
                    });
            return def.promise;                    
        };

                       
        $scope.listarUnidades = function () {
            $scope.OE = new Object();
            $scope.OE.idUsuario = $scope.idUsuario;
            $scope.OE.categoria = UNIDADFUENTE;
            listadoSrv.listarParametros($scope.OE)
                    .then(function (response) {
                        $scope.unidades = response.data.respuesta;
                    }, function (error) {
                        comunSrv.mensajeSalida(error);
                    });
        };

        $scope.listar();
        $scope.listarSectorIPCC();
        $scope.listarUnidades();

    }]);


