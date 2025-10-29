package data.entidades.payments;

import data.interfaces.Pago;

public class PayPal implements Pago {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("[PayPal] Pago enviado por $" + monto);
        return true;
    }
}
