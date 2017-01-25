package gov.mads.gestor.comun.modelo;

import java.util.List;

public class SentenciaDAO {

    private String nombre;
    private Integer idUsuario;
    private List<SentenciaParametroDAO> parametros;

    public SentenciaDAO(String nombre, Integer idUsuario) {

        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {

        this.idUsuario = idUsuario;
    }

    public List<SentenciaParametroDAO> getParametros() {

        return parametros;
    }

    public void setParametros(List<SentenciaParametroDAO> parametros) {

        this.parametros = parametros;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
}
