/* 
 * Autor: Yeimmy Lee 
 */
'use strict';

angular.module('GPYApp', ['ngRoute', 'ngSanitize', 'ui.bootstrap', 'ngResource', 'angular-jwt', 'angular-storage', 'ngFileUpload'
				, 'usuario.services', 'comun.services',  'listado.services', 'persona.services', 'representante.services', 'contacto.services', 'datosBasicos.services', 'actividad.services', 'infoMDL.services', 'avance.services', 'grilla.services','financiacion.services', 'participante.services', 'fuente.services'
				, 'usuario.controllers', 'comun.controllers', 'listado.controllers', 'persona.controllers','representante.controllers','contacto.controllers','datosBasicos.controllers','actividad.controllers','infoMDL.controllers','avance.controllers','financiacion.controllers', 'participante.controllers' , 'fuente.controllers'
				, 'GPYApp.directives'
				]);
                                

/* Services */
angular.module('comun.services'                  , []);
angular.module('usuario.services'                , []);
angular.module('listado.services'                , []);
angular.module('persona.services'                , []);
angular.module('representante.services'          , []);
angular.module('contacto.services'               , []);
angular.module('datosBasicos.services'           , []);
angular.module('actividad.services'              , []);
angular.module('infoMDL.services'                , []);
angular.module('avance.services'                 , []);
angular.module('grilla.services'                 , []);
angular.module('financiacion.services'           , []);
angular.module('participante.services'           , []);
angular.module('fuente.services'           		 , []);


/* Controllers */
angular.module('comun.controllers'               , []); 
angular.module('usuario.controllers'             , []);
angular.module('listado.controllers'             , []);
angular.module('persona.controllers'             , []);
angular.module('representante.controllers'       , []);
angular.module('contacto.controllers'            , []);
angular.module('datosBasicos.controllers'        , []);
angular.module('actividad.controllers'           , []);
angular.module('infoMDL.controllers'             , []);
angular.module('avance.controllers'              , []);
angular.module('financiacion.controllers'        , []);
angular.module('participante.controllers'        , []);
angular.module('fuente.controllers'        		 , []);

/* Directives */
angular.module('GPYApp.directives'               , []);


