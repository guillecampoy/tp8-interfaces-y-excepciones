package app.data.exceptions;

public class EdadInvalidaException extends DomainValidationException {
    public EdadInvalidaException(int edad) {
        super("Edad inválida: " + edad + " (debe estar entre 0 y 120).");
    }
}
