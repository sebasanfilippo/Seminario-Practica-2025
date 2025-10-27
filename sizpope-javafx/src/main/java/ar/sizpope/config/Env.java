package ar.sizpope.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env {
    private static final Properties p = new Properties();

    static {
        try (InputStream in = Env.class.getResourceAsStream("/application.properties")) {
            p.load(in);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar application.properties", e);
        }
    }
    public static String get(String key){ return p.getProperty(key); }
}

