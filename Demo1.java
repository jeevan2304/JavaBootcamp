//functional interface Lambda expressions

@FunctionalInterface
interface A{
    void show();
}

//see by annotating an interface with the functional interface it allows only one method to be inside the interface if i add one more method i will get error
//but if i add methods from object class like toString() then i wont get any error because every class extends the object class itself.

//i need this below class b as it implemnets the interface a because creating an object of the interface is not possible if only a class implements that interface then we can create a object.

//class B implements A{
//    public void show(){
//        System.out.println("Hello");
//    }
//}

//but one more thing is where lambda expression come into picture is:
//creating an extra class like b require extra file/memory so anonymous inner class is being implemented and then,
// A obj = new A(){
//public void show(){
//System.out.Println("Hi");}};
// lambda expression we can reduce to below code
//as functional interface contains only method so we can remove the method here.

public class Demo1 {
    public static void main(String[] args){
        //anonymous inner class
        A obj = ()->
                System.out.println("hi");
        obj.show();

    }
}
