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

public class CU_TryWhitResources implements UseCase {
    @Override
    public String nombre() {
        return "[Excepciones] Manejo IOException";
    }

    @Override public void run() {
        ConsoleIO.hr();
        ConsoleIO.println("Demostración de try-with-resources (cierre automático)\n");

        // OK
        leerConTWR(FilesSeed.DEMO_VALIDO);

        // Inexistente
        leerConTWR(FilesSeed.DEMO_INVALIDO);

        // Directorio
        leerConTWR(FilesSeed.DEMO_DIRECTORIO);
    }

    private void leerConTWR(String resourcePath) {
        System.out.println(">> Try-with-resources sobre: " + resourcePath);
        try (InputStream in = FilesSeed.getResourceStream(resourcePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            br.lines().forEach(System.out::println);
            UtilsColor.imprimirBloque(ContextColor.SUCCESS,"✔ Lectura OK\n");

        } catch (IllegalArgumentException e) {
            UtilsColor.imprimirBloque(ContextColor.ERROR,"⚠ Recurso no encontrado o inválido: " + e.getMessage() + "\n");
        } catch (IOException e) {
            UtilsColor.imprimirBloque(ContextColor.ERROR,"⚠ Error de E/S: " + e.getMessage() + "\n");
        }
    }
}
