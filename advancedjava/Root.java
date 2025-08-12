package advancedjava;

import java.util.ArrayList;
import java.util.List;

class Root implements Component {
    String name;

    public Root(String name) {
        super();
        this.name = name;
    }

    List<Component> components = new ArrayList<>();

    public void addComponent(Component com) {
        components.add(com);

    }

    @Override
    public void showPrice() {
        System.out.println(name);
        for (Component c : components) {
            c.showPrice();
        }
    }
}
