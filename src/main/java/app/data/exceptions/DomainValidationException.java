package app.data.exceptions;

public class DomainValidationException extends  RuntimeException {
    public DomainValidationException(String message) { super(message); }
}
