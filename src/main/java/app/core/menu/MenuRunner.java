package app.core.menu;

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
            UtilsColor.imprimirBloque(ContextColor.WARNING, ">", 'n');
            opt = Integer.parseInt(in.nextLine());
            if (opt>0 && opt<=items.size()) items.get(opt-1).ejecutar();
        } while (opt!=0);
    }
}
