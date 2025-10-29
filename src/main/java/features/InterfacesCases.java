package features;

import core.SubMenu;

public class InterfacesCases extends SubMenu {

    public InterfacesCases(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {

    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        return false;
    }
}
