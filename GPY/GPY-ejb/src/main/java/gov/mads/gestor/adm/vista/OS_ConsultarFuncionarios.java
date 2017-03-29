/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.adm.vista;
import java.util.List;
/**
 *
 * @author juanmetalmolina
 */
public class OS_ConsultarFuncionarios {
    public OS_ConsultarFuncionarios() {
    }
    
    private Integer codigoError;
    private String mensajeError;
    private List<Funcionario> funcionarios;


   

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }


    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    public Integer getCodigoError() {
        return codigoError;
    }
}
