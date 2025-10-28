package app;

import core.SubMenu;
import core.utils.ContextColor;
import core.utils.UtilsColor;
import features.ExceptionCases;
import features.InterfacesCases;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            SubMenu ejercicio = obtenerEjercicio(opcion);
            if (ejercicio != null) {
                ejercicio.execute();
            } else if (opcion != 0) {
                System.out.println("Opción no válida");
            }
            if (opcion != 0) {
                System.out.println("Presiona Enter para continuar...");
                scanner.nextLine();
            }

        }
        while (opcion != 0);
        System.out.println("Chau!");
        scanner.close();
    }

    private static void mostrarMenu() {
        UtilsColor.imprimirBloque(ContextColor.WARNING,"\n===========================================================");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT,"   Trabajo Práctico 8 - Interfaces y Excepciones");
        UtilsColor.imprimirBloque(ContextColor.WARNING,"===========================================================");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT,"1. Casos de uso Interfaces (eCommerce)");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT,"2. Casos de uso Excepciones ");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT,"0. Salir");
        UtilsColor.imprimirBloque(ContextColor.INFO,"Seleccionae una opcion: ", 'n');
    }

    private static int leerOpcion () {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static SubMenu obtenerEjercicio(int opcion) {
        return switch (opcion) {
            case 1  -> new InterfacesCases("Interfaces");
            case 2  -> new ExceptionCases("Excepciones");
            default -> null;
        };
    }
}
