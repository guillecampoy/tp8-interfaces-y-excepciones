package app.fixtures;

import app.data.model.Producto;

import java.util.Arrays;
import java.util.List;

public class CatalogoProductosSeed {
    public List<Producto> catalogo(){
        return Arrays.asList(
                new Producto("Mouse gamer", 5_000),
                new Producto("Teclado mecánico", 20_000),
                new Producto("Monitor 27\"", 120_000)
        );
    }
}
