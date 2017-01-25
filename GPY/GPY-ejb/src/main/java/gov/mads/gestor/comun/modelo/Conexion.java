package gov.mads.gestor.comun.modelo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.File;

public class Conexion {

    private static Conexion intancia = null;

    private Properties configuracion = null;

    private Conexion() throws Exception {

        obtenerConfiguracion();
    }

    private void obtenerConfiguracion() throws Exception {

        if (configuracion == null) {
            String archivoDefecto = "/home/juanmetalmolina/NetBeansProjects/gpy/GPY/GPY-ejb/src/main/java/gov/mads/gestor/comun/modelo/gestor.Conexion.xml";//"F:\\gpy\\GPY\\GPY-ejb\\src\\main\\java\\gov\\mads\\gestor\\comun\\modelo\\gestor.Conexion.xml";//"/home/juanmetalmolina/NetBeansProjects/gpy/GPY/GPY-ejb/src/main/java/gov/mads/gestor/comun/modelo/gestor.Conexion.xml";//"C:\\Users\\Julio C\\Documents\\NetBeansProjects\\invent\\IVE-ejb\\src\\main\\java\\com\\mads\\invent\\comun\\modelo\\invent.Conexion.xml";
 //           String archivoDefecto = "C:\\jboss-as-7.1.1.Final\\docs\\GPY\\gestor.Conexion.xml";
            String archivoConfiguracion = (System.getenv("mads.gestor.config") == null || System.getenv("mads.gestor.config").equals("")) ? archivoDefecto : System.getenv("mads.gestor.config");
            configuracion = new Properties();
            configuracion.loadFromXML(new FileInputStream(archivoConfiguracion));
        }
    }

    public static Conexion obtenerInstancia() throws Exception {

        if (intancia == null) {
            intancia = new Conexion();
        }
        return intancia;
    }

    public Connection obtenerConexion() throws Exception {

        Class.forName(configuracion.getProperty("className"));
        Connection conexion = DriverManager.getConnection(configuracion.getProperty("url"), configuracion.getProperty("user"), configuracion.getProperty("password"));
        return conexion;
    }

    public static void desconectar(Connection con) throws Exception {

        if(con != null && !con.isClosed()) {
            con.close();
        }
    }
}

/*
import javax.sql.DataSource; 
import java.sql.*; 
import java.util.ArrayList; 
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.Context;
import org.apache.log4j.Logger;

public class Conexion {

    private static final Logger logger = Logger.getLogger( Conexion.class ); 
    private static Connection instancia = null;

    public synchronized static Connection obtenerInstancia() throws Exception {

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup( "java:/GPYOracleDS");
            if( ds != null ) instancia = ds.getConnection();
        } catch (Exception ex) {
            logger.fatal( "Error conectando a Datasource GPYOracleDS", ex);
        }
        return instancia;
    }

    public static void desconectar() throws Exception {

                if(instancia != null && !instancia.isClosed()) {
                    instancia.close();
                }
    }
 }

*/
