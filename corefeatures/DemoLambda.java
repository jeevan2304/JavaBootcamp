//functional interface Lambda expressions
//see by annotating an interface with the functional interface it allows only one method to be inside the interface if i add one more method i will get error
//but if i add methods from object class like toString() then i wont get any error because every class extends the object class itself.
//but one more thing is where lambda expression come into picture is:
//creating an extra class like b require extra file/memory so anonymous inner class is being implemented and then,
// A obj = new A(){
//public void show(){
//System.out.Println("Hi");}};
// lambda expression we can reduce to below code
//as functional interface contains only method so we can remove the method here.
//i need this below class b as it implemnets the interface a because creating an object of the interface is not possible if only a class implements that interface then we can create a object.
package corefeatures;

//class B implements A{
//    public void show(){
//        System.out.println("Hello");
//    }
//}

public class DemoLambda {
    public static void main(String[] args){
        //anonymous inner class
        MessageInterface messsage = ()->System.out.println("Hi");
        messsage.show();
    }
}
