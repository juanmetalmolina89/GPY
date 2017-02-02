package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Fuente;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarFuenteOE extends ObjetoEntrada {

	@XmlElement
	private Fuente fuente;
        // Temporal mientras se crean las nuevas entidades
        @XmlElement
        private Integer a002codigo;
	public Fuente getFuente(){
		return this.fuente;
	}

	public void setFuente(Fuente in){
		this.fuente = in;
	}

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }

}
