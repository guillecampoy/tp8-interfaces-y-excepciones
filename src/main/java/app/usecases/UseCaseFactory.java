package app.usecases;

import app.features.ecommerce.*;
import app.features.exceptions.*;
import app.fixtures.CatalogoProductosSeed;
import app.fixtures.ClientesSeed;
import app.data.model.Pedido;

public class UseCaseFactory {
    // Dependencias compartidas mínimas (semillas)
    private final CatalogoProductosSeed catalogo = new CatalogoProductosSeed();
    private final ClientesSeed clientes = new ClientesSeed();

    // Estado simple para demo (un pedido por defecto)
    private final Pedido pedidoDefault = new Pedido(clientes.unCliente());

    public UseCase create(UseCaseId id) {
        switch (id) {
            case ECOM_CREAR_PEDIDO:         return new CU_CrearPedido(clientes);
            case ECOM_AGREGAR_PRODUCTOS:    return new CU_AgregarProductos(pedidoDefault, catalogo);
            case ECOM_PAGAR_PEDIDO:         return new CU_PagarPedido(pedidoDefault);
            case ECOM_AVANZAR_ESTADO:       return new CU_AvanzarEstado(pedidoDefault);
            case ECOM_VER_RESUMEN:          return new CU_VerResumen(pedidoDefault);
            case DEMO_DIAMANTE_PAGOS:       return new CU_DemoDiamantePagos();
            case EXCEP_DIVISION_SEGURA:     return new CU_DivisionSegura();
            case EXCEP_TEXTO_A_NUMERO:      return new CU_TextoANumero();
            case EXCEP_LECTURA_ARCHIVO:     return new CU_LecturaArchivo();
            case EXCEP_PERSONALIZADA:       return new CU_ExcepPersonalizada();
            case EXCEP_TRY_WITH_RESOURCES:  return new CU_TryWhitResources();
            default: throw new IllegalArgumentException("UseCase no soportado: "+id);
        }
    }
}
