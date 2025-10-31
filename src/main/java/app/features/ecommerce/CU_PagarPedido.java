package app.features.ecommerce;

import app.core.utils.ConsoleIO;
import app.usecases.UseCase;
import app.data.model.Pedido;
import app.data.mediospago.PayPal;
import app.data.mediospago.TarjetaCredito;

public class CU_PagarPedido implements UseCase {
    private final Pedido pedido;
    public CU_PagarPedido(Pedido pedido){ this.pedido = pedido; }
    @Override public String nombre() { return " [E-commerce] Pagar Pedido (PayPal/Tarjeta)"; }

    @Override public void run() {
        ConsoleIO.hr();
        System.out.println("1) PayPal  |  2) Tarjeta Crédito");
        int opt = ConsoleIO.readMenuOptionAllowed(1,2);

        boolean ok = switch (opt) {
            case 1 -> pedido.pagarCon(new PayPal());
            case 2 -> pedido.pagarCon(new TarjetaCredito());
            default -> { System.out.println("Opción inválida"); yield false; }
        };
        System.out.println(ok ? "Pago OK" : "Pago rechazado");
    }
}
