package com.everis.security;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configuraci�n del endpoint JAX-RS. Este es el punto de partida de toda
 * aplicaci�n JAX-RS.
 *
 * @author Joaqu�n G�lvez G�mez
 */
@ApplicationPath("BMW-api/v1")
public class JAXRSConfiguration extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.server.disableMoxyJson", true);
        return props;
    }
}