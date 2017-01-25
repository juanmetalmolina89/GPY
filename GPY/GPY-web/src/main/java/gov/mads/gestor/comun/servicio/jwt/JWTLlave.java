package gov.mads.gestor.comun.servicio.jwt;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;

public class JWTLlave {

    private static RsaJsonWebKey instancia = null;

    public synchronized static RsaJsonWebKey obtenerInstancia() throws JoseException {

        if (instancia == null) {
            instancia = RsaJwkGenerator.generateJwk(2048);
        }
        return instancia;
    }
}
