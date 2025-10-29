package app.app;

import app.core.menu.MenuRunner;
import app.usecases.UseCaseRegistry;

public class Main {
    public static void main(String[] args) {
        var registry = new UseCaseRegistry();
        var runner = new MenuRunner(registry.buildMenuItems());
        runner.run();
    }
}
