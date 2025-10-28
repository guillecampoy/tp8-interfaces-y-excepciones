package data.interfaces;

public interface Pago {
    double procesarPago(double valor);
    double aplicarDescuento(double valor);
}
