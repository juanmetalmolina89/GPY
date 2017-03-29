/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;

/**
 *
 * @author juanmetalmolina
 */
public class OS_Autenticar {
    public OS_Autenticar() {
    }
    
    private Integer codigoError;
    private String mensajeError;




    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }


    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    public Integer getCodigoError() {
        return codigoError;
    }
}
