package app.usecases;

import app.core.menu.SubMenuAble;

import java.util.ArrayList;
import java.util.List;

public class UseCaseRegistry {
    private final UseCaseFactory factory = new UseCaseFactory();

    public List<SubMenuAble> buildMenuItems() {
        List<SubMenuAble> items = new ArrayList<>();
        for (UseCaseId id : UseCaseId.values()) {
            UseCase uc = factory.create(id);
            items.add(new SubMenuAble() {
                @Override public String nombre() { return uc.nombre(); }
                @Override public void ejecutar() { uc.run(); }
            });
        }
        return items;
    }
}
