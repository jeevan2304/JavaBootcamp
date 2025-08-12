package advancedjava;

public class DemoCompositePattern {
    public static void main(String[] args){

        Component hdd = new Leaf(400,"seagate");
        Component mouse = new Leaf(3000,"Mouse");
        Component monitor = new Leaf(5000,"Monitor");
        Component ram = new Leaf(4000,"Ram");
        Component cpu = new Leaf(8000,"Cpu");

        Root peripheral = new Root("peri");
        Root cabinet = new Root("Cabinet");
        Root computer = new Root("Computer");

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
