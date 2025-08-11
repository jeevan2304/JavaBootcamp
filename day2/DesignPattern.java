package day2;
public class DesignPattern {
    public static void main(String[] args) {
        abc obj = abc.INSTANCE;
        obj.i = 5;
        obj.show();

        abc obj1 = abc.INSTANCE;
        obj1.i = 5;
        obj1.show();



//singleton
    }
}
enum abc{//special type of class means it has private constructor
    INSTANCE; //public static abc getinstance
    int i ;
    public void show(){
        System.out.println(i);
    }
}
//thread problem is also solved using synchronized.


//making the method synchronized and that method has lot of work to do then there may be  problem we can use like double checked locking.