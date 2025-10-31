package app.features.ecommerce;

import app.core.utils.ConsoleIO;
import app.fixtures.ClientesSeed;
import app.usecases.UseCase;
import app.data.model.Cliente;
import app.data.model.Pedido;

public class CU_CrearPedido implements UseCase {
    private final ClientesSeed clientes;
    public CU_CrearPedido(ClientesSeed clientes){ this.clientes = clientes; }

    @Override public String nombre() { return " [E-commerce] Crear Pedido"; }

    @Override public void run() {
        String nombre = ConsoleIO.readLine("Nombre cliente (enter para seed): ");
        String contacto = ConsoleIO.readLine("Contacto (enter para seed): ");
        Cliente c = (nombre.isBlank() || contacto.isBlank())
                ? clientes.unCliente()
                : new Cliente(nombre, contacto);
        Pedido p = new Pedido(c);
        ConsoleIO.hr();
        System.out.println("Pedido creado para: " + c.getNombre());
    }
}
