package app.features.ecommerce;

import app.core.utils.ConsoleIO;
import app.usecases.UseCase;
import app.data.model.EstadoPedido;
import app.data.model.Pedido;

public class CU_AvanzarEstado implements UseCase {
    private final Pedido pedido;
    public CU_AvanzarEstado(Pedido pedido){ this.pedido = pedido; }
    @Override public String nombre() { return " [E-commerce] Avanzar estado Pedido"; }

    @Override public void run() {
        ConsoleIO.hr();
        for (int i = 0; i< EstadoPedido.values().length; i++)
            System.out.printf("%d) %s%n", i+1, EstadoPedido.values()[i]);
        int idx = ConsoleIO.readIndex1BasedOrZero(EstadoPedido.values().length);
        if (idx == 0) return;

        pedido.avanzarEstado(EstadoPedido.values()[idx-1]);
    }
}
