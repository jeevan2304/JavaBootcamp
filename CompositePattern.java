import java.util.ArrayList;
import java.util.List;

interface Component{
    void showPrice();
}

class Leaf implements Component{
    int price;
    String name;
    public Leaf(int price,String name){
        super();
        this.price = price;
        this.name = name;
    }
    @Override
    public void showPrice() {
        System.out.println(name+ ":" +price);

    }
}
class Composite implements Component{
    String name;

    public Composite(String name){
        super();
        this.name = name;
    }
    List<Component> components = new ArrayList<>();

    public void addComponent(Component com){
        components.add(com);

    }

    @Override
    public void showPrice() {
        System.out.println(name);
        for(Component c:components){
            c.showPrice();
        }

    }
}

public class CompositePattern {
    public static void main(String[] args){

        Component hdd = new Leaf(400,"seagate");
        Component mouse = new Leaf(3000,"Mouse");
        Component monitor = new Leaf(5000,"Monitor");
        Component ram = new Leaf(4000,"Ram");
        Component cpu = new Leaf(8000,"Cpu");

        Composite peripheral = new Composite("peri");
        Composite cabinet = new Composite("Cabinet");
        Composite computer = new Composite("Computer");

        peripheral.addComponent(mouse);
        peripheral.addComponent(monitor);
        cabinet.addComponent(hdd);
        cabinet.addComponent(ram);
        cabinet.addComponent(cpu);

        computer.addComponent(peripheral);
        computer.addComponent(cabinet);

        peripheral.showPrice();
        cabinet.showPrice();
        computer.showPrice();



    }
}
