package app.features.exceptions;

import app.usecases.UseCase;

public class CU_ExcepPersonalizada implements UseCase {
    @Override
    public String nombre() {
        return "[Excepciones] Excepción personalizada";
    }

    @Override
    public void run() {

    }
}
