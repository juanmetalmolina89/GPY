/* 
 * Autor: Yeimmy Lee
 */
'use strict';

angular.module('proyecto.services')
        .factory('proyectoSrv', ['$http', function ($http) {

                var urlBase = urlBackEnd + 'proyecto';
                var datos = {};

                /**************************************************************/
                /** DUMMY */
                datos.listarProyectos = function () {
                    console.log("Aqui llamo al método listarProyectos del BE");
                    //return $http.get(urlBase +'/listarProyectos');

                    // @todo quitar esto cuando tengamos el método en el BE */
                    urlBase = 'https://jsonplaceholder.typicode.com/users';
                    return $http.get(urlBase);
                    // fin quitar esto cuando tengamos el método en el BE */

                };

                datos.consultarPorId = function (id) {
                    console.log("Aqui llamo al método consultarPorId del BE");
                    //return $http.get(urlBase + '/' + id);

                    // @todo quitar esto cuando tengamos el método en el BE */
                    urlBase = 'https://jsonplaceholder.typicode.com/users';
                    return $http.get(urlBase + '/' + id);
                    // fin quitar esto cuando tengamos el método en el BE */
                };

                datos.insertar = function (OE) {
                    console.log("Aqui llamo al método insertar del BE");
                    //return $http.post(urlBase +'/insertar', OE);

                    // @todo quitar esto cuando tengamos el método en el BE */ 
                    urlBase = urlBackEnd + 'prueba/saludo';
                    return $http.post(urlBase, OE);
                    // fin quitar esto cuando tengamos el método en el BE */ 
                };

                datos.actualizar = function (OE) {
                    console.log("Aqui llamo al método actualizar del BE");
                    //return $http.post(urlBase +'/actualizar', OE);

                    // @todo quitar esto cuando tengamos el método en el BE */ 
                    urlBase = urlBackEnd + 'prueba/saludo';
                    return $http.post(urlBase, OE);
                    // fin quitar esto cuando tengamos el método en el BE */ 
                };

                datos.listarProyectosAsoc = function (id) {
                    console.log("Aqui llamo al método listarProyectosAsoc del BE");
                    //return $http.get(urlBase +'/listarProyectosAsoc/'+id);

                    // @todo quitar esto cuando tengamos el método en el BE */
                    urlBase = 'https://jsonplaceholder.typicode.com/users';
                    return $http.get(urlBase+ '/' + id);
                    // fin quitar esto cuando tengamos el método en el BE */

                };

                return datos;
            }]);


