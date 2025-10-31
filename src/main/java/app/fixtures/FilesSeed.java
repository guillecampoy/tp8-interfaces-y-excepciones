package app.fixtures;

import java.io.InputStream;
import java.net.URL;

public class FilesSeed {
    // Rutas dentro de src/main/resources
    public static final String DEMO_VALIDO    = "demo/archivo_valido.txt";
    public static final String DEMO_INVALIDO  = "demo/no_existe.txt";
    public static final String DEMO_DIRECTORIO= "demo/holapepe/";

    /** Recurso como InputStream (portátil en IDE/JAR). */
    public static InputStream getResourceStream(String relativePath) {
        InputStream stream = FilesSeed.class.getClassLoader().getResourceAsStream(relativePath);
        if (stream == null) {
            throw new IllegalArgumentException("Recurso no encontrado en classpath: " + relativePath);
        }
        return stream;
    }

    /** URL del recurso (por si requerimos inspección). */
    public static URL getResourceURL(String relativePath) {
        URL url = FilesSeed.class.getClassLoader().getResource(relativePath);
        if (url == null) {
            throw new IllegalArgumentException("Recurso no encontrado en classpath: " + relativePath);
        }
        return url;
    }
}