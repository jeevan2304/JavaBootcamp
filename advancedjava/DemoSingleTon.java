package advancedjava;
public class DemoSingleTon {
    public static void main(String[] args) {
        instance obj = instance.INSTANCE;
        obj.i = 5;
        obj.show();

        instance obj1 = instance.INSTANCE;
        obj1.i = 5;
        obj1.show();
//singleton
    }
}
//thread problem is also solved using synchronized.


//making the method synchronized and that method has lot of work to do then there may be  problem we can use like double checked locking.