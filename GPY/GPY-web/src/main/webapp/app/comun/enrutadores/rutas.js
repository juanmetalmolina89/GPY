/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('GPYApp').config(['$routeProvider', '$httpProvider', '$locationProvider', 'jwtInterceptorProvider', function ($routeProvider, $httpProvider, $locationProvider, jwtInterceptorProvider) {
        
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        jwtInterceptorProvider.tokenGetter = function () {
            return localStorage.getItem('token');
        };
        $httpProvider.interceptors.push('jwtInterceptor');
        
	$routeProvider
		.when('/gpy', {
			templateUrl	: 'app/gpy/vistas/listaProyectos.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/adm', {
			templateUrl	: 'app/gpy/vistas/gestionProyectos.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/datbaspre/:tpid', {
			templateUrl	: 'app/gpy/vistas/datosBasicosPre.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/datbaspre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/datosBasicosPre.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/participantespre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/participantes.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/fuentespre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/fuentes.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/actividadespre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/actividades.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/politicaspre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/politicas.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/financiacionpre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/financiacion.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/etapa1pre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/mdlEtapa1.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/etapa2pre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/mdlEtapa2.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/etapa3pre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/mdlEtapa3.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/aprobacionpre/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/aprobacion.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/datbasreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/datosBasicosReg.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/participantesreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/participantesReg.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/fuentesreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/fuentesReg.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/actividadesreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/actividadesReg.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/politicasreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/politicas.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/financiacionreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/financiacionReg.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/documentosreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/aprobacionNacional.html',
			controller 	: 'gestionProyectosCtrl'
		})		
		.when('/gpy/aprobacionreg/:tpid/:pid', {
			templateUrl	: 'app/gpy/vistas/aprobacionRegistro.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/infogralseg/:tpid/:pid', {
			templateUrl	: 'app/comun/vistas/construccion.html',
			controller 	: 'gestionProyectosCtrl'
		})
		.when('/gpy/avanceseg/:tpid/:pid', {
			templateUrl	: 'app/comun/vistas/construccion.html',
			controller 	: 'gestionProyectosCtrl'
		})





		.when('/reportes', {
			templateUrl	: 'app/rpt/vistas/reportes.html',
			controller 	: 'comunCtrl'
		})
		.when('/reportes/a/b/c/d', {
			templateUrl	: 'app/rpt/vistas/reportes.html',
			controller 	: 'comunCtrl'
		})



		
		.when('/adm/crearUsuarios', {
			templateUrl	: 'app/adm/vistas/crearUsuario.html',
			controller 	: 'crearUsuarioCtrl'
		})
		.when('/adm/cambiarClave', {
			templateUrl	: 'app/adm/vistas/cambiarContrasena.html',
			controller 	: 'cambiarContrasenaCtrl'
		})
		.when('/ingresar', {
			templateUrl	: 'app/adm/vistas/ingresoUsuario.html',
			controller 	: 'ingresoUsuarioCtrl'
		})		
		.when('/adm/cuenta', {
			templateUrl	: 'app/adm/vistas/miCuenta.html',
			controller 	: 'miCuentaCtrl'
		})
                //@todo borrar estos dos, se dejan sólo para pruebas
		.when('/adm/cuenta/pn', {
			templateUrl	: 'app/adm/vistas/personaNatural.html',
			controller 	: 'miCuentaCtrl'
		})		
		.when('/adm/cuenta/pj', {
			templateUrl	: 'app/adm/vistas/personaJuridica.html',
			controller 	: 'miCuentaCtrl'
		})
                //fin borrar estos dos
                
                
                
                
		.when('/construccion', {
			templateUrl	: 'app/comun/vistas/construccion.html'//,
			//controller 	: 'gestionProyectosCtrl'
		})
                
                
		.otherwise({
			redirectTo: '/gpy'
		});
}]);

