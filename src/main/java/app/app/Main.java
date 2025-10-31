package app.app;

import app.core.menu.MenuRunner;
import app.core.utils.ContextColor;
import app.core.utils.UtilsColor;
import app.usecases.UseCaseRegistry;

public class Main {
    public static void main(String[] args) {
        var registry = new UseCaseRegistry();
        var runner = new MenuRunner(registry.buildMenuItems());
        try {
            runner.run();
        } catch (Throwable t) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "⚠ Error inesperado: "
                    + t.getClass().getSimpleName() + " - " + t.getMessage() );
        }
    }
}
