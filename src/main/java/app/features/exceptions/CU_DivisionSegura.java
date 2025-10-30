package app.features.exceptions;

import app.core.utils.ConsoleIO;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;
import app.usecases.UseCase;

public class CU_DivisionSegura implements UseCase {
    @Override
    public String nombre() {
        return " [Excepciones] División Segura";
    }

    @Override
    public void run() {
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Lectura de datos");
        int primer_valor = ConsoleIO.readIntSafe("Primer valor: ");
        int segundo_valor = ConsoleIO.readIntSafe("Segundo valor: ");

        try {
            UtilsColor.imprimirBloque(ContextColor.SUCCESS, "División exitosa: "+primer_valor / segundo_valor);
        } catch (ArithmeticException e) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "Error en división " + e.getMessage());
        }
    }
}
