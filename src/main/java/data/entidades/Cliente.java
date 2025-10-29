package data.entidades;

import data.interfaces.Notificable;

public class Cliente implements Notificable {
    private String nombre;
    private String contacto;

    public Cliente(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    @Override
    public void notificar(String mensaje) {
         System.out.println("[Notificación a " + nombre + " <" + contacto + ">] " + mensaje);
    }
}
