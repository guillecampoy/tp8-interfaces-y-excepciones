package app.features.exceptions;

import app.core.utils.ConsoleIO;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;
import app.usecases.UseCase;

public class CU_TextoANumero implements UseCase {
    @Override
    public String nombre() {
        return " [Excepciones] Conversión cadena a número";
    }

    @Override
    public void run() {
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Lectura de datos");
        String cadena = ConsoleIO.readLine("Ingrese cadena de texto: ");

        try {
            int numero = Integer.parseInt(cadena);
            UtilsColor.imprimirBloque(ContextColor.SUCCESS, "Conversión exitosa!!");
        } catch (NumberFormatException e) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "Error en la conversión " + e.getMessage());
        }
    }
}
