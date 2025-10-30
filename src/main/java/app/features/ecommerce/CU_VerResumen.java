package app.features.ecommerce;

import app.usecases.UseCase;
import app.data.model.Pedido;

public class CU_VerResumen implements UseCase {
    private final Pedido pedido;
    public CU_VerResumen(Pedido pedido){ this.pedido = pedido; }
    @Override public String nombre() { return " [E-commerce] Ver resumen Pedido"; }
    @Override public void run() { pedido.mostrarResumen(); }
}
