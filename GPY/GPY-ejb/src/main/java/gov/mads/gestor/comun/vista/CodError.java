/*
 * Objeto codificacion de error
 */

package gov.mads.gestor.comun.vista;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum CodError {

    OPERACION_CORRECTA(0),
    FILTRO_INVALIDO(1),
//    NUMERO_INVALIDO(2),
//    ERROR_EN_EL_VALOR(3),
    IDENTIFICADDOR_INVALIDO(4),
    NO_SE_ENCONTRARON_DATOS(5),
//    ERROR_AL_CONSULTAR_DATOS(6),
    REGISTRO_INACTIVO(7),
    USUARIO_O_CONTRASENA_INVALIDOS(8),
    CONTRASENA_ACTUAL_INVALIDA(9),
    NUEVA_CONTRASENA_VACIA(10),
//    CONTRASENA_INVALIDA(11),
    ERROR_INTERNO(99),
    MENSAJE_NO_PARAMETRIZADO(999);

    private static final Map<Integer, CodError> typesByValue = new HashMap<Integer, CodError>();

    static {
        for (CodError type : CodError.values()) {
            typesByValue.put(type.valor, type);
        }
    }

    private final Integer valor;

    private CodError(Integer valor) {

        this.valor = valor;
    }

    public static CodError forValue(Integer value) {

        return typesByValue.get(value);
    }

    @JsonValue
    public Integer getValor() {

        return this.valor;
    }
}
