package app.data.model;

import app.data.interfaces.Notificable;
import app.data.interfaces.Pagable;
import app.data.interfaces.Pago;
import app.data.interfaces.PagoConDescuento;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {
    private List<Producto> productos = new ArrayList<>();
    private Notificable clienteNotificable;
    private EstadoPedido estado = EstadoPedido.CREADO;

    public Pedido(Notificable clienteNotificable) {
        this.clienteNotificable = clienteNotificable;
        notificarCambioEstado();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for(Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }

    public void avanzarEstado(EstadoPedido nuevo) {
        this.estado = nuevo;
        notificarCambioEstado();
    }

    private void notificarCambioEstado() {
        if (clienteNotificable != null) {
            clienteNotificable.notificar("Tu pedido ahora está en estado: " + estado);
        }
    }

    public void mostrarResumen() {
        System.out.println("----- RESUMEN PEDIDO -----");
        System.out.println("Estado actual: " + estado);
        System.out.println("Productos:");
        for (Producto p : productos) {
            System.out.println("- " + p.getNombre() + "  $" + p.getPrecioUnitario());
        }
        System.out.println("Total actual: $" + calcularTotal());
        System.out.println("--------------------------");
    }

    public boolean pagarCon(Pago medioPago) {
        double montoOriginal = calcularTotal();
        double montoFinal = montoOriginal;

        // Si el medio de pago también es un PagoConDescuento,
        // aplico el descuento antes de procesar el pago.
        if (medioPago instanceof PagoConDescuento) {
            PagoConDescuento conDesc = (PagoConDescuento) medioPago;
            montoFinal = conDesc.aplicarDescuento(montoOriginal);
            System.out.println("Monto original: $" + montoOriginal +
                    " | Monto con descuento: $" + montoFinal);
        }

        boolean ok = medioPago.procesarPago(montoFinal);

        if (ok) {
            this.estado = EstadoPedido.PAGADO;
            notificarCambioEstado();
        }

        return ok;
    }

}
