package app.features.exceptions;

import app.core.utils.ConsoleIO;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;
import app.fixtures.FilesSeed;
import app.usecases.UseCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CU_LecturaArchivo implements UseCase {
    @Override
    public String nombre() {
        return " [Excepciones] Lectura archivo";
    }

    @Override public void run() {
        ConsoleIO.hr();
        ConsoleIO.println("Demostración de lectura simple con manejo de casos inválidos\n");

        // Archivo válido (se encuentra en resources)
        leerYMostrar(FilesSeed.DEMO_VALIDO);

        // Caso inválido se apunta a un archivo inexistente
        leerYMostrar(FilesSeed.DEMO_INVALIDO);

        // Se apunta a una carpeta no a un archivo
        leerYMostrar(FilesSeed.DEMO_DIRECTORIO);

        ConsoleIO.pause();
    }

    private void leerYMostrar(String resourcePath) {
        UtilsColor.imprimirBloque (ContextColor.DEFAULT, ">> Se procede a intentar lectura...: " + resourcePath);
        try (InputStream in = FilesSeed.getResourceStream(resourcePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                UtilsColor.imprimirBloque(ContextColor.DEFAULT, linea);
            }
            UtilsColor.imprimirBloque(ContextColor.SUCCESS, "✔ Lectura OK\n");

        } catch (IllegalArgumentException e) {
            UtilsColor.imprimirBloque(ContextColor.ERROR,"⚠ Recurso no encontrado o no válido: " + e.getMessage() + "\n");
        } catch (IOException e) {
            UtilsColor.imprimirBloque(ContextColor.ERROR,"⚠ Error de lectura: " + e.getMessage() + "\n");
        }
    }
}
