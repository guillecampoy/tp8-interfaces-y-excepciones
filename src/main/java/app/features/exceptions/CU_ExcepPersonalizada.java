package app.features.exceptions;

import app.core.utils.ConsoleIO;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;
import app.data.exceptions.EdadInvalidaException;
import app.usecases.UseCase;

public class CU_ExcepPersonalizada implements UseCase {
    @Override
    public String nombre() {
        return "[Excepciones] Excepción personalizada";
    }

    @Override
    public void run() {
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Lectura de datos");
        ingresoEdad();
    }

    private void ingresoEdad () throws EdadInvalidaException {
        int edad = ConsoleIO.readIntSafe("Primer valor: (0-120)");
        if (edad <= 0 || edad >= 120) throw new EdadInvalidaException(edad);
    }
}
