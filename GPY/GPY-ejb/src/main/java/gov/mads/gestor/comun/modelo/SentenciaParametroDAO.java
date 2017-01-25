package gov.mads.gestor.comun.modelo;

public class SentenciaParametroDAO {

    private String nombre;
    private Object valor;
    private SentenciaTipoParametroDAO tipoParametro;
    private int tipoDato;

    public SentenciaParametroDAO(String nombre, Object valor, SentenciaTipoParametroDAO tipoParametro, int tipoDato) {

        this.nombre = nombre;
        this.valor = valor;
        this.tipoParametro = tipoParametro;
        this.tipoDato = tipoDato;
    }

    public SentenciaTipoParametroDAO getTipoParametro() {

        return tipoParametro;
    }

    public void setTipoParametro(SentenciaTipoParametroDAO tipoParametro) {

        this.tipoParametro = tipoParametro;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Object getValor() {

        return valor;
    }

    public void setValor(Object valor) {

        this.valor = valor;
    }

    public int getTipoDato() {

        return tipoDato;
    }

    public void setTipoDato(int tipoDato) {

        this.tipoDato = tipoDato;
    }
}
