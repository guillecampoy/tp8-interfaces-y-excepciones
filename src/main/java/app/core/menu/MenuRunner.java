package app.core.menu;

import app.core.utils.ConsoleIO;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;

import java.util.List; import java.util.Scanner;
public class MenuRunner {
    private final List<SubMenuAble> items; private final Scanner in = new Scanner(System.in);
    public MenuRunner(List<SubMenuAble> items){ this.items = items; }
    public void run() {
        int opt;
        do {
            UtilsColor.imprimirBloque(ContextColor.SUCCESS, "\n===== Menú TP 8 - Interfaces y Excepciones =====");
            for (int i=0;i<items.size();i++) System.out.printf("%d) %s%n", i+1, items.get(i).nombre());
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, "0) Salir");
            opt = ConsoleIO.readMenuOption(items.size(), true);
            if (opt > 0) {
                try {
                    items.get(opt - 1).ejecutar();
                } catch (Exception ex) {
                    UtilsColor.imprimirBloque(ContextColor.ERROR, "⚠ Ocurrió un error en el caso de uso: " + ex.getMessage());
                }
                ConsoleIO.pause();
            }
        } while (opt != 0);
    }
}
