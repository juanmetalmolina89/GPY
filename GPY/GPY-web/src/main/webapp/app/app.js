/* 
 * Autor: Yeimmy Lee 
 */
'use strict';
angular.module('GPYApp', ['ui.tree','angular.filter', 'ngRoute', 'ngSanitize', 'ui.bootstrap', 'ngResource', 'angular-jwt', 'angular-storage', 'ngFileUpload'
				, 'usuario.services', 'comun.services',  'listado.services'
                                ,'persona.services', 'representante.services', 'contacto.services'
                                , 'datosBasicos.services', 'actividad.services', 'infoMDL.services'
                                , 'avance.services', 'seguimiento.services', 'grilla.services','financiacion.services','politica.services'
                                , 'participante.services', 'fuente.services','aprobarprereg.services','aprobacionregistro.services','proyecto.services','reporte.services','adjunto.services'
				, 'usuario.controllers', 'comun.controllers', 'listado.controllers', 'persona.controllers'
                                ,'representante.controllers','contacto.controllers','datosBasicos.controllers','actividad.controllers'
                                ,'infoMDL.controllers','avance.controllers','seguimiento.controllers','financiacion.controllers','politica.controllers'
                                , 'participante.controllers' , 'fuente.controllers' , 'aprobarprereg.controllers', 'aprobacionregistro.controllers' ,'aprobacionNacional.controllers' ,'proyecto.controllers','reporte.controllers','adjunto.controllers'
				, 'GPYApp.directives'
				]);
                                

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
angular.module('seguimiento.services'            , []);
angular.module('grilla.services'                 , []);
angular.module('financiacion.services'           , []);
angular.module('politica.services'               , []);
angular.module('participante.services'           , []);
angular.module('fuente.services'           	 , []);
angular.module('aprobacionregistro.services'     , []);
angular.module('aprobarprereg.services'          , []);
angular.module('proyecto.services'               , []);
angular.module('reporte.services'                , []);
angular.module('adjunto.services'                , []);


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
angular.module('seguimiento.controllers'         , []);
angular.module('financiacion.controllers'        , []);
angular.module('participante.controllers'        , []);
angular.module('fuente.controllers'              , []);
angular.module('politica.controllers'            , []);
angular.module('aprobacionregistro.controllers'  , []);
angular.module('aprobacionNacional.controllers'  , []);
angular.module('aprobarprereg.controllers'       , []);
angular.module('proyecto.controllers'            , []);
angular.module('reporte.controllers'             , []);
angular.module('adjunto.controllers'             , []);
/* Directives */
angular.module('GPYApp.directives'               , []);



