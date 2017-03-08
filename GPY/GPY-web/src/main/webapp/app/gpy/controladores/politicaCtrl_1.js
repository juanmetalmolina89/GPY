/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('politica.controllers', ['ngSanitize'])
        .controller('politicaCtrl', ['$scope', '$routeParams', 'comunSrv', 'listadoSrv','politicaSrv','$filter', function ($scope, $routeParams, comunSrv, listadoSrv, politicaSrv,$filter) {

                console.log("Controller de politicas!!");
        
                $scope.sesion = comunSrv.obtenerSesion() === null ? 0 : comunSrv.obtenerSesion();
                $scope.idUsuario = $scope.sesion.sub;

                $scope.tpid = $routeParams.tpid;
                $scope.pid = $routeParams.pid;
                $scope.campoObligatorio = 'Campo obligatorio';
                
                $scope.mensaje;
                $scope.listaPoliticas = [];
                $scope.politica = [];

                $scope.cargarConfiguracion = function () {

                    $scope.objeto = {};
                    $scope.objeto.idUsuario = $scope.idUsuario;
                    $scope.objeto.idpoliticaproyecto = $scope.pid;
                    
                    politicaSrv.listar($scope.objeto)
                            .then(function (response) {
                                console.log(">>>>>>>>>>>"+JSON.stringify(response));
                                $scope.listaPoliticas = response.data.respuesta;
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                $scope.cargarConfiguracion();

                $scope.actualizar = function () {

                    politicaSrv.actualizar($scope.politica)
                            .then(function (response) {
                                $scope.mensaje = 'Actualizado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.insertar = function () {

                    politicaSrv.insertar($scope.politica)
                            .then(function (response) {
                                $scope.mensaje = 'Insertado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };

                $scope.borrar = function () {
                    politicaSrv.borrar($scope.politica.id)
                            .then(function (response) {
                                $scope.mensaje = 'Borrado con éxito.';
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };


                $scope.marcar = function (scope) {
                  scope.toggle();
                  //scope.collapsed= !scope.collapsed;
                };

                $scope.toggle = function (scope) {
                  scope.toggle();
                };


                $scope.collapseAll = function () {
                  $scope.$broadcast('angular-ui-tree:collapse-all');
                };

                $scope.expandAll = function () {
                  $scope.$broadcast('angular-ui-tree:expand-all');
                };

                
                $scope.adicioanrHijo = function (hijo, padre) {
                  padre.items.push(hijo)
                };
                
                $scope.listarPoliticas = function () {
                    $scope.OE = new Object();
                    $scope.OE.idUsuario = $scope.idUsuario;
                    politicaSrv.listarPoliticas($scope.OE)
                            .then(function (response) {
                               // agrupamos el resultado por el primer nivel.
                                $scope.listaNivel1 = _.groupBy(response.data.respuesta, 'a003nivel1');
                                for (var i = 1, len = $scope.listaNivel1.length; i <= len; i++) 
                                {
                                    hijos = $filter("filter")( $scope.listaNivel1[i] , {'a003nivel2':parseInt($scope.listaNivel1[i])},true);
                                     $scope.listaNivel2 = _.groupBy($scope.listaNivel1[i], 'a003nivel2');
                                    // por cada resultado, filtramos el segundo y lo agrupamos
                                    console.log(JSON.stringify($scope.listaNivel1[i]));
                                    // por cada resultado, filtramos el tercero y lo agrupamos
                                }
                               
                                console.log($scope.mensaje);
                            }, function (error) {
                                $scope.mensaje = error.data.respuesta;
                                console.log($scope.mensaje);
                            });
                };
                //$scope.listaAutoridadAmb = $filter("filter")( $scope.listaAutoridadAmb, {'a001codigo':parseInt($scope.sesion.autoridadambiental)},true);
                $scope.listarPoliticas();
 
                $scope.data = [{
                  'id': 1,
                  'title': 'POLÍTICA NACIONAL DE CAMBIO CLIMÁTICO',
                  'nodes': [
                    {
                      'id': 17,
                      'title': 'Estrategia Colombiana de Desarrollo Bajo en Carbono-ECDBC',
                      'nodes': [
                        {
                          'id': 176,
                          'title': 'Plan de acción sectorial de mitigación del sector de vivienda',
                          'nodes': []
                        },
                        {
                          'id': 177,
                          'title': 'Plan de acción sectorial de mitigación del sector de agropecuario',
                          'nodes': []
                        },
                        {
                          'id': 178,
                          'title': 'Plan de acción sectorial de mitigación del sector de industria',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 11,
                      'title': 'DESARROLLO RURAL BAJO EN CARBONO Y RESILIENTE AL CLIMA',
                      'nodes': [
                        {
                          'id': 111,
                          'title': 'Promover sistemas de producción agropecuaria y pesquera más adaptados a altas temperaturas, sequías o inundaciones, para mejorar la competitividad, los ingresos y la seguridad alimentaria de poblaciones vulnerables.',
                          'nodes': []
                        },
                        {
                          'id': 112,
                          'title': 'Generar y divulgar información agroclimática estratégica tanto para el desarrollo de la agricultura resiliente al clima, como para el desarrollo de seguros climáticos, y de sistemas de predicción y alerta temprana para la adecuación de calendarios de siembra y la prevención de pérdida de cosechas.',
                          'nodes': []
                        },
                        {
                          'id': 113,
                          'title': 'Promover acciones integrales en fincas, en las chagras o comunidades que ayuden al uso eficiente del suelo, y en donde se privilegien la conservación de las coberturas naturales existentes en las fincas, la restauración de sus áreas degradadas, la intensificación ganadera baja en carbono, la implementación de sistemas agroforestales, la agricultura familiar, la reducción de la deforestación y la restauración de áreas degradas, y la asistencia técnica o transferencia tecnológica agropecuaria que aumente la competitividad y disminuya la vulnerabilidad ante el cambio climático.',
                          'nodes': []
                        },
                        {
                          'id': 114,
                          'title': 'Dentro del escenario de post-conflicto brindar alternativas productivas y de acceso a la tierra en áreas con procesos de ocupación de baldíos, minería ilegal, cultivos ilícitos y/o de ocupación de reservas forestales, que promuevan el mantenimiento o el aumento de las reservas de carbono forestal, el cierre de la frontera agrícola, y el uso de sistemas productivos agropecuarios y forestales resilientes al clima y consistentes con la vocación y las condiciones agroecológicas de dichas zonas.',
                          'nodes': []
                        },
                        {
                          'id': 115,
                          'title': 'Incorporar en los sistemas de asistencia técnica agropecuaria la evaluación y promoción de tecnologías y opciones de adaptación y mitigación en los principales subsectores agrícolas, ganaderos, agroindustriales y de biocombustibles.',
                          'nodes': []
                        },
                        {
                          'id': 116,
                          'title': 'Promover un desarrollo y ordenamiento resiliente al clima y bajo en carbono de los sectores no agropecuarios, en el contexto rural como en los sectores de energía mediante estufas eléctricas y energías alternativas, en el sector de transporte con la implmentaciòn de orientaciones de mitigación y adaptación al cambio climático para la creación de nuevas vías o el mejoramiento de las existentes y en materia de turismo para la creación de usos adecuados a las capacidades de carga de los ecosistemas y según las posibildades definidas',
                          'nodes': []
                        },
                        {
                          'id': 117,
                          'title': 'Promover dentro de las fincas el manejo forestal sostenible, el aprovechamiento sostenible de los recursos naturales, la conservación de los bosques y de las márgenes hídricas, así como la restauración de las áreas degradadas. ',
                          'nodes': []
                        },
                        {
                          'id': 118,
                          'title': 'Someter a revisión las subvenciones (incentivos) que contribuyen al deterioro o disminución en la provisión de servicios ecosistémicos que aportan a la adaptación y mitigación al cambio climático, promover diseños y técnicas de construcción de viviendas en municipios costeros que permitan amortiguar los efectos de eventos extremos y cambio climático',
                          'nodes': []
                        },
                        {
                          'id': 119,
                          'title': 'Incorporar en la planificación, mejoramiento y rehabilitación de infraestructura de adecuación de tierras, la evaluación de los efectos del cambio climático en la disponibilidad hídrica, así como la implementación de opciones para enfrentar los riesgos climáticos como inundaciones o sequías, incluyendo aquellas dirigidas a incentivar el uso eficiente del agua por parte de los usuarios.',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 12,
                      'title': 'DESARROLLO URBANO BAJO EN CARBONO Y RESILIENTE AL CLIMA',
                      'nodes': [
                        {
                          'id': 121,
                          'title': 'Dotar a las ciudades con infraestructura urbanas (i.e. sistemas de acueducto y alcantarillado, sistema transporte urbano, entre otros) resiliente a las inundaciones y/o al aumento del nivel del mar',
                          'nodes': []
                        },
                        {
                          'id': 122,
                          'title': 'Reducir el riesgo climático por desabastecimiento hídrico las ciudades mediante incentivos al uso eficiente del agua y la reducción de pérdidas y agua no contabilizada',
                          'nodes': []
                        },
                        {
                          'id': 123,
                          'title': 'Brindar alternativas de transporte público eficiente e integrados bajos en carbono y resilientes al clima; e incentivos para vehículos de bajas emisiones y la implementación de modos no motorizados.',
                          'nodes': []
                        },
                        {
                          'id': 124,
                          'title': 'Incentivar la reducción constante de la generación de residuos sólidos y líquidos urbanos, así como el re-uso, reciclaje y/o el aprovechamiento de residuos incluyendo la valorización energética de los residuos antes de que lleguen a disposición final en rellenos y el aprovechamiento energético de las emisiones generadas en los rellenos sanitarios y en los sistemas de tratamiento de aguas residuales municipales.',
                          'nodes': []
                        },
                        {
                          'id': 125,
                          'title': 'Incentivar la eficiencia energética residencial y no residencial; y  la construcción sostenible baja en carbono',
                          'nodes': []
                        },
                        {
                          'id': 126,
                          'title': 'Disminuir la exposición a inundaciones y las emisiones por transporte mediante la expansión controlada de ciudades de forma más compacta e interconectada aludiendo además a modelos de desarrollo urbano compacto',
                          'nodes': []
                        },
                        {
                          'id': 127,
                          'title': 'Promover la conservación de la estructura ecológica principal y el manejo del paisaje, a través de la construcción y mantenimiento de espacios públicos urbanos verdes',
                          'nodes': []
                        },
                        {
                          'id': 128,
                          'title': 'Generar conocimiento  cientifico que permita cuantificar la captación de CO2 por parte de las zonas marinas y costeras y diseñar acciones a ser implementadas como respuesta',
                          'nodes': []
                        },
                        {
                          'id': 129,
                          'title': 'Integrar en las políticas, instrumentos y regulación sobre expansión de la oferta energética eléctrica del país, los objetivos de adaptación ante los eventos climáticos, así como medidas de desarrollo bajo en carbono, minimizando aquellas que implican sacrificios entre objetivos.',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 13,
                      'title': 'DESARROLLO MINERO -ENERGÉTICO RESILIENTE AL CLIMA Y BAJO EN CARBONO',
                      'nodes': [
                        {
                          'id': 130,
                          'title': 'Evaluar la utilización de biocombustibles que aseguren  una baja huella de carbono a lo largo de su ciclo de vida y prevengan potenciales impactos a los recursos hídricos, la seguridad alimentaria y a la biodiversidad',
                          'nodes': []
                        },
                        {
                          'id': 131,
                          'title': 'Promover mecanismos eficientes, incluidos instrumentos económicos, para la gestión de la demanda baja en carbono en los diferentes sectores',
                          'nodes': []
                        },
                        {
                          'id': 132,
                          'title': 'Incentivar la adecuada diversificación de la canasta energética, mediante instrumentos y tecnologías que reconozcan beneficios sobre la mitigación de GEI así como cobeneficios en la calidad del aire, resiliencia climática, acceso y seguridad energética, y adicionalmente generar estrategias de coordinación interinstitucional del gobierno nacional que permitan la promoción y el desarrollo de proyectos relacionados con Fuentes No Convencionales de Energía Renovable.',
                          'nodes': []
                        },
                        {
                          'id': 133,
                          'title': 'Fomentar el aprovechamiento de fuentes de energía renovables complementarias a las no renovables con el fin de asegurar el suministro confiable de energía eléctrica en ZNI, considerando los principios de eficiencia y confiabilidad del sistema',
                          'nodes': []
                        },
                        {
                          'id': 134,
                          'title': 'Fomentar el aprovechamiento de fuentes de energía renovables complementarias a las no renovables con el fin de asegurar el suministro confiable de energía eléctrica en ZNI, considerando los principios de eficiencia y confiabilidad del sistema',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 14,
                      'title': 'DESARROLLO DE INFRAESTRUCTURA ESTRATÉGICA BAJA EN CARBONO y RESILIENTE AL CLIMA ',
                      'nodes': [
                        {
                          'id': 141,
                          'title': 'Incorporar consideraciones de cambio climático en el diseño de la infraestructura de transporte, buscando disminuir la exposición y sensibilidad ante amenazas climáticas y/o aumentar la capacidad de adaptación, en especial ante inundaciones, deslizamientos y al aumento del nivel del mar',
                          'nodes': []
                        },
                        {
                          'id': 142,
                          'title': 'Evaluar la vulnerabilidad de la infraestructura de transporte existente e implementar opciones para disminuir su riesgo climático, incluyendo guías de recuperación y mantenimiento que sean adecuados al clima futuro',
                          'nodes': []
                        },
                        {
                          'id': 143,
                          'title': 'Promover el enfoque Evitar-Cambiar-Mejorar (ASI por sus siglas en ingles) el cual implica: i) evitar viajes innecesarios a través de la gestión de la demanada; ii) cambiar, fortaleciendo la inter-modalidad de la carga y pasajeros en articulación con modos mas eficientes (en términos de generación de emisiones por unidad de carga o pasajero, reduciendo además la vulnerabilidad del sistema, iii) mejorar, incrementando la eficiencia energética de vehículos o a través de estrategias de gestión para evitar viajes en vacío.',
                          'nodes': []
                        },
                        {
                          'id': 144,
                          'title': 'Promover la gestión compartida del riesgo climático en alianzas público privadas y otras modalidades contractuales para la construcción, concesión y mantenimiento  de infraestructura de transporte ',
                          'nodes': []
                        },
                        {
                          'id': 145,
                          'title': 'Promover la conservación y restauración de ecosistemas terrestres y marino-costeros que proveen servicios ambientales que favorecen la adaptación al cambio climático de los sistemas socioeconómicos, como los servicios de regulación hídrica y protección contra inundaciones, y avanzar en el desarrollo de medidas de adaptación basadas en ecosistemas',
                          'nodes': []
                        },
                        {
                          'id': 146,
                          'title': 'Incorporar los escenarios de impacto del cambio climático en la gestión del manejo, conservación y restauración de los ecosistemas terrestres y marino-costeros prioritarios por su vulnerabilidad, incluyendo la relacionada con el sistema nacional de áreas protegidas y sus zonas de amortiguación.',
                          'nodes': []
                        },
                        {
                          'id': 147,
                          'title': 'Incorporar en la planificación territorial y del desarrollo sectorial, acciones de manejo y conservación de los ecosistemas y sus servicios, teniendo en cuenta el rol de los mismos en la reducción de emisiones y aumento de la adaptación territorial y sectorial.',
                          'nodes': []
                        },
                        {
                          'id': 148,
                          'title': 'Fortalecer la gobernanza forestal para prevenir la deforestación y degradación forestal',
                          'nodes': []
                        },
                        {
                          'id': 149,
                          'title': 'Incentivar el desarrollo de sistemas urbanos ahorradores de recursos naturales y cuya expansión planifique la integración con los ecosistemas potencialmente afectados y de sistemas de transporte, viales y de generación de energía de bajo impacto ambiental.',
                          'nodes': []
                        },
                        {
                          'id': 1410,
                          'title': 'Promover estrategias y acuerdos territoriales de corto, mediano y largo plazo, para resolver conflictos por el acceso a servicios ambientales vulnerables entre sectores económicos y comunidades',
                          'nodes': []
                        },
                        {
                          'id': 1411,
                          'title': 'Evaluar y fortalecer la capacidad institucional de las autoridades ambientales para garantizar una acción oportuna y de calidad para atender los objetivos de esta estrategia',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 15,
                      'title': 'Plan Nacional de Adaptación de Cambio Climático?',
                      'nodes': [
                        {
                          'id': 151,
                          'title': 'Plan Integral de Cambio Climático de Chocó',
                          'nodes': []
                        },
                        {
                          'id': 152,
                          'title': 'Plan Integral de Cambio Climático de Cali',
                          'nodes': []
                        },
                        {
                          'id': 153,
                          'title': 'Plan Integral de Cambio Climático de Huila',
                          'nodes': []
                        },
                        {
                          'id': 154,
                          'title': 'Plan Integral de Cambio Climático de Cundinamarca',
                          'nodes': []
                        },
                        {
                          'id': 155,
                          'title': 'Plan Integral de Cambio Climático de Bogotá D.C',
                          'nodes': []
                        },
                        {
                          'id': 156,
                          'title': 'Plan de Adaptación al Cambio Climático de San Andrés',
                          'nodes': []
                        },
                        {
                          'id': 157,
                          'title': 'Plan de Adaptación al Cambio Climático de Cartagena',
                          'nodes': []
                        },
                        {
                          'id': 158,
                          'title': 'Plan de Adaptación al Cambio Climático de Montería',
                          'nodes': []
                        },
                        {
                          'id': 159,
                          'title': 'Plan de Adaptación al Cambio Climático de Buga',
                          'nodes': []
                        },
                        {
                          'id': 1510,
                          'title': 'Plan de Adaptación al Cambio Climático de Tuluá',
                          'nodes': []
                        },
                        {
                          'id': 1511,
                          'title': 'Plan de Adaptación al Cambio Climático de Risaralda',
                          'nodes': []
                        },
                        {
                          'id': 1512,
                          'title': 'Plan de Adaptación al Cambio Climático de Nariño',
                          'nodes': []
                        },
                        {
                          'id': 1513,
                          'title': 'Plan de Adaptación al Cambio Climático de Mojana',
                          'nodes': []
                        },
                        {
                          'id': 1514,
                          'title': 'Plan de Adaptación al Cambio Climático de Pitalito',
                          'nodes': []
                        },
                        {
                          'id': 1515,
                          'title': 'Plan de Cambio Climático de Atlántico',
                          'nodes': []
                        },
                        {
                          'id': 1516,
                          'title': 'Plan de Cambio Climático de Cesar',
                          'nodes': []
                        },
                        {
                          'id': 1517,
                          'title': 'Plan de Cambio Climático de Magdalena',
                          'nodes': []
                        },
                        {
                          'id': 1518,
                          'title': 'Plan de Cambio Climático de Cauca',
                          'nodes': []
                        },
                        {
                          'id': 1519,
                          'title': 'Plan de Cambio Climático de Quindío',
                          'nodes': []
                        },
                        {
                          'id': 1520,
                          'title': 'Plan de Cambio Climático de Santander',
                          'nodes': []
                        },
                        {
                          'id': 1521,
                          'title': 'Plan de Cambio Climático de Orinoquía',
                          'nodes': []
                        },
                        {
                          'id': 1522,
                          'title': 'Plan de Cambio Climático de Córdoba',
                          'nodes': []
                        },
                        {
                          'id': 1523,
                          'title': 'Plan de Cambio Climático del Oriente Antioqueño',
                          'nodes': []
                        },
                        {
                          'id': 1524,
                          'title': 'Plan de Cambio Climático del Urabá Antioqueño',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 16,
                      'title': 'Estrategia Nacional de Reducción de Emisiones por Deforestación y Degradación de los bosques (ENREDD+)',
                      'nodes': [
                        {
                          'id': 161,
                          'title': 'Estrategia Nacional de Reducción de Emisiones por Deforestación y Degradación de los bosques (ENREDD+)',
                          'nodes': []
                        }
                      ]
                    },
                    {
                      'id': 17,
                      'title': 'Estrategia Colombiana de Desarrollo Bajo en Carbono-ECDBC',
                      'nodes': [
                        {
                          'id': 171,
                          'title': 'Plan de acción sectorial de mitigación del sector de energía',
                          'nodes': []
                        },
                        {
                          'id': 172,
                          'title': 'Plan de acción sectorial de mitigación del sector de hidrocarburos',
                          'nodes': []
                        },
                        {
                          'id': 173,
                          'title': 'Plan de acción sectorial de mitigación del sector de minería',
                          'nodes': []
                        },
                        {
                          'id': 174,
                          'title': 'Plan de acción sectorial de mitigación del sector de transporte',
                          'nodes': []
                        },
                        {
                          'id': 175,
                          'title': 'Plan de acción sectorial de mitigación del sector de residuos',
                          'nodes': []
                        }
                      ]
                    }
                  ]
                }];


  
  
            }]);





