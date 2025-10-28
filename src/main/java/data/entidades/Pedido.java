package data.entidades;

import data.interfaces.Pagable;
import java.util.ArrayList;

public class Pedido implements Pagable {
    private ArrayList<Producto> productos;

    public Pedido() {
        productos = new ArrayList<>();
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for(Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }
}
