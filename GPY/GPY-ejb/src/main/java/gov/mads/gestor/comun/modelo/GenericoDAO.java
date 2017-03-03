package gov.mads.gestor.comun.modelo;

import gov.mads.gestor.adm.modelo.impl.PersonaDAO;
import gov.mads.gestor.comun.vista.CodError;
import gov.mads.gestor.comun.vista.ErrorClass;
import gov.mads.gestor.comun.vista.ObjetoSalida;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Blob;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class GenericoDAO {
    
    public ObjetoSalida ejecutar(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    else{
                        if (parametro.getTipoDato() == OracleTypes.CLOB) {
                            Clob clob = con.createClob();
                            clob.setString(1, parametro.getValor().toString());
                            callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                            } 
                        else {
                            callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                            }
                    }
                } else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
            }

            callableStatement.setInt("p_IdUsuario", sentencia.getIdUsuario());
            callableStatement.registerOutParameter("p_Respuesta", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("p_codError", OracleTypes.INTEGER);
            callableStatement.registerOutParameter("p_msjError", OracleTypes.VARCHAR);

            callableStatement.execute();

            objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_codError")));
            objetoSalida.setMsgError(callableStatement.getString("p_msjError"));

            if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {
                
                try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_Respuesta"))){
                    ResultSetMetaData infoResultado = datos.getMetaData();
                    Integer columnas = infoResultado.getColumnCount();
                    List<HashMap<String, Object>> respuesta = new ArrayList<HashMap<String, Object>>();

                    while (datos.next()) {
                        HashMap<String, Object> registro = new HashMap<String, Object>(columnas);
                        for (Integer i = 1; i <= columnas; ++i) {
                            if (infoResultado.getColumnType(i) == OracleTypes.BLOB) {
                                Blob clob = datos.getBlob(i);
                                InputStream blob = clob.getBinaryStream(1, (int) clob.length()); 
                                StringWriter writer = new StringWriter();
                                IOUtils.copy(blob, writer, "UTF-8");
                                String theString = writer.toString();
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), (clob == null) ? datos.getObject(i) : theString);
                            }
                            else {
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));                                
                            }
                        }
                        respuesta.add(registro);
                    }

                    objetoSalida.setRespuesta(respuesta);
                    
                }catch(Exception e){
                    objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    objetoSalida.setMsgError("NO SE ENCONTRARON DATOS " +e.getMessage());
                }
                
            }
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString());
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }

    public Connection conectar() throws Exception {

        //return Conexion.obtenerInstancia().obtenerConexion();
        //return ConexionDS.obtenerConexion();
        return ConexionDS.obtenerInstancia();
    }

    private String obtenerSQL(SentenciaDAO sentencia) {

        String parametrosAdicioanles = "";
        for (SentenciaParametroDAO parametro : sentencia.getParametros())
            parametrosAdicioanles += "?, ";

        return "{call " + sentencia.getNombre() + " (?, " + parametrosAdicioanles + " ?, ?, ?)}";
    }
    
    public ObjetoSalida ejecutarX(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

        Connection con = conectar();
        
        try {

            CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
            for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                    if (parametro.getTipoDato() == OracleTypes.BLOB) {
                        Blob blob = con.createBlob();
                        blob.setBytes(1, parametro.getValor().toString().getBytes());
                        callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                    }
                    if (parametro.getTipoDato() == OracleTypes.CLOB) {
                        Clob clob = con.createClob();
                        clob.setString(1, parametro.getValor().toString());
                        callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                    } else {
                        callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                    }
                }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                    callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                }
            }

            callableStatement.setInt("p_IdUsuario", sentencia.getIdUsuario());
            callableStatement.registerOutParameter("p_resultado", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("p_codError", OracleTypes.INTEGER);
            callableStatement.registerOutParameter("p_msjError", OracleTypes.VARCHAR);

            callableStatement.execute();

            objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_codError")));
            objetoSalida.setMsgError(callableStatement.getString("p_msjError"));
                
            if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {

                try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_resultado"))){
                    ResultSetMetaData infoResultado = datos.getMetaData();
                    Integer columnas = infoResultado.getColumnCount();
                    List<HashMap<String, Object>> respuesta = new ArrayList<HashMap<String, Object>>();

                    while (datos.next()) {
                        HashMap<String, Object> registro = new HashMap<String, Object>(columnas);
                        for (Integer i = 1; i <= columnas; ++i) {
                            registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                        }
                        respuesta.add(registro);
                    }

                    objetoSalida.setRespuesta(respuesta);
                    
                }catch(Exception e){
                    objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                    objetoSalida.setMsgError(callableStatement.getString("p_msjError"));
                }
            }
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.toString());
            ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
        } finally {
            ConexionDS.desconectar(con);
            //Conexion.desconectar(con);
        }

        return objetoSalida;
    }
    
    public ObjetoSalida ejecutarReporte(SentenciaDAO sentencia, ObjetoSalida objetoSalida) throws Exception {

            Connection con = conectar();

            try {

                CallableStatement callableStatement = con.prepareCall(obtenerSQL(sentencia));
                for (SentenciaParametroDAO parametro : sentencia.getParametros()) {
                    if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.ENTRADA) {
                        if (parametro.getTipoDato() == OracleTypes.BLOB) {
                            Blob blob = con.createBlob();
                            blob.setBytes(1, parametro.getValor().toString().getBytes());
                            callableStatement.setObject(parametro.getNombre(), blob, parametro.getTipoDato());
                        }
                        if (parametro.getTipoDato() == OracleTypes.CLOB) {
                            Clob clob = con.createClob();
                            clob.setString(1, parametro.getValor().toString());
                            callableStatement.setObject(parametro.getNombre(), clob, parametro.getTipoDato());
                        } else {
                            callableStatement.setObject(parametro.getNombre(), parametro.getValor(), parametro.getTipoDato());
                        }
                    }else if (parametro.getTipoParametro() == SentenciaTipoParametroDAO.SALIDA) {
                        callableStatement.registerOutParameter(parametro.getNombre(), parametro.getTipoDato());
                    }
                }

                callableStatement.setInt("p_IdUsuario", sentencia.getIdUsuario());
                callableStatement.registerOutParameter("p_resultado", OracleTypes.CURSOR);
                callableStatement.registerOutParameter("p_codError", OracleTypes.INTEGER);
                callableStatement.registerOutParameter("p_msjError", OracleTypes.VARCHAR);

                callableStatement.execute();

                objetoSalida.setCodError(CodError.forValue(callableStatement.getInt("p_codError")));
                objetoSalida.setMsgError(callableStatement.getString("p_msjError"));
                if (callableStatement.getString("P_A103NOMBREPLANTILLA")!= null){
                    objetoSalida.setNombrePlantilla(callableStatement.getString("P_A103NOMBREPLANTILLA"));
                }
                if (objetoSalida.getCodError() == CodError.OPERACION_CORRECTA) {

                    try(ResultSet datos = ((ResultSet) callableStatement.getObject("p_resultado"))){
                        ResultSetMetaData infoResultado = datos.getMetaData();
                        Integer columnas = infoResultado.getColumnCount();
                        List<HashMap<String, Object>> respuesta = new ArrayList<HashMap<String, Object>>();

                        while (datos.next()) {
                            HashMap<String, Object> registro = new HashMap<String, Object>(columnas);
                            for (Integer i = 1; i <= columnas; ++i) {
                                registro.put(infoResultado.getColumnName(i).toLowerCase(), datos.getObject(i));
                            }
                            respuesta.add(registro);
                        }

                        objetoSalida.setRespuesta(respuesta);

                    }catch(Exception e){
                        objetoSalida.setCodError(CodError.NO_SE_ENCONTRARON_DATOS);
                        objetoSalida.setMsgError(callableStatement.getString("p_msjError"));
                    }
                }
                ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            } catch (Exception e) {

                objetoSalida.setCodError(CodError.ERROR_INTERNO);
                objetoSalida.setMsgError(e.toString());
                ErrorClass.getMessage(objetoSalida,GenericoDAO.class);
            } finally {
                ConexionDS.desconectar(con);    
                //Conexion.desconectar(con);
            }

            return objetoSalida;
        }
}
