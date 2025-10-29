package app.features.ecommerce;

import app.usecases.UseCase;
import app.data.mediospago.TarjetaCredito;

public class CU_DemoDiamantePagos implements UseCase {
    @Override public String nombre() { return "[DEMO] Diamante de interfaces (Pago vs PagoConDescuento)"; }
    @Override public void run() {
        var tc = new TarjetaCredito();
        System.out.println("Monto 9.000 => rama Pago");
        tc.procesarPago(9_000);
        System.out.println("Monto 15.000 => rama PagoConDescuento");
        tc.procesarPago(15_000);
    }
}
