/* 
 * Autor: Yeimmy Lee
 */
var ambiente = 'local';//local, desarrollo, pruebas, produccion
//var ambiente = 'desarrollo';

var urlServidor = getUrlServidor();
var urlPuerto = urlServidor + ":8080/"; // en local
//var urlPuerto = urlServidor + ":8088/"; //en desarrollo
var urlPrincipal = urlPuerto + "GPY-web/";
var urlBackEnd = urlPrincipal + "servicios/";

function getUrlServidor() {

    if (ambiente === 'local') {
        return 'http://127.0.0.1';
    } else if (ambiente === 'desarrollo') {
        //return 'http://172.17.3.90'; // IP POR VPN
        return 'http://132.255.20.182'; // IP PÚBLICA
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
var STANDARMRCDOVOL = 'STANDARMRCDOVOL';
var TIPOPERIODOACREDITA = 'TIPOPERIODOACREDITA';
var TIPOPROYECTOMDL = 'TIPOPROYECTOMDL';
var TIPOINSTRUFINAN = 'TIPOINSTRUFINAN';
var TIPOREPORTE = 'TIPOREPORTE';


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
var RECHAZADO = 25;
var SOLMDL1 = 99;
var APRMDL1 = 100;
var DEVUELTAMDL1 = 101;
var SOLMDL3 = 102;
var APRMDL3 = 103;
var DEVUELTAMDL3 = 104;
var REGISTRO = 24;// igual que aprobado
var SEGUIMIENTO = 27; // en proceso, es lo mismo.  
var SOLPRE = 107;
var SOLREG = 108;
var APRREG = 109;
var DEVUELTAREG = 110;


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


/* GEOMETRÍA */
var IDMODULO = 1; //@todo confirmar este valor
var IDSISTEMA = 1; //@todo confirmar este valor




var USUARIOIDTEMP = 1; //@TODO esto es temporal
var PERSONAIDTEMP = 1; //@TODO esto es temporal
var USERNAMETEMP = "GPY123564869"; //@TODO esto es temporal
var PERFILTEMP = FUNCMADS; //@TODO esto es temporal
