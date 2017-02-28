/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.modelo;

/**
 *
 * @author juanmetalmolina
 */
public class ParametroAdaptador {
    public ParametroAdaptador() {
    }
    private static String LLAVEENC_VITAL = "SIAC1234"; // debe ser de 8 caracteres
    private static String LLAVEENC_SIAC = "1234SIAC"; // debe ser de 8 caracteres

    private static long TIEMPO_VENCIMIENTO = 30; // VALOR EN SEGUNDOS (tenemos diferencia de 5 horas con servidor OSB
    
    public static String GetParametro(String nomParametro) {

        if (nomParametro.toUpperCase().equals("LLAVEENC_VITAL") )
            return LLAVEENC_VITAL;

        if (nomParametro.toUpperCase().equals("LLAVEENC_SIAC") )
            return LLAVEENC_SIAC;

        if (nomParametro.toUpperCase().equals("TIEMPO_VENCIMIENTO") )
            return (new Long(TIEMPO_VENCIMIENTO)).toString();

        return null;
    }

}
