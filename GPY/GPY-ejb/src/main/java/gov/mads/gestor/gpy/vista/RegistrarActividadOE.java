package gov.mads.gestor.gpy.vista;
import gov.mads.gestor.comun.vista.ObjetoEntrada;

import gov.mads.gestor.comun.entidades.Actividad;
import gov.mads.gestor.comun.entidades.ActividadGeometria;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Chacon
*/
@XmlRootElement
public class RegistrarActividadOE extends ObjetoEntrada {

	@XmlElement
	private Actividad actividad;
        
        @XmlElement
        private ActividadGeometria geometria;
        @XmlElement
        private Object a042geometriasitio;
        @XmlElement
        private Object a042geometriaintersec;
        
	public Actividad getActividad(){
		return this.actividad;
	}

	public void setActividad(Actividad in){
		this.actividad = in;
	}

        public ActividadGeometria getGeometria() {
            return geometria;
        }

        public void setGeometria(ActividadGeometria geometria) {
            this.geometria = geometria;
        }

        public Object getA042geometriasitio() {
            return a042geometriasitio;
        }

        public void setA042geometriasitio(Object a042geometriasitio) {
            this.a042geometriasitio = a042geometriasitio;
        }

        public Object getA042geometriaintersec() {
            return a042geometriaintersec;
        }

        public void setA042geometriaintersec(Object a042geometriaintersec) {
            this.a042geometriaintersec = a042geometriaintersec;
        }

}
