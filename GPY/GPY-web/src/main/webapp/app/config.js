/* 
 * Autor: Yeimmy Lee
 */
var ambiente = 'local';//local, desarrollo, pruebas, produccion

var urlServidor = getUrlServidor();
var urlPuerto = urlServidor + ":8070/";
var urlPrincipal = urlPuerto + "GPY-web/";
var urlBackEnd = urlPrincipal + "servicios/";

function getUrlServidor() {

    if (ambiente === 'local') {
        return 'http://127.0.0.1';
    } else if (ambiente === 'desarrollo') {
        return 'http://172.16.3.90';
    }
}


var isDebug = false;


/* CATEGORIAS */
var TIPOPERSONA = 'TIPOPERSONA';
var TIPOREPRESENTANTE = 'TIPOREPRESENTANTE';
var TIPOPERSJURIDICA = 'TIPOPERSJURIDICA';
var CLASEUSUARIO = 'CLASEUSUARIO';
var TIPOPROYECTO = 'TIPOPROYECTO';
var ALCANCE = 'ALCANCE';
var UBICACION = 'UBICACION';
var ESTADOPROYECTO = 'ESTADOPROYECTO';
var TIPOPROYECTOMDL = 'TIPOPROYECTOMDL';
var SECTORAL = 'SECTORAL';
var ESCALA = 'ESCALA';


/* TIPOS PERSONA */
var NATURAL = 1;
var JURIDICA = 2;
var REPLEGAL = 3;
var APODERADO = 4;
var JURIDPUBL = 5;
var JURIDPRIV = 6;


/* PERFILES */
var FUNCMADS = 7;
var ADMINAA = 8;
var GESTPROY = 9;
var PUBLICADOR = 10;
var INVITADO = 11;


/* TIPOS PROYECTO */
var NAMA = 12;
var PBDBCRC = 13;
var MDL = 14;
var MDL_POA = 15;
var CPA = 16;


/* ESTADOS PROYECTO */
var NUEVO = 0;//@TODO actualizar el código cuando lo creen en la tabla 
var PREREGISTRO = 23;
var REGISTRO = 99999999;//@TODO actualizar el código cuando lo creen en la tabla 
var SEGUIMIENTO = 999999999;//@TODO actualizar el código cuando lo creen en la tabla 


/* PANTALLAS */
var DATOSBASICOSPRE = 1;
var PARTICIPANTESPRE = 2;
var FUENTESPRE = 3;
var ACTIVIDADESPRE = 4;
var POLITICASPRE = 5;
var FINANCIANCIONPRE = 6;
var MDLETP1PRE = 7;
var MDLETP2PRE = 8;
var MDLETP3PRE = 9;
var APROBACIONPRE = 10;
var DATOSBASICOSREG = 11;
var PARTICIPANTESREG = 12;
var FUENTESREG = 13;
var ACTIVIDADESREG = 14;
var POLITICASREG = 15;
var FINANCIANCIONREG = 16;
var DOCUMENTOSREG = 17;
var MDLETP1REG = 18;
var MDLETP2REG = 19;
var MDLETP3REG = 20;    
var APROBACIONREG = 21;
var INFOGRALSEG = 22;
var AVANCESEG = 23;


/* CERO */
var CERO = '0';


var COLOMBIA = 51;






var USUARIOIDTEMP = 1; //@TODO esto es temporal
var PERSONAIDTEMP = 1; //@TODO esto es temporal
var USERNAMETEMP = "GPY123564869"; //@TODO esto es temporal
var PERFILTEMP = FUNCMADS; //@TODO esto es temporal
