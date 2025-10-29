package data.entidades.payments;

import data.interfaces.Pago;
import data.interfaces.PagoConDescuento;

public class TarjetaCredito implements Pago, PagoConDescuento {
    private final double MONTO_MINIMO = 10000;
    @Override
    public double aplicarDescuento(double montoOriginal) {
        // dejamos fijo que el descuento es del 10%
        return montoOriginal * 0.9;
    }

    @Override
    public boolean procesarPago(double monto) {
        // Voy a forzar un conflicto (diamante) entre:
        // - Pago.default procesarPago()
        // - PagoConDescuento.default procesarPago()

        if (monto > MONTO_MINIMO) {
            System.out.println("[TarjetaCredito] Aplicamos lógica de PagoConDescuento: (supera monto minimo de 10.000)");
            return PagoConDescuento.super.procesarPago(monto);
        } else {
            System.out.println("[TarjetaCredito] Aplicamos lógica de Pago: (NO supera monto minimo de 10.000)");
            return Pago.super.procesarPago(monto);
        }
    }
}
