package app.data.mediospago;

import app.data.interfaces.Pago;

public class PayPal implements Pago {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("[PayPal] Pago enviado por $" + monto);
        return true;
    }
}
