package data.entidades;

import data.interfaces.Pagable;

public class Producto implements Pagable {
    private String nombre;
    private double precioUnitario;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precioUnitario = precio;
    }

    @Override
    public double calcularTotal() {
        return precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
