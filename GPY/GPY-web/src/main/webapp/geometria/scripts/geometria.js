// Cargue del documento

L.Icon.Default.imagePath = 'images/';

var ctrlGeo = IGAC.contenedor('mapid', {
    center: [4.65, -74.15],
    zoom: 13,
    layers: [
        L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
            '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="http://mapbox.com">Mapbox</a>',
            id: 'mapbox.streets'
        })
    ],
    idModulo: getURLParameters('idModulo'),
    idSistema: getURLParameters('idSistema'),
    municipioId: getURLParameters('divipola')
});

//Funciones

var obtenerGeometria = function () {

    var geometria = ctrlGeo.obtenerGeometriasPunto();
    console.log(geometria);
    return geometria;
}

var establecerGeometria = function (geometria) {

    console.log(geometria);
    ctrlGeo.edicionRegistro(geometria);
}

function getURLParameters(paramName) {

    var sURL = window.document.URL.toString();
    if (sURL.indexOf("?") > 0) {
        var arrParams = sURL.split("?");
        var arrURLParams = arrParams[1].split("&");
        var arrParamNames = new Array(arrURLParams.length);
        var arrParamValues = new Array(arrURLParams.length);

        var i = 0;
        for (i = 0; i < arrURLParams.length; i++) {
            var sParam = arrURLParams[i].split("=");
            arrParamNames[i] = sParam[0];
            if (sParam[1] != "")
                arrParamValues[i] = unescape(sParam[1]);
            else
                arrParamValues[i] = "No Value";
        }

        for (i = 0; i < arrURLParams.length; i++) {
            if (arrParamNames[i] == paramName) {
                //alert("Parameter:" + arrParamValues[i]);
                return arrParamValues[i];
            }
        }
        return "No Parameters Found";
    }
}