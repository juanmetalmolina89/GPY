package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarAvanceOE extends ObjetoEntrada {
    // Ajuste en Registrar Avance debido a cambios en el procedimiento de almacenado
    @XmlElement
    private Integer a002codigo;
    @XmlElement
    private Integer a057idpantalla;

    public Integer getA002codigo() {
        return a002codigo;
    }

    public void setA002codigo(Integer a002codigo) {
        this.a002codigo = a002codigo;
    }
    
    /*@XmlElement
	private Integer A05IDPROYECTO;
	@XmlElement
	private Integer NvoEstado;

	public Integer getA05IDPROYECTO(){
		return this.A05IDPROYECTO;
	}

	public void setA05IDPROYECTO(Integer in){
		this.A05IDPROYECTO = in;
	}
	public Integer getNvoEstado(){
		return this.NvoEstado;
	}

	public void setNvoEstado(Integer in){
		this.NvoEstado = in;
	}*/

    public Integer getA057idpantalla() {
        return a057idpantalla;
    }

    public void setA057idpantalla(Integer a057idpantalla) {
        this.a057idpantalla = a057idpantalla;
    }


}
