package data.interfaces;

public interface PagoConDescuento{
    double aplicarDescuento(double montoOriginal);
    default boolean procesarPago(double monto) {
        System.out.println("[PagoConDescuento] Procesando pago con descuento final $" + monto);
        return true;
    }
}
