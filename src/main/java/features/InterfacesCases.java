package features;

import core.SubMenu;

public class InterfacesCases extends SubMenu {

    public InterfacesCases(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {

    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        return false;
    }

    /*
        Parte 1: Interfaces en un sistema de E-commerce
Ampliar con interfaces Pago y PagoConDescuento para distintos medios de
pago (TarjetaCredito, PayPal), con métodos procesarPago(double) y
aplicarDescuento(double).
Crear una interfaz Notificable para notificar cambios de estado. La clase
Cliente implementa dicha interfaz y Pedido debe notificarlo al cambiar de
estado.


     */
}
