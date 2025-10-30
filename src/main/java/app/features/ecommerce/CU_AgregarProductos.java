package app.features.ecommerce;

import app.core.utils.ConsoleIO;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;
import app.fixtures.CatalogoProductosSeed;
import app.usecases.UseCase;
import app.data.model.Pedido;
import app.data.model.Producto;

import java.util.List;

public class CU_AgregarProductos implements UseCase {
    private final Pedido pedido;
    private final CatalogoProductosSeed catalogo;
    public CU_AgregarProductos(Pedido pedido, CatalogoProductosSeed catalogo){
        this.pedido = pedido; this.catalogo = catalogo;
    }
    @Override public String nombre() { return "[E-commerce] Agregar productos al Pedido"; }

    @Override public void run() {
        List<Producto> items = catalogo.catalogo();
        ConsoleIO.hr();
        for (int i=0;i<items.size();i++)
            System.out.printf("%d) %s $%.2f%n", i+1, items.get(i).getNombre(), items.get(i).getPrecioUnitario());
        int idx = ConsoleIO.readIndex1BasedOrZero(items.size());
        if (idx == 0) return;
        Producto elegido = items.get(idx - 1);
        pedido.agregarProducto(elegido);
        UtilsColor.imprimirBloque(ContextColor.SUCCESS, "✔ Agregado: " + elegido.getNombre());
    }
}
