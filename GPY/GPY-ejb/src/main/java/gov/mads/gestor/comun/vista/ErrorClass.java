/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.mads.gestor.comun.vista;


import org.apache.log4j.Logger;
/**
 *
 * @author juanmetalmolina
 */
public class ErrorClass {
    private static Logger logger; 
    
    public static void getMessage(ObjetoSalida objetoSalida, Class defined){
        try {
            logger = Logger.getLogger( defined );
        
            if(objetoSalida.getCodError() == CodError.OPERACION_CORRECTA && objetoSalida.getCodError() != null){
                logger.info(objetoSalida.getMsgError());
            }else{
                logger.error(objetoSalida.getMsgError());
            }
        }catch(Exception ex){
            logger.fatal(objetoSalida.getMsgError());
        }
           
    }
    
    
    
}
