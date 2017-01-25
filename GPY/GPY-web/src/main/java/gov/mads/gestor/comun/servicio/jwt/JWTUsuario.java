package gov.mads.gestor.comun.servicio.jwt;

public class JWTUsuario {

    private String codigoUsuario;
    private String codigoPersona;
    private String username;
    private String nombre;
    private String perfil;
    private String car;
    private String primeravez;
    private Integer tiemposesion = 10;
    private Integer minexpiracion =240;

    public String getUserName() {

        return username;
    }

    public void setUserName(String username) {

        this.username = username;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getPerfil() {

        return perfil;
    }

    public void setPerfil(String perfil) {

        this.perfil = perfil;
    }

    public String getCar() {

        return car;
    }

    public void setCar(String car) {

        this.car = car;
    }

    public String getPrimeraVez() {

        return primeravez;
    }

    public void setPrimeraVez(String primeravez) {

        this.primeravez = primeravez;
    }

    public Integer getMinExpiracion() {

        return minexpiracion;
    }

    public void setMinExpiracion(Integer minexpiracion) {

        this.minexpiracion = minexpiracion;
    }

    public Integer getTiempoSesion() {
        return tiemposesion;
    }

    public void setTiempoSesion(Integer tiemposesion) {
        this.tiemposesion = tiemposesion;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(String codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
}
