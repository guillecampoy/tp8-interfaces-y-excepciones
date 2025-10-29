package data.interfaces;

public interface Pago {
    default boolean procesarPago(double monto) {
        System.out.println("[Pago] Procesando pago estándar por $" + monto);
        return true;
    }
}
