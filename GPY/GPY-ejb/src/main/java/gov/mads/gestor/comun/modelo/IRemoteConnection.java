/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.modelo;

import java.sql.Connection;

/**
 *
 * @author juanmetalmolina
 */
public interface IRemoteConnection {
    public Connection conectar();
}
