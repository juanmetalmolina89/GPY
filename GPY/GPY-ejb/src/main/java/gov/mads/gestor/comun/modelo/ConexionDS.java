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
import javax.sql.DataSource; 
import java.sql.*; 
import javax.naming.InitialContext;
import javax.naming.Context;
import org.apache.log4j.Logger;
import oracle.jdbc.pool.OracleDataSource;
//@Stateless
//@Remote(IRemoteConnection.class)
public class ConexionDS implements IRemoteConnection{

    private static final Logger logger = Logger.getLogger( Conexion.class ); 
    private static Connection instancia = null;
    
    public synchronized static Connection obtenerInstancia() throws Exception {

        try {
            
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:/GPYLOracleDS");
            if( ds != null ) instancia = ds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.fatal( "Error conectando a Datasource GPYOracleDS", ex);
        }
        return instancia;
    }
    
    public synchronized static Connection obtenerConexion() throws Exception {
        //OracleDataSourceFactory ds = OracleDataSource.
        try{
            
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:/GPYLOracleDS");
            if( ds != null ) instancia = ds.getConnection();
        }
        catch(Exception ex){
            ex.printStackTrace();
            logger.error( "Error conectando a Datasource GPYOracleDS", ex);
        }
        return instancia;
    }

    public static void desconectar(Connection instancia) throws Exception {

        if(instancia != null && !instancia.isClosed()) {
            instancia.close();
        }
    }

    public Connection conectar() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup( "java:/GPYOracleDS");
            if( ds != null ) instancia = ds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.fatal( "Error conectando a Datasource GPYOracleDS", ex);
        }
        return instancia;
    }
 }
